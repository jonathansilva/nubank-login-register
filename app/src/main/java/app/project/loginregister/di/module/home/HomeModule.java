package app.project.loginregister.di.module.home;

import app.project.loginregister.ui.activity.home.HomeContract;
import app.project.loginregister.ui.activity.home.HomePresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    @Provides
    HomeContract.HomePresenter provideHomePresenter(HomePresenter presenter) {
        return presenter;
    }
}
