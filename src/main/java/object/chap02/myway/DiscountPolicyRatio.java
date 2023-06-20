package object.chap02.myway;

import java.util.List;

public class DiscountPolicyRatio implements DiscountPolicy{

    private double discountRatio;

    private List<DiscountPolicy> conditions;

    DiscountPolicyRatio(double discountRatio){
        this.discountRatio = discountRatio;
    }

    @Override
    public long discountPrice(Movie movie) {
        return (long) (movie.getPrice() - (movie.getPrice() * discountRatio));
    }
}
