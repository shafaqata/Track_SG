package com.sp.tracksg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SelectMallActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView title;
    CardView info,map,crowd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mall);

        toolbar=findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        title=findViewById(R.id.name);
        info=findViewById(R.id.info);
        map=findViewById(R.id.map);
        crowd=findViewById(R.id.crowd);

        final String name=getIntent().getStringExtra("key");


        if (name.equals("CausewayPoint"))
        {
            getSupportActionBar().setTitle("Select any one");
            title.setText("CausewayvPoint");
        }
        if (name.equals("Junction8"))
        {
            getSupportActionBar().setTitle("Junction 8");
           title.setText("Junction 8");

        }
        if (name.equals("NorthpointCity"))
        {
            getSupportActionBar().setTitle("Northpoint City");
           title.setText("Northpoint City");
        }
        if (name.equals("WaterwayPoint"))
        {
            getSupportActionBar().setTitle("Waterway Point");
           title.setText("Waterway Point");
        }


        info=findViewById(R.id.info);
        map=findViewById(R.id.map);
        crowd=findViewById(R.id.crowd);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(SelectMallActivity.this,ViewDataActivity.class);
                intent.putExtra("key",name);
                startActivity(intent);
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SelectMallActivity.this,MainActivity.class);
                intent.putExtra("key",name);
                startActivity(intent);
            }
        });


    }
}