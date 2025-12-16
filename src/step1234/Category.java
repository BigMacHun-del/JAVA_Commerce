package step1234;

import java.util.ArrayList;
import java.util.Scanner;

public class Category {
    //Product 클래스를 관리하는 클래스
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<String> categoryName =  new ArrayList<>();

    public Category() {  //상품 내용과 카테고리 이름 생성
        products.add(new Product("Galaxy S25", "1,200,000", "최신 안드로이드 스마트폰", 20));
        products.add(new Product("iPhone 16", "1,350,000", "Apple의 최신 스마트폰", 20));
        products.add(new Product("MacBook Pro", "2,400,000", "M3 칩셋이 탑재된 노트북", 20));
        products.add(new Product("AirPods Pro", "350,000", "노이즈 캔슬링 무선 이어폰", 20));

        categoryName.add("전자제품");
        categoryName.add("의류");
        categoryName.add("식품");
    }

    public void categoryProducts(int menuNumber) {  //메뉴 번호 입력 시 해당 메뉴 출력
        System.out.println("[ " + categoryName.get(menuNumber+1) + " 카테고리 ]");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i+1) + ". " +   products.get(i));
        }
        System.out.println("0. 뒤로가기");
    }

    public void choseProduct(int productNum) {  //선택한 상품 출력 메서드
        System.out.println("선택한 상품: " + products.get(productNum-1) + "| 재고: " + products.get(productNum).stock + "개");
    }

//    public String getCategoryName() {
//        return categoryName;
//    }
}
