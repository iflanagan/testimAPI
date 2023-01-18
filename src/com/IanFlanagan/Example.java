package com.IanFlanagan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Example {

    public static void main(String[] args) {

       // String url = buildURL(MyConfiguration.runsExecutions,"RHuDFhVRY6EV97eo");
        connectAPITest("POST",MyConfiguration.myToken, buildURL(MyConfiguration.suiteByIDRun,"F8R4j64503DsSDU7"));

    }

    public static String buildURL(String myShortURL,String data)   {

        String myURL = null;

        if(data != null && !data.trim().isEmpty()) {

            // data is defined
            System.out.println("Data is defined lets build that URL!");

            try {
                myURL =(new StringBuilder()).append(MyConfiguration.baseURL).append(myShortURL).append(data).toString();
                // System.out.println("My new URL is = " +myURL);
            }
            catch (Exception ex) {
                System.out.println("Can't build URL " +ex.getMessage());
            }
        }
        else {

            System.out.println("Data is not defined");
            System.out.println("Data is defined lets build that URL!");
            try {
                myURL =(new StringBuilder()).append(MyConfiguration.baseURL).append(myShortURL).append(data).toString();
                // System.out.println("My new URL is = " +myURL);
            }
            catch (Exception ex) {
                System.out.println("Can't build URL " +ex.getMessage());
            }

        }
        System.out.println("URL is = " +myURL);
        return myURL;
    }


    public static String connectAPITest(String operationType,String myToken, String url) {

        // GET POST PUT DELETE HEAD OPERATIONS PATCH

        System.out.printf("calling API connect test Operation type = " +operationType+ " token =  " +myToken+ " url =  "  +url);
        System.out.println("\n");

        String returnedData = "";

        try {

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod(operationType);
            con.setRequestProperty("Authorization", "Bearer " +myToken);
            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            System.out.println("Connection values is = " +con);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
            returnedData = response.toString();

        } catch (Exception ex) {
            System.out.println("Can't connect " +ex.getStackTrace());
        }
        System.out.println("Data is = " +returnedData);
        return returnedData;
    }

}
