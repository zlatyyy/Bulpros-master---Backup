package com.ikea.cucumber;

import java.io.File;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ActivateUser {
	String auth;
	String output;
	File readSourceFile = null;
	File destinationFileLocation = null;
	ClientResponse resp;
	JSONObject object;
	@When("^the user send \"(.*?)\" and \"(.*?)\" to confirm registration$")
	public void the_user_send_and_to_confirm_registration(String username, String activationHash) throws Throwable {
		ClientConfig config = new DefaultClientConfig();
		Client client;
		client = Client.create(config);
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/activate").queryParam("userName",username).queryParam("activationHash",activationHash);
		resp = webRes.post(ClientResponse.class,"");
		this.output = resp.getEntity(String.class);
	}
	@Then("^the activation is successful$")
	public void the_activation_is_successful() throws Throwable {
		this.object = new JSONObject(output);
			Assert.assertEquals(200, resp.getStatus());
			Assert.assertEquals("DWT-ACT-SCS-001", object.getJSONObject("status").getString("name"));
			Assert.assertEquals("User activation succeeded.", object.getJSONObject("status").getString("description"));
	}
}
