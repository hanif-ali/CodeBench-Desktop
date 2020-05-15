package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.json.JSONException;


import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

import static javafx.scene.paint.Color.rgb;

public class Translate implements Initializable {
    Stage primaryStage;
    String type;
    Translate(){
        this(null);
    }
    Translate(Stage primaryStage){
        this.primaryStage=primaryStage;

    }
    static int no=0;
    @FXML
    private Label lab1;
    @FXML
    private Label lab2;
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private AnchorPane teacherparent;
    @FXML
    private AnchorPane side;

    @FXML
    private Pane removableteacher;
    @FXML
    private Button teach;
    @FXML
    private Button student;
    String sideofblock;
    @FXML Button login;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        type="admin";


        login.setBackground(new Background(new BackgroundFill(rgb(19,0,73),new CornerRadii(10),null)));
        login.setStyle("-fx-text-fill: white");





        student.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num=0;
                lab1.setBackground(new Background(new BackgroundFill(rgb(46,188,253),null,null)));
                lab2.setBackground(new Background(new BackgroundFill(rgb(46,188,253),null,null)));
                lab1.setStyle("-fx-text-fill: black");
                lab2.setStyle("-fx-text-fill: black");
                for (int i=0;i<=2;i++){
                login.setBackground(new Background(new BackgroundFill(rgb(46,188,253),new CornerRadii(10),null)));
                login.setStyle("-fx-text-fill: black");}

                type="student";
                TranslateTransition slide = new TranslateTransition();
                slide.setDuration(Duration.seconds(0.15));
                slide.setNode(side);

                slide.setToX(427);
                slide.play();
                removableteacher.setTranslateX(-226);
                slide.setOnFinished((e->{


                }));


            }
        });
        teach.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int num=0;

                lab1.setBackground(new Background(new BackgroundFill(rgb(19,0,73),null,null)));
                lab2.setBackground(new Background(new BackgroundFill(rgb(19,0,73),null,null)));
                lab1.setStyle("-fx-text-fill: white");
                lab2.setStyle("-fx-text-fill: white");
                login.setBackground(new Background(new BackgroundFill(rgb(19,0,73),new CornerRadii(10),null)));
                login.setStyle("-fx-text-fill: white");
                type="admin";
                TranslateTransition slide = new TranslateTransition();
                slide.setDuration(Duration.seconds(0.15));
                slide.setNode(side);

                slide.setToX(0);
                slide.play();
                removableteacher.setTranslateX(0);
                slide.setOnFinished((e->{


                }));

            }});

     login.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {


             try {
                 Auth mylogin = new Auth(user.getText(), pass.getText(), type, primaryStage,"login");
                 mylogin.authenticate();

             } catch (IOException | JSONException e) {
                 e.printStackTrace();
             } }
     });
    }




}
