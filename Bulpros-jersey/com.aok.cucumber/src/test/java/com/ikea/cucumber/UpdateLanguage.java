package com.ikea.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.json.JSONObject;
import org.junit.Assert;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import cucumber.api.java.en.Then;

public class UpdateLanguage {
	private String auth;
	private String output;
	private String input;
	@Given("^user profile with \"(.*?)\"$")	
	public void user_profile_with(String location) throws Throwable {
		this.input="{\"userName\":\"username\",\"firstName\":\"Gertruda\",\"lastName\":\"Muller\",\"email\":\"automationde@bulpros.com\",\"userData\":{\"gender\":\"f\",\"locale\":\""+location+"\"}}";
	}
	@When("^the user logs in AOK with \"(.*?)\" and \"(.*?)\"$")
	public void the_user_logs_in_AOK_with_and(String username, String password) throws Throwable {
		Authorization auth=new Authorization();
		this.auth=auth.the_have_to_authenticate_to_REST_services(username, password);
    }
	@When("^the user submits the change in \"(.*?)\"$")
	public void the_user_submits_the_change_in(String location) throws Throwable { 
	     // POST method
		ClientResponse resp;
		Client rest;
		WebResource webRes;
		rest = Client.create();
		webRes = rest.resource("http://dev15.bulpros.com:85/rest/dwt/user/update"+"?lang="+location+this.auth);
	    resp = webRes.accept("application/json").type("application/json").post(ClientResponse.class, this.input);
	    this.output = resp.getEntity(String.class);
	    Assert.assertEquals(200,resp.getStatus());
	}
	@Then("^the \"(.*?)\" and \"(.*?)\" are correct")
	public void the_and_are_correct(String responseCode, String description) throws Throwable {
			JSONObject object = new JSONObject(this.output);
			String nameOfReq=object.getJSONObject("status").getString("name");
			String descript=object.getJSONObject("status").getString("description");
			Assert.assertEquals(responseCode, nameOfReq);
			Assert.assertEquals(description, descript);
			}
}
