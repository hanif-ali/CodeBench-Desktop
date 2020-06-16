package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class Dialog1Controller  implements Initializable {
    JSONObject data;
    centerteacher cen;

    @FXML
    private Button return1;
    @FXML
    public DialogPane dp;
    @FXML
    private Rectangle background;
    @FXML
        private Rectangle separator;
    @FXML
        private Rectangle separator1;
    @FXML
        private Rectangle slide1;
    @FXML
        private Rectangle slide11;
    @FXML
        private Rectangle graph1;
    @FXML
        private Rectangle graph11;
    @FXML
        private Rectangle grader;
    @FXML
        private Rectangle linting;
    @FXML
        private Rectangle spacetime;
    @FXML
        private Rectangle head;
    @FXML
    private Label addLabel12;
    @FXML
    private Label addLabel;
    @FXML
    private Label addLabel11;
    @FXML
    private Label addLabel1;
    @FXML
    private Label grade111;
    @FXML
    private Label grade11;
    @FXML
    private Label grade1;
    @FXML
    private Label number1;
    @FXML
    private Label number11;
    @FXML
    private Label sat;
    @FXML
    private Label bloc11;
    @FXML
    private Label bloc111;
    @FXML
    private Label bloc1111;
    @FXML
    private Label suggested111;
    @FXML
    private Label suggested11;
    @FXML
    private Label suggested1;
    @FXML
    private Label totalcases;
    @FXML
    private Label total;
    @FXML
    private Label total11;
    @FXML
    private Button submit;

    @FXML
    private Button datelabel;
    @FXML
    private Arc g1arc1;
    @FXML
    private Arc g1arc2;
    @FXML
    private Arc g2arc1;
    @FXML
    private Arc g2arc2;
    @FXML
    private Arc g2arc3;
    @FXML
    private Arc g2arc4;
    @FXML
    private Circle circle1;
    @FXML
    private Circle circle11;
    @FXML
    private TextArea grade;
    @FXML
    private TextArea text11;
    @FXML
    private TextArea text111;
    @FXML
    private TextArea remarks;
    @FXML
    private Label remarkLab;
    @FXML
    private FlowPane fp;
    int subId;
    @FXML
    Button download;
    ArrayList<Button> arr=new ArrayList<Button>();
    String name;
    String cms;
    String date;
    String token;

    Dialog1Controller(){

    }


    Dialog1Controller(String name,String cms,String date,JSONObject data,centerteacher cen,String token,int sub){

    this.data=data;
    this.token=token;
    this.subId=sub;
    this.cen=cen;
    this.name=name;
    this.cms=cms;
    this.date=date;
}




    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {


            ScaleX(background,1000,2,1,0);
            LinearMoveY(head,500,-200,0,0);
            LinearMoveY(return1,500,200,0,0);
            LinearMoveY(submit,500,200,0,0);
            FadeIn(addLabel,500,500);
            FadeIn(addLabel1,500,500);
            FadeIn(addLabel12,500,500);
            FadeIn(addLabel11,500,500);
            FadeIn(datelabel,250,500);
            FadeIn(total,500,750);
            FadeIn(total11,500,750);
            FadeIn(suggested1,500,750);
            FadeIn(suggested11,500,750);
            FadeIn(suggested111,500,750);
            FadeIn(grade1,500,750);
            FadeIn(grade11,500,750);
            FadeIn(grade111,500,750);
            FadeIn(remarkLab,500,750);
            FadeIn(separator1,250,500);
            LinearMoveX(datelabel,500,200,0,500);
            LinearMoveY(separator1,500,-200,0,500);
            FadeIn(totalcases,500,750);
            FadeIn(sat,500,750);
            FadeIn(bloc11,500,750);
            FadeIn(bloc111,500,750);
            FadeIn(bloc1111,500,750);
            FadeIn(grade,500,750);
            FadeIn(text11,500,750);
            FadeIn(text111,500,750);
            FadeIn(grader,500,750);
            FadeIn(linting,500,750);
            FadeIn(spacetime,500,750);
            FadeIn(remarks,500,750);
            FadeIn(separator,500,750);
            FadeIn(graph1,500,750);
            FadeIn(graph11,500,750);
            FadeIn(circle1,500,750);
            FadeIn(circle11,500,750);
            FadeIn(g1arc1,300,750);
            FadeIn(g1arc2,400,750);
            FadeIn(g2arc1,100,750);
            FadeIn(g2arc2,200,750);
            FadeIn(g2arc3,300,750);
            FadeIn(g2arc4,400,750);
            FadeIn(number1,800,750);
            FadeIn(number11,1000,750);

            Scale(totalcases,500,0,1,750);
            Scale(sat,500,0,1,750);
            Scale(bloc11,500,0,1,750);
            Scale(bloc111,500,0,1,750);
            Scale(bloc1111,500,0,1,750);
            Scale(grade,500,0,1,750);
            Scale(text11,500,0,1,750);
            Scale(graph1,500,0,1,750);
            Scale(graph11,500,0,1,750);
            Scale(circle1,500,0,1,750);
            Scale(circle11,500,0,1,750);
            Scale(g1arc1,500,0,1,750);
            Scale(g1arc2,700,0,1,750);
            Scale(g2arc1,500,0,1,750);
            Scale(g2arc2,700,0,1,750);
            Scale(g2arc3,900,0,1,750);
            Scale(g2arc4,1100,0,1,750);
            Scale(text111,500,0,1,750);
            ScaleY(remarks,500,0,1,750);
            ScaleY(separator,500,0,1,750);


            ArcAnimation(g1arc2,0,0,0,0);
            ArcAnimation(g2arc2,0,0,0,0);
            ArcAnimation(g2arc3,0,0,0,0);
            ArcAnimation(g2arc4,0,0,0,0);

            ArcAnimation(g1arc1,500,0,10,450);
            ArcAnimation(g2arc1,500,0,10,450);

            ArcAnimation(g1arc2,500,0,10,650);
            ArcAnimation(g1arc2,500,10,8,1150);

            ArcAnimation(g2arc2,500,0,10,650);
            ArcAnimation(g2arc2,500,10,6,1150);
            ArcAnimation(g2arc3,400,0,10,850);
            ArcAnimation(g2arc3,400,10,4,1250);
            ArcAnimation(g2arc4,300,0,10,1050);
            ArcAnimation(g2arc4,300,10,2,1350);
            addLabel.setText(name);
            addLabel1.setText(cms);
            datelabel.setText(date);
            download.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        HttpGetDownloadFileExample.downloadFile("admin/submissions/"+subId+"/file","C:\\Users\\HP\\IdeaProjects\\MyApp\\src\\sample\\Downloads",token,name+subId);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("File downloaded successfully!");
                }
            });

            try{
            totalcases.setText("0"+data.getInt("total_test_cases"));
            sat.setText("0"+data.getInt("test_cases_passed"));
            number1.setText(""+data.getInt("test_cases_passed"));
            JSONArray testcases=(JSONArray)data.get("test_cases");
            int a=data.getInt("test_cases_passed");
            int b=data.getInt("total_test_cases");
            double res=(double)a/b;
            bloc11.setText(""+res*100+"%");
            number11.setText(""+res*100);
            String status=new String();
                for(int i=0;i<testcases.length();i++){
                    if(testcases.getJSONObject(i).get("output").equals(testcases.getJSONObject(i).get("expected_output"))){
                        status="Passed";
                    }
                    else {
                        status="Failed";
                    }

                    Button butt=(Button)cen.createCard(status,i,100,fp,0);
                    arr.add(butt);
                    settingAction(butt,i,testcases);

                }
            }
            catch (JSONException e){
                e.printStackTrace();
            }



    }
    public void settingAction(Button button,int i,JSONArray test){
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                ColorAdjust dim = new ColorAdjust();
                dim.setBrightness(-0.3);
                dim.setSaturation(-0.3);
                dim.setContrast(-0.3);
                BoxBlur blur = new BoxBlur(3,3,3);
                System.out.println("click");
                Dialog<ButtonType> dialog = new Dialog<>();
                dialog.initOwner(dp.getScene().getWindow());
                dialog.initStyle(StageStyle.UNDECORATED);
                blur.setInput(dim);
                dp.setEffect(blur);


                try {
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("DialogBox2.fxml"));
                    loader.setControllerFactory(t ->new Dialog2Controller(test,i));
                    Parent root = loader.load();
                    dialog.getDialogPane().setContent(root);


                } catch(IOException e){

                    System.out.println("Unable to load dialouge Box");

                }


                Optional<ButtonType> result = dialog.showAndWait();
                if(result.isPresent()){
                    //nothing
                }
                else{
                    dp.setEffect(null);
                }





            }
        });

    }


    @FXML
    public void hover1() {


        if (grade.isHover() || grade.isPressed() || grade.isFocused()){

            if (grader.getX()==0){
                LinearMoveX(grader, 250, 0, -10);
                grader.setX(-1);
            }
            if (linting.getX()==-1 && grade.isFocused()){
                LinearMoveX(linting, 250, -10, 0);
                linting.setX(0);
            }
            if (spacetime.getX()==-1 && grade.isFocused()){
                LinearMoveX(spacetime, 250, -10, 0);
                spacetime.setX(0);
            }

        }

        else {
            if (grader.getX() == -1) {
                LinearMoveX(grader, 250, -10, 0);
                grader.setX(0);
            }
        }

    }


    @FXML
    public void hover2() {


        if (text11.isHover() || text11.isPressed() || text11.isFocused()){

            if (linting.getX()==0){
                LinearMoveX(linting, 250, 0, -10);
                linting.setX(-1);
            }
            if (grader.getX()==-1 && text11.isFocused()){
                LinearMoveX(grader, 250, -10, 0);
                grader.setX(0);
            }
            if (spacetime.getX()==-1 && text11.isFocused()){
                LinearMoveX(spacetime, 250, -10, 0);
                spacetime.setX(0);
            }

        }

        else {
            if (linting.getX() == -1) {
                LinearMoveX(linting, 250, -10, 0);
                linting.setX(0);
            }
        }

    }


    @FXML
    public void hover3() {


        if (text111.isHover() || text111.isPressed() || text111.isFocused()){

            if (spacetime.getX()==0){
                LinearMoveX(spacetime, 250, 0, -10);
                spacetime.setX(-1);
            }
            if (linting.getX()==-1 &&  text111.isFocused()){
                LinearMoveX(linting, 250, -10, 0);
                linting.setX(0);
            }
            if (grader.getX()==-1 && text111.isFocused()){
                LinearMoveX(grader, 250, -10, 0);
                grader.setX(0);
            }

        }

        else {
            if (spacetime.getX() == -1) {
                LinearMoveX(spacetime, 250, -10, 0);
                spacetime.setX(0);
            }
        }

    }





    @FXML
    public void quit(){



        Stage stage = (Stage) return1.getScene().getWindow();

        popup(return1,120);

        stage.close();


    }



    public void hoverOnB(Scene button2, double color1r, double color1g, double color1b, double color2r, double color2g, double color2b, double radius, double duration) {


        CornerRadii radii = new CornerRadii(radius);

        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.millis(duration);


        double op1 = 1;
        double op2 = 0;

        int i = 0;

        KeyValue startKeyValue = new KeyValue(button2.fillProperty(),Color.color(color1r, color1g, color1b, op1));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);

        KeyFrame[] keyframes1 = new KeyFrame[10];

        while (op1 > 0.1) {


            KeyValue stop1KeyValue = new KeyValue(button2.fillProperty(),Color.color(color2r, color2g, color2b, op2));
            keyframes1[i] = new KeyFrame(Duration.millis(((i + 1) * (duration / 10))), stop1KeyValue);
            op1 = op1 - 0.1;
            i++;

        }

        int k = 0;

        KeyFrame[] keyframes2 = new KeyFrame[10];

        while (op2 < 0.9) {


            KeyValue stop2KeyValue = new KeyValue(button2.fillProperty(),Color.color(color1r, color1g, color1b, op1));
            keyframes2[k] = new KeyFrame(Duration.millis(((k + 1) * (duration / 10))), stop2KeyValue);
            op2 = op2 + 0.1;
            k++;

        }

        KeyValue endKeyValue = new KeyValue(button2.fillProperty(),Color.color(color1r, color1g, color1b, op1));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(startKeyFrame, keyframes1[4], keyframes1[3], keyframes1[2],
                keyframes1[1], keyframes1[0], keyframes2[9], keyframes2[8], keyframes2[7], keyframes2[6]
                , keyframes2[5], endKeyFrame);

        animation.setCycleCount(1);
        animation.play();

    }

    public void hoverOffB(Scene button2, double color1r, double color1g, double color1b, double color2r, double color2g, double color2b, double radius, double duration) {


        hoverOnB(button2, color2r, color2g, color2b, color1r, color1g, color1b, radius, duration);

    }


    public void open(Node node,int duration, int delay){
        LinearMoveY(node,duration,500,0,delay);
        Scale(node,duration,0,1,false,1,delay);
        Vanish(node,delay);
        FadeIn(node,duration,delay);
    }
    public void close(Node node,int duration, int delay){
        LinearMoveY(node,duration,0,500,delay);
        Scale(node,duration,1,0,false,1,delay);
        FadeOut(node,duration,delay);
    }



    public void SceneAnimation(Scene arc) {

        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.millis(5000);

        KeyValue startKeyValue = new KeyValue(arc.fillProperty(), Color.BLUE);
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
        KeyValue endKeyValue = new KeyValue(arc.fillProperty(), Color.GREEN);
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(startKeyFrame, endKeyFrame);
        animation.setCycleCount(1);
        animation.play();
    }



    public void Rotate(Node node, int duration,int fromAngle , int toAngle){

        RotateTransition rotate = new RotateTransition();
        rotate.setDuration(Duration.millis(duration));
        rotate.setNode(node);
        rotate.setFromAngle(fromAngle);
        rotate.setToAngle(toAngle);
        rotate.setAutoReverse(true);
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.play();

    }

    public void Rotate(Node node, int duration,int fromAngle , int toAngle, int delay){

        RotateTransition rotate = new RotateTransition();
        rotate.setDuration(Duration.millis(duration));
        rotate.setNode(node);
        rotate.setFromAngle(fromAngle);
        rotate.setToAngle(toAngle);
        rotate.setAutoReverse(true);
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.setDelay(Duration.millis(delay));
        rotate.play();

    }

    public void flip(Node node, int duration,int fromAngle , int toAngle, int delay){

        RotateTransition rotate = new RotateTransition();
        rotate.setDuration(Duration.millis(duration));
        rotate.setNode(node);
        rotate.setFromAngle(fromAngle);
        rotate.setAxis(Rotate.X_AXIS);
        rotate.setToAngle(toAngle);
        rotate.setAutoReverse(false);
        rotate.setCycleCount(1);
        rotate.setDelay(Duration.millis(delay));
        rotate.play();

    }

    public void ColourChange(Node nodeup, Node nodedown, boolean repeat){

        FadeTransition fade1 = new FadeTransition();
        fade1.setDuration(Duration.millis(500));
        fade1.setNode(nodeup);
        fade1.setFromValue(0);
        fade1.setToValue(1);

        FadeTransition fade2 = new FadeTransition();
        fade2.setDuration(Duration.millis(500));
        fade2.setNode(nodedown);
        fade2.setFromValue(1);
        fade2.setToValue(0);
        fade1.setAutoReverse(repeat);
        fade2.setAutoReverse(repeat);

        fade1.play();
        fade2.play();

    }

    public void ColourChange(Node nodeup, Node nodedown, boolean repeat, int delay){

        FadeTransition fade1 = new FadeTransition();
        fade1.setDuration(Duration.millis(500));
        fade1.setNode(nodeup);
        fade1.setFromValue(0);
        fade1.setToValue(1);

        FadeTransition fade2 = new FadeTransition();
        fade2.setDuration(Duration.millis(500));
        fade2.setNode(nodedown);
        fade2.setFromValue(1);
        fade2.setToValue(0);
        fade1.setAutoReverse(repeat);
        fade2.setAutoReverse(repeat);

        fade1.setDelay(Duration.millis(delay));
        fade2.setDelay(Duration.millis(delay));

        fade1.play();
        fade2.play();

    }

    public void ColourChange(Node nodeup, Node nodedown){

        FadeTransition fade1 = new FadeTransition();
        fade1.setDuration(Duration.millis(500));
        fade1.setNode(nodeup);
        fade1.setFromValue(0);
        fade1.setToValue(1);

        FadeTransition fade2 = new FadeTransition();
        fade2.setDuration(Duration.millis(500));
        fade2.setNode(nodedown);
        fade2.setFromValue(1);
        fade2.setToValue(0);

        fade1.play();
        fade2.play();

    }

    public void ColourChange(Node nodeup, Node nodedown, int delay){

        FadeTransition fade1 = new FadeTransition();
        fade1.setDuration(Duration.millis(500));
        fade1.setNode(nodeup);
        fade1.setFromValue(0);
        fade1.setToValue(1);

        FadeTransition fade2 = new FadeTransition();
        fade2.setDuration(Duration.millis(500));
        fade2.setNode(nodedown);
        fade2.setFromValue(1);
        fade2.setToValue(0);

        fade1.setDelay(Duration.millis(delay));
        fade2.setDelay(Duration.millis(delay));

        fade1.play();
        fade2.play();

    }


    public void Pulse (Node nodedown, Node nodeup , int delay){
        int k = 1;
        ColourChange(nodedown, nodeup, delay);
        while ( k<1000 ) {
            ColourChange(nodeup, nodedown, delay + (k*500));
            ColourChange(nodedown, nodeup, delay+((k*500)+500));
            k++;
        }
    }


    public void LinearMoveX(Node node, int duration, int from , int to ){

        TranslateTransition move = new TranslateTransition();
        move.setNode(node);
        move.setDuration(Duration.millis(duration));
        move.setFromX(from);
        move.setToX(to);
        move.setCycleCount(1);
        move.setAutoReverse(false);
        move.play();


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

    public void LinearMoveY(Node node, int duration, int from , int to ){

        TranslateTransition move = new TranslateTransition();
        move.setNode(node);
        move.setDuration(Duration.millis(duration));
        move.setFromY(from);
        move.setToY(to);
        move.setCycleCount(1);
        move.setAutoReverse(false);
        move.play();


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

    public void Scale(Node node, int duration, double from, double to){

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDuration(Duration.millis(duration));
        scale.setFromX(from);
        scale.setFromY(from);
        scale.setToX(to);
        scale.setToY(to);
        scale.setByX(1);
        scale.setByY(1);
        scale.setCycleCount(Animation.INDEFINITE);
        scale.setAutoReverse(true);
        scale.play();


    }


    public void Scale(Node node, int duration, double from, double to, int delay){

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDuration(Duration.millis(duration));
        scale.setFromX(from);
        scale.setFromY(from);
        scale.setToX(to);
        scale.setToY(to);
        scale.setDelay(Duration.millis(delay));
        scale.play();


    }



    public void popup(Node node, int duration){

        Scale(node,duration,0,1.2,true,1,0);
        Scale(node,duration,1.2,1,true,1,duration);


    }


    public void Popup(Node node, int duration, double from, double to, int delay){

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDuration(Duration.millis(duration));
        scale.setFromX(from);
        scale.setFromY(from);
        scale.setToX(to);
        scale.setToY(to);
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

    public void ScaleX(Node node, int duration, double from, double to, int delay){

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDuration(Duration.millis(duration));
        scale.setFromX(from);
        scale.setToX(to);
        scale.setDelay(Duration.millis(delay));
        scale.play();


    }

    public void ScaleY(Node node, int duration, int from, int to,boolean repeat,int cycles,int delay){

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDuration(Duration.millis(duration));
        scale.setFromY(from);
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
        scale.setDelay(Duration.millis(delay));
        scale.play();


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

    public void FadeIn(Node node, int duration){

        FadeTransition fade = new FadeTransition();
        fade.setNode(node);
        fade.setDuration(Duration.millis(duration));
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();

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

    public void FadeOut(Node node, int duration){

        FadeTransition fade = new FadeTransition();
        fade.setNode(node);
        fade.setDuration(Duration.millis(duration));
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();

    }

    public void FadeOut(Node node, int duration, int delay){

        FadeTransition fade = new FadeTransition();
        fade.setNode(node);
        fade.setDuration(Duration.millis(duration));
        fade.setFromValue(1);
        fade.setToValue(0);
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

    public void Fill(Shape shape, int duration, Color from , Color to, int delay){

        FillTransition fill = new FillTransition(Duration.millis(duration),shape);
        fill.setFromValue(from);
        fill.setToValue(to);
        fill.setCycleCount(1000);
        fill.setAutoReverse(true);
        fill.setDelay(Duration.millis(delay));
        fill.play();

    }

    public void Path(Shape path, Node node, int duration, int delay){

        PathTransition pathT = new PathTransition(Duration.millis(duration), path, node);
        pathT.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathT.setCycleCount(FillTransition.INDEFINITE);
        pathT.setAutoReverse(false);
        pathT.setDelay(Duration.millis(delay));
        pathT.play();

    }

    public void ArcAnimation(Arc arc, int duration, int start , double end ) {

        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.millis(1000);
        arc.setStartAngle(90);

        KeyValue startKeyValue = new KeyValue(arc.lengthProperty(), (start*36));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
        KeyValue endKeyValue = new KeyValue(arc.lengthProperty(), (end*36));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(startKeyFrame, endKeyFrame);
        animation.setCycleCount(1);
        animation.play();
    }

    public void ArcAnimation(Arc arc, int duration,int start , double end , int delay ) {

        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.millis(1000);
        arc.setStartAngle(90);

        KeyValue startKeyValue = new KeyValue(arc.lengthProperty(), (start*36));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
        KeyValue endKeyValue = new KeyValue(arc.lengthProperty(), (end*36));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(startKeyFrame, endKeyFrame);
        animation.setDelay(Duration.millis(delay));
        animation.setCycleCount(1);
        animation.play();
    }

    public Node CircleGraph(double grade){

        Circle bg = new Circle();
        Arc arc = new Arc();
        Circle fg = new Circle();
        Label text = new Label();
        text.setLayoutX(19);
        text.setLayoutY(27);
        text.setPrefWidth(82);
        text.setPrefWidth(82);
//        text.setMaxWidth(82);
//        text.setMinWidth(82);

        DropShadow shadow = new DropShadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);


        shadow.setColor(Color.color(0.63, 0.63, 0.63));
        shadow.setOffsetX(0);
        shadow.setOffsetY(0);
        shadow.setSpread(0.5);
        shadow.setHeight(25);
        shadow.setWidth(25);
        shadow.setRadius(12);

        bg.setFill(Color.WHITE);
        bg.setStrokeWidth(0);
        bg.setRadius(60);
        bg.setCenterX(60);
        bg.setCenterY(60);
        bg.setEffect(shadow);

        Color color ;

        double g1 = grade;

        if (g1 >=0 && g1 <=2.5){

            color = Color.color(0.60,0,0.145);
            arc.setFill(color);
        }
        if (g1 >2.5 && g1 <=5){

            color = Color.color(1,0.883,0.294);
            arc.setFill(color);
        }
        if (g1 >5 && g1 <=7.5){

            color = Color.color(0.331,0.61,0.927);
            arc.setFill(color);
        }
        if (g1 >7.5 && g1 <=10){

            color = Color.color(0,0.6035,0.48);
            arc.setFill(color);
        }

//        else{ arc.setFill(Color.BLACK);}




        arc.setStrokeWidth(0);
        arc.setRadiusX(50);
        arc.setRadiusY(50);
        arc.setType(ArcType.ROUND);
        arc.setCenterX(60);
        arc.setCenterY(60);
        arc.setEffect(shadow);

        fg.setFill(Color.WHITE);
        fg.setStrokeWidth(0);
        fg.setRadius(40);
        fg.setCenterX(60);
        fg.setCenterY(60);
        fg.setEffect(shadow);

        String g = ""+grade;
        if (grade == 10.0){

            text.setText("10");

        }
        else{
            text.setText(g);
        }
        text.setFont(Font.font("Square721 BT Bold", FontWeight.BOLD,45));
        text.setTextAlignment(TextAlignment.CENTER);
        text.setAlignment(Pos.CENTER);

        Pane pane = new Pane();
        pane.setMinWidth(120);
        pane.setMaxHeight(120);
        pane.setPrefHeight(60);
        pane.setPrefWidth(60);


        pane.getChildren().add(bg);
        pane.getChildren().add(arc);
        pane.getChildren().add(fg);
        pane.getChildren().add(text);

        ArcAnimation(arc,500,0,grade);
        return pane;

    }


}
