package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
public class AlfrescoOrderDetails {
	String auth;
	String output;
	String id;
	String group;
	String tagLabel;
	JSONObject object;
	@When("^an user send request to orderDetails using specified \"(.*?)\"$")
	public void an_user_send_request_to_orderDetails_using_specified(String orderId) throws Throwable {
		Client client;
		client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter("admin","admin"));
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/admin/orderDetails"+"?orderId="+orderId);
		resp = webRes.get(ClientResponse.class);
		this.output = resp.getEntity(String.class);
	}
	@Then("^the server returns a correct response$")
	public void the_server_returns_a_correct_response() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		int code = object.getJSONObject("status").getInt("code");
		Assert.assertEquals(200, code);
		Assert.assertEquals("SCS", name);
	}
}
