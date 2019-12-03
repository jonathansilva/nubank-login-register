package app.project.loginregister.ui.activity.login;

public interface LoginContract {

    interface LoginView {

        void initView();

        void openHome();

        void popBackStack();

    }

    interface LoginPresenter {

        void setView(LoginView view);

        void onBackPressed(int count);

        void onDestroy();

    }
}
