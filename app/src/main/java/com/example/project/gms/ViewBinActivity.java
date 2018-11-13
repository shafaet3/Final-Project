package com.example.project.gms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewBinActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textViewProgressPercent, textViewSensorId, textViewTime;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bin);

        //Setting Firebase Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        progressBar = findViewById(R.id.progressBar);
        textViewProgressPercent = findViewById(R.id.id_tv_progress_percent);
        textViewSensorId = findViewById(R.id.id_tv_sensor_id);
        textViewTime = findViewById(R.id.id_tv_time);

    }

    @Override
    protected void onStart() {
        super.onStart();
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Bin bin2 = dataSnapshot.child("Bin2").getValue(Bin.class);
                progressBar.setProgress(bin2.getGarbage());
                textViewProgressPercent.setText(Integer.toString(bin2.getGarbage()) + "%\nFull");
                textViewSensorId.setText("Sensor Id: " + bin2.getSensorId());
                textViewTime.setText("Time: " + bin2.getTime());
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

    }
}
