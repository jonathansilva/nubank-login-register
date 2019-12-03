package app.project.loginregister.di.module.splash;

import app.project.loginregister.ui.activity.splash.SplashContract;
import app.project.loginregister.ui.activity.splash.SplashModel;
import app.project.loginregister.ui.activity.splash.SplashPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class SplashModule {

    @Provides
    SplashContract.SplashPresenter provideSplashPresenter(SplashPresenter presenter) {
        return presenter;
    }

    @Provides
    SplashContract.SplashModel provideSplashModel(SplashModel model) {
        return model;
    }
}
