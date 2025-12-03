package com.sgtesting.RahulShetty;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TotalAmount {
    @Test
   public void amountFound(){
        JsonPath js=new JsonPath(getAddress.getBookPrice());
        int count =js.getInt("courses.size()");
        int total=0;
        for(int i=0;i<count;i++){
            int price=js.getInt("courses["+i+"].price");
            int copies=js.getInt("courses["+i+"].copies");
            int amount=price*copies;
            System.out.println(amount);
            total+=amount;

        }
        System.out.println("in sub array total"+total);

        int inDashboard=js.getInt("dashboard.purchaseAmount");
        System.out.println("Indash board :"+inDashboard);
       Assert.assertEquals(total,inDashboard);

    }
}
