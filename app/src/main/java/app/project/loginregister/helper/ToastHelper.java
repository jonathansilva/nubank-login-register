package app.project.loginregister.helper;

import android.app.Activity;
import android.widget.Toast;

public class ToastHelper {
    public static void alert(String message, Activity activity) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
    }
}
