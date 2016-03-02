package com.ikea.cucumber;

import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GetSports {
	String auth;
	String output;
	String id;
	String group;
	String tagLabel;
	JSONObject object;

	@Given("^defined sports$")
	public void defined_sports() throws Throwable {
	}

	@When("^user logs using \"(.*?)\" and \"(.*?)\"$")
	public void user_logs_using_and(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/sports" + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").get(ClientResponse.class);
		this.output = resp.getEntity(String.class);
	}

	@Then("the sports are loaded$")
	public void the_sports_are_loaded() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		int code = object.getJSONObject("status").getInt("code");
		String description = object.getJSONObject("status").getString("description");
		Assert.assertEquals(200, code);
		Assert.assertEquals("DWT-SPORT-SCS-001", name);
		Assert.assertEquals("Get sports succeeded.", description);
		Assert.assertNotNull(object.getJSONArray("data").length());
		if (object.getJSONArray("data").length() != 0) {
			int numberOfSports = object.getJSONArray("data").length();
			for (int i = 0; i < numberOfSports; i++) {
				Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("name"));
				Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("imageURL"));
			}
		}
	}
}
