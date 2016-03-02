package com.ikea.cucumber;

import org.json.JSONObject;
import org.junit.Assert;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistraionForService {
	private String auth;
	private String output;
	private String inputUpdate;
	@Given("^registration data \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")	
	public void the_user_fills(String email, String postalCode, String AokInsuranceNumber, String limitReached, String birthDate, String gender, String firstName, String secondName, String street, String city) throws Throwable {
		this.inputUpdate="{\"userName\":\""+email+"\",\"firstName\":\""+firstName+"\",\"lastName\":\""+secondName+"\",\"email\":\""+email+"\",\"jobTitle\":\"jobTitle\",\"description\":\"AutoTest\",\"country\":\"Germany\",\"city\":\""+city+"\",\"postalCode\":\""+postalCode+"\",\"address1\":\""+street+"\",\"phone\":\"0889088095\",\"userData\":{\""+gender+"\":\"f\",\"birthDate\":"+birthDate+",\"AOKMemberNumber\":\""+AokInsuranceNumber+"\",\"statusPoints\":0,\"rewardPoints\":0}}";

	}
	@When("^an user logs with \"(.*?)\" and \"(.*?)\"$")
	public void an_user_logs_with_and(String username, String password) throws Throwable {
		Authorization auth=new Authorization();
		this.auth=auth.the_have_to_authenticate_to_REST_services(username, password);
    }
	@When("^the user fills registration data$")	
	public void the_user_fills_registration_data() throws Throwable {
		Client restClient;
		restClient = Client.create();
		ClientResponse resp;
		WebResource webRes;		
        webRes = restClient.resource("http://dev15.bulpros.com:85/rest/dwt/user/registerForService"+"?lang=en_US"+this.auth);
        resp =webRes.accept("application/json").type("application/json").post(ClientResponse.class,this.inputUpdate);
		this.output = resp.getEntity(String.class);
	}

	@Then("^a \"(.*?)\" is correct$")
	public void a_is_correct(String responseCode) throws Throwable {
		JSONObject object = new JSONObject(this.output);
		String name=object.getJSONObject("status").getString("name");	
		Assert.assertEquals(responseCode, name);
		}
}
