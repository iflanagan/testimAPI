package com.IanFlanagan;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import static com.IanFlanagan.Example.buildURL;

public class Demo {

    public static void main(String[] args) throws Exception {
        // Set the URL of the endpoint you want to send the request to


        String json = "{ \"branch\":\"master\",\"grid\":\"TESTIM-GRID\",\"parallel\":\"1\",\"retries\":\"0\",\"timeout\":\"600\",\"turboMode\":\"true\" }";
       // String myUrl = buildURL(MyConfiguration.runTestByID,"YSgnxXzYp8cPQ0xj");
        MyFunctions.runTestByID("POST", json,"YSgnxXzYp8cPQ0xj");
        // works

        /*
        URL url = new URL(myUrl);

        // Open a connection to the endpoint
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // Set the request method to POST
        con.setRequestMethod("POST");

        // Add the bearer token to the Authorization header
        con.setRequestProperty("Authorization", "Bearer " +MyConfiguration.myToken);
        con.setRequestProperty("Branch", "Master");
        con.setRequestProperty("Content-Type", "application/json; charset=utf-8");

        // Add the request body as a JSON string

        String json = "{ \"branch\":\"master\",\"grid\":\"TESTIM-GRID\",\"parallel\":\"1\",\"retries\":\"0\",\"timeout\":\"600\",\"turboMode\":\"true\" }";

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(json);
        out.flush();
        out.close();

        // Send the request and get the response
        int status = con.getResponseCode();
        System.out.println("Response code is = " +status);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        // Print the response
        System.out.println(status);
        System.out.println(content);

         */
    }
}