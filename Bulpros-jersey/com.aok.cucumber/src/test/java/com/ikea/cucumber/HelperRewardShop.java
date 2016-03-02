package com.ikea.cucumber;

import org.json.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class HelperRewardShop {	
	String inputCheckout="{\"firstName\":\"Dara\",\"lastName\":\"Loar\",\"address1\":\"ghfhj 8\",\"company\":\"Ret\",\"postalCode\":\"85585\",\"city\":\"Sofia\",\"email\":\"automationenr@bulpros.com\",\"phone\":\"08655525\",\"isMoneyCheckout\":false,\"isProductCheckout\":true,\"bankData\":{\"firstName\":\"\",\"lastName\":\"\",\"IBAN\":\"\"}}";
	public String rewardShop(String auth){
	Client restClient;
	ClientResponse resp;
	WebResource webRes;
	String output;
	restClient = Client.create();
    webRes = restClient.resource("http://dev15.bulpros.com:85/rest/dwt/eshop/checkout"+"?lang=en_US"+auth);
    resp =webRes.type("application/json").post(ClientResponse.class,this.inputCheckout);
	output = resp.getEntity(String.class);
	JSONObject object = new JSONObject(output);
	String name=object.getJSONObject("status").getString("name");
	return name;
	}
	
}
