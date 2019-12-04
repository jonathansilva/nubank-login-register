package app.project.loginregister.ui.fragment.register.password_confirm;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import app.project.loginregister.R;
import app.project.loginregister.helper.ResponseHelper;
import app.project.loginregister.model.User;
import app.project.loginregister.model.server.NoConnectivityException;
import app.project.loginregister.service.UserService;
import app.project.loginregister.session.Session;
import retrofit2.Call;
import retrofit2.Callback;

public class PasswordConfirmRegisterModel implements PasswordConfirmRegisterContract.PasswordConfirmRegisterModel {
    private PasswordConfirmRegisterContract.PasswordConfirmRegisterPresenter presenter;

    private Call<User> call;
    private UserService userService;
    private Session session;

    @Inject
    PasswordConfirmRegisterModel(Session session, UserService userService){
        this.session = session;
        this.userService = userService;
    }

    @Override
    public void setPresenter(PasswordConfirmRegisterContract.PasswordConfirmRegisterPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void request(User user) {
        call = userService.create(user);
        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull retrofit2.Response<User> response) {
                final User user = response.body();

                if (ResponseHelper.isValid(user, response)) {
                    session.setLogin(user);
                    presenter.openDashboard();
                } else {
                    presenter.error(R.string.error_register_response);
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
