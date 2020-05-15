package sample;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    Stage myStage;
    Controller(){
        this(null);
    }
    Controller(Stage myStage){
        this.myStage=myStage;
    }



@FXML
private Button std;
@FXML
private AnchorPane apane;
@FXML
private Button teach;


public void onStudent(ActionEvent actionEvent){


}
public void onTeacher(ActionEvent actionEvent){
    System.out.println("I am a teacher");

}
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    std.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {



            FXMLLoader loader = new FXMLLoader(getClass().getResource("Both2.fxml"));
            loader.setControllerFactory(t ->new Both2Cont(myStage));
            try {

                Stage stage = new Stage();
                AnchorPane mine=new AnchorPane();
                mine=loader.load();
                myStage.setScene(new Scene(mine));


            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    });
    teach.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Both.fxml"));
            loader.setControllerFactory(t -> new Translate(myStage));
            try {


                AnchorPane mine=new AnchorPane();
                mine=loader.load();
                myStage.setScene(new Scene(mine));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });


    }

}
