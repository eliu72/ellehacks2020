package com.example.budgetapp1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import io.radar.sdk.Radar;
import io.radar.sdk.Radar.RadarCallback;
import io.radar.sdk.model.RadarEvent;
import io.radar.sdk.model.RadarGeofence;
import io.radar.sdk.model.RadarUser;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private static final String TAG = "MainActivity";

    String publishableKey = "prj_test_sk_fe0a41bd41c57ac3db51128fa414e3412f9b47b6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Radar.initialize(publishableKey);
        Radar.setUserId("selina");
        Radar.setDescription("test user profile");

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.ACCESS_FINE_LOCATION }, 0);
        }

        Radar.trackOnce(new RadarCallback() {
            @Override
            public void onComplete(Radar.RadarStatus status, Location location, RadarEvent[] events, RadarUser user) {
                button.setEnabled(true);

                String statusString = Utils.stringForStatus(status);

                if (status == Radar.RadarStatus.SUCCESS) {
                    Log.i(TAG, statusString);

                    RadarGeofence[] geofences = user.getGeofences();
                    if (geofences != null) {
                        for (RadarGeofence geofence : geofences) {
                            String geofenceString = geofence.getDescription();
                            Log.i(TAG, geofenceString);
                        }
                    }

                    if (user.getPlace() != null) {
                        String placeString = user.getPlace().getName();
                        Log.i(TAG, placeString);
                    }

                    for (RadarEvent event : events) {
                        String eventString = Utils.stringForEvent(event);
                        Log.i(TAG, eventString);
                    }
                } else {
                    Log.e(TAG, statusString);
                }
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBudgetAccount();
            }
        });
    }
    public void openBudgetAccount() {
        Intent intent = new Intent(this, BudgetAccount.class);
        startActivity(intent);
    }
}
