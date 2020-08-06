package com.sp.tracksg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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
        getSupportActionBar().setTitle("Select any one");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        title=findViewById(R.id.name);
        info=findViewById(R.id.info);
        map=findViewById(R.id.map);
        crowd=findViewById(R.id.crowd);

        final String name=getIntent().getStringExtra("key");


        if (name.equals("CausewayPoint"))
        {
            title.setText("Causeway Point");
        }
        if (name.equals("Junction8"))
        {
           title.setText("Junction 8");
        }
        if (name.equals("NorthpointCity"))
        {
           title.setText("Northpoint City");
        }
        if (name.equals("WaterwayPoint"))
        {
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
                Intent intent=new Intent(SelectMallActivity.this,MapActivity.class);
                intent.putExtra("key",name);
                startActivity(intent);
            }
        });
        crowd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SelectMallActivity.this,CrowdActivity.class);
                intent.putExtra("key",name);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}