package app.project.loginregister.ui.activity.dashboard;

import javax.inject.Inject;

public class DashboardPresenter implements DashboardContract.DashboardPresenter {
    private DashboardContract.DashboardView view;
    private DashboardContract.DashboardModel model;

    @Inject
    DashboardPresenter(DashboardContract.DashboardModel model) {
        this.model = model;

        model.setPresenter(this);
    }

    @Override
    public void setView(DashboardContract.DashboardView view) {
        this.view = view;

        initPresenter();
    }

    private void initPresenter() {
        view.initView();
    }

    @Override
    public void callLogout() {
        model.logout();
    }

    @Override
    public void logout() {
        view.openHome();
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }
}