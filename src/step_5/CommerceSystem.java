package step_5;

import java.util.Scanner;

public class CommerceSystem {
    Category category =  new Category();
    Cart cart = new Cart();
    Manager manager = new Manager();

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
                System.out.println("\n [ 주문 관리 ]");
                if(!cart.cartIsEmpty()){
                    System.out.println("4. 장바구니 확인");
                }
                System.out.println("5. 주문 취소");  //주문 취소 기능을 사용하기 위해 장바구니 목록이 없더라도 출력으로 변경
                System.out.println("6. 관리자 모드");
                System.out.println("0. 종료       | 프로그램 종료");
                menuNumber = sc.nextInt();

                switch(menuNumber){
                    case 0:
                        System.out.println("커머스 플랫폼을 종료합니다.");
                        System.exit(0);
                    case 1:  //전자제품
                        category.categoryProducts(menuNumber);   //메뉴에 맞는 상품 출력
                        printBack();
                        productNum = sc.nextInt();
                        category.choseProduct(productNum, cart);  //상품 선택 메서드
                        break;
                    case 2:  //의류
                        category.categoryProducts(menuNumber);
                        printBack();
                        productNum = sc.nextInt();
                        category.choseProduct(productNum, cart);
                        break;
                    case 3:  //식품
                        category.categoryProducts(menuNumber);
                        printBack();
                        productNum = sc.nextInt();
                        category.choseProduct(productNum, cart);
                        break;
                    case 4:  //장바구니 확인
                        if(!cart.cartIsEmpty()){   //장바구니 내역이 없을 경우 오류 메시지 출력
                            cart.showCart();
                            System.out.println("\n[ 총 주문 금액 ]");
                            System.out.println(cart.getTotalAmount() + "원 \n");

                            System.out.println("1. 주문 확정     2. 메인으로 돌아가기");
                            int input = sc.nextInt();
                            if(input == 1){
                                cart.completeOrder();
                                break;
                            } else if (input == 2) {
                                System.out.println("메인화면으로 돌아갑니다.");
                                break;
                            }
                        } else {
                            System.out.println("해당 메뉴에 보이는 번호를 입력해주세요.");
                        }
                    case 5:  //주문 취소
                        System.out.println("주문을 취소하시겠습니까?   1. 주문 취소     2. 메인으로 돌아가기");
                        int cancelNum = sc.nextInt();
                        if(cancelNum == 1){
                            cart.cancelOrder();
                            break;
                        }
                        else if(cancelNum == 2){
                            System.out.println("메인 화면으로");
                            break;
                        }
                    case 6:  //관리자 모드
                        manager.managerMenu(category);
                        break;
                    default:
                        System.out.println("해당 메뉴에 보이는 번호를 입력해주세요.");
                }
            }
        }catch (Exception e){
            System.out.println("올바른 숫자를 입력하세요." + e.getMessage());
        }
    }

    public void printBack(){  //코드 재사용성을 위해 출력문 따로 빼기
        System.out.println("0. 뒤로가기");
    }

}
