package com.example.budgetapp1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CalculateBudgetActivity extends AppCompatActivity {
    int num1, num2, num3;

    EditText et_input1Input;
    EditText et_input2Input;
    EditText et_input3Input;

    Button budget_update;
    private EditText num1Input;
    private EditText num2Input;
    private EditText num3Input;
    private EditText sumInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_specific_budget);

        num1Input = findViewById(R.id.et_input1);
        num2Input = findViewById(R.id.et_input2);
        num3Input = findViewById(R.id.et_input3);

        sumInput = findViewById(R.id.et_sum);

        budget_update = (Button) findViewById(R.id.update_budget);
        budget_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.valueOf(et_input1Input.getText().toString());
                num2 = Integer.valueOf(et_input2Input.getText().toString());
                num3 = Integer.valueOf(et_input3Input.getText().toString());

                int result = num1 + num2 + num3;
                sumInput.setVisibility(View.VISIBLE);
                sumInput.setText(result);
            }
        });
    }

//    private void showToast(String text) {
//        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
//    }
}