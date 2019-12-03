package app.project.loginregister.ui.fragment.login.password;

import app.project.loginregister.model.User;

public interface PasswordLoginContract {

    interface PasswordLoginModel {

        void setPresenter(PasswordLoginPresenter presenter);

        void request(User user);

        void onPause();

    }

    interface PasswordLoginView {

        void error(int error);

        void errorPassword(int error);

        void openDashboard();

    }

    interface PasswordLoginPresenter {

        void setView(PasswordLoginView view);

        void callDashboard(User user);

        void error(int error);

        void openDashboard();

        void onPause();

        void onDestroy();

    }
}
