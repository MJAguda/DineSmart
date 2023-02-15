package com.example.dinesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_screen);

        Button Order = findViewById(R.id.Order_Button);
        Button Inventory = findViewById(R.id.Inventory_Button);
        Button Menu = findViewById(R.id.Menu_Button);
        Button Report = findViewById(R.id.Report_Button);
        Button User = findViewById(R.id.User_Button);
        Button Customer = findViewById(R.id.Customer_Button);

        //Order Button
        Button ViewOrder = findViewById(R.id.ViewOrder_Button);
        Button ManageOrder = findViewById(R.id.ManageOrder_Button);

        //Inventory Button
        Button ViewInventory = findViewById(R.id.ViewInventory_Button);
        Button UpdateInventory = findViewById(R.id.UpdateInventory_Button);

        //Menu Button
        Button AddProduct = findViewById(R.id.AddProduct_Button);
        Button EditMenu = findViewById(R.id.EditMenu_Button);
        Button RemoveProduct = findViewById(R.id.RemoveProduct_Button);

        //Report Button
        Button GenerateReportSale = findViewById(R.id.GenerateReportSale_Button);
        Button GenerateReportInventory = findViewById(R.id.GenerateReportInventory_Button);
        Button GenerateReportCustomer = findViewById(R.id.GenerateReportCustomer_Button);

        //User Button
        Button AddUser = findViewById(R.id.AddUser_Button);
        Button EditUser = findViewById(R.id.EditUser_Button);
        Button RemoveUser = findViewById(R.id.RemoveUser_Button);

        //Customer Button
        Button ViewCustomer = findViewById(R.id.ViewCustomer_Button);
        Button ManageCustomer = findViewById(R.id.ManageCustomer_Button);


        //Order button got clicked
        Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewOrder.setVisibility(View.VISIBLE);
                ManageOrder.setVisibility(View.VISIBLE);
                ViewInventory.setVisibility(View.GONE);
                UpdateInventory.setVisibility(View.GONE);
                AddProduct.setVisibility(View.GONE);
                EditMenu.setVisibility(View.GONE);
                RemoveProduct.setVisibility(View.GONE);
                GenerateReportSale.setVisibility(View.GONE);
                GenerateReportInventory.setVisibility(View.GONE);
                GenerateReportCustomer.setVisibility(View.GONE);
                AddUser.setVisibility(View.GONE);
                EditUser.setVisibility(View.GONE);
                RemoveUser.setVisibility(View.GONE);
                ViewCustomer.setVisibility(View.GONE);
                ManageCustomer.setVisibility(View.GONE);
            }
        });

        //Inventory button got clicked
        Inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewOrder.setVisibility(View.GONE);
                ManageOrder.setVisibility(View.GONE);
                ViewInventory.setVisibility(View.VISIBLE);
                UpdateInventory.setVisibility(View.VISIBLE);
                AddProduct.setVisibility(View.GONE);
                EditMenu.setVisibility(View.GONE);
                RemoveProduct.setVisibility(View.GONE);
                GenerateReportSale.setVisibility(View.GONE);
                GenerateReportInventory.setVisibility(View.GONE);
                GenerateReportCustomer.setVisibility(View.GONE);
                AddUser.setVisibility(View.GONE);
                EditUser.setVisibility(View.GONE);
                RemoveUser.setVisibility(View.GONE);
                ViewCustomer.setVisibility(View.GONE);
                ManageCustomer.setVisibility(View.GONE);
            }
        });

        //Menu button got clicked
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewOrder.setVisibility(View.GONE);
                ManageOrder.setVisibility(View.GONE);
                ViewInventory.setVisibility(View.GONE);
                UpdateInventory.setVisibility(View.GONE);
                AddProduct.setVisibility(View.VISIBLE);
                EditMenu.setVisibility(View.VISIBLE);
                RemoveProduct.setVisibility(View.VISIBLE);
                GenerateReportSale.setVisibility(View.GONE);
                GenerateReportInventory.setVisibility(View.GONE);
                GenerateReportCustomer.setVisibility(View.GONE);
                AddUser.setVisibility(View.GONE);
                EditUser.setVisibility(View.GONE);
                RemoveUser.setVisibility(View.GONE);
                ViewCustomer.setVisibility(View.GONE);
                ManageCustomer.setVisibility(View.GONE);
            }
        });

        Report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewOrder.setVisibility(View.GONE);
                ManageOrder.setVisibility(View.GONE);
                ViewInventory.setVisibility(View.GONE);
                UpdateInventory.setVisibility(View.GONE);
                AddProduct.setVisibility(View.GONE);
                EditMenu.setVisibility(View.GONE);
                RemoveUser.setVisibility(View.GONE);
                GenerateReportSale.setVisibility(View.VISIBLE);
                GenerateReportInventory.setVisibility(View.VISIBLE);
                GenerateReportCustomer.setVisibility(View.VISIBLE);
                AddUser.setVisibility(View.GONE);
                EditUser.setVisibility(View.GONE);
                RemoveUser.setVisibility(View.GONE);
                ViewCustomer.setVisibility(View.GONE);
                ManageCustomer.setVisibility(View.GONE);
            }
        });

        //User button got clicked
        User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewOrder.setVisibility(View.GONE);
                ManageOrder.setVisibility(View.GONE);
                ViewInventory.setVisibility(View.GONE);
                UpdateInventory.setVisibility(View.GONE);
                AddProduct.setVisibility(View.GONE);
                EditMenu.setVisibility(View.GONE);
                RemoveProduct.setVisibility(View.GONE);
                GenerateReportSale.setVisibility(View.GONE);
                GenerateReportInventory.setVisibility(View.GONE);
                GenerateReportCustomer.setVisibility(View.GONE);
                AddUser.setVisibility(View.VISIBLE);
                EditUser.setVisibility(View.VISIBLE);
                RemoveUser.setVisibility(View.VISIBLE);
                ViewCustomer.setVisibility(View.GONE);
                ManageCustomer.setVisibility(View.GONE);
            }
        });

        Customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewOrder.setVisibility(View.GONE);
                ManageOrder.setVisibility(View.GONE);
                ViewInventory.setVisibility(View.GONE);
                UpdateInventory.setVisibility(View.GONE);
                AddProduct.setVisibility(View.GONE);
                EditMenu.setVisibility(View.GONE);
                RemoveProduct.setVisibility(View.GONE);
                GenerateReportSale.setVisibility(View.GONE);
                GenerateReportInventory.setVisibility(View.GONE);
                GenerateReportCustomer.setVisibility(View.GONE);
                AddUser.setVisibility(View.GONE);
                EditUser.setVisibility(View.GONE);
                RemoveUser.setVisibility(View.GONE);
                ViewCustomer.setVisibility(View.VISIBLE);
                ManageCustomer.setVisibility(View.VISIBLE);
            }
        });
        
        //ViewOrder button got clicked
        ViewOrder.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               Intent intent=new Intent(AdminScreen.this,View_Order.class);
               startActivity(intent);
            }
        });

        //Manage Order button got clicked
        ManageOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminScreen.this,View_or_Manage.class);
                startActivity(intent);
            }
        });

        //ViewInventory button got clicked
        ViewInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminScreen.this,ViewInventory.class);
                startActivity(intent);
            }
        });

        //UpdateInventory button got clicked
        UpdateInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminScreen.this,UpdateInventory.class);
                startActivity(intent);
            }
        });

        //AddMenu button got clicked
        AddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminScreen.this,AddProduct.class);
                startActivity(intent);
            }
        });

        //EditMenu button got clicked
        EditMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminScreen.this,EditProduct.class);
                startActivity(intent);
            }
        });

        //RemoveMenu button got clicked
        RemoveProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminScreen.this,AddProduct.class);
                startActivity(intent);
            }
        });

        //GenerateReportSale button got clicked
        GenerateReportSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminScreen.this,GenerateReportSale.class);
                startActivity(intent);
            }
        });

        //GenerateReportInventory button got clicked
        GenerateReportInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminScreen.this,GenerateReportInventory.class);
                startActivity(intent);
            }
        });

        //GenerateReportCustomer button got clicked
        GenerateReportCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminScreen.this,GenerateReportOnCostumers.class);
                startActivity(intent);
            }
        });

        //AddUser button got clicked
        AddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminScreen.this,AddUser.class);
                startActivity(intent);
            }
        });

        //EditUser button got clicked
        EditUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminScreen.this,EditUser.class);
                startActivity(intent);
            }
        });

        //RemoveUser button got clicked
        RemoveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminScreen.this,RemoveUser.class);
                startActivity(intent);
            }
        });

        //ViewCustomer button got clicked
        ViewCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminScreen.this,ViewCostumer.class);
                startActivity(intent);
            }
        });

        //ManageCustomer button got clicked
        ManageCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminScreen.this,ManageCostumer.class);
                startActivity(intent);
            }
        });







    }
}