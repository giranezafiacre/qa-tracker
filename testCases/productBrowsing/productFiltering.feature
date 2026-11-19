Feature: Product Filtering
    As a customer,
    I want to filter product by price, or category
    So that I can view products which match filtering

    @positive @showcase
    Scenario Outline: Customer to filtering by price
       Given having access to the store, men, women, and accessories page.
       When customer Click on SLIDER BAR to set minimum price to <MinimumPrice>
       When customer Click on slider bar to set Maximum price to <MaximumPrice>
       When customer click on "FILTER" Button
       Then the system should display the minimum <MinimumPrice> price under the slider bar ranges
       Then the system should display the maximum <MaximumPrice> price under the slider bar ranges
       Then the system should display those results price ranges between <MinimumPrice> and <MaximumPrice>
       Then the system should display message <results_message> in top of product list


    Examples:        
        | MinimumPrice | MaximumPrice | results_message                                |
        | $20          | $40          | Showing all 6 result                           |
        | $60          | $70          | No products were found matching your selection.|
        | $20          | $110         | Showing 1-8 of 11 results                      |
        | $90          | $110         | Showing all 2 results                          |










