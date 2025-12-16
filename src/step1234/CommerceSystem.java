package step1234;

import java.util.ArrayList;
import java.util.Scanner;

public class CommerceSystem {
    ArrayList<Product> basicProduct = new ArrayList<>();

    public CommerceSystem() {  //기본 생성자로 상품 리스트 추가
        basicProduct.add(new Product("Galaxy S25", "1,200,000", "최신 안드로이드 스마트폰", 20));
        basicProduct.add(new Product("iPhone 16", "1,350,000", "Apple의 최신 스마트폰", 20));
        basicProduct.add(new Product("MacBook Pro", "2,400,000", "M3 칩셋이 탑재된 노트북", 20));
        basicProduct.add(new Product("AirPods Pro", "350,000", "노이즈 캔슬링 무선 이어폰", 20));
    }

    public void start(){  //기본 메뉴 출력
        for (int i = 0; i < basicProduct.size(); i++) {
            System.out.println((i+1) + ". " +   basicProduct.get(i));
        }
        System.out.println("0. 종료      | 프로그램 종료");

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if (input == 0) {
            System.out.println("커머스 플랫폼을 종료합니다.");
            System.exit(0);
        }
    }

}
