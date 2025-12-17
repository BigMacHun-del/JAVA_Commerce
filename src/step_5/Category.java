package step_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Category {
    //Product 클래스를 관리하는 클래스
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<String> categoryName =  new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    //캡슐화 List 게터 세터
    public ArrayList<Product> getProducts() {return products;}
    public void setProducts(ArrayList<Product> products) {this.products = products;}
    public ArrayList<String> getCategoryName() {return categoryName;}
    public void setCategoryName(ArrayList<String> categoryName) {this.categoryName = categoryName;}

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
        System.out.println("[ " + categoryName.get(menuNumber-1) + " 카테고리 ]");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i+1) + ". " +   products.get(i));
        }
        System.out.println("0. 뒤로가기");
    }

    public void choseProduct(int productNum, Cart cart) {  //선택한 상품 출력 메서드
        if (productNum == 0) {
            System.out.println("뒤로가기");
        } else if (productNum <= products.size()) {  //저장되어 있는 상품 범위 내
            System.out.println("선택한 상품: " + products.get(productNum-1) + " | 재고: " + products.get(productNum).getStock() + "개 \n");
            System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인       아무 숫자: 취소");
            int choice = sc.nextInt();
            try {
                if (choice == 1) {
                    System.out.print("수량 입력: ");
                    int quantity = sc.nextInt();
                    cart.addCartItem(products.get(productNum-1), quantity);
                }
            } catch (Exception e){
                System.out.println("숫자를 입력하세요.");
            }
        } else {
            System.out.println("입력 오류");
        }
    }


}
