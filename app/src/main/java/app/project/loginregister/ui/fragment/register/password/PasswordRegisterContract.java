package app.project.loginregister.ui.fragment.register.password;

public interface PasswordRegisterContract {

    interface PasswordRegisterView {

        void error(int error);

        void openPasswordConfirmRegister(String password);

    }

    interface PasswordRegisterPresenter {

        void setView(PasswordRegisterView view);

        void callPasswordConfirmRegister(String password);

        void onDestroy();

    }
}
