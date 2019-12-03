package app.project.loginregister.ui.fragment.login.phone;

public interface PhoneLoginContract {

    interface PhoneLoginView {

        void error(int error);

        void openPasswordLogin();

    }

    interface PhoneLoginPresenter {

        void setView(PhoneLoginView view);

        void callPasswordLogin(String phone);

        void onDestroy();

    }
}
