package business;

import java.io.Serializable;

public class User implements Serializable {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String userName;
    private String role ="user";

    public User() {
        email = "";
        firstName = "";
        lastName = "";
        password = "";
        userName = "";
        role="user";
        
    }

    public User(String firstName, String lastName, String email , String password, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }

    
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}