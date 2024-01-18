package com.example.myunitconverterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConverterActivity extends AppCompatActivity {

    private TextView textViewUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view based on the unit passed from MainActivity
        String unit = getIntent().getStringExtra("unit");

        if ("Length".equals(unit)) {
            setContentView(R.layout.activity_converter_length);

            EditText editTextValue = findViewById(R.id.editTextValue);
            Spinner spinnerFrom = findViewById(R.id.spinnerFrom);
            Spinner spinnerTo = findViewById(R.id.spinnerTo);
            Button buttonConvert = findViewById(R.id.buttonConvert);
            TextView textViewResult = findViewById(R.id.textViewResult);

            // Assuming the array resource 'unit_array_length' is defined in strings.xml
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                    this, R.array.unit_array_length, android.R.layout.simple_spinner_item);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinnerFrom.setAdapter(adapter);
            spinnerTo.setAdapter(adapter);

            buttonConvert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double value = Double.parseDouble(editTextValue.getText().toString());
                    String unitFrom = spinnerFrom.getSelectedItem().toString();
                    String unitTo = spinnerTo.getSelectedItem().toString();

                    double result;

                    // Conversion logic for Length
                    if (unitFrom.equals("Kilometers") && unitTo.equals("Meters")) {
                        result = value * 1000;
                    } else if (unitFrom.equals("Meters") && unitTo.equals("Kilometers")) {
                        result = value / 1000;
                    } else if (unitFrom.equals("Centimeters") && unitTo.equals("Meters")) {
                        result = value / 100;
                    } else if (unitFrom.equals("Millimeters") && unitTo.equals("Meters")) {
                        result = value / 1000;
                    } else if (unitFrom.equals("Feet") && unitTo.equals("Meters")) {
                        result = value / 3.28084;
                    } else if (unitFrom.equals("Kilometers") && unitTo.equals("Feet")) {
                        result = value * 3280.84;
                    } else if (unitFrom.equals("Kilometers") && unitTo.equals("Centimeters")) {
                        result = value * 100000;
                    } else if (unitFrom.equals("Centimeters") && unitTo.equals("Kilometers")) {
                        result = value / 100000;
                    } else if (unitFrom.equals("Kilometers") && unitTo.equals("Millimeters")) {
                        result = value * 1000000;
                    } else if (unitFrom.equals("Millimeters") && unitTo.equals("Kilometers")) {
                        result = value / 1000000;
                    } else if (unitFrom.equals("Feet") && unitTo.equals("Kilometers")) {
                        result = value * 0.0003048;
                    } else if (unitFrom.equals("Meters") && unitTo.equals("Centimeters")) {
                        result = value * 100;
                    } else if (unitFrom.equals("Meters") && unitTo.equals("Millimeters")) {
                        result = value * 1000;
                    } else if (unitFrom.equals("Meters") && unitTo.equals("Feet")) {
                        result = value * 3.28084;
                    } else if (unitFrom.equals("Centimeters") && unitTo.equals("Millimeters")) {
                        result = value * 10;
                    } else if (unitFrom.equals("Centimeters") && unitTo.equals("Feet")) {
                        result = value / 30.48;
                    } else if (unitFrom.equals("Feet") && unitTo.equals("Centimeters")) {
                        result = value * 30.48;
                    } else if (unitFrom.equals("Millimeters") && unitTo.equals("Kilometers")) {
                        result = value / 1000000;
                    } else if (unitFrom.equals("Millimeters") && unitTo.equals("Feet")) {
                        result = value / 304.8;
                    } else if (unitFrom.equals("Feet") && unitTo.equals("Millimeters")) {
                        result = value * 304.8;
                    } else {
                        result = value; // Default: No conversion
                    }

                    textViewResult.setText(String.format("%.2f %s = %.2f %s", value, unitFrom, result, unitTo));
                }
            });
        }
        else if ("Temperature".equals(unit)) {
            setContentView(R.layout.activity_converter_temperature);

            EditText editTextValue = findViewById(R.id.editTextValue);
            Spinner spinnerFrom = findViewById(R.id.spinnerFrom);
            Spinner spinnerTo = findViewById(R.id.spinnerTo);
            Button buttonConvert = findViewById(R.id.buttonConvert);
            TextView textViewResult = findViewById(R.id.textViewResult);

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                    this, R.array.unit_array_temperature, android.R.layout.simple_spinner_item);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinnerFrom.setAdapter(adapter);
            spinnerTo.setAdapter(adapter);

            buttonConvert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double value = Double.parseDouble(editTextValue.getText().toString());
                    String unitFrom = spinnerFrom.getSelectedItem().toString();
                    String unitTo = spinnerTo.getSelectedItem().toString();

                    double result;

                    // Conversion logic for Temperature
                    if (unitFrom.equals("Celsius") && unitTo.equals("Fahrenheit")) {
                        result = (value * 9 / 5) + 32;
                    } else if (unitFrom.equals("Fahrenheit") && unitTo.equals("Celsius")) {
                        result = (value - 32) * 5 / 9;
                    } else if (unitFrom.equals("Celsius") && unitTo.equals("Kelvin")) {
                        result = value + 273.15;
                    } else if (unitFrom.equals("Kelvin") && unitTo.equals("Celsius")) {
                        result = value - 273.15;
                    } else if (unitFrom.equals("Fahrenheit") && unitTo.equals("Kelvin")) {
                        result = (value - 32) * 5 / 9 + 273.15;
                    } else if (unitFrom.equals("Kelvin") && unitTo.equals("Fahrenheit")) {
                        result = (value - 273.15) * 9 / 5 + 32;
                    } else {
                        result = value; // Default: No conversion
                    }

                    textViewResult.setText(String.format("%.2f %s = %.2f %s", value, unitFrom, result, unitTo));
                }
            });
        }
        else if ("Weight".equals(unit)) {
            setContentView(R.layout.activity_converter_weight);

            EditText editTextValue = findViewById(R.id.editTextValue);
            Spinner spinnerFrom = findViewById(R.id.spinnerFrom);
            Spinner spinnerTo = findViewById(R.id.spinnerTo);
            Button buttonConvert = findViewById(R.id.buttonConvert);
            TextView textViewResult = findViewById(R.id.textViewResult);

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                    this, R.array.unit_array_weight, android.R.layout.simple_spinner_item);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinnerFrom.setAdapter(adapter);
            spinnerTo.setAdapter(adapter);

            buttonConvert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double value = Double.parseDouble(editTextValue.getText().toString());
                    String unitFrom = spinnerFrom.getSelectedItem().toString();
                    String unitTo = spinnerTo.getSelectedItem().toString();

                    double result;

                    // Conversion logic for Weight
                    if (unitFrom.equals("Kilograms") && unitTo.equals("Grams")) {
                        result = value * 1000;
                    } else if (unitFrom.equals("Grams") && unitTo.equals("Kilograms")) {
                        result = value / 1000;
                    } else {
                        result = value; // Default: No conversion
                    }

                    textViewResult.setText(String.format("%.2f %s = %.2f %s", value, unitFrom, result, unitTo));
                }
            });
        }
        else if ("Time".equals(unit)) {
            setContentView(R.layout.activity_converter_time);

            EditText editTextValue = findViewById(R.id.editTextValue);
            Spinner spinnerFrom = findViewById(R.id.spinnerFrom);
            Spinner spinnerTo = findViewById(R.id.spinnerTo);
            Button buttonConvert = findViewById(R.id.buttonConvert);
            TextView textViewResult = findViewById(R.id.textViewResult);

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                    this, R.array.unit_array_time, android.R.layout.simple_spinner_item);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinnerFrom.setAdapter(adapter);
            spinnerTo.setAdapter(adapter);

            buttonConvert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double value = Double.parseDouble(editTextValue.getText().toString());
                    String unitFrom = spinnerFrom.getSelectedItem().toString();
                    String unitTo = spinnerTo.getSelectedItem().toString();

                    double result;

                    // Conversion logic for Time (generalized)
                    if (unitFrom.equals(unitTo)) {
                        // No conversion needed if units are the same
                        result = value;
                    } else {
                        // Convert both units to a common base (e.g., seconds)
                        double valueInSeconds = convertToSeconds(value, unitFrom);
                        result = convertFromSeconds(valueInSeconds, unitTo);
                    }

                    textViewResult.setText(String.format("%.2f %s = %.2f %s", value, unitFrom, result, unitTo));
                }
            });
        }

        textViewUnit = findViewById(R.id.textViewUnit);
        textViewUnit.setText(unit + " Converter");
    }

    private double convertToSeconds(double value, String unit) {
        switch (unit) {
            case "Years":
                return value * 365 * 24 * 60 * 60;
            case "Months":
                return value * 30 * 24 * 60 * 60;
            case "Weeks":
                return value * 7 * 24 * 60 * 60;
            case "Days":
                return value * 24 * 60 * 60;
            case "Hours":
                return value * 60 * 60;
            case "Minutes":
                return value * 60;
            default: // Seconds
                return value;
        }
    }

    private double convertFromSeconds(double valueInSeconds, String unit) {
        switch (unit) {
            case "Years":
                return valueInSeconds / (365 * 24 * 60 * 60);
            case "Months":
                return valueInSeconds / (30 * 24 * 60 * 60);
            case "Weeks":
                return valueInSeconds / (7 * 24 * 60 * 60);
            case "Days":
                return valueInSeconds / (24 * 60 * 60);
            case "Hours":
                return valueInSeconds / (60 * 60);
            case "Minutes":
                return valueInSeconds / 60;
            default: // Seconds
                return valueInSeconds;
        }
    }
}
