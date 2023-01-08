@regression @ui

Feature: Pizza application order functionality
  @RTB-5
  Scenario: Validating successful order
    Given user navigates to "PizzaApp" application
    When user creates pizza order with data
      | Pizza    | Small 6 Slices - no toppings |
      | Topping1 | Mushrooms                    |
      | Topping2 | Extra cheese                 |
      | Quantity | 1                            |
      | Name     | Patel Harsh                  |
      | Email    | patel@gmail.com              |
      | Phone    | 123456789                    |
      | Payment  | Cash on Pickup               |

    Then user validates order is created with message "Thank you for your order! TOTAL: 6.75 Small 6 Slices - no toppings"

