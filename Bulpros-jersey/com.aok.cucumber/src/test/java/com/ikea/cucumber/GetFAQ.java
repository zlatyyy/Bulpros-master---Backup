package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class GetFAQ {
	String auth;
	String output;
	String id;
	String group;
	String tagLabel;
	JSONObject object;
	@Given("^the list with frequently asked questions$")
	public void the_list_with_frequently_asked_questions()throws Throwable {
	}
	@When("^some user enters \"(.*?)\" and \"(.*?)\"$")
	public void some_user_enters(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/faq"+"?lang=en_US"+this.auth);
		resp = webRes.accept("application/json").get(ClientResponse.class);
		this.output = resp.getEntity(String.class);
	}
	@Then("the FAQ are loaded$")
	public void the_FAQ_are_loaded() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		int code = object.getJSONObject("status").getInt("code");
		String description = object.getJSONObject("status").getString("description");
		Assert.assertEquals("Get frequently asked questions list succeeded.", description);
		Assert.assertEquals(200, code);
		Assert.assertEquals("DWT-FAQ-SCS-001", name);
		Assert.assertNotNull(object.getJSONArray("data").length());
		int numberOfAnswers = object.getJSONArray("data").length();
		for (int i = 0; i < numberOfAnswers; i++) {
			Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("answer"));
			Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("id"));
			Assert.assertNotNull(object.getJSONArray("data").getJSONObject(i).getString("question"));
		}
	}
}
