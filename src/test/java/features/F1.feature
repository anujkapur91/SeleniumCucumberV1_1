Feature: Login to Amazon two
#
#  Scenario Outline: Login With Correct Credentials 1
#    Given User Opens Amazon India
#    When User Navigates to Login Link
#    Then User logins with Username  and Password
#      | Username              | Password  |
#      | anujkapur91@gmail.com | Rockye08$ |
#      | anujkapur19@gmail.com | Rockye08$ |
#    Then User types "<Product>" "<Model>" name and searches and selects the first listing
#    Then User goes to cart and removes the product
#    Then User Logs Out
#    Then User closes Browser
#
#    Examples: 
#      | Browser | Product | Model  |
#      | FireFox | OnePlus | 7T     |
#      | Chrome  | OnePlus | 7t pro |

#@POST @SMOKE
#Scenario Outline: API Scenario POST
#  Given User sets the base URL "<baseURL>"  for API request
#  When User sets the "Content-Type" in header as "application/json"
#  Then User creates the body of request using parameters  "<bodyContentTagAndValue>"
#  Then User submits the 'POST' request with end point as - "<endPoint>"
#  Then User validates the status code as 201
#  And User Prints the response
#  And User validatd the body of response for following "<key_value>" pair
#
#  @QA
#  Examples:
#    | baseURL           | endPoint   | headerParam_Value              | bodyContentTagAndValue | key_value  |
#    | https://reqres.in | /api/users | Content Type: Application/json | name:Anuj2;job:AQA2    | name:Anuj2 |
#
#  @PreProd
#  Examples:
#    | baseURL           | endPoint   | headerParam_Value              | bodyContentTagAndValue | key_value  |
#    | https://reqres.in | /api/users | Content Type: Application/json | name:Anuj2;job:AQA2    | name:Anuj2 |