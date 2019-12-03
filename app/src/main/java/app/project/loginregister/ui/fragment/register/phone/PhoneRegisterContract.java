package app.project.loginregister.ui.fragment.register.phone;

public interface PhoneRegisterContract {

    interface PhoneRegisterView {

        void error(int error);

        void openPasswordRegister(String phone);

    }

    interface PhoneRegisterPresenter {

        void setView(PhoneRegisterView view);

        void callPasswordRegister(String phone);

        void onDestroy();

    }
}
