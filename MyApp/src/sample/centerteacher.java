package sample;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class centerteacher implements Initializable {
    @FXML
    private HBox hb3;
    @FXML
    private HBox hb1;
    @FXML
    private HBox hb2;
    @FXML
    private FlowPane fp;
    @FXML
    private ScrollPane sp;
    @FXML
    private AnchorPane ap;
    @FXML
    private Pane pane;

   /* @FXML
    private Button button1;

    @FXML
    private TextField name;
    @FXML
    private TextField cms;
    @FXML
    private TextField date;
    @FXML
    private TextField grade;*/
    @FXML
    private Button deadline;
    @FXML
    private Label assNo;
    @FXML
    private Label assName;
    String token;
    centerteacher(){

    }
    centerteacher(String token){
        this.token=token;
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {


        //deadline.setText("25-04-2020");
        //assName.setText("Classes");
        //assNo.setText("Assignment 1");



        fp.prefWidthProperty().bind(sp.widthProperty());

        fp.minWidthProperty().bind(sp.widthProperty());
        fp.maxWidthProperty().bind(sp.widthProperty());

        ap.prefHeightProperty().bind(fp.heightProperty());
        ap.minHeightProperty().bind(fp.heightProperty());


        ap.maxHeightProperty().bind(fp.heightProperty());
//        ap.maxWidthProperty().bind(fp.widthProperty());

        pane.prefHeightProperty().bind(sp.heightProperty());
        pane.prefWidthProperty().bind(sp.widthProperty());

        pane.minHeightProperty().bind(sp.heightProperty());
        pane.minWidthProperty().bind(sp.widthProperty());

        pane.maxHeightProperty().bind(sp.heightProperty());
        pane.maxWidthProperty().bind(sp.widthProperty());

        HBox [] hbox = new HBox[3];

        hbox[0] = hb1;
        hbox[1] = hb2;
        hbox[2] = hb3;

    }


    @FXML
    public void add(){
    }


    public void empty(){
        Pane h=fp;
        h.getChildren().clear();
    }
    public void setDeadline(String dead){
        deadline.setText(dead);

    }
    public void setAssName(String dead){
        assName.setText(dead);

    }

    public void setAssNo(String dead){
        assNo.setText(dead);
    }

    public Node createCard(String status,int num,int delay,FlowPane f,int no){
        Pane hbox=f;
        Card c1 = new Card();
        Node n1 = c1.makeCard(no,num,status);
        Button b1 = c1.getgradeButton();
        Label l1 = c1.getNameLabel();


        hbox.getChildren().add(n1);
        Vanish(n1,delay);
        FadeIn(n1,100,delay);
        popup(n1,200,delay);
        Vanish(b1,400+delay);
        FadeIn(b1,200,400+delay);
        ScaleX(b1,200,0,1,false,1,400+delay);
        LinearMoveY(b1,400,-80,-80,300+delay);
        LinearMoveY(b1,200,-80,0,700+delay);
        Vanish(l1,700+delay);
        FadeIn(l1,200,700+delay);

        return n1;


    }



    public Node createCard(String name ,String cms ,String submission,String grade,boolean stat,int delay){

        Pane hbox=fp;
        Card c1 = new Card();
        Node n1 = c1.makeCard(name , cms , submission, grade);
        Button b1 = c1.getgradeButton();
        Label l1 = c1.getNameLabel();
        Label l2 = c1.getCmsLabel();
        Label l3 = c1.getSubmittedOnLabel();
        Label l4 = c1.getSubmissionLabel();
        if(stat){
        l4.setStyle("-fx-text-fill: red");
        }

        hbox.getChildren().add(n1);
        Vanish(n1,delay);
        FadeIn(n1,100,delay);
        popup(n1,200,delay);
        Vanish(b1,400+delay);
        FadeIn(b1,200,400+delay);
        ScaleX(b1,200,0,1,false,1,400+delay);
        LinearMoveY(b1,400,-80,-80,300+delay);
        LinearMoveY(b1,200,-80,0,700+delay);
        Vanish(l1,700+delay);
        FadeIn(l1,200,700+delay);
        Vanish(l2,800+delay);
        FadeIn(l2,200,750+delay);
        Vanish(l3,700+delay);
        FadeIn(l3,200,800+delay);
        Vanish(l4,800+delay);
        FadeIn(l4,200,850+delay);
        return n1;


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

    public void LinearMoveY(Node node, int duration, int from, int to ,int delay ){

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
}
class Card {

    public Label line1 ;
    public Label line2 ;
    public Label line3 ;
    public Label line4 ;
    public VBox vbox ;
    public Button buttong;
    public Button card;
    int number;
    public Node n;

    public Card() {

        line1 = new Label();
        line2 = new Label();
        line3 = new Label();
        line4 = new Label();
        buttong = new Button();
        card = new Button();

    }
    public Node getCard(){
        return this.card;
    }


    public Node makeCard (int no,int num,String status){


        line1.setText("Test Case "+(num+1));
        line1.setStyle("-fx-font-weight: bold");
        vbox = new VBox();
        vbox.setSpacing(3);
        vbox.setPadding(new Insets(5, 5, 8, 5));
        vbox.getChildren().addAll(line1);
        buttong.setText(status);
        buttong.getStylesheets().add("notgraded.css");
        vbox.getChildren().add(buttong);
        card.getStylesheets().add("test.css");
        DropShadow shadow = new DropShadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);

        shadow.setColor(Color.color(0.63, 0.63, 0.63));
        shadow.setOffsetX(2);
        shadow.setOffsetY(3);
        shadow.setSpread(0.36);
        shadow.setHeight(25);
        shadow.setWidth(25);
        shadow.setRadius(12);
        card.setGraphic(vbox);
        card.setEffect(shadow);
        return card;
    }



    public Node makeCard (String name, String cms, String submission, String status){


        line1.setText(name);
        line2.setText(cms);
        line3.setText("Submitted On");
        line4.setText(submission);


        line1.setStyle("-fx-font-weight: bold");
        line3.setStyle("-fx-font-weight: bold");

        line4.setPadding(new Insets(0,0,5,0));

        vbox = new VBox();
        vbox.setSpacing(3);
        vbox.setPadding(new Insets(5, 5, 8, 5));

        vbox.getChildren().addAll(line1, line2, line3, line4);


        status.toLowerCase();

        if (status.equals("graded")) {

            buttong.setText("Graded");
            buttong.getStylesheets().add("graded.css");


        } else {
            buttong.setText("Not Graded");
            buttong.getStylesheets().add("notgraded.css");

        }

        vbox.getChildren().add(buttong);


        card.getStylesheets().add("card.css");

        DropShadow shadow = new DropShadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);

        shadow.setColor(Color.color(0.63, 0.63, 0.63));
        shadow.setOffsetX(2);
        shadow.setOffsetY(3);
        shadow.setSpread(0.36);
        shadow.setHeight(25);
        shadow.setWidth(25);
        shadow.setRadius(12);
        card.setGraphic(vbox);
        card.setEffect(shadow);
        return card;
    }
    public Label getNameLabel(){
        return line1;
    }
    public Label getCmsLabel(){
        return line2;
    }
    public Label getSubmittedOnLabel(){
        return line3;
    }
    public Label getSubmissionLabel(){
        return line4;
    }
    public Button getgradeButton(){
        return buttong;

    }

    public double getPrefWidth(){

        return card.getPrefWidth();

    }

}