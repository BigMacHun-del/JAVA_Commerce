package step_5;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Category {
    //Product 클래스를 관리하는 클래스
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<String> categoryName =  new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    //캡슐화 List 게터 세터
    public ArrayList<Product> getProducts() {return products;}
    public ArrayList<String> getCategoryName() {return categoryName;}
    public void setCategoryName(ArrayList<String> categoryName) {this.categoryName = categoryName;}
    //public int getProductsStock(int i) {return products.get(i).getStock();}  //매니저 클래스에서 재고 확인 게터

    public Category() {  //상품 내용과 카테고리 이름 생성
        products.add(new Product("Galaxy S25", "1,200,000", "최신 안드로이드 스마트폰", 30));
        products.add(new Product("iPhone 16", "1,350,000", "Apple의 최신 스마트폰", 40));
        products.add(new Product("MacBook Pro", "2,400,000", "M3 칩셋이 탑재된 노트북", 50));
        products.add(new Product("AirPods Pro", "350,000", "노이즈 캔슬링 무선 이어폰", 20));
        products.add(new Product("test", "350,000", "노이즈 캔슬링 무선 이어폰", 20));

        categoryName.add("전자제품");
        categoryName.add("의류");
        categoryName.add("식품");
    }

    public void categoryProducts(int menuNumber) {  //메뉴 번호 입력 시 해당 메뉴 출력 -> 관리자 메뉴에서 다시 쓸 수 있는데 메뉴 출력문 때문에 못 씀.(재사용성 문제)
        System.out.println("[ " + categoryName.get(menuNumber-1) + " 카테고리 ]");
        AtomicInteger number = new AtomicInteger(1); // 자동으로 반복이 끝나면 1씩 증가하게 됨
        products.stream().forEach(product ->  System.out.println(number.getAndIncrement() + ". " + product));
        // 스트림, 람다식 사용

    }

    public void choseProduct(int productNum, Cart cart) {  //선택한 상품 출력 메서드
        if (productNum == 0) {
            System.out.println("뒤로가기");
        } else if (productNum <= products.size()) {  //저장되어 있는 상품 범위 내
            System.out.println("선택한 상품: " + products.get(productNum-1) + " | 재고: " + products.get(productNum-1).getStock() + "개 \n");
            System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인       아무 숫자: 취소");
            int choice = sc.nextInt();
            try {
                if (choice == 1) {
                    System.out.print("수량 입력: ");
                    int quantity = sc.nextInt();
                    cart.addCartItem(products.get(productNum-1), quantity);
                } else {
                    System.out.println("장바구니 추가 취소 \n");
                }
            } catch (Exception e){
                System.out.println("올바른 숫자를 입력하세요.");
            }
        } else {
            System.out.println("입력 오류");
        }
    }

    public void addProduct() {
        products.add(new Product("Galaxy S33", "1,500,000", "최신 안드로이드 스마트폰", 44));
    }


}
