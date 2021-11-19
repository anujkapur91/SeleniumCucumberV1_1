package stepDefinations;
import APILibrary.Swapnil;
import Utilities.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class stepDefinationsAPI extends BaseClass
{
	public stepDefinationsAPI()
	{
	}

//	RequestSpecification request;
//	Response response;

	@Given("User sets the base URL {string}  for API request")
	public void user_sets_the_base_url_for_api_request(String baseURL)
	{
		Swapnil.setsBaseUrl(baseURL);
	}

	@When("User submits the GET request with end point as {string}")
	public void user_submits_the_get_request_with_end_point_as(String endPoint)
	{
		Swapnil.submitsTheRequestWithEndPointAndCapturesTheResponse("GET", endPoint);
	}

	@Then("User validates the status code as {int}")
	public void user_validates_the_status_code_as(int statusCode)
	{
		Swapnil.validatesTheResponseCode(statusCode);
	}

	@Then("User validatd the body of response for following {string} pair")
	public void user_validatd_the_body_of_response_for_following_pair(String key_values)
	{
//
		Swapnil.validatesBody(key_values);
	}



	@When("User sets the header for following values")
	public void user_sets_the_header_for_following_values(io.cucumber.datatable.DataTable dataTable)
	{
//		List <Map<String,String>> list = dataTable.asMaps(String.class,String.class);
//
//		for(Map<String,String> m : list)
//		{
//			request.header(m.get("HeaderParam"),m.get("Value"));
//
//
//		}
		Swapnil.preparesTheHeaderAndAssignsItToRequest(dataTable);

	}

	@Then("User creates the body of request using parameters  {string}")
	public void user_creates_the_body_of_request_using_parameters(String strBody)
	{
//		//Crete the body of Post request to be submitted
//		JSONObject  jsonObj = new JSONObject();
//
//		String [] bodyKeyValues  = strBody.split(";");
//
//		for (String bodyKeyValue : bodyKeyValues )
//		{
//			String [] keyValue = bodyKeyValue.split(":");
//			jsonObj.put(keyValue[0], keyValue[1]);
//		}
//
//		//Putting the body created in the request
//		request.body(jsonObj.toJSONString());
		Swapnil.preparesTheBodyAndAssignsItToRequest(strBody);

	}

	@Then("User submits the {string} request with end point as - {string}")
	public void u_ser_submits_the_post_request_with_end_point_as(String requestType, String endPoint)
	{

//		switch(requestType.toUpperCase() )
//		{
//			case "POST":
//				response = request.request(Method.POST, endPoint);
//				break;  //optional
//			case "GET":
//				response = request.request(Method.GET, endPoint);
//				break;  //optional
//			case "PUT":
//				response = request.request(Method.PUT, endPoint);
//				break;  //optional
//			case "DELETE":
//				response = request.request(Method.DELETE, endPoint);
//				break;  //optional
//			default:
//
//		}
		Swapnil.submitsTheRequestWithEndPointAndCapturesTheResponse( requestType ,endPoint );
	}

	@Then("User validates the body of response for {string} Key Value pair")
	public void user_validates_the_body_of_response_for_key_value_pair(String key_values)
	{

//		System.out.println(response.getBody().prettyPrint());

//		JsonPath jp = response.jsonPath();
//		String[] keyValue;
//		String[] keyValues = key_values.split(",");
//
//		for (String x : keyValues)
//		{
//			keyValue = x.split(":");
//
//			if (keyValue[1].contains(".*"))
//			{
//				keyValue[1] = keyValue[1].replace(".*", "");
//				String fetchedValue = jp.get(keyValue[0]);
//				Assert.assertTrue(fetchedValue.contains(keyValue[1]));
//			}
//			else
//			{
//				Assert.assertEquals( keyValue[1],jp.get(keyValue[0]));
//			}
//
//
//
//
//		}

		Swapnil.validatesBody(key_values);
	}

	@Then("User Prints the response")
	public void user_prints_the_response()
	{

		System.out.println(response.getBody().prettyPrint());

	}

	@Then("User Validates header of response for {string}")
	public void user_validates_header_of_response_for(String headerTag_Value)
	{


//		JsonPath jp = response.jsonPath();
//		String[] keyValue;
//		String[] keyValues = headerTag_Value.split(",");
//
//		for (String x : keyValues)
//		{
//			keyValue = x.split(":");
//
//			if (keyValue[1].contains(".*"))
//			{
//				keyValue[1] = keyValue[1].replace(".*", "");
//				String fetchedValue =  response.header(keyValue[0]);
//				Assert.assertTrue("Validation Failed - Expected : " + keyValue[1] + "| Actual : " + fetchedValue ,fetchedValue.contains(keyValue[1]) );
//			}
//			else
//			{
//				Assert.assertEquals( keyValue[1],response.header(keyValue[0]));
//			}
//		}
		Swapnil.validatesHeaderInResponse(headerTag_Value);


	}

	@Then("User Validates the following header in response")
	public void user_validates_the_following_header_in_response(io.cucumber.datatable.DataTable dataTable)
	{

//		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
//
//		for (Map<String,String> m : list)
//		{
//			Assert.assertEquals(m.get("Value"), response.header(m.get("HeaderTag")));
//		}
		Swapnil.validatesHeaderInResponse(dataTable);
	}


	}




