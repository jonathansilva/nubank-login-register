package app.project.loginregister.ui.activity.splash;

public interface SplashContract {

    interface SplashModel {

        void setPresenter(SplashPresenter presenter);

        void getSession();

    }

    interface SplashView {

        void initView();

        void openHome();

        void openDashboard();

    }

    interface SplashPresenter {

        void setView(SplashView view);

        void callSession();

        void openHome();

        void openDashboard();

        void onDestroy();

    }
}
