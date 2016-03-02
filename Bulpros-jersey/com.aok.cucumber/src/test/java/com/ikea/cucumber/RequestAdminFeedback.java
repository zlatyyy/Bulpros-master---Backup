package com.ikea.cucumber;

import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class RequestAdminFeedback {
	String output;
	String auth;
	JSONObject object;
	@When("^an user authenticates with \"(.*?)\" and \"(.*?)\"$")
	public void an_user_authenticates_with_and(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
	}
	@And("^send request with \"(.*?)\" by some of \"(.*?)\"$")
	public void send_request_with_by_some_of(String contact, String contact_method) throws Throwable {
		ClientConfig config = new DefaultClientConfig();
		Client client;
		client = Client.create(config);
		ClientResponse resp;
		WebResource webRes;
		webRes = client
				.resource("http://dev15.bulpros.com:85/rest/dwt/user/requestAdminFeedback" + "?lang=en_US" + this.auth)
				.queryParam("contact_method", contact_method).queryParam("contact", contact);
		resp = webRes.post(ClientResponse.class, "");
		this.output = resp.getEntity(String.class);
	}

	@Then("^the connection is successfully$")
	public void the_connection_is_successfully() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		String description = object.getJSONObject("status").getString("description");
		int code = object.getJSONObject("status").getInt("code");
		Assert.assertEquals(200, code);
		Assert.assertEquals("DWT-USR-SCS-008", name);
		Assert.assertEquals("Message has been sent.", description);
	}
}
