package com.ikea.cucumber;

import org.json.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class HelperLastActivity {
	JSONObject objectLast;
	public HelperLastActivity(String username, String password) throws Throwable {
		String authentication;
		Client res;
		ClientResponse update;
		WebResource web;
		res = Client.create();
		Authorization auth=new Authorization();
		authentication=auth.the_have_to_authenticate_to_REST_services(username, password);				
		web = res.resource("http://dev15.bulpros.com:85/rest/dwt/user/lastlyAddedActivity"+"?lang=en_US"+authentication);
		update = web.type("application/json").get(ClientResponse.class);
		String output = update.getEntity(String.class);
		this.objectLast = new JSONObject(output);
	}

	public String getId() throws Throwable {
		String id = this.objectLast.getJSONObject("category").getString("id");
		System.out.println(id);
		return id;
	}

	public String getTagLabel() throws Throwable {
		String tagLabel = this.objectLast.getJSONObject("data").getJSONObject("category").getString("tagLabel");
		return tagLabel;
	}

	public String getGroup() throws Throwable {
		String group = this.objectLast.getJSONObject("data").getJSONObject("category").getString("group");
		return group;
	}

	public String getName() throws Throwable {
		String name = objectLast.getJSONObject("data").getJSONObject("category").getString("name");
		return name;
	}

	public String getCode() throws Throwable {
		String code = objectLast.getJSONObject("status").getString("code");
		return code;
	}
}
