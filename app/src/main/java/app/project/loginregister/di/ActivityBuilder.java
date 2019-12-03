package app.project.loginregister.di;

import app.project.loginregister.ui.activity.dashboard.DashboardView;
import app.project.loginregister.ui.activity.home.HomeView;
import app.project.loginregister.ui.activity.login.LoginView;
import app.project.loginregister.ui.activity.register.RegisterView;
import app.project.loginregister.ui.activity.splash.SplashView;
import app.project.loginregister.ui.fragment.login.password.PasswordLoginView;
import app.project.loginregister.ui.fragment.login.phone.PhoneLoginView;
import app.project.loginregister.ui.fragment.register.email.EmailRegisterView;
import app.project.loginregister.ui.fragment.register.name.NameRegisterView;
import app.project.loginregister.ui.fragment.register.nickname.NicknameRegisterView;
import app.project.loginregister.ui.fragment.register.password.PasswordRegisterView;
import app.project.loginregister.ui.fragment.register.password_confirm.PasswordConfirmRegisterView;
import app.project.loginregister.ui.fragment.register.phone.PhoneRegisterView;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    // Splash

    @ContributesAndroidInjector
    public abstract SplashView bindSplashView();

    // Home

    @ContributesAndroidInjector
    public abstract HomeView bindHomeView();

    // Login

    @ContributesAndroidInjector
    public abstract LoginView bindLoginView();

    @ContributesAndroidInjector
    public abstract PhoneLoginView bindPhoneLoginView();

    @ContributesAndroidInjector
    public abstract PasswordLoginView bindPasswordLoginView();

    // Register

    @ContributesAndroidInjector
    public abstract RegisterView bindRegisterView();

    @ContributesAndroidInjector
    public abstract NameRegisterView bindNameRegisterView();

    @ContributesAndroidInjector
    public abstract NicknameRegisterView bindNicknameRegisterView();

    @ContributesAndroidInjector
    public abstract EmailRegisterView bindEmailRegisterView();

    @ContributesAndroidInjector
    public abstract PhoneRegisterView bindPhoneRegisterView();

    @ContributesAndroidInjector
    public abstract PasswordRegisterView bindPasswordRegisterView();

    @ContributesAndroidInjector
    public abstract PasswordConfirmRegisterView bindPasswordConfirmRegisterView();

    // Dashboard

    @ContributesAndroidInjector
    public abstract DashboardView bindDashboardView();
}
