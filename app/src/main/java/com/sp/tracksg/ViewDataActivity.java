package com.sp.tracksg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewDataActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView mallImage;
    TextView mallAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        toolbar=findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mallImage=findViewById(R.id.mallImage);
        mallAddress=findViewById(R.id.mallAddress);


        String name=getIntent().getStringExtra("key");



        if (name.equals("CausewayPoint"))
        {
            getSupportActionBar().setTitle("Causeway Point");
            mallImage.setImageResource(R.drawable.causeway);
            mallAddress.setText("1 Woodlands Square Singapore 738099");
        }
        if (name.equals("Junction8"))
        {
            getSupportActionBar().setTitle("Junction 8");
            mallImage.setImageResource(R.drawable.juntion);
            mallAddress.setText("9 Bishan Pl, Singapore 579837");

        }
        if (name.equals("NorthpointCity"))
        {
            getSupportActionBar().setTitle("Northpoint City");
            mallImage.setImageResource(R.drawable.northpoint);
            mallAddress.setText("930 Yishun Avenue 2 Singapore 769098");
        }
        if (name.equals("WaterwayPoint"))
        {
            getSupportActionBar().setTitle("Waterway Point");
            mallImage.setImageResource(R.drawable.waterway);
            mallAddress.setText("83 Punggol Central Singapore 828761");
        }


    }
}