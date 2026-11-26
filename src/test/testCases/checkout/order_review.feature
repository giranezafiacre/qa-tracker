Feature: Order review

  -customer should be able to view the details of an order

  Background:
    Given Customer has placed an order
    Given Customer has access to the "Order Review" Page

  @positive
  Scenario Outline: Authenticated customer to review order with its details
    Given Customer is authenticated
    When Customer goes through the order page content
    Then System should display <order_detail>

        
    Examples:
      | order_detail       |
      | order number       |
      | order date         |
      | order total        |
      | payment method     |
      | items on order     |
      | price of each item |
      | items subtotal     |
      | shipping rate      |
      | shipping address   |
      | billing address    |

  @positive
  Scenario Outline: Guest customer to review order with its details
    Given Customer is a guest
    When Customer goes through the order page content
    Then System should display <order_detail>

        
    Examples:
      | order_detail       |
      | order number       |
      | order date         |
      | order total        |
      | payment method     |
      | items on order     |
      | price of each item |
      | items subtotal     |
      | shipping rate      |