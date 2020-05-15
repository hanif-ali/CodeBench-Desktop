package sample;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestCase {
    private String stdin="";
    private String stdout="";
    TestCase(String stdin,String stdout){
        this.stdin=stdin;
        this.stdout=stdout;
    }

    public String getStdin() {
        return stdin;
    }

    public void setStdin(String stdin) {
        this.stdin = stdin;
    }

    public String getStdout() {
        return stdout;
    }

    public void setStdout(String stdout) {
        this.stdout = stdout;
    }
    public static JSONArray returner(JSONArray arr) throws JSONException {
        JSONArray newJ=new JSONArray();
        for(int i=0;i<arr.length();i++){
            if(arr.get(i) instanceof JSONObject){
                newJ.put(arr.get(i));
            }

        }
        return newJ;
    }
    public static int getLength(JSONArray arr)throws JSONException{
        JSONArray newJ=new JSONArray();
        for(int i=0;i<arr.length();i++){
            if(arr.get(i) instanceof JSONObject){
                newJ.put(arr.get(i));
            }

        }return newJ.length();
    }
}
