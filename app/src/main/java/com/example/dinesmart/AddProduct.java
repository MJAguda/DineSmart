package com.example.dinesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddProduct extends AppCompatActivity {

    Products product = Products.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);


        // Declare components
        EditText productBarcode = findViewById(R.id.ProductBarcode_EditText);
        EditText productName = findViewById(R.id.ProductName_EditText);
        EditText price = findViewById(R.id.Price_EditText);
        Button save = findViewById(R.id.Save_Button);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Store products info into the Product class
                product.setProductBarcode(productBarcode.getText().toString());
                product.setProductName(productName.getText().toString());
                product.setProductPrice(Integer.parseInt(price.getText().toString()));

                // TODO Check if product already exists via barcode

                // Create Product
                Create create = new Create();
                create.createRecord("products/" + product.getProductBarcode() + "/productBarcode", product.getProductBarcode());
                create.createRecord("products/" + product.getProductBarcode() + "/productName", product.getProductName());
                create.createRecord("products/" + product.getProductBarcode() + "/productPrice", product.getProductPrice());

                Toast.makeText(getApplicationContext(), "Product Successfully saved", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AddProduct.this, AdminScreen.class);
                startActivity(intent);
            }
        });
    }
}
