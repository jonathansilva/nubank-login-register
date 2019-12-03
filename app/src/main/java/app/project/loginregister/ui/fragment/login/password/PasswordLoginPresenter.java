package app.project.loginregister.ui.fragment.login.password;

import javax.inject.Inject;

import app.project.loginregister.R;
import app.project.loginregister.helper.ValidatorHelper;
import app.project.loginregister.model.User;

public class PasswordLoginPresenter implements PasswordLoginContract.PasswordLoginPresenter {
    private PasswordLoginContract.PasswordLoginView view;
    private PasswordLoginContract.PasswordLoginModel model;

    @Inject
    PasswordLoginPresenter(PasswordLoginContract.PasswordLoginModel model) {
        this.model = model;

        model.setPresenter(this);
    }

    @Override
    public void setView(PasswordLoginContract.PasswordLoginView view) {
        this.view = view;
    }

    @Override
    public void callDashboard(User user) {
        if (contentFieldsIsValid(user.getPassword())) {
            model.request(user);
        }
    }

    @Override
    public void error(int error) {
        view.error(error);
    }

    @Override
    public void openDashboard() {
        view.openDashboard();
    }

    private boolean contentFieldsIsValid(String password) {
        if (passwordIsEmpty(password)) {
            view.errorPassword(R.string.empty_password);
            return false;
        }

        if (notIsPassword(password)) {
            view.errorPassword(R.string.invalid_password);
            return false;
        }
        return true;
    }

    private boolean passwordIsEmpty(String password) {
        return ValidatorHelper.isEmpty(password);
    }

    private boolean notIsPassword(String password) {
        return !ValidatorHelper.isPassword(password);
    }

    @Override
    public void onPause() {
        model.onPause();
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }
}
