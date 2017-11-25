package com.bluehomestudio.progresswindowdemo;

import android.app.Application;
import android.graphics.Color;

import com.bluehomestudio.progresswindow.ProgressWindow;
import com.bluehomestudio.progresswindow.ProgressWindowConfiguration;

/**
 * Created by mohamedmoamen on 11/25/17.
 */

public class ProgressWindowApplication extends Application {
    private ProgressWindow progressWindow ;
    private static ProgressWindowApplication instance  ;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this ;

        progressConfigurations();
    }

    public static ProgressWindowApplication getInstance(){
        return instance ;
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

}
