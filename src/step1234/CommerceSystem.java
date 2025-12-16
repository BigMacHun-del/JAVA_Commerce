package step1234;

import java.util.ArrayList;
import java.util.Scanner;

public class CommerceSystem {
    Category category =  new Category();
    ArrayList<Product> basicProduct = new ArrayList<>();
    int menuNumber, productNum; // 메뉴 번호, 상품 번호 변수

    public CommerceSystem() {  //기본 생성자로 상품 리스트 추가
    }

    public void start(){  //기본 상품 출력
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for(int i = 0; i < category.categoryName.size(); i++){
                System.out.println(i+1 + ". " + category.categoryName.get(i));
            }
            System.out.println("0. 종료       | 프로그램 종료");
            menuNumber = sc.nextInt();

            switch(menuNumber){
                case 0:
                    System.out.println("커머스 플랫폼을 종료합니다.");
                    break;
                case 1:
                    category.categoryProducts(menuNumber);   //메뉴에 맞는 상품 출력
                    productNum = sc.nextInt();
                    category.choseProduct(productNum);  //상품 선택 메서드
                case 2:
                    category.categoryProducts(menuNumber);
                    productNum = sc.nextInt();
                    category.choseProduct(productNum);
                case 3:
                    category.categoryProducts(menuNumber);
                    productNum = sc.nextInt();
                    category.choseProduct(productNum);
                default:

            }



        }while(menuNumber==0);


    }

}
