package sample;

import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class CustomAnimations {


    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    
    public void ScaleXLeft(Rectangle node, int duration , int delay){

        ScaleX(node,duration,0,1,delay);
        LinearMoveX(node,duration,-node.getWidth()/2,0,delay);

    }
    public void ScaleXLeft(TextField node, int duration , int delay){

        ScaleX(node,duration,0,1,delay);
        LinearMoveX(node,duration,-node.getWidth()/2,0,delay);

    }
    public void ScaleXLeft(Label node, int duration , int delay){

        ScaleX(node,duration,0,1,delay);
        LinearMoveX(node,duration,-node.getWidth()/2,0,delay);

    }
    public void ScaleXLeft(Button node, int duration , int delay){

        ScaleX(node,duration,0,1,delay);
        LinearMoveX(node,duration,-node.getWidth()/2,0,delay);

    }
    
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    
    
    
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    
    public void ScaleXRight(Rectangle node, int duration , int delay){

        ScaleX(node,duration,0,1,delay);
        LinearMoveX(node,duration,node.getWidth()/2,0,delay);

    }
    public void ScaleXRight(TextField node, int duration , int delay){

        ScaleX(node,duration,0,1,delay);
        LinearMoveX(node,duration,node.getWidth()/2,0,delay);

    }
    public void ScaleXRight(Label node, int duration , int delay){

        ScaleX(node,duration,0,1,delay);
        LinearMoveX(node,duration,node.getWidth()/2,0,delay);

    }
    public void ScaleXRight(Button node, int duration , int delay){

        ScaleX(node,duration,0,1,delay);
        LinearMoveX(node,duration,node.getWidth()/2,0,delay);

    }
    
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    
    
    
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    
    public void ScaleXTop(Rectangle node, int duration , int delay){

        ScaleY(node,duration,0,1,delay);
        LinearMoveY(node,duration,-node.getHeight()/2,0,delay);

    }
    public void ScaleXTop(TextField node, int duration , int delay){

        ScaleY(node,duration,0,1,delay);
        LinearMoveY(node,duration,-node.getHeight()/2,0,delay);

    }
    public void ScaleXTop(Label node, int duration , int delay){

        ScaleY(node,duration,0,1,delay);
        LinearMoveY(node,duration,-node.getHeight()/2,0,delay);

    }
    public void ScaleXTop(Button node, int duration , int delay){

        ScaleY(node,duration,0,1,delay);
        LinearMoveY(node,duration,-node.getHeight()/2,0,delay);

    }
    
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    
    
    
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    
    public void ScaleXBottom(Rectangle node, int duration , int delay){

        ScaleY(node,duration,0,1,delay);
        LinearMoveY(node,duration,node.getHeight()/2,0,delay);

    }
    public void ScaleXBottom(TextField node, int duration , int delay){

        ScaleY(node,duration,0,1,delay);
        LinearMoveY(node,duration,node.getHeight()/2,0,delay);

    }
    public void ScaleXBottom(Label node, int duration , int delay){

        ScaleY(node,duration,0,1,delay);
        LinearMoveY(node,duration,node.getHeight()/2,0,delay);

    }
    public void ScaleXBottom(Button node, int duration , int delay){

        ScaleY(node,duration,0,1,delay);
        LinearMoveY(node,duration,node.getHeight()/2,0,delay);

    }
    
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    //********************************************************************
    
    
    

    public void hoverOn(Button button2, String colour1 , String colour2 , String colour3 , String colour4 , double radius, double duration) {


        CornerRadii radii = new CornerRadii(radius);

        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.millis(duration);


        double op1 = 1;
        double op2 = 0;

        int i = 0;

        KeyValue startKeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1)),new Stop(1,Color.web(colour2))), radii, null)));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);

        KeyFrame[] keyframes1 = new KeyFrame[20];

        while (op1 > 0) {


            KeyValue stop1KeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1,op1)),new Stop(1,Color.web(colour2,op1))), radii, null)));
            keyframes1[i] = new KeyFrame(Duration.millis(((i + 1) * (duration / 20))), stop1KeyValue);
            op1 = op1 - 0.05;
            i++;

        }

        int k = 0;

        KeyFrame[] keyframes2 = new KeyFrame[20];

        while (op2 < 1) {


            KeyValue stop2KeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3,op2)),new Stop(1,Color.web(colour4,op2))), radii, null)));
            keyframes2[k] = new KeyFrame(Duration.millis(((k + 1) * (duration / 20))), stop2KeyValue);
            op2 = op2 + 0.05;
            k++;

        }

        KeyValue endKeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3)),new Stop(1,Color.web(colour4))), radii, null)));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(keyframes1[0],keyframes1[1], keyframes1[2],
                keyframes1[3], keyframes1[4],keyframes1[5],keyframes1[6],keyframes1[7],keyframes1[8],keyframes1[9],keyframes2[10],keyframes2[11], keyframes2[12], keyframes2[13], keyframes2[14]
                , keyframes2[15], keyframes2[16], keyframes2[17], keyframes2[18], keyframes2[19]);

        animation.setCycleCount(1);
        animation.play();

    }

    public void hoverOff(Button button2, String colour1 , String colour2 , String colour3 , String colour4 , double radius, double duration) {


        hoverOn(button2, colour3,colour4,colour1,colour2, radius, duration);

    }

    public void hoverOnText(Button button2, String colour1 , String colour2 , String colour3 , String colour4 , double duration) {



        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.millis(duration);


        double op1 = 1;
        double op2 = 0;

        int i = 0;

        KeyValue startKeyValue = new KeyValue(button2.textFillProperty(), new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1)),new Stop(1,Color.web(colour2))));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);

        KeyFrame[] keyframes1 = new KeyFrame[20];

        while (op1 > 0) {


            KeyValue stop1KeyValue = new KeyValue(button2.textFillProperty(), new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1,op1)),new Stop(1,Color.web(colour2,op1))));
            keyframes1[i] = new KeyFrame(Duration.millis(((i + 1) * (duration / 20))), stop1KeyValue);
            op1 = op1 - 0.05;
            i++;

        }

        int k = 0;

        KeyFrame[] keyframes2 = new KeyFrame[20];

        while (op2 < 1) {


            KeyValue stop2KeyValue = new KeyValue(button2.textFillProperty(), new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3,op2)),new Stop(1,Color.web(colour4,op2))));
            keyframes2[k] = new KeyFrame(Duration.millis(((k + 1) * (duration / 20))), stop2KeyValue);
            op2 = op2 + 0.05;
            k++;

        }

        KeyValue endKeyValue = new KeyValue(button2.textFillProperty(), new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3)),new Stop(1,Color.web(colour4))));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(keyframes1[0],keyframes1[1], keyframes1[2],
                keyframes1[3], keyframes1[4],keyframes1[5],keyframes1[6],keyframes1[7],keyframes1[8],keyframes1[9],keyframes2[10],keyframes2[11], keyframes2[12], keyframes2[13], keyframes2[14]
                , keyframes2[15], keyframes2[16], keyframes2[17], keyframes2[18], keyframes2[19]);

        animation.setCycleCount(1);
        animation.play();

    }

    public void hoverOffText(Button button2, String colour1 , String colour2 , String colour3 , String colour4 , double duration) {


        hoverOnText(button2, colour3,colour4,colour1,colour2, duration);

    }

    public void hoverOnText(ToggleButton button2, String colour1 , String colour2 , String colour3 , String colour4 , double duration) {



        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.millis(duration);


        double op1 = 1;
        double op2 = 0;

        int i = 0;

        KeyValue startKeyValue = new KeyValue(button2.textFillProperty(), new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1)),new Stop(1,Color.web(colour2))));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);

        KeyFrame[] keyframes1 = new KeyFrame[20];

        while (op1 > 0) {


            KeyValue stop1KeyValue = new KeyValue(button2.textFillProperty(), new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1,op1)),new Stop(1,Color.web(colour2,op1))));
            keyframes1[i] = new KeyFrame(Duration.millis(((i + 1) * (duration / 20))), stop1KeyValue);
            op1 = op1 - 0.05;
            i++;

        }

        int k = 0;

        KeyFrame[] keyframes2 = new KeyFrame[20];

        while (op2 < 1) {


            KeyValue stop2KeyValue = new KeyValue(button2.textFillProperty(), new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3,op2)),new Stop(1,Color.web(colour4,op2))));
            keyframes2[k] = new KeyFrame(Duration.millis(((k + 1) * (duration / 20))), stop2KeyValue);
            op2 = op2 + 0.05;
            k++;

        }

        KeyValue endKeyValue = new KeyValue(button2.textFillProperty(), new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3)),new Stop(1,Color.web(colour4))));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(keyframes1[0],keyframes1[1], keyframes1[2],
                keyframes1[3], keyframes1[4],keyframes1[5],keyframes1[6],keyframes1[7],keyframes1[8],keyframes1[9],keyframes2[10],keyframes2[11], keyframes2[12], keyframes2[13], keyframes2[14]
                , keyframes2[15], keyframes2[16], keyframes2[17], keyframes2[18], keyframes2[19]);

        animation.setCycleCount(1);
        animation.play();

    }

    public void hoverOffText(ToggleButton button2, String colour1 , String colour2 , String colour3 , String colour4 , double duration) {


        hoverOnText(button2, colour3,colour4,colour1,colour2, duration);

    }

    public Animation hoverOn(ToggleButton button2, String colour1 , String colour2 , String colour3 , String colour4 , double radius, double duration) {


        CornerRadii radii = new CornerRadii(radius);

        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.millis(duration);


        double op1 = 1;
        double op2 = 0;

        int i = 0;

        KeyValue startKeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1)),new Stop(1,Color.web(colour2))), radii, null)));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);

        KeyFrame[] keyframes1 = new KeyFrame[20];

        while (op1 > 0) {


            KeyValue stop1KeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1,op1)),new Stop(1,Color.web(colour2,op1))), radii, null)));
            keyframes1[i] = new KeyFrame(Duration.millis(((i + 1) * (duration / 20))), stop1KeyValue);
            op1 = op1 - 0.05;
            i++;

        }

        int k = 0;

        KeyFrame[] keyframes2 = new KeyFrame[20];

        while (op2 < 1) {


            KeyValue stop2KeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3,op2)),new Stop(1,Color.web(colour4,op2))), radii, null)));
            keyframes2[k] = new KeyFrame(Duration.millis(((k + 1) * (duration / 20))), stop2KeyValue);
            op2 = op2 + 0.05;
            k++;

        }

        KeyValue endKeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3)),new Stop(1,Color.web(colour4))), radii, null)));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(keyframes1[0],keyframes1[1], keyframes1[2],
                keyframes1[3], keyframes1[4],keyframes1[5],keyframes1[6],keyframes1[7],keyframes1[8],keyframes1[9],keyframes2[10],keyframes2[11], keyframes2[12], keyframes2[13], keyframes2[14]
                , keyframes2[15], keyframes2[16], keyframes2[17], keyframes2[18], keyframes2[19]);

        animation.setCycleCount(1);
        animation.play();
        return animation;

    }

    public void hoverOff(ToggleButton button2, String colour1 , String colour2 , String colour3 , String colour4 , double radius, double duration) {


        hoverOn(button2, colour3,colour4,colour1,colour2, radius, duration);

    }

    public void ColourShiftPane(Pane button2, String colour1 , String colour2 , String colour3 , String colour4 , double radius, double duration,double delay) {


        CornerRadii radii = new CornerRadii(radius);

        Duration startDuration = Duration.millis(delay);
        Duration endDuration = Duration.millis(duration);


        double op1 = 1;
        double op2 = 0;

        int i = 0;

        KeyValue startKeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1)),new Stop(1,Color.web(colour2))), radii, null)));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);

        KeyFrame[] keyframes1 = new KeyFrame[20];

        while (op1 > 0) {


            KeyValue stop1KeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1,op1)),new Stop(1,Color.web(colour2,op1))), radii, null)));
            keyframes1[i] = new KeyFrame(Duration.millis(((i + 1) * (duration / 20))), stop1KeyValue);
            op1 = op1 - 0.05;
            i++;

        }

        int k = 0;

        KeyFrame[] keyframes2 = new KeyFrame[20];

        while (op2 < 1) {


            KeyValue stop2KeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3,op2)),new Stop(1,Color.web(colour4,op2))), radii, null)));
            keyframes2[k] = new KeyFrame(Duration.millis(((k + 1) * (duration / 20))), stop2KeyValue);
            op2 = op2 + 0.05;
            k++;

        }

        KeyValue endKeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3)),new Stop(1,Color.web(colour4))), radii, null)));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(keyframes1[0],keyframes1[1], keyframes1[2],
                keyframes1[3], keyframes1[4],keyframes1[5],keyframes1[6],keyframes1[7],keyframes1[8],keyframes1[9],keyframes2[10],keyframes2[11], keyframes2[12], keyframes2[13], keyframes2[14]
                , keyframes2[15], keyframes2[16], keyframes2[17], keyframes2[18], keyframes2[19]);

        animation.setCycleCount(1);
        animation.play();

    }

    public void ColourShiftRect(Rectangle button2, String colour1 , String colour2 , String colour3 , String colour4 , double duration,double delay) {


        Duration startDuration = Duration.millis(delay);
        Duration endDuration = Duration.millis(duration);


        double op1 = 1;
        double op2 = 0;

        int i = 0;

        KeyValue startKeyValue = new KeyValue(button2.fillProperty(), new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1)),new Stop(1,Color.web(colour2))));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);

        KeyFrame[] keyframes1 = new KeyFrame[20];

        while (op1 > 0) {


            KeyValue stop1KeyValue = new KeyValue(button2.fillProperty(), new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1,op1)),new Stop(1,Color.web(colour2,op1))));
            keyframes1[i] = new KeyFrame(Duration.millis(((i + 1) * (duration / 20))), stop1KeyValue);
            op1 = op1 - 0.05;
            i++;

        }

        int k = 0;

        KeyFrame[] keyframes2 = new KeyFrame[20];

        while (op2 < 1) {


            KeyValue stop2KeyValue = new KeyValue(button2.fillProperty(),new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3,op2)),new Stop(1,Color.web(colour4,op2))));
            keyframes2[k] = new KeyFrame(Duration.millis(((k + 1) * (duration / 20))), stop2KeyValue);
            op2 = op2 + 0.05;
            k++;

        }

        KeyValue endKeyValue = new KeyValue(button2.fillProperty(), new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3)),new Stop(1,Color.web(colour4))));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(keyframes1[0],keyframes1[1], keyframes1[2],
                keyframes1[3], keyframes1[4],keyframes1[5],keyframes1[6],keyframes1[7],keyframes1[8],keyframes1[9],keyframes2[10],keyframes2[11], keyframes2[12], keyframes2[13], keyframes2[14]
                , keyframes2[15], keyframes2[16], keyframes2[17], keyframes2[18], keyframes2[19]);

        animation.setCycleCount(1);
        animation.play();

    }
    public void ColourShiftRectBd(Rectangle button2, String colour1 , String colour2 , String colour3 , String colour4 , double duration,double delay) {


        Duration startDuration = Duration.millis(delay);
        Duration endDuration = Duration.millis(duration);


        double op1 = 1;
        double op2 = 0;

        int i = 0;

        KeyValue startKeyValue = new KeyValue(button2.strokeProperty(), new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1)),new Stop(1,Color.web(colour2))));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);

        KeyFrame[] keyframes1 = new KeyFrame[20];

        while (op1 > 0) {


            KeyValue stop1KeyValue = new KeyValue(button2.strokeProperty(), new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1,op1)),new Stop(1,Color.web(colour2,op1))));
            keyframes1[i] = new KeyFrame(Duration.millis(((i + 1) * (duration / 20))), stop1KeyValue);
            op1 = op1 - 0.05;
            i++;

        }

        int k = 0;

        KeyFrame[] keyframes2 = new KeyFrame[20];

        while (op2 < 1) {


            KeyValue stop2KeyValue = new KeyValue(button2.strokeProperty(),new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3,op2)),new Stop(1,Color.web(colour4,op2))));
            keyframes2[k] = new KeyFrame(Duration.millis(((k + 1) * (duration / 20))), stop2KeyValue);
            op2 = op2 + 0.05;
            k++;

        }

        KeyValue endKeyValue = new KeyValue(button2.strokeProperty(), new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3)),new Stop(1,Color.web(colour4))));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(keyframes1[0],keyframes1[1], keyframes1[2],
                keyframes1[3], keyframes1[4],keyframes1[5],keyframes1[6],keyframes1[7],keyframes1[8],keyframes1[9],keyframes2[10],keyframes2[11], keyframes2[12], keyframes2[13], keyframes2[14]
                , keyframes2[15], keyframes2[16], keyframes2[17], keyframes2[18], keyframes2[19]);

        animation.setCycleCount(1);
        animation.play();

    }

    public void PaneToWhite(Pane button2, double radius, double duration,double delay) {


        CornerRadii radii = new CornerRadii(radius);

        Duration startDuration = Duration.millis(duration);
        Duration endDuration = Duration.millis(duration);


        double op1 = 1;


        int i = 0;

        KeyValue startKeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web("#1a1a1a")),new Stop(1,Color.web("#1a1a1a"))), radii, null)));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);

        KeyFrame[] keyframes1 = new KeyFrame[20];

        while (op1 > 0) {


            KeyValue stop1KeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web("#1a1a1a",op1)),new Stop(1,Color.web("#1a1a1a",op1))), radii, null)));
            keyframes1[i] = new KeyFrame(Duration.millis(((i + 1) * (duration / 20))), stop1KeyValue);
            op1 = op1 - 0.05;
            i++;

        }


        KeyValue endKeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web("#1a1a1a")),new Stop(1,Color.web("#1a1a1a"))), radii, null)));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(keyframes1[0],keyframes1[1], keyframes1[2],
                keyframes1[3], keyframes1[4],keyframes1[5],keyframes1[6],keyframes1[7],keyframes1[8],keyframes1[9],keyframes1[10],keyframes1[11],keyframes1[12],keyframes1[13]
                ,keyframes1[14],keyframes1[15],keyframes1[16],keyframes1[17],keyframes1[18],keyframes1[19]);

        animation.setCycleCount(1);
        animation.play();

    }

    public void PaneToBlack(Pane button2, double radius, double duration,double delay) {


        CornerRadii radii = new CornerRadii(radius);

        Duration startDuration = Duration.millis(duration);
        Duration endDuration = Duration.millis(duration);


        double op1 = 0;


        int i = 0;

        KeyValue startKeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web("#1a1a1a")),new Stop(1,Color.web("#1a1a1a"))), radii, null)));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);

        KeyFrame[] keyframes1 = new KeyFrame[20];

        while (op1 < 1) {


            KeyValue stop1KeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web("#1a1a1a",op1)),new Stop(1,Color.web("#1a1a1a",op1))), radii, null)));
            keyframes1[i] = new KeyFrame(Duration.millis(((i + 1) * (duration / 20))), stop1KeyValue);
            op1 = op1 + 0.05;
            i++;

        }


        KeyValue endKeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web("#1a1a1a")),new Stop(1,Color.web("#1a1a1a"))), radii, null)));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(keyframes1[0],keyframes1[1], keyframes1[2],
                keyframes1[3], keyframes1[4],keyframes1[5],keyframes1[6],keyframes1[7],keyframes1[8],keyframes1[9],keyframes1[10],keyframes1[11],keyframes1[12],keyframes1[13]
                ,keyframes1[14],keyframes1[15],keyframes1[16],keyframes1[17],keyframes1[18],keyframes1[19]);

        animation.setCycleCount(1);
        animation.play();

    }



    public void hoverOnbg(Button button2, String colour1 , String colour2 , String colour3 , String colour4 , double radius, double border, double duration) {


        CornerRadii radii = new CornerRadii(radius);

        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.millis(duration);


        double op1 = 1;
        double op2 = 0;

        int i = 0;

        KeyValue startKeyValue = new KeyValue(button2.borderProperty(), new Border(new BorderStroke(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1)),new Stop(1,Color.web(colour2))), BorderStrokeStyle.SOLID, radii,BorderStroke.MEDIUM)));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);

        KeyFrame[] keyframes1 = new KeyFrame[20];

        while (op1 > 0) {


            KeyValue stop1KeyValue = new KeyValue(button2.borderProperty(),new Border(new BorderStroke(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1)),new Stop(1,Color.web(colour2))), BorderStrokeStyle.SOLID, radii,new BorderWidths(border))));
            keyframes1[i] = new KeyFrame(Duration.millis(((i + 1) * (duration / 20))), stop1KeyValue);
            op1 = op1 - 0.05;
            i++;

        }

        int k = 0;

        KeyFrame[] keyframes2 = new KeyFrame[20];

        while (op2 < 1) {


            KeyValue stop2KeyValue = new KeyValue(button2.borderProperty(),new Border(new BorderStroke(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour4)),new Stop(1,Color.web(colour4))), BorderStrokeStyle.SOLID, radii,new BorderWidths(border))));
            keyframes2[k] = new KeyFrame(Duration.millis(((k + 1) * (duration / 20))), stop2KeyValue);
            op2 = op2 + 0.05;
            k++;

        }

        KeyValue endKeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3)),new Stop(1,Color.web(colour4))), radii, null)));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(keyframes1[0],keyframes1[1], keyframes1[2],
                keyframes1[3], keyframes1[4],keyframes1[5],keyframes1[6],keyframes1[7],keyframes1[8],keyframes1[9],keyframes2[10],keyframes2[11], keyframes2[12], keyframes2[13], keyframes2[14]
                , keyframes2[15], keyframes2[16], keyframes2[17], keyframes2[18], keyframes2[19]);

        animation.setCycleCount(1);
        animation.play();

    }

    public void hoverOffbg(Button button2, String colour1 , String colour2 , String colour3 , String colour4 , double radius, double border, double duration) {


        hoverOnbg(button2, colour3,colour4,colour1,colour2, radius, border, duration);

    }
    public void hoverOnbg(TextField button2, String colour1 , String colour2 , String colour3 , String colour4 , double radius, double border, double duration) {


        CornerRadii radii = new CornerRadii(radius);

        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.millis(duration);


        double op1 = 1;
        double op2 = 0;

        int i = 0;

        KeyValue startKeyValue = new KeyValue(button2.borderProperty(), new Border(new BorderStroke(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1)),new Stop(1,Color.web(colour2))), BorderStrokeStyle.SOLID, radii,BorderStroke.MEDIUM)));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);

        KeyFrame[] keyframes1 = new KeyFrame[20];

        while (op1 > 0) {


            KeyValue stop1KeyValue = new KeyValue(button2.borderProperty(),new Border(new BorderStroke(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1)),new Stop(1,Color.web(colour2))), BorderStrokeStyle.SOLID, radii,new BorderWidths(border))));
            keyframes1[i] = new KeyFrame(Duration.millis(((i + 1) * (duration / 20))), stop1KeyValue);
            op1 = op1 - 0.05;
            i++;

        }

        int k = 0;

        KeyFrame[] keyframes2 = new KeyFrame[20];

        while (op2 < 1) {


            KeyValue stop2KeyValue = new KeyValue(button2.borderProperty(),new Border(new BorderStroke(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour4)),new Stop(1,Color.web(colour4))), BorderStrokeStyle.SOLID, radii,new BorderWidths(border))));
            keyframes2[k] = new KeyFrame(Duration.millis(((k + 1) * (duration / 20))), stop2KeyValue);
            op2 = op2 + 0.05;
            k++;

        }

        KeyValue endKeyValue = new KeyValue(button2.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3)),new Stop(1,Color.web(colour4))), radii, null)));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(keyframes1[0],keyframes1[1], keyframes1[2],
                keyframes1[3], keyframes1[4],keyframes1[5],keyframes1[6],keyframes1[7],keyframes1[8],keyframes1[9],keyframes2[10],keyframes2[11], keyframes2[12], keyframes2[13], keyframes2[14]
                , keyframes2[15], keyframes2[16], keyframes2[17], keyframes2[18], keyframes2[19]);

        animation.setCycleCount(1);
        animation.play();

    }

    public void hoverOffbg(TextField button2, String colour1 , String colour2 , String colour3 , String colour4 , double radius, double border, double duration) {


        hoverOnbg(button2, colour3,colour4,colour1,colour2, radius, border, duration);

    }



    public void hoverOnB(Scene button2, String colour1, String colour2, double radius, double duration,double delay) {


        CornerRadii radii = new CornerRadii(radius);

        Duration startDuration = Duration.millis(delay);
        Duration endDuration = Duration.millis(duration);


        double op1 = 1;
        double op2 = 0;

        int i = 0;

        KeyValue startKeyValue = new KeyValue(button2.fillProperty(),Color.web(colour1, op1));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);

        KeyFrame[] keyframes1 = new KeyFrame[20];

        while (op1 > 0) {


            KeyValue stop1KeyValue = new KeyValue(button2.fillProperty(),Color.web(colour1, op2));
            keyframes1[i] = new KeyFrame(Duration.millis(((i + 1) * (duration / 20))), stop1KeyValue);
            op1 = op1 - 0.05;
            i++;

        }

        int k = 0;

        KeyFrame[] keyframes2 = new KeyFrame[20];

        while (op2 < 1) {


            KeyValue stop2KeyValue = new KeyValue(button2.fillProperty(),Color.web(colour2, op1));
            keyframes2[k] = new KeyFrame(Duration.millis(((k + 1) * (duration / 20))), stop2KeyValue);
            op2 = op2 + 0.05;
            k++;

        }

        KeyValue endKeyValue = new KeyValue(button2.fillProperty(),Color.web(colour2, op1));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(keyframes1[0],keyframes1[1], keyframes1[2],
                keyframes1[3], keyframes1[4],keyframes1[5],keyframes1[6],keyframes1[7],keyframes1[8],keyframes1[9],keyframes2[10],keyframes2[11], keyframes2[12], keyframes2[13], keyframes2[14]
                , keyframes2[15], keyframes2[16], keyframes2[17], keyframes2[18], keyframes2[19]);

        animation.setCycleCount(1);
        animation.play();

    }

    public void hoverOffB(Scene button2, String colour1, String colour2, double radius, double duration,double delay) {


        hoverOnB(button2, colour1, colour2, radius, duration,delay);

    }



    public void hoverOngradB(Scene button2, double color1r, double color1g, double color1b, double color2r, double color2g, double color2b, double radius, double duration) {


        CornerRadii radii = new CornerRadii(radius);

        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.millis(duration);


        double op1 = 1;
        double op2 = 0;

        int i = 0;

        KeyValue startKeyValue = new KeyValue(button2.fillProperty(),new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.color(1,1,1,op1)),new Stop(1,Color.color(0,0,0,op1))));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);

        KeyFrame[] keyframes1 = new KeyFrame[10];

        while (op1 > 0.1) {


            KeyValue stop1KeyValue = new KeyValue(button2.fillProperty(),new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.color(0,0,0,op2)),new Stop(1,Color.color(1,1,1,op2))));
            keyframes1[i] = new KeyFrame(Duration.millis(((i + 1) * (duration / 10))), stop1KeyValue);
            op1 = op1 - 0.1;
            i++;

        }

        int k = 0;

        KeyFrame[] keyframes2 = new KeyFrame[10];

        while (op2 < 0.9) {


            KeyValue stop2KeyValue = new KeyValue(button2.fillProperty(),new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.color(1,1,1,op1)),new Stop(1,Color.color(0,0,0,op1))));
            keyframes2[k] = new KeyFrame(Duration.millis(((k + 1) * (duration / 10))), stop2KeyValue);
            op2 = op2 + 0.1;
            k++;

        }

        KeyValue endKeyValue = new KeyValue(button2.fillProperty(),new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.color(1,1,1,op1)),new Stop(1,Color.color(0,0,0,op1))));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(startKeyFrame, keyframes1[4], keyframes1[3], keyframes1[2],
                keyframes1[1], keyframes1[0], keyframes2[9], keyframes2[8], keyframes2[7], keyframes2[6]
                , keyframes2[5], endKeyFrame);

        animation.setCycleCount(1);
        animation.play();

    }

    public void hoverOffgradB(Scene button2, double color1r, double color1g, double color1b, double color2r, double color2g, double color2b, double radius, double duration) {


        hoverOngradB(button2, color2r, color2g, color2b, color1r, color1g, color1b, radius, duration);

    }



    public void open(Node node, int duration, int delay){
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

    public void edgeAnimation(Rectangle arc, double start, double end, int duration , int delay) {

        Duration startDuration = Duration.millis(delay);
        Duration endDuration = Duration.millis(duration+delay);

        KeyValue startKeyValue = new KeyValue(arc.arcHeightProperty() , start );
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
        KeyValue endKeyValue = new KeyValue(arc.arcHeightProperty(), end);
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(startKeyFrame, endKeyFrame);
        animation.setCycleCount(1);

        KeyValue startKeyValue1 = new KeyValue(arc.arcWidthProperty() , start );
        KeyFrame startKeyFrame1 = new KeyFrame(startDuration, startKeyValue1);
        KeyValue endKeyValue1 = new KeyValue(arc.arcWidthProperty(), end);
        KeyFrame endKeyFrame1 = new KeyFrame(endDuration, endKeyValue1);

        Timeline animation1 = new Timeline(startKeyFrame1, endKeyFrame1);
        animation1.setCycleCount(1);

        animation1.play();
        animation.play();
    }


    public void ExpandRectX(Rectangle arc, double startWidth , double endWidth, int duration , int delay) {

        Duration startDuration = Duration.millis(delay);
        Duration endDuration = Duration.millis(duration+delay);

        KeyValue startKeyValue = new KeyValue(arc.widthProperty(), startWidth );
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
        KeyValue endKeyValue = new KeyValue(arc.widthProperty(), endWidth );
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

    public void ColourChangeShape(Shape shape,String colour1,String colour2, int duration, int delay){

        FillTransition fill = new FillTransition();
        fill.setShape(shape);
        fill.setFromValue(Color.web(colour1));
        fill.setToValue(Color.web(colour2));
        fill.setDelay(Duration.millis(delay));
        fill.setDuration(Duration.millis(duration));
        fill.play();

    }

    public void ColourChangeShape(Shape shape,String colour1,String colour2,String colour3,String colour4, int duration, int delay){


        Duration startDuration = Duration.millis(delay);
        Duration endDuration = Duration.millis(duration+delay);

        KeyValue startKeyValue = new KeyValue(shape.fillProperty(),new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1)),new Stop(1,Color.web(colour2))));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
        KeyValue endKeyValue = new KeyValue(shape.fillProperty(),new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3)),new Stop(1,Color.web(colour4))));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(startKeyFrame, endKeyFrame);
        animation.setCycleCount(1);
        animation.play();

    }

    public void ColourStrokeChangeShape(Shape shape,String colour1,String colour2, int duration, int delay){


        Duration startDuration = Duration.millis(delay);
        Duration endDuration = Duration.millis(duration+delay);

        KeyValue startKeyValue = new KeyValue(shape.strokeProperty(),Color.web(colour1));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
        KeyValue endKeyValue = new KeyValue(shape.strokeProperty(),Color.web(colour2));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(startKeyFrame, endKeyFrame);
        animation.setCycleCount(1);
        animation.play();

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

    public void ColourChangeLabel(Label label,String colour1,String colour2,String colour3, String colour4,int radius, double duration, double delay){

        CornerRadii radii = new CornerRadii(radius);


        Duration startDuration = Duration.millis(delay);
        Duration endDuration = Duration.millis(duration);


        double op1 = 1;
        double op2 = 0;

        int i = 0;

        KeyValue startKeyValue = new KeyValue(label.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1)),new Stop(1,Color.web(colour2))), radii, null)));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);

        KeyFrame[] keyframes1 = new KeyFrame[20];

        while (op1 > 0) {


            KeyValue stop1KeyValue = new KeyValue(label.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour1,op1)),new Stop(1,Color.web(colour2,op1))), radii, null)));
            keyframes1[i] = new KeyFrame(Duration.millis(((i + 1) * (duration / 10))), stop1KeyValue);
            op1 = op1 - 0.05;
            i++;

        }

        int k = 0;

        KeyFrame[] keyframes2 = new KeyFrame[20];

        while (op2 < 1) {


            KeyValue stop2KeyValue = new KeyValue(label.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3,op2)),new Stop(1,Color.web(colour4,op2))), radii, null)));
            keyframes2[k] = new KeyFrame(Duration.millis(((k + 1) * (duration / 10))), stop2KeyValue);
            op2 = op2 + 0.05;
            k++;

        }

        KeyValue endKeyValue = new KeyValue(label.backgroundProperty(), new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web(colour3)),new Stop(1,Color.web(colour4))), radii, null)));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(keyframes1[0],keyframes1[1], keyframes1[2],
                keyframes1[3], keyframes1[4],keyframes1[5],keyframes1[6],keyframes1[7],keyframes1[8],keyframes1[9],keyframes2[10],keyframes2[11], keyframes2[12], keyframes2[13], keyframes2[14]
                , keyframes2[15], keyframes2[16], keyframes2[17], keyframes2[18], keyframes2[19]);

        animation.setCycleCount(1);

        animation.play();


    }

    public void TextFill(Label label, String colour1, String colour2, double duration , double delay){

        Duration startDuration = Duration.millis(delay);
        Duration endDuration = Duration.millis(duration+delay);

        KeyValue startKeyValue = new KeyValue(label.textFillProperty(),Color.web(colour1));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
        KeyValue endKeyValue = new KeyValue(label.textFillProperty(),Color.web(colour2));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(startKeyFrame, endKeyFrame);
        animation.setCycleCount(1);
        animation.play();


    }


    public void TextFill(ToggleButton label, String colour1, String colour2, double duration , double delay){

        Duration startDuration = Duration.millis(delay);
        Duration endDuration = Duration.millis(duration+delay);

        KeyValue startKeyValue = new KeyValue(label.textFillProperty(),Color.web(colour1));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
        KeyValue endKeyValue = new KeyValue(label.textFillProperty(),Color.web(colour2));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(startKeyFrame, endKeyFrame);
        animation.setCycleCount(1);
        animation.play();


    }

    public void TextFill(Button label, String colour1, String colour2, double duration , double delay){

        Duration startDuration = Duration.millis(delay);
        Duration endDuration = Duration.millis(duration+delay);

        KeyValue startKeyValue = new KeyValue(label.textFillProperty(),Color.web(colour1));
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
        KeyValue endKeyValue = new KeyValue(label.textFillProperty(),Color.web(colour2));
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        Timeline animation = new Timeline(startKeyFrame, endKeyFrame);
        animation.setCycleCount(1);
        animation.play();


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


    public void LinearMoveX(Node node, double duration, double from , int to ){

        TranslateTransition move = new TranslateTransition();
        move.setNode(node);
        move.setDuration(Duration.millis(duration));
        move.setFromX(from);
        move.setToX(to);
        move.setCycleCount(1);
        move.setAutoReverse(false);
        move.play();


    }

    public void LinearMoveX(Node node, int duration, double from, double to ,int delay ){

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

    public void LinearMoveY(Node node, int duration, double from , double to ){

        TranslateTransition move = new TranslateTransition();
        move.setNode(node);
        move.setDuration(Duration.millis(duration));
        move.setFromY(from);
        move.setToY(to);
        move.setCycleCount(1);
        move.setAutoReverse(false);
        move.play();


    }

    public void LinearMoveY(Node node, int duration, double from, double to ,int delay ){

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

    public TranslateTransition LinearMoveYReturn(Node node, int duration, double from, double to ,int delay ){

        TranslateTransition move = new TranslateTransition();
        move.setNode(node);
        move.setDuration(Duration.millis(duration));
        move.setFromY(from);
        move.setToY(to);
        move.setCycleCount(1);
        move.setAutoReverse(false);
        move.setDelay(Duration.millis(delay));
        move.play();
        return move;


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
        scale.setCycleCount(javafx.animation.Animation.INDEFINITE);
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

    public ScaleTransition ScaleReturn(Node node, int duration, double from, double to, int delay){

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDuration(Duration.millis(duration));
        scale.setFromX(from);
        scale.setFromY(from);
        scale.setToX(to);
        scale.setToY(to);
        scale.setDelay(Duration.millis(delay));
        scale.play();
        return scale;

    }



    public void popup(Node node, int duration){

        Scale(node,duration-100,0,1.2,true,1,0);
        Scale(node,100,1.2,1,true,1,duration);


    }


    public void popup(Node node, int duration, int delay){

        Scale(node,duration-100,0,1.2,true,1,delay);
        Scale(node,100,1.2,1,true,1,duration+delay);


    }


    public void popOut(Node node, int duration, int delay){

        Scale(node,100,1,1.2,true,1,delay);
        Scale(node,duration-100,1.2,0,true,1,delay+100);


    }


    public void Popup(Node node, int duration, double from, double to, int delay){

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDuration(Duration.millis(duration));
        scale.setFromX(from);
        scale.setFromY(from);
        scale.setToX(to);
        scale.setToY(to);
        scale.setCycleCount(javafx.animation.Animation.INDEFINITE);
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
