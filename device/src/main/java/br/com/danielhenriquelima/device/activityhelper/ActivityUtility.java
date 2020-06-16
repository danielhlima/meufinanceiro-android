package br.com.danielhenriquelima.device.activityhelper;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;



public class ActivityUtility {

    private static final Object LOCK = new Object();
    private static ActivityUtility instance;

    private ActivityUtility(){}

    public static ActivityUtility getInstance(){
        if(instance == null){
            synchronized (LOCK){
                instance = new ActivityUtility();
            }
        }
        return instance;
    }


    public void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
}
