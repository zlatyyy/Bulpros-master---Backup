package com.ikea.cucumber;
import java.io.File;
import java.io.FileWriter;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class GetCard {
	String auth;
	String output;
	JSONObject object;
	File readSourceFile = null;
	File destinationFileLocation = null;
	ClientResponse resp;
	@When("^the user fills \"(.*?)\" and \"(.*?)\"$")
	public void the_user_fills(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		Client client;
		client = Client.create();
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/card"+"?lang=en_US"+this.auth);	
		resp = webRes.get(ClientResponse.class);
		// read response and store the image file at destination
		readSourceFile = (File) resp.getEntity(File.class);
		String qualifiedDownloadFilePath = "C:\\Users\\Zlatka.Yovcheva\\Desktop\\"+ username+".png";
		destinationFileLocation = new File(qualifiedDownloadFilePath);
		readSourceFile.renameTo(destinationFileLocation);
		FileWriter fileWriter = new FileWriter(readSourceFile);
		fileWriter.flush();
	}
	@Then("the status card is loaded if \"(.*?)\" is 1$")
	public void the_status_card_is_loaded_if_is_1(int response) throws Throwable {	
		Assert.assertEquals(200, resp.getStatus());
		if(response==1){
			Assert.assertNotEquals(0,destinationFileLocation.length());
			System.out.println(destinationFileLocation.length());
		}
		else{
			Assert.assertEquals(0,destinationFileLocation.length());
			System.out.println(destinationFileLocation.length());	
		}
	}
}
