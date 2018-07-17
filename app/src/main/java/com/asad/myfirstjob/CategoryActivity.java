package com.asad.myfirstjob;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;

public class CategoryActivity extends AppCompatActivity {

    String str, email;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<CategoryListItem> menuListItems;

    TextView login, signup;

    String user_email, loginUsername, signupUsername, user_email_new;

    public static Activity fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        fa = this;

        menuListItems = new ArrayList<>();

        login = findViewById(R.id.login_username_txt);
        signup = findViewById(R.id.signup_username_txt);

        loginUsername = getIntent().getStringExtra("login_username");
        user_email = getIntent().getStringExtra("email");
        user_email_new = getIntent().getStringExtra("user_email_new");
        email = getIntent().getStringExtra("email");

        login.setText(loginUsername);
        signup.setText(signupUsername);

        editor.putString("Username", loginUsername);
        editor.putString("Email", email);
        editor.commit();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getServicesAsyncClass as = new getServicesAsyncClass(new AsyncResponse() {
            @Override
            public void processFinish(Object output) {

                Log.d("Asynchronous task:", (String) output);

                str = removeCharAt((String) output);

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    JSONArray array = jsonObject.getJSONArray("Menu");

                    for (int i = 0; i<array.length(); i++)
                    {
                        JSONObject o = array.getJSONObject(i);
                        CategoryListItem item = new CategoryListItem(
                                o.getString("ServiceCatID"),
                                o.getString("ServiceCatDesc"),
                                o.getString("CatImg")
                        );
                        menuListItems.add(item);
                    }

                    adapter = new MyCategoryAdapter(menuListItems, getApplicationContext());
                    recyclerView.setAdapter(new AlphaInAnimationAdapter(adapter));

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });
        as.execute();
    }

    private static String removeCharAt(String s) {

        return new StringBuilder(s)
                .deleteCharAt(s.length() - 3)
                .toString();
    }

    public class getServicesAsyncClass extends AsyncTask<String, String, String>
    {
        ProgressDialog pd = new ProgressDialog(CategoryActivity.this);

        public AsyncResponse delegate = null;

        public getServicesAsyncClass(AsyncResponse asyncResponse) {
            delegate = asyncResponse;
        }

        @Override
        protected void onPreExecute() {
            pd.setMessage("loading");
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {

            String SOAP_ACTION = "http://apps.visualsolutions.work/getServices";
            String METHOD_NAME = "getServices";
            String NAMESPACE = "http://apps.visualsolutions.work/";
            String URL = "http://androidwebservice.somee.com/WebService.asmx?WSDL";

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            SoapObject response;
            String result;

            HttpTransportSE httptransport = new HttpTransportSE(URL);
            httptransport.debug = true;

            try
            {

                httptransport.call(SOAP_ACTION, envelope);
                response = (SoapObject) (SoapObject)envelope.bodyIn;
                result = (response.getProperty(0).toString());
            }
            catch (Exception e)
            {
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
}
