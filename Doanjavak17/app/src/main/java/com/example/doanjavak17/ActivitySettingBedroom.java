package com.example.doanjavak17;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivitySettingBedroom extends AppCompatActivity {
    Button back_menu_room_setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_bedroom);

        back_menu_room_setting = (Button) findViewById(R.id.back_menu);
        back_menu_room_setting.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back_menu = new Intent(ActivitySettingBedroom.this, MainActivity.class);
                startActivity(back_menu);
            }
        });
    }
}