package com.ikea.cucumber;

import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GetDistricts {
	String auth;
	String output;
	String id;
	String group;
	String tagLabel;
	JSONObject object;

	@Given("^the districts in KonaKart$")
	public void the_districts_in_KonaKart() throws Throwable {
	}

	@When("^\"(.*?)\" and the \"(.*?)\" are entered$")
	public void and_the_are_entered(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/partners/districts" + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").get(ClientResponse.class);
		this.output = resp.getEntity(String.class);
	}
	@Then("the districts are loaded$")
	public void the_districts_are_loaded() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		int code = object.getJSONObject("status").getInt("code");
		String description = object.getJSONObject("status").getString("description");
		Assert.assertEquals("Operation successfully executed", description);
		Assert.assertEquals(200, code);
		Assert.assertEquals("SCS", name);
		Assert.assertNotNull(object.getJSONArray("data").length());
		Assert.assertEquals("District", object.getJSONArray("data").getJSONObject(0).getString("name"));
		Assert.assertNotNull(object.getJSONArray("data").getJSONObject(0).getInt("id"));
		int numberOfDestricts = object.getJSONArray("data").getJSONObject(0).getJSONArray("tags").length();
		for (int i = 0; i < numberOfDestricts; i++) {
			Assert.assertNotNull(object.getJSONArray("data").getJSONObject(0).getJSONArray("tags").getJSONObject(i)
					.getString("name"));
			Assert.assertNotNull(
					object.getJSONArray("data").getJSONObject(0).getJSONArray("tags").getJSONObject(i).getInt("id"));
			Assert.assertNotNull(object.getJSONArray("data").getJSONObject(0).getJSONArray("tags").getJSONObject(i)
					.getInt("numProducts"));
		}
	}
}
