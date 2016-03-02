package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class ForgotPassword {
	String auth;
	String output;
	JSONObject object;
	@When("^the user logs in with \"(.*?)\" and \"(.*?)\" and send request with \"(.*?)\" to reset password$")
	public void the_user_logs_in_with_and_and_send_request_with_to_reset_password(String username, String password,String email) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/passwordForgot?email=" + email);
		resp = webRes.accept("application/json").get(ClientResponse.class);
		this.output = resp.getEntity(String.class);
	}
	@Then("the user receives email for reset$")
	public void the_user_receives_email_for_reset() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		int code = object.getJSONObject("status").getInt("code");
		String description = object.getJSONObject("status").getString("description");
		Assert.assertEquals("Eine E-Mail zur Passwortänderung wurde an dich gesendet.", description);
		Assert.assertEquals(200, code);
		Assert.assertEquals("DWT-USR-SCS-005", name);
	}
}
