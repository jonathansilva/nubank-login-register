package app.project.loginregister.helper;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

import com.google.android.material.textfield.TextInputEditText;

public class KeyboardToggleHelper {
    public static void toggle(Activity activity, TextInputEditText et_search){
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm != null) {
            if (imm.isActive()) {
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0); // hide
            } else if(!imm.isActive() && et_search != null) {
                imm.showSoftInput(et_search, InputMethodManager.SHOW_IMPLICIT);
            } else {
                imm.toggleSoftInput(0, InputMethodManager.HIDE_IMPLICIT_ONLY); // show
            }
        }
    }
}
