package com.ikea.cucumber;

import java.io.File;
import java.io.FileWriter;
import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class UserShare {
	String auth;
	File readSourceFile = null;
	File destinationFileLocation = null;
	ClientResponse resp;
	public static String encodeImage(byte[] imageByteArray) {
		return Base64.encodeBase64URLSafeString(imageByteArray);
	}
	public static byte[] decodeImage(String imageDataString) {
		return Base64.decodeBase64(imageDataString);
	}
	@When("^this user shares \"(.*?)\"$")
	public void this_user_shares(String statusLevelCode) throws Throwable {
		ClientConfig config = new DefaultClientConfig();
		Client client;
		client = Client.create(config);
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/share").queryParam("statusLevelCode",
				statusLevelCode);
		resp = webRes.get(ClientResponse.class);
		// read response and store the image file at destination
		readSourceFile = (File) resp.getEntity(File.class);
		String qualifiedDownloadFilePath = "C:\\Users\\Zlatka.Yovcheva\\Desktop\\"+ statusLevelCode+".png";
		destinationFileLocation = new File(qualifiedDownloadFilePath);
		readSourceFile.renameTo(destinationFileLocation);
		FileWriter fileWriter = new FileWriter(readSourceFile);
		fileWriter.flush();
	}
	@Then("^the image is shared$")
	public void the_image_is_shared() throws Throwable {
			Assert.assertEquals(200, resp.getStatus());
			Assert.assertNotEquals(0,destinationFileLocation.length());
			System.out.println(destinationFileLocation.length());		
	}
}
