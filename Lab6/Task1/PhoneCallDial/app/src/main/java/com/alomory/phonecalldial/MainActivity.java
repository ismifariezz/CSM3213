package com.alomory.phonecalldial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void dialNumber(View view) {
        TextView textView = (TextView) findViewById(R.id.number_to_call);
        // Use format with "tel:" and phone number to create phoneNumber.
        String phoneNumber = textView.getText().toString();
        // Create the intent.
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        // Set the data for the intent as the phone number.
        dialIntent.setData(Uri.parse("tel:"+phoneNumber));
        if(dialIntent.resolveActivity(getPackageManager()) != null){
            startActivity(dialIntent);
        }else{
            Log.e(TAG, "Can't resolve app for ACTION_DIAL Intent.");
        }
    }

}