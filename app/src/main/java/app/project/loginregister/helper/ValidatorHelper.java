package app.project.loginregister.helper;

import android.text.TextUtils;

public class ValidatorHelper {
    public static boolean isEmail(String string) {
        return PatternHelper.pattern("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", string);
    }

    public static boolean isPassword(String string) {
        return PatternHelper.pattern("\\b[a-zA-Z0-9@#$%!*\\.\\-_]{3,}\\b", string); // ((?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%!]).{8,})
    }

    public static boolean isEmpty(String string) {
        return TextUtils.isEmpty(string);
    }

    public static boolean isPhone(String string) {
        return PatternHelper.pattern("^\\([1-9]{2}\\) [2-9][0-9]{3,4}\\-[0-9]{4}$", string);
    }
}
