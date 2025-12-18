package step_5;

import java.util.Scanner;

public class Manager {
    Scanner sc = new Scanner(System.in);
    Category category = new Category();

    public void managerMenu(){
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
                //상품 추가
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
                category.categoryProducts(1);  ///재고량 갱신이 안됨
                System.out.println();
                break;
            default:
                System.out.println("올바른 숫자를 입력하세요");


        }
    }
}
