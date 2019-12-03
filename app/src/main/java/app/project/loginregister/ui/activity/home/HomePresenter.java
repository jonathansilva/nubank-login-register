package app.project.loginregister.ui.activity.home;

import javax.inject.Inject;

public class HomePresenter implements HomeContract.HomePresenter {
    private HomeContract.HomeView view;

    @Inject
    HomePresenter() {}

    @Override
    public void setView(HomeContract.HomeView view) {
        this.view = view;

        initPresenter();
    }

    private void initPresenter() {
        view.initView();
    }

    @Override
    public void callLogin() {
        view.openLogin();
    }

    @Override
    public void callRegister() {
        view.openRegister();
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }
}
