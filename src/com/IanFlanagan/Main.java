package com.IanFlanagan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

      //  MyFunctions.getBranches(MyConfiguration.myToken, "branches");
        String myresults = MyFunctions.getTestList(MyConfiguration.myToken, (MyConfiguration.testList));

        String values [] = myresults.split(" , ");
        String regex = "\"_id\":\"(\\w+)\"";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(myresults);

        // extract the test case ID from the string, remove double quotes

        while (matcher.find()) {
            String str = matcher.group();
            str = str.substring(str.indexOf(":") + 1).trim();
            str = str.substring(1, str.length() - 1);
            StringBuilder myTestURL = (new StringBuilder()).append("https://app.testim.io/#/project/"+MyConfiguration.myProjectID+"").append(str);
            System.out.println(myTestURL);
            //  System.out.println(str);

        }

        String json = "{ \"branch\":\"master\",\"grid\":\"TESTIM-GRID\",\"parallel\":\"1\",\"retries\":\"0\",\"timeout\":\"600\",\"turboMode\":\"true\" }";
     //   MyFunctions.runTestByID("POST", json,"YSgnxXzYp8cPQ0xj");
       // String jsonLabel = "{ \"baseUrl\":\"http://demo.testim.io/\",\"branch\":\"master\",\"grid\":\"TESTIM-GRID\",\"parallel\":\"1\",\"retries\":\"0\",\"timeout\":\"600\",\"turboMode\":\"true\" }";
       // MyFunctions.runTestByLabel(MyConfiguration.myToken, jsonLabel, "qTest");
        //String myUrl = MyFunctions.buildURL(MyConfiguration.testList,"");


    }
}
