package app.project.loginregister.ui.fragment.register.password;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import app.project.loginregister.ui.fragment.register.password_confirm.PasswordConfirmRegisterView;
import app.project.loginregister.R;
import app.project.loginregister.helper.FragmentHelper;
import app.project.loginregister.model.User;
import dagger.android.support.AndroidSupportInjection;

public class PasswordRegisterView extends Fragment implements PasswordRegisterContract.PasswordRegisterView {
    private ImageButton btn_next;
    private TextInputEditText et_password;
    private TextInputLayout il_password;
    private User user;

    @Inject
    PasswordRegisterContract.PasswordRegisterPresenter presenter;

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
        user = getUser();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_password_register, container, false);
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
    }

    private View.OnClickListener next = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            callPasswordConfirmRegister();
        }
    };

    private void callPasswordConfirmRegister() {
        cleanErrorMessageFields();

        presenter.callPasswordConfirmRegister(Objects.requireNonNull(et_password.getText()).toString());
    }

    private User getUser() {
        Bundle args = getArguments();

        if (args != null) {
            user.setName(args.getString("name"));
            user.setNickname(args.getString("nickname"));
            user.setEmail(args.getString("email"));
            user.setPhone(args.getString("phone"));
        }
        return user;
    }

    private void cleanErrorMessageFields() {
        il_password.setError(null);
        il_password.setErrorEnabled(false);
    }

    @Override
    public void error(int error) {
        il_password.setError(getString(error));
    }

    @Override
    public void openPasswordConfirmRegister(String password) {
        btn_next.setEnabled(false);

        Bundle bundle = new Bundle();
        bundle.putString("name", user.getName());
        bundle.putString("nickname", user.getNickname());
        bundle.putString("email", user.getEmail());
        bundle.putString("phone", user.getPhone());
        bundle.putString("password", password);

        FragmentHelper.load(new PasswordConfirmRegisterView(), true, bundle, getActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
