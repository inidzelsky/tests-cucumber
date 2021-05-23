Feature: Foo
  Some Foo desciption, if you want

  Scenario: Create User Project
    Given Configure create user 'rest-assured-test-project' project request
    When Make a create user project request
    Then Check the create user project response

  Scenario: Get User Emails
    When Make a get user emails request
    Then Emails list contains 'andruha@gmail.com'

