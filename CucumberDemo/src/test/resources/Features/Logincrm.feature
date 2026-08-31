Feature: User Login



  Scenario: Successful login with valid credentials
   
    When the user enters a valid username "<username>"
    And the user enters a valid password "<password>"
    And the user clicks the Login button
    Then the user should be redirected to the homepage
    
    Examples:
         |username|password|
         |mosampatel175@gmail.com|Mosam_123 |


  Scenario: Failed login with invalid credentials
    When the user enters an invalid username "<username>"
    And the user enters an invalid password "<password>"
    And the user clicks the Login button1
    Then the user should see an error message 

    Examples:

      | username              |password|
      |mosampatel175@gmail.com|Mosam|
