package com.example.doanjavak17;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity implements OnItemClickListener{
    private RecyclerView rcvRom,rcv1;
    private ImageView buttonprofile, addroom, iv_back;
    private RoomAdapter mromAdapter;
    private List<Room> list =new ArrayList<>();
    private List<Information> list_info =new ArrayList<>();
    private InformationAdapter minformationAdapter;
    private final String fileName="doanjava";
    public  List<String> listTempRomName=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        anhXa();

        mromAdapter=new RoomAdapter(this,this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this, 3);
        rcvRom.setLayoutManager(gridLayoutManager);
        mromAdapter.setData(setListRoom());
        rcvRom.setAdapter(mromAdapter);
        minformationAdapter=new InformationAdapter(this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rcv1.setLayoutManager(linearLayoutManager);
        minformationAdapter.setData(setListInfor());
        rcv1.setAdapter(minformationAdapter);

        addroom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Dialog dialog =new Dialog(MenuActivity.this);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.dialog_addroom);
                ImageView img_upLoad=(ImageView) dialog.findViewById(R.id.img_choose);
                final EditText newname =(EditText) dialog.findViewById(R.id.edt_newroomname);
                Button btn_cfirm_addroom =(Button) dialog.findViewById(R.id.btn_add_addroom);
                Button btn_cancel_addroom =(Button) dialog.findViewById(R.id.btn_cancel);
                img_upLoad.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customToast(R.layout.custom_toast_notsupport,R.id.layout_custom_toast_1);
                    }
                });
                btn_cfirm_addroom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list.add(new Room(R.drawable.iconanonymousroom,newname.getText().toString().trim()));
                        listTempRomName.add(newname.getText().toString().trim());
                        saveData(listTempRomName);
                        mromAdapter.notifyDataSetChanged();
                        dialog.cancel();
                    }
                });
                btn_cancel_addroom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        buttonprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,ProfileActivity.class);startActivity(intent);
            }
        });
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,Activity_Login.class);startActivity(intent);
            }
        });
        new CountDownTimer(1000000000,2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int temp_int=Integer.parseInt(list_info.get(0).getValue())+1;
                String temp_string=""+temp_int;
                list_info.get(0).setValue(temp_string);
                if(Integer.parseInt(list_info.get(0).getValue())==101)
                {
                    list_info.get(0).setValue("0");
                }
                minformationAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFinish() {

            }
        }.start();

    }
    private  List<Information> setListInfor()
    {
        list_info.add(new Information(R.drawable.iconthermometer_square,"Temperature","0"));
        list_info.add(new Information(R.drawable.iconhummid_square,"Humidity", "46%"));
        list_info.add(new Information(R.drawable.iconbrightness_square,"Brightness", "70%"));
        return list_info;
    }
    private List<Room> setListRoom()
    {
        list.add(new Room(R.drawable.iconlivingrom_square,"Living room"));
        list.add(new Room(R.drawable.iconbedroom_square,"Bed room"));
        list.add(new Room(R.drawable.iconbathroom_square,"Bath room"));
        list.add(new Room(R.drawable.icondinner_square,"Dinner room"));
        list.add(new Room(R.drawable.iconkitchen_square,"Kitchen"));
        list.add(new Room(R.drawable.icongarage_square,"Garage"));
        list.add(new Room(R.drawable.icongarden_square,"Garden"));
        list.add(new Room(R.drawable.iconbalcony_square,"Balcony"));
        list.add(new Room(R.drawable.iconstair_square,"Stairs"));
        list.add(new Room(R.drawable.icongymroom_square,"Gym"));
        list.add(new Room(R.drawable.icongate_square,"Gate"));
        readData();
        return list;
    }
    private void anhXa()
    {
        rcvRom=findViewById(R.id.rcv_rom);
        rcv1=findViewById(R.id.rcv_1);
        buttonprofile=findViewById(R.id.buttonprofile);
        addroom=findViewById(R.id.img_add);
        iv_back=findViewById(R.id.img_back_menu);
    }

    @Override
    public void onItemClick(Room rom) {
        if(rom.getName()=="Bed room")
        {
            Intent intent = new Intent(MenuActivity.this,MainActivity.class);
            startActivity(intent);
        }else
            Toast.makeText(this,rom.getName(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(Room rom) {
        final Room romTempremove=rom;
        final Dialog dialog =new Dialog(MenuActivity.this);
        dialog.setCancelable(false);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_remove);

        Window window=dialog.getWindow();
        if(window==null)
        {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button btn_yes_remove =(Button) dialog.findViewById(R.id.btn_yes_remove);
        Button btn_cancel_remove =(Button) dialog.findViewById(R.id.btn_no_remove);
        btn_yes_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checkdefault=true;
                for(int i=list.size()-1;i>10;i--)
                    {
                        if(romTempremove==list.get(i))
                             {
                                list.remove(romTempremove);
                                listTempRomName.remove(romTempremove.getName().trim());
                                checkdefault=false;
                                 saveData(listTempRomName);
                                mromAdapter.notifyDataSetChanged();
                                dialog.cancel();
                                break;
                             }
                    }
                if(checkdefault==true)
                {
                    customToast(R.layout.custom_toast_dialogremove,R.id.layout_custom_toast_dialogremove);
                    dialog.cancel();
                }

            }
        });
        btn_cancel_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    public void saveData(List<String> content){
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=openFileOutput(fileName,MODE_PRIVATE);
            for(int i=0;i<listTempRomName.size();i++)
            {
                fileOutputStream.write(listTempRomName.get(i).getBytes());
                fileOutputStream.write("\n".getBytes());
            }
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void readData(){
        try {
            FileInputStream in=openFileInput(fileName);
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            StringBuffer buffer=new StringBuffer();
            String line=null;
            while((line=br.readLine())!=null)
            {
                list.add(new Room(R.drawable.iconanonymousroom,line));
                listTempRomName.add(line);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void customToast(int layout, int idLayout)
    {
        Toast toast=new Toast(MenuActivity.this);
        LayoutInflater inflater=getLayoutInflater();
        View view=inflater.inflate(layout,(ViewGroup) findViewById(idLayout) );
        toast.setView(view);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }

}