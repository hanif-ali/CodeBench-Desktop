package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class teacherinter implements Initializable {
    JSONObject js;
    FXMLLoader mainborder;
    Stage primaryStage;
    String token;
    teacherinter(){
        this(null,null,null,null);
    }

    teacherinter(Stage pm,JSONObject js,FXMLLoader mainborder,String token){
        this.js=js;
        this.token=token;
        this.primaryStage=pm;
        this.mainborder=mainborder;
    }
    @FXML
    BorderPane borderpane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("testing.fxml"));
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("centerteacher.fxml"));
        loader.setControllerFactory(t ->new Panel(primaryStage,js,loader2,loader,borderpane,mainborder,token));
        loader2.setControllerFactory(t ->new centerteacher(token));

        try {
            Parent root2=loader2.load();
            borderpane.setCenter(root2);
            Parent root=loader.load();
            borderpane.setLeft(root);
            primaryStage.setScene(new Scene(borderpane));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
