package sample;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

public class UserAuth {

    private String route;
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    JSONObject jsonObject = new JSONObject();
    UserAuth(String route){
        this.route=route;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }


    public  JSONObject auth(JSONObject jsonObject) throws IOException {
        this.jsonObject=jsonObject;

        URL url2 = new URL("http://127.0.0.1:5000/"+route);
        //URL url2=new URL("http://c95eac32-0eb0-4854-bdf8-81dbe49655b1.mock.pstmn.io/"+route);

        HttpURLConnection con = (HttpURLConnection)url2.openConnection();
        if(accessToken!=null){
        con.setRequestProperty("Authorization", "Bearer " + accessToken);}
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        String send=jsonObject.toString();
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = send.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }


            JSONObject json=new JSONObject(response.toString());
            System.out.println(json.toString());
            return json;
        } catch ( IOException | JSONException e) {
            e.printStackTrace();
            return null;
        }


    }


}
