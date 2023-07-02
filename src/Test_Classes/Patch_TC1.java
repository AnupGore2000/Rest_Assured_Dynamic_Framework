package Test_Classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.Patch_API_Methods;
import RequestRepository.Patch_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Patch_TC1 {
	@Test
	    public static void extractor() {
		
		int statusCode =Patch_API_Methods.ResponseStatusCode(Patch_Req_Repository.BaseURI(),Patch_Req_Repository.Patch_Resource(),Patch_Req_Repository.Patch_Req_TC1());
	    System.out.println(statusCode);
	    String ResponseBody = Patch_API_Methods.ResponseBody(Patch_Req_Repository.BaseURI(),Patch_Req_Repository.Patch_Resource(),Patch_Req_Repository.Patch_Req_TC1());
	    System.out.println(ResponseBody);
	    
	    JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		String Res_createdAt = JspResponse.getString("updatedAt");
		Res_createdAt = Res_createdAt.substring(0,11);
		
		Assert.assertEquals(Res_name,Res_name);
		Assert.assertEquals(Res_job,Res_job);
	}

}
