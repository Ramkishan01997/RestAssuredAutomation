package package1;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.commonMethods;
import data.payLoad;
import io.restassured.path.json.JsonPath;

public class sumValidation {
	
	@Test
	public void validateallPrice() {
		JsonPath js=new JsonPath(payLoad.dummydata);
		int count=js.getInt("courses.size()");
		int totalprice=0;
		for(int i=0;i<count;i++) {
			int price=js.getInt("courses["+i+"].price");
			int qnt=js.getInt("courses["+i+"].copies");
			int tprice=price*qnt;
			totalprice=totalprice+tprice;
			
		}
		System.out.println(totalprice);
		Assert.assertEquals(totalprice, js.getInt("dashboard.purchaseAmount"));
		
		
	}

}
