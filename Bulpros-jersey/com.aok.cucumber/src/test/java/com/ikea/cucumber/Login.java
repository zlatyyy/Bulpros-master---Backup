package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Login{
	Client restClient;
	ClientResponse respUpdate;
	WebResource webResource;
	JSONObject object;
	@Given("^the user wants to login$")  
	public void the_user_wants_to_login() throws Throwable { 
		restClient = Client.create();
        webResource = restClient.resource("http://dev15.bulpros.com:85/rest/dwt/user/login");     
	}
	@When("^the user logs in using \"(.*?)\" and \"(.*?)\"$")
	public void the_user_logs_in_using_and(String username, String password) throws Throwable {			
			respUpdate =webResource.type("application/x-www-form-urlencoded").post(ClientResponse.class,username+"&"+password);
			String outputs = respUpdate.getEntity(String.class);
			this.object = new JSONObject(outputs);
			System.out.println(object.toString());
	}
	@Then("^the user should be logged and \"(.*?)\" should be correct$")
	public void the_user_should_be_logged_and_should_be_correct(String responseCode) throws Throwable {
		Assert.assertEquals(responseCode, object.getJSONObject("status").getString("name"));
		Assert.assertTrue(object.has("data"));
		Assert.assertTrue(object.getJSONObject("data").has("alf_ticket"));
		Assert.assertTrue(object.getJSONObject("data").has("kk_session_id"));		
	}	
}