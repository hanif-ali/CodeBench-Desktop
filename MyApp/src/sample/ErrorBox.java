package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Optional;

public class ErrorBox {
    BorderPane border;
    AnchorPane anchorPane;
    String message;
    String name;
    ErrorBox(String name,String message,BorderPane br){
        this.border=br;
        this.name=name;
        this.message=message;
    }
    ErrorBox(String name,String message,AnchorPane anchorPane){
        this.anchorPane=anchorPane;
        this.name=name;
        this.message=message;
    }


    public void showDialogue(){

        ColorAdjust dimi = new ColorAdjust();
        dimi.setBrightness(-0.3);
        dimi.setSaturation(-0.3);
        dimi.setContrast(-0.3);
        BoxBlur blur = new BoxBlur(3,3,3);
        System.out.println("Click");
        Dialog<ButtonType> dialog = new Dialog<>();
        if(border==null){
            dialog.initOwner(anchorPane.getScene().getWindow());
            dialog.initOwner(anchorPane.getScene().getWindow());
            dialog.initStyle(StageStyle.UNDECORATED);
            blur.setInput(dimi);
            anchorPane.setEffect(blur);

    }   else{
            dialog.initOwner(border.getScene().getWindow());
            dialog.initStyle(StageStyle.UNDECORATED);
            blur.setInput(dimi);
            border.setEffect(blur);}
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ErrorBox.fxml"));
            loader.setControllerFactory(t ->new Error(message,name));
            Parent parent=loader.load();
            dialog.getDialogPane().setContent(parent);

        } catch(IOException e){

            System.out.println("Unable to load dialouge Box");
        }
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent()){
        }
        else{
            if(border!=null){
            border.setEffect(null);}
            else {
                anchorPane.setEffect(null);
            }


        }

    }
}
