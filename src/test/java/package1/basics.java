package package1;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import data.commonMethods;
import data.payLoad;
public class basics {
public static String url="https://rahulshettyacademy.com";
public static String placeid="";
public static String bookurl="https://rahulshettyacademy.com";
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String res=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payLoad.addplace())
		.when()
		.post("/maps/api/place/add/json").then().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("Server", equalTo("Apache/2.4.52 (Ubuntu)")).extract().response().asString();
		System.out.println(res);
		
		
//		JsonPath js=new JsonPath(res);
		JsonPath js=commonMethods.rawjson(res);
		System.out.println(js.getString("place_id"));
		placeid=js.getString("place_id");
		getplace();
		updateplace();
//		getplace();
		readjson();
	
	}
	
	static void getplace() {
	System.out.println(url);
	RestAssured.baseURI="https://rahulshettyacademy.com";
	given()
	.queryParam("place_id", placeid)
	.queryParam("key","qaclick123")
	.when().get("/maps/api/place/get/json")
	.then().log().all()
	.body("name", equalTo("Frontline house"))
	.assertThat().statusCode(200);
	
}
	static void updateplace() {
		RestAssured.baseURI=url;
		System.out.println("place id"+placeid);
		given().log().all().queryParam("place_id", placeid).queryParam("key", "qaclick123")
		.header("Content-Type","application/json").
		body(payLoad.updateplace).when().put("/maps/api/place/update/json").then().log()
.all();	}
	
	public static void readjson() {
		JsonPath js1=commonMethods.rawjson(payLoad.dummydata);
		int coursecount= js1.getInt("courses.size()");
		System.out.println("count od coyrse"+coursecount);
		System.out.println("amount: "+ js1.getInt("dashboard.purchaseAmount"));
		System.out.println("title: "+ js1.getString("courses[0].title"));
		System.out.println("title& amount: "+ js1.getString("courses[0].title")+" amount: "+js1.getInt("courses[0].price"));
	
	  for(int i=0;i<coursecount;i++) {
		  String cname=js1.getString("courses["+i+"].title");
		  int price=js1.getInt("courses["+i+"].price");
		  System.out.println("course name : "+cname+ " price: "+price);
		  
	  }
	}

}
