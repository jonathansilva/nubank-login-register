package app.project.loginregister.ui.activity.splash;

import javax.inject.Inject;

public class SplashPresenter implements SplashContract.SplashPresenter {
    private SplashContract.SplashView view;
    private SplashContract.SplashModel model;

    @Inject
    SplashPresenter(SplashContract.SplashModel model) {
        this.model = model;

        model.setPresenter(this);
    }

    @Override
    public void setView(SplashContract.SplashView view) {
        this.view = view;

        initPresenter();
    }

    private void initPresenter() {
        view.initView();
    }

    @Override
    public void callSession() {
        model.getSession();
    }

    @Override
    public void openHome() {
        view.openHome();
    }

    @Override
    public void openDashboard() {
        view.openDashboard();
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }
}
