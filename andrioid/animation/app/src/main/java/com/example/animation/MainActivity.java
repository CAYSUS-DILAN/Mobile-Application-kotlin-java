package com.example.animation;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    Button btn_graphics,btn_animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        btn_graphics=findViewById(R.id.b_graphics);
        btn_animation=findViewById(R.id.b_ani);


        btn_graphics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this, com.example.animation.MainActivity2.class);
                startActivity(i1);
            }
        });


        btn_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(MainActivity.this, com.example.animation.MainActivity3.class);
                startActivity(i2);
            }
        });
    }
}
