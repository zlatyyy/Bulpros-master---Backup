package com.ikea.cucumber;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GetStatusPartnerCategory {
	String auth;
	String output;
	String id;
	String group;
	String tagLabel;
	JSONObject object;
	@Given("^the partner categories in KonaKart$")
	public void the_partner_categories_in_KonaKart() throws Throwable {
	}
	@When("^\"(.*?)\" \"(.*?)\" are entered$")
	public void are_entered(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource(
				"http://dev15.bulpros.com:85/rest/dwt/partners/statusPartnerCategories" + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").get(ClientResponse.class);
		this.output = resp.getEntity(String.class);
	}
	@Then("the partner categories are loaded$")
	public void the_partner_categories_are_loaded() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		int code = object.getJSONObject("status").getInt("code");
		String description = object.getJSONObject("status").getString("description");
		Assert.assertEquals("Operation successfully executed", description);
		Assert.assertEquals(200, code);
		Assert.assertEquals("SCS", name);
		Assert.assertNotNull(object.getJSONArray("data").length());
		int numberOfPartners = object.getJSONArray("data").length();
		for (int i = 0; i < numberOfPartners; i++) {
			Assert.assertEquals(false, object.getJSONArray("data").getJSONObject(i).getBoolean("invisible"));
			Assert.assertEquals(0, object.getJSONArray("data").getJSONObject(i).getInt("parentId"));
			Assert.assertTrue(object.getJSONArray("data").getJSONObject(i).getString("searchKey").contains("#partner"));
			Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getInt("level"));
			Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("name"));
			Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getInt("id"));
			Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("image"));
			try {
				int numberOfChildren = object.getJSONArray("data").getJSONObject(i).getJSONArray("children").length();
				for (int j = 0; j < numberOfChildren; j++) {
					Assert.assertEquals(object.getJSONArray("data").getJSONObject(i).getInt("id"),
							object.getJSONArray("data").getJSONObject(i).getJSONArray("children").getJSONObject(j)
									.getString("parentId"));
					Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getJSONArray("children")
							.getJSONObject(j).getString("custom1"));
					Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getJSONArray("children")
							.getJSONObject(j).getString("name"));
					Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getJSONArray("children")
							.getJSONObject(j).getString("image"));
					Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getJSONArray("children")
							.getJSONObject(j).getInt("id"));
					Assert.assertEquals(false, object.getJSONArray("data").getJSONObject(i).getJSONArray("children")
							.getJSONObject(j).getBoolean("invisible"));
				}
			} catch (JSONException e) {

			}
		}
	}
}
