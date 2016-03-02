package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class GetActivityCategories {
	String output;
	String auth;
	JSONObject object;
	@When("^some user fills \"(.*?)\" and \"(.*?)\" and get activity categories$")
	public void some_user_fills_and_and_get_activity_categories(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/activityCategories" + "?lang=en_US"  + this.auth);
		resp = webRes.get(ClientResponse.class);
		this.output = resp.getEntity(String.class);
	}
	@Then("^the activity categories are displayed$")
	public void the_activity_categories_are_displayed() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		String description = object.getJSONObject("status").getString("description");
		int code = object.getJSONObject("status").getInt("code");
		Assert.assertEquals(200, code);
		Assert.assertEquals("DWT-CAT-SCS-001", name);
		Assert.assertEquals("Get activity categories succeeded.", description);
		/*Assert.assertNotNull(object.getJSONObject("data").getString("id"));
		Assert.assertNotNull(object.getJSONObject("data").getString("name"));
		Assert.assertNotNull(object.getJSONObject("data").getString("group"));
		Assert.assertNotNull(object.getJSONObject("data").getString("workflow"));
		Assert.assertNotNull(object.getJSONObject("data").getString("tagLabel"));
		Assert.assertNotNull(object.getJSONObject("data").getInt("statusPoints"));
		Assert.assertNotNull(object.getJSONObject("data").getInt("rewardPoints"));
		Assert.assertEquals("iBeacon", object.getJSONObject("data").getString("input"));*/
	}
}
