@regression @ui
  Feature: Validating Etsy titles

    @RTB-3
    Scenario Outline: Validating Etsy separate category titles
      Given  user navigates to "Etsy" application
      When user clicks on "<Section>" section
      Then user validates the title is "<Title>" and the header is "<Header>"

      Examples:
        | Section               | Title                                | Header                 |
        | Jewelry & Accessories | Jewelry & Accessories - Etsy         | Jewelry & Accessories  |
        | Clothing & Shoes      | Clothing & Shoes - Etsy              | Clothing & Shoes       |
        | Home & Living         | Home & Living - Etsy                 | Home & Living          |
        | Wedding & Party       | Wedding & Party - Etsy               | Wedding & Party        |
        | Toys & Entertainment  | Toys & Entertainment - Etsy          | Toys & Entertainment   |
        | Art & Collectibles    | Art & Collectibles - Etsy            | Art & Collectibles     |
        | Craft Supplies        | Craft Supplies & Tools - Etsy        | Craft Supplies & Tools |
        | Gifts & Gift Cards    | The Etsy Gift Guide for 2022 \| Etsy | The Etsy Gift Guide    |

# Scenario Outline runs once for each row in the Examples Table.
# Use Example Table where ENTIRE scenario needs to be tested with different/multiple test data.
# use datatable -> set of data for a single step.