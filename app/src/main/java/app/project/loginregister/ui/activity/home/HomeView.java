package app.project.loginregister.ui.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import app.project.loginregister.R;
import app.project.loginregister.ui.activity.login.LoginView;
import app.project.loginregister.ui.activity.register.RegisterView;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class HomeView extends AppCompatActivity implements HomeContract.HomeView, HasSupportFragmentInjector {
    public Intent intent;

    @Inject
    HomeContract.HomePresenter presenter;

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
        setContentView(R.layout.activity_home);

        presenter.setView(this);
    }

    protected void onStart() {
        super.onStart();

        Window window = getWindow(); window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    @Override
    public void initView() {
        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(login);

        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(register);
    }

    private View.OnClickListener login = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.callLogin();
        }
    };

    private View.OnClickListener register = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.callRegister();
        }
    };

    @Override
    public void openLogin() {
        intent = new Intent(HomeView.this, LoginView.class);
        startActivity(intent);
        HomeView.this.finish();
    }

    @Override
    public void openRegister() {
        intent = new Intent(HomeView.this, RegisterView.class);
        startActivity(intent);
        HomeView.this.finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
