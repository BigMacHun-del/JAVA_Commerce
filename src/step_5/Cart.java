package step_5;

// 장바구니 관리 클래스
//  - addCartItem(): 상품 추가 시 재고 확인 및 중복 상품 수량 업데이트
//  - cartIsEmpty(): 장바구니가 비어있는지 확인

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    ArrayList<CartItem> items = new ArrayList<>();  //리스트 객체 생성

    public void addCartItem(Product product, int quantity) {  //상품 정보들과 수량을 매개변수로 장바구니 추가
        //남은 재고가 없는 경우
        if(product.getStock() < quantity) {
            System.out.println("상품 재고가 없습니다.");
            return;
        }

        //상품이 이미 있는 경우
        for (CartItem item : items) { //items의 상품을 반복하며 선택한 상품과 동일한지 확인
            if (item.getProduct().getProductName().equals(product.getProductName())) {
                System.out.println(product.getProductName() + "은(는) 이미 장바구니에 있는 상품입니다.");
                //같은 상품이 있을 경우 새 상품 추가가 아닌, 해당 상품에 수량만 더해주면 됨
                item.setQuantity(item.getQuantity() + quantity);
                product.setStock(product.getStock() - quantity); //주문한 수량만큼 재고 감소
                System.out.println(product.getProductName() + "이(가) 장바구니에 더 추가되었습니다.");
                return;
            }
        }

        //새 상품 추가
        items.add(new CartItem(product, quantity));
        product.setStock(product.getStock() - quantity); //주문한 수량만큼 재고 감소
        System.out.println(product.getProductName() + "이(가) 장바구니에 추가되었습니다.");
    }

    public boolean cartIsEmpty() {  //장바구니가 비어있는지 확인
        return items.isEmpty();
    }
}
