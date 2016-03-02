package com.ikea.cucumber;

import org.json.JSONObject;
import org.junit.Assert;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Authorization {
	public String the_have_to_authenticate_to_REST_services(String username, String password) throws Throwable {
		Client restClient;
		ClientResponse respUpdate;
		WebResource webResource;
		restClient = Client.create();
        webResource = restClient.resource("http://dev15.bulpros.com:85/rest/dwt/user/login");
        respUpdate =webResource.type("application/x-www-form-urlencoded").post(ClientResponse.class,username+"&"+password);
		String outputs = respUpdate.getEntity(String.class);
		JSONObject object = new JSONObject(outputs);
		System.out.println(object.toString());
		Assert.assertTrue(object.has("data"));
		String alf_ticket=object.getJSONObject("data").getString("alf_ticket");	
		String kk_session_id=object.getJSONObject("data").getString("kk_session_id");	
		String auth="&alf_ticket="+alf_ticket+"&kk_session_id="+kk_session_id;	
		return auth;
    }
}