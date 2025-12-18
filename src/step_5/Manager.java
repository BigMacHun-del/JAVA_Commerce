package step_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    Scanner sc = new Scanner(System.in);
    //Category category = new Category();

    public void managerMenu(Category category) {
        int missCount = 0;
        do {
            System.out.print("관리자 비밀번호를 입력해주세요: ");
            String password = sc.next();
            sc.nextLine();
            if (password.equals("1234")){
                System.out.println("[ 관리자 모드 ]");
                System.out.println("1. 상품 추가");
                System.out.println("2. 상품 수정");
                System.out.println("3. 상품 삭제");
                System.out.println("4. 전체 상품 현황");
                System.out.println("0. 메인으로 돌아가기");

                int meunNum = sc.nextInt();
                switch(meunNum){
                    case 0:
                        break;
                    case 1:
                        addProduct(category);
                        break;
                    case 2:
                        //상품 수정
                        break;
                    case 3:
                        //상품 삭제
                        break;
                    case 4:
                        //전체 상품 현황
                        System.out.println("[ 전체 상품 현황 ]");
//                for (int i = 0; i < category.getProducts().size(); i++) {
//                    System.out.println(i+1 + ". " + category.getProducts().get(i));
//                }
                        /*TODO: Category 클래스에서는 되는데 같은 함수인데도 재고량 갱신이 안됨
                        아마도 Category 클래스에서는 ArrayList로 받고 이 클래슨느 Category 그자체 객체에 담으니까 다른 객체로 인식하는 듯
                        --> 위 의심이 맞았고, 매개변수로 Category 객체를 받아 값을 전달해주었음.
                         */
                        category.categoryProducts(1);
                        System.out.println();
                        break;
                    default:
                        System.out.println("올바른 숫자를 입력하세요");
                        break;
                } break;
            }else {
                System.out.println("비밀번호가 틀렸습니다.");
                System.out.println("남은 입력 횟수: " + (3 - ++missCount));  //3에서 -1 -2 -3 끝
            }
        } while (missCount < 3);

    }

    public void addProduct(Category category) {
        category.addProduct();
    }

    public void updateProduct(){

    }

    public void removeProduct(){

    }


}
