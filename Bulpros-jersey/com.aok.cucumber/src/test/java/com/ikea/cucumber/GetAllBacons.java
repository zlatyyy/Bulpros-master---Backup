package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class GetAllBacons {
	String output;
	String auth;
	JSONObject object;
	@When("^the user fills \"(.*?)\" and \"(.*?)\" and gets all beacons$")
	public void the_user_fills_and_and_gets_all_beacons(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/partners/ibeacons" + "?lang=en_US"  + this.auth);
		resp = webRes.get(ClientResponse.class);
		this.output = resp.getEntity(String.class);
	}
	@Then("^the beacons are displayed$")
	public void the_beacons_are_displayed() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		String description = object.getJSONObject("status").getString("description");
		int code = object.getJSONObject("status").getInt("code");
		Assert.assertEquals(200, code);
		Assert.assertEquals("DWT-BEACONS-SCS-001", name);
		Assert.assertEquals("Get all iBeacons succeeded.", description);
		int numberOfBeacons= object.getJSONArray("data").length();
		for(int i=0;i<numberOfBeacons;i++){
		Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("id"));
		Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("title"));
		Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("uuid"));
		Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getInt("major"));
		Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getInt("minor"));
		Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getJSONObject("category").getString("id"));
		Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getJSONObject("category").getString("name"));
		Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getJSONObject("category").getString("workflow"));
		Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getJSONObject("category").getString("tagLabel"));
		Assert.assertEquals("iBeacon",object.getJSONArray("data").getJSONObject(i).getJSONObject("category").getString("input"));
		Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getJSONObject("category").getInt("statusPoints"));
		Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getJSONObject("category").getInt("rewardPoints"));
		}
	}
}
