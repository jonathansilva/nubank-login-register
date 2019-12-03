package app.project.loginregister.ui.fragment.login.phone;

import javax.inject.Inject;

import app.project.loginregister.R;
import app.project.loginregister.helper.ValidatorHelper;

public class PhoneLoginPresenter implements PhoneLoginContract.PhoneLoginPresenter {
    private PhoneLoginContract.PhoneLoginView view;

    @Inject
    PhoneLoginPresenter() {}

    @Override
    public void setView(PhoneLoginContract.PhoneLoginView view) {
        this.view = view;
    }

    @Override
    public void callPasswordLogin(String phone) {
        if (contentFieldsIsValid(phone)) {
            view.openPasswordLogin();
        }
    }

    private boolean contentFieldsIsValid(String phone) {
        if (phoneIsEmpty(phone)) {
            view.error(R.string.empty_phone);
            return false;
        }

        if (notIsPhone(phone)) {
            view.error(R.string.invalid_phone_length);
            return false;
        }
        return true;
    }

    private boolean phoneIsEmpty(String phone) {
        return ValidatorHelper.isEmpty(phone);
    }

    private boolean notIsPhone(String phone) {
        return !ValidatorHelper.isPhone(phone);
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }
}
