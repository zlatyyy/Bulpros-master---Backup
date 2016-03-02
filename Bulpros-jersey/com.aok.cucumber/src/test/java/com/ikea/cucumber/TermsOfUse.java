package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class TermsOfUse {
	String auth;
	String output;
	String id;
	String group;
	String tagLabel;
	JSONObject object;
	@When("^the user logs with \"(.*?)\" and \"(.*?)\" and opens Legal notices$")
	public void the_user_logs_with_and_opens_Legal_notices(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/wikiPage"+"?type=TOU"+this.auth+"lang=en_US");
		resp = webRes.accept("application/json").get(ClientResponse.class);
		this.output = resp.getEntity(String.class);
	}
	@Then("Terms of Use is displayed successfully$")
	public void Terms_of_Use_is_displayed_successfully() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		int code = object.getJSONObject("status").getInt("code");
		Assert.assertEquals(200, code);
		Assert.assertEquals("DWT-IMP-SCS-001", name);
		Assert.assertNotNull(object.getJSONArray("data").getJSONObject(0).getString("id"));
		Assert.assertNotNull(object.getJSONArray("data").getJSONObject(0).getString("title"));
		Assert.assertNotNull(object.getJSONArray("data").getJSONObject(0).getString("content"));
	}
}
