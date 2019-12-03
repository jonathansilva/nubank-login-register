package app.project.loginregister.ui.fragment.register.nickname;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

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
import app.project.loginregister.ui.fragment.register.email.EmailRegisterView;
import dagger.android.support.AndroidSupportInjection;

public class NicknameRegisterView extends Fragment implements NicknameRegisterContract.NicknameRegisterView {

    private ImageButton btn_next;
    private TextInputEditText et_nickname;
    private TextInputLayout il_nickname;
    private User user;

    @Inject
    NicknameRegisterContract.NicknameRegisterPresenter presenter;

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
        return inflater.inflate(R.layout.fragment_nickname_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tv_firstname = view.findViewById(R.id.tv_firstname);
        tv_firstname.setText(firstWord(user.getName()));

        et_nickname = view.findViewById(R.id.et_nickname);
        il_nickname = view.findViewById(R.id.il_nickname);

        et_nickname.setFocusable(true);
        et_nickname.requestFocus();

        btn_next = view.findViewById(R.id.btn_next);
        btn_next.setOnClickListener(next);
    }

    private static String firstWord(String string) {
        return string.split(" ")[0];
    }

    private View.OnClickListener next = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            callEmailRegister();
        }
    };

    private void callEmailRegister() {
        cleanErrorMessageFields();

        presenter.callEmailRegister(Objects.requireNonNull(et_nickname.getText()).toString().trim());
    }

    private User getUser() {
        Bundle args = getArguments();

        if (args != null) {
            user.setName(args.getString("name"));
        }
        return user;
    }

    private void cleanErrorMessageFields() {
        il_nickname.setError(null);
        il_nickname.setErrorEnabled(false);
    }

    @Override
    public void error(int error) {
        il_nickname.setError(getString(error));
    }

    @Override
    public void openEmailRegister(String nickname) {
        btn_next.setEnabled(false);

        Bundle bundle = new Bundle();
        bundle.putString("name", user.getName());
        bundle.putString("nickname", nickname.substring(0,1).toUpperCase() + nickname.substring(1));

        FragmentHelper.load(new EmailRegisterView(), true, bundle, getActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
