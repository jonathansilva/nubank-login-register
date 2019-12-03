package app.project.loginregister.ui.fragment.login.password;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import app.project.loginregister.R;
import app.project.loginregister.helper.KeyboardToggleHelper;
import app.project.loginregister.helper.ToastHelper;
import app.project.loginregister.model.User;
import app.project.loginregister.ui.activity.splash.SplashView;
import dagger.android.support.AndroidSupportInjection;

public class PasswordLoginView extends Fragment implements PasswordLoginContract.PasswordLoginView {
    private ProgressBar progress;

    private ImageButton btn_next;
    private TextInputEditText et_password;
    private TextInputLayout il_password;

    @Inject
    PasswordLoginContract.PasswordLoginPresenter presenter;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter.setView(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_password, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et_password = view.findViewById(R.id.et_password);
        il_password = view.findViewById(R.id.il_password);

        et_password.setFocusable(true);
        et_password.requestFocus();

        btn_next = view.findViewById(R.id.btn_next);
        btn_next.setOnClickListener(next);

        progress = view.findViewById(R.id.progress);
    }

    private View.OnClickListener next = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            callDashboard();
        }
    };

    private void callDashboard() {
        KeyboardToggleHelper.toggle(requireActivity(), null);

        cleanErrorMessageFields();
        buttonNextEnabled(false);
        et_password.setEnabled(false);
        progress.setVisibility(View.VISIBLE);

        presenter.callDashboard(getUser());
    }

    private User getUser() {
        User user = new User();

        Bundle args = getArguments();

        if (args != null) {
            user.setPhone(args.getString("phone"));
            user.setPassword(Objects.requireNonNull(et_password.getText()).toString());
        }
        return user;
    }

    private void cleanErrorMessageFields() {
        il_password.setError(null);
        il_password.setErrorEnabled(false);
    }

    private void buttonNextEnabled(Boolean enabled) {
        btn_next.setEnabled(enabled);
    }

    @Override
    public void error(int error) {
        KeyboardToggleHelper.toggle(requireActivity(), null);

        buttonNextEnabled(true);
        et_password.setEnabled(true);
        progress.setVisibility(View.GONE);

        ToastHelper.alert(getString(error), getActivity());
    }

    @Override
    public void errorPassword(int error) {
        il_password.setError(getString(error));
    }

    @Override
    public void openDashboard() {
        progress.setVisibility(View.GONE);

        Intent intent = new Intent(getActivity(), SplashView.class);

        if (getActivity() != null) {
            getActivity().startActivity(intent);
            getActivity().finish();
            getActivity().overridePendingTransition(R.anim.fade_in, 0);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
