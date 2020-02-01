package com.example.budgetapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBudgetAccount();
            }
        });
    }

    public void openBudgetAccount() {
        Intent intent = new Intent(this, BudgetAccount.class);
        startActivity(intent);

    }
}
