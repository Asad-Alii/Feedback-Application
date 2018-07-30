package com.asad.myfirstjob;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

import static android.text.TextUtils.isEmpty;

public class FeedbackActivity extends AppCompatActivity {

    String catId, catDesc, timing;
    String serviceId1, serviceId2, serviceId3, serviceId4, serviceId5, serviceId6, serviceId7, serviceId8, serviceId9, serviceId10;
    String serviceId11, serviceId12, serviceId13, serviceId14, serviceId15, serviceId16, serviceId17, serviceId18, serviceId19, serviceId20;
    String serviceDesc1, serviceDesc2, serviceDesc3, serviceDesc4, serviceDesc5, serviceDesc6, serviceDesc7, serviceDesc8, serviceDesc9, serviceDesc10;
    String serviceDesc11, serviceDesc12, serviceDesc13, serviceDesc14, serviceDesc15, serviceDesc16, serviceDesc17, serviceDesc18, serviceDesc19, serviceDesc20;
    String rating1, rating2, rating3, rating4, rating5, rating6, rating7, rating8, rating9, rating10;
    String rating11, rating12, rating13, rating14, rating15, rating16, rating17, rating18, rating19, rating20;
    String mood1, mood2, mood3, mood4, mood5, mood6, mood7, mood8, mood9, mood10, mood;
    String mood11, mood12, mood13, mood14, mood15, mood16, mood17, mood18, mood19, mood20;
    String listSize;
    int feedbackSize;
    List<String> serviceDescArray = new ArrayList<>();
    List<String> serviceIdArray = new ArrayList<>();
    List<String> ratingArray = new ArrayList<>();
    List<String> moodArray = new ArrayList<>();
    LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10;
    LinearLayout linearLayout11, linearLayout12, linearLayout13, linearLayout14, linearLayout15, linearLayout16, linearLayout17, linearLayout18, linearLayout19, linearLayout20;
    TextView feedbackDesc1, feedbackDesc2, feedbackDesc3, feedbackDesc4, feedbackDesc5, feedbackDesc6, feedbackDesc7, feedbackDesc8, feedbackDesc9, feedbackDesc10;
    TextView feedbackDesc11, feedbackDesc12, feedbackDesc13, feedbackDesc14, feedbackDesc15, feedbackDesc16, feedbackDesc17, feedbackDesc18, feedbackDesc19, feedbackDesc20;
    EditText feedbackEditTxt1, feedbackEditTxt2, feedbackEditTxt3, feedbackEditTxt4, feedbackEditTxt5, feedbackEditTxt6, feedbackEditTxt7, feedbackEditTxt8, feedbackEditTxt9, feedbackEditTxt10;
    EditText feedbackEditTxt11, feedbackEditTxt12, feedbackEditTxt13, feedbackEditTxt14, feedbackEditTxt15, feedbackEditTxt16, feedbackEditTxt17, feedbackEditTxt18, feedbackEditTxt19, feedbackEditTxt20;
    List<String> feedbackDescArray = new ArrayList<>();
    List<String> serviceIdFeedbackArray = new ArrayList<>();
    Button feedbackBtn;
    List<String> feedbackRatingArray = new ArrayList<>();
    List<String> testArray = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        controlInit();

        checkSize();

        onSubmitClick();
    }

    public void onSubmitClick(){
        feedbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                feedbackDescArray.clear();

                addInFeedbackArray();

                if (linearLayout1.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt1.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc1.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout2.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt2.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc2.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout3.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt3.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc3.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout4.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt4.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc4.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout5.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt5.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc5.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout6.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt6.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc6.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout7.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt7.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc7.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout8.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt8.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc8.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout9.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt9.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc9.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout10.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt10.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc10.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout11.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt11.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc11.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout12.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt12.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc12.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout13.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt13.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc13.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout14.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt14.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc14.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout15.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt15.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc15.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout16.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt16.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc16.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout17.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt17.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc17.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout18.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt18.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc18.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout19.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt19.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc19.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (linearLayout20.getVisibility() == View.VISIBLE && isEmpty(feedbackEditTxt20.getText().toString()))
                {
                    Toast.makeText(FeedbackActivity.this, "Feedback about " + feedbackDesc20.getText().toString() + " is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                else
                {
                    new AsyncSoapClass().execute();
                    Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
                    in.putExtra("catId", catId);
                    in.putExtra("catDesc", catDesc);
                    in.putExtra("timing", timing);
                    in.putExtra("feedbackSize", String.valueOf(feedbackSize));
                    in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
                    in.putStringArrayListExtra("serviceIdFeedbackArray", (ArrayList<String>) serviceIdFeedbackArray);
                    in.putStringArrayListExtra("feedbackRatingArray", (ArrayList<String>) feedbackRatingArray);

                    in.putStringArrayListExtra("serviceIdArray", (ArrayList<String>) serviceIdArray);
                    in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArray);
                    in.putStringArrayListExtra("ratingArray", (ArrayList<String>) ratingArray);
                    in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
                    startActivity(in);
                    finish();
                }
            }
        });
    }

    public void controlInit() {
        feedbackBtn = findViewById(R.id.feedback_btn);

        linearLayout1 = findViewById(R.id.linearlayout1);
        linearLayout2 = findViewById(R.id.linearlayout2);
        linearLayout3 = findViewById(R.id.linearlayout3);
        linearLayout4 = findViewById(R.id.linearlayout4);
        linearLayout5 = findViewById(R.id.linearlayout5);
        linearLayout6 = findViewById(R.id.linearlayout6);
        linearLayout7 = findViewById(R.id.linearlayout7);
        linearLayout8 = findViewById(R.id.linearlayout8);
        linearLayout9 = findViewById(R.id.linearlayout9);
        linearLayout10 = findViewById(R.id.linearlayout10);
        linearLayout11 = findViewById(R.id.linearlayout11);
        linearLayout12 = findViewById(R.id.linearlayout12);
        linearLayout13 = findViewById(R.id.linearlayout13);
        linearLayout14 = findViewById(R.id.linearlayout14);
        linearLayout15 = findViewById(R.id.linearlayout15);
        linearLayout16 = findViewById(R.id.linearlayout16);
        linearLayout17 = findViewById(R.id.linearlayout17);
        linearLayout18 = findViewById(R.id.linearlayout18);
        linearLayout19 = findViewById(R.id.linearlayout19);
        linearLayout20 = findViewById(R.id.linearlayout20);

        feedbackDesc1 = findViewById(R.id.feedbackDesc1);
        feedbackDesc2 = findViewById(R.id.feedbackDesc2);
        feedbackDesc3 = findViewById(R.id.feedbackDesc3);
        feedbackDesc4 = findViewById(R.id.feedbackDesc4);
        feedbackDesc5 = findViewById(R.id.feedbackDesc5);
        feedbackDesc6 = findViewById(R.id.feedbackDesc6);
        feedbackDesc7 = findViewById(R.id.feedbackDesc7);
        feedbackDesc8 = findViewById(R.id.feedbackDesc8);
        feedbackDesc9 = findViewById(R.id.feedbackDesc9);
        feedbackDesc10 = findViewById(R.id.feedbackDesc10);
        feedbackDesc11 = findViewById(R.id.feedbackDesc11);
        feedbackDesc12 = findViewById(R.id.feedbackDesc12);
        feedbackDesc13 = findViewById(R.id.feedbackDesc13);
        feedbackDesc14 = findViewById(R.id.feedbackDesc14);
        feedbackDesc15 = findViewById(R.id.feedbackDesc15);
        feedbackDesc16 = findViewById(R.id.feedbackDesc16);
        feedbackDesc17 = findViewById(R.id.feedbackDesc17);
        feedbackDesc18 = findViewById(R.id.feedbackDesc18);
        feedbackDesc19 = findViewById(R.id.feedbackDesc19);
        feedbackDesc20 = findViewById(R.id.feedbackDesc20);

        feedbackEditTxt1 = findViewById(R.id.feedbackTxt1);
        feedbackEditTxt2 = findViewById(R.id.feedbackTxt2);
        feedbackEditTxt3 = findViewById(R.id.feedbackTxt3);
        feedbackEditTxt4 = findViewById(R.id.feedbackTxt4);
        feedbackEditTxt5 = findViewById(R.id.feedbackTxt5);
        feedbackEditTxt6 = findViewById(R.id.feedbackTxt6);
        feedbackEditTxt7 = findViewById(R.id.feedbackTxt7);
        feedbackEditTxt8 = findViewById(R.id.feedbackTxt8);
        feedbackEditTxt9 = findViewById(R.id.feedbackTxt9);
        feedbackEditTxt10 = findViewById(R.id.feedbackTxt10);
        feedbackEditTxt11 = findViewById(R.id.feedbackTxt11);
        feedbackEditTxt12 = findViewById(R.id.feedbackTxt12);
        feedbackEditTxt13 = findViewById(R.id.feedbackTxt13);
        feedbackEditTxt14 = findViewById(R.id.feedbackTxt14);
        feedbackEditTxt15 = findViewById(R.id.feedbackTxt15);
        feedbackEditTxt16 = findViewById(R.id.feedbackTxt16);
        feedbackEditTxt17 = findViewById(R.id.feedbackTxt17);
        feedbackEditTxt18 = findViewById(R.id.feedbackTxt18);
        feedbackEditTxt19 = findViewById(R.id.feedbackTxt19);
        feedbackEditTxt20 = findViewById(R.id.feedbackTxt20);

        catId = getIntent().getStringExtra("catId");
        catDesc = getIntent().getStringExtra("catDesc");
        timing = getIntent().getStringExtra("timing");

        serviceId1 = getIntent().getStringExtra("serviceId1");
        serviceId2 = getIntent().getStringExtra("serviceId2");
        serviceId3 = getIntent().getStringExtra("serviceId3");
        serviceId4 = getIntent().getStringExtra("serviceId4");
        serviceId5 = getIntent().getStringExtra("serviceId5");
        serviceId6 = getIntent().getStringExtra("serviceId6");
        serviceId7 = getIntent().getStringExtra("serviceId7");
        serviceId8 = getIntent().getStringExtra("serviceId8");
        serviceId9 = getIntent().getStringExtra("serviceId9");
        serviceId10 = getIntent().getStringExtra("serviceId10");
        serviceId11 = getIntent().getStringExtra("serviceId11");
        serviceId12 = getIntent().getStringExtra("serviceId12");
        serviceId13 = getIntent().getStringExtra("serviceId13");
        serviceId14 = getIntent().getStringExtra("serviceId14");
        serviceId15 = getIntent().getStringExtra("serviceId15");
        serviceId16 = getIntent().getStringExtra("serviceId16");
        serviceId17 = getIntent().getStringExtra("serviceId17");
        serviceId18 = getIntent().getStringExtra("serviceId18");
        serviceId19 = getIntent().getStringExtra("serviceId19");
        serviceId20 = getIntent().getStringExtra("serviceId20");

        serviceDesc1 = getIntent().getStringExtra("serviceDesc1");
        serviceDesc2 = getIntent().getStringExtra("serviceDesc2");
        serviceDesc3 = getIntent().getStringExtra("serviceDesc3");
        serviceDesc4 = getIntent().getStringExtra("serviceDesc4");
        serviceDesc5 = getIntent().getStringExtra("serviceDesc5");
        serviceDesc6 = getIntent().getStringExtra("serviceDesc6");
        serviceDesc7 = getIntent().getStringExtra("serviceDesc7");
        serviceDesc8 = getIntent().getStringExtra("serviceDesc8");
        serviceDesc9 = getIntent().getStringExtra("serviceDesc9");
        serviceDesc10 = getIntent().getStringExtra("serviceDesc10");
        serviceDesc11 = getIntent().getStringExtra("serviceDesc11");
        serviceDesc12 = getIntent().getStringExtra("serviceDesc12");
        serviceDesc13 = getIntent().getStringExtra("serviceDesc13");
        serviceDesc14 = getIntent().getStringExtra("serviceDesc14");
        serviceDesc15 = getIntent().getStringExtra("serviceDesc15");
        serviceDesc16 = getIntent().getStringExtra("serviceDesc16");
        serviceDesc17 = getIntent().getStringExtra("serviceDesc17");
        serviceDesc18 = getIntent().getStringExtra("serviceDesc18");
        serviceDesc19 = getIntent().getStringExtra("serviceDesc19");
        serviceDesc20 = getIntent().getStringExtra("serviceDesc20");

        rating1 = getIntent().getStringExtra("rating1");
        rating2 = getIntent().getStringExtra("rating2");
        rating3 = getIntent().getStringExtra("rating3");
        rating4 = getIntent().getStringExtra("rating4");
        rating5 = getIntent().getStringExtra("rating5");
        rating6 = getIntent().getStringExtra("rating6");
        rating7 = getIntent().getStringExtra("rating7");
        rating8 = getIntent().getStringExtra("rating8");
        rating9 = getIntent().getStringExtra("rating9");
        rating10 = getIntent().getStringExtra("rating10");
        rating11 = getIntent().getStringExtra("rating11");
        rating12 = getIntent().getStringExtra("rating12");
        rating13 = getIntent().getStringExtra("rating13");
        rating14 = getIntent().getStringExtra("rating14");
        rating15 = getIntent().getStringExtra("rating15");
        rating16 = getIntent().getStringExtra("rating16");
        rating17 = getIntent().getStringExtra("rating17");
        rating18 = getIntent().getStringExtra("rating18");
        rating19 = getIntent().getStringExtra("rating19");
        rating20 = getIntent().getStringExtra("rating20");

        mood1 = getIntent().getStringExtra("mood1");
        mood2 = getIntent().getStringExtra("mood2");
        mood3 = getIntent().getStringExtra("mood3");
        mood4 = getIntent().getStringExtra("mood4");
        mood5 = getIntent().getStringExtra("mood5");
        mood6 = getIntent().getStringExtra("mood6");
        mood7 = getIntent().getStringExtra("mood7");
        mood8 = getIntent().getStringExtra("mood8");
        mood9 = getIntent().getStringExtra("mood9");
        mood10 = getIntent().getStringExtra("mood10");
        mood11 = getIntent().getStringExtra("mood11");
        mood12 = getIntent().getStringExtra("mood12");
        mood13 = getIntent().getStringExtra("mood13");
        mood14 = getIntent().getStringExtra("mood14");
        mood15 = getIntent().getStringExtra("mood15");
        mood16 = getIntent().getStringExtra("mood16");
        mood17 = getIntent().getStringExtra("mood17");
        mood18 = getIntent().getStringExtra("mood18");
        mood19 = getIntent().getStringExtra("mood19");
        mood20 = getIntent().getStringExtra("mood20");

        listSize = getIntent().getStringExtra("serviceSize");
    }

    public void checkSize() {
        if (Integer.valueOf(listSize) == 1) {
            addInArrayOfSize1();
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }
        }

        if (Integer.valueOf(listSize) == 2) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }
            addInArrayOfSize2();
        }

        if (Integer.valueOf(listSize) == 3) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }
            addInArrayOfSize3();
        }

        if (Integer.valueOf(listSize) == 4) {

            addInArrayOfSize4();
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }

            if (Integer.valueOf(rating4) == 1 || Integer.valueOf(rating4) == 2) {
                linearLayout4.setVisibility(View.VISIBLE);
                feedbackDesc4.setText(serviceDesc4);
            }

        }

        if (Integer.valueOf(listSize) == 5) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }

            if (Integer.valueOf(rating4) == 1 || Integer.valueOf(rating4) == 2) {
                linearLayout4.setVisibility(View.VISIBLE);
                feedbackDesc4.setText(serviceDesc4);
            }

            if (Integer.valueOf(rating5) == 1 || Integer.valueOf(rating5) == 2) {
                linearLayout5.setVisibility(View.VISIBLE);
                feedbackDesc5.setText(serviceDesc5);
            }
            addInArrayOfSize5();
        }

        if (Integer.valueOf(listSize) == 6) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }

            if (Integer.valueOf(rating4) == 1 || Integer.valueOf(rating4) == 2) {
                linearLayout4.setVisibility(View.VISIBLE);
                feedbackDesc4.setText(serviceDesc4);
            }

            if (Integer.valueOf(rating5) == 1 || Integer.valueOf(rating5) == 2) {
                linearLayout5.setVisibility(View.VISIBLE);
                feedbackDesc5.setText(serviceDesc5);
            }

            if (Integer.valueOf(rating6) == 1 || Integer.valueOf(rating6) == 2) {
                linearLayout6.setVisibility(View.VISIBLE);
                feedbackDesc6.setText(serviceDesc6);
            }
            addInArrayOfSize6();
        }

        if (Integer.valueOf(listSize) == 7) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }

            if (Integer.valueOf(rating4) == 1 || Integer.valueOf(rating4) == 2) {
                linearLayout4.setVisibility(View.VISIBLE);
                feedbackDesc4.setText(serviceDesc4);
            }

            if (Integer.valueOf(rating5) == 1 || Integer.valueOf(rating5) == 2) {
                linearLayout5.setVisibility(View.VISIBLE);
                feedbackDesc5.setText(serviceDesc5);
            }

            if (Integer.valueOf(rating6) == 1 || Integer.valueOf(rating6) == 2) {
                linearLayout6.setVisibility(View.VISIBLE);
                feedbackDesc6.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating7) == 1 || Integer.valueOf(rating7) == 2) {
                linearLayout7.setVisibility(View.VISIBLE);
                feedbackDesc7.setText(serviceDesc6);
            }
            addInArrayOfSize7();
        }

        if (Integer.valueOf(listSize) == 8) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }

            if (Integer.valueOf(rating4) == 1 || Integer.valueOf(rating4) == 2) {
                linearLayout4.setVisibility(View.VISIBLE);
                feedbackDesc4.setText(serviceDesc4);
            }

            if (Integer.valueOf(rating5) == 1 || Integer.valueOf(rating5) == 2) {
                linearLayout5.setVisibility(View.VISIBLE);
                feedbackDesc5.setText(serviceDesc5);
            }

            if (Integer.valueOf(rating6) == 1 || Integer.valueOf(rating6) == 2) {
                linearLayout6.setVisibility(View.VISIBLE);
                feedbackDesc6.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating7) == 1 || Integer.valueOf(rating7) == 2) {
                linearLayout7.setVisibility(View.VISIBLE);
                feedbackDesc7.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating8) == 1 || Integer.valueOf(rating8) == 2) {
                linearLayout8.setVisibility(View.VISIBLE);
                feedbackDesc8.setText(serviceDesc6);
            }
            addInArrayOfSize8();
        }

        if (Integer.valueOf(listSize) == 9) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }

            if (Integer.valueOf(rating4) == 1 || Integer.valueOf(rating4) == 2) {
                linearLayout4.setVisibility(View.VISIBLE);
                feedbackDesc4.setText(serviceDesc4);
            }

            if (Integer.valueOf(rating5) == 1 || Integer.valueOf(rating5) == 2) {
                linearLayout5.setVisibility(View.VISIBLE);
                feedbackDesc5.setText(serviceDesc5);
            }

            if (Integer.valueOf(rating6) == 1 || Integer.valueOf(rating6) == 2) {
                linearLayout6.setVisibility(View.VISIBLE);
                feedbackDesc6.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating7) == 1 || Integer.valueOf(rating7) == 2) {
                linearLayout7.setVisibility(View.VISIBLE);
                feedbackDesc7.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating8) == 1 || Integer.valueOf(rating8) == 2) {
                linearLayout8.setVisibility(View.VISIBLE);
                feedbackDesc8.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating9) == 1 || Integer.valueOf(rating9) == 2) {
                linearLayout9.setVisibility(View.VISIBLE);
                feedbackDesc9.setText(serviceDesc6);
            }
            addInArrayOfSize9();
        }

        if (Integer.valueOf(listSize) == 10) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }

            if (Integer.valueOf(rating4) == 1 || Integer.valueOf(rating4) == 2) {
                linearLayout4.setVisibility(View.VISIBLE);
                feedbackDesc4.setText(serviceDesc4);
            }

            if (Integer.valueOf(rating5) == 1 || Integer.valueOf(rating5) == 2) {
                linearLayout5.setVisibility(View.VISIBLE);
                feedbackDesc5.setText(serviceDesc5);
            }

            if (Integer.valueOf(rating6) == 1 || Integer.valueOf(rating6) == 2) {
                linearLayout6.setVisibility(View.VISIBLE);
                feedbackDesc6.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating7) == 1 || Integer.valueOf(rating7) == 2) {
                linearLayout7.setVisibility(View.VISIBLE);
                feedbackDesc7.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating8) == 1 || Integer.valueOf(rating8) == 2) {
                linearLayout8.setVisibility(View.VISIBLE);
                feedbackDesc8.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating9) == 1 || Integer.valueOf(rating9) == 2) {
                linearLayout9.setVisibility(View.VISIBLE);
                feedbackDesc9.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating10) == 1 || Integer.valueOf(rating10) == 2) {
                linearLayout10.setVisibility(View.VISIBLE);
                feedbackDesc10.setText(serviceDesc6);
            }
            addInArrayOfSize10();
        }

        if (Integer.valueOf(listSize) == 11) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }

            if (Integer.valueOf(rating4) == 1 || Integer.valueOf(rating4) == 2) {
                linearLayout4.setVisibility(View.VISIBLE);
                feedbackDesc4.setText(serviceDesc4);
            }

            if (Integer.valueOf(rating5) == 1 || Integer.valueOf(rating5) == 2) {
                linearLayout5.setVisibility(View.VISIBLE);
                feedbackDesc5.setText(serviceDesc5);
            }

            if (Integer.valueOf(rating6) == 1 || Integer.valueOf(rating6) == 2) {
                linearLayout6.setVisibility(View.VISIBLE);
                feedbackDesc6.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating7) == 1 || Integer.valueOf(rating7) == 2) {
                linearLayout7.setVisibility(View.VISIBLE);
                feedbackDesc7.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating8) == 1 || Integer.valueOf(rating8) == 2) {
                linearLayout8.setVisibility(View.VISIBLE);
                feedbackDesc8.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating9) == 1 || Integer.valueOf(rating9) == 2) {
                linearLayout9.setVisibility(View.VISIBLE);
                feedbackDesc9.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating10) == 1 || Integer.valueOf(rating10) == 2) {
                linearLayout10.setVisibility(View.VISIBLE);
                feedbackDesc10.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating11) == 1 || Integer.valueOf(rating11) == 2) {
                linearLayout11.setVisibility(View.VISIBLE);
                feedbackDesc11.setText(serviceDesc6);
            }
            addInArrayOfSize11();
        }

        if (Integer.valueOf(listSize) == 12) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }

            if (Integer.valueOf(rating4) == 1 || Integer.valueOf(rating4) == 2) {
                linearLayout4.setVisibility(View.VISIBLE);
                feedbackDesc4.setText(serviceDesc4);
            }

            if (Integer.valueOf(rating5) == 1 || Integer.valueOf(rating5) == 2) {
                linearLayout5.setVisibility(View.VISIBLE);
                feedbackDesc5.setText(serviceDesc5);
            }

            if (Integer.valueOf(rating6) == 1 || Integer.valueOf(rating6) == 2) {
                linearLayout6.setVisibility(View.VISIBLE);
                feedbackDesc6.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating7) == 1 || Integer.valueOf(rating7) == 2) {
                linearLayout7.setVisibility(View.VISIBLE);
                feedbackDesc7.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating8) == 1 || Integer.valueOf(rating8) == 2) {
                linearLayout8.setVisibility(View.VISIBLE);
                feedbackDesc8.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating9) == 1 || Integer.valueOf(rating9) == 2) {
                linearLayout9.setVisibility(View.VISIBLE);
                feedbackDesc9.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating10) == 1 || Integer.valueOf(rating10) == 2) {
                linearLayout10.setVisibility(View.VISIBLE);
                feedbackDesc10.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating11) == 1 || Integer.valueOf(rating11) == 2) {
                linearLayout11.setVisibility(View.VISIBLE);
                feedbackDesc11.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating12) == 1 || Integer.valueOf(rating12) == 2) {
                linearLayout12.setVisibility(View.VISIBLE);
                feedbackDesc12.setText(serviceDesc6);
            }
            addInArrayOfSize12();
        }

        if (Integer.valueOf(listSize) == 13) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }

            if (Integer.valueOf(rating4) == 1 || Integer.valueOf(rating4) == 2) {
                linearLayout4.setVisibility(View.VISIBLE);
                feedbackDesc4.setText(serviceDesc4);
            }

            if (Integer.valueOf(rating5) == 1 || Integer.valueOf(rating5) == 2) {
                linearLayout5.setVisibility(View.VISIBLE);
                feedbackDesc5.setText(serviceDesc5);
            }

            if (Integer.valueOf(rating6) == 1 || Integer.valueOf(rating6) == 2) {
                linearLayout6.setVisibility(View.VISIBLE);
                feedbackDesc6.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating7) == 1 || Integer.valueOf(rating7) == 2) {
                linearLayout7.setVisibility(View.VISIBLE);
                feedbackDesc7.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating8) == 1 || Integer.valueOf(rating8) == 2) {
                linearLayout8.setVisibility(View.VISIBLE);
                feedbackDesc8.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating9) == 1 || Integer.valueOf(rating9) == 2) {
                linearLayout9.setVisibility(View.VISIBLE);
                feedbackDesc9.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating10) == 1 || Integer.valueOf(rating10) == 2) {
                linearLayout10.setVisibility(View.VISIBLE);
                feedbackDesc10.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating11) == 1 || Integer.valueOf(rating11) == 2) {
                linearLayout11.setVisibility(View.VISIBLE);
                feedbackDesc11.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating12) == 1 || Integer.valueOf(rating12) == 2) {
                linearLayout12.setVisibility(View.VISIBLE);
                feedbackDesc12.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating13) == 1 || Integer.valueOf(rating13) == 2) {
                linearLayout13.setVisibility(View.VISIBLE);
                feedbackDesc13.setText(serviceDesc6);
            }
            addInArrayOfSize13();
        }

        if (Integer.valueOf(listSize) == 14) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }

            if (Integer.valueOf(rating4) == 1 || Integer.valueOf(rating4) == 2) {
                linearLayout4.setVisibility(View.VISIBLE);
                feedbackDesc4.setText(serviceDesc4);
            }

            if (Integer.valueOf(rating5) == 1 || Integer.valueOf(rating5) == 2) {
                linearLayout5.setVisibility(View.VISIBLE);
                feedbackDesc5.setText(serviceDesc5);
            }

            if (Integer.valueOf(rating6) == 1 || Integer.valueOf(rating6) == 2) {
                linearLayout6.setVisibility(View.VISIBLE);
                feedbackDesc6.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating7) == 1 || Integer.valueOf(rating7) == 2) {
                linearLayout7.setVisibility(View.VISIBLE);
                feedbackDesc7.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating8) == 1 || Integer.valueOf(rating8) == 2) {
                linearLayout8.setVisibility(View.VISIBLE);
                feedbackDesc8.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating9) == 1 || Integer.valueOf(rating9) == 2) {
                linearLayout9.setVisibility(View.VISIBLE);
                feedbackDesc9.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating10) == 1 || Integer.valueOf(rating10) == 2) {
                linearLayout10.setVisibility(View.VISIBLE);
                feedbackDesc10.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating11) == 1 || Integer.valueOf(rating11) == 2) {
                linearLayout11.setVisibility(View.VISIBLE);
                feedbackDesc11.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating12) == 1 || Integer.valueOf(rating12) == 2) {
                linearLayout12.setVisibility(View.VISIBLE);
                feedbackDesc12.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating13) == 1 || Integer.valueOf(rating13) == 2) {
                linearLayout13.setVisibility(View.VISIBLE);
                feedbackDesc13.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating14) == 1 || Integer.valueOf(rating14) == 2) {
                linearLayout14.setVisibility(View.VISIBLE);
                feedbackDesc14.setText(serviceDesc6);
            }
            addInArrayOfSize14();
        }

        if (Integer.valueOf(listSize) == 15) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }

            if (Integer.valueOf(rating4) == 1 || Integer.valueOf(rating4) == 2) {
                linearLayout4.setVisibility(View.VISIBLE);
                feedbackDesc4.setText(serviceDesc4);
            }

            if (Integer.valueOf(rating5) == 1 || Integer.valueOf(rating5) == 2) {
                linearLayout5.setVisibility(View.VISIBLE);
                feedbackDesc5.setText(serviceDesc5);
            }

            if (Integer.valueOf(rating6) == 1 || Integer.valueOf(rating6) == 2) {
                linearLayout6.setVisibility(View.VISIBLE);
                feedbackDesc6.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating7) == 1 || Integer.valueOf(rating7) == 2) {
                linearLayout7.setVisibility(View.VISIBLE);
                feedbackDesc7.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating8) == 1 || Integer.valueOf(rating8) == 2) {
                linearLayout8.setVisibility(View.VISIBLE);
                feedbackDesc8.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating9) == 1 || Integer.valueOf(rating9) == 2) {
                linearLayout9.setVisibility(View.VISIBLE);
                feedbackDesc9.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating10) == 1 || Integer.valueOf(rating10) == 2) {
                linearLayout10.setVisibility(View.VISIBLE);
                feedbackDesc10.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating11) == 1 || Integer.valueOf(rating11) == 2) {
                linearLayout11.setVisibility(View.VISIBLE);
                feedbackDesc11.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating12) == 1 || Integer.valueOf(rating12) == 2) {
                linearLayout12.setVisibility(View.VISIBLE);
                feedbackDesc12.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating13) == 1 || Integer.valueOf(rating13) == 2) {
                linearLayout13.setVisibility(View.VISIBLE);
                feedbackDesc13.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating14) == 1 || Integer.valueOf(rating14) == 2) {
                linearLayout14.setVisibility(View.VISIBLE);
                feedbackDesc14.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating15) == 1 || Integer.valueOf(rating15) == 2) {
                linearLayout15.setVisibility(View.VISIBLE);
                feedbackDesc15.setText(serviceDesc6);
            }
            addInArrayOfSize15();
        }

        if (Integer.valueOf(listSize) == 16) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }

            if (Integer.valueOf(rating4) == 1 || Integer.valueOf(rating4) == 2) {
                linearLayout4.setVisibility(View.VISIBLE);
                feedbackDesc4.setText(serviceDesc4);
            }

            if (Integer.valueOf(rating5) == 1 || Integer.valueOf(rating5) == 2) {
                linearLayout5.setVisibility(View.VISIBLE);
                feedbackDesc5.setText(serviceDesc5);
            }

            if (Integer.valueOf(rating6) == 1 || Integer.valueOf(rating6) == 2) {
                linearLayout6.setVisibility(View.VISIBLE);
                feedbackDesc6.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating7) == 1 || Integer.valueOf(rating7) == 2) {
                linearLayout7.setVisibility(View.VISIBLE);
                feedbackDesc7.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating8) == 1 || Integer.valueOf(rating8) == 2) {
                linearLayout8.setVisibility(View.VISIBLE);
                feedbackDesc8.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating9) == 1 || Integer.valueOf(rating9) == 2) {
                linearLayout9.setVisibility(View.VISIBLE);
                feedbackDesc9.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating10) == 1 || Integer.valueOf(rating10) == 2) {
                linearLayout10.setVisibility(View.VISIBLE);
                feedbackDesc10.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating11) == 1 || Integer.valueOf(rating11) == 2) {
                linearLayout11.setVisibility(View.VISIBLE);
                feedbackDesc11.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating12) == 1 || Integer.valueOf(rating12) == 2) {
                linearLayout12.setVisibility(View.VISIBLE);
                feedbackDesc12.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating13) == 1 || Integer.valueOf(rating13) == 2) {
                linearLayout13.setVisibility(View.VISIBLE);
                feedbackDesc13.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating14) == 1 || Integer.valueOf(rating14) == 2) {
                linearLayout14.setVisibility(View.VISIBLE);
                feedbackDesc14.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating15) == 1 || Integer.valueOf(rating15) == 2) {
                linearLayout15.setVisibility(View.VISIBLE);
                feedbackDesc15.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating16) == 1 || Integer.valueOf(rating16) == 2) {
                linearLayout16.setVisibility(View.VISIBLE);
                feedbackDesc16.setText(serviceDesc6);
            }
            addInArrayOfSize16();
        }

        if (Integer.valueOf(listSize) == 17) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }

            if (Integer.valueOf(rating4) == 1 || Integer.valueOf(rating4) == 2) {
                linearLayout4.setVisibility(View.VISIBLE);
                feedbackDesc4.setText(serviceDesc4);
            }

            if (Integer.valueOf(rating5) == 1 || Integer.valueOf(rating5) == 2) {
                linearLayout5.setVisibility(View.VISIBLE);
                feedbackDesc5.setText(serviceDesc5);
            }

            if (Integer.valueOf(rating6) == 1 || Integer.valueOf(rating6) == 2) {
                linearLayout6.setVisibility(View.VISIBLE);
                feedbackDesc6.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating7) == 1 || Integer.valueOf(rating7) == 2) {
                linearLayout7.setVisibility(View.VISIBLE);
                feedbackDesc7.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating8) == 1 || Integer.valueOf(rating8) == 2) {
                linearLayout8.setVisibility(View.VISIBLE);
                feedbackDesc8.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating9) == 1 || Integer.valueOf(rating9) == 2) {
                linearLayout9.setVisibility(View.VISIBLE);
                feedbackDesc9.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating10) == 1 || Integer.valueOf(rating10) == 2) {
                linearLayout10.setVisibility(View.VISIBLE);
                feedbackDesc10.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating11) == 1 || Integer.valueOf(rating11) == 2) {
                linearLayout11.setVisibility(View.VISIBLE);
                feedbackDesc11.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating12) == 1 || Integer.valueOf(rating12) == 2) {
                linearLayout12.setVisibility(View.VISIBLE);
                feedbackDesc12.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating13) == 1 || Integer.valueOf(rating13) == 2) {
                linearLayout13.setVisibility(View.VISIBLE);
                feedbackDesc13.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating14) == 1 || Integer.valueOf(rating14) == 2) {
                linearLayout14.setVisibility(View.VISIBLE);
                feedbackDesc14.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating15) == 1 || Integer.valueOf(rating15) == 2) {
                linearLayout15.setVisibility(View.VISIBLE);
                feedbackDesc15.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating16) == 1 || Integer.valueOf(rating16) == 2) {
                linearLayout16.setVisibility(View.VISIBLE);
                feedbackDesc16.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating17) == 1 || Integer.valueOf(rating17) == 2) {
                linearLayout17.setVisibility(View.VISIBLE);
                feedbackDesc17.setText(serviceDesc6);
            }
            addInArrayOfSize17();
        }

        if (Integer.valueOf(listSize) == 18) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }

            if (Integer.valueOf(rating4) == 1 || Integer.valueOf(rating4) == 2) {
                linearLayout4.setVisibility(View.VISIBLE);
                feedbackDesc4.setText(serviceDesc4);
            }

            if (Integer.valueOf(rating5) == 1 || Integer.valueOf(rating5) == 2) {
                linearLayout5.setVisibility(View.VISIBLE);
                feedbackDesc5.setText(serviceDesc5);
            }

            if (Integer.valueOf(rating6) == 1 || Integer.valueOf(rating6) == 2) {
                linearLayout6.setVisibility(View.VISIBLE);
                feedbackDesc6.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating7) == 1 || Integer.valueOf(rating7) == 2) {
                linearLayout7.setVisibility(View.VISIBLE);
                feedbackDesc7.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating8) == 1 || Integer.valueOf(rating8) == 2) {
                linearLayout8.setVisibility(View.VISIBLE);
                feedbackDesc8.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating9) == 1 || Integer.valueOf(rating9) == 2) {
                linearLayout9.setVisibility(View.VISIBLE);
                feedbackDesc9.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating10) == 1 || Integer.valueOf(rating10) == 2) {
                linearLayout10.setVisibility(View.VISIBLE);
                feedbackDesc10.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating11) == 1 || Integer.valueOf(rating11) == 2) {
                linearLayout11.setVisibility(View.VISIBLE);
                feedbackDesc11.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating12) == 1 || Integer.valueOf(rating12) == 2) {
                linearLayout12.setVisibility(View.VISIBLE);
                feedbackDesc12.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating13) == 1 || Integer.valueOf(rating13) == 2) {
                linearLayout13.setVisibility(View.VISIBLE);
                feedbackDesc13.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating14) == 1 || Integer.valueOf(rating14) == 2) {
                linearLayout14.setVisibility(View.VISIBLE);
                feedbackDesc14.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating15) == 1 || Integer.valueOf(rating15) == 2) {
                linearLayout15.setVisibility(View.VISIBLE);
                feedbackDesc15.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating16) == 1 || Integer.valueOf(rating16) == 2) {
                linearLayout16.setVisibility(View.VISIBLE);
                feedbackDesc16.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating17) == 1 || Integer.valueOf(rating17) == 2) {
                linearLayout17.setVisibility(View.VISIBLE);
                feedbackDesc17.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating18) == 1 || Integer.valueOf(rating18) == 2) {
                linearLayout18.setVisibility(View.VISIBLE);
                feedbackDesc18.setText(serviceDesc6);
            }
            addInArrayOfSize18();
        }

        if (Integer.valueOf(listSize) == 19) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }

            if (Integer.valueOf(rating4) == 1 || Integer.valueOf(rating4) == 2) {
                linearLayout4.setVisibility(View.VISIBLE);
                feedbackDesc4.setText(serviceDesc4);
            }

            if (Integer.valueOf(rating5) == 1 || Integer.valueOf(rating5) == 2) {
                linearLayout5.setVisibility(View.VISIBLE);
                feedbackDesc5.setText(serviceDesc5);
            }

            if (Integer.valueOf(rating6) == 1 || Integer.valueOf(rating6) == 2) {
                linearLayout6.setVisibility(View.VISIBLE);
                feedbackDesc6.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating7) == 1 || Integer.valueOf(rating7) == 2) {
                linearLayout7.setVisibility(View.VISIBLE);
                feedbackDesc7.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating8) == 1 || Integer.valueOf(rating8) == 2) {
                linearLayout8.setVisibility(View.VISIBLE);
                feedbackDesc8.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating9) == 1 || Integer.valueOf(rating9) == 2) {
                linearLayout9.setVisibility(View.VISIBLE);
                feedbackDesc9.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating10) == 1 || Integer.valueOf(rating10) == 2) {
                linearLayout10.setVisibility(View.VISIBLE);
                feedbackDesc10.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating11) == 1 || Integer.valueOf(rating11) == 2) {
                linearLayout11.setVisibility(View.VISIBLE);
                feedbackDesc11.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating12) == 1 || Integer.valueOf(rating12) == 2) {
                linearLayout12.setVisibility(View.VISIBLE);
                feedbackDesc12.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating13) == 1 || Integer.valueOf(rating13) == 2) {
                linearLayout13.setVisibility(View.VISIBLE);
                feedbackDesc13.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating14) == 1 || Integer.valueOf(rating14) == 2) {
                linearLayout14.setVisibility(View.VISIBLE);
                feedbackDesc14.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating15) == 1 || Integer.valueOf(rating15) == 2) {
                linearLayout15.setVisibility(View.VISIBLE);
                feedbackDesc15.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating16) == 1 || Integer.valueOf(rating16) == 2) {
                linearLayout16.setVisibility(View.VISIBLE);
                feedbackDesc16.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating17) == 1 || Integer.valueOf(rating17) == 2) {
                linearLayout17.setVisibility(View.VISIBLE);
                feedbackDesc17.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating18) == 1 || Integer.valueOf(rating18) == 2) {
                linearLayout18.setVisibility(View.VISIBLE);
                feedbackDesc18.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating19) == 1 || Integer.valueOf(rating19) == 2) {
                linearLayout19.setVisibility(View.VISIBLE);
                feedbackDesc19.setText(serviceDesc6);
            }
            addInArrayOfSize19();
        }

        if (Integer.valueOf(listSize) == 20) {
            if (Integer.valueOf(rating1) == 1 || Integer.valueOf(rating1) == 2) {
                linearLayout1.setVisibility(View.VISIBLE);
                feedbackDesc1.setText(serviceDesc1);
            }

            if (Integer.valueOf(rating2) == 1 || Integer.valueOf(rating2) == 2) {
                linearLayout2.setVisibility(View.VISIBLE);
                feedbackDesc2.setText(serviceDesc2);
            }

            if (Integer.valueOf(rating3) == 1 || Integer.valueOf(rating3) == 2) {
                linearLayout3.setVisibility(View.VISIBLE);
                feedbackDesc3.setText(serviceDesc3);
            }

            if (Integer.valueOf(rating4) == 1 || Integer.valueOf(rating4) == 2) {
                linearLayout4.setVisibility(View.VISIBLE);
                feedbackDesc4.setText(serviceDesc4);
            }

            if (Integer.valueOf(rating5) == 1 || Integer.valueOf(rating5) == 2) {
                linearLayout5.setVisibility(View.VISIBLE);
                feedbackDesc5.setText(serviceDesc5);
            }

            if (Integer.valueOf(rating6) == 1 || Integer.valueOf(rating6) == 2) {
                linearLayout6.setVisibility(View.VISIBLE);
                feedbackDesc6.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating7) == 1 || Integer.valueOf(rating7) == 2) {
                linearLayout7.setVisibility(View.VISIBLE);
                feedbackDesc7.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating8) == 1 || Integer.valueOf(rating8) == 2) {
                linearLayout8.setVisibility(View.VISIBLE);
                feedbackDesc8.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating9) == 1 || Integer.valueOf(rating9) == 2) {
                linearLayout9.setVisibility(View.VISIBLE);
                feedbackDesc9.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating10) == 1 || Integer.valueOf(rating10) == 2) {
                linearLayout10.setVisibility(View.VISIBLE);
                feedbackDesc10.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating11) == 1 || Integer.valueOf(rating11) == 2) {
                linearLayout11.setVisibility(View.VISIBLE);
                feedbackDesc11.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating12) == 1 || Integer.valueOf(rating12) == 2) {
                linearLayout12.setVisibility(View.VISIBLE);
                feedbackDesc12.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating13) == 1 || Integer.valueOf(rating13) == 2) {
                linearLayout13.setVisibility(View.VISIBLE);
                feedbackDesc13.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating14) == 1 || Integer.valueOf(rating14) == 2) {
                linearLayout14.setVisibility(View.VISIBLE);
                feedbackDesc14.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating15) == 1 || Integer.valueOf(rating15) == 2) {
                linearLayout15.setVisibility(View.VISIBLE);
                feedbackDesc15.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating16) == 1 || Integer.valueOf(rating16) == 2) {
                linearLayout16.setVisibility(View.VISIBLE);
                feedbackDesc16.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating17) == 1 || Integer.valueOf(rating17) == 2) {
                linearLayout17.setVisibility(View.VISIBLE);
                feedbackDesc17.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating18) == 1 || Integer.valueOf(rating18) == 2) {
                linearLayout18.setVisibility(View.VISIBLE);
                feedbackDesc18.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating19) == 1 || Integer.valueOf(rating19) == 2) {
                linearLayout19.setVisibility(View.VISIBLE);
                feedbackDesc19.setText(serviceDesc6);
            }

            if (Integer.valueOf(rating20) == 1 || Integer.valueOf(rating20) == 2) {
                linearLayout20.setVisibility(View.VISIBLE);
                feedbackDesc20.setText(serviceDesc6);
            }
            addInArrayOfSize20();
        }
    }

    public void addInFeedbackArray(){
        feedbackDescArray.add(feedbackEditTxt1.getText().toString());
        feedbackDescArray.add(feedbackEditTxt2.getText().toString());
        feedbackDescArray.add(feedbackEditTxt3.getText().toString());
        feedbackDescArray.add(feedbackEditTxt4.getText().toString());
        feedbackDescArray.add(feedbackEditTxt5.getText().toString());
        feedbackDescArray.add(feedbackEditTxt6.getText().toString());
        feedbackDescArray.add(feedbackEditTxt7.getText().toString());
        feedbackDescArray.add(feedbackEditTxt8.getText().toString());
        feedbackDescArray.add(feedbackEditTxt9.getText().toString());
        feedbackDescArray.add(feedbackEditTxt10.getText().toString());
        feedbackDescArray.add(feedbackEditTxt11.getText().toString());
        feedbackDescArray.add(feedbackEditTxt12.getText().toString());
        feedbackDescArray.add(feedbackEditTxt13.getText().toString());
        feedbackDescArray.add(feedbackEditTxt14.getText().toString());
        feedbackDescArray.add(feedbackEditTxt15.getText().toString());
        feedbackDescArray.add(feedbackEditTxt16.getText().toString());
        feedbackDescArray.add(feedbackEditTxt17.getText().toString());
        feedbackDescArray.add(feedbackEditTxt18.getText().toString());
        feedbackDescArray.add(feedbackEditTxt19.getText().toString());
        feedbackDescArray.add(feedbackEditTxt20.getText().toString());

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                testArray.add(feedbackDescArray.get(i));
            }
        }

    }

    public void addInArrayOfSize1() {
        serviceIdArray.add(serviceId1);

        serviceDescArray.add(serviceDesc1);

        ratingArray.add(rating1);

        moodArray.add(mood1);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize2() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);

        ratingArray.add(rating1);
        ratingArray.add(rating2);

        moodArray.add(mood1);
        moodArray.add(mood2);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize3() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize4() {

        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);
        serviceIdArray.add(serviceId4);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);
        serviceDescArray.add(serviceDesc4);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);
        ratingArray.add(rating4);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize5() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);
        serviceIdArray.add(serviceId4);
        serviceIdArray.add(serviceId5);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);
        serviceDescArray.add(serviceDesc4);
        serviceDescArray.add(serviceDesc5);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);
        ratingArray.add(rating4);
        ratingArray.add(rating5);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize6() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);
        serviceIdArray.add(serviceId4);
        serviceIdArray.add(serviceId5);
        serviceIdArray.add(serviceId6);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);
        serviceDescArray.add(serviceDesc4);
        serviceDescArray.add(serviceDesc5);
        serviceDescArray.add(serviceDesc6);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);
        ratingArray.add(rating4);
        ratingArray.add(rating5);
        ratingArray.add(rating6);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize7() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);
        serviceIdArray.add(serviceId4);
        serviceIdArray.add(serviceId5);
        serviceIdArray.add(serviceId6);
        serviceIdArray.add(serviceId7);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);
        serviceDescArray.add(serviceDesc4);
        serviceDescArray.add(serviceDesc5);
        serviceDescArray.add(serviceDesc6);
        serviceDescArray.add(serviceDesc7);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);
        ratingArray.add(rating4);
        ratingArray.add(rating5);
        ratingArray.add(rating6);
        ratingArray.add(rating7);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);
        moodArray.add(mood7);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize8() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);
        serviceIdArray.add(serviceId4);
        serviceIdArray.add(serviceId5);
        serviceIdArray.add(serviceId6);
        serviceIdArray.add(serviceId7);
        serviceIdArray.add(serviceId8);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);
        serviceDescArray.add(serviceDesc4);
        serviceDescArray.add(serviceDesc5);
        serviceDescArray.add(serviceDesc6);
        serviceDescArray.add(serviceDesc7);
        serviceDescArray.add(serviceDesc8);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);
        ratingArray.add(rating4);
        ratingArray.add(rating5);
        ratingArray.add(rating6);
        ratingArray.add(rating7);
        ratingArray.add(rating8);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);
        moodArray.add(mood7);
        moodArray.add(mood8);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize9() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);
        serviceIdArray.add(serviceId4);
        serviceIdArray.add(serviceId5);
        serviceIdArray.add(serviceId6);
        serviceIdArray.add(serviceId7);
        serviceIdArray.add(serviceId8);
        serviceIdArray.add(serviceId9);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);
        serviceDescArray.add(serviceDesc4);
        serviceDescArray.add(serviceDesc5);
        serviceDescArray.add(serviceDesc6);
        serviceDescArray.add(serviceDesc7);
        serviceDescArray.add(serviceDesc8);
        serviceDescArray.add(serviceDesc9);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);
        ratingArray.add(rating4);
        ratingArray.add(rating5);
        ratingArray.add(rating6);
        ratingArray.add(rating7);
        ratingArray.add(rating8);
        ratingArray.add(rating9);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);
        moodArray.add(mood7);
        moodArray.add(mood8);
        moodArray.add(mood9);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize10() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);
        serviceIdArray.add(serviceId4);
        serviceIdArray.add(serviceId5);
        serviceIdArray.add(serviceId6);
        serviceIdArray.add(serviceId7);
        serviceIdArray.add(serviceId8);
        serviceIdArray.add(serviceId9);
        serviceIdArray.add(serviceId10);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);
        serviceDescArray.add(serviceDesc4);
        serviceDescArray.add(serviceDesc5);
        serviceDescArray.add(serviceDesc6);
        serviceDescArray.add(serviceDesc7);
        serviceDescArray.add(serviceDesc8);
        serviceDescArray.add(serviceDesc9);
        serviceDescArray.add(serviceDesc10);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);
        ratingArray.add(rating4);
        ratingArray.add(rating5);
        ratingArray.add(rating6);
        ratingArray.add(rating7);
        ratingArray.add(rating8);
        ratingArray.add(rating9);
        ratingArray.add(rating10);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);
        moodArray.add(mood7);
        moodArray.add(mood8);
        moodArray.add(mood9);
        moodArray.add(mood10);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize11() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);
        serviceIdArray.add(serviceId4);
        serviceIdArray.add(serviceId5);
        serviceIdArray.add(serviceId6);
        serviceIdArray.add(serviceId7);
        serviceIdArray.add(serviceId8);
        serviceIdArray.add(serviceId9);
        serviceIdArray.add(serviceId10);
        serviceIdArray.add(serviceId11);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);
        serviceDescArray.add(serviceDesc4);
        serviceDescArray.add(serviceDesc5);
        serviceDescArray.add(serviceDesc6);
        serviceDescArray.add(serviceDesc7);
        serviceDescArray.add(serviceDesc8);
        serviceDescArray.add(serviceDesc9);
        serviceDescArray.add(serviceDesc10);
        serviceDescArray.add(serviceDesc11);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);
        ratingArray.add(rating4);
        ratingArray.add(rating5);
        ratingArray.add(rating6);
        ratingArray.add(rating7);
        ratingArray.add(rating8);
        ratingArray.add(rating9);
        ratingArray.add(rating10);
        ratingArray.add(rating11);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);
        moodArray.add(mood7);
        moodArray.add(mood8);
        moodArray.add(mood9);
        moodArray.add(mood10);
        moodArray.add(mood11);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize12() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);
        serviceIdArray.add(serviceId4);
        serviceIdArray.add(serviceId5);
        serviceIdArray.add(serviceId6);
        serviceIdArray.add(serviceId7);
        serviceIdArray.add(serviceId8);
        serviceIdArray.add(serviceId9);
        serviceIdArray.add(serviceId10);
        serviceIdArray.add(serviceId11);
        serviceIdArray.add(serviceId12);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);
        serviceDescArray.add(serviceDesc4);
        serviceDescArray.add(serviceDesc5);
        serviceDescArray.add(serviceDesc6);
        serviceDescArray.add(serviceDesc7);
        serviceDescArray.add(serviceDesc8);
        serviceDescArray.add(serviceDesc9);
        serviceDescArray.add(serviceDesc10);
        serviceDescArray.add(serviceDesc11);
        serviceDescArray.add(serviceDesc12);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);
        ratingArray.add(rating4);
        ratingArray.add(rating5);
        ratingArray.add(rating6);
        ratingArray.add(rating7);
        ratingArray.add(rating8);
        ratingArray.add(rating9);
        ratingArray.add(rating10);
        ratingArray.add(rating11);
        ratingArray.add(rating12);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);
        moodArray.add(mood7);
        moodArray.add(mood8);
        moodArray.add(mood9);
        moodArray.add(mood10);
        moodArray.add(mood11);
        moodArray.add(mood12);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize13() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);
        serviceIdArray.add(serviceId4);
        serviceIdArray.add(serviceId5);
        serviceIdArray.add(serviceId6);
        serviceIdArray.add(serviceId7);
        serviceIdArray.add(serviceId8);
        serviceIdArray.add(serviceId9);
        serviceIdArray.add(serviceId10);
        serviceIdArray.add(serviceId11);
        serviceIdArray.add(serviceId12);
        serviceIdArray.add(serviceId13);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);
        serviceDescArray.add(serviceDesc4);
        serviceDescArray.add(serviceDesc5);
        serviceDescArray.add(serviceDesc6);
        serviceDescArray.add(serviceDesc7);
        serviceDescArray.add(serviceDesc8);
        serviceDescArray.add(serviceDesc9);
        serviceDescArray.add(serviceDesc10);
        serviceDescArray.add(serviceDesc11);
        serviceDescArray.add(serviceDesc12);
        serviceDescArray.add(serviceDesc13);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);
        ratingArray.add(rating4);
        ratingArray.add(rating5);
        ratingArray.add(rating6);
        ratingArray.add(rating7);
        ratingArray.add(rating8);
        ratingArray.add(rating9);
        ratingArray.add(rating10);
        ratingArray.add(rating11);
        ratingArray.add(rating12);
        ratingArray.add(rating13);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);
        moodArray.add(mood7);
        moodArray.add(mood8);
        moodArray.add(mood9);
        moodArray.add(mood10);
        moodArray.add(mood11);
        moodArray.add(mood12);
        moodArray.add(mood13);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize14() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);
        serviceIdArray.add(serviceId4);
        serviceIdArray.add(serviceId5);
        serviceIdArray.add(serviceId6);
        serviceIdArray.add(serviceId7);
        serviceIdArray.add(serviceId8);
        serviceIdArray.add(serviceId9);
        serviceIdArray.add(serviceId10);
        serviceIdArray.add(serviceId11);
        serviceIdArray.add(serviceId12);
        serviceIdArray.add(serviceId13);
        serviceIdArray.add(serviceId14);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);
        serviceDescArray.add(serviceDesc4);
        serviceDescArray.add(serviceDesc5);
        serviceDescArray.add(serviceDesc6);
        serviceDescArray.add(serviceDesc7);
        serviceDescArray.add(serviceDesc8);
        serviceDescArray.add(serviceDesc9);
        serviceDescArray.add(serviceDesc10);
        serviceDescArray.add(serviceDesc11);
        serviceDescArray.add(serviceDesc12);
        serviceDescArray.add(serviceDesc13);
        serviceDescArray.add(serviceDesc14);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);
        ratingArray.add(rating4);
        ratingArray.add(rating5);
        ratingArray.add(rating6);
        ratingArray.add(rating7);
        ratingArray.add(rating8);
        ratingArray.add(rating9);
        ratingArray.add(rating10);
        ratingArray.add(rating11);
        ratingArray.add(rating12);
        ratingArray.add(rating13);
        ratingArray.add(rating14);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);
        moodArray.add(mood7);
        moodArray.add(mood8);
        moodArray.add(mood9);
        moodArray.add(mood10);
        moodArray.add(mood11);
        moodArray.add(mood12);
        moodArray.add(mood13);
        moodArray.add(mood14);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize15() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);
        serviceIdArray.add(serviceId4);
        serviceIdArray.add(serviceId5);
        serviceIdArray.add(serviceId6);
        serviceIdArray.add(serviceId7);
        serviceIdArray.add(serviceId8);
        serviceIdArray.add(serviceId9);
        serviceIdArray.add(serviceId10);
        serviceIdArray.add(serviceId11);
        serviceIdArray.add(serviceId12);
        serviceIdArray.add(serviceId13);
        serviceIdArray.add(serviceId14);
        serviceIdArray.add(serviceId15);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);
        serviceDescArray.add(serviceDesc4);
        serviceDescArray.add(serviceDesc5);
        serviceDescArray.add(serviceDesc6);
        serviceDescArray.add(serviceDesc7);
        serviceDescArray.add(serviceDesc8);
        serviceDescArray.add(serviceDesc9);
        serviceDescArray.add(serviceDesc10);
        serviceDescArray.add(serviceDesc11);
        serviceDescArray.add(serviceDesc12);
        serviceDescArray.add(serviceDesc13);
        serviceDescArray.add(serviceDesc14);
        serviceDescArray.add(serviceDesc15);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);
        ratingArray.add(rating4);
        ratingArray.add(rating5);
        ratingArray.add(rating6);
        ratingArray.add(rating7);
        ratingArray.add(rating8);
        ratingArray.add(rating9);
        ratingArray.add(rating10);
        ratingArray.add(rating11);
        ratingArray.add(rating12);
        ratingArray.add(rating13);
        ratingArray.add(rating14);
        ratingArray.add(rating15);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);
        moodArray.add(mood7);
        moodArray.add(mood8);
        moodArray.add(mood9);
        moodArray.add(mood10);
        moodArray.add(mood11);
        moodArray.add(mood12);
        moodArray.add(mood13);
        moodArray.add(mood14);
        moodArray.add(mood15);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize16() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);
        serviceIdArray.add(serviceId4);
        serviceIdArray.add(serviceId5);
        serviceIdArray.add(serviceId6);
        serviceIdArray.add(serviceId7);
        serviceIdArray.add(serviceId8);
        serviceIdArray.add(serviceId9);
        serviceIdArray.add(serviceId10);
        serviceIdArray.add(serviceId11);
        serviceIdArray.add(serviceId12);
        serviceIdArray.add(serviceId13);
        serviceIdArray.add(serviceId14);
        serviceIdArray.add(serviceId15);
        serviceIdArray.add(serviceId16);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);
        serviceDescArray.add(serviceDesc4);
        serviceDescArray.add(serviceDesc5);
        serviceDescArray.add(serviceDesc6);
        serviceDescArray.add(serviceDesc7);
        serviceDescArray.add(serviceDesc8);
        serviceDescArray.add(serviceDesc9);
        serviceDescArray.add(serviceDesc10);
        serviceDescArray.add(serviceDesc11);
        serviceDescArray.add(serviceDesc12);
        serviceDescArray.add(serviceDesc13);
        serviceDescArray.add(serviceDesc14);
        serviceDescArray.add(serviceDesc15);
        serviceDescArray.add(serviceDesc16);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);
        ratingArray.add(rating4);
        ratingArray.add(rating5);
        ratingArray.add(rating6);
        ratingArray.add(rating7);
        ratingArray.add(rating8);
        ratingArray.add(rating9);
        ratingArray.add(rating10);
        ratingArray.add(rating11);
        ratingArray.add(rating12);
        ratingArray.add(rating13);
        ratingArray.add(rating14);
        ratingArray.add(rating15);
        ratingArray.add(rating16);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);
        moodArray.add(mood7);
        moodArray.add(mood8);
        moodArray.add(mood9);
        moodArray.add(mood10);
        moodArray.add(mood11);
        moodArray.add(mood12);
        moodArray.add(mood13);
        moodArray.add(mood14);
        moodArray.add(mood15);
        moodArray.add(mood16);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize17() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);
        serviceIdArray.add(serviceId4);
        serviceIdArray.add(serviceId5);
        serviceIdArray.add(serviceId6);
        serviceIdArray.add(serviceId7);
        serviceIdArray.add(serviceId8);
        serviceIdArray.add(serviceId9);
        serviceIdArray.add(serviceId10);
        serviceIdArray.add(serviceId11);
        serviceIdArray.add(serviceId12);
        serviceIdArray.add(serviceId13);
        serviceIdArray.add(serviceId14);
        serviceIdArray.add(serviceId15);
        serviceIdArray.add(serviceId16);
        serviceIdArray.add(serviceId17);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);
        serviceDescArray.add(serviceDesc4);
        serviceDescArray.add(serviceDesc5);
        serviceDescArray.add(serviceDesc6);
        serviceDescArray.add(serviceDesc7);
        serviceDescArray.add(serviceDesc8);
        serviceDescArray.add(serviceDesc9);
        serviceDescArray.add(serviceDesc10);
        serviceDescArray.add(serviceDesc11);
        serviceDescArray.add(serviceDesc12);
        serviceDescArray.add(serviceDesc13);
        serviceDescArray.add(serviceDesc14);
        serviceDescArray.add(serviceDesc15);
        serviceDescArray.add(serviceDesc16);
        serviceDescArray.add(serviceDesc17);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);
        ratingArray.add(rating4);
        ratingArray.add(rating5);
        ratingArray.add(rating6);
        ratingArray.add(rating7);
        ratingArray.add(rating8);
        ratingArray.add(rating9);
        ratingArray.add(rating10);
        ratingArray.add(rating11);
        ratingArray.add(rating12);
        ratingArray.add(rating13);
        ratingArray.add(rating14);
        ratingArray.add(rating15);
        ratingArray.add(rating16);
        ratingArray.add(rating17);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);
        moodArray.add(mood7);
        moodArray.add(mood8);
        moodArray.add(mood9);
        moodArray.add(mood10);
        moodArray.add(mood11);
        moodArray.add(mood12);
        moodArray.add(mood13);
        moodArray.add(mood14);
        moodArray.add(mood15);
        moodArray.add(mood16);
        moodArray.add(mood17);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize18() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);
        serviceIdArray.add(serviceId4);
        serviceIdArray.add(serviceId5);
        serviceIdArray.add(serviceId6);
        serviceIdArray.add(serviceId7);
        serviceIdArray.add(serviceId8);
        serviceIdArray.add(serviceId9);
        serviceIdArray.add(serviceId10);
        serviceIdArray.add(serviceId11);
        serviceIdArray.add(serviceId12);
        serviceIdArray.add(serviceId13);
        serviceIdArray.add(serviceId14);
        serviceIdArray.add(serviceId15);
        serviceIdArray.add(serviceId16);
        serviceIdArray.add(serviceId17);
        serviceIdArray.add(serviceId18);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);
        serviceDescArray.add(serviceDesc4);
        serviceDescArray.add(serviceDesc5);
        serviceDescArray.add(serviceDesc6);
        serviceDescArray.add(serviceDesc7);
        serviceDescArray.add(serviceDesc8);
        serviceDescArray.add(serviceDesc9);
        serviceDescArray.add(serviceDesc10);
        serviceDescArray.add(serviceDesc11);
        serviceDescArray.add(serviceDesc12);
        serviceDescArray.add(serviceDesc13);
        serviceDescArray.add(serviceDesc14);
        serviceDescArray.add(serviceDesc15);
        serviceDescArray.add(serviceDesc16);
        serviceDescArray.add(serviceDesc17);
        serviceDescArray.add(serviceDesc18);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);
        ratingArray.add(rating4);
        ratingArray.add(rating5);
        ratingArray.add(rating6);
        ratingArray.add(rating7);
        ratingArray.add(rating8);
        ratingArray.add(rating9);
        ratingArray.add(rating10);
        ratingArray.add(rating11);
        ratingArray.add(rating12);
        ratingArray.add(rating13);
        ratingArray.add(rating14);
        ratingArray.add(rating15);
        ratingArray.add(rating16);
        ratingArray.add(rating17);
        ratingArray.add(rating18);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);
        moodArray.add(mood7);
        moodArray.add(mood8);
        moodArray.add(mood9);
        moodArray.add(mood10);
        moodArray.add(mood11);
        moodArray.add(mood12);
        moodArray.add(mood13);
        moodArray.add(mood14);
        moodArray.add(mood15);
        moodArray.add(mood16);
        moodArray.add(mood17);
        moodArray.add(mood18);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize19() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);
        serviceIdArray.add(serviceId4);
        serviceIdArray.add(serviceId5);
        serviceIdArray.add(serviceId6);
        serviceIdArray.add(serviceId7);
        serviceIdArray.add(serviceId8);
        serviceIdArray.add(serviceId9);
        serviceIdArray.add(serviceId10);
        serviceIdArray.add(serviceId11);
        serviceIdArray.add(serviceId12);
        serviceIdArray.add(serviceId13);
        serviceIdArray.add(serviceId14);
        serviceIdArray.add(serviceId15);
        serviceIdArray.add(serviceId16);
        serviceIdArray.add(serviceId17);
        serviceIdArray.add(serviceId18);
        serviceIdArray.add(serviceId19);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);
        serviceDescArray.add(serviceDesc4);
        serviceDescArray.add(serviceDesc5);
        serviceDescArray.add(serviceDesc6);
        serviceDescArray.add(serviceDesc7);
        serviceDescArray.add(serviceDesc8);
        serviceDescArray.add(serviceDesc9);
        serviceDescArray.add(serviceDesc10);
        serviceDescArray.add(serviceDesc11);
        serviceDescArray.add(serviceDesc12);
        serviceDescArray.add(serviceDesc13);
        serviceDescArray.add(serviceDesc14);
        serviceDescArray.add(serviceDesc15);
        serviceDescArray.add(serviceDesc16);
        serviceDescArray.add(serviceDesc17);
        serviceDescArray.add(serviceDesc18);
        serviceDescArray.add(serviceDesc19);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);
        ratingArray.add(rating4);
        ratingArray.add(rating5);
        ratingArray.add(rating6);
        ratingArray.add(rating7);
        ratingArray.add(rating8);
        ratingArray.add(rating9);
        ratingArray.add(rating10);
        ratingArray.add(rating11);
        ratingArray.add(rating12);
        ratingArray.add(rating13);
        ratingArray.add(rating14);
        ratingArray.add(rating15);
        ratingArray.add(rating16);
        ratingArray.add(rating17);
        ratingArray.add(rating18);
        ratingArray.add(rating19);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);
        moodArray.add(mood7);
        moodArray.add(mood8);
        moodArray.add(mood9);
        moodArray.add(mood10);
        moodArray.add(mood11);
        moodArray.add(mood12);
        moodArray.add(mood13);
        moodArray.add(mood14);
        moodArray.add(mood15);
        moodArray.add(mood16);
        moodArray.add(mood17);
        moodArray.add(mood18);
        moodArray.add(mood19);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public void addInArrayOfSize20() {
        serviceIdArray.add(serviceId1);
        serviceIdArray.add(serviceId2);
        serviceIdArray.add(serviceId3);
        serviceIdArray.add(serviceId4);
        serviceIdArray.add(serviceId5);
        serviceIdArray.add(serviceId6);
        serviceIdArray.add(serviceId7);
        serviceIdArray.add(serviceId8);
        serviceIdArray.add(serviceId9);
        serviceIdArray.add(serviceId10);
        serviceIdArray.add(serviceId11);
        serviceIdArray.add(serviceId12);
        serviceIdArray.add(serviceId13);
        serviceIdArray.add(serviceId14);
        serviceIdArray.add(serviceId15);
        serviceIdArray.add(serviceId16);
        serviceIdArray.add(serviceId17);
        serviceIdArray.add(serviceId18);
        serviceIdArray.add(serviceId19);
        serviceIdArray.add(serviceId20);

        serviceDescArray.add(serviceDesc1);
        serviceDescArray.add(serviceDesc2);
        serviceDescArray.add(serviceDesc3);
        serviceDescArray.add(serviceDesc4);
        serviceDescArray.add(serviceDesc5);
        serviceDescArray.add(serviceDesc6);
        serviceDescArray.add(serviceDesc7);
        serviceDescArray.add(serviceDesc8);
        serviceDescArray.add(serviceDesc9);
        serviceDescArray.add(serviceDesc10);
        serviceDescArray.add(serviceDesc11);
        serviceDescArray.add(serviceDesc12);
        serviceDescArray.add(serviceDesc13);
        serviceDescArray.add(serviceDesc14);
        serviceDescArray.add(serviceDesc15);
        serviceDescArray.add(serviceDesc16);
        serviceDescArray.add(serviceDesc17);
        serviceDescArray.add(serviceDesc18);
        serviceDescArray.add(serviceDesc19);
        serviceDescArray.add(serviceDesc20);

        ratingArray.add(rating1);
        ratingArray.add(rating2);
        ratingArray.add(rating3);
        ratingArray.add(rating4);
        ratingArray.add(rating5);
        ratingArray.add(rating6);
        ratingArray.add(rating7);
        ratingArray.add(rating8);
        ratingArray.add(rating9);
        ratingArray.add(rating10);
        ratingArray.add(rating11);
        ratingArray.add(rating12);
        ratingArray.add(rating13);
        ratingArray.add(rating14);
        ratingArray.add(rating15);
        ratingArray.add(rating16);
        ratingArray.add(rating17);
        ratingArray.add(rating18);
        ratingArray.add(rating19);
        ratingArray.add(rating20);

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);
        moodArray.add(mood7);
        moodArray.add(mood8);
        moodArray.add(mood9);
        moodArray.add(mood10);
        moodArray.add(mood11);
        moodArray.add(mood12);
        moodArray.add(mood13);
        moodArray.add(mood14);
        moodArray.add(mood15);
        moodArray.add(mood16);
        moodArray.add(mood17);
        moodArray.add(mood18);
        moodArray.add(mood19);
        moodArray.add(mood20);

        for (int i = 0; i <= Integer.valueOf(ratingArray.size()) - 1; i++) {
            if (Integer.valueOf(ratingArray.get(i)) == 1 || Integer.valueOf(ratingArray.get(i)) == 2) {
                serviceIdFeedbackArray.add(serviceIdArray.get(i));
                feedbackRatingArray.add(ratingArray.get(i));
            }
        }
    }

    public class AsyncSoapClass extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            String SOAP_ACTION_FEEDBACK = "http://apps.visualsolutions.work/Feedback";
            String METHOD_NAME_FEEDBACK = "Feedback";
            String NAMESPACE_FEEDBACK = "http://apps.visualsolutions.work/";
            String URL_FEEDBACK = "http://androidwebservice.somee.com/WebService.asmx?WSDL";

            for (int i = 0; i <= Integer.valueOf(serviceIdFeedbackArray.size()) - 1; i++) {

                SoapObject request = new SoapObject(NAMESPACE_FEEDBACK, METHOD_NAME_FEEDBACK);

                PropertyInfo pi = new PropertyInfo();
                pi.setName("FeedBackDesc");
                pi.setValue(String.valueOf(testArray.get(i)));
                pi.setType(String.class);
                request.addProperty(pi);

                pi = new PropertyInfo();
                pi.setName("ServiceCatID");
                pi.setValue(String.valueOf(catId));
                pi.setType(String.class);
                request.addProperty(pi);

                pi = new PropertyInfo();
                pi.setName("ServiceID");
                pi.setValue(String.valueOf(serviceIdFeedbackArray.get(i)));
                pi.setType(String.class);
                request.addProperty(pi);

                pi = new PropertyInfo();
                pi.setName("RatingID");
                pi.setValue(String.valueOf(feedbackRatingArray.get(i)));
                pi.setType(String.class);
                request.addProperty(pi);

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);

                HttpTransportSE httptransport = new HttpTransportSE(URL_FEEDBACK);
                httptransport.debug = true;

                try {
                    httptransport.call(SOAP_ACTION_FEEDBACK, envelope);
                } catch (Exception e) {
                    String result = "ERROR";
                }
            }

            return "";

        }

        @Override
        protected void onPostExecute(String result) {
            //super.onPostExecute(result);
            //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            //TextView txtResponse = findViewById(R.id.txt_response);
            //txtDesc.setText(result);
            //json_string = result;
            //Toast.makeText(getApplicationContext(), json_string, Toast.LENGTH_LONG).show();

        }
    }

}
