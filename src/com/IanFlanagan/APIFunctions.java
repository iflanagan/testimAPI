package com.IanFlanagan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIFunctions {

public static final String baseURL = "https://api.testim.io/";
public static final String baseURLLabels = "https://api.testim.io/labels/run/";



    public static String buildURLGeneric(String baseURL, String myString)   {

        String myURL = null;

        try {
            myURL =(new StringBuilder()).append(baseURLLabels).append(myString).toString();
            // System.out.println("My new URL is = " +myURL);
        }
        catch (Exception ex) {
            System.out.println("Can't build URL " +ex.getMessage());
        }

        return myURL;
    }

    public static String buildURLLabels(String myLabel)   {

        String myURL = null;

        try {
            myURL =(new StringBuilder()).append(baseURLLabels).append(myLabel).toString();
            // System.out.println("My new URL is = " +myURL);
        }
        catch (Exception ex) {
            System.out.println("Can't build URL " +ex.getMessage());
        }

        return myURL;
    }



public static String buildURL(String myShortURL)   {

    String myURL = null;

    try {
        myURL =(new StringBuilder()).append(baseURL).append(myShortURL).toString();
       // System.out.println("My new URL is = " +myURL);
    }
    catch (Exception ex) {
        System.out.println("Can't build URL " +ex.getMessage());
    }

    return myURL;
}

public static void getResultsbyID() {

    try

    {

    } catch (Exception ex) {
        System.out.println("Can't call function getResultsbyID()  " +ex.getMessage());
    }

    System.out.println("Results are ");
}

public static String connectAPI(String operationType,String myToken, String urlType) {

    // GET POST PUT DELETE HEAD OPERATIONS PATCH
    String url = APIFunctions.buildURL(urlType);
    String returnedData = "";

    try {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(operationType);
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
        System.out.println(response.toString());
        returnedData = response.toString();

    } catch (Exception ex) {
        System.out.println("Can't connect " +ex.getMessage());
    }

    return returnedData;
}

public static String getBranches(String myToken, String urlType) {

    String myBranches = "";

    try {

        System.out.println("Calling getBranches() method now");

        String url = APIFunctions.buildURL(urlType);
       // String url = "https://api.testim.io/branches";

        URL obj = new URL(url);
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
    public static String getBranchesExample(String oppType, String myToken, String urlType) {

        String myBranches = "";
        String myResult = null;

        try {

            System.out.println("Calling getBranches() method now");
            String url = APIFunctions.buildURL(urlType);
            myResult = connectAPI(oppType,myToken,urlType);

        } catch (Exception ex) {

            System.out.println("Can't get the branches" +ex.getMessage());

        }

        System.out.println("My Branches are = " +myResult);
        return myBranches;

    }
    public static String runTestsWithLabel(String oppType, String myToken, String urlType) {

        String myBranches = "";
        String myResult = null;

        try {

            System.out.println("Calling runTestsWithLabel() method now");
            String url = APIFunctions.buildURL(urlType);
            myResult = connectAPI(oppType,myToken,urlType);

        } catch (Exception ex) {

            System.out.println("Can't execute runTestsWithLabel() method now" +ex.getMessage());

        }

        System.out.println("My results are = " +myResult);
        return myBranches;

    }
    public static String runTestsByID(String oppType, String myToken, String urlType) {

        String myBranches = "";
        String myResult = null;

        try {

            System.out.println("Calling runTestsWithLabel() method now");
            String url = APIFunctions.buildURL(urlType);
            myResult = connectAPI(oppType,myToken,urlType);

        } catch (Exception ex) {

            System.out.println("Can't execute runTestsWithLabel() method now" +ex.getMessage());

        }

        System.out.println("My results are = " +myResult);
        return myBranches;

    }


    public static String connectAPITest(String operationType,String myToken, String urlType) {

        // GET POST PUT DELETE HEAD OPERATIONS PATCH
        String url = APIFunctions.buildURL(urlType);
        String returnedData = "";

        try {

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod(operationType);
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
            System.out.println(response.toString());
            returnedData = response.toString();

        } catch (Exception ex) {
            System.out.println("Can't connect " +ex.getMessage());
        }

        return returnedData;
    }

}
