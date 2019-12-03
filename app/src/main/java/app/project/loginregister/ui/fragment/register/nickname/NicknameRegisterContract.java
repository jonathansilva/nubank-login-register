package app.project.loginregister.ui.fragment.register.nickname;

public interface NicknameRegisterContract {

    interface NicknameRegisterView {

        void error(int error);

        void openEmailRegister(String nickname);

    }

    interface NicknameRegisterPresenter {

        void setView(NicknameRegisterView view);

        void callEmailRegister(String nickname);

        void onDestroy();

    }
}
