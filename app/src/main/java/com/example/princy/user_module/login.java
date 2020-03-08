//package com.example.princy.user_module;
//
//import android.annotation.SuppressLint;
//import android.app.MediaRouteButton;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.android.volley.RequestQueue;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONObject;
//
//@SuppressLint("registration")
//
//
//public class login extends AppCompatActivity {
//    TextView txtE, txtR;
//    Button btlogin;
//    EditText phone, edtPass;
//    CheckBox ckbox;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.login);
//        final ProgressBar loading;
//        //final String URL="http://192.168.0.103:8080/login";
//
//
//        //final String URL="http://192.168.0.103:8080/login";
//        txtE = findViewById(R.id.txtView);
//        txtR = findViewById(R.id.txtReg);
//
//        phone = findViewById(R.id.editphone);
//        edtPass = findViewById(R.id.txtPassword);
//
//        ckbox = findViewById(R.id.chkbox);
//
//        btlogin = findViewById(R.id.btnlogin);
//
//        //for shared preference
//        final SharedPreferences mPref;
//        final String PREF_NAME = "phone";
//        mPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
//        String storedEmail = mPref.getString("phone", "");
//        Log.d("Stored email", "stored email cha value"+storedEmail);
//        phone.setText(storedEmail);
//
////        txtE = findViewById(R.id.txtView);
////        txtR = findViewById(R.id.txtReg);
////
////        phone = findViewById(R.id.editphone);
////        edtPass = findViewById(R.id.txtPassword);
////
////        ckbox = findViewById(R.id.chkbox);
////
////        btlogin = findViewById(R.id.btnlogin);
//
//        btlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String phoneno = phone.getText().toString().trim();
//                String pass = edtPass.getText().toString().trim();
//                if (!phoneno.isEmpty() || !pass.isEmpty()) {
//                    //shared pref
//                    SharedPreferences.Editor editor = mPref.edit();
//                    editor.putString("phone", phoneno);
//                    editor.apply();
//
//                    Login(phoneno, pass);
//                    //shared pref
//                    phone.setText("");
//                    edtPass.setText("");
//                    Toast.makeText(login.this, "Saved", Toast.LENGTH_SHORT).show();
//                } else {
//                    phone.setError(" email ");
//                    edtPass.setError(" Password ");
//                }
//            }
//
//
//        });
//    }
//
//
//        private void Login (final String phone, String pass){
//
//                //name=findViewById(R.id.name);
//                getIp ip = new getIp();
//                String del = ip.getIp();
//                RequestQueue requestQueue = Volley.newRequestQueue(login.this);
//                //String URL = "http://192.168.0.103:8080/login";
//                String URL = "" + del + ":8080/login";
//
//                JSONObject jsonObject = new JSONObject();
//                try {
//                    jsonObject.put("phone", phone);
//                    jsonObject.put("pass", pass);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                final String requestBody = jsonObject.toString();
//                Log.d("str", "str is" + requestBody);
//
//                connection.sendData(requestBody, requestQueue, URL, new connection.VolleyCallback() {
//                    @Override
//                    public void onSuccessResponse(String result) {
//
//                        //System.out.print("Bool" + result);
//                        Log.d("RESULT", "RESULTS " + result);
//                        if (result.equals("1")) {
//                            MediaRouteButton loading = null;
//                            loading.setVisibility(View.VISIBLE);
//                            Toast.makeText(login.this, "Hello " + phone, Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                            Bundle bundle = new Bundle();
//                            bundle.putString("params", phone);
//                            intent.putExtras(bundle);
//                            startActivity(intent);
//                        } else {
//                            Toast.makeText(login.this, "Ooops! Try Again.", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast toast = Toast.makeText(login.this,
//                                "Volley needs attention" + error,
//                                Toast.LENGTH_LONG);
//                        toast.show();
//                    }
//                });
//
//
//            }
//    }
//
//
//
//


package com.example.princy.user_module;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@SuppressLint("Registered")

public class login extends AppCompatActivity {
    TextView txtE, txtR;
    Button btlogin;
    EditText phone, edtPass;
    CheckBox ckbox;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        txtE = findViewById(R.id.txtView);
        txtR = findViewById(R.id.txtReg);

        phone = findViewById(R.id.editphone);
        edtPass = findViewById(R.id.txtPassword);

        ckbox = findViewById(R.id.chkbox);

        btlogin = findViewById(R.id.btnlogin);


        sessionManager = new SessionManager(getApplicationContext());
        if (sessionManager.isLoggin()){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }

        //LOGIN BUTTON LOGIC
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mPhone=phone.getText().toString().trim();
                String mPassword=edtPass.getText().toString().trim();

                if (!mPhone.isEmpty() || !mPassword.isEmpty()) {
                    Login(mPhone,mPassword);
                    //shared pref
                    phone.setText("");
                    edtPass.setText("");
                    Toast.makeText(login.this,"Saved",Toast.LENGTH_SHORT).show();
                }
                else{
                    phone.setError("Please enter phone number");
                    edtPass.setError("Please enter password");
                }
            }
        });

        txtR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Registration.class);
                startActivity(intent);
            }
        });

    }

    private void Login(final String phone, final String password) {
        //name=findViewById(R.id.name);
         getIp ip = new getIp();
        String del = ip.getIp();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
      //  String URL = "http://192.168.43.254:8080/login";
        Log.d("login", "android ka login pahele"+phone+" "+password);
        String URL = del+"/user_module/api.php";
        Log.d("login", "android ka login"+phone+" "+password);
        JSONObject jsonObject = new JSONObject();
        String mregister = "mlogin";
        try {
            jsonObject.put("phone", phone);
            jsonObject.put("pass", password);
            jsonObject.put("mregister", mregister);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        String requestBody = jsonObject.toString();
        Log.d("str","str is"+requestBody);

        connection.sendData(jsonObject.toString(), requestQueue, URL, new connection.VolleyCallback(){
            @Override
            public void onSuccessResponse(String result) {

                System.out.print("It comes in login get data.");
                Log.d("RESULT","RESULTS login ka  "+result);
                if (result.contains("1")) {
                    Toast.makeText(login.this, "Hello "+phone, Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(login.this,MainActivity.class);
                    startActivity(in);

                    sessionManager.createSession(phone);
                    System.out.println("Email"+phone);

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(login.this, "Ooops! Try Again.", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast toast = Toast.makeText(login.this,
                        "Volley needs attention" + error,
                        Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }}