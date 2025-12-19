package step_5;


import java.util.Scanner;

public class Customer {
    private String name;
    private String email;
    private CustomerRank rank;

    public Customer() {}

    public Customer(String name, String email, CustomerRank rank) {
        this.name = name;
        this.email = email;
        this.rank = rank;
    }


    public CustomerRank searchCustomerRank(){  //고객 등급을 정하고 해당 열거형 반환
        System.out.println("고객 등급을 입력해주세요");
        int index = 1;
        for (CustomerRank rank : CustomerRank.values()){  //열거형의 모든 값들을 반복
            System.out.println(index+ ". " + rank + " : " + rank.getDiscountRate() + "% 할인");
            index++;
        }
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        if(choice == 1){rank = CustomerRank.BRONZE;}
        else if(choice == 2){rank = CustomerRank.SILVER;}
        else if(choice == 3){rank = CustomerRank.GOLD;}
        else if(choice == 4){rank = CustomerRank.PLATINUM;}
        else {System.out.println("올바른 숫자를 입력해주세요"); }

        return rank;
    }

    //각 요소 게터 세터
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
//    public String getRank() {return rank;}
//    public void setRank(String rank) {this.rank = rank;}
}
