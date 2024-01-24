package com.example.sharedpreferences;// MainActivity.java
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (validateLogin(username, password)) {
                    // Save username and password to SharedPreferences
                    saveCredentials(username, password);

                    // Open success page
                    openSuccessPage();
                } else {
                    // Handle invalid login
                }
            }
        });

        // Check if there are stored credentials
        if (hasStoredCredentials()) {
            openSuccessPage();
        }
    }

    private boolean validateLogin(String username, String password) {
        // Add your login validation logic here
        // For simplicity, always return true in this example
        return true;
    }

    private void saveCredentials(String username, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    private boolean hasStoredCredentials() {
        return sharedPreferences.contains("username") && sharedPreferences.contains("password");
    }

    private void openSuccessPage() {
        Intent intent = new Intent(this, SuccessActivity.class);
        startActivity(intent);
        finish();
    }
}
