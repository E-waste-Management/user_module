package com.example.princy.user_module;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Registration extends AppCompatActivity {

    EditText edtName,edtemail,edtphone,edtpass,edtstreet,edtaddress,edtcity,edtpin;
    Button btnReg;


    ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        edtName=findViewById(R.id.txtName);
        edtemail=findViewById(R.id.txtEmail);
        edtphone=findViewById(R.id.txtPhone);
        edtpass=findViewById(R.id.txtPass);
        edtstreet=findViewById(R.id.txtstreet);
        edtcity=findViewById(R.id.txtcity);
        edtaddress=findViewById(R.id.txtaddress);
        edtpin=findViewById(R.id.txtpin);
        btnReg=findViewById(R.id.btnreg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= edtemail.getText().toString().trim();
                String pass = edtpass.getText().toString().trim();
                String name = edtName.getText().toString().trim();

                String city= edtcity.getText().toString().trim();
                String pin = edtpin.getText().toString().trim();
                String phone=edtphone.getText().toString().trim();
                String  address = edtaddress.getText().toString().trim();
                String street = edtstreet.getText().toString().trim();

                if (!email.isEmpty() || !pass.isEmpty() || !name.isEmpty() || !city.isEmpty() || !pin.isEmpty() || !phone.isEmpty() || !street.isEmpty() || !address.isEmpty()) {
                    if(phone.length()==10 && pin.length()==6) {
                        Register(email, pass,name,city,pin,phone,street,address);
                    }
                }
                else{
                    edtemail.setError("email is invalid");
                    edtpass.setError("password is invalid");
                    edtName.setError("name is invalid");
                    edtcity.setError("city is invalid");
                    edtpin.setError("pincode is invalid");
                    edtphone.setError("invalid number");
                    edtaddress.setError("invalid address");
                    edtstreet.setError("invalid street");
                }

            }
        });



    }
    private void Register(String email, String pass, String name ,String city ,String pin , String phone ,String  street ,String address) {
        getIp ip = new getIp();
        String del = ip.getIp();
        RequestQueue requestQueue = Volley.newRequestQueue(Registration.this);
      //  String URL = "C:\\wamp64\\www\\user_module\\api.php";
        String URL=del+"/user_module/api.php";
        System.out.println("URL"+URL);


        Log.d("register","register var aala aapan" );
      //  String URL = "http://192.168.43.254:8080/register";
        String mregister = "mregister";
        JSONObject jsonObject = new JSONObject();
        try {

          //  jsonObject.put("registration",registration);
            jsonObject.put("email", email);
            jsonObject.put("pass", pass);
            jsonObject.put("name", name);
            jsonObject.put("city", city);
            jsonObject.put("pin", pin);
            jsonObject.put("phone", phone);
            jsonObject.put("address", address);
            jsonObject.put("street", street);
            jsonObject.put("mregister", mregister);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        final String requestBody = jsonObject.toString();
        Log.d("str_register","strREG is"+requestBody);

        connection.sendData(requestBody, requestQueue, URL, new connection.VolleyCallback(){
            @Override
            /*
            public void onSuccessResponse(String result) {
                Log.d("RESULT","RESULTS "+result);
                if (result.equals("1")) {
                    Toast.makeText(RegistrationActivity.this, result, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                //System.out.print("Bool" + result);
                 else {
                    Toast.makeText(RegistrationActivity.this, "Oops! Try Again.", Toast.LENGTH_SHORT).show();
                }
            }
            */

            public void onSuccessResponse(String result) {
                System.out.println("Alok");
                Log.d("RESULT","RESULTS dgfiugifgdi "+result);
                if (result.contains("1")) {
                    Toast.makeText(Registration.this, "Hello", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Registration.this, login.class);
                    startActivity(intent);
                }
                else {
                    if(result.contains("User already exists."))
                    Toast.makeText(Registration.this, "User already exists", Toast.LENGTH_SHORT).show();
                    else{
                    Log.d("skdnasj", "result was" + result);
                        Toast.makeText(Registration.this, "oopss try again", Toast.LENGTH_SHORT).show();

                    }
                }
            }


            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Alok"+error);
                Toast toast = Toast.makeText(Registration.this,
                        "Volley needs attention" + error.networkResponse,
                        Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
