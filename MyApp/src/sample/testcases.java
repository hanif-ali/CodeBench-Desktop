package sample;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;

public class testcases implements Initializable {
    int id;
    @FXML
    private BorderPane center;
    @FXML
    private Rectangle rect;
    @FXML
    private ScrollPane scroll;
    @FXML
    private Pane backpane;
    @FXML
    private FlowPane testfp;
    @FXML
    private AnchorPane anchor;
    @FXML
    private TextField tit;
    @FXML
    private TextField dead;
    @FXML
    private Label deadlabel;
    @FXML
    private Label titlabel;
    @FXML
    private Label courselabel;
    @FXML
    private Button test;
    @FXML
    private  Button addnew;





    JSONArray testcase=new JSONArray();
    String buttonState="p";
    String course;
    centerteacher cen;
    FXMLLoader loader;
    Stage primaryStage;
    FXMLLoader mainbp;
    BorderPane myBorderPane;
    teacherinter tc;
    FXMLLoader load;
    JSONObject newassignment=new  JSONObject();
    ArrayList<Button> testcases=new ArrayList<Button>();
    ArrayList<Card> cards=new ArrayList<Card>();
    int num=0;
    Panel pan;
    String token;
    FXMLLoader pani;

    testcases(){
        this(null,null,null,null,null,null,null,0);

    }

    public void getId(){


    }

    testcases(Stage pm,FXMLLoader loader,String course,FXMLLoader mainbp,FXMLLoader load,FXMLLoader pani,String token,int id){
        this.token=token;
        this.loader=loader;
        this.id=id;
        this.primaryStage=pm;
        this.course=course;
        this.mainbp=mainbp;
        tc=mainbp.getController();
        myBorderPane=tc.borderpane;
        this.load=load;
        this.pani=pani;
        pan=(Panel)pani.getController();




    }


    public String getTitle(){
        try {
            if (tit.getText().length()==0) {
                throw new TitleEx("Title field cannot be blank");
            } else {
                System.out.println("NON-EMPTY");
                return tit.getText();
            }
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
            throw new TitleEx("Title field cannot be blank");
        }

    }

    public boolean validate(String deadline){
        String pattern="//d//d//d//d-//d//d-//d//d//s//d//d://d//d";
        boolean result= Pattern.matches(pattern,deadline);
        if(result==false){
            System.out.println("No result");
            System.out.println(deadline);
        }
        return result;
    }



    public String getDead() throws IllegalArgumentException,Exception{
        String deadline=dead.getText();
        try {
            if (deadline.length() != 16 ) {

                throw new IllegalArgumentException("Please enter the deadline in YYYY-MM-DD HH:MM format");
            }
            else {
                String year=deadline.substring(0,4);
                String month=deadline.substring(5,7);
                String day=deadline.substring(8,10);
                String hour=deadline.substring(11,13);
                String minute=deadline.substring(14,16);
                LocalDateTime deadLine=LocalDateTime.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day),Integer.parseInt(hour),Integer.parseInt(minute));
                System.out.println(deadline);

                return deadLine.toString();
            }
        }
        catch (NumberFormatException e){
            System.out.println("Please enter the deadline in YYYY-MM-DD HH:MM format ");
            throw new IllegalArgumentException("Please enter the deadline in YYYY-MM-DD HH:MM\n format e.g 2020:12:12 12:12");
        }
        catch (IllegalArgumentException e){
            System.out.println("Please enter the deadline in YYYY-MM-DD HH:MM format ");
            throw new IllegalArgumentException("Please enter the deadline in YYYY-MM-DD HH:MM \nformat e.g 2020:12:12 12:12");

        }catch (Exception e){
            System.out.println("Please enter the deadline in YYYY-MM-DD HH:MM format ");
            throw new Exception("Please enter the deadline in YYYY-MM-DD HH:MM \nformat e.g 2020:12:12 12:12");
        }

    }

    public int getIndex(ArrayList<Button> a,Button butt){
        System.out.println(a.indexOf(butt));
      return a.indexOf(butt);
    }


    public void setCourselabel() {
        courselabel.setText(course);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        testfp.prefWidthProperty().bind(scroll.widthProperty());
        testfp.minWidthProperty().bind(scroll.widthProperty());
        testfp.maxWidthProperty().bind(scroll.widthProperty());
        anchor.prefHeightProperty().bind(testfp.heightProperty());
        anchor.minHeightProperty().bind(testfp.heightProperty());
        anchor.maxHeightProperty().bind(testfp.heightProperty());
        backpane.prefHeightProperty().bind(scroll.heightProperty());
        backpane.prefWidthProperty().bind(scroll.widthProperty());
        backpane.minHeightProperty().bind(scroll.heightProperty());
        backpane.minWidthProperty().bind(scroll.widthProperty());
        backpane.maxHeightProperty().bind(scroll.heightProperty());
        backpane.maxWidthProperty().bind(scroll.widthProperty());




        addnew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            try{
                try{

                    newassignment.put("deadline",getDead());
                    newassignment.put("title",getTitle());

                    HashMap<String,Integer> hashed=pan.getCourses();
                    int id=hashed.get(course);
                    newassignment.put("group_id",id);
                    newassignment.put("test_cases",TestCase.returner(testcase));
                    FirstLineService firstLineService=new FirstLineService("newAss",token,newassignment);
                    firstLineService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                        @Override
                        public void handle(WorkerStateEvent event) { ;
                            JSONObject response=(JSONObject) event.getSource().getValue();
                            System.out.println(newassignment.toString());
                            System.out.println(testcase.toString());
                            if(response.equals("success")){
                                System.out.println("Assignment uploaded!");
                            }


                            //Clearing the components of testcase window
                            tit.clear();
                            dead.clear();
                            testfp.getChildren().removeAll(testfp.getChildren());
                            pan.modify();


                            for(int i=0;i<testcase.length();i++){
                                testcase.remove(i);
                            }
                            num=0;

                        }
                    });
                    firstLineService.start();

                }
                catch (JSONException e){
                    e.printStackTrace();
                }

            }
            catch(TitleEx ex){
                System.out.println(ex);
                ErrorBox eb=new ErrorBox("ERROR",ex.getMessage(),myBorderPane);
                eb.showDialogue();
            }
            catch (Exception ex){
                System.out.println(ex);
                ErrorBox eb=new ErrorBox("ERROR",ex.getMessage(),myBorderPane);
                eb.showDialogue();

            }


            }
        });




        cen=(centerteacher)loader.getController();

        test.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                increment();
                try {
                    testcase.put(num-1,"null");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Card myCard= null;
                try {
                    myCard = createCard(TestCase.getLength(testcase),num-1,  100);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Button b1=(Button) myCard.n;
                testcases.add(b1);
                setAction(b1,num-1);

            }
        });

    }
    public void addingTest(JSONObject js,int n) throws JSONException {
        testcase.put(n,js);
        System.out.println(num);
    }
    public void increment(){
        num+=1;
    }

    public Card createCard(int disp,int testnum, int delay){
        Pane hbox=testfp;
        Card c1 = new Card();
        cards.add(c1);
        c1.n= c1.makeCard(disp,testnum,"Delete");
        Button b1 = c1.getgradeButton();
        Label l1 = c1.getNameLabel();
        c1.number=testnum;
        HashMap<Node,Integer> singleCard=new HashMap<>();

        buttonState="p";
        hbox.getChildren().add(c1.n);
        cen.Vanish(c1.n,delay);
        cen.FadeIn(c1.n,100,delay);
        cen.popup(c1.n,200,delay);
        cen.Vanish(b1,400+delay);
        cen.FadeIn(b1,200,400+delay);
        cen.ScaleX(b1,200,0,1,false,1,400+delay);
        cen.LinearMoveY(b1,400,-80,-80,300+delay);
        cen.LinearMoveY(b1,200,-80,0,700+delay);
        cen.Vanish(l1,700+delay);
        cen.FadeIn(l1,200,700+delay);
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                testfp.getChildren().remove(c1.n);
                buttonState="n";
                try {
                    testcase.put(testnum,"null");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        return c1;
    }
    public BorderPane getAnchorPane() {

        return myBorderPane;
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
    public ArrayList<JSONObject> returns(JSONArray ar,ArrayList<JSONObject> j){
        for (int i=0;i<ar.length();i++) {

        }
        return j;
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
    public  void setAction(Button butt,int n){
        butt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(buttonState.equals("p")){

                ColorAdjust dim = new ColorAdjust();

                dim.setBrightness(-0.3);
                dim.setSaturation(-0.3);
                dim.setContrast(-0.3);
                BoxBlur blur = new BoxBlur(3,3,3);
                System.out.println("click");
                Dialog<ButtonType> dialog = new Dialog<>();
                dialog.initOwner(myBorderPane.getScene().getWindow());


                dialog.initStyle(StageStyle.UNDECORATED);
                blur.setInput(dim);
                myBorderPane.setEffect(blur);

                try {

                    FXMLLoader mine=new FXMLLoader(getClass().getResource("dialougueBox.fxml"));
                    int index= getIndex(testcases,butt);
                    mine.setControllerFactory(t ->new DialogController(load,index));
                    Parent root1=mine.load();
                    DialogController myDg=(DialogController)mine.getController();
                    dialog.getDialogPane().setContent(root1);


                    myDg.setInt(testcase.getJSONObject(index).getString("input"));
                    myDg.setOut(testcase.getJSONObject(index).getString("output"));




                } catch(IOException | JSONException e){
                    System.out.println("Unable to load Dialogue Box");

                }
                Optional<ButtonType> result = dialog.showAndWait();
                if(result.isPresent()){
                    //nothing
                }
                else{
                    myBorderPane.setEffect(null);
                }}else{
                    buttonState="p";
                }
            }
        });

    }



}

class TitleEx extends IllegalArgumentException{
    TitleEx(String message){
        super(message);
    }

}
