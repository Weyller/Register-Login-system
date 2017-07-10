package com.example.breezil.loginsystem;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by breezil on 7/10/2017.
 */

public class RegisterRequest extends StringRequest{
    private static final String REGISTER_REQUEST_URL ="the Url.register.php";

    private Map<String,String> param;

    public RegisterRequest(String name, String username, int age, String password, Response.Listener<String> listener){

        super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        param = new HashMap<>();
        param.put("name",name);
        param.put("username",username);
        param.put("password",password);
        param.put("age",age+"");
    }

    public Map<String, String> getParam() {
        return param;
    }
}
