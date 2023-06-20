package object.chap02.myway;

import java.util.List;

public class DiscountPolicyAmount implements DiscountPolicy{

    private long discountAmount;

    private List<DiscountPolicy> conditions;

    DiscountPolicyAmount(long discountAmount){
        this.discountAmount = discountAmount;
    }
    @Override
    public long discountPrice(Movie movie) {
        return movie.getPrice() - this.discountAmount;
    }
}
