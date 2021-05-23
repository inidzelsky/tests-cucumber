package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import models.Project;
import org.json.simple.JSONObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserProjectSteps {
    private String createUserProjectBody;
    private Response createUserProjectResponse;
    
    @Given("^Configure create user '(.*)' project request$")
    public void configure_create_user_rest_assured_test_project_project_request(String projectName) throws Exception {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("name", projectName);
        createUserProjectBody = jsonBody.toJSONString();
    }

    @When("^Make a create user project request$")
    public void make_a_create_user_project_request() throws Exception {
        createUserProjectResponse = new GithubAPIRequestService().createUserProjectRequest(this.createUserProjectBody);
    }

    @Then("^Check the create user project response$")
    public void check_the_create_user_project_response() throws Exception {
        Project project = createUserProjectResponse.then()
                .statusCode(201)
                .extract()
                .as(Project.class);

        assertThat(project.name, equalTo("rest-assured-test-project"));
    }
}
