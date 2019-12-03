package app.project.loginregister.ui.activity.home;

public interface HomeContract {

    interface HomeView {

        void initView();

        void openLogin();

        void openRegister();

    }

    interface HomePresenter {

        void setView(HomeView view);

        void callLogin();

        void callRegister();

        void onDestroy();

    }
}
