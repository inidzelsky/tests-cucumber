package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.response.Response;
import models.Email;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class GetUserEmailsSteps {
    private Response getUserEmailsResponse;
    @When("Make a get user emails request")
    public void make_a_get_user_emails_request() throws Exception {
        getUserEmailsResponse = new GithubAPIRequestService().getUserEmails();
    }

    @Then("^Emails list contains '(.*)'$")
    public void emails_list_contains(String email) throws Exception {
        Email[] emails = getUserEmailsResponse
                .then()
                .statusCode(200)
                .extract()
                .as(Email[].class);

        assertThat(emails[0].email, equalTo(email));
    }
}
