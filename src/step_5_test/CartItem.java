package step_5;

// 장바구니 항목 클래스
// 상품, 수량 정보 저장
//  - getTotalPrice(): 각각의 상품 가격을 int로 바꾸고, 수량을 곱해 해당 상품의 총가격 반환
public class CartItem {
    private Product product;
    private int quantity;
    private int stockBeforeOrder;  //주문하기 전 상품 재고량 저장

    public CartItem(Product product, int quantity) {  //생성자로 이름과 수량 전달 받기
        this.product = product;
        this.quantity = quantity;
        this.stockBeforeOrder = product.getStock();   //주문 하기 전 재고량 저장
    }

    //게터 세터
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice(){
        String priceStr = product.getPrice().replace(",", "");  // 콤마 삭제시켜서 문자열로 저장
        return Integer.parseInt(priceStr) * quantity;  //해당 문자열을 int로 변환하고, 수량을 곱해서 총 가격 결정
    }

    public int getStockBeforeOrder() {
        return this.stockBeforeOrder;
    }


    @Override
    public String toString() {
        return product.getProductName() + " | " + product.getPrice() + " | " + product.getProductName() + " | " + quantity +'개';
    }
}
