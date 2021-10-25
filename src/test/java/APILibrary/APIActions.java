package APILibrary;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIActions {
	
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

}
