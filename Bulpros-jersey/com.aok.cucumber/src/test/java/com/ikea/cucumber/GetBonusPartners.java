package com.ikea.cucumber;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class GetBonusPartners {
	String auth;
	String outputGetProducts;
	String id;
	String group;
	String tagLabel;
	JSONObject object;
	String input;
	@When ("^the user logs in with \"(.*?)\" and \"(.*?)\" and gets all bonus partners without filter$")
	public void the_user_logs_in_with_and_and_gets_all_partners_without_filter(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client
				.resource("http://dev15.bulpros.com:85/rest/dwt/partners/bonuspartners" + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").post(ClientResponse.class,"");
		this.outputGetProducts = resp.getEntity(String.class);
	}
	@When ("^the user logs in with \"(.*?)\" and \"(.*?)\" and gets bonus partners by \"(.*?)\"$")
	public void the_user_logs_in_with_and_and_gets_bonus_partners_by(String username, String password, String tags) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client
				.resource("http://dev15.bulpros.com:85/rest/dwt/partners/bonuspartners" + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").post(ClientResponse.class,"{\"tags\":[\""+tags+"\"]}");
		this.outputGetProducts = resp.getEntity(String.class);
	}
	@When ("^the user logs in with \"(.*?)\" and \"(.*?)\"and gets bonus partners by search \"(.*?)\"$")
	public void the_user_logs_in_with_and_and_gets_bonus_partners_by_search(String username, String password, String nameSearch) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client
				.resource("http://dev15.bulpros.com:85/rest/dwt/partners/bonuspartners" + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").post(ClientResponse.class,"{\"nameSearch\":\""+nameSearch+"\"}");
		this.outputGetProducts = resp.getEntity(String.class);
	}
	@When ("^the user logs in with \"(.*?)\" and \"(.*?)\" and gets bonus partners by category \"(.*?)\"$")
	public void the_user_logs_in_with_and_and_gets_bonus_partners_by_category(String username, String password, String categoryId) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client
				.resource("http://dev15.bulpros.com:85/rest/dwt/partners/bonuspartners" + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").post(ClientResponse.class,"{\"categoryId\":\""+categoryId+"\"}");
		this.outputGetProducts = resp.getEntity(String.class);
	}
	@Then("^the bonus partners are loaded$")
	public void the_bonus_partners_are_loaded() throws Exception {	
		this.object = new JSONObject(outputGetProducts);
		String name = object.getJSONObject("status").getString("name");
		System.out.println(name);
		int code = object.getJSONObject("status").getInt("code");
		String description = object.getJSONObject("status").getString("description");
		Assert.assertEquals(200, code);
		Assert.assertEquals("SCS", name);
		Assert.assertEquals("Operation successfully executed", description);
		try {
			Assert.assertNotNull(object.getJSONObject("data").getJSONObject("pagination").getInt("total"));
			int numberOfBonusPartners=object.getJSONObject("data").getJSONObject("pagination").getInt("total");
			for(int i=0;i<numberOfBonusPartners;i++){
				Assert.assertNotNull(object.getJSONObject("data").getJSONArray("bonusPartners").getJSONObject(i).getInt("id"));
				Assert.assertNotNull(object.getJSONObject("data").getJSONArray("bonusPartners").getJSONObject(i).getInt("name"));
				Assert.assertNotNull(object.getJSONObject("data").getJSONArray("bonusPartners").getJSONObject(i).getInt("email"));
			}
		} catch (JSONException e) {};
	}
}
