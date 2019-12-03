package app.project.loginregister.ui.activity.dashboard;

public interface DashboardContract {

    interface DashboardModel {

        void setPresenter(DashboardPresenter presenter);

        void logout();

    }

    interface DashboardView {

        void initView();

        void openHome();

    }

    interface DashboardPresenter {

        void setView(DashboardView view);

        void callLogout();

        void logout();

        void onDestroy();

    }
}