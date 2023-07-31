package object.chap02.myway;

public interface DiscountPolicy {
    //abstract클래스로 할것인지 인테페이스로 할 것인지 선택.
    //하위 클래스에 공통 코드가 필요한가 안한가

    long discountPrice(Movie movie);
}
