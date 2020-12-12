package com.example.doanjavak17;

public class information_user {
    private String email;
    private String password;
    public information_user()
    {

    }
    public information_user(String email, String password)
    {
        this.email=email;
        this.password=password;
    }

    public  void setEmail(String email)
    {
        this.email=email;
    }
    public  void setPassword(String password)
    {
        this.password=password;
    }

    public String getEmail()
    {
        return email;
    }
    public String getPassword()
    {
        return  password;
    }

}
