package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class GetBeaconSettings {
	String output;
	String auth;
	JSONObject object;
	@When("^an user fills \"(.*?)\" and \"(.*?)\" and gets beacon settings$")
	public void an_user_fills_and_and_gets_beacon_settings(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/beaconSettings" + "?lang=en_US"  + this.auth);
		resp = webRes.get(ClientResponse.class);
		this.output = resp.getEntity(String.class);
	}
	@Then("^the user can see uuid$")
	public void the_user_can_see_uuid() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		int code = object.getJSONObject("status").getInt("code");
		Assert.assertEquals(200, code);
		Assert.assertEquals("SCS", name);
		Assert.assertNotNull(object.getJSONObject("data").getString("uuid"));
		System.out.println(object.getJSONObject("data").getString("uuid"));
	}
}
