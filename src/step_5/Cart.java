package step_5;

import java.util.ArrayList;

// 장바구니 관리 클래스
//  - addCartItem(): 상품 추가 시 재고 확인 및 중복 상품 수량 업데이트
//  - cartIsEmpty(): 장바구니가 비어있는지 확인
//  - showCart(): 장바구니 목록 및 총 금액 출력
//  - getTotalAmount(): 총 금액 계산
//  - completeOrder(): 주문 완료 시 재고 차감 및 장바구니 초기화
//  - cancelOrder(): 주문 취소 시 주문 했던 상품 재고량 복구
//  - deleteCartItem(): 장바구니에 들어있는 상품 삭제

public class Cart {
    ArrayList<CartItem> items = new ArrayList<>();  //리스트 객체 생성
    ArrayList<CartItem> orderItems = new ArrayList<>();  //item.claer 연산으로 주문내역이 사라지므로 주문 내역을 저장하기 위한 리스트

    public void deleteCartItem(String productName) {
//        for (CartItem item : items) {
//            if (item.getProduct().getProductName().equals(productName)) {
//                System.out.println(item.getProduct().getProductName() + "을 장바구니에서 삭제합니다.");
//                items.remove(item);
//            }else {
//                System.out.println("해당 상품은 장바구니에 없는 상품입니다.");
//            }
//        }  스트림을 쓰지 않은 경우
        CartItem deleteItem = items.stream()
                .filter(item -> item.getProduct().getProductName().equals(productName))
                .findFirst() //필터링 된 결과중 첫 번째 요소를 저장
                .orElse(null); //그렇지 않으면 null 저장
        if(deleteItem == null){
            System.out.println("해당 상품은 장바구니에 없는 상품입니다.");
        }
        System.out.println(deleteItem.getProduct().getProductName() + "을(를) 장바구니에서 삭제합니다.");
        items.remove(deleteItem);
    }

    public void addCartItem(Product product, int quantity) {  //상품 정보들과 수량을 매개변수로 장바구니 추가
        //남은 재고가 없는 경우
        if(product.getStock() < quantity) {
            System.out.println("상품 재고가 없습니다.");
            items.remove(product);
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
        System.out.println("현 재고" + product.getStock());
        System.out.println(product.getProductName() + "이(가) 장바구니에 추가되었습니다.");
    }

    public boolean cartIsEmpty() {  //장바구니가 비어있는지 확인
        return items.isEmpty();
    }

    public void showCart() {
        System.out.println("아래와 같이 주문 하시겠습니까? \n");
        System.out.println("[ 장바구니 내역 ]");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
    }

    public String getTotalAmount(){
        int total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        String totalStr = String.format("%,d", total);  //3자리마다 , 붙이기
        return totalStr;
    }

    public void completeOrder(CustomerRank rank) {
        orderItems.clear();
        for (CartItem item : items) {
            orderItems.add(new CartItem(item.getProduct(), item.getQuantity()));
        }

        System.out.println("주문이 완료되었습니다!");
        String total = getTotalAmount();
        String discountPrice = rank.discountPrice(total);  //할인 된 가격 반환


        System.out.println("할인 전 금액: " + total + "원");
        System.out.println(rank + " 등급 할인(" + rank.getDiscountRate() +"%): -" + discountPrice + "원");
        System.out.println("최종 결제 금액: " + strCalculate(total, discountPrice, 2) + "원");

        for (CartItem item : items) {
            System.out.println(item.getProduct().getProductName() + " 재고가 " + item.getStockBeforeOrder() + "개 -> " + item.getProduct().getStock() + "개로 업데이트 되었습니다.");
        }

        items.clear();  //장바구니 초기화
    }

    public String strCalculate(String a, String b, int c) {  //문자열 사칙연산 함수
        int a1 = Integer.parseInt(a.replace(",", ""));
        int b1 = Integer.parseInt(b.replace(",", ""));
        int result = 0;
        if (c == 1){result = a1 + b1;}
        else if (c == 2){result = a1 - b1;}
        else if (c == 3){result = a1 * b1;}
        else if (c == 4){result = a1 / b1;}

        String resultStr = String.format("%,d", result);
        return resultStr;
    }

    public void cancelOrder(){
        if (orderItems.isEmpty()) {
            System.out.println("주문내역이 없습니다");
            return;
        }
        System.out.println("[ 주문 내역 ]");
        for (int i = 0; i < orderItems.size(); i++) {
            System.out.println(orderItems.get(i));
        }

        System.out.println("주문을 취소합니다.");
        for (CartItem item : orderItems) {
            Product product = item.getProduct();
            int afterOrderStock = product.getStock();
            product.setStock(afterOrderStock + item.getQuantity());   //주문으로 차감된 재고량의 주문 수량 더하기
            System.out.println(product.getProductName() +" 재고가 " + afterOrderStock + "개 -> " +  product.getStock() + "개로 업데이트 되었습니다.");
        }
    }
}
