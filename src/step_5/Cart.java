package step_5;

// 장바구니 관리 클래스

import java.util.ArrayList;

public class Cart {
    ArrayList<CartItem> items = new ArrayList<>();

    public void addCartItem(Product product, int quantity) {
        if(product.getStock() < quantity) {
            System.out.println("상품 재고가 없습니다.");
        }
    }

    public boolean cartIsEmpty() {  //장바구니가 비어있는지 확인
        return items.isEmpty();
    }
}
