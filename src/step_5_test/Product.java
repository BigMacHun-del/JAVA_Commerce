package step_5;

import java.util.ArrayList;

public class Product {
    private String productName;  //상품 이름
    private String price;  //상품 가격
    private String description; //상품 설명
    private int stock;  //상품 재고

    // 캡슐화: 각 필드 세터 세터
    public String getProductName() {return productName;}
    public void setProductName(String productName) {this.productName = productName;}
    public String getPrice() { return price; }
    public void setPrice(String price) {this.price = price;}
    public String getDescription() { return description; }
    public void setDescription(String description) {this.description = description;}
    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}

    public Product(String productName, String price, String description, int stock) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    @Override
    public String toString() {  //toString 오버라이드를 하지 않으면 List 출력시 주소값 출력 됨 + 출력 양식
        return productName + " | " + price + "원 | " +  description + " | 재고: " + stock;
    }



}
