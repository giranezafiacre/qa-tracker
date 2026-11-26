Feature: Product Search
    
    - Product search should return relevant results

    Feature Description
      As a Customer I should be able to search for products using keywords and filters.

        
    @negative
    Scenario: Customer to search for a product that doesn't exist in the store
        Given Customer is on the "Home" page, "Store" tab
        When Customer enters a keyword "Top" in the search field
        Then The system should display the message "No products were found matching your selection".
    
    @positive
    Scenario Outline: Customer to search for a product that exist in the store.
       Given Customer in on Customer is on the "Home" page, "Store" tab
       When Customer enters <SearchInputs>
       Then The system should display matching products.

       Examples:
         | SearchInputs        |
         | "blue jeans"        |
         | "Basic Blue Jeans"  |
         | "Anchor Bracelet"   |

    @negative
    Scenario: Customer to view all products when the search field is empty.
        Given Customer has access to "home", "men", "women", "accessories" or "store" page 
        When Custome search field empty.
        Then The system should display all the products and 
        Then The system should display this message Search results: ""