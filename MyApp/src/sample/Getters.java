package sample;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
interface GET{

    public JSONObject adDetails(String token) throws JSONException;

    public JSONArray courses(String token) throws JSONException;

    public JSONArray assignments(int id,String token) throws JSONException;

    public JSONArray submissions(int id,String token) throws JSONException;

    public JSONObject subDetails(int subId,String token) throws JSONException;
}

public class Getters implements GET{

    public JSONObject adDetails(String token) throws JSONException {

        JavaGet detail=new JavaGet("admin/details",token);

        //JSONObject myjson=detail.authGet();
        JSONObject myjson=new JSONObject(detail.authGet());
        return myjson;
    }
    public JSONObject detailsStudent(String token) throws JSONException {
        JavaGet detail=new JavaGet("student/details",token);
        return new JSONObject(detail.authGet());

    }

    public JSONArray courses(String token) throws JSONException {
        JavaGet detail=new JavaGet("admin/groups",token);

        return new JSONArray(detail.authGet());
    }

    public JSONArray assignments(int id,String token) throws JSONException {
        JavaGet detail=new JavaGet("admin/groups/"+id+"/assignments",token);

        return new JSONArray(detail.authGet());
    }

    public JSONArray submissions(int id,String token) throws JSONException {
        JavaGet detail=new JavaGet("admin/assignments/"+id+"/submissions",token);
        //JSONObject myjson=detail.authGet();
        return new JSONArray(detail.authGet());

    }

    @Override
    public JSONObject subDetails(int subId, String token) throws JSONException {
        JavaGet detail=new JavaGet("admin/submissions/"+subId+"/results",token);
        //JavaGet detail=new JavaGet("admin/submission/subid",token);
        return new JSONObject(detail.authGet());
        //return myjson;
    }
    public JSONArray studAssign(String token) throws JSONException {
        JavaGet detail=new JavaGet("student/assignments",token);
        return new JSONArray(detail.authGet());
    }

}
