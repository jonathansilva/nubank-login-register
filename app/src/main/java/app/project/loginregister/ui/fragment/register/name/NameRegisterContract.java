package app.project.loginregister.ui.fragment.register.name;

public interface NameRegisterContract {

    interface NameRegisterView {

        void error(int error);

        void openNicknameRegister(String name);

    }

    interface NameRegisterPresenter {

        void setView(NameRegisterView view);

        void callNicknameRegister(String name);

        void onDestroy();

    }
}
