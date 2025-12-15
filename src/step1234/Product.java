package step1234;

import java.util.ArrayList;

public class Product {
    String productName;  //상품 이름
    String price;  //상품 가격
    String description; //상품 설명
    int stock;  //상품 재고

    public Product(String productName, String price, String description, int stock) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    ArrayList<Product> products = new ArrayList<>();

    public String getProductName() {
        return productName;
    }
    public void setProductMembers(String productName, String price, String description, int stock) {
        products.add(new Product(productName, price, description, stock));
    }

    public ArrayList<Product> getProductMembers() {
        return products;
    }



}
