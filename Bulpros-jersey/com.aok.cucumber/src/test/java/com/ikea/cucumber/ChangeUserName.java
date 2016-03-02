package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class ChangeUserName {
	private String auth;
	private String output;
	@When("^an user logs using \"(.*?)\" and \"(.*?)\"$")
	public void user_logs_using_and(String username, String password) throws Throwable {
		Authorization auth=new Authorization();
		this.auth=auth.the_have_to_authenticate_to_REST_services(username, password);
    }
	@And("^the user changes old username with \"(.*?)\"$")	
	public void the_user_changes_old_username_with(String newUsername) throws Throwable {
		 // POST method
		ClientResponse resp;
		Client rest;
		WebResource webRes;
		rest = Client.create();
		webRes = rest.resource("http://dev15.bulpros.com:85/rest/dwt/user/changeUsername"+"?lang=en_US&newUsername="+newUsername+this.auth);
		resp = webRes.accept("application/json").post(ClientResponse.class, "");
	    this.output = resp.getEntity(String.class);
	    System.out.println(output);
	    Assert.assertEquals(200,resp.getStatus());
	}
	@Then("^the username is changed and the \"(.*?)\" is correct$")
	public void the_username_is_changed_and_the_is_correct(String responseCode) throws Throwable {
		JSONObject object = new JSONObject(this.output);
		Assert.assertEquals(responseCode, object.getJSONObject("status").getString("name"));
		Assert.assertEquals("Update user succeeded.", object.getJSONObject("status").getString("description"));
		}
}
