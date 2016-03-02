package com.ikea.cucumber;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class GetProducts {
	String auth;
	String outputGetProducts;
	String id;
	String group;
	String tagLabel;
	JSONObject object;
	String input;
	@Given("^the products in KonaKart$")
	public void the_products_in_KonaKart() throws Throwable {
	}
	@When ("^the user logs in with \"(.*?)\" and \"(.*?)\" and does not apply filter$")
	public void the_user_logs_in_with_and_and_does_not_apply_filter(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client
				.resource("http://dev15.bulpros.com:85/rest/dwt/eshop/products" + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").post(ClientResponse.class,"");
		this.outputGetProducts = resp.getEntity(String.class);
	}
	@When("^the user logs in with \"(.*?)\" and \"(.*?)\" and filters products by category \"(.*?)\"$")
	public void the_user_logs_in_with_and_and_filters_products_by_category(String username, String password,int categoryId) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client
				.resource("http://dev15.bulpros.com:85/rest/dwt/eshop/products" + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").post(ClientResponse.class,
				"{\"categoryId\":\"" + categoryId + "\"}");
		this.outputGetProducts = resp.getEntity(String.class);
	}
	@When("^the user logs in with \"(.*?)\" and \"(.*?)\" and filters by search \"(.*?)\"$")
	public void the_user_logs_in_with_and_and_filters_by_search(String username, String password,String nameSearch) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/eshop/products" + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").post(ClientResponse.class,"{\"nameSearch\":\"" + nameSearch + "\"}");
		this.outputGetProducts = resp.getEntity(String.class);
	}
	@When("^the user logs in with \"(.*?)\" and \"(.*?)\" and filters to \"(.*?)\"$")
	public void the_user_logs_in_with_and_and_filters_to(String username, String password,String priceTo) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/eshop/products" + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").post(ClientResponse.class,"{\"priceTo\":\"" + priceTo + "\"}");
		this.outputGetProducts = resp.getEntity(String.class);
	}
	@Then("the products are loaded$")
	public void the_products_are_loaded() throws Exception {	
		this.object = new JSONObject(outputGetProducts);
		String name = object.getJSONObject("status").getString("name");
		System.out.println(name);
		int code = object.getJSONObject("status").getInt("code");
		String description = object.getJSONObject("status").getString("description");
		Assert.assertEquals(200, code);
		Assert.assertEquals("SCS", name);
		Assert.assertEquals("Operation successfully executed", description);
		Assert.assertNotNull(object.getJSONObject("data").getInt("totalNumProducts"));
		System.out.println(object.getJSONObject("data").getInt("totalNumProducts")+"..................................");
		//We don't know if there is even one partner.
		try {
			Assert.assertNotNull(object.getJSONObject("data").getJSONArray("productArray"));
			int numbers = object.getJSONObject("data").getJSONArray("productArray").length();
			for (int i = 0; i < numbers; i++) {
				Assert.assertNotNull(object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i)
						.getInt("categoryId"));
				Assert.assertNotNull(
						object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i).getInt("id"));
				Assert.assertNotNull(
						object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i).getDouble("price0"));
				Assert.assertNotNull(
						object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i).getString("name"));
				Assert.assertNotNull(
						object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i).getString("image"));
				int numberOfTags = object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i)
						.getJSONArray("tags").length();
				for (int j = 0; j < numberOfTags; j++) {
					Assert.assertTrue(object.getJSONObject("data").getJSONArray("productArray").getJSONObject(i)
							.getJSONArray("tags").getJSONObject(j).getString("name").contains("#Product"));
				}
			}
		} catch (JSONException e) {};
	}
}
