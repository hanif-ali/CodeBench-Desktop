package sample;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller extends CustomAnimations implements Initializable {
    Stage myStage;
    Controller(){
        this(null);
    }
    Controller(Stage myStage){
        this.myStage=myStage;
    }

    CustomAnimations animations = new CustomAnimations();

    Logo l1 = new Logo();



@FXML
private Pane blackpane;
@FXML
private Pane whitepane;
@FXML
private AnchorPane logopane;
@FXML
private Button std;
@FXML
private AnchorPane apane;
@FXML
private Button teach;
@FXML
private Rectangle stdbg;
@FXML
private Rectangle teachbg;
@FXML
private Label text1;
@FXML
private Hyperlink link1;
@FXML
private Button close;

private double xOffset = 0 ;
private double yOffset = 0 ;


public void onStudent(ActionEvent actionEvent){


}
public void onTeacher(ActionEvent actionEvent){
    System.out.println("I am a teacher");

}

public void drag(Pane apane){

    apane.setOnMousePressed(((event) -> {

        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }));

    apane.setOnMouseDragged(((event) -> {

        myStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        myStage.setX(event.getScreenX()-xOffset);
        myStage.setY(event.getScreenY()-yOffset);


    }));

}

public  void createLines(Pane blackpane,String colour){

        Line[] lines = new Line[200];
        double lineX = -200;
        double lineY = -500;


        for (int i = 0 ; i<199 ; i++){

            Line line = new Line();

            line.setStartX(0);
            line.setEndX(2000);
            line.setStartY(0);
            line.setEndY(0);
            line.setRotate(-30);
            line.setFill(Color.web(colour));
            line.setStroke(Color.web(colour));
            line.setStrokeWidth(1.5);
            lines[i] = line;
            lines[i].setLayoutX(lineX);
            lines[i].setLayoutY(lineY);
            if ( i%2 == 1 ) {
                animations.LinearMoveX(lines[i], 1500, 1732, 1, 250);
                animations.LinearMoveY(lines[i], 1500, -1000, 1, 250);
            }
            else{
                animations.LinearMoveX(lines[i], 2500, -1732, 1, 250);
                animations.LinearMoveY(lines[i], 2500, 1000, 1, 250);
            }
            blackpane.getChildren().add(lines[i]);

            lineY +=7.5;

        }


    }

    int i = 0;
    int j = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        apane.setScaleX(1.3);
        apane.setScaleY(1.3);

        teach.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animations.hoverOn(teach,"#130049","#070026","#070026","#130049",9,100);

            }

        });

        teach.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animations.hoverOff(teach,"#130049","#070026","#070026","#130049",9,100);
            }

        });

        teach.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animations.hoverOn(teach,"#130049","#070026","#260094","#0F0051",9,100);

            }

        });

        teach.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animations.hoverOff(teach,"#130049","#070026","#260094","#0F0051",9,100);

            }

        });

        std.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animations.hoverOn(std,"#2EBCFD","#2EE2E2","#2EE2E2","#2EBCFD",9,100);

            }

        });

        std.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animations.hoverOff(std,"#2EBCFD","#2EE2E2","#2EE2E2","#2EBCFD",9,100);

            }

        });


        std.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animations.hoverOn(std,"#2EBCFD","#2EE2E2","#008AC9","#00CBCB",9,100);

            }

        });

        std.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animations.hoverOff(std,"#2EBCFD","#2EE2E2","#008AC9","#00CBCB",9,100);

            }

        });


        close.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animations.hoverOnbg(close,"#838383","#838383","#CE4869","#CE4869",7,2,10);
                close.setTextFill(Color.web("#CE4869"));

            }

        });

        close.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animations.hoverOffbg(close,"#838383","#838383","#CE4869","#CE4869",7,2,10);
                close.setTextFill(Color.web("#838383"));

            }

        });


        close.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animations.hoverOnbg(close,"#CE4869","#CE4869","#A60028","#A60028",7,2,10);
                close.setTextFill(Color.web("#A60028"));

            }

        });

        close.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animations.hoverOffbg(close,"#CE4869","#CE4869","#A60028","#A60028",7,2,10);
                close.setTextFill(Color.web("#CE4869"));

            }

        });

        logopane.getChildren().add(l1.createLogo(1));
        ScaleTransition logoAnim = l1.makeBig(1000,1);
        logopane.setScaleX(0.5);
        logopane.setScaleY(0.5);

        Rectangle clipper = new Rectangle();
        clipper.setHeight(363);
        clipper.setWidth(698);
        clipper.setArcHeight(18);
        clipper.setArcWidth(18);
        clipper.setLayoutY(39);
        clipper.setLayoutX(2);

        blackpane.setClip(clipper);

        Rectangle clipper2 = new Rectangle();
        clipper2.setHeight(430);
        clipper2.setWidth(351);
        clipper2.setArcHeight(18);
        clipper2.setArcWidth(18);
        clipper2.setLayoutY(2);
        clipper2.setLayoutX(0);

        whitepane.setClip(clipper2);

        createLines(blackpane,"#4d4d4d");
        createLines(whitepane,"#E7E7E7");


        //animations


        animations.ScaleX(clipper,500,0,1,0);
        animations.ScaleX(clipper2,500,0,1,250);
        animations.ScaleY(clipper2,500,0,1,250);
        animations.FadeIn(std,250,2000);
        animations.FadeIn(teach,250,2000);
        animations.FadeIn(stdbg,250,2000);
        animations.FadeIn(teachbg,250,2000);
        animations.FadeIn(close,250,2000);
        animations.FadeIn(text1,250,1000);
        animations.FadeIn(link1,250,1000);
        ScaleTransition start = animations.ScaleReturn(link1,50,1,1,1250);






        //animations


        drag(apane);

    std.setOnAction(new EventHandler<ActionEvent>() {


        @Override
        public void handle(ActionEvent event) {

            start.playFromStart();
            start.setOnFinished(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent event) {


                    animations.ScaleX(clipper, 250, 1, 0, 1250);
                    animations.ScaleX(clipper2, 250, 1, 0, 1650);
                    animations.ScaleY(clipper2, 250, 1, 0, 1650);
                    animations.FadeOut(std, 250, 1000);
                    animations.FadeOut(teach, 250, 1000);
                    animations.FadeOut(stdbg, 250, 1000);
                    animations.FadeOut(teachbg, 250, 1000);
                    animations.FadeOut(close, 250, 1000);
                    animations.FadeOut(text1, 250, 750);
                    animations.FadeOut(link1, 250, 750);
                    l1.vanishBig(0, 1);


                    ScaleTransition scale1 = animations.ScaleReturn(clipper, 50, 0, 0, 1900);

                    scale1.setOnFinished(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {

                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Both2.fxml"));
                            loader.setControllerFactory(t -> new

                                    Both2Cont(myStage));
                            try {

                                Stage stage = new Stage();
                                AnchorPane mine = new AnchorPane();
                                mine = loader.load();
                                mine.setStyle("-fx-background-color: transparent");
                                Scene scene = new Scene(mine);
                                scene.setFill(Color.TRANSPARENT);
                                myStage.setScene(scene);


                            } catch (
                                    IOException e) {
                                e.printStackTrace();
                            }
                        }


                    });

                }

            });

        }
    });



    teach.setOnAction(new EventHandler<ActionEvent>() {





        @Override
        public void handle(ActionEvent event) {

            start.playFromStart();
            start.setOnFinished(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent event) {



                    animations.ScaleX(clipper, 250, 1, 0, 1250);
                    animations.ScaleX(clipper2, 250, 1, 0, 1650);
                    animations.ScaleY(clipper2, 250, 1, 0, 1650);
                    animations.FadeOut(std, 250, 1000);
                    animations.FadeOut(teach, 250, 1000);
                    animations.FadeOut(stdbg, 250, 1000);
                    animations.FadeOut(teachbg, 250, 1000);
                    animations.FadeOut(close, 250, 1000);
                    animations.FadeOut(text1, 250, 750);
                    animations.FadeOut(link1, 250, 750);
                    l1.vanishBig(0,1);



                    ScaleTransition scale2 = animations.ScaleReturn(clipper, 50, 0, 0, 1900);

                    scale2.setOnFinished(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {


                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Both.fxml"));
                            loader.setControllerFactory(t -> new Translate(myStage));
                            try {


                                AnchorPane mine = new AnchorPane();
                                mine = loader.load();
                                mine.setStyle("-fx-background-color: transparent");
                                Scene scene = new Scene(mine);
                                scene.setFill(Color.TRANSPARENT);
                                myStage.setScene(scene);


                            } catch (IOException e) {
                                e.printStackTrace();

                            }
                        }


                    });

                    }

                });

                }
            });


        close.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                start.playFromStart();
                start.setOnFinished(new EventHandler<ActionEvent>(){

                    @Override
                    public void handle(ActionEvent event) {



                        animations.ScaleX(clipper, 250, 1, 0, 1250);
                        animations.ScaleX(clipper2, 250, 1, 0, 1650);
                        animations.ScaleY(clipper2, 250, 1, 0, 1650);
                        animations.FadeOut(std, 250, 1000);
                        animations.FadeOut(teach, 250, 1000);
                        animations.FadeOut(stdbg, 250, 1000);
                        animations.FadeOut(teachbg, 250, 1000);
                        animations.FadeOut(close, 250, 1000);
                        animations.FadeOut(text1, 250, 750);
                        animations.FadeOut(link1, 250, 750);
                        l1.vanishBig(0,1);



                        ScaleTransition scale = animations.ScaleReturn(clipper, 50, 0, 0, 1900);

                        scale.setOnFinished(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {

                                myStage.close();

                            }


                        });

                    }

                });

            }
        });


        }



}
