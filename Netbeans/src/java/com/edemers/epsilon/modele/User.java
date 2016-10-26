package com.edemers.epsilon.modele;

public class User {

    private String username, password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean verifyPassword (String password) {
       if (password == null) return false;
       password = password.trim();
       return (this.password.equals(password));
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.username + "," + this.password;
    }

    public String getPassword() {
        return password;
    }
}
