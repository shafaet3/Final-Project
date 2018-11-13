package com.example.project.gms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddBinActivity extends AppCompatActivity {
    private EditText editTextBinName, editTextPercentValueSms, editTextMobile;
    private Button buttonAddBin;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bin);
        
        editTextBinName = findViewById(R.id.id_et_bin_name);
        editTextPercentValueSms = findViewById(R.id.id_et_percent_value_for_sms);
        editTextMobile = findViewById(R.id.id_et_mobile_number);
        buttonAddBin = findViewById(R.id.id_btn_add);

        // Setting Firebase Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Bin2");
        
        buttonAddBin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBin();
            }
        });
    }

    private void addBin() {
        String binName = editTextBinName.getText().toString();
        String percentValueSms = editTextPercentValueSms.getText().toString();
        String mobile = editTextMobile.getText().toString();
        if(TextUtils.isEmpty(binName)){
            Toast.makeText(this, "Bin Name is Required", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(percentValueSms)){
            Toast.makeText(this, "Percent Value is Required", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(mobile)){
            Toast.makeText(this, "Mobile is Required", Toast.LENGTH_SHORT).show();
        }
        else{
            sendDataToFireBase(binName, percentValueSms, mobile);
        }
    }

    private void sendDataToFireBase(String binName, String percentValueSms, String mobile) {
        Toast.makeText(this, "data send to firebase", Toast.LENGTH_SHORT).show();

    }
}
