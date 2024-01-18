package com.example.myunitconverterapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonLength = findViewById(R.id.buttonLength);
        Button buttonTemperature = findViewById(R.id.buttonTemperature);
        Button buttonTime = findViewById(R.id.buttonTime);
        Button buttonWeight = findViewById(R.id.buttonWeight);

        buttonLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConverter("Length");
            }
        });

        buttonTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConverter("Temperature");
            }
        });

        buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConverter("Time");
            }
        });

        buttonWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConverter("Weight");
            }
        });
    }

    private void openConverter(String unit) {
        Intent intent = new Intent(this, ConverterActivity.class);
        intent.putExtra("unit", unit);
        startActivity(intent);
    }
}
