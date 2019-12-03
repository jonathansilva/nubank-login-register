package app.project.loginregister.ui.fragment.register.name;

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
import app.project.loginregister.ui.fragment.register.nickname.NicknameRegisterView;
import app.project.loginregister.R;
import app.project.loginregister.helper.FragmentHelper;
import dagger.android.support.AndroidSupportInjection;

public class NameRegisterView extends Fragment implements NameRegisterContract.NameRegisterView {
    private ImageButton btn_next;
    private TextInputEditText et_name;
    private TextInputLayout il_name;

    @Inject
    NameRegisterContract.NameRegisterPresenter presenter;

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
        return inflater.inflate(R.layout.fragment_name_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et_name = view.findViewById(R.id.et_name);
        il_name = view.findViewById(R.id.il_name);

        et_name.setFocusable(true);
        et_name.requestFocus();

        btn_next = view.findViewById(R.id.btn_next);
        btn_next.setOnClickListener(next);
    }

    private View.OnClickListener next = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            callNicknameRegister();
        }
    };

    private void callNicknameRegister() {
        cleanErrorMessageFields();

        presenter.callNicknameRegister(Objects.requireNonNull(et_name.getText()).toString().trim());
    }

    private void cleanErrorMessageFields() {
        il_name.setError(null);
        il_name.setErrorEnabled(false);
    }

    @Override
    public void error(int error) {
        il_name.setError(getString(error));
    }

    @Override
    public void openNicknameRegister(String name) {
        btn_next.setEnabled(false);

        Bundle bundle = new Bundle();
        bundle.putString("name", name.substring(0,1).toUpperCase() + name.substring(1));

        FragmentHelper.load(new NicknameRegisterView(), true, bundle, getActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
