package app.project.loginregister.ui.activity.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import app.project.loginregister.R;
import app.project.loginregister.ui.activity.dashboard.DashboardView;
import app.project.loginregister.ui.activity.home.HomeView;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class SplashView extends AppCompatActivity implements SplashContract.SplashView, HasActivityInjector {
    public Intent intent;

    @Inject
    SplashContract.SplashPresenter presenter;

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        presenter.setView(this);
    }

    @Override
    public void initView() {
        presenter.callSession();
    }

    @Override
    public void openHome() {
        intent = new Intent(SplashView.this, HomeView.class);
        startActivity(intent);
        SplashView.this.finish();
    }

    @Override
    public void openDashboard() {
        intent = new Intent(SplashView.this, DashboardView.class);
        startActivity(intent);
        SplashView.this.finish();

        overridePendingTransition(0, 0);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
