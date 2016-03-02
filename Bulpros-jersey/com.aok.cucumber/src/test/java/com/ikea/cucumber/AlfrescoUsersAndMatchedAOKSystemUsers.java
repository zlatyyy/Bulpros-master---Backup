package com.ikea.cucumber;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
public class AlfrescoUsersAndMatchedAOKSystemUsers {
	String auth;
	String output;
	String id;
	String group;
	String tagLabel;
	JSONObject object;
	@When("^we get the alfresco user with \"(.*?)\"$")
	public void we_get_the_alfresco_user(String userDataNodeRefId) throws Throwable {
		Client client;
		client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter("admin","admin"));
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/admin/alfrescoandexternal?userDataNodeRefId="+userDataNodeRefId);
		resp = webRes.get(ClientResponse.class);
		this.output = resp.getEntity(String.class);
	}
	@Then("^alfresco user matched from AOK system user is loaded$")
	public void alfresco_user_matched_from_AOK_system_user_is_loaded() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		int code = object.getJSONObject("status").getInt("code");
		Assert.assertEquals(200, code);
		Assert.assertEquals("DWT-USR-SCS-001", name);
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getString("id"));
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getString("userName"));
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getString("firstName"));
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getString("lastName"));
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getString("email"));
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getJSONObject("userData").getString("id"));
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getJSONObject("userData").getString("userName"));
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getJSONObject("userData").getString("firstName"));
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getJSONObject("userData").getString("lastName"));
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getJSONObject("userData").getString("email"));
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getJSONObject("userData").getString("id"));
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getJSONObject("userData").getString("address1"));
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getJSONObject("userData").getString("gender"));
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getJSONObject("userData").getString("birthDate"));
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getJSONObject("userData").getString("city"));
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getJSONObject("userData").getString("postalCode"));
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getJSONObject("userData").getString("country"));
		if(object.getJSONObject("data").getJSONObject("alfrescoUser").getJSONObject("userData").getString("enrollmentStatus").equals("Approved")){
		Assert.assertNotNull(object.getJSONObject("data").getJSONObject("alfrescoUser").getJSONObject("userData").getString("AOKMemberNumber"));
		}
	}
}
