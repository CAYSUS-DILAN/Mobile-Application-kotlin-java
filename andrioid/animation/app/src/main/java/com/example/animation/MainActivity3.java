package com.example.animation;


import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.animation.R;


public class MainActivity3 extends AppCompatActivity {
    ImageView img;
    Button btn_fade,btn_rot,btn_zoom,btn_blink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);


        btn_fade=findViewById(R.id.b_fade);
        btn_rot=findViewById(R.id.b_rotate);
        btn_zoom=findViewById(R.id.b_zoom);
        btn_blink=findViewById(R.id.b_blink);


        img=findViewById(R.id.image);


        btn_fade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation fade_ani = AnimationUtils.loadAnimation(MainActivity3.this,R.anim.fade);
                img.startAnimation(fade_ani);
            }
        });


        btn_rot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation rotate_ani = AnimationUtils.loadAnimation(MainActivity3.this,R.anim.rotate);
                img.startAnimation(rotate_ani);
            }
        });


        btn_zoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation zoom_ani = AnimationUtils.loadAnimation(MainActivity3.this,R.anim.zoom);
                img.startAnimation(zoom_ani);
            }
        });


        btn_blink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation blink_ani = AnimationUtils.loadAnimation(MainActivity3.this,R.anim.blink);
                img.startAnimation(blink_ani);
            }
        });


    }
}
