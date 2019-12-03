package app.project.loginregister.di.component;

import android.app.Application;

import javax.inject.Singleton;

import app.project.loginregister.App;
import app.project.loginregister.di.ActivityBuilder;
import app.project.loginregister.di.module.AppModule;
import app.project.loginregister.di.module.RetrofitModule;
import app.project.loginregister.di.module.dashboard.DashboardModule;
import app.project.loginregister.di.module.home.HomeModule;
import app.project.loginregister.di.module.login.LoginModule;
import app.project.loginregister.di.module.register.RegisterModule;
import app.project.loginregister.di.module.splash.SplashModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ActivityBuilder.class,
        AndroidSupportInjectionModule.class,
        RetrofitModule.class,
        AppModule.class,
        SplashModule.class,
        HomeModule.class,
        LoginModule.class,
        RegisterModule.class,
        DashboardModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application (Application application);

        AppComponent build();
    }

    void inject(App app);
}
