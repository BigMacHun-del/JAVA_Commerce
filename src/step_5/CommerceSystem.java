package step_5;

import java.util.Scanner;

public class CommerceSystem {
    Category category =  new Category();
    Cart cart = new Cart();

    public void start(){  //기본 상품 출력
        int menuNumber, productNum; // 메뉴 번호, 상품 번호 변수
        Scanner sc = new Scanner(System.in);
        try {
            while(true) {
                System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
                for(int i = 0; i < category.getCategoryName().size(); i++){
                    System.out.println(i+1 + ". " + category.getCategoryName().get(i));
                }
                //장바구니 목록이 있다면, 주문관리 메뉴 추가
                if(!cart.cartIsEmpty()){
                    System.out.println("\n [ 주문 관리 ]");
                    System.out.println("4. 장바구니 확인");
                    System.out.println("5. 주문 취소");
                }

                System.out.println("0. 종료       | 프로그램 종료");
                menuNumber = sc.nextInt();

                switch(menuNumber){
                    case 0:
                        System.out.println("커머스 플랫폼을 종료합니다.");
                        System.exit(0);
                    case 1:
                        category.categoryProducts(menuNumber);   //메뉴에 맞는 상품 출력
                        productNum = sc.nextInt();
                        category.choseProduct(productNum, cart);  //상품 선택 메서드
                        break;
                    case 2:
                        category.categoryProducts(menuNumber);
                        productNum = sc.nextInt();
                        category.choseProduct(productNum, cart);
                        break;
                    case 3:
                        category.categoryProducts(menuNumber);
                        productNum = sc.nextInt();
                        category.choseProduct(productNum, cart);
                        break;
                    case 4:
                        cart.showCart();
                        System.out.println("\n[ 총 주문 금액 ]");
                        System.out.println(cart.getTotalAmount() + "원 \n");

                        System.out.println("1. 주문 확정     2. 메인으로 돌아가기");
                        int input = sc.nextInt();
                        if(input == 1){
                            cart.completeOrder();
                        } else if (input == 2) {
                            System.out.println("메인화면으로 돌아갑니다.");
                            break;
                        }

//                case 5:
//                    //장바구니 상품 들어있으면 주문 취소 기능
                }
            }
        }catch (Exception e){
            System.out.println("올바른 숫자를 입력하세요." + e.getMessage());
        }
    }

}
