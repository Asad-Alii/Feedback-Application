package com.asad.myfirstjob;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText Name, Username, Email, Mobileno, Password1, Password2;

    Button signup;

    TextView status;

    DatabaseHelper helper = new DatabaseHelper(this);

    String emailPattern = "[a-zA-Z0-9._-a-zA-Z0-9]+@[a-z._-]+\\.+[a-z]+";

    String imei, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Name = findViewById(R.id.txt_name);
        Username = findViewById(R.id.txt_username);
        Email = findViewById(R.id.txt_email);
        Mobileno = findViewById(R.id.txt_mobileno);
        Password1 = findViewById(R.id.txt_password1);
        Password2 = findViewById(R.id.txt_password2);

        status = findViewById(R.id.txt_status);

        signup = findViewById(R.id.btn_signup);

        imei = getIntent().getStringExtra("imei");
        address = getIntent().getStringExtra("address");

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSignUpClick(view);
            }
        });

    }

    public void onSignUpClick(View v){

        if (v.getId() == R.id.btn_signup)
        {
            //User side validation
            if (TextUtils.isEmpty(Name.getText().toString()))
            {
                Toast.makeText(SignupActivity.this, "Please enter your Full Name", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(Username.getText().toString()))
            {
                Toast.makeText(SignupActivity.this, "Please enter your User Name", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!Email.getText().toString().matches(emailPattern))
            {
                Toast.makeText(SignupActivity.this,"Please enter valid email address",Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(Mobileno.getText().toString()))
            {
                Toast.makeText(SignupActivity.this, "Please enter your User Name", Toast.LENGTH_SHORT).show();
                return;
            }

            if (Mobileno.getText().toString().length() > 11)
            {
                Toast.makeText(SignupActivity.this, "Incorrect Mobile number", Toast.LENGTH_SHORT).show();
                return;
            }

            if (Password1.getText().toString().length() < 4)
            {
                Toast.makeText(SignupActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!Password1.getText().toString().equals(Password2.getText().toString()))
            {
                Toast pass = Toast.makeText(SignupActivity.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                new AsyncSoapClass().execute();
            }

        }
    }

    public class AsyncSoapClass extends AsyncTask<String, Void, String>
    {
        ProgressDialog pd = new ProgressDialog(SignupActivity.this);

        @Override
        protected void onPreExecute() {
            pd.setMessage("loading");
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {

            SoapClass sc = new SoapClass();
            int  response = sc.SignUp(Name.getText().toString(), Username.getText().toString(), Email.getText().toString(), Mobileno.getText().toString(), Password1.getText().toString());

            if (response == 1)
            {
                Toast.makeText(SignupActivity.this, "Duplicate Email", Toast.LENGTH_SHORT).show();
            }

            if (response == 2)
            {
                Toast.makeText(SignupActivity.this, "Duplicate Mobile No.", Toast.LENGTH_SHORT).show();;
            }

            if (response == 3)
            {
                User u = new User();
                u.setName(Name.getText().toString());
                u.setEmail(Email.getText().toString());
                u.setUname(Username.getText().toString());
                u.setPass(Password1.getText().toString());

                helper.insertUser(u);

                Intent in = new Intent(SignupActivity.this, CategoryActivity.class);
                in.putExtra("email", Email.getText().toString());
                in.putExtra("login_username", Username.getText().toString());
                in.putExtra("imei", imei);
                in.putExtra("address", address);
                startActivity(in);
                finish();
            }

            return "Nothing";
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (pd.isShowing()) {
                pd.dismiss();
            }
        }
    }
}
