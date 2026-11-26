Feature: Fill in valid alternative shipping address

    Feature Description: The system should allow an authenticated customer to checkout with alternative shipping address

    background: 
        Given Customer is on the "Checkout" Page
        Given user should have atleast one items in cart
        Given the check button should have to be checked
        Given the information of billing details should be filled in
        
    @positive
    Scenario Outline: Customer to fill in valid alternative Shipping Address
        When Customer enters <firstName> 
        When Customer enters <lastName>
        When Customer enters <CompanyName> 
        When Customer enters <Country>
        When Customer enters <StreetNumber> 
        When Customer enters <City> 
        When Customer enters <EmailAddress> 
        When Customer enters <Zip> 
        When Customer clicks on "Place Order" button
        Then Customer the system display <firstName>in the input field
        Then Customer the system display <lastName> in the input field
        Then Customer the system display <CompanyName> in the input field
        Then Customer the system display <Country> in the input field
        Then Customer the system display <StreetNumber> in the input field
        Then Customer the system display <City> in the input field
        Then Customer the system display <EmailAddress> in the input field
        Then Customer the system display <Zip> in the input field
        Then System redirect to order detail page
        
        Examples:
            | firstName | lastName | CompanyName   | Country | StreetNumber | City       | EmailAddress        | Zip           |
            | John      | Doe      | Test Solution | USA     | US 12 st     | Califonia  |johnDoe@sale.com     | 345 California|
            | James     | Dumpton  | Test Solution | Canada  | CA 100 Ave   | Toronto    |jamesDumpton@sale.com| M5V 3L9       |

      Scenario Outline: Customer to fill in invalid alternative Shipping Address
        Given Customer is on the "Checkout" Page
        Given user should have atleast one items in cart
        Given the check button should have to be checked
        When Customer enters <firstName> 
        When Customer enters <lastName>
        When Customer enters <CompanyName> 
        When Customer enters <Country>
        When Customer enters <StreetNumber> 
        When Customer enters <City> 
        When Customer enters <EmailAddress> 
        When Customer enters <Zip> 
        When Customer clicks on "Place Order" button
        Then Customer the system display <firstName>in the input field
        Then Customer the system display <lastName> in the input field
        Then Customer the system display <CompanyName> in the input field
        Then Customer the system display <Country> in the input field
        Then Customer the system display <StreetNumber> in the input field
        Then Customer the system display <City> in the input field
        Then Customer the system display <EmailAddress> in the input field
        Then Customer the system display <Zip> in the input field
        Then System display error message of "Error message" 

        Examples:
          | firstName | lastName | CompanyName   | Country | StreetNumber | City       | EmailAddress    | Zip          |error_message                          |
          |           | Doe      | Test Solution | USA     | US 12 st     | Califonia  |johnDoe@sale.com |345 California|Shipping First name is a required field|
          |james      |          | Test Solution | Canada  | CA 100 Ave   | Toronto    |jamesDum@sold.com|M5V 3L9       |Shipping First name is a required field|
        