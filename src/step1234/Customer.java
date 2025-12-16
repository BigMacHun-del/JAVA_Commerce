package step1234;

public class Customer {
    private String name;
    private String email;
    private String rank = "초기 등급";

    public Customer(String name, String email, String rank) {
        this.name = name;
        this.email = email;
    }

    //각 요소 게터 세터
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getRank() {return rank;}
    public void setRank(String rank) {this.rank = rank;}
}
