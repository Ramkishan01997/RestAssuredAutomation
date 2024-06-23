package data;

import io.restassured.path.json.JsonPath;

public class commonMethods {
	public static JsonPath rawjson(String res) {
		JsonPath js=new JsonPath(res);
		return js;
	}

}
