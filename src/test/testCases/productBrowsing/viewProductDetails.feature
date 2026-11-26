Feature: View Product Details
    As a customer,
    I want to click on any item 
    So that I can view each product's details and submit reviews.

    - The system should display product details including name, price, category, details, additional information, and reviews on a separate product page.
    
    @positive
    Scenario Outline: Customer to view Product Details
        Given Customer is on the "product detail" Page
        When Customer clicked on <page> of product category
        And Customer click on product <product>
        Then System should redirect to selected <page> product category page
        And System should display products in <page> category
        And System should redirect <product> detail page
        
        
        Examples:
            | page       | product              |
            | men        | Basic blue jeans     |
            | women      | Anchor Bracelet      |
            | accessories| Boho Bangle Bracelet |
            | store      | Blue Tshirt          |

    
    

