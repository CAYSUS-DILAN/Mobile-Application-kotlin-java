package com.example.music;




import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.music.backgroundmusic;


public class MainActivity extends AppCompatActivity {
    Button bstart,bstop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        bstart=findViewById(R.id.start_btn);
        bstop=findViewById(R.id.stop_btn);


        bstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startintent=new Intent(MainActivity.this, backgroundmusic.class);
                startService(startintent);
            }
        });


        bstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stopintent=new Intent(MainActivity.this,backgroundmusic.class);
                stopService(stopintent);
            }
        });
    }
}
