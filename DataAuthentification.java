package com.company;

public class DataAuthentification {
    private String inputPassword="";
    private String inputUsername="";

    public DataAuthentification(String inputUsername, String inputPassword) {
        this.inputPassword = inputPassword;
        this.inputUsername = inputUsername;
    }

    public String getInputPassword() {
        return inputPassword;
    }

    public void setInputPassword(String inputPassword) {
        this.inputPassword = inputPassword;
    }

    public String getInputUsername() {
        return inputUsername;
    }

    public void setInputUsername(String inputUsername) {
        this.inputUsername = inputUsername;
    }
}




