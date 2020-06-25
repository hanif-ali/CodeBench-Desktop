package sample;

//import javafx.application.Application;
//import javafx.application.Application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        scene.setFill(null);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();



    }

    public static void main(String[] args) {
       launch(args);
       Button b1=new Button();
    }
}
