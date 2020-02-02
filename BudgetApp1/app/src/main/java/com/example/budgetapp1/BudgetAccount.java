package com.example.budgetapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class BudgetAccount<response> extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_account);

        ArrayList<Card> cardList = new ArrayList<>();
        cardList.add(new Card(R.drawable.ic_credit_card_black_24dp, "Gong Cha", /*Budget: $15.00\nSpent: $6.76       */"Remaining: $8.43"));
        cardList.add(new Card(R.drawable.ic_credit_card_black_24dp,"No Frills", /*Budget: $50.00\nSpent: $22.32       */"Remaining: $27.68"));
        cardList.add(new Card(R.drawable.ic_credit_card_black_24dp,"Tim Horton's", /*Budget: $40.00\nSpent: $17.15       */"Remaining: $22.85"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(cardList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
}
