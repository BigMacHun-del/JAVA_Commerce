package step_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    Scanner sc = new Scanner(System.in);
    //Category category = new Category();  --> 매개변수로 이미 사용되고 있는 객체를 사용해야함

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
        System.out.println("어느 카테고리에 상품을 추가하시겠습니까?");
        for (int i = 0; i<3; i++){
            System.out.println(i+1 + ". " + category.getCategoryName().get(i));
        }
        int categoryNum = sc.nextInt();
        sc.nextLine();
        String selectcategoryName = category.getCategoryName().get(categoryNum - 1);

        System.out.println("[ " +  selectcategoryName + "카테고리에 상품 추가 ]");
        System.out.print("상품명을 입력해주세요: ");
        String productName = sc.nextLine();

        //중복 상품명 검증(같은 카테고리 내에서)
        for (Product product : category.getProducts()) { //상품 클래스를 반복하며 현재 객체의 카테고리를 찾고, 상품 명 비교
            if (productName.equals(selectcategoryName) &&  product.getProductName().equals(productName)) {
                System.out.println("이미 해당 카테고리에 동일한 이름의 상품이 있습니다");
                return;
            }
        }

        System.out.print("가격을 입력해주세요: ");
        String price = sc.nextLine();

        System.out.print("설명을 입력해주세요: ");
        String description = sc.nextLine();

        System.out.print("재고수량을 입력해주세요: ");
        int stock = sc.nextInt();
        sc.nextLine();

        Product newProduct = new Product(productName, price, description, stock);
        System.out.println(newProduct);
        System.out.println("위 정보로 상품을 추가하시겠습니까?");
        System.out.println("1. 확인     아무 키: 취소");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            category.getProducts().add(newProduct);  //추가 완료
            System.out.println("상품이 성공적으로 추가되었습니다!");
        } else{
            System.out.println("상품 추가가 취소 되었습니다.");
        }
    }

//    public ArrayList<T> addProductScan(){
//        ArrayList<T> scanList = new ArrayList<>();
//        System.out.print("상품명을 입력해주세요: ");
//        scanList.add();
//    }

    public void updateProduct(){

    }

    public void removeProduct(){

    }


}
