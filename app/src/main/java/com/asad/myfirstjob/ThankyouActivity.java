package com.asad.myfirstjob;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ThankyouActivity extends AppCompatActivity {

    TextView login, signup;
    View mProgressView;
    String catId, catDesc;
    List<String> feedbackDescArray = new ArrayList<>();
    List<String> serviceIdFeedbackArray = new ArrayList<>();
    List<String> feedbackRatingArray = new ArrayList<>();
    List<String> serviceIdArray = new ArrayList<>();
    List<String> serviceDescArray = new ArrayList<>();
    List<String> ratingArray = new ArrayList<>();
    List<String> moodArray = new ArrayList<>();
    String userName, email, timing, androidVersion;
    int CVersion;

    SimpleDateFormat dff = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat df = new SimpleDateFormat("hh:mm a");

    String MANUFACTURER = android.os.Build.MANUFACTURER;
    String myDeviceModel = android.os.Build.MODEL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);

        login = findViewById(R.id.login_thanks_txt);
        signup = findViewById(R.id.signup_thanks_txt);
        mProgressView = findViewById(R.id.progress);

        userName = pref.getString("Username", "Empty");
        email = pref.getString("Email", "Empty");

        catId = getIntent().getStringExtra("catId");
        catDesc = getIntent().getStringExtra("catDesc");
        timing = getIntent().getStringExtra("timing");
        feedbackDescArray = getIntent().getStringArrayListExtra("feedbackDescArray");
        serviceIdFeedbackArray = getIntent().getStringArrayListExtra("serviceIdFeedbackArray");
        feedbackRatingArray = getIntent().getStringArrayListExtra("feedbackRatingArray");
        serviceIdArray = getIntent().getStringArrayListExtra("serviceIdArray");
        serviceDescArray = getIntent().getStringArrayListExtra("serviceDescArray");
        ratingArray = getIntent().getStringArrayListExtra("ratingArray");
        moodArray = getIntent().getStringArrayListExtra("moodArray");

        login.setText("Mr. " + userName);

        getAndroidVersion();

        sendMail();

    }

    private void getAndroidVersion(){
        CVersion = android.os.Build.VERSION.SDK_INT;

        switch (CVersion) {

            case 16:
                androidVersion = "Jelly Bean";
                break;

            case 17:
                androidVersion = "Jelly Bean";
                break;

            case 18:
                androidVersion = "Jelly Bean";
                break;

            case 19:
                androidVersion = "KitKat";
                break;

            case 21:
                androidVersion = "Lollipop";
                break;

            case 22:
                androidVersion = "Lollipop";
                break;

            case 23:
                androidVersion = "Marshmallow";
                break;

            case 24:
                androidVersion = "Nougat";
                break;

            case 25:
                androidVersion = "Nougat";
                break;

            case 26:
                androidVersion = "Oreo";
                break;
        }
    }

    protected void sendMail() {
        final String username = "asadali786karachi@gmail.com";
        final String password = "03332338869";

        Calendar c = Calendar.getInstance();
        String formatteddate = dff.format(c.getTime());
        String formattedTime = df.format(c.getTime());

        String mess = "<b><p style=\"font-family: 'Calibri'; font-size: 14px;\">Dear Mr. " + userName + "</p></b>\n" +
                "\n" +
                "<b><p style=\"font-family: 'Calibri'; font-size: 14px;\">" + timing + "</p></b>\n" +
                "\n" +
                "<p style=\"font-family: 'Calibri'; font-size: 12px;\">Thanks to use this application and provide your feedback. We will surely investigate the matter and assure you to improve it in the light of your identified observation related to concern domain.</p>\n" +
                "\n" +
                "<b><p style=\"font-family: 'Calibri'; font-size: 12px; text-align: justify;\">Feedback of " + catDesc + "</p></b>" +
                "<style>\n" +
                "table {\n" +
                "    font-family: 'Calibri';\n" +
                "    font-size: 12px;\n" +
                "    border-collapse: collapse;\n" +
                "}\n" +
                "\n" +
                "td, th {\n" +
                "    border: 1px solid #dddddd;\n" +
                "    text-align: center;\n" +
                "    padding: 8px;\n" +
                "}\n" +
                "\n" +
                "tr:nth-child(even) {\n" +
                "    background-color: #dddddd;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "\n" +
                "<table>\n" +
                "  <tr>\n" +
                "    <th style=\"width: 100px;\">Services</th>\n" +
                "    <th style=\"width: 80px;\">Rating</th>\n" +
                "    <th style=\"width: 300px;\">Feedback</th>\n" +
                "  </tr>\n";

        String temp = "";

        if (feedbackDescArray.isEmpty())
        {
            for (int i = 0; i <= Integer.valueOf(serviceDescArray.size())-1; i++) {
                temp += "  <tr>\n" +
                        "    <td>" + serviceDescArray.get(i) + "</td>\n" +
                        "    <td>" + moodArray.get(i) + "</td>\n" +
                        "    <td>" + " " + "</td>\n" +
                        "  </tr>\n";
            }
        }
        else
        {
            for (int i = 0; i <= Integer.valueOf(serviceDescArray.size())-1; i++) {
                temp += "  <tr>\n" +
                        "    <td>" + serviceDescArray.get(i) + "</td>\n" +
                        "    <td>" + moodArray.get(i) + "</td>\n" +
                        "    <td>" + feedbackDescArray.get(i) + "</td>\n" +
                        "  </tr>\n";
            }
        }

        mess += temp + "</table>\n" +
                "\n<p style=\"font-family: 'Calibri'; font-size: 12px;\">Feedback Date: " + formatteddate + "<br/>Feedback Time: " + formattedTime + "</p>" +
                "\n\n<p style=\"font-family: 'Calibri'; font-size: 12px;\">Feedback sent from: <br/>Manufacturer: " + MANUFACTURER + "<br/>Model: " + myDeviceModel + "<br/>Android Version: " + androidVersion + "</p>" +
                "<p class=\"x_MsoNormal\"><span style=\"font-size: 11pt; font-family: &quot;Calibri&quot;, sans-s &quot;EmojiFont&quot;; color: rgb(31, 73, 125);\\\">&nbsp;</span></p>" +
                "<p class=\"x_MsoNormal\"><span style=\"font-size: 11pt; font-family: &quot;Calibri&quot;, sans-s &quot;EmojiFont&quot;; color: rgb(31, 73, 125);\\\">&nbsp;</span></p>" +
                "<p class=\"x_MsoNormal\"><span style=\"font-size: 11pt; font-family: &quot;Calibri&quot;, sans-s &quot;EmojiFont&quot;; color: rgb(31, 73, 125);\\\">&nbsp;</span></p>" +
                "<p style=\"margin-top: 0px!important;margin-bottom: 0px !important;\"><b><span style=\"font-family:&quot;Calibri&quot;,sans-serif,serif,&quot;EmojiFont&quot;; color:rgb(31,73,125)\">Visual Solutions</span></b></p>" +
                "<p class=\"x_x_MsoNormal\" style=\"margin-top: 0px!important;margin-bottom: 0px !important;\"><b><span style=\"font-size:8pt; font-family:&quot;Calibri&quot;,sans-serif,serif,&quot;EmojiFont&quot;; color:rgb(31,73,125)\">Telephone&nbsp; : +92 213 588 4544 | +92 300 224 5429 | +92 311 104 2419 </span></b></p>" +
                "<p class=\"x_x_MsoNormal\" style=\"margin-top:0px!important; margin-bottom:0px!important\"><b><span style=\"font-size:8pt; font-family:&quot;Calibri&quot;,sans-serif,serif,&quot;EmojiFont&quot;; color:rgb(31,73,125)\">E-mail&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <a href=\"mailto:info@vs-pl.com\" target=\"_blank\" rel=\"noopener noreferrer\"><span style=\"color:blue\">info@vs-pl.com</span></a></span></b></p>" +
                "<p class=\"x_x_MsoNormal\" style=\"margin-top:0px!important; margin-bottom:0px!important\"><b><span style=\"font-size:8pt; font-family:&quot;Calibri&quot;,sans-serif,serif,&quot;EmojiFont&quot;; color:rgb(31,73,125)\">Web&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : <a href=\"http://www.vs-pl.com/\" target=\"_blank\" rel=\"noopener noreferrer\"><span style=\"color:blue\">www.vs-pl.com</span></a></span></b></p>" +
                "<p class=\"x_x_MsoNormal\" style=\"margin-top:0px!important; margin-bottom:0px!important\"><b><span style=\"font-size:8pt; font-family:&quot;Calibri&quot;,sans-serif,serif,&quot;EmojiFont&quot;; color:rgb(31,73,125)\">MF-1, 25-C, 15th Street, Phase II Ext,<br>\n" +
                "D.H.A., Karachi, Pakistan</span></b></p>" +
                "<p class=\"x_MsoNormal\"><span style=\"font-size: 11pt; font-family: &quot;Calibri&quot;, sans-serif, serif, &quot;EmojiFont&quot;; color: rgb(31, 73, 125);\"><img data-imagetype=\"AttachmentByCid\" originalsrc=\"cid:image001.jpg@01D3F511.FE32D630\" data-custom=\"AQMkADAwATY3ZmYAZS1jM2NkLTQ2NzEtMDACLTAwCgBGAAADCNjwVnHqLUCqAeswhQDCOAcA%2FCPQbnEMWkuFuTnnbWK0rwAAAgEMAAAA%2FCPQbnEMWkuFuTnnbWK0rwABlniLkwAAAAESABAAvC9twQ3cV02CCTQ82uevMQ%3D%3D\" naturalheight=\"213\" naturalwidth=\"624\" src=\"https://attachment.outlook.live.net/owa/asad-alii@hotmail.com/service.svc/s/GetFileAttachment?id=AQMkADAwATY3ZmYAZS1jM2NkLTQ2NzEtMDACLTAwCgBGAAADCNjwVnHqLUCqAeswhQDCOAcA%2FCPQbnEMWkuFuTnnbWK0rwAAAgEMAAAA%2FCPQbnEMWkuFuTnnbWK0rwABlniLkwAAAAESABAAvC9twQ3cV02CCTQ82uevMQ%3D%3D&amp;X-OWA-CANARY=1d4aERz47EKwD0Fm6KNg2AC1sugEw9UYXtUugvT60mmp1l3apY8k0HDyguHi9HnwBEn5lmAJrjU.&amp;token=eyJhbGciOiJSUzI1NiIsImtpZCI6IjA2MDBGOUY2NzQ2MjA3MzdFNzM0MDRFMjg3QzQ1QTgxOENCN0NFQjgiLCJ4NXQiOiJCZ0Q1OW5SaUJ6Zm5OQVRpaDhSYWdZeTN6cmciLCJ0eXAiOiJKV1QifQ.eyJ2ZXIiOiJFeGNoYW5nZS5DYWxsYmFjay5WMSIsImFwcGN0eHNlbmRlciI6Ik93YURvd25sb2FkQDg0ZGY5ZTdmLWU5ZjYtNDBhZi1iNDM1LWFhYWFhYWFhYWFhYSIsImFwcGN0eCI6IntcIm1zZXhjaHByb3RcIjpcIm93YVwiLFwicHJpbWFyeXNpZFwiOlwiUy0xLTI4MjctNDI1OTgyLTMyODUwMTAwMzNcIixcInB1aWRcIjpcIjE4Mjk1ODIwNDM2OTQ3MDVcIixcIm9pZFwiOlwiMDAwNjdmZmUtYzNjZC00NjcxLTAwMDAtMDAwMDAwMDAwMDAwXCIsXCJzY29wZVwiOlwiT3dhRG93bmxvYWRcIn0iLCJuYmYiOjE1MjczMzgwMTYsImV4cCI6MTUyNzMzODYxNiwiaXNzIjoiMDAwMDAwMDItMDAwMC0wZmYxLWNlMDAtMDAwMDAwMDAwMDAwQDg0ZGY5ZTdmLWU5ZjYtNDBhZi1iNDM1LWFhYWFhYWFhYWFhYSIsImF1ZCI6IjAwMDAwMDAyLTAwMDAtMGZmMS1jZTAwLTAwMDAwMDAwMDAwMC9hdHRhY2htZW50Lm91dGxvb2subGl2ZS5uZXRAODRkZjllN2YtZTlmNi00MGFmLWI0MzUtYWFhYWFhYWFhYWFhIn0.LV4I00QM2ZV0bzfVpBvwKHWuLhgr59ZdPHNVYJ3XJ5suKZPENUdcQEkIy867Vy8U6jrgkVaUwfB_g5rcc8EdOSS5cpK3ZZbFmXqhUtZkAgpNVHez72e8XzvZamnbWhcuoCl_K4MAZ8RnU4AvtN7qyu45wxP5HyRu-Fwyq9QOt4bvM0XNWc0xQc0IkW2ZaBI4hxa0iPKfTl8inrCt3ReUIr84JtvprEskA73tN_nhkCufyO9j1mvirnrNhBw7Hwpn0F2pCptgdu9kmvNWcFB95smgRLqYrZOI6HAohtv5cCz-9zSeiL2q2sG6LsGtYB9fJP-0iFUV427GnkOBodHvlQ&amp;owa=outlook.live.com&amp;isc=1&amp;isImagePreview=True\" id=\"x_Picture_x0020_2\" alt=\"Email Signatures 5\" style=\"width: 6.5in; height: 2.2187in; cursor: pointer;\" data-downloadimage=\"service.svc/s/GetFileAttachment?id=AQMkADAwATY3ZmYAZS1jM2NkLTQ2NzEtMDACLTAwCgBGAAADCNjwVnHqLUCqAeswhQDCOAcA%2FCPQbnEMWkuFuTnnbWK0rwAAAgEMAAAA%2FCPQbnEMWkuFuTnnbWK0rwABlniLkwAAAAESABAAvC9twQ3cV02CCTQ82uevMQ%3D%3D&amp;X-OWA-CANARY=1d4aERz47EKwD0Fm6KNg2AC1sugEw9UYXtUugvT60mmp1l3apY8k0HDyguHi9HnwBEn5lmAJrjU.\" data-thumbnailimage=\"https://attachment.outlook.live.net/owa/asad-alii@hotmail.com/service.svc/s/GetFileAttachment?id=AQMkADAwATY3ZmYAZS1jM2NkLTQ2NzEtMDACLTAwCgBGAAADCNjwVnHqLUCqAeswhQDCOAcA%2FCPQbnEMWkuFuTnnbWK0rwAAAgEMAAAA%2FCPQbnEMWkuFuTnnbWK0rwABlniLkwAAAAESABAAvC9twQ3cV02CCTQ82uevMQ%3D%3D&amp;X-OWA-CANARY=1d4aERz47EKwD0Fm6KNg2AC1sugEw9UYXtUugvT60mmp1l3apY8k0HDyguHi9HnwBEn5lmAJrjU.&amp;token=eyJhbGciOiJSUzI1NiIsImtpZCI6IjA2MDBGOUY2NzQ2MjA3MzdFNzM0MDRFMjg3QzQ1QTgxOENCN0NFQjgiLCJ4NXQiOiJCZ0Q1OW5SaUJ6Zm5OQVRpaDhSYWdZeTN6cmciLCJ0eXAiOiJKV1QifQ.eyJ2ZXIiOiJFeGNoYW5nZS5DYWxsYmFjay5WMSIsImFwcGN0eHNlbmRlciI6Ik93YURvd25sb2FkQDg0ZGY5ZTdmLWU5ZjYtNDBhZi1iNDM1LWFhYWFhYWFhYWFhYSIsImFwcGN0eCI6IntcIm1zZXhjaHByb3RcIjpcIm93YVwiLFwicHJpbWFyeXNpZFwiOlwiUy0xLTI4MjctNDI1OTgyLTMyODUwMTAwMzNcIixcInB1aWRcIjpcIjE4Mjk1ODIwNDM2OTQ3MDVcIixcIm9pZFwiOlwiMDAwNjdmZmUtYzNjZC00NjcxLTAwMDAtMDAwMDAwMDAwMDAwXCIsXCJzY29wZVwiOlwiT3dhRG93bmxvYWRcIn0iLCJuYmYiOjE1MjczMzgwMTYsImV4cCI6MTUyNzMzODYxNiwiaXNzIjoiMDAwMDAwMDItMDAwMC0wZmYxLWNlMDAtMDAwMDAwMDAwMDAwQDg0ZGY5ZTdmLWU5ZjYtNDBhZi1iNDM1LWFhYWFhYWFhYWFhYSIsImF1ZCI6IjAwMDAwMDAyLTAwMDAtMGZmMS1jZTAwLTAwMDAwMDAwMDAwMC9hdHRhY2htZW50Lm91dGxvb2subGl2ZS5uZXRAODRkZjllN2YtZTlmNi00MGFmLWI0MzUtYWFhYWFhYWFhYWFhIn0.LV4I00QM2ZV0bzfVpBvwKHWuLhgr59ZdPHNVYJ3XJ5suKZPENUdcQEkIy867Vy8U6jrgkVaUwfB_g5rcc8EdOSS5cpK3ZZbFmXqhUtZkAgpNVHez72e8XzvZamnbWhcuoCl_K4MAZ8RnU4AvtN7qyu45wxP5HyRu-Fwyq9QOt4bvM0XNWc0xQc0IkW2ZaBI4hxa0iPKfTl8inrCt3ReUIr84JtvprEskA73tN_nhkCufyO9j1mvirnrNhBw7Hwpn0F2pCptgdu9kmvNWcFB95smgRLqYrZOI6HAohtv5cCz-9zSeiL2q2sG6LsGtYB9fJP-0iFUV427GnkOBodHvlQ&amp;owa=outlook.live.com&amp;isc=1&amp;isImagePreview=True\" crossorigin=\"use-credentials\" width=\"624\" height=\"213\" border=\"0\"></span></p>" +
                "<div class=\\\"x_MsoNormal\\\" style=\\\"text-align:center\\\" align=\\\"center\\\"><span style=\\\"color:#1F497D\\\">" +
                "<hr width=\\\"100%\\\" size=\\\"2\\\" align=\\\"center\\\"></span></div>" +
                "<p class=\\\"x_Mserif, serif,oNormal\"><span style=\"font-size: 7.5pt; font-family: &quot;Arial&quot;, sans-serif, serif, &quot;EmojiFont&quot;; color: teal;\"><br>\n" +
                "</span><span style=\"font-size: 7.5pt; font-family: &quot;Arial&quot;, sans-serif, serif, &quot;EmojiFont&quot;; color: rgb(0, 32, 96);\">This e-mail and any attachments are confidential and intended solely for the addressee and may also be privileged or exempt from disclosure under applicable law. If you are not the addressee, or have received this e-mail in error, please notify the sender immediately, delete it from your system and do not copy, disclose or otherwise act upon any part of this e-mail or its attachments. Any opinion or other information in this e-mail or its attachments that does not relate to the business of VS-PL is personal to the sender and is not given or endorsed by VS-PL. Internet communications are not guaranteed to be secure or virus-free. VS-PL does not accept responsibility for any loss arising from unauthorised access to, or interference with, any Internet communications by any third party, or from the transmission of any viruses. Replies to this e-mail may be monitored by VS-PL for operational or business reasons.</span><span style=\"color:#002060\"></span></p>" +
                "<p class=\"x_MsoNormal\"><span style=\"font-size: 11pt; font-family: &quot;Calibri&quot;, sans-serif, serif, &quot;EmojiFont&quot;; color: rgb(31, 73, 125);\">&nbsp;</span></p>";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            //message.addRecipient(Message.RecipientType.CC, new InternetAddress("info@vs-pl.com"));
            message.setSubject("Feedback of Mr. " + userName);
            message.setContent(mess, "text/html");

            new SendMailTask().execute(message);

        }catch (MessagingException mex) {
            mex.printStackTrace();
        }


    }

    private class SendMailTask extends AsyncTask<Message,String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressView.setVisibility(View.VISIBLE);

        }



        @Override
        protected String doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);
                return "Success";
            }
            catch(SendFailedException ee)
            {
                if(mProgressView.getVisibility() == View.VISIBLE)
                    mProgressView.setVisibility(View.GONE);
                return "error1";
            }catch (MessagingException e) {
                if(mProgressView.getVisibility() == View.VISIBLE)
                    mProgressView.setVisibility(View.GONE);
                return "error2";
            }

        }


        @Override
        protected void onPostExecute(String result) {
            if(result.equals("Success"))
            {

                super.onPostExecute(result);
                mProgressView.setVisibility(View.GONE);

                Toast.makeText(ThankyouActivity.this, "Mail Sent Successfully", Toast.LENGTH_LONG).show();

                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ThankyouActivity.this);
                alertDialogBuilder.setMessage("Do you want to give feedback again?")
                        .setCancelable(true)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent in = new Intent(ThankyouActivity.this, CategoryActivity.class);
                                in.putExtra("login_username", userName);
                                in.putExtra("email", email);
                                startActivity(in);
                                finish();

                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent in = new Intent(ThankyouActivity.this, LoginActivity.class);
                                startActivity(in);
                                finish();
                                CategoryActivity.fa.finish();


                            }
                        });
                AlertDialog alert = alertDialogBuilder.create();
                alert.show();


            }
            else
            if(result.equals("error1"))
                Toast.makeText(ThankyouActivity.this, "Email Failure", Toast.LENGTH_LONG).show();
            else
            if(result.equals("error2"))
                Toast.makeText(ThankyouActivity.this, "Email Sent problem2", Toast.LENGTH_LONG).show();

        }
    }
}
