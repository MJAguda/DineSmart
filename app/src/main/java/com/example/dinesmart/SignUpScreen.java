package com.example.dinesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.MediaRouteButton;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class SignUpScreen extends AppCompatActivity {


    Users user = Users.getInstance();

    public SignUpScreen() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);

        EditText FullName = findViewById(R.id.FullName_EditText);
        EditText IdNumber = findViewById(R.id.IdNumber_EditText);
        EditText Password = findViewById(R.id.Password_EditText);
        Button SignUp = findViewById(R.id.SignUp_Button);

        //connect Spinner from thew layout
        Spinner Role = findViewById(R.id.Role_Spinner);

        //Array Adapter
        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(this,
                R.array.role_array, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Role.setAdapter(yearAdapter);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setFullName(FullName.getText().toString());
                user.setIdNumber(IdNumber.getText().toString());
                user.setPassword(Password.getText().toString());
                user.setRole(Role.getSelectedItem().toString());


                // check if all fields are filled
                if (FullName.getText().toString().isEmpty() || IdNumber.getText().toString().isEmpty() || Password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_LONG).show();
                }
                else {
                    // Check if IDNumber exist
                    Read read = new Read();

                    read.readRecord("user/" + user.getIdNumber(), new Read.OnGetDataListener() {
                        @Override
                        public void onSuccess(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                Toast.makeText(getApplicationContext(), "Id Number is already registered", Toast.LENGTH_SHORT).show();

                            } else {
                                //create an account
                                Create create = new Create();

                                Toast.makeText(getApplicationContext(), "Successfully registered", Toast.LENGTH_LONG).show();

                                create.createRecord("user/" + user.getIdNumber() + "/fullname" , user.getFullName());
                                create.createRecord("user/" + user.getIdNumber() + "/id" , user.getIdNumber());
                                create.createRecord("user/" + user.getIdNumber() + "/password" , user.getPassword());
                                create.createRecord("user/" + user.getIdNumber() + "/role" , user.getRole());
                                create.createRecord("user/" + user.getIdNumber() + "/balance" , 0);
                                Intent intent=new Intent(SignUpScreen.this,SignInOrSignOut.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onFailure(DatabaseError databaseError) {
                            // handle error here
                        }
                    });


                }





                /*//check
                Log.d("FullName:", user.getFullName());
                Log.d("IdNumber:", user.getIdNumber());
                Log.d("Password:", user.getPassword());
                Log.d("Role:", user.getRole());
                 */
            }
        });
    }
}