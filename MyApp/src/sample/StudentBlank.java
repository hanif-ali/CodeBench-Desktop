package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentBlank implements Initializable {
    String token;
    FXMLLoader centstudent;
    JSONObject details;
    Stage myStage;
    @FXML
            private BorderPane studentbp;

    StudentBlank(){
        this(null,null,null,null);

    }
    StudentBlank(Stage myStage,JSONObject obj,FXMLLoader load,String token){
        this.token=token;
        this.centstudent=load;
        this.details=obj;
        this.myStage=myStage;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXMLLoader loader2=new FXMLLoader(getClass().getResource("centerstudent.fxml"));
        loader2.setControllerFactory(t -> new CenterStudent(token,myStage));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("stPanel.fxml"));
        loader.setControllerFactory(t -> new StPanel(myStage,token,loader2,centstudent,studentbp,details));
        try {
            Parent root1=loader2.load();
            studentbp.setCenter(root1);
            Parent root3=loader.load();
            studentbp.setLeft(root3);
            myStage.setScene(new Scene(studentbp));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
