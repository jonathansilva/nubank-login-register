package app.project.loginregister.ui.fragment.login.password;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import app.project.loginregister.R;
import app.project.loginregister.helper.ResponseHelper;
import app.project.loginregister.model.User;
import app.project.loginregister.model.server.NoConnectivityException;
import app.project.loginregister.service.LoginService;
import app.project.loginregister.session.Session;
import retrofit2.Call;
import retrofit2.Callback;

public class PasswordLoginModel implements PasswordLoginContract.PasswordLoginModel {
    private PasswordLoginContract.PasswordLoginPresenter presenter;

    private Call<User> call;
    private LoginService loginService;
    private Session session;

    @Inject
    PasswordLoginModel(Session session, LoginService loginService){
        this.session = session;
        this.loginService = loginService;
    }

    @Override
    public void setPresenter(PasswordLoginContract.PasswordLoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void request(User user) {
        call = loginService.login(user);
        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull retrofit2.Response<User> response) {
                final User user = response.body();

                if (ResponseHelper.isValid(user, response)) {
                    session.setLogin(user);
                    presenter.openDashboard();
                } else {
                    presenter.error(R.string.error_login_response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                if (t instanceof NoConnectivityException || !call.isCanceled()) {
                    presenter.error(R.string.error_request);
                }
            }
        });
    }

    @Override
    public void onPause() {
        if (call != null) {
            call.cancel();
        }
    }
}
