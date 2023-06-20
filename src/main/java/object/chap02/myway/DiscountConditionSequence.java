package object.chap02.myway;

public class DiscountConditionSequence implements DiscountCondition{
    private int discountSequence;

    public DiscountConditionSequence(int discountSequence) {
        this.discountSequence = discountSequence;
    }

    @Override
    public boolean isAvailable(Schedule schedule) {
        if(schedule.getIndex() == discountSequence){
            return true;
        }
        return false;
    }
}
