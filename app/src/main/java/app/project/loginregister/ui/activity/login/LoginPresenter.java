package app.project.loginregister.ui.activity.login;

import javax.inject.Inject;

public class LoginPresenter implements LoginContract.LoginPresenter {
    private LoginContract.LoginView view;

    @Inject
    LoginPresenter() {}

    @Override
    public void setView(LoginContract.LoginView view) {
        this.view = view;

        initPresenter();
    }

    private void initPresenter() {
        view.initView();
    }

    @Override
    public void onBackPressed(int count) {
        if (count == 0) {
            view.openHome();
        } else {
            view.popBackStack();
        }
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }
}
