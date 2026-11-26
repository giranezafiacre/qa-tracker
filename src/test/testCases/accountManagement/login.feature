Feature: Login

    -system should accept valid credentials and reject invalid credentials on login

    Background:
        Given Customer already exists in system

    @negative
    Scenario Outline: System to reject login with invalid credentials
        Given Customer has access to the Login Page
        When Customer enters username or email "<username_or_email>"
        When Customer enters password "<password>"
        When Customer clicks on "LOG IN" button
        Then System should display "<username_or_email>" in the username input field
        Then System should display the password in dots
        Then System should provide the error message "<error_message>"
        Then System should stay on the same page

        Examples:
            | username_or_email         | password      | error_message                                                                                                                 |
            |                           | Christian@123 | Error: Username is required.                                                                                                  |
            | chris                     | Christian@123 | Error: The username chris is not registered on this site. If you are unsure of your username, try your email address instead. |
            | fiacregiraneza1@gmail.com | njmk          | Error: The password you entered for the email address fiacregiraneza1@gmail.com is incorrect. Lost your password?             |

    @positive
    Scenario Outline: System to accept a successful login using username or email
        Given Customer is signed out
        When Customer opens the "Login" Page
        Then System should display the login form
        When Customer enters username or email "<identifier>"
        When Customer enters password "<password>"
        Then System should display "<identifier>" in the username input field
        Then System should display the password in dots
        When Customer clicks on "LOG IN" button
        Then System should log the customer in successfully
        Then System should display the account dashboard

        # Given -> When -> Then
        Examples:
            | identifier    | password |
            | test123       | test123  |
            | test@test.com | test123  |
