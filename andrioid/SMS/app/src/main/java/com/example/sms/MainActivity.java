package com.example.sms;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;




public class MainActivity extends AppCompatActivity {
    Button bsms,bcall,bemail,bmaps,bbrowser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        bsms=findViewById(R.id.btn_sms);
        bcall=findViewById(R.id.btn_call);
        bemail=findViewById(R.id.btn_email);
        bmaps=findViewById(R.id.btn_maps);
        bbrowser=findViewById(R.id.btn_browser);


        bsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smsintent=new Intent(Intent.ACTION_SENDTO);
                smsintent.setData(Uri.parse("smsto:"+"9945312550"));
                smsintent.putExtra("smsbody","This is SMS");
                startActivity(smsintent);
            }
        });


        bcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callintent=new Intent(Intent.ACTION_DIAL);
                callintent.setData(Uri.parse("tel:"+"7204206754"));
                callintent.putExtra("callbody","This is call");
                startActivity(callintent);
            }
        });


        bemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailintent=new Intent(Intent.ACTION_SENDTO);
                emailintent.setData(Uri.parse("mailto:"+"crys.mca.lab@gmail.com"));
                emailintent.putExtra("emailbody","This is email");
                startActivity(emailintent);
            }
        });


        bmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri mapUri=Uri.parse("geo:0,0?q=Bird watching point,Mangalore");
                Intent mapintent=new Intent(Intent.ACTION_VIEW,mapUri);
                startActivity(mapintent);
            }
        });


        bbrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri browserUri=Uri.parse("https://www.google.com");
                Intent browserintent=new Intent(Intent.ACTION_VIEW,browserUri);
                startActivity(browserintent);
            }
        });
    }
}
