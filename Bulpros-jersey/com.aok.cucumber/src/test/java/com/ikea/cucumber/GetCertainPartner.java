package com.ikea.cucumber;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class GetCertainPartner {
	String auth;
	String outputGetPartner;
	String id;
	String group;
	String tagLabel;
	JSONObject object;
	String input;
	@When("^the user logs in with \"(.*?)\" and \"(.*?)\" and add \"(.*?)\"$")
	public void the_user_logs_in_with_and_and_add(String username, String password,int partnerId) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client
				.resource("http://dev15.bulpros.com:85/rest/dwt/partners/statuspartners/" + partnerId + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").get(ClientResponse.class);
		this.outputGetPartner = resp.getEntity(String.class);
	}
	@Then("the partner is loaded$")
	public void the_partners_is_loaded() throws Exception {	
		this.object = new JSONObject(outputGetPartner);
		String name = object.getJSONObject("status").getString("name");
		System.out.println(name);
		int code = object.getJSONObject("status").getInt("code");
		String description = object.getJSONObject("status").getString("description");
		Assert.assertEquals(200, code);
		Assert.assertEquals("SCS", name);
		Assert.assertEquals("Operation successfully executed", description);
		try {
				Assert.assertNotNull(object.getJSONObject("data").getJSONArray("productArray"));
				Assert.assertNotNull(object.getJSONObject("data").getInt("categoryId"));
				Assert.assertNotNull(object.getJSONObject("data").getString("description"));
				Assert.assertNotNull(object.getJSONObject("data").getInt("id"));
				Assert.assertNotNull(object.getJSONObject("data").getString("image"));
				Assert.assertNotNull(object.getJSONObject("data").getString("name")); 
				Assert.assertNotNull(object.getJSONObject("data").getString("taxClassId"));
				Assert.assertNotNull(object.getJSONObject("data").getString("price0"));
				Assert.assertNotNull(object.getJSONObject("data").getString("priceExTax"));
				Assert.assertNotNull(object.getJSONObject("data").getString("priceIncTax"));
				Assert.assertNotNull(object.getJSONObject("data").getString("manufacturerId"));
				Assert.assertNotNull(object.getJSONObject("data").getString("type"));
				Assert.assertNotNull(object.getJSONObject("data").getString("model"));
		} catch (JSONException e) {};
	}
}
