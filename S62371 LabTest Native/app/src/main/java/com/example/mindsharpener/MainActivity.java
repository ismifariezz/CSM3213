package com.example.mindsharpener;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonOption1, radioButtonOption2, radioButtonOption3;
    private Button myButton, checkButton;
    private EditText editTextExample;
    private TextView textView4, textView6, textViewOperator, textViewPoints;

    private int points = 0; // Variable to keep track of user points

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        radioButtonOption1 = findViewById(R.id.radioButtonOption1);
        radioButtonOption2 = findViewById(R.id.radioButtonOption2);
        radioButtonOption3 = findViewById(R.id.radioButtonOption3);
        myButton = findViewById(R.id.myButton);
        checkButton = findViewById(R.id.myButton);
        editTextExample = findViewById(R.id.editTextExample);
        textView4 = findViewById(R.id.TextView4);
        textView6 = findViewById(R.id.TextView6);
        textViewOperator = findViewById(R.id.TextView5);
        textViewPoints = findViewById(R.id.TextView8);


        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyAnswer();
            }
        });

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateQuestion();
            }
        });
    }

    private void generateQuestion() {
        // Retrieve the selected level
        int selectedLevel = getSelectedLevel();

        // Generate two operands and an operator based on the selected level
        Random random = new Random();

        int operand1, operand2, operator;
        switch (selectedLevel) {
            case 1:
                // Level i3: Display maximum one-digit operands
                operand1 = random.nextInt(10);
                operand2 = random.nextInt(10);
                operator = random.nextInt(4); // 0 to 3 for +, -, *, /
                break;
            case 2:
                // Level i5: Display maximum 2 digits operands
                operand1 = random.nextInt(100);
                operand2 = random.nextInt(100);
                operator = random.nextInt(4); // 0 to 3 for +, -, *, /
                break;
            case 3:
            default:
                // Level i7 (default): Display maximum 3 digits operands
                operand1 = random.nextInt(1000);
                operand2 = random.nextInt(1000);
                operator = random.nextInt(4); // 0 to 3 for +, -, *, /
                break;
        }

        // Display the generated operands and operator
        String symbol = "";
        switch (operator) {
            case 0:
                symbol = "+";
                break;
            case 1:
                symbol = "-";
                break;
            case 2:
                symbol = "*";
                break;
            case 3:
                symbol = "/";
                break;
        }

        textView4.setText(String.valueOf(operand1));
        textView6.setText(String.valueOf(operand2));
        textViewOperator.setText(symbol);

        // Clear the user's previous answer
        editTextExample.setText("");
    }

    private void verifyAnswer() {
        // Get user's answer
        String userAnswerStr = editTextExample.getText().toString();

        // Get operands and operator from TextViews
        int operand1 = Integer.parseInt(textView4.getText().toString());
        int operand2 = Integer.parseInt(textView6.getText().toString());
        String operator = textViewOperator.getText().toString();

        // Calculate the correct answer
        int correctAnswer = calculateAnswer(operand1, operand2, operator);

        // Compare user's answer with correct answer
        if (userAnswerStr.equals(String.valueOf(correctAnswer))) {
            // If correct, increase points by 1
            points++;
        } else {
            // Otherwise, deduct points by 1
            points--;
        }

        // Update the points display
        textViewPoints.setText("POINT: " + points);

        // Display another question
        generateQuestion();
    }

    private int calculateAnswer(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                return 0; // Default case, should not happen if operator is valid
        }
    }

    private int getSelectedLevel() {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == radioButtonOption1.getId()) {
            return 1; // Level i3
        } else if (selectedId == radioButtonOption2.getId()) {
            return 2; // Level i5
        } else {
            return 3; // Level i7 (default)
        }
    }
}
