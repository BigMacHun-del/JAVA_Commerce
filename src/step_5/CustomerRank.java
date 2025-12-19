package step_5;

public enum CustomerRank {
    BRONZE(0),
    SILVER(5),
    GOLD(10),
    PLATINUM(15);

    private int discountRate;

    CustomerRank(int discountRate) {this.discountRate = discountRate;}  //할인률 생성자
    public int getDiscountRate() {return this.discountRate;}   //할인률 게터

    public String discountPrice(String price) {  //할인되는 값 반환
        int priceInt = Integer.parseInt(price.replace(",", ""));  //문자열 -> 정수
        int disconutPrice = priceInt * (discountRate) / 100;

        String discountPriceStr = String.format("%,d", disconutPrice);  //정수 -> 문자열
        return discountPriceStr;
    }

}


