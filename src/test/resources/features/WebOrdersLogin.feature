Feature: WebOrders application login feature

  Scenario: validating login feature with valid credentials
   Given user navigates to "WebOrders" application
    When user enters username "Tester" and password "test" and clicks on login button
    Then user validates application is logged in

    Scenario: validating login feature with invalid credentials
      Given user navigates to "WebOrders" application
      When user enters username "invalid" and password "invalid" and clicks on login button
      Then user validates an error message "Invalid Login or Password."
