package com.example.dinesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class SignInScreen extends AppCompatActivity {

    Users user = Users.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);

        //declare the variables
        EditText IdNumber = findViewById(R.id.IdNumber_EditText);
        EditText Password = findViewById(R.id.Password_EditText);
        Button SignIn = findViewById(R.id.SignIn_Button);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setIdNumber(IdNumber.getText().toString());
                user.setPassword(Password.getText().toString());

                Read read = new Read();
                read.readRecord("user/" + user.getIdNumber(), new Read.OnGetDataListener() {
                    @Override
                    public void onSuccess(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            // check password

                            read.readRecord("user/" +user.getIdNumber() + "/password", new Read.OnGetDataListener() {
                                @Override
                                public void onSuccess(DataSnapshot dataSnapshot) {
                                    if (dataSnapshot.getValue().equals(user.getPassword())){

                                        Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_LONG).show();

                                        Intent intent=new Intent(SignInScreen.this,UserScreen.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        //wrong password
                                        Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_LONG).show();
                                    }
                                }

                                @Override
                                public void onFailure(DatabaseError databaseError) {
                                    // handle error here
                                }
                            });
                        }
                        else {
                            read.readRecord("admin/" + user.getIdNumber(), new Read.OnGetDataListener() {
                                @Override
                                public void onSuccess(DataSnapshot dataSnapshot) {
                                    if(dataSnapshot.exists()){
                                        // check password
                                        read.readRecord("admin/" +user.getIdNumber() + "/password", new Read.OnGetDataListener() {
                                            @Override
                                            public void onSuccess(DataSnapshot dataSnapshot) {
                                                if (dataSnapshot.getValue().equals(user.getPassword())){

                                                    Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_LONG).show();

                                                    Intent intent=new Intent(SignInScreen.this,AdminScreen.class);
                                                    startActivity(intent);
                                                }
                                                else {
                                                    //wrong password
                                                    Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_LONG).show();
                                                }
                                            }

                                            @Override
                                            public void onFailure(DatabaseError databaseError) {
                                                // handle error here
                                            }
                                        });
                                    }
                                    else {
                                        //check ID didn't exist
                                        Toast.makeText(getApplicationContext(), "Invalid ID Number", Toast.LENGTH_LONG).show();
                                    }

                                }

                                @Override
                                public void onFailure(DatabaseError databaseError) {
                                    // handle error here
                                }
                            });
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