package APILibrary;

import Utilities.BaseClass;
import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class Swapnil extends BaseClass {
	
	String BaseURL;
	
	public static void setBaseUrl(String BaseURL) 
	{
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = BaseURL;

		

	}
	
	public static void getRequest(String URLExtention, String expectedResponse) 
	
	{
	
		
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "/Hyderabad");

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().prettyPrint();
		System.out.println("Response Body is =>  " + responseBody);

		
		
	}

	public static void setsBaseUrl(String URL)
	{
		RestAssured.baseURI = URL;
		request = RestAssured.given();

	}

	public static void preparesTheHeaderAndAssignsItToRequest(DataTable Header)
	{
		List <Map<String,String>> list = Header.asMaps(String.class,String.class);

		for(Map<String,String> m : list)
		{
			request.header(m.get("HeaderTag"),m.get("Value"));


		}

	}
	public static void preparesTheHeaderAndAssignsItToRequest(String Header)
	{


	}

	public static void preparesTheBodyAndAssignsItToRequest(String body)
	{
		//Crete the body of Post request to be submitted
		JSONObject  jsonObj = new JSONObject();

		String [] bodyKeyValues  = body.split(";");

		for (String bodyKeyValue : bodyKeyValues )
		{
			String [] keyValue = bodyKeyValue.split(":");
			jsonObj.put(keyValue[0], keyValue[1]);
		}

		//Putting the body created in the request
		request.body(jsonObj.toJSONString());


	}

	public static void preparesTheBodyAndAssignsItToRequest(DataTable body)
	{
		JSONObject  jsonObj = new JSONObject();
		List<Map<String,String>> list = body.asMaps(String.class,String.class);
		for (Map m: list)
		{
			jsonObj.put(m.get("BodyTag"),m.get("Value"));
		}
		request.body(jsonObj.toJSONString());

	}



	public static void submitsTheRequestWithEndPointAndCapturesTheResponse(String RequestType, String EndPoint)
	{
		switch(RequestType.toUpperCase() )
		{
			case "POST":
				response = request.request(Method.POST, EndPoint);
				break;  //optional
			case "GET":
				response = request.request(Method.GET, EndPoint);
				break;  //optional
			case "PUT":
				response = request.request(Method.PUT, EndPoint);
				break;  //optional
			case "DELETE":
				response = request.request(Method.DELETE, EndPoint);
				break;  //optional
			default:

		}
	}

	public static void validatesTheResponseCode(int ExpectedResponseCode)
	{
		Assert.assertEquals(ExpectedResponseCode, response.getStatusCode());
	}

	public static void validatesHeaderInResponse(DataTable header)
	{
		List<Map<String, String>> list = header.asMaps(String.class, String.class);

		for (Map<String,String> m : list)
		{
			Assert.assertEquals(m.get("Value"), response.header(m.get("HeaderTag")));
		}
	}
	public static void validatesHeaderInResponse(String header)
	{
		JsonPath jp = response.jsonPath();
		String[] keyValue;
		String[] keyValues = header.split(",");

		for (String x : keyValues)
		{
			keyValue = x.split(":");

			if (keyValue[1].contains("*"))
			{
				keyValue[1] = keyValue[1].replace("*", "");
				String fetchedValue =  response.header(keyValue[0]);
				Assert.assertTrue("Validation Failed - Expected : " + keyValue[1] + "| Actual : " + fetchedValue ,fetchedValue.contains(keyValue[1]) );
			}
			else
			{
				Assert.assertEquals( keyValue[1],response.header(keyValue[0]));
			}
		}
	}

	public static void validatesBody(String bodyParams)
	{
		JsonPath jp = response.jsonPath();
		String[] keyValue;
		String[] keyValues = bodyParams.split(",");

		for (String x : keyValues)
		{
			keyValue = x.split(":");

			if (keyValue[1].contains("*"))
			{
				keyValue[1] = keyValue[1].replace("*", "");
				String fetchedValue = jp.get(keyValue[0]);
				Assert.assertTrue(fetchedValue.contains(keyValue[1]));
			}
			else
			{
				Assert.assertEquals( keyValue[1],jp.get(keyValue[0]));
			}




		}
	}
	public static void validatesBody(DataTable bodyParams)
	{
		JsonPath jp = response.jsonPath();
		List<Map<String,String>> list = bodyParams.asMaps(String.class,String.class);
		for (Map m: list)
		{
			if (m.get("ResponseBodyValues").toString().contains("*"))
			{
				String actualValue = m.get("ResponseBodyValues").toString().replace("*", "");
				String fetchedValue = jp.get(m.get("ResponseBodyTag").toString());
				Assert.assertTrue(fetchedValue.contains(actualValue));
			}
			else
			{
				Assert.assertEquals( m.get("ResponseBodyValues").toString(),jp.get(m.get("ResponseBodyTag").toString()));
			}

		}

	}





}
