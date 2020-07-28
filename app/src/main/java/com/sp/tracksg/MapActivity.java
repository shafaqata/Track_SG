package com.sp.tracksg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    Toolbar toolbar;
    LatLng latLng;
    MapView mapView;
    GoogleMap gMap;


    private static final int REQUEST_CODE_PERMISIION = 10101;
    private static final int ERROR_CODE = 1111;
    boolean allReadyAnimate = false;
    boolean mLocationPermisisionGranter;
    LatLng currentLatln, destinationLatLn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Location");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final String name = getIntent().getStringExtra("key");


        mapView = findViewById(R.id.mapView);
        initMap();
        mapView.getMapAsync(this);
        mapView.onCreate(savedInstanceState);
        if (name.equals("CausewayPoint")) {
            latLng = new LatLng(1.436923, 103.786516);
          //  GotoMyLocation(latLng);
        } else if (name.equals("Junction8")) {
            latLng = new LatLng(1.350696, 103.848762);
         //   GotoMyLocation(latLng);
        }
        if (name.equals("NorthpointCity")) {
            latLng = new LatLng(1.428026, 103.836413);
          //
        }
        if (name.equals("WaterwayPoint")) {
            latLng = new LatLng(1.406716, 103.902175);
           // GotoMyLocation(latLng);
        }


    }

    private void initMap() {

        if (isServicesOK()) {
            if (PermissionOK()) {
                Toast.makeText(this, "Map is Ready", Toast.LENGTH_SHORT).show();
            } else {
                RequestPermission();
            }
        }
    }

    private boolean isServicesOK() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int result = apiAvailability.isGooglePlayServicesAvailable(this);
        if (result == ConnectionResult.SUCCESS) {
            Toast.makeText(this, "Google Play Services OK", Toast.LENGTH_SHORT).show();
            return true;
        } else if (apiAvailability.isUserResolvableError(result)) {
            Dialog dialog = apiAvailability.getErrorDialog(this, result, ERROR_CODE, new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    Toast.makeText(getApplicationContext(), "Dialog is Cancelled By User", Toast.LENGTH_SHORT).show();

                }

            });
            dialog.show();
        } else {
            Toast.makeText(this, "Google Play Service is required for Google maps", Toast.LENGTH_SHORT).show();
        }

        return false;
    }

    private boolean PermissionOK() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void RequestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_PERMISIION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_PERMISIION && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            mLocationPermisisionGranter = true;
        } else {
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
//        gMap.getUiSettings().setZoomControlsEnabled(true);
//        gMap.addMarker(new MarkerOptions().position(/*some location*/));
//        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(/*some location*/, 10));
        GotoMyLocation(latLng);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    boolean isGpsEnabled() {
        LocationManager locationManage = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        return locationManage.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    private void GotoMyLocation(LatLng latLng) {


        CameraUpdate cameraUpdate1 = CameraUpdateFactory.newLatLngZoom(latLng, 15);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("I am Here");
        markerOptions.draggable(false);
        gMap.addMarker(markerOptions);

        gMap.animateCamera(cameraUpdate1);

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