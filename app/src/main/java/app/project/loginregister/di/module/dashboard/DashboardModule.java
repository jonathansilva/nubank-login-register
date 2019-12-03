package app.project.loginregister.di.module.dashboard;

import javax.inject.Singleton;

import app.project.loginregister.ui.activity.dashboard.DashboardContract;
import app.project.loginregister.ui.activity.dashboard.DashboardModel;
import app.project.loginregister.ui.activity.dashboard.DashboardPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class DashboardModule {

    @Provides
    DashboardContract.DashboardPresenter provideDashboardPresenter(DashboardPresenter presenter) {
        return presenter;
    }

    @Provides
    @Singleton
    DashboardContract.DashboardModel provideDashboardModel(DashboardModel model) {
        return model;
    }
}