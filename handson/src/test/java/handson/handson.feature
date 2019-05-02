
@Productscenario
Feature:End to End Scenario for Testmeapp

Background:Login with valid credentials
Given user in the home page
When user enter username and password and click Login
  |username|password|
  |lalitha|password123|
Then user should be logged in and verified

@AddtoCartandPaymentprocess

Scenario:Successful Checkout
Given user navigate to all categories, electronics and head phone
And add product into shopping cart
When proceed to checkout
And select bank and credentials
|username|password|
|123456|Pass@456|
Then redirected to the thank you page