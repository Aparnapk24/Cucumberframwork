Feature: Login Page

Scenario: Login should be successful
    Given User luanch chrome browser    
    When User give the URL "https://facbook.com/"
    And User enters the username as "Praphull" and password as a "123"
    And User click on login button
    Then User should not able to login
    


