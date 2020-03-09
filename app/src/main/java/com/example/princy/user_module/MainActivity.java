package com.example.princy.user_module;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;
import java.util.HashMap;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Vector;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button btnitem1, btnupload ,btncap;
    Spinner cat1;
    ImageView cam1,cam2;
    EditText edtproduct, edtquan,cat2;
    SessionManager sessionManager;
    String phone ="";
    CheckBox checkitem;
    ImageView imageview;
    Bitmap bitmap,bitmap1,bitmap2;
    int p =0;
    long order_id;



    private static final int pic_id = 123;
    private static final int pic_id1 = 456;
    private static final int pic_id2 = 789;
    private int requestCode;
    private int resultCode;
    private Intent data;
    private String pictureFile;
    ProgressBar loading;
    Object b1,b2,b3;
   // final String URL="C:\\wamp64\\www\\user_module\\api.php";
    EditText pd;
    int count = 0;
    int [] pic = {1,2,3};
    Vector v = new Vector();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnitem1 = findViewById(R.id.btnitem);
        btncap = findViewById(R.id.capture);
        btnupload = findViewById(R.id.upload);
        cat1 = findViewById(R.id.cat);
        cat2 = findViewById(R.id.subcat);
        imageview = findViewById(R.id.imageView);
        cam1 = findViewById(R.id.camera1);
        cam2 = findViewById(R.id.camera2);
        pd = findViewById(R.id.pd);
        final int requestcode = 7;
        Date date= new Date();

        long time = date.getTime();
        order_id = time;






        edtproduct = findViewById(R.id.pd);
        edtquan = findViewById(R.id.edquantity);
        checkitem = findViewById(R.id.chksave);

//        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//        String pictureFile = "ZOFTINO_"+timestamp;
//        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//        File image = File.createTempFile(pictureFile, ".jpg",storageDir);
//        pictureFilePath = image.getAbsolutePath();

            // Inflate the menu; this adds items to the action bar if it is present.








        btncap.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Log.d("Capture", "Mandir vahi banayenge");
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera, pic[count++]);
                if(count>2){
                    count = 0;
                }


            }
            }
        );

//        btncap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(camera, pic_id1);
//            }
//        });
//        btncap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(camera, pic_id2);
//            }
//        });k
//
//        btnupload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("news", "Jai Shree Ram");
//            }
//        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pr = new Intent(MainActivity.this,MainActivity.class);
            startActivity(pr);}
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    public void UploadImage(final Object b1, final Object b2 , Object b3, String phone, int p, long order_id) {
        Log.d("upload","upload var aala aapan" );
        Log.d("miss","miss"+b1);
        getIp ip = new getIp();
        String del = ip.getIp();
        String ten = pd.getText().toString();
        String quan = edtquan.getText().toString();
        String subcat = cat2.getText().toString();
        String cat = cat1.getSelectedItem().toString();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
              //  Log.d("str_register","nilesh on response"+requestBody);
                Log.d("response", "response"+response);
             //   volleyCallback.onSuccessResponse(response);
            }
        }, new Response.ErrorListener() {

            public void onErrorResponse(VolleyError error) {
               // volleyCallback.onErrorResponse(error);
            }
        })  {
           protected Map<String, Object> getparams() throws AuthFailureError{
               Map<String,Object> params = new HashMap<>();
               String mregister = "morder";
               params.put("images",b1);
               params.put("images1",b2);
               params.put("mregister",mregister);
                 Log.d("str_register","onee"+params);



               return params; }

        } ;
        RequestQueue requestQueue1 = Volley.newRequestQueue(MainActivity.this);
              requestQueue1.add(stringRequest);



                Log.d("bitmap","bitmap");
        Log.d("dfdfusdf", "dfksdfd "+ten);
        Log.d("love","image nahi milega"+b2);
        Log.d("princy","image nahi mila"+b3);
        Log.d("je","jeni"+cat);
        Log.d("elsa","elsa"+order_id);
        Log.d("meee","meee"+p);






        Log.d("dfdfusdf", "image leaa"+b1);

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
      // String URL = ""+del+":8080/upload";
        String URL = del+"/user_module/api.php";

        String mregister = "morder";

        //  String URL = "http://192.168.0.107:8080/user_module/api.php";


        //String URL = "http://192.168.0.103:8080/register";
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("product_desc", ten);

            jsonObject.put("phone",phone);
            jsonObject.put("quantity",quan);
          //  jsonObject.put("images1",b2);
          //  jsonObject.put("images2",b3);
            jsonObject.put("catgory",cat);
            jsonObject.put("subcatgory",subcat);
            jsonObject.put("product_id",p);
            jsonObject.put("order_id",order_id);
            jsonObject.put("images",b1);
            jsonObject.put("mregister", mregister);
            Log.d("lln", "json"+jsonObject);
            System.out.print(jsonObject);



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
                Log.d("RESULT","RESULTS dgfiugifgdi "+result);
                if (result.contains("1")) {
                    Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                    } else {
                    Toast.makeText(MainActivity.this, "Ooops! Try Again.", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onErrorResponse(VolleyError error) {
                Toast toast = Toast.makeText(MainActivity.this,
                        "Volley needs attention" + error,
                        Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("aamhi onactivity","aamhi onactivity");
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            // Uri filepath = data.getData();
            //try {
            //  bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
            final Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageview.setImageBitmap(bitmap);
            String image = getStringImage(bitmap);

            v.add(image);
            Log.d("bit", "bit" + bitmap);


        }else if(requestCode == 2 && resultCode ==RESULT_OK && data!=null){
            Bitmap bitmap1 = (Bitmap) data.getExtras().get("data");
            cam1.setImageBitmap(bitmap1);
            String image1 = getStringImage(bitmap1);
            v.add(image1);


        } else if (requestCode  == 3 && resultCode ==RESULT_OK && data!= null){
            Bitmap bitmap2 = (Bitmap) data.getExtras().get("data");
            cam2.setImageBitmap(bitmap2);
            String image2 = getStringImage(bitmap2);

            v.add(image2);

        }



            btnupload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sessionManager = new SessionManager(getApplicationContext());
                    sessionManager.checkLogin();
                    HashMap<String, String> user = sessionManager.getUserDetails();
                    phone = user.get(sessionManager.PHONE);
                    Log.d("news", "Jai Shree Ram");
                    Log.d("news", "sure"+v.add(1));
                     p = p+1;
                //    Intent pr = new Intent(MainActivity.this,ordercart.class);
                //    startActivity(pr);



                   UploadImage(v.get(0), v.get(1),v.get(2),phone,p,  order_id);
                }
            });
            //} catch (IOException e) {
              //  e.printStackTrace();
            //}


    }

    public String getStringImage(Bitmap bm) {
        Log.d("heloo","heloo"+bm);
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, ba);
        byte[] imagebyte = ba.toByteArray();
        String encode = Base64.encodeToString(imagebyte, Base64.DEFAULT);
        return encode;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cart, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Log.d("id", "id ka value"+id);

        //noinspection SimplifiableIfStatement
        if (id == R.id.cart) {
            Intent ar = new Intent(MainActivity.this,My_Post.class);
            startActivity(ar);

            return true;
        }
        if (id== R.id.dial){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.MyProfile) {
            Intent in = new Intent(MainActivity.this, Registration.class);
            startActivity(in);
            // Handle the camera action
            //put intent here to which page you have to go on this corresponding menu click
        } else if (id == R.id.MYPost) {
            Intent an = new Intent(MainActivity.this, ordercart.class);
            startActivity(an);

        } else if (id == R.id.vouchers) {
            Intent ab = new Intent(MainActivity.this, My_Vouchers.class);
            startActivity(ab);

        }

         else if (id == R.id.addpost) {
            Intent ae = new Intent(MainActivity.this, MainActivity.class);
            startActivity(ae);

        } else if (id == R.id.help) {
            Intent ac = new Intent(MainActivity.this, help.class);
            startActivity(ac);

        } else if (id == R.id.about) {
            Intent ac = new Intent(MainActivity.this, About_us.class);
            startActivity(ac);

        } else if (id == R.id.log) {
            sessionManager = new SessionManager(getApplicationContext());
            sessionManager.logout();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }


}
