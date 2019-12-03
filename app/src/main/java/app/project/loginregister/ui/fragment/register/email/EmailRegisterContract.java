package app.project.loginregister.ui.fragment.register.email;

public interface EmailRegisterContract {

    interface EmailRegisterView {

        void error(int error);

        void openPhoneRegister(String email);

    }

    interface EmailRegisterPresenter {

        void setView(EmailRegisterView view);

        void callPhoneRegister(String email);

        void onDestroy();

    }
}
