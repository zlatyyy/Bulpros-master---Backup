package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class UpdateBeaconActivity {
	String auth;
	String output;
	JSONObject object;
	@When("^an user enters \"(.*?)\" and \"(.*?)\" and submits beacon activity with \"(.*?)\"$")
	public void an_user_enters_and_and_submits_beacon_activity_with(String username, String password, String beaconUI) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/submitBeaconActivity" + "?lang=en_US"  + this.auth);
		resp = webRes.post(ClientResponse.class,"{\"uuid\":\""+beaconUI+"\",\"major\":\"100\",\"minor\":\"200\"}");
		this.output = resp.getEntity(String.class);
	}
	@Then("^the \"(.*?)\" is according to the entered beacon id$")
	public void the_is_according_to_the_entered_beacon_id(String responseCode) throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		int code = object.getJSONObject("status").getInt("code");
		Assert.assertEquals(200, code);
		Assert.assertEquals(responseCode, name);
		System.out.println(responseCode);
	}
}
