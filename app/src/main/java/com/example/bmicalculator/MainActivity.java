package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editWeight ,editHeight ,editInches;
        TextView result_btn;
        Button calcuateButton;
        editWeight = findViewById(R.id.editWeight);
        editHeight = findViewById(R.id.editHeight);
        editInches = findViewById(R.id.editInches);
        result_btn = findViewById(R.id.result_btn);
        calcuateButton = findViewById(R.id.calcuateButton);

        calcuateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int weight = Integer.parseInt(editWeight.getText().toString());
                int feet = Integer.parseInt(editHeight.getText().toString());
                int inches = Integer.parseInt(editInches.getText().toString());
                double bmi;
                int totalinches = feet * 12 + inches;
                double totalcm = totalinches * 2.53;
                double totalM = totalcm / 100;
                bmi = weight / (totalM * totalM);


                if (bmi > 25) {
                    result_btn.setBackgroundColor(getResources().getColor(R.color.orangish));
                    result_btn.setText("You're overweight!...");
                } else if (bmi < 18) {
                    result_btn.setBackgroundColor(getResources().getColor(R.color.redish));
                    result_btn.setText("you're underweight!...");
                } else {
                    result_btn.setBackgroundColor(getResources().getColor(R.color.greenish));
                    result_btn.setText("you're healthy...");
                }
            }
        });
    }
}