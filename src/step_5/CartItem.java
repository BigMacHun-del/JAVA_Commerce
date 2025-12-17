package step_5;

// 장바구니 항목 클래스
// 상품, 수량 정보 저장
public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {  //생성자로 이름과 수량 전달 받기
        this.product = product;
        this.quantity = quantity;
    }

    //게터 세터
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {}

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return product.getProductName() + " | " + product.getPrice() + " | " + product.getProductName() + " | " + quantity +'개';
    }
}
