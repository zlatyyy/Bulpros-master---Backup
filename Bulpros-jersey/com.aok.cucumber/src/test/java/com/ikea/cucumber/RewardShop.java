package com.ikea.cucumber;
	import org.json.JSONObject;
	import org.junit.Assert;
	import cucumber.api.java.en.Given;
	import cucumber.api.java.en.Then;
	import cucumber.api.java.en.When;
	import com.sun.jersey.api.client.Client;
	import com.sun.jersey.api.client.ClientResponse;
	import com.sun.jersey.api.client.WebResource;
	public class RewardShop {
		private String auth;
		private String output;
		private String inputCheckout;
		@Given("^list of products$")
		public void list_of_products_with() throws Throwable {
			this.inputCheckout="{\"firstName\":\"Martin\",\"lastName\":\"Neychev\",\"email\":\"automationenr@bulpros.com\",\"phone\":\"0888888888\",\"city\":\"Sofia\",\"address1\":\"Business Park\",\"addressAditionalInfo\":\"1A\",\"postcode\":\"1700\"}";
		}
		@When("^the user logs with her \"(.*?)\" and \"(.*?)\"$")
		public void user_logs_with_her_and(String username, String password) throws Throwable {
			Authorization auth=new Authorization();
			this.auth=auth.the_have_to_authenticate_to_REST_services(username, password);
	    }
		@When("^the user buy \"(.*?)\" of \"(.*?)\"$")	
		public void the_buy_of(String number, String product) throws Throwable {
			Client restClient;
			ClientResponse resp;
			WebResource webRes;
			restClient = Client.create();
	        webRes = restClient.resource("http://dev15.bulpros.com:85/rest/dwt/eshop/checkout"+"?lang=en_US"+this.auth);
	        resp =webRes.type("application/json").post(ClientResponse.class,
	        		this.inputCheckout);
			this.output = resp.getEntity(String.class);
			System.out.println(output);
		}
		@Then("^correct \"(.*?)\" is desplayed$")
		public void correct_is_desplayed(String responseCode) throws Throwable {
			JSONObject object = new JSONObject(this.output);
			String name=object.getJSONObject("status").getString("name");	
			Assert.assertEquals(responseCode, name);
			}
		}
