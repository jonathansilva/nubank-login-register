package app.project.loginregister.model;

public class User {
    private String name;
    private String nickname;
    private String phone;
    private String email;
    private String password;
    private String password_confirm;
    private String token;
    private Boolean checkBox;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return password_confirm;
    }

    public void setPasswordConfirm(String password_confirm) {
        this.password_confirm = password_confirm;
    }

    public String getToken() {
        return token;
    }

    public Boolean getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(Boolean checkBox) {
        this.checkBox = checkBox;
    }
}