package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class CenterStudent implements Initializable {
    @FXML
    Button butt;
    @FXML
    BorderPane myBP;
    @FXML
    Label assNo;
    @FXML
    private BorderPane apr;
    @FXML
    private BorderPane apb;
    @FXML
    private BorderPane aps;
    @FXML
    Button butt1;
    @FXML
    Button butt3;
    @FXML
    Button cenbutt;
    @FXML
    private Pane rec;
    Parent parent;
    @FXML
    private BorderPane lb;
    @FXML
    Button deadline;
    @FXML
    Label assName;
    int assId;

    File sub;
    String token;
    Stage myStage;
    CenterStudent(String token,Stage myStage){
        this.token=token;
        this.myStage=myStage;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        butt1.setText("Add submission");
        butt3.setText("+ Submit Assignment");

        rec.prefWidthProperty().bind(lb.widthProperty());
        cenbutt.setText("Please choose your submission file.");
        butt1.setVisible(false);
        butt3.setVisible(false);
        cenbutt.setVisible(false);
        butt1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fc=new FileChooser();
                sub=fc.showOpenDialog(null);
                if(sub!=null){
                    System.out.println(sub.getAbsolutePath());
                    cenbutt.setText("Submit the file to run it.");
                    butt1.setText(sub.getName());

                }

            }

        });
        butt3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // FileSend fileSend=new FileSend("student/assignments/"+assId+"/submit",token,sub.getAbsolutePath());
                //fileSend.sendFile();
                String charset = "UTF-8";
                String requestURL = "http://127.0.0.1:5000/student/assignments/"+assId+"/submit";

                MultipartUtility multipart = null;
                try {
                    multipart = new MultipartUtility(requestURL, charset,token);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                multipart.addFormField("source_code", "source_code");
                try {
                    multipart.addFilePart("source_code", new File(sub.getAbsolutePath()));
                    String response = multipart.finish();
                    JSONObject visible=new JSONObject(response);
                    if(visible.getJSONArray("visible_test_cases").length()>0){
                        FXMLLoader mine=new FXMLLoader(getClass().getResource("visible.fxml"));
                        mine.setControllerFactory(t -> new Visible(visible));
                        parent=mine.load();
                        myBP.setCenter(parent);
                    }else {
                        butt.setText("SUBMITTED");
                    }





                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }



            }
        });

    }

}
