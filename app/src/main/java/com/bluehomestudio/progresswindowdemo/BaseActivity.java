package com.bluehomestudio.progresswindowdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bluehomestudio.progresswindow.ProgressWindow;
import com.bluehomestudio.progresswindow.ProgressWindowConfiguration;

/**
 * Created by mohamedmoamen on 11/25/17.
 */

public class BaseActivity extends AppCompatActivity {
    private ProgressWindow progressWindow ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressConfigurations();
    }

    /**
     * Function to set main configuration
     */
    private void progressConfigurations(){
        progressWindow = ProgressWindow.getInstance(this);
        ProgressWindowConfiguration progressWindowConfiguration = new ProgressWindowConfiguration();
        progressWindowConfiguration.backgroundColor = Color.parseColor("#32000000") ;
        progressWindowConfiguration.progressColor = Color.WHITE ;
        progressWindow.setConfiguration(progressWindowConfiguration);
    }

    /**
     * Function to show progress
     */
    public void showProgress(){
        progressWindow.showProgress();
    }

    /**
     * Function to hide progress
     */
    public void hideProgress(){
        progressWindow.hideProgress();
    }

    @Override
    protected void onPause() {
        super.onPause();

        hideProgress();
    }
}
