package sample;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JavaGet {
    private static String route;
    private String token;
    JavaGet(String route,String token){
        this.route=route;
        this.token=token;
    }

    public String authGet(){
        try {

            String url = "http://127.0.0.1:5000/"+route;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            //con.setRequestProperty("Authorization", "Bearer " + token);
            //int responseCode = con.getResponseCode();
            con.setRequestMethod("GET");
           // con.setRequestProperty("Authorization", "Bearer " + token);
            con.setRequestProperty("Authorization", "Bearer " + token);
            BufferedReader in =new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            } in .close();
            //JSONObject json=new JSONObject(response.toString());
            //System.out.println(json.toString());
            System.out.println(response.toString());
            return response.toString();


    } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
