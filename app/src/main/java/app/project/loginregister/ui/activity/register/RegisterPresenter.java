package app.project.loginregister.ui.activity.register;

import javax.inject.Inject;

public class RegisterPresenter implements RegisterContract.RegisterPresenter {
    private RegisterContract.RegisterView view;

    @Inject
    RegisterPresenter() {}

    @Override
    public void setView(RegisterContract.RegisterView view) {
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
