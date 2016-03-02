package com.ikea.cucumber;

import org.json.JSONObject;
import org.junit.Assert;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class RegitrationMain {
	private String output;
	private String inputUpdate;
	@Given("^an user enters personal data$")
	public void an_user_personal_data() throws Throwable {
	}
	@When("^an user fills \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")	
	public void an_user_fills(String email,String username, String firstName, String secondName,String gender, String password) throws Throwable {
		this.inputUpdate=
				"{\"userName\":\""+username+"\",\"password\":\""+password+"\",\"firstName\":\""+firstName+"\",\"lastName\":\""+secondName+"\",\"email\":\""+email+"\",\"userData\":{\"gender\":\""+gender+"\"}}";
		Client restClient;
		ClientResponse resp;
		WebResource webRes;
		restClient = Client.create();
        webRes = restClient.resource("http://dev15.bulpros.com:85/rest/dwt/user/register");
        resp =webRes.type("application/json").post(ClientResponse.class,
        		this.inputUpdate);
		this.output = resp.getEntity(String.class);
	}
	@Then("^the code \"(.*?)\" correct$")
	public void the_code_correct(String responseCode) throws Throwable {
		JSONObject object = new JSONObject(this.output);
		String name=object.getJSONObject("status").getString("name");	
		Assert.assertEquals(responseCode, name);
		}
}
