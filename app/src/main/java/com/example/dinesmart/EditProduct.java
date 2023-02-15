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

public class EditProduct extends AppCompatActivity {

    Products product = Products.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

        // Connect all components
        EditText productBarcode = findViewById(R.id.productBarcode_EditText);
        Button search = findViewById(R.id.Search_Button);
        EditText productName = findViewById(R.id.ProductName_EditText);
        EditText productPrice = findViewById(R.id.Price_EditText);
        Button save = findViewById(R.id.Save_Button);
        Button remove = findViewById(R.id.remove_Button);

        // Hide components
        productName.setVisibility(View.GONE);
        productPrice.setVisibility(View.GONE);
        save.setVisibility(View.GONE);
        remove.setVisibility(View.GONE);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Store barcode edittext component to product class
                product.setProductBarcode(productBarcode.getText().toString());

                // Fetch Product via barcode
                Read read = new Read();
                read.readRecord("products/" + product.getProductBarcode(), new Read.OnGetDataListener() {
                    @Override
                    public void onSuccess(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            // Unhide
                            productName.setVisibility(View.VISIBLE);
                            productPrice.setVisibility(View.VISIBLE);
                            save.setVisibility(View.VISIBLE);
                            remove.setVisibility(View.VISIBLE);

                            // Hide Button
                            search.setVisibility(View.GONE);

                            // put the fetch data to the EditText
                            productName.setText(dataSnapshot.child("productName").getValue(String.class));
                            productPrice.setText(Integer.toString(dataSnapshot.child("productPrice").getValue(Integer.class)));
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Product Not Found", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(DatabaseError databaseError) {
                        // handle error here
                    }
                });
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Store products info into the Product class
                product.setProductBarcode(productBarcode.getText().toString());
                product.setProductName(productName.getText().toString());
                product.setProductPrice(Integer.parseInt(productPrice.getText().toString()));

                // TODO Check if product already exists via barcode

                // Create Product
                Create create = new Create();
                create.createRecord("products/" + product.getProductBarcode() + "/productBarcode", product.getProductBarcode());
                create.createRecord("products/" + product.getProductBarcode() + "/productName", product.getProductName());
                create.createRecord("products/" + product.getProductBarcode() + "/productPrice", product.getProductPrice());

                Toast.makeText(getApplicationContext(), "Product Successfully saved", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(EditProduct.this, AdminScreen.class);
                startActivity(intent);
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Delete delete = new Delete();
                delete.deleteRecord("products/", product.getProductBarcode());

                Toast.makeText(getApplicationContext(), "Product Successfully removed", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(EditProduct.this, AdminScreen.class);
                startActivity(intent);
            }
        });
    }
}