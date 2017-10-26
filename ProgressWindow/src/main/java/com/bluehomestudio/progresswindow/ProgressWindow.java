package com.bluehomestudio.progresswindow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

/**
 * Created by mohamedmoamen on 10/26/17.
 */

public class ProgressWindow {
    private static ProgressWindow instance = null;
    private Context mContext;

    private WindowManager windowManager;
    private WindowManager.LayoutParams layoutParams;
    private View progressLayout;

    /**
     * Private constructor to single-tone class
     *
     * @param context caller context
     */
    private ProgressWindow(Context context) {
        mContext = context;
        setupView();
    }

    /**
     * Static method to avoid multi instance from dialog
     *
     * @param context caller context
     * @return dialog reference
     */
    public static ProgressWindow getInstance(Context context) {

        synchronized (ProgressWindow.class) {

            if (instance == null) {
                instance = new ProgressWindow(context);
            }
        }

        return instance;
    }

    private ProgressBar mainProgress;
    private LinearLayout mainLayout;


    /**
     * Function to setup component view
     */
    private void setupView() {

        DisplayMetrics metrics = new DisplayMetrics();
        windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        progressLayout = LayoutInflater.from(mContext).inflate(R.layout.view_progress_window, null);

        mainProgress = progressLayout.findViewById(R.id.pb_main_progress);
        mainProgress.getIndeterminateDrawable().setColorFilter(Color.WHITE,
                android.graphics.PorterDuff.Mode.MULTIPLY);

        mainLayout = progressLayout.findViewById(R.id.ll_main_layout);
        mainLayout.setBackgroundColor(Color.TRANSPARENT);

        layoutParams = new WindowManager.LayoutParams(
                metrics.widthPixels, metrics.heightPixels,
                WindowManager.LayoutParams.TYPE_TOAST,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
        );
        layoutParams.gravity = Gravity.CENTER;
    }


    /**
     * Function to update component configuration
     *
     * @param progressWindowConfiguration progress configuration
     */
    public void setConfiguration(ProgressWindowConfiguration progressWindowConfiguration) {

        if (progressWindowConfiguration == null) {
            Log.e(ProgressWindow.class.getName()
                    , mContext.getString(R.string.null_configuration_error));
            return;
        }

        mainProgress.getIndeterminateDrawable().setColorFilter(progressWindowConfiguration.progressColor,
                android.graphics.PorterDuff.Mode.MULTIPLY);
        mainLayout.setBackgroundColor(progressWindowConfiguration.backgroundColor);
    }

    /**
     * Function to show progress
     */
    public void showProgress() {
        windowManager.addView(progressLayout, layoutParams);
    }

    /**
     * Function to hide progress
     */
    public void hideProgress() {
        windowManager.removeViewImmediate(progressLayout);
    }


}
