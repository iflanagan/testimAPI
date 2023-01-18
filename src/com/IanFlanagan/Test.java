package com.IanFlanagan;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {


        String input = "tests\":[{\"_id\":\"05vnUYBnKW1ilIz3\",\"name\":\"Test1\"},{\"_id\":\"05vnUYBnKW1ilIFF\",\"name\":\"Test2\"}";

        String values [] = input.split(" , ");
        String regex = "\"_id\":\"(\\w+)\"";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String str = matcher.group();
            str = str.substring(str.indexOf(":") + 1).trim();
            str = str.substring(1, str.length() - 1);
            StringBuilder myTestURL = (new StringBuilder()).append("https://app.testim.io/#/project/yUHggaUM53fuXM0PejOu/branch/master/test/").append(str);
            System.out.println(myTestURL);
          //  System.out.println(str);

        }


    }
}
