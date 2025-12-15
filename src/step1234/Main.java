package step1234;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product product = new Product("Galaxy S25", "1,200,000", "최신 안드로이드 스마트폰", 20);
        product.setProductMembers("iPhone 16", "1,350,000", "Apple의 최신 스마트폰", 20);
        product.setProductMembers("MacBook Pro", "2,400,000", "M3 칩셋이 탑재된 노트북", 20);
        product.setProductMembers("AirPods Pro", "350,000", "노이즈 캔슬링 무선 이어폰", 20);

        System.out.println(product.getProductMembers().get(2));
        for (int i = 0; i < product.getProductMembers().size(); i++) {
            System.out.println((i+1) + ". " +   product.getProductMembers().get(i));
        }
    }
}
