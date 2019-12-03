package app.project.loginregister.ui.fragment.register.password_confirm;

import javax.inject.Inject;

import app.project.loginregister.R;
import app.project.loginregister.helper.ValidatorHelper;
import app.project.loginregister.model.User;

public class PasswordConfirmRegisterPresenter implements PasswordConfirmRegisterContract.PasswordConfirmRegisterPresenter {
    private PasswordConfirmRegisterContract.PasswordConfirmRegisterView view;
    private PasswordConfirmRegisterContract.PasswordConfirmRegisterModel model;

    @Inject
    PasswordConfirmRegisterPresenter(PasswordConfirmRegisterContract.PasswordConfirmRegisterModel model) {
        this.model = model;

        model.setPresenter(this);
    }

    @Override
    public void setView(PasswordConfirmRegisterContract.PasswordConfirmRegisterView view) {
        this.view = view;
    }

    @Override
    public void callDashboard(User user) {
        if (contentFieldsIsValid(user)) {
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

    private boolean contentFieldsIsValid(User user) {
        if (passwordIsEmpty(user.getPasswordConfirm())) {
            view.errorPassword(R.string.empty_password);
            return false;
        }

        if (notIsSamePassword(user.getPassword(), user.getPasswordConfirm())) {
            view.errorPassword(R.string.invalid_password_confirm);
            return false;
        }

        if (!user.getCheckBox()) {
            view.errorCheckbox();
            return false;
        }
        return true;
    }

    private boolean passwordIsEmpty(String passwordConfirm) {
        return ValidatorHelper.isEmpty(passwordConfirm);
    }

    private boolean notIsSamePassword(String password, String passwordConfirm) {
        return !passwordConfirm.equals(password);
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
