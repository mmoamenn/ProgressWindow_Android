package com.bluehomestudio.progresswindowdemo;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.bluehomestudio.progresswindow.ProgressWindow;
import com.bluehomestudio.progresswindow.ProgressWindowConfiguration;

public class MainActivity extends AppCompatActivity {
    private  ProgressWindow progressWindow ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressWindow = ProgressWindow.getInstance(this);
        ProgressWindowConfiguration progressWindowConfiguration = new ProgressWindowConfiguration();
        progressWindowConfiguration.backgroundColor = Color.TRANSPARENT ;
        progressWindowConfiguration.progressColor = Color.WHITE ;
        progressWindow.setConfiguration(progressWindowConfiguration);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressWindow.showProgress();
            }
        } , 1000) ;


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressWindow.hideProgress();
            }
        } , 8000) ;

    }
}
