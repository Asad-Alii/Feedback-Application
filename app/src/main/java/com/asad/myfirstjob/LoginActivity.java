package com.asad.myfirstjob;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertDialog;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class LoginActivity extends BaseActivity {

    private String emailToRemember, passwordToRemember;
    private CheckBox saveLoginCheckBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;

    TextView signUp;
    Button login;
    EditText Email, Password;

    String username, email, password;
    int userno;

    DatabaseHelper helper = new DatabaseHelper(this);

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z._-]+\\.+[a-z]+";

    NestedScrollView scroll_view;

    private int PHONE_STATE_CODE=1;
    String imei;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        saveLoginCheckBox = findViewById(R.id.saveLoginCheckBox);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        Email = findViewById(R.id.email_edt);
        Password = findViewById(R.id.pass_edt);

        scroll_view = findViewById(R.id.nestedScrollView);

        loadImei();

        signUp = findViewById(R.id.signup_txt);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(in);
            }
        });

        login = findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LoginSoapClass asc = new LoginSoapClass(new AsyncResponse() {
                    @Override
                    public void processFinish(Object output) {

                        Log.d("Asynchronous task:", (String) output);

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
                            //return;
                        }

                        if (TextUtils.isEmpty(pa)) {
                            Toast.makeText(LoginActivity.this, "Please enter your Password", Toast.LENGTH_SHORT).show();
                            //return;
                        }

                        if (pa.length() < 4) {
                            Toast.makeText(LoginActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
                            //return;
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

                            //Toast.makeText(LoginActivity.this, username, Toast.LENGTH_SHORT).show();
                            Intent in = new Intent(LoginActivity.this, CategoryActivity.class);
                            in.putExtra("login_username", username);
                            in.putExtra("email", em);
                            in.putExtra("imei", imei);
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

        public AsyncResponse delegate = null;

        public LoginSoapClass(AsyncResponse asyncResponse) {
            delegate = asyncResponse;
        }

        private final ProgressDialog dialog = new ProgressDialog(LoginActivity.this);

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
                response = (SoapObject) (SoapObject) envelope.bodyIn;
                result = (response.getProperty(0).toString());

            } catch (Exception e) {
                result = "Error";
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            delegate.processFinish(result);
            //Toast.makeText(LoginActivity.this, result, Toast.LENGTH_SHORT).show();
            dialog.dismiss();
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
        if(requestCode == PHONE_STATE_CODE){
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

}
