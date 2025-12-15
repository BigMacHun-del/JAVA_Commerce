package step1234;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        product.setProductMembers("Galaxy S25", "1,200,000", "최신 안드로이드 스마트폰", 20);
        product.setProductMembers("iPhone 16", "1,350,000", "Apple의 최신 스마트폰", 20);
        product.setProductMembers("MacBook Pro", "2,400,000", "M3 칩셋이 탑재된 노트북", 20);
        product.setProductMembers("AirPods Pro", "350,000", "노이즈 캔슬링 무선 이어폰", 20);

        for (int i = 0; i < product.getProductMembers().size(); i++) {
            System.out.println((i+1) + ". " +   product.getProductMembers().get(i));
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
