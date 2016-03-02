package com.ikea.cucumber;
import org.json.JSONObject;
	import org.junit.Assert;
	import cucumber.api.java.en.Given;
	import cucumber.api.java.en.Then;
	import cucumber.api.java.en.When;
	import com.sun.jersey.api.client.Client;
	import com.sun.jersey.api.client.ClientResponse;
	import com.sun.jersey.api.client.WebResource;
	public class LastAddedActivity {
		String auth;
		String output;
		String name;	
		int code;
		String description;
		String id;
		String group;
		String tagLabel;
		JSONObject object;
		@Given("^there is at least one added activity$")
		public void there_is_at_least_one_added_activity() throws Throwable {
		}
		@When("^user logs with \"(.*?)\" and \"(.*?)\"$")
		public void user_logs_with_and(String username, String password) throws Throwable {
			Authorization auth=new Authorization();
			this.auth=auth.the_have_to_authenticate_to_REST_services(username, password);
	    }							
		@When("^get the lastly activity$")	
		public void get_the_lastly_activity() throws Throwable {
			Client client;
			client = Client.create();
			ClientResponse resp;
			WebResource webRes;			
	        webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/lastlyAddedActivity"+"?lang=en_US"+this.auth);
	        resp =webRes.accept("application/json").get(ClientResponse.class);
			this.output=resp.getEntity(String.class);
		}
		@Then("the response is SCS$")
		public void the_response_is_SCS() throws Throwable {
			this.object = new JSONObject(output);
			this.name=object.getJSONObject("status").getString("name");	
			this.code=object.getJSONObject("status").getInt("code");
			this.description=object.getJSONObject("status").getString("description");
			this.id=object.getJSONObject("data").getJSONObject("category").getString("id");
			this.group=object.getJSONObject("data").getJSONObject("category").getString("group");
			this.tagLabel=object.getJSONObject("data").getJSONObject("category").getString("tagLabel");
			Assert.assertEquals(200, code);
			Assert.assertEquals("SCS", name);
			}
		}
