package app.project.loginregister.ui.fragment.register.email;

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
import app.project.loginregister.R;
import app.project.loginregister.helper.FragmentHelper;
import app.project.loginregister.model.User;
import app.project.loginregister.ui.fragment.register.phone.PhoneRegisterView;
import dagger.android.support.AndroidSupportInjection;

public class EmailRegisterView extends Fragment implements EmailRegisterContract.EmailRegisterView {
    private ImageButton btn_next;
    private TextInputEditText et_email;
    private TextInputLayout il_email;
    private User user;

    @Inject
    EmailRegisterContract.EmailRegisterPresenter presenter;

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
        return inflater.inflate(R.layout.fragment_email_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et_email = view.findViewById(R.id.et_email);
        il_email = view.findViewById(R.id.il_email);

        et_email.setFocusable(true);
        et_email.requestFocus();

        btn_next = view.findViewById(R.id.btn_next);
        btn_next.setOnClickListener(next);
    }

    private View.OnClickListener next = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            callPhoneRegister();
        }
    };

    private void callPhoneRegister() {
        cleanErrorMessageFields();

        presenter.callPhoneRegister(Objects.requireNonNull(et_email.getText()).toString());
    }

    private User getUser() {
        Bundle args = getArguments();

        if (args != null) {
            user.setName(args.getString("name"));
            user.setNickname(args.getString("nickname"));
        }
        return user;
    }

    private void cleanErrorMessageFields() {
        il_email.setError(null);
        il_email.setErrorEnabled(false);
    }

    @Override
    public void error(int error) {
        il_email.setError(getString(error));
    }

    @Override
    public void openPhoneRegister(String email) {
        btn_next.setEnabled(false);

        Bundle bundle = new Bundle();
        bundle.putString("name", user.getName());
        bundle.putString("nickname", user.getNickname());
        bundle.putString("email", email);

        FragmentHelper.load(new PhoneRegisterView(), true, bundle, getActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
