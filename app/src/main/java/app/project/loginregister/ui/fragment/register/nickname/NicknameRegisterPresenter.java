package app.project.loginregister.ui.fragment.register.nickname;

import javax.inject.Inject;

import app.project.loginregister.R;
import app.project.loginregister.helper.ValidatorHelper;

public class NicknameRegisterPresenter implements NicknameRegisterContract.NicknameRegisterPresenter {
    private NicknameRegisterContract.NicknameRegisterView view;

    @Inject
    NicknameRegisterPresenter() {}

    @Override
    public void setView(NicknameRegisterContract.NicknameRegisterView view) {
        this.view = view;
    }

    @Override
    public void callEmailRegister(String nickname) {
        if (contentFieldsIsValid(nickname)) {
            view.openEmailRegister(nickname);
        }
    }

    private boolean contentFieldsIsValid(String nickname) {
        if (nicknameIsEmpty(nickname)) {
            view.error(R.string.empty_nickname);
            return false;
        }
        return true;
    }

    private boolean nicknameIsEmpty(String nickname) {
        return ValidatorHelper.isEmpty(nickname);
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }
}
