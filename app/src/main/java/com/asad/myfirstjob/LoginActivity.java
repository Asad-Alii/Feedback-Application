package com.asad.myfirstjob;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

    private String emailToRemember, passwordToRemember;
    private CheckBox saveLoginCheckBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;

    AppCompatTextView signUp;
    AppCompatButton login;
    TextInputEditText Email, Password;

    String username, email, password;
    int userno;

    DatabaseHelper helper = new DatabaseHelper(this);

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z._-]+\\.+[a-z]+";

    NestedScrollView scroll_view;

    static final int PHONE_STATE_CODE=1;
    String imei;

    static final int REQUEST_LOCATION = 2;

    LocationManager locationManager;
    String value = null;
    double dLat;
    double dLong;
    private GoogleMap mMap;

    String address1, address2, address3, address4, address;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        saveLoginCheckBox = findViewById(R.id.saveLoginCheckBox);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        Email = findViewById(R.id.email_edt);
        Password = findViewById(R.id.pass_edt);
        signUp = findViewById(R.id.signup_txt);
        login = findViewById(R.id.btn_login);

        scroll_view = findViewById(R.id.nestedScrollView);

        loadImei();

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        getLocation();
        address = address1 + ", " + address2 + ", " + address3 + ", " + address4;

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(LoginActivity.this, SignupActivity.class);
                in.putExtra("imei", imei);
                in.putExtra("address", address);
                startActivity(in);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(LoginActivity.this, "Testing", Toast.LENGTH_SHORT).show();

                LoginSoapClass asc = new LoginSoapClass(new AsyncResponse() {
                    @Override
                    public void processFinish(Object output) {

                        //Log.d("Asynchronous task:", (String) output);

                        //int userno = 0;
                        //String username = null;
                        //String email = null;
                        //String password;

                        String em = Email.getText().toString();
                        String pa = Password.getText().toString();

                        String passw = helper.searchPass(em);

                        String uname = helper.searchPass1(em);

                        try {

                            JSONObject user = (new JSONObject((String) output)).getJSONObject("users");

                            userno = user.getInt("UserNo");
                            username = user.getString("UserName");
                            email = user.getString("Email");
                            password = user.getString("Password");

                            //Toast.makeText(LoginActivity.this, password, Toast.LENGTH_SHORT).show();


                        } catch (JSONException e) {
                            e.printStackTrace();
                            //Toast.makeText(LoginActivity.this, "Username and Password don't match!", Toast.LENGTH_SHORT).show();
                        }

                        if (!em.matches(emailPattern)) {
                            Toast.makeText(LoginActivity.this, "Please enter valid email address", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (TextUtils.isEmpty(pa)) {
                            Toast.makeText(LoginActivity.this, "Please enter your Password", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (pa.length() < 4) {
                            Toast.makeText(LoginActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (pa.equals(password)) {
                            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(Email.getWindowToken(), 0);

                            emailToRemember = Email.getText().toString();
                            passwordToRemember = Password.getText().toString();

                            if (saveLoginCheckBox.isChecked()) {
                                loginPrefsEditor.putBoolean("saveLogin", true);
                                loginPrefsEditor.putString("email", emailToRemember);
                                loginPrefsEditor.putString("password", passwordToRemember);
                                loginPrefsEditor.commit();
                            } else {
                                loginPrefsEditor.clear();
                                loginPrefsEditor.commit();
                            }

                            Intent in = new Intent(LoginActivity.this, CategoryActivity.class);
                            in.putExtra("login_username", username);
                            in.putExtra("email", em);
                            in.putExtra("imei", imei);
                            in.putExtra("address", address);
                            startActivity(in);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this, "Username and Password don't match!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                asc.execute();

            }
        });

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            Email.setText(loginPreferences.getString("email", ""));
            Password.setText(loginPreferences.getString("password", ""));
            saveLoginCheckBox.setChecked(true);

        }

    }

    public class LoginSoapClass extends AsyncTask<String, String, String> {

        ProgressDialog pd = new ProgressDialog(LoginActivity.this);

        public AsyncResponse delegate = null;

        public LoginSoapClass(AsyncResponse asyncResponse) {
            delegate = asyncResponse;
        }

        @Override
        protected void onPreExecute() {
            pd.setMessage("loading");
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {

            String SOAP_ACTION = "http://apps.visualsolutions.work/getLoginDetail";
            String METHOD_NAME = "getLoginDetail";
            String NAMESPACE = "http://apps.visualsolutions.work/";
            String URL = "http://androidwebservice.somee.com/WebService.asmx?WSDL";

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

            PropertyInfo pi = new PropertyInfo();
            pi.setName("UserId");
            pi.setValue(Email.getText().toString());
            pi.setType(String.class);
            request.addProperty(pi);

            pi = new PropertyInfo();
            pi.setName("Password");
            pi.setValue(Password.getText().toString());
            pi.setType(String.class);
            request.addProperty(pi);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            SoapObject response;
            String result;

            HttpTransportSE httptransport = new HttpTransportSE(URL);
            httptransport.debug = true;

            try {

                httptransport.call(SOAP_ACTION, envelope);
                response = (SoapObject) envelope.bodyIn;
                result = (response.getProperty(0).toString());

            } catch (Exception e) {
                result = "Error";
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            delegate.processFinish(result);
            if (pd.isShowing()) {
                pd.dismiss();
            }
        }
    }

    public void loadImei(){
        TelephonyManager t = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE );
        if (ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            imei =t.getDeviceId();
        } else {
            reqPhonePermission();
        }
    }

    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults ){

        switch (requestCode)
        {
            case REQUEST_LOCATION:
                getLocation();

            case PHONE_STATE_CODE:
                    if(grantResults.length > 0 && grantResults[0] ==  PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this,"Permission granted",Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this,"Permission denied",Toast.LENGTH_SHORT).show();
                    }
        }
    }

    private void reqPhonePermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_PHONE_STATE)){
            new AlertDialog.Builder(this).setTitle("permission needed").setMessage("this permission needed")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCompat.requestPermissions(LoginActivity.this,new String[]{Manifest.permission.READ_PHONE_STATE},PHONE_STATE_CODE);

                        }
                    }) .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).create().show();
        } else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_PHONE_STATE},PHONE_STATE_CODE);
        }
    }

    void getLocation() {

        SharedPreferences preferences=getSharedPreferences("latLong",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.INTERNET}, REQUEST_LOCATION);

        } else {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if (location != null) {
                double latti = location.getLatitude();
                double longi = location.getLongitude();

                //e1 = (EditText) findViewById(R.id.atLocationLat);
                //e1.setText(latti + " , " + longi);
                //value = e1.getText().toString();
                //value = latti + " ," + longi;
                //editor.putString("value", value);
                //editor.commit();
                //e2.setText(value);
                //e2.setText("Latitude: " + longi);

                //Geocoder geocoder;
                //List<Address> addresses;
                //geocoder = new Geocoder(this, Locale.getDefault());
                //loc = findViewById(R.id.location_textview);

                try {
                    Geocoder geocoder;
                    List<Address> addresses;
                    geocoder = new Geocoder(this, Locale.getDefault());
                    addresses = geocoder.getFromLocation(latti, longi, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
                    String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                    String city = addresses.get(0).getLocality();
                    String state = addresses.get(0).getAdminArea();
                    String country = addresses.get(0).getCountryName();
                    String postalCode = addresses.get(0).getPostalCode();
                    String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL

                    String[] seperated = address.split(",");
                    address1 = seperated[0].trim();
                    address2 = seperated[1].trim();
                    address3 = seperated[2].trim();
                    address4 = seperated[5].trim();
                    //dLat = Double.parseDouble(latiPos);
                    //dLong = Double.parseDouble(longiPos);
                    //loc.setText(address1 + ", " + address2 + ", " + address3 + ", " + address4);
                    //loc.setText(address);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }


                //((EditText)findViewById(R.id.atLocationLat)).setText("Latitude: " + latti);
                //((EditText)findViewById(R.id.atLocationLong)).setText("Longitude: " + longi);

            } else {
                /*((EditText) findViewById(R.id.atLocationLat)).setText("Unable to find correct location.");
                ((EditText) findViewById(R.id.atLocationLong)).setText("Unable to find correct location. ");*/
            }
        }

    }

}
