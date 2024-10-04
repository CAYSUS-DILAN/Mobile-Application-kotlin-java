package com.example.prog3;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity3 extends AppCompatActivity {
    TextView txt1,txt2,txt3,txt4;
    Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);


        txt1=findViewById(R.id.txtView1);
        txt2=findViewById(R.id.txtView2);
        txt3=findViewById(R.id.txtView3);
        txt4=findViewById(R.id.txtView4);
        b3=findViewById(R.id.button3);


        String text1=getIntent().getStringExtra("data1");
        txt1.setText(text1);
        String text2=getIntent().getStringExtra("data2");
        txt2.setText(text2);
        String text3=getIntent().getStringExtra("data3");
        txt3.setText(text3);
        String text4=getIntent().getStringExtra("data4");
        txt4.setText(text4);


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(MainActivity3.this,MainActivity.class);
                startActivity(i3);
            }
        });
    }
}
