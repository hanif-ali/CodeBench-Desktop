package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class CenterStudent implements Initializable {
    @FXML
    Label assNo;
    @FXML
    private BorderPane apr;
    @FXML
    private BorderPane apb;
    @FXML
    private BorderPane aps;
    @FXML
    private Button butt1;
    @FXML
    private Button butt3;
    @FXML
    private Button cenbutt;
    @FXML
    private Pane rec;
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
                } catch (IOException e) {
                    e.printStackTrace();
                }






            }
        });

        }

}
