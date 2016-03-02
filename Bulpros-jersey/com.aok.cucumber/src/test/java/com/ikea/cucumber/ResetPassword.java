package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class ResetPassword {
	Client restClient;
	ClientResponse respUpdate;
	WebResource webResource;
	JSONObject object;
	@Given("^the user wants to reset password$")  
	public void the_user_wants_to_reset_password() throws Throwable { 
		restClient = Client.create();
        webResource = restClient.resource("http://dev15.bulpros.com:85/rest/dwt/user/passwordReset");     
	}
	@When("^the user puts \"(.*?)\" and \"(.*?)\"$")
	public void the_user_puts_and(String token,String newPassword) throws Throwable {			
			respUpdate =webResource.type("application/x-www-form-urlencoded").post(ClientResponse.class,token+"&"+newPassword);
			String outputs = respUpdate.getEntity(String.class);
			this.object = new JSONObject(outputs);
			System.out.println(object.toString());
	}
	@Then("^the new password is activated and \"(.*?)\" is correct$")
	public void the_new_password_is_activated_and_is_correct(String responseCode) throws Throwable {
		Assert.assertEquals(200, object.getJSONObject("status").getInt("code"));
		Assert.assertEquals(responseCode, object.getJSONObject("status").getString("name"));	
	}
}
