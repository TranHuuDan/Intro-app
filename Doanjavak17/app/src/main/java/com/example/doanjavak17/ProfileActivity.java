package com.example.doanjavak17;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    ImageButton imageButton;
    TextView tvgivefeedback,tvhelp,tvchangepass,tvlogout;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        anhXa();

        tvhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog =new Dialog(ProfileActivity.this);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.dialog_help);
                ImageButton back =(ImageButton) dialog.findViewById(R.id.button_back_help);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });

        tvgivefeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog =new Dialog(ProfileActivity.this);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.dialog_givefeedback);
                ImageButton back =(ImageButton) dialog.findViewById(R.id.button_back_givefeedback);
                Button  submit=(Button) dialog.findViewById(R.id.btn_submit_givefeedback);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast=new Toast(ProfileActivity.this);
                        LayoutInflater inflater=getLayoutInflater();
                        View view=inflater.inflate(R.layout.custom_toast_feedback,(ViewGroup) findViewById(R.id.layout_custom_toast) );
                        toast.setView(view);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.show();
                        dialog.cancel();
                    }
                });
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });

        tvchangepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog =new Dialog(ProfileActivity.this);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.dialog_changepass);
                ImageButton back =(ImageButton) dialog.findViewById(R.id.button_back_changepass);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        tvlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProfileActivity.this, Activity_Login.class);
                startActivity(intent);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProfileActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
    private void anhXa(){
        imageButton=findViewById(R.id.profilebutton);
        tvhelp=(TextView) findViewById(R.id.tv_help);
        tvgivefeedback=(TextView) findViewById(R.id.tv_givefeedback);
        tvchangepass=(TextView) findViewById(R.id.tv_changepass);
        tvlogout=(TextView) findViewById(R.id.tv_logout);
    }
}
