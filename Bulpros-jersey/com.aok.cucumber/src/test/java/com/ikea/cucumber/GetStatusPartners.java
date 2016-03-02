package com.ikea.cucumber;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GetStatusPartners {
	String auth;
	String outputGetPartners;
	String id;
	String group;
	String tagLabel;
	JSONObject object;
	String input;
	@Given("^the partners in KonaKart$")
	public void the_partners_in_KonaKart() throws Throwable {
	}

	@When("^an \"(.*?)\" and a \"(.*?)\" are entered$")
	public void an_and_a_are_entered(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
	}

	@And("^the user fillters by category \"(.*?)\"$")
	public void the_user_fillters_by_category(int categoryId) throws Throwable {
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client
				.resource("http://dev15.bulpros.com:85/rest/dwt/partners/statuspartners" + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").post(ClientResponse.class,
				"{\"categoryId\":\"" + categoryId + "\"}");
		this.outputGetPartners = resp.getEntity(String.class);
	}
	@And("^the user fillters by partner \"(.*?)\"$")
	public void the_user_fillters_by_partner(String partner) throws Throwable {
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client
				.resource("http://dev15.bulpros.com:85/rest/dwt/partners/statuspartners" + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").post(ClientResponse.class,
				"{\"tags\" : [ { \"tags\" : [\""+partner+"\"] }, { \"tags\" : [\"Partner\"] } ]}");
		this.outputGetPartners = resp.getEntity(String.class);
	}
	@Then("the status partners are loaded$")
	public void the_status_partners_are_loaded() throws Exception {	
		this.object = new JSONObject(outputGetPartners);
		String name = object.getJSONObject("status").getString("name");
		System.out.println(name);
		int code = object.getJSONObject("status").getInt("code");
		String description = object.getJSONObject("status").getString("description");
		Assert.assertEquals(200, code);
		Assert.assertEquals("SCS", name);
		Assert.assertEquals("Operation successfully executed", description);
		Assert.assertNotNull(object.getJSONObject("data").getInt("totalNumProducts"));
		System.out.println(object.getJSONObject("data").getInt("totalNumProducts")+"..................................");
		//We don't know if there is even one partner.
		try {
			Assert.assertNotNull(object.getJSONObject("data").getJSONArray("productArray"));
			int numbers = object.getJSONObject("data").getJSONArray("productArray").length();
			for (int i = 0; i < numbers; i++) {
				System.out.println(object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i)
						.getInt("categoryId"));
				Assert.assertNotNull(
						object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i).getInt("id"));
				System.out.println(
						object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i).getDouble("id"));
				Assert.assertNotNull(
						object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i).getDouble("price0"));
				System.out.println(
						object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i).getString("price0"));
				Assert.assertNotNull(
						object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i).getString("image"));
				System.out.println(
						object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i).getString("image"));
				Assert.assertNotNull(
						object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i).getString("name"));
				System.out.println(
						object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i).getString("name"));
				int numberOfTags = object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i)
						.getJSONArray("tags").length();
				for (int j = 0; j < numberOfTags; j++) {
					Assert.assertNotNull(object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i)
							.getJSONArray("tags").getJSONObject(j).getString("name"));
				}
			}
		} catch (JSONException e) {};
	}
}
