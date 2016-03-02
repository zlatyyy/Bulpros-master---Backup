package com.ikea.cucumber;
import java.io.File;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.MultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;
public class ChangeAvatar {
	String output;
	String auth;
	JSONObject object;
	@When("^some user fills \"(.*?)\" and \"(.*?)\" and changes avatar$")
	public void some_user_fills_and_and_changes_avatar(String username, String password) throws Throwable {
		Authorization auth = new Authorization();
		this.auth = auth.the_have_to_authenticate_to_REST_services(username, password);
		ClientConfig config = new DefaultClientConfig();
		Client client;
		client = Client.create(config);
		ClientResponse resp;
		WebResource webRes;
		webRes = client.resource("http://dev15.bulpros.com:85/rest/dwt/user/changeAvatar" + "?lang=en_US"  + this.auth);
		 // the file to upload, represented as FileDataBodyPart
		File fileToUpload=new File("C:/Users/Zlatka.Yovcheva/Desktop/background.jpg");
        FileDataBodyPart fileDataBodyPart = new FileDataBodyPart("file",fileToUpload,MediaType.APPLICATION_OCTET_STREAM_TYPE);
        fileDataBodyPart.setContentDisposition(
                FormDataContentDisposition.name("file")
                        .fileName(fileToUpload.getName()).build());
        /* create the MultiPartRequest with:
         * Text field called "description"
         * JSON field called "characterProfile"
         * Text field called "filename"
         * Binary body part called "file" using fileDataBodyPart
         */
        MultiPart multiPart = new FormDataMultiPart()
                .bodyPart(fileDataBodyPart);
        multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);		
		resp =webRes.type("multipart/form-data").post(ClientResponse.class,
                multiPart);
		this.output = resp.getEntity(String.class);
	}
	@Then("^the avatar is changed$")
	public void the_avatar_is_changed() throws Throwable {
		this.object = new JSONObject(output);
		String name = object.getJSONObject("status").getString("name");
		String description = object.getJSONObject("status").getString("description");
		int code = object.getJSONObject("status").getInt("code");
		Assert.assertEquals(200, code);
		Assert.assertEquals("DWT-USR-SCS-007", name);
		Assert.assertEquals("Profile picture changed.", description);
		Assert.assertNotNull(object.getJSONObject("data").getString("url"));
	}
}
