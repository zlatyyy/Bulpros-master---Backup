package com.ikea.cucumber;

import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ApplyForAOKMember {
	String output;
	String input;
	JSONObject object;

	@Given("^the user data \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void the_user_data(String gender, String firstName, String lastName, String postalCode, String city,
			String email, String birthDate, String employmentStatus, String address1) throws Throwable {
		this.input = "{\"firstName\":\""+firstName+"\",\"lastName\":\""+lastName+"\",\"email\":\""+email+"\",\"city\":\""+city+"\",\"postalCode\":\""+postalCode+"\",\"address1\":\""+address1+"\",\"userData\":{\"gender\":\""+gender+"\",\"birthDate\":\""+birthDate+"\",\"employmentStatus\":\""+employmentStatus+"\"}}";
	}

	@When("^this user fills mandatory information$")
	public void this_user_fills_mandatory_information() throws Throwable {
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/becomeAOKMember");
		resp = webRes.accept("application/json").post(ClientResponse.class, this.input);
		this.output = resp.getEntity(String.class);
	}

	@Then("the application is sent and \"(.*?)\" is correct$")
	public void the_application_is_sent_and_is_correct(String responseCode) throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		int code = object.getJSONObject("status").getInt("code");
		Assert.assertEquals(200, code);
		Assert.assertEquals(responseCode, name);
	}
}
