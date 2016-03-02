package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class DisableUser {
	String auth;
	String output;
	String id;
	JSONObject object;
	@When("^the user enters \"(.*?)\" and \"(.*?)\" and send request$")
	public void the_user_enters_and_and_send_request(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/disable" + "?lang=en_US"  + this.auth);
		resp = webRes.post(ClientResponse.class,"");
		this.output = resp.getEntity(String.class);
	}
	@Then("^the user is disable$")
	public void the_user_is_disable() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		int code = object.getJSONObject("status").getInt("code");
		Assert.assertEquals(200, code);
		Assert.assertEquals("SCS", name);
	}
}
