package com.asad.myfirstjob;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hsalf.smilerating.SmileRating;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

public class RatingActivity extends AppCompatActivity {

    String catDesc, catId, timing;

    SmileRating smRating1, smRating2, smRating3, smRating4, smRating5, smRating6, smRating7, smRating8, smRating9, smRating10;
    SmileRating smRating11, smRating12, smRating13, smRating14, smRating15, smRating16, smRating17, smRating18, smRating19, smRating20;

    TextView[] serviceIds;
    TextView[] serviceDescs;
    LinearLayout[] linearlayouts;
    Button serviceFeedbackBtn, serviceSubmitBtn;

    int r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20;
    String mood1, mood2, mood3, mood4, mood5, mood6, mood7, mood8, mood9, mood10, mood;
    String mood11, mood12, mood13, mood14, mood15, mood16, mood17, mood18, mood19, mood20;
    String serviceValue1, serviceValue2, serviceValue3, serviceValue4, serviceValue5, serviceValue6, serviceValue7, serviceValue8, serviceValue9, serviceValue10;
    String serviceValue11, serviceValue12, serviceValue13, serviceValue14, serviceValue15, serviceValue16, serviceValue17, serviceValue18, serviceValue19, serviceValue20;

    List<String> serviceIdArr = new ArrayList<>();
    List<String> serviceDescArr = new ArrayList<>();
    List<String> moodArray = new ArrayList<>();
    List<String> feedbackDescArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        serviceIds = new TextView[22];
        serviceDescs = new TextView[22];
        linearlayouts = new LinearLayout[22];

        controlInit();

        serviceFeedbackBtn = findViewById(R.id.serviceFeedback_btn);
        serviceSubmitBtn = findViewById(R.id.serviceSubmit_btn);

        catId = getIntent().getStringExtra("catId");
        catDesc = getIntent().getStringExtra("catDesc");
        timing = getIntent().getStringExtra("timing");

        smRating1.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r1RatingSelected(level);
            }
        });

        smRating2.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r2RatingSelected(level);
            }
        });

        smRating3.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r3RatingSelected(level);
            }
        });

        smRating4.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r4RatingSelected(level);
            }
        });


        smRating5.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r5RatingSelected(level);
            }
        });

        smRating6.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r6RatingSelected(level);
            }
        });

        smRating7.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r7RatingSelected(level);
            }
        });

        smRating8.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r8RatingSelected(level);
            }
        });

        smRating9.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r9RatingSelected(level);
            }
        });

        smRating10.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r10RatingSelected(level);
            }
        });

        smRating11.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r11RatingSelected(level);
            }
        });

        smRating12.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r12RatingSelected(level);
            }
        });

        smRating13.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r13RatingSelected(level);
            }
        });

        smRating14.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r14RatingSelected(level);
            }
        });

        smRating15.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r15RatingSelected(level);
            }
        });

        smRating16.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r16RatingSelected(level);
            }
        });

        smRating17.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r17RatingSelected(level);
            }
        });

        smRating18.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r18RatingSelected(level);
            }
        });

        smRating19.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r19RatingSelected(level);
            }
        });

        smRating20.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {

                r20RatingSelected(level);
            }
        });

        AsyncSoapClass as = new AsyncSoapClass(new AsyncResponse() {
            @Override
            public void processFinish(Object output) {

                Log.d("Asynchronous task:", (String) output);

                try {
                    JSONObject jsonObject = new JSONObject((String) output);
                    JSONArray array = jsonObject.getJSONArray("Services");

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject o = array.getJSONObject(i);
                        o.getInt("ServiceID");
                        o.getString("ServiceDesc");
                        serviceIdArr.add(o.getString("ServiceID"));
                        serviceDescArr.add(o.getString("ServiceDesc"));

                        String txtId = "serviceId" + (i + 1);
                        String txtDesc = "serviceDesc" + (i + 1);
                        String linearlayoutId = "linearlayout" + (i + 1);
                        int resID = getResources().getIdentifier(txtId, "id", getPackageName());
                        int linearID = getResources().getIdentifier(linearlayoutId, "id", getPackageName());
                        int descID = getResources().getIdentifier(txtDesc, "id", getPackageName());
                        linearlayouts[i] = findViewById(linearID);
                        linearlayouts[i].setVisibility(View.VISIBLE);
                        serviceIds[i] = findViewById(resID);
                        serviceDescs[i] = findViewById(descID);
                        serviceDescs[i].setText(String.valueOf(serviceDescArr.get(i)));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                serviceSubmitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        initRating();

                        if (serviceIdArr.size() == 1) {
                            submitForSize1();
                        }

                        if (serviceIdArr.size() == 2) {
                            submitForSize2();
                        }

                        if (serviceIdArr.size() == 3) {
                            submitForSize3();
                        }

                        if (serviceIdArr.size() == 4) {
                            submitForSize4();
                        }

                        if (serviceIdArr.size() == 5) {
                            submitForSize5();
                        }

                        if (serviceIdArr.size() == 6) {
                            submitForSize6();
                        }

                        if (serviceIdArr.size() == 7) {
                            submitForSize7();
                        }

                        if (serviceIdArr.size() == 8) {
                            submitForSize8();
                        }

                        if (serviceIdArr.size() == 9) {
                            submitForSize9();
                        }

                        if (serviceIdArr.size() == 10) {
                            submitForSize10();
                        }

                        if (serviceIdArr.size() == 11) {
                            submitForSize11();
                        }

                        if (serviceIdArr.size() == 12) {
                            submitForSize12();
                        }

                        if (serviceIdArr.size() == 13) {
                            submitForSize13();
                        }

                        if (serviceIdArr.size() == 14) {
                            submitForSize14();
                        }

                        if (serviceIdArr.size() == 15) {
                            submitForSize15();
                        }

                        if (serviceIdArr.size() == 16) {
                            submitForSize16();
                        }

                        if (serviceIdArr.size() == 17) {
                            submitForSize17();
                        }

                        if (serviceIdArr.size() == 18) {
                            submitForSize18();
                        }

                        if (serviceIdArr.size() == 19) {
                            submitForSize19();
                        }

                        if (serviceIdArr.size() == 20) {
                            submitForSize20();
                        }

                    }
                });

                serviceFeedbackBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        initRating();

                        if (serviceIdArr.size() == 1) {
                            feedbackForSize1();
                        }

                        if (serviceIdArr.size() == 2) {
                            feedbackForSize2();
                        }

                        if (serviceIdArr.size() == 3) {
                            feedbackForSize3();
                        }

                        if (serviceIdArr.size() == 4) {
                            feedbackForSize4();
                        }

                        if (serviceIdArr.size() == 5) {
                            feedbackForSize5();
                        }

                        if (serviceIdArr.size() == 6) {
                            feedbackForSize6();
                        }

                        if (serviceIdArr.size() == 7) {
                            feedbackForSize7();
                        }

                        if (serviceIdArr.size() == 8) {
                            feedbackForSize8();
                        }

                        if (serviceIdArr.size() == 9) {
                            feedbackForSize9();
                        }

                        if (serviceIdArr.size() == 10) {
                            feedbackForSize10();
                        }

                        if (serviceIdArr.size() == 11) {
                            feedbackForSize11();
                        }

                        if (serviceIdArr.size() == 12) {
                            feedbackForSize12();
                        }

                        if (serviceIdArr.size() == 13) {
                            feedbackForSize13();
                        }

                        if (serviceIdArr.size() == 14) {
                            feedbackForSize14();
                        }

                        if (serviceIdArr.size() == 15) {
                            feedbackForSize15();
                        }

                        if (serviceIdArr.size() == 16) {
                            feedbackForSize16();
                        }

                        if (serviceIdArr.size() == 17) {
                            feedbackForSize17();
                        }

                        if (serviceIdArr.size() == 18) {
                            feedbackForSize18();
                        }

                        if (serviceIdArr.size() == 19) {
                            feedbackForSize19();
                        }

                        if (serviceIdArr.size() == 20) {
                            feedbackForSize20();
                        }

                    }

                });

            }
        });
        as.execute();
    }

    public void initRating(){
        int serviceRating1 = smRating1.getRating();
        int serviceRating2 = smRating2.getRating();
        int serviceRating3 = smRating3.getRating();
        int serviceRating4 = smRating4.getRating();
        int serviceRating5 = smRating5.getRating();
        int serviceRating6 = smRating6.getRating();
        int serviceRating7 = smRating7.getRating();
        int serviceRating8 = smRating8.getRating();
        int serviceRating9 = smRating9.getRating();
        int serviceRating10 = smRating10.getRating();
        int serviceRating11 = smRating11.getRating();
        int serviceRating12 = smRating12.getRating();
        int serviceRating13 = smRating13.getRating();
        int serviceRating14 = smRating14.getRating();
        int serviceRating15 = smRating15.getRating();
        int serviceRating16 = smRating16.getRating();
        int serviceRating17 = smRating17.getRating();
        int serviceRating18 = smRating18.getRating();
        int serviceRating19 = smRating19.getRating();
        int serviceRating20 = smRating20.getRating();

        serviceValue1 = String.valueOf(serviceRating1);
        serviceValue2 = String.valueOf(serviceRating2);
        serviceValue3 = String.valueOf(serviceRating3);
        serviceValue4 = String.valueOf(serviceRating4);
        serviceValue5 = String.valueOf(serviceRating5);
        serviceValue6 = String.valueOf(serviceRating6);
        serviceValue7 = String.valueOf(serviceRating7);
        serviceValue8 = String.valueOf(serviceRating8);
        serviceValue9 = String.valueOf(serviceRating9);
        serviceValue10 = String.valueOf(serviceRating10);
        serviceValue11 = String.valueOf(serviceRating11);
        serviceValue12 = String.valueOf(serviceRating12);
        serviceValue13 = String.valueOf(serviceRating13);
        serviceValue14 = String.valueOf(serviceRating14);
        serviceValue15 = String.valueOf(serviceRating15);
        serviceValue16 = String.valueOf(serviceRating16);
        serviceValue17 = String.valueOf(serviceRating17);
        serviceValue18 = String.valueOf(serviceRating18);
        serviceValue19 = String.valueOf(serviceRating19);
        serviceValue20 = String.valueOf(serviceRating20);

        mood1 = getR1Rating(mood);
        mood2 = getR2Rating(mood);
        mood3 = getR3Rating(mood);
        mood4 = getR4Rating(mood);
        mood5 = getR5Rating(mood);
        mood6 = getR6Rating(mood);
        mood7 = getR7Rating(mood);
        mood8 = getR8Rating(mood);
        mood9 = getR9Rating(mood);
        mood10 = getR10Rating(mood);
        mood11 = getR11Rating(mood);
        mood12 = getR12Rating(mood);
        mood13 = getR13Rating(mood);
        mood14 = getR14Rating(mood);
        mood15 = getR15Rating(mood);
        mood16 = getR16Rating(mood);
        mood17 = getR17Rating(mood);
        mood18 = getR18Rating(mood);
        mood19 = getR19Rating(mood);
        mood20 = getR20Rating(mood);
    }

    public void feedbackForSize1(){
        int service1 = smRating1.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        } else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("mood1", mood1);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize2(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        } else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize3(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating2.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        } else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize4(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        } else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceId4", serviceIdArr.get(3));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("serviceDesc4", serviceDescArr.get(3));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("rating4", serviceValue4);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("mood4", mood4);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize5(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        } else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceId4", serviceIdArr.get(3));
            in.putExtra("serviceId5", serviceIdArr.get(4));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("serviceDesc4", serviceDescArr.get(3));
            in.putExtra("serviceDesc5", serviceDescArr.get(4));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("rating4", serviceValue4);
            in.putExtra("rating5", serviceValue5);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("mood4", mood4);
            in.putExtra("mood5", mood5);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize6(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        } else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceId4", serviceIdArr.get(3));
            in.putExtra("serviceId5", serviceIdArr.get(4));
            in.putExtra("serviceId6", serviceIdArr.get(5));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("serviceDesc4", serviceDescArr.get(3));
            in.putExtra("serviceDesc5", serviceDescArr.get(4));
            in.putExtra("serviceDesc6", serviceDescArr.get(5));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("rating4", serviceValue4);
            in.putExtra("rating5", serviceValue5);
            in.putExtra("rating6", serviceValue6);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("mood4", mood4);
            in.putExtra("mood5", mood5);
            in.putExtra("mood6", mood6);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize7(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceId4", serviceIdArr.get(3));
            in.putExtra("serviceId5", serviceIdArr.get(4));
            in.putExtra("serviceId6", serviceIdArr.get(5));
            in.putExtra("serviceId7", serviceIdArr.get(6));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("serviceDesc4", serviceDescArr.get(3));
            in.putExtra("serviceDesc5", serviceDescArr.get(4));
            in.putExtra("serviceDesc6", serviceDescArr.get(5));
            in.putExtra("serviceDesc7", serviceDescArr.get(6));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("rating4", serviceValue4);
            in.putExtra("rating5", serviceValue5);
            in.putExtra("rating6", serviceValue6);
            in.putExtra("rating7", serviceValue7);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("mood4", mood4);
            in.putExtra("mood5", mood5);
            in.putExtra("mood6", mood6);
            in.putExtra("mood7", mood7);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize8(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceId4", serviceIdArr.get(3));
            in.putExtra("serviceId5", serviceIdArr.get(4));
            in.putExtra("serviceId6", serviceIdArr.get(5));
            in.putExtra("serviceId7", serviceIdArr.get(6));
            in.putExtra("serviceId8", serviceIdArr.get(7));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("serviceDesc4", serviceDescArr.get(3));
            in.putExtra("serviceDesc5", serviceDescArr.get(4));
            in.putExtra("serviceDesc6", serviceDescArr.get(5));
            in.putExtra("serviceDesc7", serviceDescArr.get(6));
            in.putExtra("serviceDesc8", serviceDescArr.get(7));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("rating4", serviceValue4);
            in.putExtra("rating5", serviceValue5);
            in.putExtra("rating6", serviceValue6);
            in.putExtra("rating7", serviceValue7);
            in.putExtra("rating8", serviceValue8);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("mood4", mood4);
            in.putExtra("mood5", mood5);
            in.putExtra("mood6", mood6);
            in.putExtra("mood7", mood7);
            in.putExtra("mood8", mood8);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize9(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceId4", serviceIdArr.get(3));
            in.putExtra("serviceId5", serviceIdArr.get(4));
            in.putExtra("serviceId6", serviceIdArr.get(5));
            in.putExtra("serviceId7", serviceIdArr.get(6));
            in.putExtra("serviceId8", serviceIdArr.get(7));
            in.putExtra("serviceId9", serviceIdArr.get(8));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("serviceDesc4", serviceDescArr.get(3));
            in.putExtra("serviceDesc5", serviceDescArr.get(4));
            in.putExtra("serviceDesc6", serviceDescArr.get(5));
            in.putExtra("serviceDesc7", serviceDescArr.get(6));
            in.putExtra("serviceDesc8", serviceDescArr.get(7));
            in.putExtra("serviceDesc9", serviceDescArr.get(8));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("rating4", serviceValue4);
            in.putExtra("rating5", serviceValue5);
            in.putExtra("rating6", serviceValue6);
            in.putExtra("rating7", serviceValue7);
            in.putExtra("rating8", serviceValue8);
            in.putExtra("rating9", serviceValue9);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("mood4", mood4);
            in.putExtra("mood5", mood5);
            in.putExtra("mood6", mood6);
            in.putExtra("mood7", mood7);
            in.putExtra("mood8", mood8);
            in.putExtra("mood9", mood9);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize10(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceId4", serviceIdArr.get(3));
            in.putExtra("serviceId5", serviceIdArr.get(4));
            in.putExtra("serviceId6", serviceIdArr.get(5));
            in.putExtra("serviceId7", serviceIdArr.get(6));
            in.putExtra("serviceId8", serviceIdArr.get(7));
            in.putExtra("serviceId9", serviceIdArr.get(8));
            in.putExtra("serviceId10", serviceIdArr.get(9));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("serviceDesc4", serviceDescArr.get(3));
            in.putExtra("serviceDesc5", serviceDescArr.get(4));
            in.putExtra("serviceDesc6", serviceDescArr.get(5));
            in.putExtra("serviceDesc7", serviceDescArr.get(6));
            in.putExtra("serviceDesc8", serviceDescArr.get(7));
            in.putExtra("serviceDesc9", serviceDescArr.get(8));
            in.putExtra("serviceDesc10", serviceDescArr.get(9));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("rating4", serviceValue4);
            in.putExtra("rating5", serviceValue5);
            in.putExtra("rating6", serviceValue6);
            in.putExtra("rating7", serviceValue7);
            in.putExtra("rating8", serviceValue8);
            in.putExtra("rating9", serviceValue9);
            in.putExtra("rating10", serviceValue10);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("mood4", mood4);
            in.putExtra("mood5", mood5);
            in.putExtra("mood6", mood6);
            in.putExtra("mood7", mood7);
            in.putExtra("mood8", mood8);
            in.putExtra("mood9", mood9);
            in.putExtra("mood10", mood10);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize11(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceId4", serviceIdArr.get(3));
            in.putExtra("serviceId5", serviceIdArr.get(4));
            in.putExtra("serviceId6", serviceIdArr.get(5));
            in.putExtra("serviceId7", serviceIdArr.get(6));
            in.putExtra("serviceId8", serviceIdArr.get(7));
            in.putExtra("serviceId9", serviceIdArr.get(8));
            in.putExtra("serviceId10", serviceIdArr.get(9));
            in.putExtra("serviceId11", serviceIdArr.get(10));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("serviceDesc4", serviceDescArr.get(3));
            in.putExtra("serviceDesc5", serviceDescArr.get(4));
            in.putExtra("serviceDesc6", serviceDescArr.get(5));
            in.putExtra("serviceDesc7", serviceDescArr.get(6));
            in.putExtra("serviceDesc8", serviceDescArr.get(7));
            in.putExtra("serviceDesc9", serviceDescArr.get(8));
            in.putExtra("serviceDesc10", serviceDescArr.get(9));
            in.putExtra("serviceDesc11", serviceDescArr.get(10));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("rating4", serviceValue4);
            in.putExtra("rating5", serviceValue5);
            in.putExtra("rating6", serviceValue6);
            in.putExtra("rating7", serviceValue7);
            in.putExtra("rating8", serviceValue8);
            in.putExtra("rating9", serviceValue9);
            in.putExtra("rating10", serviceValue10);
            in.putExtra("rating11", serviceValue11);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("mood4", mood4);
            in.putExtra("mood5", mood5);
            in.putExtra("mood6", mood6);
            in.putExtra("mood7", mood7);
            in.putExtra("mood8", mood8);
            in.putExtra("mood9", mood9);
            in.putExtra("mood10", mood10);
            in.putExtra("mood11", mood11);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize12(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceId4", serviceIdArr.get(3));
            in.putExtra("serviceId5", serviceIdArr.get(4));
            in.putExtra("serviceId6", serviceIdArr.get(5));
            in.putExtra("serviceId7", serviceIdArr.get(6));
            in.putExtra("serviceId8", serviceIdArr.get(7));
            in.putExtra("serviceId9", serviceIdArr.get(8));
            in.putExtra("serviceId10", serviceIdArr.get(9));
            in.putExtra("serviceId11", serviceIdArr.get(10));
            in.putExtra("serviceId12", serviceIdArr.get(11));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("serviceDesc4", serviceDescArr.get(3));
            in.putExtra("serviceDesc5", serviceDescArr.get(4));
            in.putExtra("serviceDesc6", serviceDescArr.get(5));
            in.putExtra("serviceDesc7", serviceDescArr.get(6));
            in.putExtra("serviceDesc8", serviceDescArr.get(7));
            in.putExtra("serviceDesc9", serviceDescArr.get(8));
            in.putExtra("serviceDesc10", serviceDescArr.get(9));
            in.putExtra("serviceDesc11", serviceDescArr.get(10));
            in.putExtra("serviceDesc12", serviceDescArr.get(11));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("rating4", serviceValue4);
            in.putExtra("rating5", serviceValue5);
            in.putExtra("rating6", serviceValue6);
            in.putExtra("rating7", serviceValue7);
            in.putExtra("rating8", serviceValue8);
            in.putExtra("rating9", serviceValue9);
            in.putExtra("rating10", serviceValue10);
            in.putExtra("rating11", serviceValue11);
            in.putExtra("rating12", serviceValue12);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("mood4", mood4);
            in.putExtra("mood5", mood5);
            in.putExtra("mood6", mood6);
            in.putExtra("mood7", mood7);
            in.putExtra("mood8", mood8);
            in.putExtra("mood9", mood9);
            in.putExtra("mood10", mood10);
            in.putExtra("mood11", mood11);
            in.putExtra("mood12", mood12);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize13(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();
        int service13 = smRating13.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service13 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(12), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceId4", serviceIdArr.get(3));
            in.putExtra("serviceId5", serviceIdArr.get(4));
            in.putExtra("serviceId6", serviceIdArr.get(5));
            in.putExtra("serviceId7", serviceIdArr.get(6));
            in.putExtra("serviceId8", serviceIdArr.get(7));
            in.putExtra("serviceId9", serviceIdArr.get(8));
            in.putExtra("serviceId10", serviceIdArr.get(9));
            in.putExtra("serviceId11", serviceIdArr.get(10));
            in.putExtra("serviceId12", serviceIdArr.get(11));
            in.putExtra("serviceId13", serviceIdArr.get(12));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("serviceDesc4", serviceDescArr.get(3));
            in.putExtra("serviceDesc5", serviceDescArr.get(4));
            in.putExtra("serviceDesc6", serviceDescArr.get(5));
            in.putExtra("serviceDesc7", serviceDescArr.get(6));
            in.putExtra("serviceDesc8", serviceDescArr.get(7));
            in.putExtra("serviceDesc9", serviceDescArr.get(8));
            in.putExtra("serviceDesc10", serviceDescArr.get(9));
            in.putExtra("serviceDesc11", serviceDescArr.get(10));
            in.putExtra("serviceDesc12", serviceDescArr.get(11));
            in.putExtra("serviceDesc13", serviceDescArr.get(12));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("rating4", serviceValue4);
            in.putExtra("rating5", serviceValue5);
            in.putExtra("rating6", serviceValue6);
            in.putExtra("rating7", serviceValue7);
            in.putExtra("rating8", serviceValue8);
            in.putExtra("rating9", serviceValue9);
            in.putExtra("rating10", serviceValue10);
            in.putExtra("rating11", serviceValue11);
            in.putExtra("rating12", serviceValue12);
            in.putExtra("rating13", serviceValue13);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("mood4", mood4);
            in.putExtra("mood5", mood5);
            in.putExtra("mood6", mood6);
            in.putExtra("mood7", mood7);
            in.putExtra("mood8", mood8);
            in.putExtra("mood9", mood9);
            in.putExtra("mood10", mood10);
            in.putExtra("mood11", mood11);
            in.putExtra("mood12", mood12);
            in.putExtra("mood13", mood13);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize14(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();
        int service13 = smRating13.getRating();
        int service14 = smRating14.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service13 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(12), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service14 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(13), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceId4", serviceIdArr.get(3));
            in.putExtra("serviceId5", serviceIdArr.get(4));
            in.putExtra("serviceId6", serviceIdArr.get(5));
            in.putExtra("serviceId7", serviceIdArr.get(6));
            in.putExtra("serviceId8", serviceIdArr.get(7));
            in.putExtra("serviceId9", serviceIdArr.get(8));
            in.putExtra("serviceId10", serviceIdArr.get(9));
            in.putExtra("serviceId11", serviceIdArr.get(10));
            in.putExtra("serviceId12", serviceIdArr.get(11));
            in.putExtra("serviceId13", serviceIdArr.get(12));
            in.putExtra("serviceId14", serviceIdArr.get(13));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("serviceDesc4", serviceDescArr.get(3));
            in.putExtra("serviceDesc5", serviceDescArr.get(4));
            in.putExtra("serviceDesc6", serviceDescArr.get(5));
            in.putExtra("serviceDesc7", serviceDescArr.get(6));
            in.putExtra("serviceDesc8", serviceDescArr.get(7));
            in.putExtra("serviceDesc9", serviceDescArr.get(8));
            in.putExtra("serviceDesc10", serviceDescArr.get(9));
            in.putExtra("serviceDesc11", serviceDescArr.get(10));
            in.putExtra("serviceDesc12", serviceDescArr.get(11));
            in.putExtra("serviceDesc13", serviceDescArr.get(12));
            in.putExtra("serviceDesc14", serviceDescArr.get(13));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("rating4", serviceValue4);
            in.putExtra("rating5", serviceValue5);
            in.putExtra("rating6", serviceValue6);
            in.putExtra("rating7", serviceValue7);
            in.putExtra("rating8", serviceValue8);
            in.putExtra("rating9", serviceValue9);
            in.putExtra("rating10", serviceValue10);
            in.putExtra("rating11", serviceValue11);
            in.putExtra("rating12", serviceValue12);
            in.putExtra("rating13", serviceValue13);
            in.putExtra("rating14", serviceValue14);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("mood4", mood4);
            in.putExtra("mood5", mood5);
            in.putExtra("mood6", mood6);
            in.putExtra("mood7", mood7);
            in.putExtra("mood8", mood8);
            in.putExtra("mood9", mood9);
            in.putExtra("mood10", mood10);
            in.putExtra("mood11", mood11);
            in.putExtra("mood12", mood12);
            in.putExtra("mood13", mood13);
            in.putExtra("mood14", mood14);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize15(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();
        int service13 = smRating13.getRating();
        int service14 = smRating14.getRating();
        int service15 = smRating15.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service13 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(12), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service14 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(13), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service15 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(14), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceId4", serviceIdArr.get(3));
            in.putExtra("serviceId5", serviceIdArr.get(4));
            in.putExtra("serviceId6", serviceIdArr.get(5));
            in.putExtra("serviceId7", serviceIdArr.get(6));
            in.putExtra("serviceId8", serviceIdArr.get(7));
            in.putExtra("serviceId9", serviceIdArr.get(8));
            in.putExtra("serviceId10", serviceIdArr.get(9));
            in.putExtra("serviceId11", serviceIdArr.get(10));
            in.putExtra("serviceId12", serviceIdArr.get(11));
            in.putExtra("serviceId13", serviceIdArr.get(12));
            in.putExtra("serviceId14", serviceIdArr.get(13));
            in.putExtra("serviceId15", serviceIdArr.get(14));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("serviceDesc4", serviceDescArr.get(3));
            in.putExtra("serviceDesc5", serviceDescArr.get(4));
            in.putExtra("serviceDesc6", serviceDescArr.get(5));
            in.putExtra("serviceDesc7", serviceDescArr.get(6));
            in.putExtra("serviceDesc8", serviceDescArr.get(7));
            in.putExtra("serviceDesc9", serviceDescArr.get(8));
            in.putExtra("serviceDesc10", serviceDescArr.get(9));
            in.putExtra("serviceDesc11", serviceDescArr.get(10));
            in.putExtra("serviceDesc12", serviceDescArr.get(11));
            in.putExtra("serviceDesc13", serviceDescArr.get(12));
            in.putExtra("serviceDesc14", serviceDescArr.get(13));
            in.putExtra("serviceDesc15", serviceDescArr.get(14));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("rating4", serviceValue4);
            in.putExtra("rating5", serviceValue5);
            in.putExtra("rating6", serviceValue6);
            in.putExtra("rating7", serviceValue7);
            in.putExtra("rating8", serviceValue8);
            in.putExtra("rating9", serviceValue9);
            in.putExtra("rating10", serviceValue10);
            in.putExtra("rating11", serviceValue11);
            in.putExtra("rating12", serviceValue12);
            in.putExtra("rating13", serviceValue13);
            in.putExtra("rating14", serviceValue14);
            in.putExtra("rating15", serviceValue15);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("mood4", mood4);
            in.putExtra("mood5", mood5);
            in.putExtra("mood6", mood6);
            in.putExtra("mood7", mood7);
            in.putExtra("mood8", mood8);
            in.putExtra("mood9", mood9);
            in.putExtra("mood10", mood10);
            in.putExtra("mood11", mood11);
            in.putExtra("mood12", mood12);
            in.putExtra("mood13", mood13);
            in.putExtra("mood14", mood14);
            in.putExtra("mood15", mood15);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize16(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();
        int service13 = smRating13.getRating();
        int service14 = smRating14.getRating();
        int service15 = smRating15.getRating();
        int service16 = smRating16.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service13 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(12), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service14 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(13), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service15 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(14), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service16 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(15), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceId4", serviceIdArr.get(3));
            in.putExtra("serviceId5", serviceIdArr.get(4));
            in.putExtra("serviceId6", serviceIdArr.get(5));
            in.putExtra("serviceId7", serviceIdArr.get(6));
            in.putExtra("serviceId8", serviceIdArr.get(7));
            in.putExtra("serviceId9", serviceIdArr.get(8));
            in.putExtra("serviceId10", serviceIdArr.get(9));
            in.putExtra("serviceId11", serviceIdArr.get(10));
            in.putExtra("serviceId12", serviceIdArr.get(11));
            in.putExtra("serviceId13", serviceIdArr.get(12));
            in.putExtra("serviceId14", serviceIdArr.get(13));
            in.putExtra("serviceId15", serviceIdArr.get(14));
            in.putExtra("serviceId16", serviceIdArr.get(15));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("serviceDesc4", serviceDescArr.get(3));
            in.putExtra("serviceDesc5", serviceDescArr.get(4));
            in.putExtra("serviceDesc6", serviceDescArr.get(5));
            in.putExtra("serviceDesc7", serviceDescArr.get(6));
            in.putExtra("serviceDesc8", serviceDescArr.get(7));
            in.putExtra("serviceDesc9", serviceDescArr.get(8));
            in.putExtra("serviceDesc10", serviceDescArr.get(9));
            in.putExtra("serviceDesc11", serviceDescArr.get(10));
            in.putExtra("serviceDesc12", serviceDescArr.get(11));
            in.putExtra("serviceDesc13", serviceDescArr.get(12));
            in.putExtra("serviceDesc14", serviceDescArr.get(13));
            in.putExtra("serviceDesc15", serviceDescArr.get(14));
            in.putExtra("serviceDesc16", serviceDescArr.get(15));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("rating4", serviceValue4);
            in.putExtra("rating5", serviceValue5);
            in.putExtra("rating6", serviceValue6);
            in.putExtra("rating7", serviceValue7);
            in.putExtra("rating8", serviceValue8);
            in.putExtra("rating9", serviceValue9);
            in.putExtra("rating10", serviceValue10);
            in.putExtra("rating11", serviceValue11);
            in.putExtra("rating12", serviceValue12);
            in.putExtra("rating13", serviceValue13);
            in.putExtra("rating14", serviceValue14);
            in.putExtra("rating15", serviceValue15);
            in.putExtra("rating16", serviceValue16);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("mood4", mood4);
            in.putExtra("mood5", mood5);
            in.putExtra("mood6", mood6);
            in.putExtra("mood7", mood7);
            in.putExtra("mood8", mood8);
            in.putExtra("mood9", mood9);
            in.putExtra("mood10", mood10);
            in.putExtra("mood11", mood11);
            in.putExtra("mood12", mood12);
            in.putExtra("mood13", mood13);
            in.putExtra("mood14", mood14);
            in.putExtra("mood15", mood15);
            in.putExtra("mood16", mood16);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize17(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();
        int service13 = smRating13.getRating();
        int service14 = smRating14.getRating();
        int service15 = smRating15.getRating();
        int service16 = smRating16.getRating();
        int service17 = smRating17.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service13 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(12), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service14 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(13), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service15 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(14), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service16 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(15), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service17 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(16), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceId4", serviceIdArr.get(3));
            in.putExtra("serviceId5", serviceIdArr.get(4));
            in.putExtra("serviceId6", serviceIdArr.get(5));
            in.putExtra("serviceId7", serviceIdArr.get(6));
            in.putExtra("serviceId8", serviceIdArr.get(7));
            in.putExtra("serviceId9", serviceIdArr.get(8));
            in.putExtra("serviceId10", serviceIdArr.get(9));
            in.putExtra("serviceId11", serviceIdArr.get(10));
            in.putExtra("serviceId12", serviceIdArr.get(11));
            in.putExtra("serviceId13", serviceIdArr.get(12));
            in.putExtra("serviceId14", serviceIdArr.get(13));
            in.putExtra("serviceId15", serviceIdArr.get(14));
            in.putExtra("serviceId16", serviceIdArr.get(15));
            in.putExtra("serviceId17", serviceIdArr.get(16));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("serviceDesc4", serviceDescArr.get(3));
            in.putExtra("serviceDesc5", serviceDescArr.get(4));
            in.putExtra("serviceDesc6", serviceDescArr.get(5));
            in.putExtra("serviceDesc7", serviceDescArr.get(6));
            in.putExtra("serviceDesc8", serviceDescArr.get(7));
            in.putExtra("serviceDesc9", serviceDescArr.get(8));
            in.putExtra("serviceDesc10", serviceDescArr.get(9));
            in.putExtra("serviceDesc11", serviceDescArr.get(10));
            in.putExtra("serviceDesc12", serviceDescArr.get(11));
            in.putExtra("serviceDesc13", serviceDescArr.get(12));
            in.putExtra("serviceDesc14", serviceDescArr.get(13));
            in.putExtra("serviceDesc15", serviceDescArr.get(14));
            in.putExtra("serviceDesc16", serviceDescArr.get(15));
            in.putExtra("serviceDesc17", serviceDescArr.get(16));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("rating4", serviceValue4);
            in.putExtra("rating5", serviceValue5);
            in.putExtra("rating6", serviceValue6);
            in.putExtra("rating7", serviceValue7);
            in.putExtra("rating8", serviceValue8);
            in.putExtra("rating9", serviceValue9);
            in.putExtra("rating10", serviceValue10);
            in.putExtra("rating11", serviceValue11);
            in.putExtra("rating12", serviceValue12);
            in.putExtra("rating13", serviceValue13);
            in.putExtra("rating14", serviceValue14);
            in.putExtra("rating15", serviceValue15);
            in.putExtra("rating16", serviceValue16);
            in.putExtra("rating17", serviceValue17);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("mood4", mood4);
            in.putExtra("mood5", mood5);
            in.putExtra("mood6", mood6);
            in.putExtra("mood7", mood7);
            in.putExtra("mood8", mood8);
            in.putExtra("mood9", mood9);
            in.putExtra("mood10", mood10);
            in.putExtra("mood11", mood11);
            in.putExtra("mood12", mood12);
            in.putExtra("mood13", mood13);
            in.putExtra("mood14", mood14);
            in.putExtra("mood15", mood15);
            in.putExtra("mood16", mood16);
            in.putExtra("mood17", mood17);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize18(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();
        int service13 = smRating13.getRating();
        int service14 = smRating14.getRating();
        int service15 = smRating15.getRating();
        int service16 = smRating16.getRating();
        int service17 = smRating17.getRating();
        int service18 = smRating18.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service13 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(12), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service14 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(13), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service15 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(14), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service16 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(15), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service17 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(16), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service18 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(17), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceId4", serviceIdArr.get(3));
            in.putExtra("serviceId5", serviceIdArr.get(4));
            in.putExtra("serviceId6", serviceIdArr.get(5));
            in.putExtra("serviceId7", serviceIdArr.get(6));
            in.putExtra("serviceId8", serviceIdArr.get(7));
            in.putExtra("serviceId9", serviceIdArr.get(8));
            in.putExtra("serviceId10", serviceIdArr.get(9));
            in.putExtra("serviceId11", serviceIdArr.get(10));
            in.putExtra("serviceId12", serviceIdArr.get(11));
            in.putExtra("serviceId13", serviceIdArr.get(12));
            in.putExtra("serviceId14", serviceIdArr.get(13));
            in.putExtra("serviceId15", serviceIdArr.get(14));
            in.putExtra("serviceId16", serviceIdArr.get(15));
            in.putExtra("serviceId17", serviceIdArr.get(16));
            in.putExtra("serviceId18", serviceIdArr.get(17));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("serviceDesc4", serviceDescArr.get(3));
            in.putExtra("serviceDesc5", serviceDescArr.get(4));
            in.putExtra("serviceDesc6", serviceDescArr.get(5));
            in.putExtra("serviceDesc7", serviceDescArr.get(6));
            in.putExtra("serviceDesc8", serviceDescArr.get(7));
            in.putExtra("serviceDesc9", serviceDescArr.get(8));
            in.putExtra("serviceDesc10", serviceDescArr.get(9));
            in.putExtra("serviceDesc11", serviceDescArr.get(10));
            in.putExtra("serviceDesc12", serviceDescArr.get(11));
            in.putExtra("serviceDesc13", serviceDescArr.get(12));
            in.putExtra("serviceDesc14", serviceDescArr.get(13));
            in.putExtra("serviceDesc15", serviceDescArr.get(14));
            in.putExtra("serviceDesc16", serviceDescArr.get(15));
            in.putExtra("serviceDesc17", serviceDescArr.get(16));
            in.putExtra("serviceDesc18", serviceDescArr.get(17));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("rating4", serviceValue4);
            in.putExtra("rating5", serviceValue5);
            in.putExtra("rating6", serviceValue6);
            in.putExtra("rating7", serviceValue7);
            in.putExtra("rating8", serviceValue8);
            in.putExtra("rating9", serviceValue9);
            in.putExtra("rating10", serviceValue10);
            in.putExtra("rating11", serviceValue11);
            in.putExtra("rating12", serviceValue12);
            in.putExtra("rating13", serviceValue13);
            in.putExtra("rating14", serviceValue14);
            in.putExtra("rating15", serviceValue15);
            in.putExtra("rating16", serviceValue16);
            in.putExtra("rating17", serviceValue17);
            in.putExtra("rating18", serviceValue18);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("mood4", mood4);
            in.putExtra("mood5", mood5);
            in.putExtra("mood6", mood6);
            in.putExtra("mood7", mood7);
            in.putExtra("mood8", mood8);
            in.putExtra("mood9", mood9);
            in.putExtra("mood10", mood10);
            in.putExtra("mood11", mood11);
            in.putExtra("mood12", mood12);
            in.putExtra("mood13", mood13);
            in.putExtra("mood14", mood14);
            in.putExtra("mood15", mood15);
            in.putExtra("mood16", mood16);
            in.putExtra("mood17", mood17);
            in.putExtra("mood18", mood18);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize19(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();
        int service13 = smRating13.getRating();
        int service14 = smRating14.getRating();
        int service15 = smRating15.getRating();
        int service16 = smRating16.getRating();
        int service17 = smRating17.getRating();
        int service18 = smRating18.getRating();
        int service19 = smRating19.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service13 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(12), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service14 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(13), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service15 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(14), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service16 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(15), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service17 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(16), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service18 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(17), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service19 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(18), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceId4", serviceIdArr.get(3));
            in.putExtra("serviceId5", serviceIdArr.get(4));
            in.putExtra("serviceId6", serviceIdArr.get(5));
            in.putExtra("serviceId7", serviceIdArr.get(6));
            in.putExtra("serviceId8", serviceIdArr.get(7));
            in.putExtra("serviceId9", serviceIdArr.get(8));
            in.putExtra("serviceId10", serviceIdArr.get(9));
            in.putExtra("serviceId11", serviceIdArr.get(10));
            in.putExtra("serviceId12", serviceIdArr.get(11));
            in.putExtra("serviceId13", serviceIdArr.get(12));
            in.putExtra("serviceId14", serviceIdArr.get(13));
            in.putExtra("serviceId15", serviceIdArr.get(14));
            in.putExtra("serviceId16", serviceIdArr.get(15));
            in.putExtra("serviceId17", serviceIdArr.get(16));
            in.putExtra("serviceId18", serviceIdArr.get(17));
            in.putExtra("serviceId19", serviceIdArr.get(18));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("serviceDesc4", serviceDescArr.get(3));
            in.putExtra("serviceDesc5", serviceDescArr.get(4));
            in.putExtra("serviceDesc6", serviceDescArr.get(5));
            in.putExtra("serviceDesc7", serviceDescArr.get(6));
            in.putExtra("serviceDesc8", serviceDescArr.get(7));
            in.putExtra("serviceDesc9", serviceDescArr.get(8));
            in.putExtra("serviceDesc10", serviceDescArr.get(9));
            in.putExtra("serviceDesc11", serviceDescArr.get(10));
            in.putExtra("serviceDesc12", serviceDescArr.get(11));
            in.putExtra("serviceDesc13", serviceDescArr.get(12));
            in.putExtra("serviceDesc14", serviceDescArr.get(13));
            in.putExtra("serviceDesc15", serviceDescArr.get(14));
            in.putExtra("serviceDesc16", serviceDescArr.get(15));
            in.putExtra("serviceDesc17", serviceDescArr.get(16));
            in.putExtra("serviceDesc18", serviceDescArr.get(17));
            in.putExtra("serviceDesc19", serviceDescArr.get(18));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("rating4", serviceValue4);
            in.putExtra("rating5", serviceValue5);
            in.putExtra("rating6", serviceValue6);
            in.putExtra("rating7", serviceValue7);
            in.putExtra("rating8", serviceValue8);
            in.putExtra("rating9", serviceValue9);
            in.putExtra("rating10", serviceValue10);
            in.putExtra("rating11", serviceValue11);
            in.putExtra("rating12", serviceValue12);
            in.putExtra("rating13", serviceValue13);
            in.putExtra("rating14", serviceValue14);
            in.putExtra("rating15", serviceValue15);
            in.putExtra("rating16", serviceValue16);
            in.putExtra("rating17", serviceValue17);
            in.putExtra("rating18", serviceValue18);
            in.putExtra("rating19", serviceValue19);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("mood4", mood4);
            in.putExtra("mood5", mood5);
            in.putExtra("mood6", mood6);
            in.putExtra("mood7", mood7);
            in.putExtra("mood8", mood8);
            in.putExtra("mood9", mood9);
            in.putExtra("mood10", mood10);
            in.putExtra("mood11", mood11);
            in.putExtra("mood12", mood12);
            in.putExtra("mood13", mood13);
            in.putExtra("mood14", mood14);
            in.putExtra("mood15", mood15);
            in.putExtra("mood16", mood16);
            in.putExtra("mood17", mood17);
            in.putExtra("mood18", mood18);
            in.putExtra("mood19", mood19);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void feedbackForSize20(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();
        int service13 = smRating13.getRating();
        int service14 = smRating14.getRating();
        int service15 = smRating15.getRating();
        int service16 = smRating16.getRating();
        int service17 = smRating17.getRating();
        int service18 = smRating18.getRating();
        int service19 = smRating19.getRating();
        int service20 = smRating20.getRating();

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service13 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(12), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service14 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(13), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service15 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(14), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service16 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(15), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service17 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(16), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service18 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(17), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service19 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(18), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service20 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(19), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), FeedbackActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("serviceId1", serviceIdArr.get(0));
            in.putExtra("serviceId2", serviceIdArr.get(1));
            in.putExtra("serviceId3", serviceIdArr.get(2));
            in.putExtra("serviceId4", serviceIdArr.get(3));
            in.putExtra("serviceId5", serviceIdArr.get(4));
            in.putExtra("serviceId6", serviceIdArr.get(5));
            in.putExtra("serviceId7", serviceIdArr.get(6));
            in.putExtra("serviceId8", serviceIdArr.get(7));
            in.putExtra("serviceId9", serviceIdArr.get(8));
            in.putExtra("serviceId10", serviceIdArr.get(9));
            in.putExtra("serviceId11", serviceIdArr.get(10));
            in.putExtra("serviceId12", serviceIdArr.get(11));
            in.putExtra("serviceId13", serviceIdArr.get(12));
            in.putExtra("serviceId14", serviceIdArr.get(13));
            in.putExtra("serviceId15", serviceIdArr.get(14));
            in.putExtra("serviceId16", serviceIdArr.get(15));
            in.putExtra("serviceId17", serviceIdArr.get(16));
            in.putExtra("serviceId18", serviceIdArr.get(17));
            in.putExtra("serviceId19", serviceIdArr.get(18));
            in.putExtra("serviceId20", serviceIdArr.get(19));
            in.putExtra("serviceDesc1", serviceDescArr.get(0));
            in.putExtra("serviceDesc2", serviceDescArr.get(1));
            in.putExtra("serviceDesc3", serviceDescArr.get(2));
            in.putExtra("serviceDesc4", serviceDescArr.get(3));
            in.putExtra("serviceDesc5", serviceDescArr.get(4));
            in.putExtra("serviceDesc6", serviceDescArr.get(5));
            in.putExtra("serviceDesc7", serviceDescArr.get(6));
            in.putExtra("serviceDesc8", serviceDescArr.get(7));
            in.putExtra("serviceDesc9", serviceDescArr.get(8));
            in.putExtra("serviceDesc10", serviceDescArr.get(9));
            in.putExtra("serviceDesc11", serviceDescArr.get(10));
            in.putExtra("serviceDesc12", serviceDescArr.get(11));
            in.putExtra("serviceDesc13", serviceDescArr.get(12));
            in.putExtra("serviceDesc14", serviceDescArr.get(13));
            in.putExtra("serviceDesc15", serviceDescArr.get(14));
            in.putExtra("serviceDesc16", serviceDescArr.get(15));
            in.putExtra("serviceDesc17", serviceDescArr.get(16));
            in.putExtra("serviceDesc18", serviceDescArr.get(17));
            in.putExtra("serviceDesc19", serviceDescArr.get(18));
            in.putExtra("serviceDesc20", serviceDescArr.get(19));
            in.putExtra("rating1", serviceValue1);
            in.putExtra("rating2", serviceValue2);
            in.putExtra("rating3", serviceValue3);
            in.putExtra("rating4", serviceValue4);
            in.putExtra("rating5", serviceValue5);
            in.putExtra("rating6", serviceValue6);
            in.putExtra("rating7", serviceValue7);
            in.putExtra("rating8", serviceValue8);
            in.putExtra("rating9", serviceValue9);
            in.putExtra("rating10", serviceValue10);
            in.putExtra("rating11", serviceValue11);
            in.putExtra("rating12", serviceValue12);
            in.putExtra("rating13", serviceValue13);
            in.putExtra("rating14", serviceValue14);
            in.putExtra("rating15", serviceValue15);
            in.putExtra("rating16", serviceValue16);
            in.putExtra("rating17", serviceValue17);
            in.putExtra("rating18", serviceValue18);
            in.putExtra("rating19", serviceValue19);
            in.putExtra("rating20", serviceValue20);
            in.putExtra("mood1", mood1);
            in.putExtra("mood2", mood2);
            in.putExtra("mood3", mood3);
            in.putExtra("mood4", mood4);
            in.putExtra("mood5", mood5);
            in.putExtra("mood6", mood6);
            in.putExtra("mood7", mood7);
            in.putExtra("mood8", mood8);
            in.putExtra("mood9", mood9);
            in.putExtra("mood10", mood10);
            in.putExtra("mood11", mood11);
            in.putExtra("mood12", mood12);
            in.putExtra("mood13", mood13);
            in.putExtra("mood14", mood14);
            in.putExtra("mood15", mood15);
            in.putExtra("mood16", mood16);
            in.putExtra("mood17", mood17);
            in.putExtra("mood18", mood18);
            in.putExtra("mood19", mood19);
            in.putExtra("mood20", mood20);
            in.putExtra("timing", timing);
            in.putExtra("serviceSize", String.valueOf(serviceIdArr.size()));
            startActivity(in);
            finish();
        }
    }

    public void controlInit(){
        smRating1 = findViewById(R.id.serviceRating1);
        smRating2 = findViewById(R.id.serviceRating2);
        smRating3 = findViewById(R.id.serviceRating3);
        smRating4 = findViewById(R.id.serviceRating4);
        smRating5 = findViewById(R.id.serviceRating5);
        smRating6 = findViewById(R.id.serviceRating6);
        smRating7 = findViewById(R.id.serviceRating7);
        smRating8 = findViewById(R.id.serviceRating8);
        smRating9 = findViewById(R.id.serviceRating9);
        smRating10 = findViewById(R.id.serviceRating10);
        smRating11 = findViewById(R.id.serviceRating11);
        smRating12 = findViewById(R.id.serviceRating12);
        smRating13 = findViewById(R.id.serviceRating13);
        smRating14 = findViewById(R.id.serviceRating14);
        smRating15 = findViewById(R.id.serviceRating15);
        smRating16= findViewById(R.id.serviceRating16);
        smRating17 = findViewById(R.id.serviceRating17);
        smRating18 = findViewById(R.id.serviceRating18);
        smRating19 = findViewById(R.id.serviceRating19);
        smRating20 = findViewById(R.id.serviceRating20);
    }

    public void submitForSize1(){
        int service1 = smRating1.getRating();

        moodArray.add(mood1);

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        } else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize2(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();

        moodArray.add(mood1);
        moodArray.add(mood2);

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        } else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize3(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating2.getRating();

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        } else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize4(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize5(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        } else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize6(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        } else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize7(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);
        moodArray.add(mood7);

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize8(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);
        moodArray.add(mood7);
        moodArray.add(mood8);

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize9(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();

        moodArray.add(mood1);
        moodArray.add(mood2);
        moodArray.add(mood3);
        moodArray.add(mood4);
        moodArray.add(mood5);
        moodArray.add(mood6);
        moodArray.add(mood7);
        moodArray.add(mood8);
        moodArray.add(mood9);

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize10(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();

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

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize11(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();

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

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize12(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();

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

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize13(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();
        int service13 = smRating13.getRating();

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

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service13 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(12), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize14(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();
        int service13 = smRating13.getRating();
        int service14 = smRating14.getRating();

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

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service13 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(12), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service14 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(13), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize15(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();
        int service13 = smRating13.getRating();
        int service14 = smRating14.getRating();
        int service15 = smRating15.getRating();

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

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service13 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(12), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service14 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(13), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service15 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(14), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize16(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();
        int service13 = smRating13.getRating();
        int service14 = smRating14.getRating();
        int service15 = smRating15.getRating();
        int service16 = smRating16.getRating();

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

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service13 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(12), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service14 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(13), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service15 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(14), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service16 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(15), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize17(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();
        int service13 = smRating13.getRating();
        int service14 = smRating14.getRating();
        int service15 = smRating15.getRating();
        int service16 = smRating16.getRating();
        int service17 = smRating17.getRating();

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

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service13 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(12), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service14 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(13), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service15 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(14), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service16 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(15), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service17 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(16), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize18(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();
        int service13 = smRating13.getRating();
        int service14 = smRating14.getRating();
        int service15 = smRating15.getRating();
        int service16 = smRating16.getRating();
        int service17 = smRating17.getRating();
        int service18 = smRating18.getRating();

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

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service13 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(12), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service14 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(13), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service15 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(14), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service16 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(15), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service17 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(16), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service18 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(17), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize19(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();
        int service13 = smRating13.getRating();
        int service14 = smRating14.getRating();
        int service15 = smRating15.getRating();
        int service16 = smRating16.getRating();
        int service17 = smRating17.getRating();
        int service18 = smRating18.getRating();
        int service19 = smRating19.getRating();

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

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service13 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(12), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service14 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(13), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service15 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(14), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service16 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(15), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service17 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(16), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service18 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(17), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service19 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(18), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public void submitForSize20(){
        int service1 = smRating1.getRating();
        int service2 = smRating2.getRating();
        int service3 = smRating3.getRating();
        int service4 = smRating4.getRating();
        int service5 = smRating5.getRating();
        int service6 = smRating6.getRating();
        int service7 = smRating7.getRating();
        int service8 = smRating8.getRating();
        int service9 = smRating9.getRating();
        int service10 = smRating10.getRating();
        int service11 = smRating11.getRating();
        int service12 = smRating12.getRating();
        int service13 = smRating13.getRating();
        int service14 = smRating14.getRating();
        int service15 = smRating15.getRating();
        int service16 = smRating16.getRating();
        int service17 = smRating17.getRating();
        int service18 = smRating18.getRating();
        int service19 = smRating19.getRating();
        int service20 = smRating20.getRating();

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

        if (service1 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(0), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service2 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service3 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service4 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(3), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service5 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(4), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service6 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(5), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service7 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(6), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service8 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(7), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service9 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(8), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service10 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(9), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service11 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(10), Toast.LENGTH_SHORT).show();
            return;
        }
        if (service12 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(11), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service13 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(12), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service14 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(13), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service15 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(14), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service16 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(15), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service17 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(16), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service18 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(17), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service19 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(18), Toast.LENGTH_SHORT).show();
            return;
        }

        if (service20 == 0) {
            Toast.makeText(RatingActivity.this, "Kindly rate our " + serviceDescArr.get(19), Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            Intent in = new Intent(getApplicationContext(), ThankyouActivity.class);
            in.putExtra("catId", catId);
            in.putExtra("catDesc", catDesc);
            in.putExtra("timing", timing);
            in.putStringArrayListExtra("serviceDescArray", (ArrayList<String>) serviceDescArr);
            in.putStringArrayListExtra("moodArray", (ArrayList<String>) moodArray);
            in.putStringArrayListExtra("feedbackDescArray", (ArrayList<String>) feedbackDescArray);
            startActivity(in);
            finish();
        }
    }

    public class AsyncSoapClass extends AsyncTask<String, Void, String> {

        ProgressDialog pd = new ProgressDialog(RatingActivity.this);

        public AsyncResponse delegate = null;

        public AsyncSoapClass(AsyncResponse asyncResponse) {
            delegate = asyncResponse;//Assigning call back interfacethrough constructor
        }

        @Override
        protected void onPreExecute() {
            pd.setMessage("loading");
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {

            String SOAP_ACTION = "http://apps.visualsolutions.work/ServiceOfServes";
            String METHOD_NAME = "ServiceOfServes";
            String NAMESPACE = "http://apps.visualsolutions.work/";
            String URL = "http://androidwebservice.somee.com/WebService.asmx?WSDL";

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

            PropertyInfo pi = new PropertyInfo();
            pi.setName("ServiceDescription");
            pi.setValue(catDesc);
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

    public void r1RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r1 == 1 || r1 == 2) {
            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r1 == 3 || r1 == 4 || r1 == 5) {

            if (r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }

        }
    }

    public void r2RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r2 == 1 || r2 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r2 == 3 || r2 == 4 || r2 == 5) {

            if (r1 == 1 || r1 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r3RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r3 == 1 || r3 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r3 == 3 || r3 == 4 || r3 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r4RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r4 == 1 || r4 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }
            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r4 == 3 || r4 == 4 || r4 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r5RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r5 == 1 || r5 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }
            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }


        } else if (r5 == 3 || r5 == 4 || r5 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r6RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r6 == 1 || r6 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r6 == 3 || r6 == 4 || r6 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r7RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r7 == 1 || r7 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r7 == 3 || r7 == 4 || r7 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r8RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r8 == 1 || r8 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r8 == 3 || r8 == 4 || r8 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r9RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r9 == 1 || r9 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r9 == 3 || r9 == 4 || r9 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r10RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r10 == 1 || r10 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r10 == 3 || r10 == 4 || r10 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r11RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r11 == 1 || r11 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r11 == 3 || r11 == 4 || r11 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r12RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r12 == 1 || r12 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r12 == 3 || r12 == 4 || r12 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r13RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r13 == 1 || r13 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r13 == 3 || r13 == 4 || r13 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r14RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r14 == 1 || r14 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r14 == 3 || r14 == 4 || r14 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r15RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r15 == 1 || r15 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r15 == 3 || r15 == 4 || r15 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r16RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r16 == 1 || r16 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r16 == 3 || r16 == 4 || r16 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r17RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r17 == 1 || r17 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r17 == 3 || r17 == 4 || r17 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r18RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r18 == 1 || r18 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r18 == 3 || r18 == 4 || r18 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r19 == 1 || r19 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r19RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r19 == 1 || r19 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r20 == 0 || r20 == 1 || r20 == 2 || r20 == 3 || r20 == 4 || r20 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r19 == 3 || r19 == 4 || r19 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r20 == 1 || r20 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public void r20RatingSelected(int val)
    {
        r1 = smRating1.getRating();
        r2 = smRating2.getRating();
        r3 = smRating3.getRating();
        r4 = smRating4.getRating();
        r5 = smRating5.getRating();
        r6 = smRating6.getRating();
        r7 = smRating6.getRating();
        r8 = smRating6.getRating();
        r9 = smRating6.getRating();
        r10 = smRating6.getRating();
        r11 = smRating6.getRating();
        r12 = smRating6.getRating();
        r13 = smRating6.getRating();
        r14 = smRating6.getRating();
        r15 = smRating6.getRating();
        r16 = smRating6.getRating();
        r17 = smRating6.getRating();
        r18 = smRating6.getRating();
        r19 = smRating6.getRating();
        r20 = smRating6.getRating();

        if (r20 == 1 || r20 == 2) {
            if (r1 == 0 || r1 == 1 || r1 == 2 || r1 == 3 || r1 == 4 || r1 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r2 == 0 || r2 == 1 || r2 == 2 || r2 == 3 || r2 == 4 || r2 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r3 == 0 || r3 == 1 || r3 == 2 || r3 == 3 || r3 == 4 || r3 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r4 == 0 || r4 == 1 || r4 == 2 || r4 == 3 || r4 == 4 || r4 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r5 == 0 || r5 == 1 || r5 == 2 || r5 == 3 || r5 == 4 || r5 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r6 == 0 || r6 == 1 || r6 == 2 || r6 == 3 || r6 == 4 || r6 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r7 == 0 || r7 == 1 || r7 == 2 || r7 == 3 || r7 == 4 || r7 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r8 == 0 || r8 == 1 || r8 == 2 || r8 == 3 || r8 == 4 || r8 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r9 == 0 || r9 == 1 || r9 == 2 || r9 == 3 || r9 == 4 || r9 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r10 == 0 || r10 == 1 || r10 == 2 || r10 == 3 || r10 == 4 || r10 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r11 == 0 || r11 == 1 || r11 == 2 || r11 == 3 || r11 == 4 || r11 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r12 == 0 || r12 == 1 || r12 == 2 || r12 == 3 || r12 == 4 || r12 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r13 == 0 || r13 == 1 || r13 == 2 || r13 == 3 || r13 == 4 || r13 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r14 == 0 || r14 == 1 || r14 == 2 || r14 == 3 || r14 == 4 || r14 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r15 == 0 || r15 == 1 || r15 == 2 || r15 == 3 || r15 == 4 || r15 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r16 == 0 || r16 == 1 || r16 == 2 || r16 == 3 || r16 == 4 || r16 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r17 == 0 || r17 == 1 || r17 == 2 || r17 == 3 || r17 == 4 || r17 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r18 == 0 || r18 == 1 || r18 == 2 || r18 == 3 || r18 == 4 || r18 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

            if (r19 == 0 || r19 == 1 || r19 == 2 || r19 == 3 || r19 == 4 || r19 == 5) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            }

        } else if (r20 == 3 || r20 == 4 || r20 == 5) {

            if (r1 == 1 || r1 == 2 || r2 == 1 || r2 == 2 || r3 == 1 || r3 == 2 || r4 == 1 || r4 == 2 || r5 == 1 || r5 == 2 || r6 == 1 || r6 == 2 || r7 == 1 || r7 == 2 || r8 == 1 || r8 == 2 || r9 == 1 || r9 == 2 || r10 == 1 || r10 == 2 || r11 == 1 || r11 == 2 || r12 == 1 || r12 == 2 || r13 == 1 || r13 == 2 || r14 == 1 || r14 == 2 || r15 == 1 || r15 == 2 || r16 == 1 || r16 == 2 || r17 == 1 || r17 == 2 || r18 == 1 || r18 == 2 || r19 == 1 || r19 == 2) {
                serviceFeedbackBtn.setVisibility(View.VISIBLE);
                serviceSubmitBtn.setVisibility(View.GONE);
            } else {
                serviceSubmitBtn.setVisibility(View.VISIBLE);
                serviceFeedbackBtn.setVisibility(View.GONE);
            }
        }
    }

    public String getR1Rating(String value) {
        r1 = smRating1.getRating();


        if (r1 == 1) {
            value = "Terrible";
        }

        if (r1 == 2) {
            value = "Bad";
        }

        if (r1 == 3) {
            value = "Okay";
        }

        if (r1 == 4) {
            value = "Good";
        }

        if (r1 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR2Rating(String value) {
        r2 = smRating2.getRating();


        if (r2 == 1) {
            value = "Terrible";
        }

        if (r2 == 2) {
            value = "Bad";
        }

        if (r2 == 3) {
            value = "Okay";
        }

        if (r2 == 4) {
            value = "Good";
        }

        if (r2 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR3Rating(String value) {
        r3 = smRating3.getRating();


        if (r3 == 1) {
            value = "Terrible";
        }

        if (r3 == 2) {
            value = "Bad";
        }

        if (r3 == 3) {
            value = "Okay";
        }

        if (r3 == 4) {
            value = "Good";
        }

        if (r3 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR4Rating(String value) {
        r4 = smRating4.getRating();


        if (r4 == 1) {
            value = "Terrible";
        }

        if (r4 == 2) {
            value = "Bad";
        }

        if (r4 == 3) {
            value = "Okay";
        }

        if (r4 == 4) {
            value = "Good";
        }

        if (r4 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR5Rating(String value) {
        r5 = smRating5.getRating();


        if (r5 == 1) {
            value = "Terrible";
        }

        if (r5 == 2) {
            value = "Bad";
        }

        if (r5 == 3) {
            value = "Okay";
        }

        if (r5 == 4) {
            value = "Good";
        }

        if (r5 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR6Rating(String value) {
        r6 = smRating6.getRating();


        if (r6 == 1) {
            value = "Terrible";
        }

        if (r6 == 2) {
            value = "Bad";
        }

        if (r6 == 3) {
            value = "Okay";
        }

        if (r6 == 4) {
            value = "Good";
        }

        if (r6 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR7Rating(String value) {
        r7 = smRating7.getRating();


        if (r7 == 1) {
            value = "Terrible";
        }

        if (r7 == 2) {
            value = "Bad";
        }

        if (r7 == 3) {
            value = "Okay";
        }

        if (r7 == 4) {
            value = "Good";
        }

        if (r7 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR8Rating(String value) {
        r8 = smRating8.getRating();


        if (r8 == 1) {
            value = "Terrible";
        }

        if (r8 == 2) {
            value = "Bad";
        }

        if (r8 == 3) {
            value = "Okay";
        }

        if (r8 == 4) {
            value = "Good";
        }

        if (r8 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR9Rating(String value) {
        r9 = smRating9.getRating();


        if (r9 == 1) {
            value = "Terrible";
        }

        if (r9 == 2) {
            value = "Bad";
        }

        if (r9 == 3) {
            value = "Okay";
        }

        if (r9 == 4) {
            value = "Good";
        }

        if (r9 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR10Rating(String value) {
        r10 = smRating10.getRating();


        if (r10 == 1) {
            value = "Terrible";
        }

        if (r10 == 2) {
            value = "Bad";
        }

        if (r10 == 3) {
            value = "Okay";
        }

        if (r10 == 4) {
            value = "Good";
        }

        if (r10 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR11Rating(String value) {
        r11 = smRating11.getRating();


        if (r11 == 1) {
            value = "Terrible";
        }

        if (r11 == 2) {
            value = "Bad";
        }

        if (r11 == 3) {
            value = "Okay";
        }

        if (r11 == 4) {
            value = "Good";
        }

        if (r11 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR12Rating(String value) {
        r12 = smRating12.getRating();


        if (r12 == 1) {
            value = "Terrible";
        }

        if (r12 == 2) {
            value = "Bad";
        }

        if (r12 == 3) {
            value = "Okay";
        }

        if (r12 == 4) {
            value = "Good";
        }

        if (r12 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR13Rating(String value) {
        r13 = smRating13.getRating();


        if (r13 == 1) {
            value = "Terrible";
        }

        if (r13 == 2) {
            value = "Bad";
        }

        if (r13 == 3) {
            value = "Okay";
        }

        if (r13 == 4) {
            value = "Good";
        }

        if (r13 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR14Rating(String value) {
        r14 = smRating14.getRating();


        if (r14 == 1) {
            value = "Terrible";
        }

        if (r14 == 2) {
            value = "Bad";
        }

        if (r14 == 3) {
            value = "Okay";
        }

        if (r14 == 4) {
            value = "Good";
        }

        if (r14 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR15Rating(String value) {
        r15 = smRating15.getRating();


        if (r15 == 1) {
            value = "Terrible";
        }

        if (r15 == 2) {
            value = "Bad";
        }

        if (r15 == 3) {
            value = "Okay";
        }

        if (r15 == 4) {
            value = "Good";
        }

        if (r15 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR16Rating(String value) {
        r16 = smRating16.getRating();


        if (r16 == 1) {
            value = "Terrible";
        }

        if (r16 == 2) {
            value = "Bad";
        }

        if (r16 == 3) {
            value = "Okay";
        }

        if (r16 == 4) {
            value = "Good";
        }

        if (r16 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR17Rating(String value) {
        r17 = smRating17.getRating();


        if (r17 == 1) {
            value = "Terrible";
        }

        if (r17 == 2) {
            value = "Bad";
        }

        if (r17 == 3) {
            value = "Okay";
        }

        if (r17 == 4) {
            value = "Good";
        }

        if (r17 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR18Rating(String value) {
        r18 = smRating18.getRating();


        if (r18 == 1) {
            value = "Terrible";
        }

        if (r18 == 2) {
            value = "Bad";
        }

        if (r18 == 3) {
            value = "Okay";
        }

        if (r18 == 4) {
            value = "Good";
        }

        if (r18 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR19Rating(String value) {
        r19 = smRating19.getRating();


        if (r19 == 1) {
            value = "Terrible";
        }

        if (r19 == 2) {
            value = "Bad";
        }

        if (r19 == 3) {
            value = "Okay";
        }

        if (r19 == 4) {
            value = "Good";
        }

        if (r19 == 5) {
            value = "Great";
        }

        return value;

    }

    public String getR20Rating(String value) {
        r20 = smRating20.getRating();


        if (r20 == 1) {
            value = "Terrible";
        }

        if (r20 == 2) {
            value = "Bad";
        }

        if (r20 == 3) {
            value = "Okay";
        }

        if (r20 == 4) {
            value = "Good";
        }

        if (r20 == 5) {
            value = "Great";
        }

        return value;

    }

}
