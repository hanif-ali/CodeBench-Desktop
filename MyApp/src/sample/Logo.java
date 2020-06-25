package sample;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Logo {

    private CB cb;
    private Back background;
    private Pane backPane;
    private BenchText bt;
    private CustomAnimations animation;
    private Rectangle rect1;
    private Rectangle rect2;
    private Rectangle rect3;
    private Circle inner;
    private Circle outer;
    private Pane oBg;
    private Line[] lines;
    private Line[] polyLines;
    private Pane ePane;
    private Pane dPane;
    private Line[] eLines;
    private Line[] dLines;
    private AnchorPane bottomPane;







    public Pane getMainPane() {
        return mainPane;
    }

    private Pane mainPane;

    public Logo(){

        mainPane = new Pane();
        bt = new BenchText();
        animation = new CustomAnimations();

    }

    public Pane createLogo(double scale){

        cb = new CB();
        background = new Back();

        Pane p1 = background.createBackground();
        backPane = new Pane();

        Group g1 = cb.createC();
        Group g2 = cb.createB();
        Group g3 = cb.createB2();
        p1.getChildren().addAll(backPane,g1,g3,g2);
        mainPane.getChildren().add(p1);

        mainPane.setStyle("-fx-background-color: #F2F2F2  ; -fx-background-radius: 40 ");
        mainPane.setPrefWidth(273*scale);
        mainPane.setPrefHeight(273*scale);
        mainPane.setScaleX(scale);
        mainPane.setScaleY(scale);

        return mainPane;

    }

    public Pane getBackPane() {
        return backPane;
    }

    public void cbBuild(int duration , int delay){

        animation.LinearMoveX(cb.getsLeft(),duration,-250,0,delay);
        animation.LinearMoveY(cb.getsLeft(),duration,-250,0,delay);
        animation.LinearMoveX(cb.gettLeft(),duration,250,0,250+delay);
        animation.LinearMoveY(cb.gettLeft(),duration,-250,0,250+delay);
        animation.LinearMoveX(cb.getsRight(),duration,250,0,500+delay);
        animation.LinearMoveY(cb.getsRight(),duration,250,0,500+delay);
        animation.LinearMoveX(cb.gettRight(),duration,-250,0,750+delay);
        animation.LinearMoveY(cb.gettRight(),duration,250,0,750+delay);
        animation.FadeIn(cb.getsLeft(),duration/2,250+delay);
        animation.FadeIn(cb.gettLeft(),duration/2,500+delay);
        animation.FadeIn(cb.getsRight(),duration/2,750+delay);
        animation.FadeIn(cb.gettRight(),duration/2,1000+delay);

    }
    public void bLinesBuild(int duration , int delay){


        for(Line testLine : cb.getBgLines()) {
            animation.FadeIn(testLine, 100, delay);
        }

        for (int i =1 ; i<8 ; i+=2){

            animation.LinearMoveX(cb.getBgLines(i),duration,-105,0,250+delay);
            animation.LinearMoveY(cb.getBgLines(i),duration,61,0,250+delay);

        }

        double iDuration = duration*0.66666666667;
        duration = (int) iDuration;

        for(int j=0 ; j<9 ; j +=2){

            animation.LinearMoveX(cb.getBgLines(j),duration,105,0,250+delay);
            animation.LinearMoveY(cb.getBgLines(j),duration,-61,0,250+delay);

        }


    }
    public void clip1Build(int duration , int delay){

        animation.FadeIn(cb.getClip(),100,delay);
        animation.LinearMoveY(cb.getClip(),duration,500,0,delay);

    }
    public ScaleTransition bgLinesBuild(int duration , int delay){


        for (int i = 0 ; i<30 ; i +=2){
            animation.FadeIn(background.getBgLines(i),100,delay);
            animation.LinearMoveX(background.getBgLines(i),duration,-1050,0,delay);
            animation.LinearMoveY(background.getBgLines(i),duration,-610,0,delay);
        }
        for(int j = 1 ; j<30 ; j +=2 ){
            animation.FadeIn(background.getBgLines(j),100,delay);
            animation.LinearMoveX(background.getBgLines(j),duration,1050,0,delay);
            animation.LinearMoveY(background.getBgLines(j),duration,610,0,delay);

        }

        return animation.ScaleReturn(background.getBgLines(29),duration,1,1,delay);


    }
    public void mainPaneBuild(int duration , int delay,double scale){

        animation.FadeIn(mainPane,100,delay);
        animation.Scale(mainPane,duration,0,scale+(scale*0.2),delay);
        animation.Scale(mainPane,100,scale+(scale*0.2),scale,400+delay);

    }

    public void cbDestroy(int duration , int delay){




        animation.LinearMoveX(cb.getsLeft(),duration,0,-250,(duration*3/4)+delay);
        animation.LinearMoveY(cb.getsLeft(),duration,0,-250,(duration*3/4)+delay);
        animation.LinearMoveX(cb.gettLeft(),duration,0,250,(duration/2)+delay);
        animation.LinearMoveY(cb.gettLeft(),duration,0,-250,(duration/2)+delay);
        animation.LinearMoveX(cb.getsRight(),duration,0,250,(duration/4)+delay);
        animation.LinearMoveY(cb.getsRight(),duration,0,250,(duration/4)+delay);
        animation.LinearMoveX(cb.gettRight(),duration,0,-250,delay);
        animation.LinearMoveY(cb.gettRight(),duration,0,250,delay);
        animation.FadeOut(cb.getsLeft(),duration/2,(duration*2)+delay+duration/2);
        animation.FadeOut(cb.gettLeft(),duration/2,(duration*3/4)+delay+duration/2);
        animation.FadeOut(cb.getsRight(),duration/2,(duration/2)+delay+duration/2);
        animation.FadeOut(cb.gettRight(),duration/2,(duration/4)+delay+duration/2);

    }

    public void bLinesDestroy(int duration , int delay){


        for(Line testLine : cb.getBgLines()) {
            animation.FadeOut(testLine, 100, delay+duration-100);
        }

        for (int i =1 ; i<8 ; i+=2){

            animation.LinearMoveX(cb.getBgLines(i),duration,0,-105,250+delay);
            animation.LinearMoveY(cb.getBgLines(i),duration,0,61,250+delay);

        }

        double iDuration = duration*0.66666666667;
        duration = (int) iDuration;

        for(int j=0 ; j<9 ; j +=2){

            animation.LinearMoveX(cb.getBgLines(j),duration,0,105,250+delay);
            animation.LinearMoveY(cb.getBgLines(j),duration,0,-61,250+delay);

        }


    }

    public void clip1Destroy(int duration , int delay){

        animation.FadeOut(cb.getClip(),100,delay+duration-100);
        animation.LinearMoveY(cb.getClip(),duration,0,500,delay);

    }

    public void bgLinesDestroy(int duration , int delay){


        for (int i = 0 ; i<30 ; i +=2){
            animation.FadeOut(background.getBgLines(i),100,delay+duration-100);
            animation.LinearMoveX(background.getBgLines(i),duration,0,-1050,delay);
            animation.LinearMoveY(background.getBgLines(i),duration,0,-610,delay);
        }
        for(int j = 1 ; j<30 ; j +=2 ){
            animation.FadeOut(background.getBgLines(j),100,delay+duration-100);
            animation.LinearMoveX(background.getBgLines(j),duration,0,1050,delay);
            animation.LinearMoveY(background.getBgLines(j),duration,0,610,delay);

        }

    }

    public void mainPaneDestroy(int duration , int delay,double scale){

        animation.FadeOut(mainPane,100,delay+duration-100);
        animation.Scale(mainPane,100,scale,scale+(scale*0.2),delay);
        animation.Scale(mainPane,duration,scale+(scale*0.2),0,100+delay);

    }




    public ScaleTransition play(int delay,double scale){

        cbBuild(500,delay);

        //CB animation done

        bLinesBuild(1500,delay);

        //B lines done

        clip1Build(400,delay);

        //clip1 done

        //bg lines done

        mainPaneBuild(200,delay,scale);

        //build up animation done

        return bgLinesBuild(1500,delay);



    }

    public void finish(int delay,double scale){

        cbDestroy(200,delay);

        //CB animation done

        bLinesDestroy(200,delay);

        //B lines done

        clip1Destroy(200,delay);

        //clip1 done

        bgLinesDestroy(150,delay);

        //bg lines done

        mainPaneDestroy(250,delay,scale);

        //build up animation done

    }


    public void createElements(){

        rect1 = new Rectangle();
        rect2 = new Rectangle();
        rect3 = new Rectangle();

        inner = new Circle();
        outer = new Circle();

        oBg = new Pane();

        lines = new Line[20];

        double[] points = {-130.76617431640625, 57.74456787109375, 180.23382568359375, 57.74456787109375, 180.23382568359375, 122.82843017578125, 198.23382568359375, 122.82843017578125, 198.23382568359375, 57.74456787109375, 245.23382568359375, 57.74456787109375, 245.23382568359375, 46.0, -203.76617431640625, 46.0, -203.76617431640625, 57.74456787109375, -147.76617431640625, 57.74456787109375, -147.76617431640625, 122.82843017578125, -130.76617431640625, 122.82843017578125};
        Polygon bench = new Polygon(points);
        bench.setScaleX(1.54);
        bench.setScaleY(1.4);


        polyLines = new Line[40];

        double linePX = -1160;
        double linePY = 0;

        Pane benchP = new Pane();
        benchP.setStyle("-fx-background-color: #F2F2F2");
        benchP.setClip(bench);
        bench.setLayoutX(275);
        bench.setLayoutY(-30);
        benchP.setPrefHeight(200);
        benchP.setPrefWidth(600);

        benchP.setLayoutX(0);
        benchP.setLayoutY(5);

        for ( int i = 0 ; i<19 ; i++ ){


            Line polyLine = new Line();

            polyLine.setStartX(0);
            polyLine.setEndX(2400);
            polyLine.setStartY(0);
            polyLine.setEndY(0);
            polyLine.setRotate(-30);
            polyLine.setFill(Color.web("#999999"));
            polyLine.setStroke(Color.web("#999999"));
            polyLine.setStrokeWidth(4);

            polyLines[i] = polyLine;
            polyLines[i].setLayoutX(linePX);
            polyLines[i].setLayoutY(linePY);
            benchP.getChildren().add(polyLines[i]);
            linePY +=20;

        }



        oBg.setClip(outer);
        oBg.setStyle("-fx-background-color: #F2F2F2 ");
        oBg.setPrefWidth(135);
        oBg.setPrefHeight(135);

        double radius = 67.5;
        double layX = 210-(radius);
        double layY = 172.5-(radius);

        oBg.setLayoutX(layX);
        oBg.setLayoutY(layY);

        double lineX = -100;
        double lineY = 0;

        for (int i = 0 ; i<19 ; i++){

            Line line = new Line();

            line.setStartX(100);
            line.setEndX(269);
            line.setStartY(0);
            line.setEndY(-109);
            line.setFill(Color.web("#999999"));
            line.setStroke(Color.web("#999999"));
            line.setStrokeWidth(4);

            lines[i] = line;
            lines[i].setLayoutX(lineX);
            lines[i].setLayoutY(lineY);
            oBg.getChildren().add(lines[i]);
            lineY +=20;

        }


        outer.setRadius(radius);
        inner.setRadius(radius/2);

        oBg.getChildren().add(inner);


        outer.setLayoutX((radius));
        outer.setLayoutY((radius));
        inner.setLayoutX((radius));
        inner.setLayoutY((radius));

        inner.setFill(Color.web("#08002A"));

        inner.setCenterX(outer.getCenterX());
        inner.setCenterY(outer.getCenterY());

        double width = 138.2;
        double height = 27;
        double offsetY = 105;
        double offsetX = 425;

        rect1.setWidth(width*0.75);
        rect2.setWidth(width*0.5);
        rect3.setWidth(width);

        rect1.setHeight(height);
        rect2.setHeight(height);
        rect3.setHeight(height);

        rect1.setLayoutY(offsetY);
        rect2.setLayoutY(offsetY+height*2);
        rect3.setLayoutY(offsetY+height*4);

        rect1.setLayoutX(offsetX);
        rect2.setLayoutX(offsetX);
        rect3.setLayoutX(offsetX);

        rect1.setFill(Color.web("#08002A"));
        rect2.setFill(Color.web("#08002A"));
        rect3.setFill(Color.web("#08002A"));

        ePane = new Pane();
        ePane.setStyle("-fx-background-color: #F2F2F2");
        ePane.setPrefWidth(30);
        ePane.setPrefHeight(135);
        ePane.setLayoutX(425);
        ePane.setLayoutY(105);

        eLines = new Line[40];
        double eX = -50;
        double eY = -90;

        for ( int i = 0 ; i<19 ; i++ ){


            Line eLine = new Line();

            eLine.setStartX(0);
            eLine.setEndX(240);
            eLine.setStartY(0);
            eLine.setEndY(0);
            eLine.setRotate(-30);
            eLine.setFill(Color.web("#999999"));
            eLine.setStroke(Color.web("#999999"));
            eLine.setStrokeWidth(4);

            eLines[i] = eLine;
            eLines[i].setLayoutX(eX);
            eLines[i].setLayoutY(eY);
            ePane.getChildren().add(eLines[i]);
            eY +=20;

        }



        dPane = new Pane();
        dPane.setStyle("-fx-background-color: #F2F2F2");
        dPane.setPrefWidth(30);
        dPane.setPrefHeight(80);
        dPane.setLayoutX(301);
        dPane.setLayoutY(128);


        dLines = new Line[40];
        double dX = -50;
        double dY = -92;

        for ( int i = 0 ; i<19 ; i++ ){


            Line dLine = new Line();

            dLine.setStartX(0);
            dLine.setEndX(240);
            dLine.setStartY(0);
            dLine.setEndY(0);
            dLine.setRotate(-30);
            dLine.setFill(Color.web("#999999"));
            dLine.setStroke(Color.web("#999999"));
            dLine.setStrokeWidth(4);

            dLines[i] = dLine;
            dLines[i].setLayoutX(dX);
            dLines[i].setLayoutY(dY);
            dPane.getChildren().add(dLines[i]);
            dY +=20;

        }

        Rectangle eClip = new Rectangle();
        Rectangle dClip = new Rectangle();

        eClip.setWidth(30);
        eClip.setHeight(135);
        dClip.setWidth(30);
        dClip.setHeight(80);

        ePane.setClip(eClip);
        dPane.setClip(dClip);

        HBox hbox = bt.createBenchText();
        hbox.setScaleX(0.45);
        hbox.setScaleY(0.45);
        hbox.setLayoutX(-130);
        hbox.setLayoutY(12.5);

        bottomPane = new AnchorPane();
        bottomPane.setStyle("-fx-background-color: #F2F2F2 ");
        bottomPane.setLayoutY(195);
        bottomPane.getChildren().addAll(benchP,hbox);

        Pane pane1 = createLogo(1);
        background.getPane().setStyle("-fx-background-radius: 0 ; -fx-background-color: #F2F2F2 ");

        background.getPane().setPrefWidth(600);


    }

    private int k;

    public void addElements(){

        createElements();
        animation.FadeIn(bottomPane,150,200);
        animation.FadeIn(ePane,150,200);
        animation.FadeIn(dPane,150,200);
        animation.FadeIn(rect1,150,200);
        animation.FadeIn(rect2,150,200);
        animation.FadeIn(rect3,150,200);
        animation.FadeIn(oBg,150,200);
        ScaleTransition scale = animation.ScaleReturn(rect1,50 ,1 ,1 ,50);

        if(k==0) {

            scale.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    backPane.getChildren().addAll( bottomPane, ePane, dPane, rect1, rect2, rect3, oBg);
                    k++;

                }

            });

        }



    }

    int i = 0;


    public void backgroundAdjust(int duration, int delay){

        animation.ExpandRectX(background.getClip(),273,600,duration/2,delay);
        animation.edgeAnimation(background.getClip(),80,40,duration,delay);
        animation.LinearMoveX(background.getPane(),duration/2,0,-163.5,delay);


    }

    public void moveCbRight(int duration, int delay){

        animation.LinearMoveX(cb.getsRight(),duration,0,145,delay);
        animation.LinearMoveX(cb.gettRight(),duration,0,145,delay);

    }

    public void retractBLines(int duration, int delay){

        for (int i =1 ; i<8 ; i+=2){

            animation.LinearMoveX(cb.getBgLines(i),duration,0,-105,delay-250);
            animation.LinearMoveY(cb.getBgLines(i),duration,0,61,delay-250);

        }

        for(int j=0 ; j<9 ; j +=2){

            animation.LinearMoveX(cb.getBgLines(j),(duration*2)/3,0,105,delay-250);
            animation.LinearMoveY(cb.getBgLines(j),(duration*2)/3,0,-61,delay-250);

        }

        animation.ScaleY(cb.getClip(),duration/3,1,0,delay);


    }

    public void createE(int duration, int delay){

        animation.FadeIn(rect1,100,delay);
        animation.FadeIn(rect2,100,delay);
        animation.FadeIn(rect3,100,delay);

        animation.ScaleX(rect1,duration,0,1,delay);
        animation.LinearMoveX(rect1,duration,-rect1.getWidth()/2,0,delay);
        animation.ScaleX(rect2,duration,0,1,delay);
        animation.LinearMoveX(rect2,duration,-rect2.getWidth()/2,0,delay);
        animation.ScaleX(rect3,duration,0,1,delay);
        animation.LinearMoveX(rect3,duration,-rect3.getWidth()/2,0,delay);


    }

    public void createO(int duration, int delay){

        animation.FadeIn(ePane,100,delay);
        animation.FadeIn(dPane,100,delay);
        animation.FadeIn(outer,100,delay);
        animation.FadeIn(inner,100,delay-500);
        animation.popup(outer,duration,delay);
        animation.popup(inner,duration,delay-500);

    }

    public void moveUp(int duration, int delay){

        animation.LinearMoveY(cb.gettRight(),duration,0,-70,delay);
        animation.LinearMoveY(cb.getsRight(),duration,0,-70,delay);
        animation.LinearMoveY(cb.getsLeft(),duration,0,-70,delay);
        animation.LinearMoveY(cb.gettLeft(),duration,0,-70,delay);
        animation.LinearMoveY(rect1,duration,0,-70,delay);
        animation.LinearMoveY(rect2,duration,0,-70,delay);
        animation.LinearMoveY(rect3,duration,0,-70,delay);


        animation.LinearMoveY(ePane,duration,0,-70,delay);
        animation.LinearMoveY(dPane,duration,0,-70,delay);

        animation.LinearMoveY(oBg,duration,0,-70,delay);


    }

    public void bringBench(int duration, int delay){

        animation.FadeIn(bottomPane,100,(delay*4)/6);
        animation.LinearMoveY(bottomPane,duration,100,0,(delay*4)/6);

        animation.FadeIn(bt.getB1(),100,delay);
        animation.LinearMoveX(bt.getB1(),duration/2,-150,0,delay);
        animation.FadeIn(bt.getB2(),100,delay-(duration/2));
        animation.LinearMoveY(bt.getB2(),duration/2,50,0,delay-(duration/2));

        animation.FadeIn(bt.getE1(),100,delay-(duration/2));
        animation.LinearMoveY(bt.getE1(),duration/2,50,0,delay-(duration/2));
        animation.FadeIn(bt.getE2(),100,delay);
        animation.LinearMoveX(bt.getE2(),duration/2,150,0,delay);

        animation.FadeIn(bt.getN(),100,delay-(duration/2));
        animation.LinearMoveY(bt.getN(),duration/2,50,0,delay-(duration/2));

        animation.FadeIn(bt.getC(),100,delay-(duration/2));
        animation.LinearMoveY(bt.getC(),duration/2,50,0,delay-(duration/2));

        animation.FadeIn(bt.getH(),100,delay-(duration/2));
        animation.LinearMoveY(bt.getH(),duration/2,50,0,delay-(duration/2));

    }

    public void bringOLines(int duration, int delay1){

        for(int k = 0 ; k<19 ; k++){

            animation.FadeIn(lines[k],100,delay1);

        }

        for (int i =1 ; i<18 ; i+=2){

            animation.LinearMoveX(lines[i],duration,-105,0,delay1);
            animation.LinearMoveY(lines[i],duration,69,0,delay1);

        }

        for(int j=0 ; j<19 ; j +=2){

            animation.LinearMoveX(lines[j],duration/2,105,0,delay1);
            animation.LinearMoveY(lines[j],duration/2,-69,0,delay1);

        }

    }

    public void bringDLines(int duration, int delay1){

        for(int k = 0 ; k<19 ; k++){

            animation.FadeIn(dLines[k],100,delay1);

        }

        for (int i =1 ; i<18 ; i+=2){

            animation.LinearMoveX(dLines[i],duration,-205,0,delay1);
            animation.LinearMoveY(dLines[i],duration,120,0,delay1);

        }

        for(int j=0 ; j<19 ; j +=2){

            animation.LinearMoveX(dLines[j],duration/3,105,0,delay1);
            animation.LinearMoveY(dLines[j],duration/3,-60,0,delay1);

        }

    }

    public void bringELines(int duration, int delay1){


        for(int k = 0 ; k<19 ; k++){

            animation.FadeIn(eLines[k],100,delay1);

        }

        for (int i =1 ; i<18 ; i+=2){

            animation.LinearMoveX(eLines[i],duration,-205,0,delay1);
            animation.LinearMoveY(eLines[i],duration,120,0,delay1);

        }

        for(int j=0 ; j<19 ; j +=2){

            animation.LinearMoveX(eLines[j],duration/3,105,0,delay1);
            animation.LinearMoveY(eLines[j],duration/3,-60,0,delay1);

        }



    }

    public ScaleTransition bringBenchLines(int duration, int delay1){


        for(int k = 0 ; k<19 ; k++){

            animation.FadeIn(polyLines[k],100,delay1);

        }

        for (int i =1 ; i<18 ; i+=2){

            animation.LinearMoveX(polyLines[i],duration,-2075,0,delay1);
            animation.LinearMoveY(polyLines[i],duration,1200,0,delay1);

        }

        for(int j=0 ; j<19 ; j +=2){

            animation.LinearMoveX(polyLines[j],duration,2075,0,delay1);
            animation.LinearMoveYReturn(polyLines[j],duration,-1200,0,delay1);

        }

        return animation.ScaleReturn(polyLines[18],duration,1,1,delay1);

    }


    public void backgroundRevert(int duration, int delay){

        animation.ExpandRectX(background.getClip(),600,273,duration/2,delay);
        animation.edgeAnimation(background.getClip(),40,80,duration,delay);
        animation.LinearMoveX(background.getPane(),duration/2,-163.5,0,delay);



    }

    public void moveCbBack(int duration, int delay){

        animation.LinearMoveX(cb.getsRight(),duration,145,0,delay);
        animation.LinearMoveX(cb.gettRight(),duration,145,0,delay);

    }

    public ScaleTransition bringBLines(int duration, int delay){

        for (int i =1 ; i<8 ; i+=2){

            animation.LinearMoveX(cb.getBgLines(i),duration,-105,0,delay-250);
            animation.LinearMoveY(cb.getBgLines(i),duration,61,0,delay-250);

        }

        for(int j=0 ; j<9 ; j +=2){

            animation.LinearMoveX(cb.getBgLines(j),(duration*2)/3,105,0,delay-250);
            animation.LinearMoveY(cb.getBgLines(j),(duration*2)/3,-61,0,delay-250);

        }

        animation.ScaleY(cb.getClip(),duration/3,0,1,delay);

        return animation.ScaleReturn(cb.getClip(),duration,1,1,delay);



    }

    public void removeE(int duration, int delay){

        animation.FadeOut(rect1,100,delay+duration-100);
        animation.FadeOut(rect2,100,delay+duration-100);
        animation.FadeOut(rect3,100,delay+duration-100);

        animation.ScaleX(rect1,duration,1,0,delay);
        animation.LinearMoveX(rect1,duration,0,-rect1.getWidth()/2,delay);
        animation.ScaleX(rect2,duration,1,0,delay);
        animation.LinearMoveX(rect2,duration,0,-rect2.getWidth()/2,delay);
        animation.ScaleX(rect3,duration,1,0,delay);
        animation.LinearMoveX(rect3,duration,0,-rect3.getWidth()/2,delay);


    }

    public void removeO(int duration, int delay){

        animation.FadeOut(ePane,100,delay-500+duration-100);
        animation.FadeOut(dPane,100,delay-500+duration-100);
        animation.FadeOut(outer,100,delay-500+duration-100);
        animation.FadeOut(inner,100,delay+duration-100);
        animation.popOut(outer,duration,delay-500);
        animation.popOut(inner,duration,delay);

    }

    public void moveDown(int duration, int delay){

        animation.LinearMoveY(cb.gettRight(),duration,-70,0,delay);
        animation.LinearMoveY(cb.getsRight(),duration,-70,0,delay);
        animation.LinearMoveY(cb.getsLeft(),duration,-70,0,delay);
        animation.LinearMoveY(cb.gettLeft(),duration,-70,0,delay);
        animation.LinearMoveY(rect1,duration,-70,0,delay);
        animation.LinearMoveY(rect2,duration,-70,0,delay);
        animation.LinearMoveY(rect3,duration,-70,0,delay);


        animation.LinearMoveY(ePane,duration,-70,0,delay);
        animation.LinearMoveY(dPane,duration,-70,0,delay);

        animation.LinearMoveY(oBg,duration,-70,0,delay);


    }

    public void removeBench(int duration, int delay){

        animation.FadeOut(bottomPane,200,(delay*4)/6+duration-200);
        animation.LinearMoveY(bottomPane,duration,0,100,(delay*4)/6);

        animation.FadeOut(bt.getB1(),200,delay-(duration/2)+duration-200);
        animation.LinearMoveX(bt.getB1(),duration/2,0,-150,delay-(duration/2));
        animation.FadeOut(bt.getB2(),200,delay+duration-200);
        animation.LinearMoveY(bt.getB2(),duration/2,0,50,delay);

        animation.FadeOut(bt.getE1(),200,delay+duration-200);
        animation.LinearMoveY(bt.getE1(),duration/2,0,50,delay);
        animation.FadeOut(bt.getE2(),200,delay-(duration/2)+duration-200);
        animation.LinearMoveX(bt.getE2(),duration/2,0,150,delay-(duration/2));

        animation.FadeOut(bt.getN(),200,delay+duration-200);
        animation.LinearMoveY(bt.getN(),duration/2,0,50,delay);

        animation.FadeOut(bt.getC(),200,delay+duration-200);
        animation.LinearMoveY(bt.getC(),duration/2,0,50,delay);

        animation.FadeOut(bt.getH(),200,delay+duration-200);
        animation.LinearMoveY(bt.getH(),duration/2,0,50,delay);

    }

    public void removeOLines(int duration, int delay1){

        for(int k = 0 ; k<19 ; k++){

            animation.FadeOut(lines[k],100,delay1+duration-100);

        }

        for (int i =1 ; i<18 ; i+=2){

            animation.LinearMoveX(lines[i],duration,0,-105,delay1);
            animation.LinearMoveY(lines[i],duration,0,69,delay1);

        }

        for(int j=0 ; j<19 ; j +=2){

            animation.LinearMoveX(lines[j],duration/2,0,105,delay1);
            animation.LinearMoveY(lines[j],duration/2,0,-69,delay1);

        }

    }

    public void removeDLines(int duration, int delay1){

        for(int k = 0 ; k<19 ; k++){

            animation.FadeOut(dLines[k],100,delay1+duration-100);

        }

        for (int i =1 ; i<18 ; i+=2){

            animation.LinearMoveX(dLines[i],duration,0,-205,delay1);
            animation.LinearMoveY(dLines[i],duration,0,120,delay1);

        }

        for(int j=0 ; j<19 ; j +=2){

            animation.LinearMoveX(dLines[j],duration/3,0,105,delay1);
            animation.LinearMoveY(dLines[j],duration/3,0,-60,delay1);

        }

    }

    public void removeELines(int duration, int delay1){


        for(int k = 0 ; k<19 ; k++){

            animation.FadeOut(eLines[k],100,delay1+duration-100);

        }

        for (int i =1 ; i<18 ; i+=2){

            animation.LinearMoveX(eLines[i],duration,0,-205,delay1);
            animation.LinearMoveY(eLines[i],duration,0,120,delay1);

        }

        for(int j=0 ; j<19 ; j +=2){

            animation.LinearMoveX(eLines[j],duration/3,0,105,delay1);
            animation.LinearMoveY(eLines[j],duration/3,0,-60,delay1);

        }



    }

    public void removeBenchLines(int duration, int delay1){


        for(int k = 0 ; k<19 ; k++){

            animation.FadeOut(polyLines[k],100,delay1+duration-100);

        }

        for (int i =1 ; i<18 ; i+=2){

            animation.LinearMoveX(polyLines[i],duration,0,-2075,delay1);
            animation.LinearMoveY(polyLines[i],duration,0,1200,delay1);

        }

        for(int j=0 ; j<19 ; j +=2){

            animation.LinearMoveX(polyLines[j],duration,0,2075,delay1);
            animation.LinearMoveY(polyLines[j],duration,0,-1200,delay1);

        }



    }



    public ScaleTransition extend(int delay,double scale){

        mainPane.setScaleX(scale);
        mainPane.setScaleY(scale);


        retractBLines(750,400+delay);


        backgroundAdjust(300,500+delay);

        moveCbRight(300,500+delay);


        createE(150,1000+delay);

        createO(350,1250+delay);

        bringOLines(1000,1250+delay);

        bringDLines(1000,1250+delay);

        bringELines(1000,1250+delay);

        moveUp(150,1800+delay);


        bringBench(250,2000+delay);

        return bringBenchLines(1500,1500+delay);

    }


    public ScaleTransition retract(int delay , double scale ){

        mainPane.setScaleX(scale);
        mainPane.setScaleY(scale);

        removeBenchLines(500,delay);

        removeBench(500,500+delay);

        moveDown(250,500+delay);

        removeELines(2000,750+delay);

        removeDLines(2000,750+delay);

        removeOLines(2000,750+delay);

        removeO(500,750+delay);

        removeE(250,1000+delay);

        moveCbBack(350,750+delay);

        backgroundRevert(400,750+delay);

        return bringBLines(500,1000+delay);

    }


    public ScaleTransition makeBig(int delay,double ogScale){

//
//        mainPane.setScaleX(ogScale);
//        mainPane.setScaleY(ogScale);

        ScaleTransition scale = play(delay,ogScale);

        if(j>=0) {
            scale.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    if(i==0){
                        addElements();
                        i++;
                    }

                    ScaleTransition scale1 = extend(0,ogScale);
                    j++;

                }

            });
        }

        return scale;

    }


    public void vanishBig(int delay,double ogScale){


        ScaleTransition scale = retract(delay,ogScale);

        if(j>=0) {
            scale.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    if(i==0){
                        addElements();
                        i++;
                    }

                    finish(0,ogScale);

                    j++;
                }
            });
        }


    }


    int j = 0;

    public void fullAnimation(int delay,double ogScale){

//
//        mainPane.setScaleX(ogScale);
//        mainPane.setScaleY(ogScale);

        ScaleTransition scale = play(delay,ogScale);

        if(j>=0) {
            scale.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    if(i==0){
                        addElements();
                        i++;
                    }

                    ScaleTransition scale1 = extend(0,ogScale);

                    if(j>=0) {
                        scale1.setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                                ScaleTransition scale2 = retract(0,ogScale);

                                if(j>=0) {

                                    scale2.setOnFinished(new EventHandler<ActionEvent>() {

                                        @Override
                                        public void handle(ActionEvent event) {

                                            finish(0,ogScale);
                                            j++;

                                        }

                                    });

                                }

                                j++;
                            }
                        });
                    }
                    j++;
                }
            });
        }



//        retractBLines(1500,250+delay+2000);
//
//        backgroundAdjust(750,500+delay+2000);
//
//        moveCbRight(750,500+delay+2000);
//
//        createE(250,1000+delay+2000);
//
//        createO(500,1250+delay+2000);
//
//        bringOLines(1500,1750+delay+2000);
//
//        bringDLines(1500,1750+delay+2000);
//
//        bringELines(1500,1750+delay+2000);
//
//        moveUp(250,2250+delay+2000);
//
//        bringBenchLines(2500,2250+delay+2000);
//
//        bringBench(500,3000+delay+2000);
//
//
//
//
//
//
//
//        removeBenchLines(1000,delay+6750);
//
//        removeBench(750,1000+delay+6750);
//
//        moveDown(250,1000+delay+6750);
//
//        removeELines(2500,1250+delay+6750);
//
//        removeDLines(2500,1250+delay+6750);
//
//        removeOLines(2500,1250+delay+6750);
//
//        removeO(500,1750+delay+6750);
//
//        removeE(250,2000+delay+6750);
//
//        moveCbBack(500,2000+delay+6750);
//
//        backgroundRevert(750,2000+delay+6750);
//
//        bringBLines(1500,2250+delay+6750);
//
//
//




//
//        cbDestroy(250,delay+750+10500);
//
//        //CB animation done
//
//        bLinesDestroy(750,delay+250+10500);
//
//        //B lines done
//
//        clip1Destroy(325,delay+675+10500);
//
//        //clip1 done
//
//        bgLinesDestroy(1000,delay+10500);
//
//        //bg lines done
//
//        mainPaneDestroy(200,delay+1150+10500);
//
//        //build up animation done



    }


    public CB getCb() {
        return cb;
    }

    public Back getBackground() {
        return background;
    }


}



class Back{

    private Line line ;
    private Line[] bgLines ;
    private Pane pane;
    private Rectangle clip;

    public Back(){

        pane = new Pane();

        pane.setStyle("-fx-background-color: #F2F2F2  ; -fx-background-radius: 40 ");

    }


    public Line bgLine(){

        line = new Line();
        line.setStartX(-100);
        line.setEndX(500);
        line.setStartY(0);
        line.setEndY(345);
        line.setFill(Color.web("#e6e6e6"));
        line.setStroke(Color.web("#e6e6e6"));
        line.setStrokeWidth(4);
        return line;

    }

    public Pane createBackground(){

        bgLines = new Line[31];
        clip = new Rectangle();

        clip.setArcWidth(80);
        clip.setArcHeight(80);
        clip.setHeight(273);
        clip.setWidth(273);


        double layoutX = 100 ;
        double layoutY = -350 ;

        for(int i = 0 ; i<30 ; i++){


            bgLines[i] = bgLine();
            bgLines[i].setLayoutY(layoutY);
            bgLines[i].setLayoutX(layoutX);

            pane.getChildren().add(bgLines[i]);
            layoutY += 20.0 ;

        }


        pane.setClip(clip);
        return pane;

    }



    public Line[] getBgLines() {

        return bgLines;

    }

    public Line getBgLines(int index) {

        return bgLines[index];

    }

    public Pane getPane() {

        return pane;

    }

    public Rectangle getClip() {

        return clip;

    }
}

class CB{

    private Polygon sLeft;
    private Polygon tLeft;
    private Polygon sRight;
    private Polygon tRight;
    private Line line;
    private Line[] bgLines;
    private Rectangle clip;

    CB(){


    }

    public Group createC(){

        Group group1 = new Group();

        Stop[] stop1 = {new Stop(0,Color.web("#2EBCFD")),new Stop(1,Color.web("#2EE2E2"))};
        LinearGradient studentLeft = new LinearGradient(0,0,1,1, true , CycleMethod.NO_CYCLE , stop1);
        Stop[] stop2 = {new Stop(0,Color.web("#130049")),new Stop(1,Color.web("#070026"))};
        LinearGradient teacherLeft = new LinearGradient(1,0,0,1, true , CycleMethod.NO_CYCLE , stop2);

        double[] points = {0, 44.0, 92.0, 97.0, 92.0, 54.0, 0, 0};
        sLeft = new Polygon(points);
        sLeft.setFill(studentLeft);
        sLeft.setLayoutX(30);
        sLeft.setLayoutY(146);
        sLeft.setScaleX(0.9);
        sLeft.setScaleY(0.9);

        double[] points1 = {0, -44.0, 92.0, -97.0, 92.0, -54.0, 0, 0};
        tLeft = new Polygon(points1);
        tLeft.setFill(teacherLeft);
        tLeft.setLayoutX(30.5);
        tLeft.setLayoutY(195);
        tLeft.setScaleX(0.9);
        tLeft.setScaleY(0.9);

        group1.getChildren().addAll(tLeft,sLeft);

        return group1;

    }

    public Group createB(){


        Group group2 = new Group();

        Stop[] stop1 = {new Stop(0,Color.web("#2EBCFD")),new Stop(1,Color.web("#2EE2E2"))};
        LinearGradient studentRight = new LinearGradient(1,1,0,0, true , CycleMethod.NO_CYCLE , stop1);
        Stop[] stop2 = {new Stop(0,Color.web("#130049")),new Stop(1,Color.web("#070026"))};
        LinearGradient teacherRight = new LinearGradient(0,1,1,0, true , CycleMethod.NO_CYCLE , stop2);

        double[] points = {0, -44.0, -92.0, -97.0, -92.0, -54.0, 0, 0};
        sRight = new Polygon(points);
        sRight.setFill(studentRight);
        sRight.setLayoutX(243);
        sRight.setLayoutY(195);
        sRight.setScaleX(0.9);
        sRight.setScaleY(0.9);

        double[] points1 = {0, 44.0, -92.0, 97.0, -92.0, 54.0, 0, 0};
        tRight = new Polygon(points1);
        tRight.setFill(teacherRight);
        tRight.setLayoutX(242.5);
        tRight.setLayoutY(146);
        tRight.setScaleX(0.9);
        tRight.setScaleY(0.9);

        group2.getChildren().addAll(tRight,sRight);

        return group2;



    }

    public Group createB2(){

        Group g3 = new Group();
        Pane p1 = createBack();

        g3.getChildren().add(p1);

        return g3;

    }


    public Line bgLine(){

        line = new Line();
        line.setStartX(100);
        line.setEndX(150);
        line.setStartY(0);
        line.setEndY(-29);
        line.setFill(Color.web("#999999"));
        line.setStroke(Color.web("#999999"));
        line.setStrokeWidth(4);
        return line;

    }

    public Pane createBack(){

        bgLines = new Line[10];
        Pane pane = new Pane();
        pane.setLayoutX(156);
        pane.setLayoutY(30);
        pane.setStyle("-fx-background-color: #F2F2F2 ");
        clip = new Rectangle();

        clip.setArcWidth(0);
        clip.setArcHeight(0);
        clip.setHeight(170);
        clip.setWidth(32);
        double layoutX = -100 ;
        double layoutY = 8 ;

        for(int i = 0 ; i<9 ; i++){


            bgLines[i] = bgLine();
            bgLines[i].setLayoutY(layoutY);
            bgLines[i].setLayoutX(layoutX);
            pane.getChildren().add(bgLines[i]);
            layoutY += 20.0 ;

        }

        pane.setClip(clip);
        return pane;

    }




    public Polygon getsLeft() {
        return sLeft;
    }

    public Polygon gettLeft() {
        return tLeft;
    }

    public Polygon getsRight() {
        return sRight;
    }

    public Polygon gettRight() {
        return tRight;
    }

    public Line getLine() {
        return line;
    }

    public Line[] getBgLines() {
        return bgLines;
    }

    public Line getBgLines(int index) {
        return bgLines[index] ;
    }

    public Rectangle getClip() {
        return clip;
    }
}
