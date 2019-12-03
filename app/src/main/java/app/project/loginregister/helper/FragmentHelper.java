package app.project.loginregister.helper;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import app.project.loginregister.R;

public class FragmentHelper {
    public static void load(Fragment fragment, boolean addToBackStack, Bundle args, Activity activity) {
        fragment.setArguments(args);
        FragmentTransaction transaction = ((AppCompatActivity) activity).getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.up, R.anim.down, R.anim.right_to_left, R.anim.left_to_right);
        transaction.replace(R.id.fragment_container, fragment);

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
