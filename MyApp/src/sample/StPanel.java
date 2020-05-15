package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javafx.scene.control.*;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ResourceBundle;

public class StPanel implements Initializable {
    @FXML
    private Label name;
    @FXML
    private Button signout;
    @FXML
    private VBox vbox;
    @FXML
    private Label courselab;
    @FXML
    private ScrollPane sp;
    Stage primaryStage;
    FXMLLoader center;
    FXMLLoader stint;
    String token;
    BorderPane back;
    JSONObject details;
    int groupId;
    int studentId;
    CenterStudent myCent;
    StPanel(){

    }
    StPanel(Stage primaryStage,String token,FXMLLoader f1,FXMLLoader f2,BorderPane bp,JSONObject js){
        this.primaryStage=primaryStage;
        this.token=token;
        this.center=f1;
        this.stint=f2;
        this.back=bp;
        this.details=js;
        this.myCent=f1.getController();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            courselab.setText(""+details.getJSONObject("group").get("name"));
            groupId=details.getJSONObject("group").getInt("id");
            studentId=details.getInt("cms_id");
            name.setText(""+details.get("first_name") +" "+ details.get("last_name"));

            Getters g1=new Getters();
            JSONArray assignments=g1.studAssign(token);
            ToggleGroup assignment=new ToggleGroup();
            ToggleButton[] buttons=new ToggleButton[assignments.length()];
            for(int i=0;i<assignments.length();i++){
                buttons[i]=new ToggleButton();
                buttons[i].setToggleGroup(assignment);
                buttons[i].setAlignment(Pos.CENTER_LEFT);
                buttons[i].setPadding(new Insets(0,0,0,50));
                buttons[i].setText("Assignment "+(i+1)+" "+assignments.getJSONObject(i).getString("title"));
                buttons[i].getStylesheets().add("toggle.css");
                int finalI = i;
                buttons[i].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            myCent.deadline.setText(assignments.getJSONObject(finalI).getString("deadline"));
                            myCent.assName.setText("  "+assignments.getJSONObject(finalI).getString("title"));
                            myCent.assNo.setText("Assignment No "+(finalI+1));
                            myCent.assId=assignments.getJSONObject(finalI).getInt("id");
                        }catch (JSONException e){
                            e.printStackTrace();
                        }


                    }
                });


            vbox.getChildren().add(buttons[i]);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
