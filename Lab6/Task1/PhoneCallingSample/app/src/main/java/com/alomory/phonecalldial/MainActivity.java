package com.alomory.phonecalldial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private static final int MY_PERMISSION_REQUEST_CODE_CALL_PHONE= 555;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void callNumber(View view) {
        EditText editText = (EditText) findViewById(R.id.editText_main);
        // Use format with "tel:" and phone number to create phoneNumber.
        String phoneNumber = String.format("tel: %s",
                editText.getText().toString());
        // Log the concatenated phone number for dialing.
        Log.d(TAG, getString(R.string.dial_number) + phoneNumber);
        Toast.makeText(this,
                getString(R.string.dial_number) + phoneNumber,
                Toast.LENGTH_LONG).show();
        // Create the intent.
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        // Set the data for the intent as the phone number.
        callIntent.setData(Uri.parse(phoneNumber));
        // If package resolves to an app, send intent.
        if (callIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(callIntent);
        } else {
            Log.e(TAG, "Can't resolve app for ACTION_CALL Intent.");
        }
    }



    public  void askPermissionAndCall(View v){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int sendPermission = ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE);

            if (sendPermission != PackageManager.PERMISSION_GRANTED) {
                this.requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSION_REQUEST_CODE_CALL_PHONE);
                return;
            }
        }
        this.callNumber(v);

    }

    @Override
    public void onRequestPermissionsResult (int requestCode , String permission[], int[] grantResult){
        super.onRequestPermissionsResult(requestCode, permission, grantResult);
        switch (requestCode){
            case MY_PERMISSION_REQUEST_CODE_CALL_PHONE:
                if(grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED){
                    Log.i(TAG, "Permission Denied");
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_LONG).show();

                }else{
                    Log.i(TAG, "Permission Granted");
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }
    @Override
    protected  void onActivityResult(int requestCode, int resultCode , Intent data){
        super.onActivityResult(requestCode, resultCode,data);
        if(requestCode == MY_PERMISSION_REQUEST_CODE_CALL_PHONE){
            if(resultCode == RESULT_OK){
                Toast.makeText(this, "Action Ok", Toast.LENGTH_LONG).show();
            } else if (requestCode == RESULT_CANCELED) {
                Toast.makeText(this, "Action Canceled", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Action Failed", Toast.LENGTH_LONG).show();
            }
        }

    }
}