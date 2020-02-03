package com.example.budgetapp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculateBudgetActivity extends AppCompatActivity {

    int num1, num2, num3;
    private Button button;

    //EditText et_input1Input;
    //EditText et_input2Input;
    EditText et_input3Input;

    Button budget_update;
    //Button add_purchase;
    //private EditText num1Input;
    //private EditText num2Input;
    private EditText num3Input;
    private EditText sumInput;
    //private ViewGroup mainLayout;

    TextView tv;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_specific_budget);

        //num3Input = findViewById(R.id.et_input3);

        tv=findViewById(R.id.tv_title);
        st=getIntent().getExtras().getString("Store Name");
        tv.setText(st);

        button = (Button) findViewById(R.id.home);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBudgetAccount();
            }
        });

    }
    private void addEditView() {
        RelativeLayout ri=new RelativeLayout(this);
        EditText et=new EditText(this);
        Button b=new Button(this);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=(Integer) v.getTag();
                //mainLayout.removeViewAt(pos);
            }
        });
    }

    public void openBudgetAccount(){
        Intent intent = new Intent(CalculateBudgetActivity.this, BudgetAccount.class);
        //startActivity(intent);
        finish();
    }
}


//    private void showToast(String text) {
//        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
//    }
//}