package com.sgtesting.RahulShetty;

import io.restassured.path.json.JsonPath;

public class ComplexJasonParse {
    public static void main(String[] args) {
        JsonPath js=new JsonPath(getAddress.getBookPrice());
       int count=js.getInt("courses.size()");
//        System.out.println(count);
//
////       int toalamount= js.getInt("dashboard.purchaseAmount");
////        System.out.println(toalamount);
////
////        String firstTitle=js.getString("courses.title[0]");
////        System.out.println(firstTitle);
////        String secondTitle=js.getString("courses.title[2]");
////        System.out.println(secondTitle);
////
////        for(int i=0;i<count;i++){
////            String CousrseTitles=js.get("courses["+i+"].title");
////            System.out.println(CousrseTitles);
////            //js.get("courses["+i+"].title").toString()
////            int amount=js.getInt("courses["+i+"].price");
////            System.out.println(amount+" ");
////            int copies=js.getInt("courses["+i+"].copies");
////            System.out.println(copies);
//////js.get("courses.title[i]");
////        }
////for(int i=0;i<count;i++){
////    String insidetitel=js.getString("courses["+i+"].title");
////    if(insidetitel.equalsIgnoreCase("RPA")){
////        System.out.println(js.getInt("courses["+i+"].copies"));
////        break;
////    }
////}



    }
}
