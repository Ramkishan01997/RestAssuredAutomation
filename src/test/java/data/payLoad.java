package data;

public class payLoad {
	
	public static String addplace() {
		String data="{\"location\":{\r\n"
				+ "        \"lat\":-38.383494,\r\n"
				+ "        \"lng\":33.427262\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\":50,\r\n"
				+ "    \"name\":\"Frontline house\",\r\n"
				+ "    \"phone_number\":\"(+91) 9838933937\",\r\n"
				+ "    \"address\":\"29, side layout, cohen 09\",\r\n"
				+ "    \"types\":[\r\n"
				+ "        \"shoe park\",\r\n"
				+ "        \"shop\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\":\"http://google.com\",\r\n"
				+ "    \"language\":\"French-IN\"\r\n"
				+ "}";
		return data;
		
	}
	public static String updateplace="{\r\n"
			+ "\"place_id\":\"988a1454f3cf056bd95eba9fdbb7ff0e\",\r\n"
			+ "\"address\":\"29, tttt side layout, cohen 09\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}";
	public static String dummydata="{\r\n"
			+ "\r\n"
			+ "\"dashboard\": {\r\n"
			+ "\r\n"
			+ "\"purchaseAmount\": 910,\r\n"
			+ "\r\n"
			+ "\"website\": \"rahulshettyacademy.com\"\r\n"
			+ "\r\n"
			+ "},\r\n"
			+ "\r\n"
			+ "\"courses\": [\r\n"
			+ "\r\n"
			+ "{\r\n"
			+ "\r\n"
			+ "\"title\": \"Selenium Python\",\r\n"
			+ "\r\n"
			+ "\"price\": 50,\r\n"
			+ "\r\n"
			+ "\"copies\": 6\r\n"
			+ "\r\n"
			+ "},\r\n"
			+ "\r\n"
			+ "{\r\n"
			+ "\r\n"
			+ "\"title\": \"Cypress\",\r\n"
			+ "\r\n"
			+ "\"price\": 40,\r\n"
			+ "\r\n"
			+ "\"copies\": 4\r\n"
			+ "\r\n"
			+ "},\r\n"
			+ "\r\n"
			+ "{\r\n"
			+ "\r\n"
			+ "\"title\": \"RPA\",\r\n"
			+ "\r\n"
			+ "\"price\": 45,\r\n"
			+ "\r\n"
			+ "\"copies\": 10\r\n"
			+ "\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ "]\r\n"
			+ "\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "1. Print No of courses returned by API\r\n"
			+ "\r\n"
			+ "2.Print Purchase Amount\r\n"
			+ "\r\n"
			+ "3. Print Title of the first course\r\n"
			+ "\r\n"
			+ "4. Print All course titles and their respective Prices\r\n"
			+ "\r\n"
			+ "5. Print no of copies sold by RPA Course\r\n"
			+ "\r\n"
			+ "6. Verify if Sum of all Course prices matches with Purchase Amount\r\n"
			+ "\r\n"
			+ "";
	public static String bookpayload(String isbn,String aisle) {
		String payload="{\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foer\"\r\n"
				+ "}";
				return payload;
		
	}
	
	public String jirausercredentaial="{\r\n"
			+ "    \"username\":\"manav9545714224\",\"password\":\"Ram@1997\"\r\n"
			+ "}";
	public String issuedetails="{\r\n"
			+ "    \"fields\":{\r\n"
			+ "        \"project\":\r\n"
			+ "        {\r\n"
			+ "            \"key\":\"TES\"\r\n"
			+ "        },\r\n"
			+ "        \"summary\":\"issue in generating new log file\",\r\n"
			+ "        \"description\":\"add and correct log 4 j\",\r\n"
			+ "        \"issuetype\":{\r\n"
			+ "            \"name\":\"Bug\"\r\n"
			+ "        }\r\n"
			+ "    }\r\n"
			+ "}";
	/*public void getplace() {
		System.out.println(url);
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given()
		.queryParam("place_id", "bf809a0d2191cdd5bcbe1f9d2b7edd27")
		.queryParam("key","qaclick123")
		.when().get("/maps/api/place/get/json")
		.then().log().all();
//		.body("name", equalTo("Frontline house"))
//		.assertThat().statusCode(200);
		
	}*/

}
