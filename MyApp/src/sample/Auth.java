package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import org.json.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class Auth {
    String user_name;
    String password;
    Stage myStage;
    String type;
    String route;


    Auth(String user_name,String password,String type,Stage myStage,String route){
        this.user_name=user_name;
        this.password=password;
        this.type=type;
        this.myStage=myStage;
        this.route=route;
    }


    public void authenticate() throws IOException, JSONException {
        JSONObject myJson = new JSONObject();
        myJson.put("email", user_name);
        myJson.put("password", password);
        myJson.put("mode", type);
        System.out.println(type);
        System.out.println(user_name);
        System.out.println(password);

        UserAuth login = new UserAuth(route);
        JSONObject js = login.auth(myJson);

        String value = (String) js.get("status");


        if (value.equals("success")) {
            if (type.equals("admin")) {
                Getters g1 = new Getters();
                String token = (String) js.get("access_token");
                JSONObject detail = g1.adDetails(token);
                FXMLLoader load = new FXMLLoader(getClass().getResource("tester.fxml"));
                load.setControllerFactory(t -> new teacherinter(myStage, detail, load, token));
                BorderPane b1 = load.load();
                try {
                    myStage.setScene(new Scene(b1));
                }
                catch (IllegalArgumentException e){

                }

            } else {


                Getters g1 = new Getters();
                String token = (String) js.get("access_token");
                JSONObject detail = g1.detailsStudent(token);
                FXMLLoader load = new FXMLLoader(getClass().getResource("studentBlank.fxml"));
                load.setControllerFactory(t -> new StudentBlank(myStage, detail, load, token));
                BorderPane b1 = load.load();
                try{
                myStage.setScene(new Scene(b1));}
                catch(IllegalArgumentException e){

                }
            }
        }

        else if(value.equals("denied")){
            String description=(String)js.get("description");
            System.out.println(description);
        }


        else {
            String description=(String)js.get("description");
            System.out.println(description);
        }
    }


}
