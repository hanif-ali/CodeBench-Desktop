package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LabelPractice implements Initializable {

@FXML
    private Label mylab;
@FXML
    private AnchorPane mypan;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Scanner my=new Scanner(System.in);
        String lab=my.nextLine();
        mylab.setText(lab);
        Label labs=new Label("I am new");
        mypan.getChildren().add(labs);

    }
}
