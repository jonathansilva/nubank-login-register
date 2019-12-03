package app.project.loginregister.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import javax.inject.Inject;

import app.project.loginregister.model.User;

public class Session {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private static final int PRIVATE_MODE = 0;

    @Inject
    public Session(Context context) {
        pref = context.getSharedPreferences("pref", PRIVATE_MODE);
        editor = pref.edit();
        editor.apply();
    }

    public void setLogin(User user) {
        editor.putString(encrypt("token"), encrypt(user.getToken()));
        editor.putBoolean("logged", true);
        editor.commit();
    }

    public String getToken() {
        return pref.getString("token", null);
    }

    public boolean isLoggedIn() {
        return pref.getBoolean("logged", false);
    }

    public void logout() {
        editor.clear();
        editor.commit();
    }

    private static String encrypt(String input) {
        return Base64.encodeToString(input.getBytes(), Base64.DEFAULT);
    }

    private static String decrypt(String input) {
        return new String(Base64.decode(input, Base64.DEFAULT));
    }
}
