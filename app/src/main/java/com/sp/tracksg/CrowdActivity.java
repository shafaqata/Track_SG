package com.sp.tracksg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class CrowdActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView mallImageView;
    TextView esticmatePeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crowd);

        toolbar=findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Crowd in Mall");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mallImageView=findViewById(R.id.mallImage);
        esticmatePeople=findViewById(R.id.mallCrowd);

        final String name=getIntent().getStringExtra("key");


        if (name.equals("CausewayPoint"))
        {
            mallImageView.setImageResource(R.drawable.causeway_point_crowd);
            esticmatePeople.setText("1567 People");
        }
        if (name.equals("Junction8"))
        {
            mallImageView.setImageResource(R.drawable.junction8_crowd);
            esticmatePeople.setText("1160 People");
        }
        if (name.equals("NorthpointCity"))
        {
            mallImageView.setImageResource(R.drawable.north_point_crod);
            esticmatePeople.setText("1567 People");
        }
        if (name.equals("WaterwayPoint"))
        {
            mallImageView.setImageResource(R.drawable.water_wayt_point_crowd);
            esticmatePeople.setText("1456  People");
        }

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