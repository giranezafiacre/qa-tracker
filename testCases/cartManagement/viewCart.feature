Feature: View Cart Details
   Customer should have access to askomdch

   Background: 
   Given Customer is on askomdch.com, any tab
   
Scenario: Customer is on any tab of askomdch.com and clicks on the cart icon.
   When Customer clicks directly on the Cart icon in the header.
   Then The system redirects to the Cart page.