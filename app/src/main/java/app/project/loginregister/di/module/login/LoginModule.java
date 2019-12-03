package app.project.loginregister.di.module.login;

import javax.inject.Singleton;

import app.project.loginregister.ui.activity.login.LoginContract;
import app.project.loginregister.ui.activity.login.LoginPresenter;
import app.project.loginregister.ui.fragment.login.password.PasswordLoginContract;
import app.project.loginregister.ui.fragment.login.password.PasswordLoginModel;
import app.project.loginregister.ui.fragment.login.password.PasswordLoginPresenter;
import app.project.loginregister.ui.fragment.login.phone.PhoneLoginContract;
import app.project.loginregister.ui.fragment.login.phone.PhoneLoginPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    LoginContract.LoginPresenter provideLoginPresenter(LoginPresenter presenter) {
        return presenter;
    }

    @Provides
    PhoneLoginContract.PhoneLoginPresenter providePhoneLoginPresenter(PhoneLoginPresenter presenter) {
        return presenter;
    }

    @Provides
    PasswordLoginContract.PasswordLoginPresenter providePasswordLoginPresenter(PasswordLoginPresenter presenter) {
        return presenter;
    }

    @Provides
    @Singleton
    PasswordLoginContract.PasswordLoginModel providePasswordLoginModel(PasswordLoginModel model) {
        return model;
    }
}
