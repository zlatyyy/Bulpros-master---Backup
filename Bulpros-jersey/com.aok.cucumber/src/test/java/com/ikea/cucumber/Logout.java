package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class Logout {
	String auth;
	String output;
	String id;
	String group;
	String tagLabel;
	JSONObject object;
	@Given("^an user$")
	public void an_user()throws Throwable {
	}
	@When("^this user logs with \"(.*?)\" and \"(.*?)\"$")
	public void this_user_logs_with_and(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/logout"+"?lang=en_US"+this.auth);
		resp = webRes.accept("application/json").get(ClientResponse.class);
		this.output = resp.getEntity(String.class);
	}
	@Then("the logout is successfully$")
	public void the_logout_is_successfully() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		int code = object.getJSONObject("status").getInt("code");
		String description = object.getJSONObject("status").getString("description");
		Assert.assertEquals("Logout successful.", description);
		Assert.assertEquals(200, code);
		Assert.assertEquals("DWT-LGT-SCS-001", name);
	}
}
