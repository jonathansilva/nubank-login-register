package app.project.loginregister.ui.fragment.login.phone;

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
import app.project.loginregister.helper.PhoneMaskHelper;
import app.project.loginregister.ui.fragment.login.password.PasswordLoginView;
import dagger.android.support.AndroidSupportInjection;

public class PhoneLoginView extends Fragment implements PhoneLoginContract.PhoneLoginView {
    private ImageButton btn_next;
    private TextInputEditText et_phone;
    private TextInputLayout il_phone;

    @Inject
    PhoneLoginContract.PhoneLoginPresenter presenter;

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
        return inflater.inflate(R.layout.fragment_login_phone, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et_phone = view.findViewById(R.id.et_phone);
        il_phone = view.findViewById(R.id.il_phone);

        et_phone.setFocusable(true);
        et_phone.requestFocus();

        btn_next = view.findViewById(R.id.btn_next);
        btn_next.setOnClickListener(next);

        et_phone.addTextChangedListener(PhoneMaskHelper.insert(et_phone));
    }

    private View.OnClickListener next = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            callPasswordLogin();
        }
    };

    private void callPasswordLogin() {
        cleanErrorMessageFields();

        presenter.callPasswordLogin(Objects.requireNonNull(et_phone.getText()).toString());
    }

    private void cleanErrorMessageFields() {
        il_phone.setError(null);
        il_phone.setErrorEnabled(false);
    }

    @Override
    public void error(int error) {
        il_phone.setError(getString(error));
    }

    @Override
    public void openPasswordLogin() {
        btn_next.setEnabled(false);

        String phone = Objects.requireNonNull(et_phone.getText()).toString().replaceAll("[^0-9]*", "");

        Bundle bundle = new Bundle();
        bundle.putString("phone", phone);

        FragmentHelper.load(new PasswordLoginView(), true, bundle, getActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
