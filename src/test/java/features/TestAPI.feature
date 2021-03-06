Feature: Validating GET/POST Requests

  @POST
  Scenario Outline: API Scenario POST
    Given User sets the base URL "<baseURL>"  for API request
    When User sets the header for following values
      | HeaderTag    | Value            |
      | Content-Type | application/json |
    Then User creates the body of request using parameters  "<bodyContentTagAndValue>"
    Then User submits the 'POST' request with end point as - "<endPoint>"
    Then User validates the status code as 201
    And User Prints the response
    And User validatd the body of response for following "<key_value>" pair

    @QA
    Examples:
      | baseURL           | endPoint   | bodyContentTagAndValue | key_value  |
      | https://reqres.in | /api/users | name:Anuj3;job:AQA3    | name:Anuj3 |

    @PreProd
    Examples:
      | baseURL           | endPoint   | bodyContentTagAndValue | key_value  |
      | https://reqres.in | /api/users | name:Anuj4;job:AQA4    | name:Anuj4 |

  @GET @SMOKE
  Scenario Outline: API Scenario GET
    Given User sets the base URL "<baseURL>"  for API request
    When User submits the 'GET' request with end point as - "<endPoint>"
    Then User validates the status code as 200
    And User validatd the body of response for following "<key_value>" pair
    And User Prints the response

    Examples:
      | baseURL                                   | endPoint   | key_value                         |
      | https://demoqa.com/utilities/weather/city | /Hyderabad | City:Hyderabad,Humidity:*Percent* |
      | https://demoqa.com/utilities/weather/city | /Pune      | City:Pune                         |

  @GET @Gmaps
  Scenario Outline: Google Maps Get Request
    Given User sets the base URL "<baseURL>"  for API request
    When User submits the 'GET' request with end point as - "<endPoint>"
    Then User Validates the following header in response
      | HeaderTag        | Value                          |
      | Content-Type     | application/xml; charset=UTF-8 |
      | Content-Encoding | gzip                           |


    Examples:
      | baseURL                     | endPoint                                                                                                                                   |  |
      | https://maps.googleapis.com | /maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s |  |


  @GET @Gmaps
  Scenario Outline: Google Maps Get Request
    Given User sets the base URL "<baseURL>"  for API request
    When User submits the 'GET' request with end point as - "<endPoint>"
    Then User Validates header of response for "<headerTag_Value>"


    @QA
    Examples:
      | baseURL                     | endPoint                                                                                                                                   | headerTag_Value                                                   |
      | https://maps.googleapis.com | /maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s | Content-Type:application/xml; charset=UTF-8,Content-Encoding:gzip |

    @PreProd
    Examples:
      | baseURL                     | endPoint                                                                                                                                   | headerTag_Value                                                   |
      | https://maps.googleapis.com | /maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s | Content-Type:application/xml; charset=UTF-8,Content-Encoding:gzip |