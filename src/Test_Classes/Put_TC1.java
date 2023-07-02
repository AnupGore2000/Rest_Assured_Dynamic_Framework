package Test_Classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.API_Methods;
import Common_API_Methods.Put_API_Methods;
import RequestRepository.Put_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Put_TC1 {
	@Test
	    public static void extractor() {
		
		int statusCode = Put_API_Methods.ResponseStatusCode(Put_Req_Repository.BaseURI(),Put_Req_Repository.Put_Resource(),Put_Req_Repository.Put_Req_TC1());
		System.out.println(statusCode);
	    
	    String ResponseBody = API_Methods.ResponseBody(Put_Req_Repository.BaseURI(),Put_Req_Repository.Put_Resource(),Put_Req_Repository.Put_Req_TC1());
	    System.out.println(ResponseBody);
	    
	    JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		String Res_createdAt = JspResponse.getString("createdAt");
		Res_createdAt = Res_createdAt.substring(0,11);

		Assert.assertEquals(Res_name,Res_name);
		Assert.assertEquals(Res_job,Res_job);
	}

}
