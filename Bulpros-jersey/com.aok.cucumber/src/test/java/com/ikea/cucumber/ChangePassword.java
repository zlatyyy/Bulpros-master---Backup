package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class ChangePassword {
	private String auth;
	private String output;
	private String name;
	@Given("^a password$")
	public void a_password() throws Throwable {		
	}
	@When("^user logs with a \"(.*?)\" and \"(.*?)\"$")
	public void user_logs_with_a_and(String username, String password) throws Throwable {
		Authorization auth=new Authorization();
		this.auth=auth.the_have_to_authenticate_to_REST_services(username, password);
    }
	@When("^the user with \"(.*?)\" changes \"(.*?)\" with a \"(.*?)\"$")	
	public void the_user_with_changes_with_a(String email,String oldPassword, String newPassword) throws Throwable {
		 // POST method
		ClientResponse resp;
		Client rest;
		WebResource webRes;
		rest = Client.create();
		webRes = rest.resource("http://dev15.bulpros.com:85/rest/dwt/user/changePassword"+"?lang=en_US&email="+email+"&oldPassword="+oldPassword+"&newPassword="+newPassword+this.auth);
	    System.out.println("http://dev15.bulpros.com:85/rest/dwt/user/changePassword"+"?lang=en_US&email="+email+"&oldPassword="+oldPassword+"&newPassword="+newPassword+this.auth);
		resp = webRes.accept("application/json").post(ClientResponse.class, "");
	    this.output = resp.getEntity(String.class);
	    System.out.println(output);
	    Assert.assertEquals(200,resp.getStatus());
	}
	@Then("^the response \"(.*?)\" is correct$")
	public void the_response_is_correct(String responseCode) throws Throwable {
		JSONObject object = new JSONObject(this.output);
		this.name=object.getJSONObject("status").getString("name");	
		Assert.assertEquals(responseCode, name);
		}
}
	
