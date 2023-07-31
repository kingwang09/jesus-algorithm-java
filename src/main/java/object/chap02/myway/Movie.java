package object.chap02.myway;

public class Movie {
    private String title;

    private long price;

    private int runningMinutes;

    private DiscountPolicy discountPolicy; //movie당 할인 정책은 0 or 1개를 갖는다.


    public long getPrice(){
        return this.price;
    }
}
