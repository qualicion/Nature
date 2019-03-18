@register

Feature: validate Wiki Search and Language

  Scenario Outline: Validate user registration
    Given I am on nature home page
    When  I navigate to the registration page
    Then I should be able to register with my "<firstName>" "<lastName>" "<email>" "<password>"
    And I should get a confirmation message

    Examples:
      | firstName | lastName   | email                     | password     |
      | James     | Bach       | qualicion+09@outlook.com  | speednature12|
      | Milton    | Erickson   | qualicion+10@outlook.com  | speedlight12 |
      | Elizabeth | Hendrickson| qualicion+11@outlook.com  | speednature12|
      | Michael   | Bolton     | qualicion+12@outlook.com  | speedlight12 |