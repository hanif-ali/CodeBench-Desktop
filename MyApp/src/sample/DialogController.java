package sample;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DialogController  implements Initializable {
    @FXML
    private Button return1;
    @FXML
    private Button addTest;

    @FXML
    private Rectangle head;

    @FXML
    private Rectangle smallRect;
    @FXML
    private Label addLabel;
    @FXML
    private Label visibleLabel;
    @FXML
    private ToggleButton tButt;
    @FXML
    private Label label2;
    @FXML
    private Label label1;
    @FXML
    private TextArea tab1;
    @FXML
    private TextArea tab2;
    @FXML
    public Label header;
    @FXML
    public Label detail;
    @FXML
    public DialogPane dp;






    @FXML
    public void quit2(){
        Stage stage = (Stage) return1.getScene().getWindow();
        popup(return1,120);
        stage.close();
    }

    FXMLLoader fx;
    testcases t1;
    int index;

    DialogController(){
        this(null,0);

    }
    DialogController(FXMLLoader fx,int num){

    this.fx=fx;
    this.index=num;
    t1= fx.getController();
}


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        addTest.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String in=getInt();
                String out=getOut();
                if(in.equals("")||out.equals("")){
                    System.out.println("Please enter valid input in the fields");
                }
                else {
                    JSONObject obj=new JSONObject();
                    try {
                        obj.put("input",in);
                        obj.put("output",out);
                        t1.addingTest(obj,index);
                }   catch (JSONException e) {
                        e.printStackTrace();
                }

                    Stage stage = (Stage) return1.getScene().getWindow();
                    popup(return1,120);
                    stage.close();
            }}
        });


        ScaleX(tab1,500,2,1,false,1,0);
        ScaleX(tab2,500,2,1,false,1,0);
        Vanish(label1,500);
        Vanish(label2,500);
        FadeIn(label1,500,500);
        FadeIn(label2,500,500);
        LinearMoveY(return1,750,500,0,0);
        LinearMoveY(addTest,750,500,0,0);
        LinearMoveY(head,500,-200,0,0);
        Vanish(smallRect,250);
        FadeIn(smallRect,50,250);
        LinearMoveY(smallRect,750,-200,0,250);
        Vanish(addLabel,500);
        Vanish(visibleLabel,100);
        Vanish(tButt,500);
        FadeIn(addLabel,500,500);
        FadeIn(visibleLabel,500,500);
        FadeIn(tButt,500,500);

    }



    public void popup(Node node, int duration){

        Scale(node,duration,0,1.2,true,1,0);
        Scale(node,duration,1.2,1,true,1,duration);


    }
    public void popup(Node node, int duration,int delay){

        Scale(node,duration,0,1.2,true,1,delay);
        Scale(node,duration,1.2,1,true,1,duration+delay);


    }

    public void Scale(Node node, int duration, double from, double to,boolean repeat,int cycles,int delay){

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDuration(Duration.millis(duration));
        scale.setFromX(from);
        scale.setFromY(from);
        scale.setToX(to);
        scale.setToY(to);
        scale.setCycleCount(cycles);
        scale.setDelay(Duration.millis(delay));
        scale.setAutoReverse(repeat);
        scale.play();
    }

    public void ScaleY(Node node, int duration, double from, double to, int delay){

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDuration(Duration.millis(duration));
        scale.setFromY(from);
        scale.setToY(to);
        scale.setCycleCount(Animation.INDEFINITE);
        scale.setAutoReverse(true);
        scale.setDelay(Duration.millis(delay));
        scale.play();
    }

    public void FadeIn(Node node, int duration, int delay){

        FadeTransition fade = new FadeTransition();
        fade.setNode(node);
        fade.setDuration(Duration.millis(duration));
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.setDelay(Duration.millis(delay));
        fade.play();

    }

    public void Vanish(Node node, int duration){

        FadeTransition fade = new FadeTransition();
        fade.setNode(node);
        fade.setDuration(Duration.millis(duration));
        fade.setFromValue(0);
        fade.setToValue(0);
        fade.play();

    }

    public void ScaleX(Node node, int duration, double from, double to, int delay){

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDuration(Duration.millis(duration));
        scale.setFromX(from);
        scale.setToX(to);
        scale.setCycleCount(Animation.INDEFINITE);
        scale.setAutoReverse(true);
        scale.setDelay(Duration.millis(delay));
        scale.play();


    }

    public void ScaleX(Node node, int duration, int from, int to,boolean repeat,int cycles,int delay){

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDuration(Duration.millis(duration));
        scale.setFromX(from);
        scale.setToX(to);
        scale.setCycleCount(cycles);
        scale.setDelay(Duration.millis(delay));
        scale.setAutoReverse(repeat);
        scale.play();


    }

    public void LinearMoveY(Node node, int duration, int from, int to , int delay ){

        TranslateTransition move = new TranslateTransition();
        move.setNode(node);
        move.setDuration(Duration.millis(duration));
        move.setFromY(from);
        move.setToY(to);
        move.setCycleCount(1);
        move.setAutoReverse(false);
        move.setDelay(Duration.millis(delay));
        move.play();


    }
    public String getInt(){
        return tab1.getText();
    }
    public String getOut(){
        return tab2.getText();
    }
    public void setInt(String in){
        tab1.setText(in);
    }

    public  void setOut(String out){
        tab2.setText(out);
    }

}
