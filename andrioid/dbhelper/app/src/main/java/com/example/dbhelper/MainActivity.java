package com.example.dbhelper;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    EditText name,mobile,dob,address;
    Button insert,view;
    MyDBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        name=findViewById(R.id.editText1);
        mobile=findViewById(R.id.editText2);
        dob=findViewById(R.id.editText3);
        address=findViewById(R.id.editText4);
        insert=findViewById(R.id.button1);
        view=findViewById(R.id.button2);
        db=new MyDBHelper(this);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username=name.getText().toString();
                String Usercon=mobile.getText().toString();
                String Userdob=dob.getText().toString();
                String Useradd=address.getText().toString();
                Boolean checkinsert=db.insertdata(Username, Usercon, Userdob, Useradd);
                if( checkinsert == true) {
                    Toast.makeText(MainActivity.this, "USER DATA INSERTED!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "USER DATA NOT INSERTED!",Toast.LENGTH_SHORT).show();
                }
            }
        });


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=db.getdata();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity.this,"NO ENTRY EXISTS!",Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("NAME:" +res.getString(0) +"\n");
                    buffer.append("MOBILE:" +res.getString(1) +"\n");
                    buffer.append("DOB:" +res.getString(2) +"\n");
                    buffer.append("ADDRESS:" +res.getString(3) +"\n\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("USER ENTRIES");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}
