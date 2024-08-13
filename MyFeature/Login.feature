Feature: Login

  Scenario Outline: Valid credentials
    Given The user is not logged in
    When the credentials is valid email is "<Email>" and password is "<Password>"
    Then User logs in successfully

    Examples:
      | Email                      | Password |
      | musabsoftware@gmail.com    | musab    |
      | mohdsoftware@gmail.com     | mohd     |
      | ameedsoftware@gmail.com    | ameed    |

  Scenario Outline: Invalid email
    Given The user is not logged in
    When The email is invalid email is "<Email>" and password is "<Password>"
    Then User failed in log in

    Examples:
      | Email                       | Password |
      | invalidmusab@gmail.com      | musab    |
      | invalidmohd@gmail.com       | mohd     |
      |                             | ameed    |

  Scenario Outline: Invalid password
    Given The user is not logged in
    When The password is invalid email is "<Email>" and password is "<Password>"
    Then User failed in log in

    Examples:
      | Email                       | Password |
      | musabsoftware@gmail.com     | 0000     |
      | mohdsoftware@gmail.com      |          |
      | ameedsoftware@gmail.com     | aaaa     |

  Scenario Outline: Invalid credentials
    Given The user is not logged in
    When The credentials is invalid, email is "<Email>" and password is "<Password>"
    Then User failed in log in

    Examples:
      | Email                       | Password |
      | invalidameed@gmail.com      | b1b1     |
      |                             |          |
