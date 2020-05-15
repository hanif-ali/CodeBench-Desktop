package sample;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ResourceBundle;

public class Dialog2Controller implements Initializable {
    JSONArray myjson;
    int index;
    Dialog2Controller(){

    }
    Dialog2Controller(JSONArray myjson, int index){
        this.myjson=myjson;
        this.index=index;
    }

    @FXML
    private Button return1;
    @FXML
    private Rectangle head;
    @FXML
    private Label addLabel;
    @FXML
    private TextArea eoutput;
    @FXML
    private TextArea output;
    @FXML
    private TextArea input;
    @FXML
    private Label label1;
    @FXML
    private Label label11;
    @FXML
    private Label label2;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        LinearMoveY(head,500,-200,0,0);
        FadeIn(addLabel,250,500);
        LinearMoveY(return1,500,200,0,0);
        ScaleX(input,750,2,1,0);
        LinearMoveX(output,750,500,0,0);
        LinearMoveX(eoutput,750,-500,0,0);
        FadeIn(label1,1000,500);
        FadeIn(label11,1000,500);
        FadeIn(label2,1000,500);

        try {
            eoutput.setText(myjson.getJSONObject(index).get("expected_output").toString());
            output.setText(myjson.getJSONObject(index).get("output").toString());
            input.setText(myjson.getJSONObject(index).get("expected_input").toString());

        }catch (JSONException e){
            e.printStackTrace();
        }





    }



        @FXML
    public void quit(){



        Stage stage = (Stage) return1.getScene().getWindow();

        stage.close();


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

    public void ScaleX(Node node, int duration, double from, double to, int delay){

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDuration(Duration.millis(duration));
        scale.setFromX(from);
        scale.setToX(to);
        scale.setDelay(Duration.millis(delay));
        scale.play();


    }

    public void FadeIn(Node node, int duration, int delay){

        Vanish(node,delay);
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

    public void LinearMoveX(Node node, int duration, int from, int to ,int delay ){

        TranslateTransition move = new TranslateTransition();
        move.setNode(node);
        move.setDuration(Duration.millis(duration));
        move.setFromX(from);
        move.setToX(to);
        move.setCycleCount(1);
        move.setAutoReverse(false);
        move.setDelay(Duration.millis(delay));
        move.play();


    }


}



