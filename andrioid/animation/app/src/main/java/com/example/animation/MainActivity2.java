package com.example.animation;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.animation.R;


public class MainActivity2 extends AppCompatActivity {


    Bitmap bp;
    Button btn_rect,btn_sqr,btn_circ,btn_line;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);


        btn_rect=findViewById(R.id.b_rect);
        btn_sqr=findViewById(R.id.b_square);
        btn_circ=findViewById(R.id.b_circle);
        btn_line=findViewById(R.id.b_line);
        bp=Bitmap.createBitmap(800,1200,Bitmap.Config.ARGB_8888);
        img=findViewById(R.id.image);
        img.setImageBitmap(bp);
        Canvas c=new Canvas(bp);


        btn_rect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paint p1=new Paint();
                p1.setColor(Color.GREEN);
                p1.setTextSize(50);


                c.drawText("Rectangle",100,150,p1);
                c.drawRect(100,200,300,500,p1);
            }
        });


        btn_sqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Paint p2=new Paint();
                p2.setColor(Color.YELLOW);
                p2.setTextSize(50);


                c.drawText("Square",480,150,p2);
                c.drawRect(480,200,680,400,p2);


            }
        });


        btn_circ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Paint p3=new Paint();
                p3.setColor(Color.RED);
                p3.setTextSize(50);


                c.drawText("Circle",100,600,p3);
                c.drawCircle(200,800,80,p3);


            }
        });


        btn_line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Paint p4=new Paint();
                p4.setColor(Color.CYAN);
                p4.setTextSize(50);


                c.drawText("Line",400,600,p4);
                c.drawLine(450,700,700,1000,p4);


            }
        });


    }
}
