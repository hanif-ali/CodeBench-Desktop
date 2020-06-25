package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class teacherinter implements Initializable {
    JSONObject js;
    FXMLLoader mainborder;
    Stage primaryStage;
    String token;
    teacherinter(){
        this(null,null,null,null);
    }

    teacherinter(Stage pm,JSONObject js,FXMLLoader mainborder,String token){
        this.js=js;
        this.token=token;
        this.primaryStage=pm;
        this.mainborder=mainborder;
    }

    CustomAnimations animator = new CustomAnimations();

    private double xOffset = 0 ;
    private double yOffset = 0 ;

    public void drag(Pane apane){

        apane.setOnMousePressed(((event) -> {

            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        }));

        apane.setOnMouseDragged(((event) -> {

            primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            primaryStage.setX(event.getScreenX()-xOffset);
            primaryStage.setY(event.getScreenY()-yOffset);

        }));

    }
    @FXML
    BorderPane borderpane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        drag(borderpane);
        borderpane.setScaleX(1.3);
        borderpane.setScaleY(1.3);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("testing.fxml"));
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("centerteacher.fxml"));
        loader.setControllerFactory(t ->new Panel(primaryStage,js,loader2,loader,borderpane,mainborder,token));
        loader2.setControllerFactory(t ->new centerteacher(token));

        Rectangle clipper = new Rectangle();
        clipper.setWidth(960);
        clipper.setHeight(540);
        animator.FadeIn(borderpane,100,250);
        animator.ScaleX(borderpane,350,0,1,250);
        animator.ScaleY(borderpane,350,0,1,250);
        animator.Scale(clipper,350,0,1,250);
        animator.Scale(clipper,25,1,5,600);

        try {
            Parent root2=loader2.load();
            borderpane.setCenter(root2);
            Parent root=loader.load();
            borderpane.setLeft(root);
            borderpane.setClip(clipper);
            Scene scene = new Scene(borderpane);
            scene.setFill(null);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
