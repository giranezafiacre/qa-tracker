Feature: Payment Method

    Feature Description: Payment method should be selected before a user places an order
    
        

      Scenario Outline: A user to select payment method
      Given Customer is on the "Checkout" Page
      Given Customer has products in the cart
      When Customer selects <payment_method>
      Then System should display radio button will be selected on <payment_method>
      examples:
            | payment_method         |
            | Direct bank transfer   |
            |  Cash on delivery      |
           

    
     
       
