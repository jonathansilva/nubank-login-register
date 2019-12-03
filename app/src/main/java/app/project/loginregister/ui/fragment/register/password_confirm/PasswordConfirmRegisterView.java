package app.project.loginregister.ui.fragment.register.password_confirm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import app.project.loginregister.R;
import app.project.loginregister.helper.ToastHelper;
import app.project.loginregister.model.User;
import app.project.loginregister.ui.activity.splash.SplashView;
import app.project.loginregister.ui.activity.terms.TermsView;
import dagger.android.support.AndroidSupportInjection;

public class PasswordConfirmRegisterView extends Fragment implements PasswordConfirmRegisterContract.PasswordConfirmRegisterView {
    private CheckBox checkBox;
    private Intent intent;
    private ProgressBar progress;

    private TextInputEditText et_password_confirm;
    private TextInputLayout il_password_confirm;
    private User user;

    @Inject
    PasswordConfirmRegisterContract.PasswordConfirmRegisterPresenter presenter;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter.setView(this);

        user = new User();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_password_confirm_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et_password_confirm = view.findViewById(R.id.et_password_confirm);
        il_password_confirm = view.findViewById(R.id.il_password_confirm);

        et_password_confirm.setFocusable(true);
        et_password_confirm.requestFocus();

        TextView tv_terms = view.findViewById(R.id.tv_terms);
        tv_terms.setOnClickListener(terms);

        checkBox = view.findViewById(R.id.checkBox);

        ImageButton btn_next = view.findViewById(R.id.btn_next);
        btn_next.setOnClickListener(next);

        progress = view.findViewById(R.id.progress);
    }

    private View.OnClickListener terms = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            callTerms();
        }
    };

    private void callTerms() {
        cleanErrorMessageFields();

        intent = new Intent(getActivity(), TermsView.class);

        if (getActivity() != null) {
            getActivity().startActivity(intent);
            getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.stable);
        }
    }

    private View.OnClickListener next = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            callDashboard();
        }
    };

    private void callDashboard() {
        cleanErrorMessageFields();
        progress.setVisibility(View.VISIBLE);

        presenter.callDashboard(getUser());
    }

    private User getUser() {
        Bundle args = getArguments();

        if (args != null) {
            user.setName(args.getString("name"));
            user.setNickname(args.getString("nickname"));
            user.setEmail(args.getString("email"));
            user.setPhone(args.getString("phone"));
            user.setPassword(args.getString("password"));
            user.setPasswordConfirm(Objects.requireNonNull(et_password_confirm.getText()).toString());
            user.setCheckBox(checkBox.isChecked());
        }
        return user;
    }

    private void cleanErrorMessageFields() {
        il_password_confirm.setError(null);
        il_password_confirm.setErrorEnabled(false);
    }

    @Override
    public void error(int error) {
        progress.setVisibility(View.GONE);

        ToastHelper.alert(getResources().getString(error), getActivity());
    }

    @Override
    public void errorPassword(int error) {
        progress.setVisibility(View.GONE);
        il_password_confirm.setError(getString(error));
    }

    @Override
    public void errorCheckbox() {
        progress.setVisibility(View.GONE);

        ToastHelper.alert(getResources().getString(R.string.error_accept), getActivity());
    }

    @Override
    public void openDashboard() {
        progress.setVisibility(View.GONE);

        intent = new Intent(requireActivity(), SplashView.class);

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
