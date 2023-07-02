package Common_API_Methods;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class API_Methods {
	
	public static int ResponseStatusCode (String BaseURI , String Resource , String RequestBody) {
		
		RestAssured.baseURI = BaseURI;
		
		int StatusCode = given().header("Content-Type","application/json").body(RequestBody).
				when().post(Resource).then().extract().statusCode();
		return StatusCode;	
	}
	
    public static String ResponseBody (String BaseURI , String Resource , String RequestBody) {
		
		RestAssured.baseURI = BaseURI;
		
		String Responsebody = given().header("Content-Type","application/json").body(RequestBody).
				when().post(Resource).then().extract().response().asPrettyString();
		return Responsebody;
	}

}

