Feature: Login


@test
Scenario: Login is successfully done
     Given I am on the Login page
     When User logins to portal
     |username|user@phptravels.com|
     |password|demouser|
     Then Verify whether the User profile is Corrects