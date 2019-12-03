package app.project.loginregister.ui.activity.splash;

import javax.inject.Inject;

import app.project.loginregister.session.Session;

public class SplashModel implements SplashContract.SplashModel {
    private SplashContract.SplashPresenter presenter;

    private Session session;

    @Inject
    SplashModel(Session session){
        this.session = session;
    }

    @Override
    public void setPresenter(SplashContract.SplashPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getSession() {
        if (!session.isLoggedIn()) {
            presenter.openHome();
        } else {
            presenter.openDashboard();
        }
    }
}
