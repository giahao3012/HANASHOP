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
public class AccountDTO {
    private String username, password,lastname, email,role;
    private boolean isStillWorking;     

    public AccountDTO() {
    }

    public AccountDTO(String username, String password, String lastname, String email, String role, boolean isStillWorking) {
        this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
        this.isStillWorking = isStillWorking;
    }

    public AccountDTO(String username, String password, String lastname, String email) {
        this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.email = email;
    }
    public AccountDTO(String username, String password, String lastname, String email, String role) {
        this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isIsStillWorking() {
        return isStillWorking;
    }

    public void setIsStillWorking(boolean isStillWorking) {
        this.isStillWorking = isStillWorking;
    }

}
