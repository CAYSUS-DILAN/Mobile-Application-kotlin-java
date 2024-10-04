package com.example.prog3;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity2 extends AppCompatActivity {
    TextView txtvw2;
    EditText ed1,ed2,ed3,ed4;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);


        txtvw2=findViewById(R.id.textView2);
        ed1=findViewById(R.id.editTextText1);
        ed2=findViewById(R.id.editTextText2);
        ed3=findViewById(R.id.editTextText3);
        ed4=findViewById(R.id.editTextText4);
        b2=findViewById(R.id.button2);


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(MainActivity2.this,MainActivity3.class);
                String text1=ed1.getText().toString();
                i2.putExtra("data1",text1);
                String text2=ed2.getText().toString();
                i2.putExtra("data2",text2);
                String text3=ed3.getText().toString();
                i2.putExtra("data3",text3);
                String text4=ed4.getText().toString();
                i2.putExtra("data4",text4);
                startActivity(i2);
            }
        });
    }
}
