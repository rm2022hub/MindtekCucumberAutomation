@regression @ui

Feature: Pizza application order functionality

  @RTB-5
  Scenario Outline: Validating successful place order
    Given user navigates to "PizzaApp" application
    When user creates pizza order with data
      | Pizza    | <Pizza>    |
      | Topping1 | <Topping1> |
      | Topping2 | <Topping2> |
      | Quantity | <Quantity> |
      | Name     | <Name>     |
      | Email    | <Email>    |
      | Phone    | <Phone>    |
      | Payment  | <Payment>  |
    Then user validates that order is created with message "Thank you for your order! TOTAL: " "<Quantity>" "<Pizza>"

    Examples:
      | Pizza                        | Topping1  | Topping2     | Quantity | Name        | Email           | Phone     | Payment        |
      | Small 6 Slices - no toppings | Mushrooms | Extra cheese | 1        | Patel Harsh | patel@gmail.com | 123456789 | Cash on Pickup |
      | Large 10 Slices - 2 toppings | Mushrooms | Extra cheese | 3        | John Doe    | john@gmail.com  | 123456789 | Credit Card    |
      | Medium 8 Slices - 2 toppings | Olives    | Salami       | 2        | Kim Yan     | kim@gmail.com   | 123456789 | Cash on Pickup |



# Use Data table where test data is Explicitly meant for specific steps or one step and
# user would like to interpret based on use case internally.
# can use when multiple inputs are needed eg: filling up pizza order form, registration form etc..
# No scenario Outline is needed for data table and can convert data table in steps class to a map or list.
# Use Example Table where ENTIRE scenario needs to be tested with different/multiple test data. Scenario Outline is needed.
# to go to step definition press Ctrl first then hover over the feature step and then click on it to go to that step in steps class.