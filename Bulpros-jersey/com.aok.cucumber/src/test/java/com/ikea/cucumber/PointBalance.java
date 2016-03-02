package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class PointBalance {
	String auth;
	String output;
	String id;
	String group;
	String tagLabel;
	JSONObject object;
	@Given("^there is a created user$")
	public void there_is_a_created_user() throws Throwable {
	}
	@When("^\"(.*?)\" and \"(.*?)\" are entered$")
	public void and_are_entered(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/pointbalance" + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").post(ClientResponse.class,"");
		this.output = resp.getEntity(String.class);
	}
	@Then("the point balance history is loaded$")
	public void the_point_balance_history_is_loaded() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		int code = object.getJSONObject("status").getInt("code");
		String description = object.getJSONObject("status").getString("description");
		Assert.assertEquals(200, code);
		Assert.assertEquals("SCS", name);
		Assert.assertEquals("Operation successfully executed", description);
		if (object.getJSONArray("data").length() != 0) {
			int numberOfSports = object.getJSONArray("data").length();
			for (int i = 0; i < numberOfSports; i++) {
				Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("name"));
				Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("description1"));
				Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("description2"));
				Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("status"));
				Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getInt("bonusPoints"));
				Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("date"));
				Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("type"));
				Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("statusName"));
			}
		}
	}
}
