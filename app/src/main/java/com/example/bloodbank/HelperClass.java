package com.example.bloodbank;

public class HelperClass {

    public String getPseudo() {
        return pseudo;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public HelperClass(String pseudo, String password, String mail) {
        this.pseudo = pseudo;
        this.password = password;
        this.mail = mail;
    }

    String pseudo , password , mail ;
}
