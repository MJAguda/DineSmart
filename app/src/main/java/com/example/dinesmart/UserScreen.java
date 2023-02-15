package com.example.dinesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class UserScreen extends AppCompatActivity {

    Users user = Users.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);

        TextView balance = findViewById(R.id.balance_TextView);

        Read read = new Read();
        read.readRecord("user/" + user.getIdNumber(), new Read.OnGetDataListener() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {

                balance.setText(Integer.toString(dataSnapshot.child("balance").getValue(Integer.class)));

            }

            @Override
            public void onFailure(DatabaseError databaseError) {

            }
        });


    }
}