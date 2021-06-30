Feature: To Validate Facebook Login Page

  Background: 
    Given User is in Facebook Login Page

  Scenario Outline: To Validate Login using diiferent set of username and password
    When User to enter "<username>" and "<password>"
    And User to Click the Login button
    Then User should be in invalid credential Page

    Examples: 
      | username          | password  |
      | qelock@gmail.com  | jjkkkkkll |
      | illsalo@gmail.com | mkkkkk    |
      | helloho@gmail.com | fsdafkask |
      | gracsql@gmail.com | jkkkkkl   |

  Scenario: To Validate Login without username and password
    When User to Click the Login button
    Then User should be in invalid credential Page
