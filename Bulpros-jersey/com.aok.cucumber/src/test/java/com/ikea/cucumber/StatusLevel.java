package com.ikea.cucumber;
import java.util.List;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class StatusLevel {
	String auth;
	String output;
	String id;
	String group;
	String tagLabel;
	JSONObject object;
	private List<List<String>> tab;
	@Given("^defined levels$")
	public void defined_levels() throws Throwable {
	}
	@When("^the user logs using \"(.*?)\" and \"(.*?)\"$")
	public void the_user_logs_using_and(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/statuslevels" + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").get(ClientResponse.class);
		this.output = resp.getEntity(String.class);
	}
	@Then("the received response code is correct$")
	public void the_received_response_code_is_correct(DataTable table) throws Throwable {
		this.tab=table.raw();
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		int code = object.getJSONObject("status").getInt("code");
		Assert.assertEquals(200, code);
		Assert.assertEquals(tab.get(0).get(1), name);
		Assert.assertNotNull(object.getJSONArray("data").length());
		if (object.getJSONArray("data").length() != 0) {
			int numberOfSports = object.getJSONArray("data").length();
			for (int i = 0; i < numberOfSports; i++) {
				Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("name"));
				Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("code"));
				Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getInt("pointsFrom"));
				Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getInt("pointsTo"));
				Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("cardImageUrl"));
				Assert.assertNotEquals("dummy", object.getJSONArray("data").getJSONObject(i).getString("name"));
			}
		}
	}
}

