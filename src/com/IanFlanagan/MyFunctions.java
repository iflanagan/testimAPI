package com.IanFlanagan;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.IanFlanagan.Example.buildURL;

public class MyFunctions {

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


    public static String getTestList(String myToken, String urlType) {

        String myTests = "";

        try {

            System.out.println("Calling getTestList() method now");
            String myUrl = buildURL(urlType,"");

            URL obj = new URL(myUrl);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer " +myToken);
            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //  System.out.println(response.toString());
            myTests = response.toString();

        } catch (Exception ex) {

            System.out.println("Can't call the getTestList() method " +ex.getMessage());

        }
        System.out.println("My Tests are = " +myTests);
        return myTests;

    }

    public static String getBranches(String myToken, String urlType) {

        String myBranches = "";

        try {

            System.out.println("Calling getBranches() method now");
            String myUrl = buildURL(urlType,"");

            URL obj = new URL(myUrl);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer " +myToken);
            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //  System.out.println(response.toString());
            myBranches = response.toString();


        } catch (Exception ex) {

            System.out.println("Can't get the branches" +ex.getMessage());

        }

        System.out.println("My Branches are = " +myBranches);
        return myBranches;

    }


    public static void runTestByLabel(String token,String json, String myID) {

        String myUrl = buildURL(MyConfiguration.labelsRun,myID);

        try {

            URL url = new URL(myUrl);

            // Open a connection to the endpoint
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            con.setRequestMethod("POST");

            // Add the bearer token to the Authorization header
            con.setRequestProperty("Authorization", "Bearer " +token);
            con.setRequestProperty("Branch", "Master");
            con.setRequestProperty("Content-Type", "application/json; charset=utf-8");

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

        } catch (Exception ex) {
            System.out.println("Can't call runTestByLabel() method " +ex.getStackTrace());
        }
    }

    public static void runTestByID(String requestType,String json, String myID) {

        String myUrl = buildURL(MyConfiguration.runTestByID,myID);

        try {

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
          //  String json = "{ \"branch\":\"master\",\"grid\":\"TESTIM-GRID\",\"parallel\":\"1\",\"retries\":\"0\",\"timeout\":\"600\",\"turboMode\":\"true\" }";

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

        } catch (Exception ex) {
            System.out.println("Can't call runTestbyID() method " +ex.getStackTrace());
        }
    }

}
