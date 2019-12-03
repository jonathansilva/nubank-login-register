package app.project.loginregister.ui.fragment.register.password_confirm;

import app.project.loginregister.model.User;

public interface PasswordConfirmRegisterContract {

    interface PasswordConfirmRegisterModel {

        void setPresenter(PasswordConfirmRegisterPresenter presenter);

        void request(User user);

        void onPause();

    }

    interface PasswordConfirmRegisterView {

        void error(int error);

        void errorPassword(int error);

        void errorCheckbox();

        void openDashboard();

    }

    interface PasswordConfirmRegisterPresenter {

        void setView(PasswordConfirmRegisterView view);

        void callDashboard(User user);

        void error(int error);

        void openDashboard();

        void onPause();

        void onDestroy();

    }
}
