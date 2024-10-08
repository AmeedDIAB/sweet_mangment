Feature:  Sign up

  Scenario:Signing up with an incorrect email format
    Given The user is not logged in
    When the email format is incorrect
    Then Signing up fails

  Scenario Outline:Signing up with an already existing email
    Given The user is not logged in
    When The provided credentials exists, the email is "<Email>"
    Then Signing up fails

    Examples:
      | Email                       |
      | musabsoftware@gmail.com     |
      | mohdsoftware@gmail.com      |
      | ameedsoftware@gmail.com     |

  Scenario Outline:Signing up with new email account
    Given The user is not logged in
    When The provided credentials exists, the email is not "<Email>"
    Then Signing up succeeds

    Examples:
      | Email                      |
      | invalidmusab@gmail.com     |
      | invalidmohd@gmail.com      |
      | invalidameed@gmail.com     |