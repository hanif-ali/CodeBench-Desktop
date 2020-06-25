package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ResourceBundle;

public class Visible implements Initializable {
    JSONObject test;
    @FXML
    Label testcases;
    @FXML
    Label ttest;
    @FXML
    Label stest;

    @FXML
    Label linter;
    int passed=0;

    Visible(JSONObject obj){
        this.test=obj;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //int num=(int)((Double.parseDouble((String) test.getJSONObject("scores").get("linter")))*1000);
            int num=(int)(test.getJSONObject("scores").getDouble("linter")*1000);
            int numb=(int)(test.getJSONObject("percentages").getDouble("linter")) ;
            linter.setText(num+"/"+numb);
            JSONArray vis=(JSONArray)test.getJSONArray("visible_test_cases");
            ttest.setText(vis.length()+"");
            int tot=vis.length();
            for(int i=0;i<vis.length();i++){
                if(vis.getJSONObject(i).getBoolean("passed")){
                    passed+=1;
                }
            }
            stest.setText(passed+"");
            double percent=passed/tot*100;
            int p=(int)percent;
            testcases.setText(p+"");




        } catch (JSONException e) {
            e.printStackTrace();
        }



    }
}
