package app.project.loginregister.ui.activity.login;

import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import app.project.loginregister.R;
import app.project.loginregister.helper.FragmentHelper;
import app.project.loginregister.ui.activity.home.HomeView;
import app.project.loginregister.ui.fragment.login.phone.PhoneLoginView;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class LoginView extends AppCompatActivity implements LoginContract.LoginView, HasSupportFragmentInjector {

    @Inject
    LoginContract.LoginPresenter presenter;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_login_register);

        presenter.setView(this);
    }

    @Override
    public void initView() {
        FragmentHelper.load(new PhoneLoginView(), true, new Bundle(), this);
    }

    @Override
    public void openHome() {
        Intent intent = new Intent(this, HomeView.class);
        startActivity(intent);
        LoginView.this.finish();
    }

    @Override
    public void popBackStack() {
        getFragmentManager().popBackStack();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        int count = getSupportFragmentManager().getBackStackEntryCount();
        presenter.onBackPressed(count);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
