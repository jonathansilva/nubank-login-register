package app.project.loginregister.ui.activity.dashboard;

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
import app.project.loginregister.ui.activity.home.HomeView;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class DashboardView extends AppCompatActivity implements DashboardContract.DashboardView, HasSupportFragmentInjector {
    public Intent intent;

    @Inject
    DashboardContract.DashboardPresenter presenter;

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
        setContentView(R.layout.activity_dashboard);

        presenter.setView(this);
    }

    protected void onStart() {
        super.onStart();

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    @Override
    public void initView() {
        Button btn_logout = findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(logout);
    }

    private View.OnClickListener logout = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.callLogout();
        }
    };

    @Override
    public void openHome() {
        intent = new Intent(DashboardView.this, HomeView.class);
        startActivity(intent);
        DashboardView.this.finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}