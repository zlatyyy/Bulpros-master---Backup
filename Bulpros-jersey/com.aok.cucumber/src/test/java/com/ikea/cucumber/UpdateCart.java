package com.ikea.cucumber;
	import org.json.JSONObject;
	import org.junit.Assert;
	import cucumber.api.java.en.Given;
	import cucumber.api.java.en.Then;
	import cucumber.api.java.en.When;
	import com.sun.jersey.api.client.Client;
	import com.sun.jersey.api.client.ClientResponse;
	import com.sun.jersey.api.client.WebResource;
	public class UpdateCart {
		private String auth;
		private String output;
		private String input;
		private String name;
		@Given("the user selects \"(.*?)\" from \"(.*?)\"$")
		public void the_user_selects(String number, String product) throws Throwable {
			this.input="[{\"id\":"+product+",\"quantity\":"+number+",\"opts\":[]}]";
		}
		@When("^user logs with his \"(.*?)\" and \"(.*?)\"$")
		public void user_logs_with_his_and(String username, String password) throws Throwable {
			Authorization auth=new Authorization();
			this.auth=auth.the_have_to_authenticate_to_REST_services(username, password);
	    }
		@When("^the user add selected products to cart$")	
		public void the_user_add_selected_products_to_cart() throws Throwable {
			 // POST method
			ClientResponse resp;
			Client rest;
			WebResource webRes;
			rest = Client.create();
			webRes = rest.resource("http://dev15.bulpros.com:85/rest/dwt/eshop/updateCart"+"?lang=en_US"+this.auth);
		    resp = webRes.accept("application/json").type("application/json").post(ClientResponse.class, this.input);
		    this.output = resp.getEntity(String.class);
		    Assert.assertEquals(200,resp.getStatus());
		}
		@Then("^the \"(.*?)\" is ok$")
		public void the_is_ok(String responseCode) throws Throwable {
			JSONObject object = new JSONObject(this.output);
			this.name=object.getJSONObject("status").getString("name");	
			Assert.assertEquals(responseCode, name);
			}
		@Then("^do checkout$")
		public void do_checkout() throws Throwable {
			if(name.equals("DWT-ESHP-SCS-001")){
				HelperRewardShop shop=new HelperRewardShop();
				String codeName=shop.rewardShop(this.auth);
				System.out.println(codeName);
				Assert.assertEquals("DWT-ESHP-SCS-002", codeName);
			}
		}
		}
