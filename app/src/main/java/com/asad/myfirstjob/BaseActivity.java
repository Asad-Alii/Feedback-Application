package com.asad.myfirstjob;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class BaseActivity extends AppCompatActivity {

    private final static int NO_THEME = 1;
    private final static int THEME_BLUE = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateTheme();

    }
    public void updateTheme() {
        if (Utility.getTheme(getApplicationContext()) <= NO_THEME) {
            setTheme(R.style.nobar);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
            }
        } else if (Utility.getTheme(getApplicationContext()) == THEME_BLUE) {
            setTheme(R.style.NewTheme_Blue);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.accent_material_light));
                //getWindow().setBackgroundDrawableResource(R.drawable.bg_with_header);
            }
        }
    }
}
