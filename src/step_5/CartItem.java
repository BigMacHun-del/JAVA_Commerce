package step_5;

// 장바구니 항목 클래스
// 상품, 수량 정보 저장
public class CartItem {
    private String itemName;
    private int quantity;

    public CartItem(String itemName, int quantity) {  //생성자로 이름과 수량 전달 받기
        this.itemName = itemName;
        this.quantity = quantity;
    }
}
