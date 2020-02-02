package com.example.budgetapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class BudgetAccount<response> extends AppCompatActivity {
    private ArrayList<Card> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;
    private Button buttonRemove;
   // private EditText editTextInsert;
   // private EditText editTextRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_account);

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
                insertItem(position);
            }
        });

       /* buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = mExampleList.size();
                insertItem(position);

            }
        });*/

    }

    public void insertItem(int position){
        mExampleList.add(new Card(R.drawable.ic_credit_card_black_24dp, "Store Name", "Remaining: $0.00"));
        mAdapter.notifyDataSetChanged();
    }

    public void changeItem(int position, String text){
        mExampleList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);

    }

    /*public void removeItem(int position){


    }*/

    public void createExampleList(){
        mExampleList = new ArrayList<>();
        mExampleList.add(new Card(R.drawable.ic_credit_card_black_24dp, "Gong Cha", /*Budget: $15.00\nSpent: $6.76       */"Remaining: $8.43"));
        mExampleList.add(new Card(R.drawable.ic_credit_card_black_24dp,"No Frills", /*Budget: $50.00\nSpent: $22.32       */"Remaining: $27.68"));
        mExampleList.add(new Card(R.drawable.ic_credit_card_black_24dp,"Tim Horton's", /*Budget: $40.00\nSpent: $17.15       */"Remaining: $22.85"));
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
            }
        });
    }
}
