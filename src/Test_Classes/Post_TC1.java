package Test_Classes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.API_Methods;
import RequestRepository.Post_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Post_TC1 {
	@Test
		public static void extractor() throws IOException
	    {
	    
		int statusCode =API_Methods.ResponseStatusCode(Post_Req_Repository.BaseURI(),Post_Req_Repository.Post_Resource() ,Post_Req_Repository.Post_Req_TC1());
	    
		System.out.println(statusCode);
	    
	    String ResponseBody = API_Methods.ResponseBody(Post_Req_Repository.BaseURI(),Post_Req_Repository.Post_Resource() ,Post_Req_Repository.Post_Req_TC1());
	    System.out.println(ResponseBody);
		
	    JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		String Res_createdAt = JspResponse.getString("createdAt");
		Res_createdAt = Res_createdAt.substring(0,11);
		
		Assert.assertEquals(Res_name,Res_name);
		Assert.assertEquals(Res_job, Res_job);
	}

}
