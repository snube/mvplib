package com.snubee.widget.gridpasswordview;

/**
 * @author Jungly
 * @mail jungly.ik@gmail.com
 * @date 15/3/21 16:20
 */
interface PasswordView {

    //void setError(String error);

    String getPassWord();

    void clearPassword();

    void setPassword(String password);

    void appendPassword(String password);

    void deletePassword();

    void setPasswordVisibility(boolean visible);

    void togglePasswordVisibility();

    void setOnPasswordChangedListener(GridPasswordView.OnPasswordChangedListener listener);

    void setPasswordType(PasswordType passwordType);
}