package app.project.loginregister.ui.activity.register;

public interface RegisterContract {

    interface RegisterView {

        void initView();

        void openHome();

        void popBackStack();

    }

    interface RegisterPresenter {

        void setView(RegisterView view);

        void onBackPressed(int count);

        void onDestroy();

    }
}
