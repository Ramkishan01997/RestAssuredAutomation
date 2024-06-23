package package1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.commonMethods;
import data.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class dynamicJson extends basics {
	
	
	@Test(dataProvider="booksdata")
	public void addBook(String isbm,String isbl) {
		RestAssured.baseURI=bookurl;
		
		Response response=given().header("Content-Type","Text/plain").body(payLoad.bookpayload(isbm,isbl))
		.when().post("/Library/Addbook.php");
		String res=response.asString();
		JsonPath js=commonMethods.rawjson(res);
		String id=js.get("ID");
		response.then().log().all();
		System.out.println(id);
	}
	@DataProvider(name="booksdata")
	@Test
	public Object[][] getData() {
		
		return new Object[][] {{"test1","test345"},{"test23","6778"},{"python","9000"}};
	 
	}
//R
}
