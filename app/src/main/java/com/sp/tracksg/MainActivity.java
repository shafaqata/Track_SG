package com.sp.tracksg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    CardView CausewayPoint,Junction8,NorthpointCity,WaterwayPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Track SG");


        CausewayPoint=findViewById(R.id.CausewayPoint);
        Junction8=findViewById(R.id.Junction8);
        NorthpointCity=findViewById(R.id.NorthpointCity);
        WaterwayPoint=findViewById(R.id.WaterwayPoint);



        CausewayPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SelectMallActivity.class);
                intent.putExtra("key","CausewayPoint");
                startActivity(intent);
            }
        });
        Junction8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SelectMallActivity.class);
                intent.putExtra("key","Junction8");
                startActivity(intent);
            }
        });
        NorthpointCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SelectMallActivity.class);
                intent.putExtra("key","NorthpointCity");
                startActivity(intent);

            }
        });
        WaterwayPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SelectMallActivity.class);
                intent.putExtra("key","WaterwayPoint");
                startActivity(intent);

            }
        });



    }
}