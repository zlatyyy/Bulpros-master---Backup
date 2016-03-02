package com.ikea.cucumber;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GetTargets {
	String auth;
	String outputGetTargets;
	String id;
	String group;
	String tagLabel;
	JSONObject object;
	String input;

	@When("^the user enters \"(.*?)\" and \"(.*?)\"$")
	public void the_user_enters_and(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/target/targets" + "?lang=en_US" + this.auth);
		resp = webRes.accept("application/json").get(ClientResponse.class);
		this.outputGetTargets = resp.getEntity(String.class);
	}

	@Then("^the targets are loaded$")
	public void the_targets_are_loaded() throws Exception {
		this.object = new JSONObject(outputGetTargets);
		String name = object.getJSONObject("status").getString("name");
		System.out.println(name);
		int code = object.getJSONObject("status").getInt("code");
		String description = object.getJSONObject("status").getString("description");
		Assert.assertEquals(200, code);
		Assert.assertEquals("DWT-CAT-SCS-001", name);
		Assert.assertEquals("Get activity categories succeeded.", description);
			Assert.assertNotNull(object.getJSONObject("data").getJSONArray("CALORIES"));
			Assert.assertNotNull(object.getJSONObject("data").getJSONArray("STEPS"));
			Assert.assertNotNull(object.getJSONObject("data").getJSONArray("PULSE"));
			List <JSONArray> targets= new ArrayList<JSONArray>();
			targets.add(object.getJSONObject("data").getJSONArray("CALORIES"));
			targets.add(object.getJSONObject("data").getJSONArray("STEPS"));
			targets.add(object.getJSONObject("data").getJSONArray("PULSE"));
			for (JSONArray arr : targets) {
				int number = arr.length();
				for (int i = 0; i < number; i++) {
					Assert.assertNotNull(
							arr.getJSONObject(i).getString("id"));
					Assert.assertNotNull(
							arr.getJSONObject(i).getInt("target"));
					Assert.assertNotNull(
							arr.getJSONObject(i).getInt("timeRange"));
					Assert.assertNotNull(
							arr.getJSONObject(i).getInt("age"));
					Assert.assertNotNull(arr.getJSONObject(i)
							.getJSONObject("activityCategory").getString("id"));
					Assert.assertNotNull(arr.getJSONObject(i)
							.getJSONObject("activityCategory").getString("name"));
					Assert.assertNotNull(arr.getJSONObject(i)
							.getJSONObject("activityCategory").getString("group"));
					Assert.assertNotNull(arr.getJSONObject(i)
							.getJSONObject("activityCategory").getString("workflow"));
					Assert.assertNotNull(arr.getJSONObject(i)
							.getJSONObject("activityCategory").getInt("limitForPeriod"));
					Assert.assertNotNull(arr.getJSONObject(i)
							.getJSONObject("activityCategory").getString("period"));
					int numberOfLimits=arr.getJSONObject(i)
							.getJSONObject("activityCategory").getJSONArray("categoryLimits").length();
					for(int j=0;j<numberOfLimits;j++){
					Assert.assertNotNull(arr.getJSONObject(i)
							.getJSONObject("activityCategory").getJSONArray("categoryLimits").getJSONObject(j).getString("id"));
					Assert.assertNotNull(arr.getJSONObject(i)
							.getJSONObject("activityCategory").getJSONArray("categoryLimits").getJSONObject(j).getInt("limitForPeriod"));
					Assert.assertNotNull(arr.getJSONObject(i)
							.getJSONObject("activityCategory").getJSONArray("categoryLimits").getJSONObject(j).getString("period"));
					}
					Assert.assertEquals("Health",arr.getJSONObject(i)
							.getJSONObject("activityCategory").getString("input"));
					Assert.assertEquals(true,arr.getJSONObject(i)
							.getJSONObject("activityCategory").getBoolean("isVisible"));
					Assert.assertNotNull(arr.getJSONObject(i)
							.getJSONObject("activityCategory").getInt("statusPoints"));
					Assert.assertNotNull(arr.getJSONObject(i)
							.getJSONObject("activityCategory").getInt("rewardPoints"));
					}
			}					
	}
}
