/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Admin
 */
public class AccountErrObjDTO {
    private String usernameErr, passwordErr,rePasswordErr,lastnameErr, emailErr;

    public AccountErrObjDTO() {
    }

    public AccountErrObjDTO(String usernameErr, String passwordErr, String rePasswordErr, String lastnameErr, String emailErr) {
        this.usernameErr = usernameErr;
        this.passwordErr = passwordErr;
        this.rePasswordErr = rePasswordErr;
        this.lastnameErr = lastnameErr;
        this.emailErr = emailErr;
    }

    public String getUsernameErr() {
        return usernameErr;
    }

    public void setUsernameErr(String usernameErr) {
        this.usernameErr = usernameErr;
    }

    public String getPasswordErr() {
        return passwordErr;
    }

    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    public String getRePasswordErr() {
        return rePasswordErr;
    }

    public void setRePasswordErr(String rePasswordErr) {
        this.rePasswordErr = rePasswordErr;
    }

    public String getLastnameErr() {
        return lastnameErr;
    }

    public void setLastnameErr(String lastnameErr) {
        this.lastnameErr = lastnameErr;
    }

    public String getEmailErr() {
        return emailErr;
    }

    public void setEmailErr(String emailErr) {
        this.emailErr = emailErr;
    }

    
}
