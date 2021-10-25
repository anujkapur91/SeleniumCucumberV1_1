package stepDefinations;


import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;


public class stepDefinationsAPI
{
	RequestSpecification request;
	Response response;

	@Given("User sets the base URL {string}  for API request")
	public void user_sets_the_base_url_for_api_request(String baseURL) {
		RestAssured.baseURI = baseURL;
		request = RestAssured.given();


	}

	@When("User submits the GET request with end point as {string}")
	public void user_submits_the_get_request_with_end_point_as(String endPoint) {
		response = request.request(Method.GET, endPoint);
	}

	@Then("User validates the status code as {int}")
	public void user_validates_the_status_code_as(int statusCode) 
	{
		Assert.assertEquals(statusCode, response.getStatusCode());
//		System.out.println(response.prettyPrint());
	}

	@Then("User validatd the body of response for following {string} pair")
	public void user_validatd_the_body_of_response_for_following_pair(String key_values) {
		JsonPath jp = response.jsonPath();
		String[] keyValue;
		String[] keyValues = key_values.split(",");

		for (String x : keyValues)
		{
			keyValue = x.split(":");
			
			if (keyValue[1].contains(".*")) 
			{
				keyValue[1] = keyValue[1].replace(".*", "");
				String fetchedValue = jp.get(keyValue[0]);
				Assert.assertTrue(fetchedValue.contains(keyValue[1]));
			}
			else
			{
				Assert.assertEquals( keyValue[1],jp.get(keyValue[0]));	
			}
			
			
			

		}



	}

	@When("User sets the {string} in header as {string}")
	public void user_sets_the_in_header_as(String Key, String Value) {

		request.header(Key,Value);

	}


	@Then("User creates the body of request using parameters  {string}")
	public void user_creates_the_body_of_request_using_parameters(String strBody) {
		//Crete the body of Post request to be submitted
		JSONObject jsonObj = new JSONObject();

		String [] bodyKeyValues  = strBody.split(";");

		for (String bodyKeyValue : bodyKeyValues )
		{
			String [] keyValue = bodyKeyValue.split(":");
			jsonObj.put(keyValue[0], keyValue[1]);
		}

		//Putting the body created in the request
		request.body(jsonObj.toJSONString());


	}

	@Then("User submits the {string} request with end point as - {string}")
	public void u_ser_submits_the_post_request_with_end_point_as(String requestType, String endPoint) {

		switch(requestType.toUpperCase() ){
			case "POST":
				response = request.request(Method.POST, endPoint);
				break;  //optional
			case "GET":
				response = request.request(Method.GET, endPoint);
				break;  //optional
			default:

		}

	}

	@Then("User validates the body of response for {string} Key Value pair")
	public void user_validates_the_body_of_response_for_key_value_pair(String key_values) {

		System.out.println(response.getBody().prettyPrint());

		JsonPath jp = response.jsonPath();
		String[] keyValue;
		String[] keyValues = key_values.split(",");

		for (String x : keyValues)
		{
			keyValue = x.split(":");

			if (keyValue[1].contains(".*"))
			{
				keyValue[1] = keyValue[1].replace(".*", "");
				String fetchedValue = jp.get(keyValue[0]);
				Assert.assertTrue(fetchedValue.contains(keyValue[1]));
			}
			else
			{
				Assert.assertEquals( keyValue[1],jp.get(keyValue[0]));
			}




		}
	}

	@Then("User Prints the response")
	public void user_prints_the_response() {

		System.out.println(response.getBody().prettyPrint());

	}

	@Then("User Validates header of response for {string}")
	public void user_validates_header_of_response_for(String headerTag_Value) {


		JsonPath jp = response.jsonPath();
		String[] keyValue;
		String[] keyValues = headerTag_Value.split(",");

		for (String x : keyValues)
		{
			keyValue = x.split(":");

			if (keyValue[1].contains(".*"))
			{
				keyValue[1] = keyValue[1].replace(".*", "");
				String fetchedValue =  response.header(keyValue[0]);
				Assert.assertTrue("Validation Failed - Expected : " + keyValue[1] + "| Actual : " + fetchedValue ,fetchedValue.contains(keyValue[1]) );
			}
			else
			{
				Assert.assertEquals( keyValue[1],response.header(keyValue[0]));
			}




		}


	}

	@Then("User Validates the following header in response")
	public void user_validates_the_following_header_in_response(io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> list = dataTable.asMaps(String.class,String.class);

		for(int i =0;i<list.size(); i++ )
		{
			Assert.assertEquals(list.get(i).get("Value"),response.header(list.get(i).get("HeaderTag")));
		}


	}



}
