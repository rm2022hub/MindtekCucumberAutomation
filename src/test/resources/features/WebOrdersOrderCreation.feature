@regression @smoke @ui
Feature: Validating order creation functionalities

# Scenario Outline and the Examples table always goes hand in hand.
  @RTB-4
  Scenario Outline: validating order calculation functionality
    Given user navigates to "WebOrders" application
    When user enters username "Tester" and password "test" and clicks on login button
    And user clicks on Order module
    And  user selects "<product>" with <quantity>
    Then user validates total is calculated properly for <quantity>

    Examples:
      | product     | quantity |
      | MyMoney     | 10       |
      | FamilyAlbum | 55       |
      | ScreenSaver | 3        |

