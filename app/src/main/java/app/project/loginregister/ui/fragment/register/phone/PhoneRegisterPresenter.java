package app.project.loginregister.ui.fragment.register.phone;

import javax.inject.Inject;

import app.project.loginregister.R;
import app.project.loginregister.helper.ValidatorHelper;

public class PhoneRegisterPresenter implements PhoneRegisterContract.PhoneRegisterPresenter {
    private PhoneRegisterContract.PhoneRegisterView view;

    @Inject
    PhoneRegisterPresenter() {}

    @Override
    public void setView(PhoneRegisterContract.PhoneRegisterView view) {
        this.view = view;
    }

    @Override
    public void callPasswordRegister(String phone) {
        if (contentFieldsIsValid(phone)) {
            view.openPasswordRegister(phone);
        }
    }

    private boolean contentFieldsIsValid(String phone) {
        if (phoneIsEmpty(phone)) {
            view.error(R.string.empty_phone);
            return false;
        }

        if (notIsPhone(phone)) {
            view.error(R.string.invalid_phone);
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
