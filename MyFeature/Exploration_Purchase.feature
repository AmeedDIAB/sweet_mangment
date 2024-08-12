Feature: Exploration and Purchase

  Scenario: Browsing dessert recipes
    Given The user is on the dessert recipe page
    When The user is browsing through the available dessert recipes
    Then The user should see a list of dessert recipes

  Scenario Outline: Searching for a specific dessert recipe
    Given The user is on the dessert recipe page
    When The user searches for a recipe using the keyword "<Keyword>"
    Then The user should see a list of recipes that match the keyword "<Keyword>"

    Examples:
      | Keyword   |
      | Chocolate |
      | Cake      |
      | Cockies   |

  Scenario Outline: Filtering recipes based on dietary needs or food allergies
    Given The user is on the dessert recipe page
    When The user applies a filter for "<DietaryNeed>"
    Then The user should see a list of recipes that match the filter "<DietaryNeed>"

    Examples:
      | DietaryNeed   |
      | Nut-Free      |
      | Dairy-Free    |
      | Gluten-Free    |

  Scenario: Purchasing desserts directly from store owners
    Given The user is viewing a dessert recipe
    When The user choses "Purchase" choice for the selected dessert
    Then The user should be redirected to the store owner's purchase page
    And The user should see purchase page that contains options to select quantity and delivery details and "Confirm Purchase" choice
