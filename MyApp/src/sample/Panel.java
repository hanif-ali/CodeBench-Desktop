package sample;

import com.sun.javafx.image.impl.ByteIndexed;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.WeakEventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;


public class Panel implements Initializable {
    String course="null";
    String token;
    FXMLLoader mainbp;
    ToggleGroup assignment;
    MenuItem menuItem[];
    HashMap<Integer,String> hash1=new HashMap<Integer, String>();

    BorderPane bp;
    ArrayList<Button> cardsSub=new ArrayList<Button>();
    ArrayList<Button> tests=new ArrayList<Button>();
    Stage primaryStage;
    String[] ns;
    String[] ds;
    String[] nos;
    JSONObject myjson=new JSONObject();
    FXMLLoader fx;
    FXMLLoader current;
    String deadline1;
    centerteacher c2;
    int id;
    int number;
    HashMap<String,Integer> coursesh=new HashMap<String,Integer>();

    String state="s";
    Panel(){
        this(null,null,null,null,null,null,null);
    }
    Panel(Stage primaryStage, JSONObject myJs, FXMLLoader fx,FXMLLoader c,BorderPane bp,FXMLLoader mainbp,String token){
        this.primaryStage=primaryStage;
        this.token=token;
        this.mainbp=mainbp;
        this.myjson=myJs;
        this.fx=fx;
        this.bp=bp;
        this.current=c;
    }
    @FXML
    private VBox vbox;
    @FXML
    private MenuButton coursebutton;
    @FXML
    private Label name;
    @FXML
    private Button add;
    @FXML
    private Button signout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        add.setVisible(false);

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLLoader load = new FXMLLoader(getClass().getResource("testcases.fxml"));
                load.setControllerFactory(t -> new testcases(primaryStage,fx,course,mainbp,load,current,token,id));

                try {

                    BorderPane mybp=(BorderPane)load.load();
                    testcases t1=(testcases)load.getController();
                    t1.setCourselabel();
                    state="t";
                    bp.setCenter(mybp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });




        try{
            coursebutton.setText("Courses");
            coursebutton.getItems().clear();
            coursebutton.setAlignment(Pos.BASELINE_CENTER);
            name.setText(myjson.get("first_name").toString()+" "+myjson.get("last_name").toString());



            FirstLineService1 myservice=new FirstLineService1("courses",token);
            myservice.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    Getters g1=new Getters();
                    //JSONObject courses=(JSONObject)event.getSource().getValue();
                    JSONArray arr1= (JSONArray)event.getSource().getValue();

                    int num=arr1.length();
                    String coursenames[]=new String[num];
                    MenuItem[] m=new MenuItem[num];
                    menuItem=m;



                    for(int n=0;n<num;n++){
                        //m[n]=new MenuItem(arr1.getJSONObject(n).getString("name"));
                        try{
                        hash1.put(arr1.getJSONObject(n).getInt("id"),arr1.getJSONObject(n).getString("name"));
                        coursesh.put(arr1.getJSONObject(n).getString("name"),arr1.getJSONObject(n).getInt("id"));
                        m[n]=new MenuItem(hash1.get(arr1.getJSONObject(n).getInt("id")));}
                        catch (JSONException e){
                            e.printStackTrace();
                        }
                        coursebutton.getItems().add(m[n]);
                        final int myNum=n;
                        JSONArray finalArr = arr1;

                        m[n].setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                caller(finalArr,myNum);
                                try {
                                    id=arr1.getJSONObject(myNum).getInt("id");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                //HashMap<Integer,String> hashed=new HashMap<Integer, String>();
                                /*
                                try {
                                    if(state.equals("t")){
                                        bp.getChildren().removeAll(bp.getCenter());
                                        FXMLLoader load1=new FXMLLoader(getClass().getResource("centerteacher.fxml"));
                                        fx=load1;
                                        load1.setControllerFactory(t -> new centerteacher());
                                        BorderPane my=(BorderPane)load1.load();
                                        bp.setCenter(my);
                                    }

                                    add.setVisible(true);
                                    vbox.getChildren().clear();
                                    centerteacher c1=(centerteacher) fx.getController();
                                    id=finalArr.getJSONObject(myNum).getInt("id");
                                    c1.empty();

                                    state="s";

                                    FirstLineService1 myserv=new FirstLineService1("menu",finalArr.getJSONObject(myNum).getInt("id"),token);
                                    myserv.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                                        @Override
                                        public void handle(WorkerStateEvent ev) {

                                            try{
                                                //JSONObject js=(JSONObject) ev.getSource().getValue();
                                            coursebutton.setText(hash1.get(finalArr.getJSONObject(myNum).getInt("id")));
                                            course=hash1.get(finalArr.getJSONObject(myNum).getInt("id"));
                                            JSONArray arr2=(JSONArray)ev.getSource().getValue();
                                            int len=arr2.length();

                                            String [] names=new String[len];
                                            String[] deadlines=new String[len];
                                            int ids[]=new int[len];
                                            for(int no=0;no<arr2.length();no++){
                                                names[no]=arr2.getJSONObject(no).getString("title");
                                                ids[no]=arr2.getJSONObject(no).getInt("id");
                                                deadlines[no]=arr2.getJSONObject(no).getString("deadline");
                                               // System.out.println(ids[no]);
                                            }
                                            display(len,names,ids,deadlines);}
                                            catch (JSONException o){
                                                o.printStackTrace();
                                            }



                                        }
                                    });
                                    myserv.start();


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                catch (IOException e){
                                    e.printStackTrace();
                                }*/

                            }
                        });
                    }
                }
            });
            myservice.start();
    }catch (JSONException e){
            e.printStackTrace();
        }
    }
    public void caller(JSONArray finalArr,int myNum){
        HashMap<Integer,String> hashed=new HashMap<Integer, String>();
        try {
            if(state.equals("t")){
                bp.getChildren().removeAll(bp.getCenter());
                FXMLLoader load1=new FXMLLoader(getClass().getResource("centerteacher.fxml"));
                fx=load1;
                load1.setControllerFactory(t -> new centerteacher());
                BorderPane my=(BorderPane)load1.load();
                bp.setCenter(my);
            }

            add.setVisible(true);
            vbox.getChildren().clear();
            centerteacher c1=(centerteacher) fx.getController();
            id=finalArr.getJSONObject(myNum).getInt("id");
            c1.empty();

            state="s";

            FirstLineService1 myserv=new FirstLineService1("menu",finalArr.getJSONObject(myNum).getInt("id"),token);
            myserv.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent ev) {

                    try{
                        //JSONObject js=(JSONObject) ev.getSource().getValue();
                        coursebutton.setText(hash1.get(finalArr.getJSONObject(myNum).getInt("id")));
                        course=hash1.get(finalArr.getJSONObject(myNum).getInt("id"));
                        JSONArray arr2=(JSONArray)ev.getSource().getValue();
                        int len=arr2.length();

                        String [] names=new String[len];
                        String[] deadlines=new String[len];
                        String[] dead=new String[len];
                        int ids[]=new int[len];
                        for(int no=0;no<arr2.length();no++){
                            names[no]=arr2.getJSONObject(no).getString("title");
                            ids[no]=arr2.getJSONObject(no).getInt("id");
                            deadlines[no]=arr2.getJSONObject(no).getString("deadline");
                            // System.out.println(ids[no]);
                        }
                        for(int in=0;in<deadlines.length;in++){
                            dead[in]=deadlines[in].substring(0,16);
                            dead[in]=deadlines[in].substring(0,10)+" "+deadlines[in].substring(11,16);
                        }
                        display(len,names,ids,dead);}
                    catch (JSONException o){
                        o.printStackTrace();
                    }



                }
            });
            myserv.start();


        } catch (JSONException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
    public void display(int num,String[] names,int[] ids,String[] deadlines){
        //centerteacher c2=(centerteacher) fx.getController();
        ToggleGroup assignments = new ToggleGroup();
        assignment=assignments;
        int i=0;
        ToggleButton[] butt = new ToggleButton[num];
        number=num;
        //ArrayList<ToggleButton> butt=new ArrayList<ToggleButton>();

        for (int n=0;n<num;n++){
            butt[n] = new ToggleButton();
            butt[n].setToggleGroup(assignments);
            butt[n].setAlignment(Pos.BASELINE_LEFT);
            butt[n].setPadding(new Insets(0,0,0,50));
            butt[n].setText("  "+"Assignment "+(ids[n]-1)+" "+names[n]);
            i++;
            butt[n].getStylesheets().add("Main.css");
            final int temp=n;

            FirstLineService1 fs=new FirstLineService1("subs",ids[n],token);
            int finalN = n;
            vbox.getChildren().add(butt[finalN]);

            fs.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent eve) {
                    butt[finalN].setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                            Getters g2=new Getters();
                            JSONArray sub=(JSONArray) eve.getSource().getValue();
                            deadline1=deadlines[finalN].substring(0,10)+" "+deadlines[finalN].substring(11,16);


                            try {
                                if(state.equals("t")){
                                    bp.getChildren().removeAll(bp.getCenter());
                                    FXMLLoader load1=new FXMLLoader(getClass().getResource("centerteacher.fxml"));
                                    fx=load1;
                                    load1.setControllerFactory(t -> new centerteacher(token));
                                    BorderPane my=(BorderPane)load1.load();
                                    centerteacher cn=(centerteacher)load1.getController();
                                    cn.setAssName(names[temp]);
                                    cn.setAssNo("Assignment "+(temp+1));
                                    System.out.println(names[temp]);
                                    System.out.println(deadlines[finalN]);
                                    String de=deadlines[finalN].substring(0,10)+" "+deadlines[finalN].substring(11,16);
                                    cn.setDeadline(de);

                                    bp.setCenter(my);
                                }

                                c2=(centerteacher)fx.getController();
                                c2.setAssName(names[temp]);
                                System.out.println("Chalo");
                                c2.setAssNo("Assignment "+(temp+1));
                                c2.setDeadline(deadline1);
                                centerteacher c1=(centerteacher) fx.getController();
                                c1.empty();
                                state="s";
                                System.out.println(sub.toString());
                                int size=sub.length();
                                //System.out.println(size);

                                String students[]=new String[size];
                                long cms[]=new long[size];
                                String[] time=new String[size];
                                String date[]=new String[size];
                                int[] subId=new int[size];
                                for(int numb=0;numb<size;numb++){

                                    JSONObject stud=(JSONObject) sub.getJSONObject(numb);
                                    JSONObject indiv=(JSONObject) stud.getJSONObject("student");
                                    //JSONObject assign=(JSONObject)stud.getJSONObject("assignment");
                                    subId[numb]=stud.getInt("id");
                                    date[numb]=stud.getString("submission_time");
                                    cms[numb]=indiv.getLong("cms_id");
                                    students[numb]=indiv.getString("first_name")+" "+indiv.getString("last_name");
                                }
                                add(students,cms,date,subId,size);
                            } catch (JSONException | IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
            fs.start();

        }
}
    public void modify(){
        ToggleButton button=new ToggleButton();
        button.setToggleGroup(assignment);
        button.setAlignment(Pos.BASELINE_LEFT);
        button.setPadding(new Insets(0,0,0,50));
        FirstLineService1 myService=new FirstLineService1("menu",id,token);
        myService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                JSONArray array=(JSONArray)event.getSource().getValue();
                int leng=array.length();
                vbox.getChildren().addAll(button);
                try {
                    String name = array.getJSONObject(leng - 1).getString("title");
                    int ids = array.getJSONObject(leng - 1).getInt("id");
                    String deadline = array.getJSONObject(leng - 1).getString("deadline");
                    deadline1=deadline.substring(0,10)+" "+deadline.substring(11,16);

                    button.setText("  "+"Assignment "+(ids-1)+" "+name);
                    button.getStylesheets().add("Main.css");
                    FirstLineService1 fs=new FirstLineService1("subs",ids,token);
                    int finalN = leng;

                    fs.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                        @Override
                        public void handle(WorkerStateEvent eve) {
                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {


                                    Getters g2=new Getters();
                                    JSONArray sub=(JSONArray) eve.getSource().getValue();
                                    try {
                                        if(state.equals("t")){
                                            bp.getChildren().removeAll(bp.getCenter());
                                            FXMLLoader load1=new FXMLLoader(getClass().getResource("centerteacher.fxml"));
                                            fx=load1;
                                            load1.setControllerFactory(t -> new centerteacher(token));
                                            BorderPane my=(BorderPane)load1.load();
                                            bp.setCenter(my);
                                        }
                                        c2=(centerteacher)fx.getController();
                                        c2.setAssName(name);
                                        c2.setAssNo("Assignment "+(leng+1));
                                        c2.setDeadline(deadline1);
                                        centerteacher c1=(centerteacher) fx.getController();
                                        c1.empty();
                                        state="s";
                                        System.out.println(sub.toString());
                                        int size=sub.length();
                                        //System.out.println(size);

                                        String students[]=new String[size];
                                        long cms[]=new long[size];
                                        String[] time=new String[size];
                                        String date[]=new String[size];
                                        int[] subId=new int[size];
                                        for(int numb=0;numb<size;numb++){

                                            JSONObject stud=(JSONObject) sub.getJSONObject(numb);
                                            JSONObject indiv=(JSONObject) stud.getJSONObject("student");
                                            //JSONObject assign=(JSONObject)stud.getJSONObject("assignment");
                                            subId[numb]=stud.getInt("id");
                                            date[numb]=stud.getString("submission_time");
                                            cms[numb]=indiv.getLong("cms_id");
                                            students[numb]=indiv.getString("first_name")+" "+indiv.getString("last_name");
                                        }
                                        add(students,cms,date,subId,size);
                                    } catch (JSONException | IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    });
                    fs.start();




                }catch (JSONException e){

                }




            }
        });
        myService.start();







    }
    public static LocalDateTime toDate(String string){
        String year=string.substring(0,4);
        String month=string.substring(5,7);
        String day=string.substring(8,10);
        String hour=string.substring(11,13);
        String minute=string.substring(14,16);
        LocalDateTime deadLine=LocalDateTime.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day),Integer.parseInt(hour),Integer.parseInt(minute));
        return deadLine;

    }



    public void add(String [] names,long[] cms,String[] date,int[] subid,int num){
        int inc = 300;
        int delay = inc;
        centerteacher c1=(centerteacher) fx.getController();
        c1.empty();

        for (int i = 0; i < num; i++) {

            String name1 = names[i];
            boolean value=false;
            String cms1 = String.format("%s",cms[i]);
            String date1 = date[i].substring(0,10)+" "+date[i].substring(11,16);
            int subId=subid[i];
            LocalDateTime ded= toDate(deadline1);
            LocalDateTime dated=toDate(date1);
            if(dated.isAfter(ded)){
                value=true;
            }

            Button button=(Button)(c1.createCard(name1, cms1, date1, "graded",value, (((i+1)*inc)+delay)));


            cardsSub.add(button);
            settingAction(button,name1,cms1,date1,subId);

            delay = delay+(3*inc);
        }

}

    public void settingAction(Button b, String name, String cms, String date, int subId){
        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                FirstLineService service = new FirstLineService("subid",subId,token);
                service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {

                    @Override
                    public void handle(WorkerStateEvent event) {
                        JSONObject myjson=(JSONObject)event.getSource().getValue();
                        ColorAdjust dim = new ColorAdjust();
                        dim.setBrightness(-0.3);
                        dim.setSaturation(-0.3);
                        dim.setContrast(-0.3);
                        BoxBlur blur = new BoxBlur(3,3,3);
                        System.out.println("click");
                        Dialog<ButtonType> dialog = new Dialog<>();
                        dialog.initOwner(bp.getScene().getWindow());

                        dialog.initStyle(StageStyle.UNDECORATED);
                        blur.setInput(dim);
                        bp.setEffect(blur);

                        try {

                            FXMLLoader loader=new FXMLLoader(getClass().getResource("DialogBox1.fxml"));

                            loader.setControllerFactory(t ->new Dialog1Controller(name,cms,date,myjson,(centerteacher)fx.getController(),token,subId) );
                            Dialog1Controller dg=(Dialog1Controller) loader.getController();
                           // dg.subId=subId;
                            Parent root=loader.load();
                            dialog.getDialogPane().setContent(root);

                        } catch(IOException e){

                            System.out.println("Unable to load Dialog Box");
                        }

                        Optional<ButtonType> result = dialog.showAndWait();
                        if(result.isPresent()){
                            //nothing
                        }
                        else{
                            bp.setEffect(null);
                        }  }
                });
                service.start();
            }});
    }


    public HashMap<String,Integer> getCourses(){

                return coursesh;

}


}

 class FirstLineService extends Service<JSONObject> {
    String route;
    int id;
    String token;
    JSONObject params;
    FirstLineService(String route,String token){
        this.route=route;
        this.token=token;
    }


    FirstLineService(String route,int id,String token)
    {
        this.route=route;
        this.id=id;
        this.token=token;
    }


    FirstLineService(String route,String token,JSONObject params){
        this.route=route;
        this.token=token;
        this.params=params;
    }

    protected Task<JSONObject> createTask() {

        if(route.equals("subid")){
            return new Task<JSONObject>() {
            protected JSONObject call()
                    throws IOException, MalformedURLException, JSONException {
                Getters g=new Getters();
                JSONObject result=g.subDetails(id,token);
                return result;
            }
        };
        }
        else if(route.equals("newAss")){

            return new Task<JSONObject>() {
                protected JSONObject call()
                        throws IOException, MalformedURLException {
                    UserAuth newAss=new UserAuth("admin/assignments/new");
                    newAss.setAccessToken(token);
                    JSONObject response=newAss.auth(params);
                    return response;
                }
            };


        }



        else {
            return null;
        }

    }





}


class FirstLineService1 extends Service<JSONArray> {
    String route;
    int id;
    String token;
    JSONObject params;
    FirstLineService1(String route,String token){
        this.route=route;
        this.token=token;
    }


    FirstLineService1(String route,int id,String token)
    {
        this.route=route;
        this.id=id;
        this.token=token;
    }


    FirstLineService1(String route,String token,JSONObject params){
        this.route=route;
        this.token=token;
        this.params=params;
    }

    protected Task<JSONArray> createTask() {

       if(route.equals("courses")){
            return new Task<JSONArray>() {
                protected JSONArray call()
                        throws IOException, MalformedURLException, JSONException {
                    Getters g1=new Getters();
                    JSONArray courses=g1.courses(token);
                    return courses;
                }};
        }
       else if(route.equals("menu")){
           return new Task<JSONArray>() {
               @Override
               protected JSONArray call() throws Exception {
                   Getters g2=new Getters();
                   JSONArray  sub=g2.assignments(id,token);
                   return sub;
               }
           };
        }
       else if(route.equals("subs")){
           return new Task<JSONArray>() {
               @Override
               protected JSONArray call() throws Exception {
                   Getters g2=new Getters();
                   JSONArray sub=g2.submissions(id,token);
                   return sub;
               }
           };
       }

       else {
           return null;
       }

        /*else if(route.equals("subs")){
            return new Task<JSONObject>() {
                @Override
                protected JSONObject call() throws Exception {
                    Getters g2=new Getters();
                    JSONObject sub=g2.submissions(id,token);
                    return sub;
                }
            };
        }
        else if(route.equals("menu")){
            return new Task<JSONObject>() {
                @Override
                protected JSONObject call() throws Exception {
                    Getters g2=new Getters();
                    JSONObject sub=g2.assignments(id,token);
                    return sub;
                }
            };

        }
        else {
            return null;
        }

    }*/


}}