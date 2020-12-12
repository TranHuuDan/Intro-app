package com.example.doanjavak17;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Activity_Login extends AppCompatActivity {
    EditText edtEmail,edtPassword;
    EditText edtConfirmPass_Register,confirmPass_confirm;
    TextView tv_Register,tv_ForgotPass;
    Button btnLogIn;
    String str_email_register,str_pass_register,str_confirmPass_register;
    String str_email_forgot,str_pass_forgot,str_confirmPass_forgot;
    information_user user_login = new information_user();
    information_user user_register = new information_user();
    information_user user_forgot = new information_user();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automation_login);
        anhXaID();
        logIn();
        Register();
        forgotPassWord();
    }
    public void logIn()
    {
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String str_email  = edtEmail.getText().toString().trim();
               String str_pass  = edtPassword.getText().toString().trim();
                user_login.setEmail(str_email);
                user_login.setPassword(str_pass);
                System.out.println();
                System.out.println("Email :" +user_login.getEmail());
                System.out.println("Password:" +user_login.getPassword());
                if(user_login.getEmail().equalsIgnoreCase("") || user_login.getPassword().equalsIgnoreCase(""))
                  {
                     customToast(R.layout.custom_toast_login,R.id.layout_custom_toast_login,R.id.tv_custom_toast_login,"Your Email Or Password Is Not Empty!!!");
                  }
                else if(user_login.getEmail().equalsIgnoreCase("abcde")== false || user_login.getPassword().equalsIgnoreCase("xyz")== false)
                 {
                     customToast(R.layout.custom_toast_login,R.id.layout_custom_toast_login,R.id.tv_custom_toast_login,"Your Email Or Paasword Is Not Correct!!!");
                 }
                else
                  {
                      // Mi xóa cái activity after_login_activity  với cái layout after_login_activity
                      // Thay bằng cái activity sau khi nhấn login ra cái activity mày vào
                      // đổi các after_login_activity nơi cái intent bên dưới nữa
                    Intent intent=new Intent(Activity_Login.this,MenuActivity.class);
                    startActivity(intent);
                  }
            }
        });
    }
    public void Register()
    {
        tv_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog =new Dialog(Activity_Login.this);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.activity_register);
                 final EditText edtEmail_Register    = (EditText) dialog.findViewById(R.id.email_register);
                 final EditText edtPassword_Register = (EditText) dialog.findViewById(R.id.password_register);
                 final EditText edtPasswordConfirm_Register=(EditText) dialog.findViewById(R.id.confirmpassword_register);
                Button btnRegister    = (Button) dialog.findViewById(R.id.button_register);


                    btnRegister.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            str_email_register  = edtEmail_Register.getText().toString().trim();
                            str_pass_register   = edtPassword_Register.getText().toString().trim();
                            str_confirmPass_register = edtPasswordConfirm_Register.getText().toString().trim();
                            user_register.setEmail(str_email_register);
                            user_register.setPassword(str_pass_register);

                            System.out.println();
                            System.out.println("Email register : " + user_register.getEmail());
                            System.out.println("Pass register : " + user_register.getPassword());

                            if(user_register.getEmail().equalsIgnoreCase("abcde"))
                            {
                                customToast(R.layout.custom_toast_login,R.id.layout_custom_toast_login,R.id.tv_custom_toast_login,"Your Email Is Exist!!!");
                            }
                            else if(str_pass_register.equals(str_confirmPass_register)
                            && user_register.getEmail() != null ) {

                                edtEmail.setText(str_email_register);
                                edtPassword.setText(str_pass_register);
                                customToast(R.layout.custom_toast_login,R.id.layout_custom_toast_login,R.id.tv_custom_toast_login,"Your Register Is Success!!!");
                                dialog.cancel();
                            }
                            else {
                                customToast(R.layout.custom_toast_login,R.id.layout_custom_toast_login,R.id.tv_custom_toast_login,"Confirm Password Is Not Correct!!!");
                            }

                        }
                    });
                    dialog.show();
            }
        });
    }
    public  void forgotPassWord()
    {
        tv_ForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog =new Dialog(Activity_Login.this);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.activity_forgotpassword);

                final EditText edtEmail_confirm   = (EditText) dialog.findViewById(R.id.email_confirm);
                final EditText edtPassword_confirm = (EditText) dialog.findViewById(R.id.password_confirm);
                final EditText edtPasswordConfirm_Confirm = (EditText) dialog.findViewById(R.id.confirmpassword_confirm);
                Button btnConfirm    = (Button) dialog.findViewById(R.id.button_confirm);
                btnConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        str_email_forgot  = edtEmail_confirm.getText().toString().trim();
                        str_pass_forgot   = edtPassword_confirm.getText().toString().trim();
                        str_confirmPass_forgot = edtPasswordConfirm_Confirm.getText().toString().trim();
                        user_forgot.setEmail(str_email_forgot);
                        user_forgot.setPassword(str_pass_forgot);
                        System.out.println();
                        System.out.println("Email :" +user_forgot.getEmail());
                        System.out.println("Password:" +user_forgot.getPassword());

                        if(str_pass_forgot.equals(str_confirmPass_forgot)&& user_forgot.getEmail() != null ) {

                            edtEmail.setText(str_email_forgot);
                            edtPassword.setText(str_pass_forgot);
                            customToast(R.layout.custom_toast_login,R.id.layout_custom_toast_login,R.id.tv_custom_toast_login,"Your Confirm Is Success!!!");
                            dialog.cancel();
                        }
                        else {
                            customToast(R.layout.custom_toast_login,R.id.layout_custom_toast_login,R.id.tv_custom_toast_login,"Confirm Password Is Not Correct!!!");
                        }
                    }
                });
                dialog.show();
            }
        });
    }

    public void anhXaID()
    {
        edtEmail      = (EditText) findViewById(R.id.email);
        edtPassword   = (EditText) findViewById(R.id.password);
        btnLogIn      = (Button) findViewById(R.id.button_login);
        tv_Register   = (TextView) findViewById(R.id.tvRegister);
        tv_ForgotPass = (TextView) findViewById(R.id.tvForgotPassword);
    }
    public void customToast(int layout, int idLayout,int idTextview,String text)
    {
        Toast toast=new Toast(Activity_Login.this);
        LayoutInflater inflater=getLayoutInflater();
        View view=inflater.inflate(layout,(ViewGroup) findViewById(idLayout) );
        TextView textView=view.findViewById(idTextview);
        textView.setText(text);
        toast.setView(view);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }
}