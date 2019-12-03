package app.project.loginregister.di.module.register;

import app.project.loginregister.ui.activity.register.RegisterContract;
import app.project.loginregister.ui.activity.register.RegisterPresenter;
import app.project.loginregister.ui.fragment.register.email.EmailRegisterContract;
import app.project.loginregister.ui.fragment.register.email.EmailRegisterPresenter;
import app.project.loginregister.ui.fragment.register.name.NameRegisterContract;
import app.project.loginregister.ui.fragment.register.name.NameRegisterPresenter;
import app.project.loginregister.ui.fragment.register.nickname.NicknameRegisterContract;
import app.project.loginregister.ui.fragment.register.nickname.NicknameRegisterPresenter;
import app.project.loginregister.ui.fragment.register.password.PasswordRegisterContract;
import app.project.loginregister.ui.fragment.register.password.PasswordRegisterPresenter;
import app.project.loginregister.ui.fragment.register.password_confirm.PasswordConfirmRegisterContract;
import app.project.loginregister.ui.fragment.register.password_confirm.PasswordConfirmRegisterModel;
import app.project.loginregister.ui.fragment.register.password_confirm.PasswordConfirmRegisterPresenter;
import app.project.loginregister.ui.fragment.register.phone.PhoneRegisterContract;
import app.project.loginregister.ui.fragment.register.phone.PhoneRegisterPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class RegisterModule {

    @Provides
    RegisterContract.RegisterPresenter provideRegisterPresenter(RegisterPresenter presenter) {
        return presenter;
    }

    @Provides
    NameRegisterContract.NameRegisterPresenter provideNameRegisterPresenter(NameRegisterPresenter presenter) {
        return presenter;
    }

    @Provides
    NicknameRegisterContract.NicknameRegisterPresenter provideNicknameRegisterPresenter(NicknameRegisterPresenter presenter) {
        return presenter;
    }

    @Provides
    EmailRegisterContract.EmailRegisterPresenter provideEmailRegisterPresenter(EmailRegisterPresenter presenter) {
        return presenter;
    }

    @Provides
    PhoneRegisterContract.PhoneRegisterPresenter providePhoneRegisterPresenter(PhoneRegisterPresenter presenter) {
        return presenter;
    }

    @Provides
    PasswordRegisterContract.PasswordRegisterPresenter providePasswordRegisterPresenter(PasswordRegisterPresenter presenter) {
        return presenter;
    }

    @Provides
    PasswordConfirmRegisterContract.PasswordConfirmRegisterPresenter providePasswordConfirmRegisterPresenter(PasswordConfirmRegisterPresenter presenter) {
        return presenter;
    }

    @Provides
    PasswordConfirmRegisterContract.PasswordConfirmRegisterModel providePasswordConfirmRegisterModel(PasswordConfirmRegisterModel model) {
        return model;
    }
}
