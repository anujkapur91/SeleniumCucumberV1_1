Feature: Test ToolsSQA Page with POM

  Scenario Outline: Login in and navigate
    Given User Opens Browser and Navigates to DemoQA
    Then User validates the Page Title of DemoQA Page
    Then User clicks on Elements link on DemoQA Page
    Then User validates the Page Title of Elements Page
    Then Use clicks on ToolSQA Banner
    Then User validates the Page Title of ToolSQAPage
#    Then User closes browser

    Examples:
      | Browser | Product | Model |
      |         |         |       |


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