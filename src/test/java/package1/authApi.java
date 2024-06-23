package package1;

import org.testng.annotations.Test;

import data.commonMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.api;
import pojo.getCourse;
import pojo.mobile;
import pojo.webAutomation;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class authApi extends commonMethods {
	String[] courseTitles= {"Selenium Webdriver Java","Cypress","Protractor"};
	
	@Test
	public void getAccessToken() {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String res=given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
	     .formParam("grant_type","client_credentials").formParam("scope","trust")
	     .when().post("/oauthapi/oauth2/resourceOwner/token").then().extract().response().asString();
		
		JsonPath js=rawjson(res);
		System.out.println("access"+js.getString("access_token"));
		Response res1=given().queryParam("access_token", js.getString("access_token")).when().get("/oauthapi/getCourseDetails");
		System.out.println(res1.then().log().all());
	}
@Test(priority=1)
    public void getjavaObject() {
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String res=given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
     .formParam("grant_type","client_credentials").formParam("scope","trust")
     .when().post("/oauthapi/oauth2/resourceOwner/token").then().extract().response().asString();
	
	JsonPath js=rawjson(res);
	System.out.println("access"+js.getString("access_token"));
	getCourse gc=given().queryParam("access_token", js.getString("access_token"))
			.when().get("/oauthapi/getCourseDetails").as(getCourse.class);
	System.out.println(gc.getInstructor());
	System.out.println(gc.getUrl());
//	System.out.println(res1.then().log().all());
//	System.out.println(gc.getCourses().getApi().get(0).getPrice());
	List<mobile>apicourses=gc.getCourses().getMobile();
	for (int i=0;i<apicourses.size();i++) {
		System.out.println(apicourses.get(i).getPrice());
		apicourses.get(i).getCourseTitle();
		System.out.println("title"+apicourses.get(i).getCourseTitle());
	}
	List<webAutomation>wc=gc.getCourses().getWebAutomation();
	ArrayList<String>alist=new ArrayList<String>();
	
	for(webAutomation x:wc) {
		System.out.println("titlewebautomation"+x.getCourseTitle());
		alist.add(x.getCourseTitle());
		if(x.getCourseTitle().equals("Cypress")) {
			System.out.println(x.getPrice());
		}
		System.out.println(alist);
		
	}
	List<String>exp=Arrays.asList(courseTitles);
	if(alist.equals(exp)) {
		System.out.println("both arrays are equals");
	}
}
}
