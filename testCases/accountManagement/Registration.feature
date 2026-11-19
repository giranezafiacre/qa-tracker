Feature: Customer Registration
    # user acceptance criteria should be included here as well
    - Username should have atleast 6 characters

    Feature Description
      As a Customer I sho....
    Background: 
        Given Customer is on the "Registration" Page
#   this is like common precondition
#  it is nice to have even common steps which does not have parameters in background section

    Scenario Outline: Customer to Register with valid credentials
#  Given Customer is on the "Registration" Page
        When Customer enters <username>
        When Customer enters <email_address>
        When Customer enters <password>
        When Customer clicks on "REGISTER" button
        Then System should create a new account
        Then System should redirect customer to Dashboard
        Then System should display message as <message>


        Examples:
            | username | email_address      | password      | message                                                                |
            | George123| geordger@gmail.com | 123Jumonkjo!  | Hello george123(not George Log Scenario Outline: Scenario Outline name)|

#  Given->when->then (in any case we can't have "Given" /between "Given" and "then")

    Scenario Outline: Customer to Register with invalid credentials
        # Given Customer is on the "Registration" Page
        When Customer enters <username>
        When Customer enters <email_address>
        When Customer enters <password>
        When Customer clicks on "REGISTER" button
        Then System should display the error message as <error_message>
        Then System should remain in registration page
        But Customer should not be redirected to another page(postcondition)

        Examples:
            | username | email_address | password | error_message
            | George123| geordger@gmail.com | 123Jumonko!  | Invalid username or password|