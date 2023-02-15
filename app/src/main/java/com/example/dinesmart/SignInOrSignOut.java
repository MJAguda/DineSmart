package com.example.dinesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignInOrSignOut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_or_sign_out);

        //Declaration
        Button SignUp = findViewById(R.id.SignUp_Button);
        Button SignIn = findViewById(R.id.SignIn_Button);

        //Sign In got clicked
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignInOrSignOut.this,SignInScreen.class);
                startActivity(intent);
            }
        });

        //Sign Up got clicked
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignInOrSignOut.this,SignUpScreen.class);
                startActivity(intent);
            }
        });




    }
}