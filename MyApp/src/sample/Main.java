package sample;

//import javafx.application.Application;
//import javafx.application.Application;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.jfoenix.controls.*;
import  com.jfoenix.transitions.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        loader.setControllerFactory(t ->new Controller(primaryStage));
        //loader.setControllerFactory(t -> new Controller(primaryStage));
        //Button b1= (Button) loader.getNamespace().get("teach");
        AnchorPane root;
        root=loader.load();
        primaryStage.setTitle("Code Bench");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public static void main(String[] args) {
       launch(args);
       Button b1=new Button();
    }
}
