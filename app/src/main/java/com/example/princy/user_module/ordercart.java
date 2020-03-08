package com.example.princy.user_module;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ordercart extends AppCompatActivity {

    ArrayList<data> productList;
    SessionManager sessionManager;


    private RecyclerView recyclerView;
    private  RecyclerView.LayoutManager layoutManager;
    Button  btnadd ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordercart);
        recyclerView = findViewById(R.id.rvorder);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        productList = new ArrayList<>();
        getData();
        Log.i("we returned", "shut up!");
        Log.i("FoodList in on create", "LOL");





    }

    private void getData() {
        RequestQueue requestQueue = Volley.newRequestQueue(ordercart.this);
        getIp ip = new getIp();
        String del = ip.getIp();
        String URL = ""+del+":8080/get_order";
        sessionManager = new SessionManager(getApplicationContext());
        sessionManager.checkLogin();
        HashMap<String, String> user = sessionManager.getUserDetails();
       String phone = user.get(sessionManager.PHONE);

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("test", "null");
            jsonObject.put("phone",phone);

        } catch (Exception e) {
            e.printStackTrace();
        }

        final String requestBody = jsonObject.toString();
        Log.d("str", "str is" + requestBody);

        connection.sendData(requestBody, requestQueue, URL, new connection.VolleyCallback(){


            public void onSuccessResponse(String result) {
                Log.d("result pagal =", "" + result);

                result = result.replaceAll("\'", "");


                if (result != null) {
                    try {
                        JSONArray jsonArray = new JSONArray(result);
                        Log.d("jsonAray", "" + jsonArray);
                        Log.d("Jsonarray ka  size", "size" + jsonArray.length());
                        int i;
                        for (i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                            String product = null;
                            try {
                                product = jsonObject1.getString("product");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            String images = null;
                            try {
                                images = jsonObject1.getString("images");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            String images1 = null;
                            try {
                                images1 = jsonObject1.getString("images1");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            String images2 = null;

                            try {
                                images2 = jsonObject1.getString("images2");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            String quantity = null;

                            try {
                                quantity = jsonObject1.getString("quantity");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Log.d("loc", "" + images1);
                            Log.d("name", "" + images);
                            Log.d("price", "" + images2);
                            productList.add(new data(product,images,images1,images2,quantity));



                        }
                          Cartviewholder cartviewholder = new Cartviewholder(ordercart.this, productList);
                        recyclerView.setAdapter(cartviewholder);



                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                }
            }

            public void onErrorResponse(VolleyError error) {

                Log.d("error: ", "hagg diya");
            }

        });
    }




}

