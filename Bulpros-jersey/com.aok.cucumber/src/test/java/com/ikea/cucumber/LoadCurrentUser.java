package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class LoadCurrentUser {
	String auth;
	String output;
	String id;
	String group;
	String tagLabel;
	JSONObject object;

	@Given("^There is already created user account$")
	public void There_is_already_created_user_account() throws Throwable {
	}

	@When("^\"(.*?)\" and \"(.*?)\" are filled$")
	public void and_are_filled(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/current" + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").get(ClientResponse.class);
		this.output = resp.getEntity(String.class);
	}
	@Then("the user profile is loaded$")
	public void the_user_profile_is_loaded() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		int code = object.getJSONObject("status").getInt("code");
		String description = object.getJSONObject("status").getString("description");
		Assert.assertEquals(200, code);
		Assert.assertEquals("DWT-USR-SCS-001", name);
		Assert.assertEquals("Get user succeeded.", description);
		Assert.assertNotNull(object.getJSONObject("data").getString("id"));
		Assert.assertNotNull(object.getJSONObject("data").getString("userName"));
		Assert.assertNotNull(object.getJSONObject("data").getString("email"));
		Assert.assertNotNull(object.getJSONObject("data").getString("firstName"));
		Assert.assertNotNull(object.getJSONObject("data").getString("lastName"));
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("userData").getString("gender"));
		if(object.getJSONObject("data").getJSONObject("userData").get("enrollmentStatus").equals("Approved")){
			Assert.assertNotNull(object.getJSONObject("data").getString("city"));
			Assert.assertNotNull(object.getJSONObject("data").getString("postalCode"));
			Assert.assertNotNull(object.getJSONObject("data").getString("phone"));
			Assert.assertNotNull(object.getJSONObject("data").getString("address1"));
			Assert.assertNotNull(object.getJSONObject("data").getJSONObject("userData").getString("AOKMemberNumber"));
		}
	}
}
