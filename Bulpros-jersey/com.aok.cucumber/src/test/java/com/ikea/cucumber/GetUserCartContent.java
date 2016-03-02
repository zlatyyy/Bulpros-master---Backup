package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class GetUserCartContent {
	private String auth;
	private String output;
	private String name;
	@When("^user logs with his \"(.*?)\" and his \"(.*?)\"$")
	public void user_logs_with_his_and_his(String username, String password) throws Throwable {
		Authorization auth=new Authorization();
		this.auth=auth.the_have_to_authenticate_to_REST_services(username, password);
    }
	@And("^the user gets cart$")	
	public void the_user_gets_cart() throws Throwable {
		ClientResponse resp;
		Client rest;
		WebResource webRes;
		rest = Client.create();
		webRes = rest.resource("http://dev15.bulpros.com:85/rest/dwt/eshop/cart"+"?lang=en_US"+this.auth);
	    resp = webRes.accept("application/json").type("application/json").post(ClientResponse.class, "");
	    this.output = resp.getEntity(String.class);
	    Assert.assertEquals(200,resp.getStatus());
	}
	@Then("^the response is returned$")
	public void the_response_is_returned() throws Throwable {
		JSONObject object = new JSONObject(this.output);
		this.name=object.getJSONObject("status").getString("name");	
		Assert.assertEquals("SCS", name);
		Assert.assertNotNull(object.getJSONObject("data"));
		}
}
