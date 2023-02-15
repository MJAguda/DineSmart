package com.example.dinesmart;

public class Products {



    private String productName;
    private int productPrice;
    private String productBarcode;

    private static Products instance; // Singleton

    public static Products getInstance() {
        if(instance == null){
            instance = new Products();
        }
        return instance;
    }


    // Setters
    public void setProductName(String productName) {this.productName = productName;}
    public void setProductPrice(int productPrice) {this.productPrice = productPrice;}
    public void setProductBarcode(String productBarcode) {this.productBarcode = productBarcode;}

    // Getters
    public String getProductName() {return productName;}
    public int getProductPrice() {return productPrice;}
    public String getProductBarcode() {return productBarcode;}
}
