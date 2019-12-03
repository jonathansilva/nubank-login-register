package app.project.loginregister.ui.activity.dashboard;

import javax.inject.Inject;

import app.project.loginregister.session.Session;

public class DashboardModel implements DashboardContract.DashboardModel {
    private DashboardContract.DashboardPresenter presenter;

    private Session session;

    @Inject
    DashboardModel(Session session) {
        this.session = session;
    }

    @Override
    public void setPresenter(DashboardContract.DashboardPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void logout() {
        session.logout();
        presenter.logout();
    }

}
