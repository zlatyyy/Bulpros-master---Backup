package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeactivateAccount {
	private String auth;
	private String output;
	@Given("^user accounts$")	
	public void user_accounts() throws Throwable {
	}
	@When("^our user logs with \"(.*?)\" and \"(.*?)\"$")
	public void our_user_logs_with_and(String username, String password) throws Throwable {
		Authorization auth=new Authorization();
		this.auth=auth.the_have_to_authenticate_to_REST_services(username, password);
    }
	@When("^the user fills the \"(.*?)\"$")	
	public void the_user_fills_the(String passwords) throws Throwable {
		Client restClient;
		restClient = Client.create();
		ClientResponse resp;
		WebResource webRes;		
        webRes = restClient.resource("http://dev15.bulpros.com:85/rest/dwt/user/delete"+"?lang=en_US&"+passwords+this.auth);
        resp =webRes.accept("application/json").type("application/json").post(ClientResponse.class,"");
		this.output = resp.getEntity(String.class);
	}

	@Then("^the responseCode \"(.*?)\" is correct$")
	public void the_responseCode_is_correct(String responseCode) throws Throwable {
		JSONObject object = new JSONObject(this.output);
		String name=object.getJSONObject("status").getString("name");	
		Assert.assertEquals(responseCode, name);
		}
}
