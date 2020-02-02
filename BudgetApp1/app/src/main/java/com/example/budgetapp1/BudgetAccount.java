package com.example.budgetapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class BudgetAccount<response> extends AppCompatActivity {
    private ArrayList<Card> mExampleList = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;
    private Button buttonRemove;
   // private EditText editTextInsert;
   // private EditText editTextRemove;

    private String st;
    //private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_account);

        mExampleList.add(new Card(R.drawable.ic_credit_card_black_24dp, "Gong Cha", /*Budget: $15.00\nSpent: $6.76       */"Remaining: $8.43"));
        mExampleList.add(new Card(R.drawable.ic_credit_card_black_24dp,"No Frills", /*Budget: $50.00\nSpent: $22.32       */"Remaining: $27.68"));
        mExampleList.add(new Card(R.drawable.ic_credit_card_black_24dp,"Tim Horton's", /*Budget: $40.00\nSpent: $17.15       */"Remaining: $22.85"));


        createExampleList();
        buildRecycleView();

        buttonInsert = findViewById(R.id.button_insert);
        //buttonRemove = findViewById(R.id.button_remove);
        //editTextInsert = findViewById(R.id.edittext_insert);
        //editTextRemove = findViewById(R.id.edittext_remove);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = mExampleList.size();
                insertItem(position, "New Store", 10);

            }
        });


       /* buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Overrides
            public void onClick(View v) {
                int position = mExampleList.size();
                insertItem(position);

            }
        });*/

    }

    public void insertItem(int position, String name, float balance){
        mExampleList.add(new Card(R.drawable.ic_credit_card_black_24dp, name, "Remaining: " + Float.toString(balance)));
        mAdapter.notifyDataSetChanged();
    }

    public void changeItem(int position, String text){
        //mExampleList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);


    }

    /*public void removeItem(int position){


    }*/

    public void createExampleList(){

    }

    public void buildRecycleView(){

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");

                openActivity(position);
            }
        });
    }

    public void openActivity(int pos){
        //if ()
        Intent myIntent = new Intent(BudgetAccount.this, CalculateBudgetActivity.class);
        st = mExampleList.get(pos).getText1();
        myIntent.putExtra("Store Name", st);
        //myIntent.putExtra()
        startActivity(myIntent);
    }
}
