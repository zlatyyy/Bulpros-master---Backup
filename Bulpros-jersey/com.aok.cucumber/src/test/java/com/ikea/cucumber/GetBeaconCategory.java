package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class GetBeaconCategory {
	String output;
	String auth;
	JSONObject object;
	@When("^an user fills \"(.*?)\" and \"(.*?)\" and submits \"(.*?)\" \"(.*?)\" and \"(.*?)\"$")
	public void an_user_fills_and_and_submits_and(String username, String password, String uuid, int minor, int major) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/partners/ibeaconCategory" + "?lang=en_US"  + this.auth);
		resp = webRes.post(ClientResponse.class,"{\"uuid\":\""+uuid+"\",\"major\":\""+major+"\",\"minor\":\""+minor+"\"}");
		this.output = resp.getEntity(String.class);
	}
	@Then("^the categoty for the beacons is displayed$")
	public void the_categoty_for_the_beacons_is_displayed() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		String description = object.getJSONObject("status").getString("description");
		int code = object.getJSONObject("status").getInt("code");
		Assert.assertEquals(200, code);
		Assert.assertEquals("SCS", name);
		Assert.assertEquals("Operation successfully executed", description);
		try{
		Assert.assertNotNull(object.getJSONObject("data").getString("id"));
		Assert.assertNotNull(object.getJSONObject("data").getString("name"));
		Assert.assertNotNull(object.getJSONObject("data").getString("group"));
		Assert.assertNotNull(object.getJSONObject("data").getString("workflow"));
		Assert.assertNotNull(object.getJSONObject("data").getString("tagLabel"));
		Assert.assertNotNull(object.getJSONObject("data").getInt("statusPoints"));
		Assert.assertNotNull(object.getJSONObject("data").getInt("rewardPoints"));
		Assert.assertEquals("iBeacon", object.getJSONObject("data").getString("input"));
		}
		catch(Exception e){
			System.out.println("The data is not returned.");
		}
	}
}
