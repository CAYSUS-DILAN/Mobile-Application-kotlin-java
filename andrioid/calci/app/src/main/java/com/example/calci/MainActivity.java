package com.example.calci;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;




import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import java.util.Random;


public class MainActivity extends AppCompatActivity {
    EditText fno,sno;
    Button add,sub,div,mul,rand_col;
    TextView ans;
    RadioGroup rg_col;
    RadioButton r1,r2,r3;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        fno=findViewById(R.id.txt1);
        sno=findViewById(R.id.txt2);
        add=findViewById(R.id.b_add);
        sub=findViewById(R.id.b_sub);
        mul=findViewById(R.id.b_mul);
        div=findViewById(R.id.b_div);
        ans=findViewById(R.id.txtvw1);
        rand_col=findViewById(R.id.rand_btn);
        rg_col=findViewById(R.id.rdgrp);
        r1=findViewById(R.id.red);
        r2=findViewById(R.id.blue);
        r3=findViewById(R.id.green);


        //calculation
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int t1,t2,result;
                t1=Integer.parseInt(fno.getText().toString());
                t2=Integer.parseInt(sno.getText().toString());
                result=t1+t2;
                ans.setText("Result = " +result);
            }
        });


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int t1,t2,result;
                t1=Integer.parseInt(fno.getText().toString());
                t2=Integer.parseInt(sno.getText().toString());
                result=t1-t2;
                ans.setText("Result = " +result);
            }
        });


        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int t1,t2,result;
                t1=Integer.parseInt(fno.getText().toString());
                t2=Integer.parseInt(sno.getText().toString());
                result=t1*t2;
                ans.setText("Result = " +result);
            }
        });


        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int t1,t2,result;
                t1=Integer.parseInt(fno.getText().toString());
                t2=Integer.parseInt(sno.getText().toString());
                result=t1/t2;
                ans.setText("Result = " +result);
            }
        });


        //random background color generator
        rand_col.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int color = Color.argb(254,random.nextInt(255),random.nextInt(256),random.nextInt(256));
                getWindow().getDecorView().setBackgroundColor(color);
            }
        });


        //background color using radio btn
        rg_col.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch(i) {
                    case R.id.red:
                        getWindow().getDecorView().setBackgroundColor(Color.RED);
                        break;
                    case R.id.blue:
                        getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                        break;
                    case R.id.green:
                        getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                        break;
                }
            }
        });
    }
}
