package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.rgb;

public class Both2Cont implements Initializable {
    String type;

    Both2Cont(){
        this(null);
    }
    Both2Cont(Stage myStage){
        this.primaryStage=myStage;

    }
    @FXML
    private Label lab1;
    @FXML
    private Label lab2;
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private Pane studentside;
    @FXML
    private Pane removablestudent;
    @FXML
    private Button teach;
    @FXML
    private Button student;
    @FXML
    Button login;
    private Stage primaryStage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        type="student";

        login.setBackground(new Background(new BackgroundFill(rgb(46,188,253),new CornerRadii(10),null)));
        login.setStyle("-fx-text-fill: black");





        teach.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                lab1.setBackground(new Background(new BackgroundFill(rgb(19,0,73),null,null)));
                lab2.setBackground(new Background(new BackgroundFill(rgb(19,0,73),null,null)));
                lab1.setStyle("-fx-text-fill: white");
                lab2.setStyle("-fx-text-fill: white");
                login.setBackground(new Background(new BackgroundFill(rgb(19,0,73),new CornerRadii(10),null)));
                login.setStyle("-fx-text-fill: white");

                                  type="admin";

                                  TranslateTransition slide = new TranslateTransition();
                                  slide.setDuration(Duration.seconds(0.15));
                                  slide.setNode(removablestudent);

                                  slide.setToX(226);
                                  slide.play();
                                  studentside.setTranslateX(-427);
                                  slide.setOnFinished((e->{


                                  }));

                              }
                          }
        );
        student.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                type="student";
                TranslateTransition slide = new TranslateTransition();
                slide.setDuration(Duration.seconds(0.15));
                slide.setNode(removablestudent);

                slide.setToX(0);
                slide.play();
                studentside.setTranslateX(0);
                slide.setOnFinished((e->{


                }));
                lab1.setBackground(new Background(new BackgroundFill(rgb(46,188,253),null,null)));
                lab2.setBackground(new Background(new BackgroundFill(rgb(46,188,253),null,null)));
                lab1.setStyle("-fx-text-fill: black");
                lab2.setStyle("-fx-text-fill: black");
               login.setBackground(new Background(new BackgroundFill(rgb(46,188,253), new CornerRadii(10),null)));
                login.setStyle("-fx-text-fill: black");
            }
        });
        login.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {


          try {
                    Auth mylogin = new Auth(user.getText(), pass.getText(), type, primaryStage,"login");
                    mylogin.authenticate();
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }


            }
        });
    }


}
