package sample;

import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.rgb;

public class Both2Cont implements Initializable {

    CustomAnimations animator = new CustomAnimations();

    Stage primaryStage;
    String type;

    Both2Cont(){
        this(null);
    }


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


    Both2Cont(Stage primaryStage){

        this.primaryStage=primaryStage;

    }

    private int check1 = 0;
    private int check2 = 0;

    static int no=0;
    @FXML
    private Label lab1;
    @FXML
    private Label lab2;
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private AnchorPane teacherparent;
    @FXML
    private AnchorPane side;
    @FXML Button close;

    @FXML
    private Pane removableteacher;
    @FXML
    private ToggleButton teach;
    @FXML
    private ToggleButton student;
    String sideofblock;
    @FXML Button login;
    @FXML Pane linepane;
    @FXML Rectangle selectedRect;
    @FXML Pane sliderbg;
    @FXML Rectangle wcpane;
    @FXML Rectangle backrect;
    @FXML Rectangle sider;
    @FXML Rectangle studentrect;
    @FXML Rectangle teachrect;
    @FXML Rectangle userrect;
    @FXML Rectangle passrect;
    @FXML Label welcome;
    @FXML Label logininfo;
    @FXML Label trouble;
    @FXML
    Hyperlink contact;
    @FXML
    private AnchorPane logopane;
    private int tch = 1;
    private int std = 1;

    public Line[] createLines(Pane blackpane,String colour){

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

            blackpane.getChildren().add(lines[i]);

            lineY +=7.5;

        }

        return lines;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        teacherparent.setScaleX(1.3);
        teacherparent.setScaleY(1.3);

        ToggleGroup tg = new ToggleGroup();

        Logo l1 = new Logo();

        logopane.getChildren().add(l1.createLogo(1));

        user.setStyle("-fx-text-fill: #999999  ; -fx-background-color:  transparent ; -fx-border-colour:#999999; -fx-border-width: 2 " );
        pass.setStyle("-fx-text-fill: #999999  ; -fx-background-color:  transparent ; -fx-border-colour: #999999  ; -fx-border-width: 2 " );

        animator.hoverOffbg(user, "#999999", "#999999", "#212121", "#212121", 0, 2, 250);
        animator.hoverOffbg(pass, "#999999", "#999999", "#212121", "#212121", 0, 2, 250);


        logopane.setScaleX(0.43);
        logopane.setScaleY(0.43);
        l1.play(1000,1);

        type="student";
        Line[] bgline = createLines(linepane,"#4C4C4C");
        drag(teacherparent);

        student.setBackground(new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web("#191919")),new Stop(1,Color.web("#191919"))), new CornerRadii(9), null)));
        teach.setBackground(new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web("#130049")),new Stop(1,Color.web("#070026"))), new CornerRadii(9), null)));
        login.setBackground(new Background(new BackgroundFill(rgb(46,214,235),new CornerRadii(0),null)));
        login.setStyle("-fx-text-fill: #191919");

        Rectangle clipper = new Rectangle();
        clipper.setHeight(399.75);
        clipper.setWidth(700);
        clipper.setArcHeight(15);
        clipper.setArcWidth(15);
        clipper.setLayoutY(3.75);
        clipper.setLayoutX(5.5);

        Rectangle rclipper = new Rectangle();
        rclipper.setHeight(399);
        rclipper.setWidth(700);
        rclipper.setArcHeight(16);
        rclipper.setArcWidth(16);
        rclipper.setLayoutY(4);
        rclipper.setLayoutX(5);

        linepane.setClip(clipper);
        backrect.setClip(rclipper);


        //intro animation


        animator.ScaleX(removableteacher,500,0,1,0);
        animator.ScaleX(side,500,0,1,0);
        animator.ScaleY(side,500,0,1,0);
        animator.LinearMoveX(side,1000,-375,0,0);

        animator.FadeIn(user,100,500);
        animator.FadeIn(userrect,100,500);
        animator.FadeIn(pass,100,500);
        animator.FadeIn(passrect,100,500);
        animator.FadeIn(lab1,100,1000);
        animator.FadeIn(lab2,100,1000);
        animator.FadeIn(login,100,1000);
        animator.FadeIn(welcome,259,1000);
        animator.FadeIn(logininfo,250,1000);


        animator.ScaleXLeft(user,500,500);
        animator.ScaleXLeft(pass,500,500);
        animator.LinearMoveX(user,500,-338/2,0,500);
        animator.LinearMoveX(pass,500,-338/2,0,500);
        animator.ScaleXLeft(userrect,500,500);
        animator.ScaleXLeft(passrect,500,500);

        animator.ScaleY(lab1,750,0,1,1000);
        animator.ScaleY(lab2,750,0,1,1000);
        animator.LinearMoveY(lab1,750,19/2,0,1000);
        animator.LinearMoveY(lab2,750,19/2,0,1000);

        animator.ScaleXRight(login,500,750);
        animator.LinearMoveX(login,500,53/2,0,1000);

        //intro animation


        //START HOVERS

        if(teach.isPressed() || teach.isSelected()) {


            Animation anim1 = animator.hoverOn(student, "#191919", "#191919", "#2EBCFD", "#2EE2E2", 9, 250);
            animator.TextFill(student, "#2ED0EE", "#000000", 250, 0);

            Animation anim2 = animator.hoverOn(teach, "#130049", "#070026", "#FFFFFF", "#FFFFFF", 9, 250);
            animator.TextFill(teach,  "#ffffff","#000000", 250, 0);


            anim1.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                    student.setBackground(new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web("#2EBCFD")),new Stop(1,Color.web("#2EE2E2"))), new CornerRadii(9), null)));
                }
            });

            anim2.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                    teach.setBackground(new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web("#FFFFFF")),new Stop(1,Color.web("#FFFFFF"))), new CornerRadii(9), null)));
                }
            });

            teach.setOnMouseEntered(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOn(teach, "#FFFFFF", "#FFFFFF", "#D5D5D5", "#D5D5D5", 9, 100);

                }

            });

            teach.setOnMouseExited(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOff(teach, "#FFFFFF", "#FFFFFF", "#D5D5D5", "#D5D5D5", 9, 100);

                }

            });

            teach.setOnMousePressed(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOn(teach, "#D5D5D5", "#D5D5D5", "#C1C1C1", "#C1C1C1", 9, 100);
                    animator.hoverOn(student, "#191919", "#191919", "#2EBCFD", "#2EE2E2", 9, 250);
                    animator.TextFill(student, "#2ED0EE", "#000000", 250, 0);
                    animator.TextFill(teach,  "#ffffff","#000000", 250, 0);
                }

            });

            teach.setOnMouseReleased(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOff(teach, "#D5D5D5", "#D5D5D5", "#C1C1C1", "#C1C1C1", 9, 100);

                }

            });

            //********************************************************
            //********************************************************
            //********************************************************
            //********************************************************
            //********************************************************

            student.setOnMouseEntered(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOn(student, "#2EBCFD", "#2EE2E2", "#2EE2E2", "#2EBCFD", 9, 100);

                }

            });

            student.setOnMouseExited(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOff(student, "#2EBCFD", "#2EE2E2", "#2EE2E2", "#2EBCFD", 9, 100);

                }

            });


            student.setOnMousePressed(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOn(student, "#2EE2E2", "#2EBCFD", "#008AC9", "#00CBCB", 9, 100);
                    animator.TextFill(student, "#000000", "#2ED0EE", 250, 0);
                    animator.hoverOn(teach, "#FFFFFF", "#FFFFFF", "#130049", "#070026", 9, 250);
                    animator.TextFill(teach, "#000000","#FFFFFF",  250, 0);
                }

            });

            student.setOnMouseReleased(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOff(student, "#2EE2E2", "#2EBCFD", "#008AC9", "#00CBCB", 9, 100);

                }

            });

        }


        if(student.isPressed() || student.isSelected()) {


            Animation anim3 = animator.hoverOn(student, "#2EBCFD", "#2EE2E2", "#191919", "#191919", 9, 250);
            animator.TextFill(student, "#000000", "#2ED0EE", 250, 0);
            Animation anim4 = animator.hoverOn(teach, "#FFFFFF", "#FFFFFF", "#130049", "#070026", 9, 250);
            animator.TextFill(teach, "#000000","#FFFFFF",  250, 0);


            anim3.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    teach.setBackground(new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web("#130049")),new Stop(1,Color.web("#070026"))), new CornerRadii(9), null)));


                }
            });

            anim4.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    student.setBackground(new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web("#191919")),new Stop(1,Color.web("#191919"))), new CornerRadii(9), null)));

                }
            });


            teach.setOnMouseEntered(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOn(teach,"#130049","#070026","#070026","#130049",9,100);

                }

            });

            teach.setOnMouseExited(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOff(teach,"#130049","#070026","#070026","#130049",9,100);

                }

            });

            teach.setOnMousePressed(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOn(teach,"#070026","#130049","#260094","#0F0051",9,100);
                    animator.hoverOn(student, "#191919", "#191919", "#2EBCFD", "#2EE2E2", 9, 250);
                    animator.TextFill(student, "#2ED0EE", "#000000", 250, 0);
                    animator.TextFill(teach,  "#ffffff","#000000", 250, 0);

                }

            });

            teach.setOnMouseReleased(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOff(teach,"#070026","#130049","#260094","#0F0051",9,100);

                }

            });

            //********************************************************
            //********************************************************
            //********************************************************
            //********************************************************
            //********************************************************

            student.setOnMouseEntered(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOn(student,"#191919","#191919","#464646","#464646",9,100);

                }

            });

            student.setOnMouseExited(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOff(student,"#191919","#191919","#464646","#464646",9,100);

                }

            });

            student.setOnMousePressed(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOn(student, "#464646", "#464646", "#000000", "#000000", 9, 100);
                    animator.TextFill(student, "#000000", "#2ED0EE", 250, 0);
                    animator.hoverOn(teach, "#FFFFFF", "#FFFFFF", "#130049", "#070026", 9, 250);
                    animator.TextFill(teach, "#000000","#FFFFFF",  250, 0);
                }

            });

            student.setOnMouseReleased(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    animator.hoverOff(student, "#464646", "#464646", "#000000", "#000000", 9, 100);

                }

            });

        }



        //START HOVERS


        close.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animator.hoverOnText(close,"#999999","#999999","#CE4869","#CE4869",100);
//                close.setTextFill(Color.web("#CE4869"));

            }

        });

        close.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animator.hoverOffText(close,"#999999","#999999","#CE4869","#CE4869",100);
//                close.setTextFill(Color.web("#838383"));

            }

        });


        close.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animator.hoverOnText(close,"#CE4869","#CE4869","#A60028","#A60028",100);
//                close.setTextFill(Color.web("#A60028"));

            }

        });

        close.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animator.hoverOffText(close,"#CE4869","#CE4869","#A60028","#A60028",100);
//                close.setTextFill(Color.web("#CE4869"));

            }

        });



        student.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                check1 =0;
                check2 =0;
                animator.hoverOffbg(user, "#999999", "#999999", "#212121", "#212121", 0, 2, 250);
                animator.hoverOffbg(pass, "#999999", "#999999", "#212121", "#212121", 0, 2, 250);

                if(std > 0){

                    animator.LinearMoveX(close,250,377,0);

                    Animation anim3 = animator.hoverOn(student, "#2EBCFD", "#2EE2E2", "#191919", "#191919", 9, 250);
                    animator.TextFill(student, "#000000", "#2ED0EE", 250, 0);
                    Animation anim4 = animator.hoverOn(teach, "#FFFFFF", "#FFFFFF", "#130049", "#070026", 9, 250);
                    animator.TextFill(teach, "#000000","#FFFFFF",  250, 0);


                    anim3.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            student.setBackground(new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web("#191919")),new Stop(1,Color.web("#191919"))), new CornerRadii(9), null)));
                        }
                    });

                    anim4.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            teach.setBackground(new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web("#130049")),new Stop(1,Color.web("#070026"))), new CornerRadii(9), null)));
                        }
                    });

                    teach.setOnMouseEntered(new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {

                            animator.hoverOn(teach,"#130049","#070026","#070026","#130049",9,100);

                        }

                    });

                    teach.setOnMouseExited(new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {

                            animator.hoverOff(teach,"#130049","#070026","#070026","#130049",9,100);

                        }

                    });

                    teach.setOnMousePressed(new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {

                            animator.hoverOn(teach,"#070026","#130049","#260094","#0F0051",9,100);
                            animator.hoverOn(student, "#191919", "#191919", "#2EBCFD", "#2EE2E2", 9, 250);
                            animator.TextFill(student, "#2ED0EE", "#000000", 250, 0);
                            animator.TextFill(teach,  "#ffffff","#000000", 250, 0);

                        }

                    });

                    teach.setOnMouseReleased(new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {

                            animator.hoverOff(teach,"#070026","#130049","#260094","#0F0051",9,100);

                        }

                    });

                    //********************************************************
                    //********************************************************
                    //********************************************************
                    //********************************************************
                    //********************************************************

                    student.setOnMouseEntered(new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {

                            animator.hoverOn(student,"#191919","#191919","#464646","#464646",9,100);

                        }

                    });

                    student.setOnMouseExited(new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {

                            animator.hoverOff(student,"#191919","#191919","#464646","#464646",9,100);

                        }

                    });

                    student.setOnMousePressed(new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {

                            animator.hoverOn(student, "#464646", "#464646", "#000000", "#000000", 9, 100);

                        }

                    });

                    student.setOnMouseReleased(new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {

                            animator.hoverOff(student, "#464646", "#464646", "#000000", "#000000", 9, 100);

                        }

                    });



                    login.setOnMouseEntered(new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {

                            animator.hoverOn(login, "#2ED6EB", "#2ED6EB", "#36B7D2", "#36B7D2", 0, 100);
                            animator.TextFill(login, "#000000", "#000000", 250, 0);

                        }

                    });

                    login.setOnMouseExited(new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {

                            animator.hoverOff(login, "#2ED6EB", "#2ED6EB", "#36B7D2", "#36B7D2", 0, 100);
                            animator.TextFill(login, "#000000", "#000000", 250, 0);

                        }

                    });


                    login.setOnMousePressed(new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {

                            animator.hoverOn(login, "#36B7D2", "#36B7D2", "#418EF3", "#418EF3", 0, 100);
                            animator.TextFill(login, "#000000", "#000000", 250, 0);

                        }

                    });

                    login.setOnMouseReleased(new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {

                            animator.hoverOff(login, "#36B7D2", "#36B7D2", "#418EF3", "#418EF3", 0, 100);
                            animator.TextFill(login, "#000000", "#000000", 250, 0);

                        }

                    });


                    for (int i=0 ; i<199 ; i++ ){

                        animator.ColourChangeShape(bgline[i],"#E7E7E7","#4d4d4d",250,0);
                        animator.ColourStrokeChangeShape(bgline[i],"#E7E7E7","#4d4d4d",250,0);

                        //                    bgline[i].setFill(Color.web("#4d4d4d"));
                        //                    bgline[i].setStroke(Color.web("#4d4d4d"));

                    }

                    animator.LinearMoveY(selectedRect,250,67.5,0,0);
                    animator.ColourChangeShape(selectedRect,"#2E264C","#34A4BA",250,0);
                    contact.setTextFill(Color.web("#120046"));


                    int num=0;
                    animator.ColourChangeLabel(lab1,"#130049","#130049","#2ED6EB","#2ED6EB",0,250,0);
                    animator.ColourChangeLabel(lab2,"#130049","#130049","#2ED6EB","#2ED6EB",0,250,0);
                    animator.TextFill(lab1,"#ffffff","#000000",250,0);
                    animator.TextFill(lab2,"#ffffff","#000000",250,0);
                    animator.TextFill(trouble,"#ffffff","#000000",250,0);

                    //                lab1.setBackground(new Background(new BackgroundFill(rgb(46,188,253),null,null)));
                    //                lab2.setBackground(new Background(new BackgroundFill(rgb(46,188,253),null,null)));
                    //                lab1.setStyle("-fx-text-fill: black");
                    //                lab2.setStyle("-fx-text-fill: black");

                    animator.ColourChangeShape(wcpane,"#ffffff","#212121",250,0);
                    animator.ColourChangeShape(studentrect,"#2EBCFD","#191919",100,0);
                    animator.ColourChangeShape(teachrect,"#ffffff","#010453",100,0);
                    animator.ColourShiftRect(sider,"#130048","#070027","#2EBDFC","#2EE1E2",250,0);
                    animator.TextFill(welcome,"#000000","#2ED6EB",250,0);
                    animator.TextFill(logininfo,"#000000","#2ED6EB",250,0);



                    for (int i=0;i<=2;i++){

                        //                    login.setBackground(new Background(new BackgroundFill(rgb(46,188,253),new CornerRadii(0),null)));
                        //                login.setStyle("-fx-text-fill: black");

                        animator.hoverOn(login,"#130049","#130049","#2ED6EB","#2ED6EB",0,250);
                        animator.TextFill(login,"#ffffff","#000000",250,0);


                        //                animator.ColourShiftPane(linepane,"#ffffff","#ffffff","#1a1a1a","#1a1a1a",0,250,0);
                        animator.PaneToBlack(linepane,0,250,0);

                    }

                    type="student";
                    TranslateTransition slide = new TranslateTransition();
                    slide.setDuration(Duration.seconds(0.25));
                    slide.setNode(side);

                    slide.setToX(0);
                    slide.play();
                    //                removableteacher.setTranslateX(-226);
                    animator.LinearMoveX(sliderbg,250,295,0,0);
                    slide.setOnFinished((e->{


                    }));

                    tch = 1;
                    std = 0;

                }

            }
        });


        teach.setOnAction(new EventHandler<ActionEvent>() {

                              @Override
                              public void handle(ActionEvent event){

                                  check1 =0;
                                  check2 =0;
                                  animator.hoverOffbg(user, "#999999", "#999999", "#212121", "#212121", 0, 2, 250);
                                  animator.hoverOffbg(pass, "#999999", "#999999", "#212121", "#212121", 0, 2, 250);


                                  if(tch > 0){

                                      animator.LinearMoveX(close,250,0,377);


                                      Animation anim1 = animator.hoverOn(student, "#191919", "#191919", "#2EBCFD", "#2EE2E2", 9, 250);
                                      animator.TextFill(student, "#2ED0EE", "#000000", 250, 0);

                                      Animation anim2 = animator.hoverOn(teach, "#130049", "#070026", "#FFFFFF", "#FFFFFF", 9, 250);
                                      animator.TextFill(teach,  "#ffffff","#000000", 250, 0);


                                      anim1.setOnFinished(new EventHandler<ActionEvent>() {
                                          @Override
                                          public void handle(ActionEvent actionEvent) {
                                              student.setBackground(new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web("#2EBCFD")),new Stop(1,Color.web("#2EE2E2"))), new CornerRadii(9), null)));
                                          }
                                      });

                                      anim2.setOnFinished(new EventHandler<ActionEvent>() {
                                          @Override
                                          public void handle(ActionEvent actionEvent) {
                                              teach.setBackground(new Background(new BackgroundFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0,Color.web("#FFFFFF")),new Stop(1,Color.web("#FFFFFF"))), new CornerRadii(9), null)));
                                          }
                                      });



                                      teach.setOnMouseEntered(new EventHandler<MouseEvent>() {

                                          @Override
                                          public void handle(MouseEvent event) {

                                              check1 =0;
                                              check2 =0;


                                              animator.hoverOn(teach, "#FFFFFF", "#FFFFFF", "#D5D5D5", "#D5D5D5", 9, 100);

                                          }

                                      });

                                      teach.setOnMouseExited(new EventHandler<MouseEvent>() {

                                          @Override
                                          public void handle(MouseEvent event) {

                                              animator.hoverOff(teach, "#FFFFFF", "#FFFFFF", "#D5D5D5", "#D5D5D5", 9, 100);

                                          }

                                      });


                                      teach.setOnMousePressed(new EventHandler<MouseEvent>() {

                                          @Override
                                          public void handle(MouseEvent event) {

                                              animator.hoverOn(teach,"#D5D5D5","#D5D5D5","#C1C1C1","#C1C1C1",9,100);

                                          }

                                      });

                                      teach.setOnMouseReleased(new EventHandler<MouseEvent>() {

                                          @Override
                                          public void handle(MouseEvent event) {

                                              animator.hoverOff(teach,"#D5D5D5","#D5D5D5","#C1C1C1","#C1C1C1",9,100);

                                          }

                                      });


                                      //********************************************************
                                      //********************************************************
                                      //********************************************************
                                      //********************************************************
                                      //********************************************************


                                      student.setOnMouseEntered(new EventHandler<MouseEvent>() {

                                          @Override
                                          public void handle(MouseEvent event) {

                                              animator.hoverOn(student, "#2EBCFD", "#2EE2E2", "#2EE2E2", "#2EBCFD", 9, 100);

                                          }

                                      });

                                      student.setOnMouseExited(new EventHandler<MouseEvent>() {

                                          @Override
                                          public void handle(MouseEvent event) {

                                              animator.hoverOff(student, "#2EBCFD", "#2EE2E2", "#2EE2E2", "#2EBCFD", 9, 100);

                                          }

                                      });


                                      student.setOnMousePressed(new EventHandler<MouseEvent>() {

                                          @Override
                                          public void handle(MouseEvent event) {

                                              animator.hoverOn(student, "#2EE2E2", "#2EBCFD", "#008AC9", "#00CBCB", 9, 100);
                                              animator.TextFill(student, "#000000", "#2ED0EE", 250, 0);
                                              animator.hoverOn(teach, "#FFFFFF", "#FFFFFF", "#130049", "#070026", 9, 250);
                                              animator.TextFill(teach, "#000000", "#FFFFFF", 250, 0);

                                          }

                                      });

                                      student.setOnMouseReleased(new EventHandler<MouseEvent>() {

                                          @Override
                                          public void handle(MouseEvent event) {

                                              animator.hoverOff(student, "#2EE2E2", "#2EBCFD", "#008AC9", "#00CBCB", 9, 100);

                                          }

                                      });

                                      login.setOnMouseEntered(new EventHandler<MouseEvent>() {

                                          @Override
                                          public void handle(MouseEvent event) {

                                              animator.hoverOn(login,"#010453","#010453","#220082","#220082",0,100);
                                              animator.TextFill(login,  "#ffffff","#ffffff", 250, 0);

                                          }

                                      });

                                      login.setOnMouseExited(new EventHandler<MouseEvent>() {

                                          @Override
                                          public void handle(MouseEvent event) {

                                              animator.hoverOff(login,"#010453","#010453","#220082","#220082",0,100);
                                              animator.TextFill(login,  "#ffffff","#ffffff", 250, 0);

                                          }

                                      });

                                      login.setOnMousePressed(new EventHandler<MouseEvent>() {

                                          @Override
                                          public void handle(MouseEvent event) {

                                              animator.hoverOn(login,"#220082","#220082","#260094","#0F0051",0,100);
                                              animator.TextFill(login,  "#ffffff","#ffffff", 250, 0);

                                          }

                                      });

                                      login.setOnMouseReleased(new EventHandler<MouseEvent>() {

                                          @Override
                                          public void handle(MouseEvent event) {

                                              animator.hoverOff(login,"#220082","#220082","#260094","#0F0051",0,100);
                                              animator.TextFill(login,  "#ffffff","#ffffff", 250, 0);

                                          }

                                      });




                                      animator.LinearMoveY(selectedRect, 250, 0,67.5,  0);
                                      animator.ColourChangeShape(selectedRect, "#34A4BA", "#2E264C", 250, 0);


                                      for (int i = 0; i < 199; i++) {

                                          animator.ColourChangeShape(bgline[i], "#4d4d4d", "#E7E7E7", 250, 0);
                                          animator.ColourStrokeChangeShape(bgline[i], "#4d4d4d", "#E7E7E7", 250, 0);


//                    bgline[i].setFill(Color.web("#E7E7E7"));
//                    bgline[i].setStroke(Color.web("#E7E7E7"));

                                      }

                                      int num = 0;

                                      animator.ColourChangeLabel(lab1, "#2ED6EB", "#2ED6EB", "#130049", "#130049", 0, 250, 0);
                                      animator.ColourChangeLabel(lab2, "#2ED6EB", "#2ED6EB", "#130049", "#130049", 0, 250, 0);
                                      animator.TextFill(lab1, "#000000", "#ffffff", 250, 0);
                                      animator.TextFill(lab2, "#000000", "#ffffff", 250, 0);
                                      animator.TextFill(trouble, "#000000", "#ffffff", 250, 0);
                                      contact.setTextFill(Color.web("#2ED6EB"));
//                lab1.setBackground(new Background(new BackgroundFill(rgb(19,0,73),null,null)));
//                lab2.setBackground(new Background(new BackgroundFill(rgb(19,0,73),null,null)));
//                lab1.setStyle("-fx-text-fill: white");
//                lab2.setStyle("-fx-text-fill: white");

                                      animator.ColourChangeShape(wcpane, "#212121", "#ffffff", 250, 0);
                                      animator.ColourChangeShape(studentrect, "#191919", "#2EBCFD", 100, 0);
                                      animator.ColourChangeShape(teachrect, "#010453", "#ffffff", 100, 0);
                                      animator.ColourShiftRect(sider, "#2EBDFC", "#2EE1E2", "#130048", "#070027", 250, 0);
                                      animator.TextFill(welcome, "#2ED6EB", "#000000", 250, 0);
                                      animator.TextFill(logininfo, "#2ED6EB", "#000000", 250, 0);


//                login.setBackground(new Background(new BackgroundFill(rgb(19,0,73),new CornerRadii(0),null)));
//                login.setStyle("-fx-text-fill: white");

                                      animator.hoverOn(login, "#2ED6EB", "#2ED6EB", "#130049", "#130049", 0, 250);
                                      animator.TextFill(login, "#000000", "#ffffff", 250, 0);


//                animator.ColourShiftPane(linepane,"#1a1a1a","#1a1a1a","#ffffff","#ffffff",0,250,0);
                                      animator.PaneToWhite(linepane, 0, 250, 0);


                                      type = "admin";
                                      TranslateTransition slide = new TranslateTransition();
                                      slide.setDuration(Duration.seconds(0.25));
                                      slide.setNode(side);

                                      slide.setToX(-395);
                                      slide.play();
                                      animator.LinearMoveX(sliderbg, 250, 0, 295, 0);

                                      slide.setOnFinished((e -> {


                                      }));

                                      tch = 0;
                                      std = 1;

                                  }
                              }
                          }
        );




        user.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                if (check1 == 1){

                    animator.hoverOffbg(user, "#2EBCFD", "#2EBCFD", "#2EE2E2", "#2EE2E2", 0,2, 250);

                }
                else {
                    animator.hoverOnbg(user, "#999999", "#999999", "#212121", "#212121", 0, 2, 250);
                }
            }

        });

        user.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (check1 == 1){

                    animator.hoverOffbg(user, "#2EBCFD", "#2EBCFD", "#2EE2E2", "#2EE2E2", 0,2, 250);

                }
                else {

                    animator.hoverOffbg(user, "#999999", "#999999", "#212121", "#212121", 0, 2, 250);

                }
//                animator.hoverOffbg(user, "#ffffff", "#ffffff", "#000000", "#000000", 0,2, 100);

            }

        });

        user.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animator.hoverOnbg(user, "#2EBCFD", "#2EE2E2", "#2EE2E2", "#2EBCFD", 0,2, 250);
                check1 = 1;
                check2 = 0;
            }

        });

        user.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animator.hoverOffbg(user, "#2EBCFD", "#2EE2E2", "#2EE2E2", "#2EBCFD", 0,2, 250);


            }

        });

        //***************************************************************************************************
        //***************************************************************************************************
        //***************************************************************************************************
        //***************************************************************************************************
        //***************************************************************************************************
        //***************************************************************************************************
        //***************************************************************************************************


        pass.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                if (check2 == 1){

                    animator.hoverOffbg(pass, "#2EBCFD", "#2EBCFD", "#2EE2E2", "#2EE2E2", 0,2, 250);

                }
                else {
                    animator.hoverOnbg(pass, "#999999", "#999999", "#212121", "#212121", 0, 2, 250);
                }
            }

        });

        pass.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (check2 == 1){

                    animator.hoverOffbg(pass, "#2EBCFD", "#2EBCFD", "#2EE2E2", "#2EE2E2", 0,2, 250);

                }
                else {

                    animator.hoverOffbg(pass, "#999999", "#999999", "#212121", "#212121", 0, 2, 250);

                }
//                animator.hoverOffbg(user, "#ffffff", "#ffffff", "#000000", "#000000", 0,2, 100);

            }

        });

        pass.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animator.hoverOnbg(pass, "#2EBCFD", "#2EE2E2", "#2EE2E2", "#2EBCFD", 0,2, 250);
                check2 = 1;
                check1 = 0;
            }

        });

        pass.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                animator.hoverOffbg(pass, "#2EBCFD", "#2EE2E2", "#2EE2E2", "#2EBCFD", 0,2, 250);

            }

        });



        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                animator.ScaleX(removableteacher, 250, 1, 0, 250);
                animator.ScaleX(side, 500, 1, 0, 500);
                animator.ScaleY(side, 500, 1, 0, 500);

                if(student.isSelected()){
                    animator.LinearMoveX(side, 250, 0,-183,  0);
                }
                if(teach.isSelected()){
                    animator.LinearMoveX(side, 250, -375,-183,  0);
                }

                animator.FadeOut(removableteacher,100,450);
                animator.FadeOut(side,100,950);

                l1.finish(0,1);

                ScaleTransition scale = animator.ScaleReturn(clipper, 50, 0, 0, 1000);

                scale.setOnFinished(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {

                        try {
                            Auth mylogin = new Auth(user.getText(), pass.getText(), type, primaryStage,"login",welcome);
                            mylogin.authenticate();

                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }

                    }

                });

            }

        });


        close.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                animator.ScaleX(removableteacher, 250, 1, 0, 250);
                animator.ScaleX(side, 500, 1, 0, 500);
                animator.ScaleY(side, 500, 1, 0, 500);
                if(student.isSelected()){
                    animator.LinearMoveX(side, 250, 0,-183,  0);
                }
                if(teach.isSelected()){
                    animator.LinearMoveX(side, 250, -375,-183,  0);
                }
                animator.FadeOut(removableteacher,100,450);
                animator.FadeOut(side,100,950);

                l1.finish(0,1);

                ScaleTransition scale = animator.ScaleReturn(clipper, 50, 0, 0, 1000);

                scale.setOnFinished(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {

                        primaryStage.close();

                    }


                });

            }
        });


    }




}
