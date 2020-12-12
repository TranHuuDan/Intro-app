package com.example.doanjavak17;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import static com.example.smarthome.state_device.RELAY_OFF;

public class MainActivity extends AppCompatActivity {
    private Button state_0_light;
    private Button state_0_fan;
    Button back_menu;
    Button setting_bedroom;
    Button information_contact;
    TextView text_state_device1;
    TextView text_state_device2;
    device_and_state device1 = new device_and_state();
    device_and_state device2 = new device_and_state();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bedroom_control);
        text_state_device1 = (TextView) findViewById(R.id.textView1);
        text_state_device2 = (TextView) findViewById(R.id.textView2);
        state_0_light = (Button) findViewById(R.id.light_0_bedroom);
        state_0_fan = (Button) findViewById(R.id.fan_0_bedroom);

        setting_bedroom = (Button) findViewById(R.id.setting_room);
        setting_bedroom.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setting_bedroom = new Intent(MainActivity.this,ActivitySettingBedroom.class);
                startActivity(setting_bedroom);
            }
        });

//        information_contact = (Button) findViewById(R.id.insert);
//        information_contact.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent information_contact = new Intent(MainActivity.this,ActivityInformation.class);
//                startActivity(information_contact);
//            }
//        });

        back_menu = (Button) findViewById(R.id.back_menu);
        back_menu.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back_menu = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(back_menu);
            }
        });

    }




    public void onClick(View view)
    {
//        if ( device1.getState_bedroom() != state_device.RELAY_DISCONNECTED )
//            {
//                switch (view.getId())
//                {
//                    case R.id.light_0_bedroom:
//
//                        switch ( device1.getState_bedroom() )
//                        {
//                            case RELAY_ON :
//                                state_0_light.setBackgroundResource(R.drawable.bongden1);
//                                text_state_device1.setText(device1.setText_state_device_bedroom("Turn On"));
//                                device1.setName_bedroom(name_device.THE_LIGHT);
//                                device1.setState_bedroom(state_device.RELAY_OFF);
//                                break;
//
//                            case RELAY_OFF:
//                                state_0_light.setBackgroundResource(R.drawable.bongden);
//                                text_state_device1.setText(device1.setText_state_device_bedroom("Turn Off"));
//                                device1.setName_bedroom(name_device.THE_LIGHT);
//                                device1.setState_bedroom(state_device.RELAY_ON);
//                                break;
//                        }
//
//                        break;
//
//                    case R.id.fan_0_bedroom:
//
//                        switch ( device2.getState_bedroom() )
//                        {
//                            case RELAY_ON :
//                                state_0_fan.setBackgroundResource(R.drawable.quat1);
//                                text_state_device2.setText(device2.setText_state_device_bedroom("Turn On"));
//                                device2.setName_bedroom(name_device.THE_FAN);
//                                device2.setState_bedroom(state_device.RELAY_OFF);
//                                break;
//
//                            case RELAY_OFF:
//                                state_0_fan.setBackgroundResource(R.drawable.quat);
//                                text_state_device2.setText(device2.setText_state_device_bedroom("Turn Off"));
//                                device2.setName_bedroom(name_device.THE_FAN);
//                                device2.setState_bedroom(state_device.RELAY_ON);
//                                break;
//
//                        }
//
//                        break;
//                }
//            }
//        else if (device1.getState_bedroom() == state_device.RELAY_DISCONNECTED)
//        {
//            text_state_device1.setText(device1.setText_state_device_bedroom("Disconnected"));
//            text_state_device2.setText(device2.setText_state_device_bedroom("Disconnected"));
//        }
    }

}




