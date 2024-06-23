package package1;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import data.commonMethods;
import data.payLoad;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;

public class jiraApi extends payLoad {

//	public  void JSONObject() {
//		JsonObject js=new JsonObject();
//		js.put("username","manav9545714224");
//		js.put();
//		js.add(username,"manav9545714224");
//	}
	public String cookie="";
	@Test(priority=0)
	public void getauthCookies() {
		RestAssured.baseURI="http://localhost:8080/rest";
		Response res=given().log().all().body(jirausercredentaial).contentType("application/json")
		.when().post("/auth/1/session");
		JsonPath js=commonMethods.rawjson(res.asString());
		res.then().log().all();
		System.out.println("code"+res.getStatusCode());
		System.out.println("cookies: "+js.getString("session.value"));
		cookie=js.getString("session.value");
	}
	
//	@Test(priority=1)
	public void createIssue() {
		
		RestAssured.baseURI="http://localhost:8080/rest";
		System.out.println(cookie);
		Response res=given().log().all().header("Cookie",cookie).contentType("application/json").body(issuedetails).
				when().post("/api/2/issue");
		JsonPath js=commonMethods.rawjson(res.asString());
		res.then().log().all();
	}
//	@Test(priority=2)
	public void addComment() {
		SessionFilter session=new SessionFilter();
		RestAssured.baseURI="http://localhost:8080/rest";
		String res=given().log().all().body(jirausercredentaial).contentType("application/json")
				.when().post("/auth/1/session").then().extract().response().asString();
		System.out.println(res);
		System.out.println("session"+session);
		given().pathParam("id", "10103").log().all()
		.contentType("application/json")
		.body("{\r\n"
				+ "    \"body\":\"My own comment updated here \",\r\n"
				+ "    \"visibility\":{\r\n"
				+ "        \"type\":\"role\",\r\n"
				+ "        \"value\":\"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session).when().post("/api/2/issue/{id}/comment").then().log().all();
		System.out.println("session"+session);
	}
//	@Test(priority=3)
	public void addFileinJira() {
		RestAssured.baseURI="http://localhost:8080/rest";
		String res1=given().log().all().header("X-Atlassian-Token","no-check")
		.header("Cookie","64008781A57A38EF4054F6840FF6B418")
		.header("Content-Type","multipart/form-data")
		.pathParam("key", "10103")
		.multiPart("file",new File("test.txt")).when()
		.post("/api/2/issue/{key}/attachments").then().extract().response().asString();
	System.out.println(res1);
	}
	@Test(priority=4)
	public void getissue() {
		RestAssured.baseURI="http://localhost:8080/rest";
//		String res1=
	
				Response res=given().log().all()
				.header("Cookie","JSESSIONIDF304886865101DF43A830A7E51EFAA49")
	          .pathParam("key", "10104")
	          .queryParam("fields", "issuetype").when().get("/api/2/issue/{key}");
	          
	          res.then().log().all().assertThat().statusCode(200);
//		System.out.println(res1);
	}
	
}
