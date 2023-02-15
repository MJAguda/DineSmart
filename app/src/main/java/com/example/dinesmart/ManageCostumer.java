package com.example.dinesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class ManageCostumer extends AppCompatActivity {

    Users user = Users.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_costumer);

        // Declare Components
        EditText idNumber = findViewById(R.id.idNumber_EditText);
        TextView currentBalance = findViewById(R.id.currentBalance_TextView);
        Button search = findViewById(R.id.searchId_Button);

        EditText cashInAmount = findViewById(R.id.cashInAmount_EditText);
        Button cashIn = findViewById(R.id.cashIn_Button);

        cashInAmount.setVisibility(View.GONE);
        cashIn.setVisibility(View.GONE);


        // If Button search is pressed search database for id
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user.setIdNumber(idNumber.getText().toString());

                Read read = new Read();
                read.readRecord("user/" + user.getIdNumber(), new Read.OnGetDataListener() {
                    @Override
                    public void onSuccess(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.exists()){

                            // Set currentAmount
                            Long value = dataSnapshot.child("balance").getValue(Long.class);
                            user.setBalance(Math.toIntExact(value));
                            currentBalance.setText("Bulawan " + value);

                            // Set visible
                            cashInAmount.setVisibility(View.VISIBLE);
                            cashIn.setVisibility(View.VISIBLE);

                            // set gone button search
                            search.setVisibility(View.GONE);

                            cashIn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    // get cashIn Amount
                                    int amount = Integer.parseInt(String.valueOf(cashInAmount.getText()));

                                    user.setBalance(user.getBalance() + amount);

                                    Update update = new Update();
                                    update.updateRecord("user/" + user.getIdNumber(), "balance", user.getBalance());

                                    Toast.makeText(getApplicationContext(), "Cash In Successfully", Toast.LENGTH_SHORT).show();

                                    // TODO Get new balance
                                    currentBalance.setText("Bulawan " + user.getBalance());
                                }
                            });

                        }
                        else {
                            Toast.makeText(getApplicationContext(), "ID Number not found", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(DatabaseError databaseError) {
                        // handle error here
                    }
                });
            }
        });
    }
}
