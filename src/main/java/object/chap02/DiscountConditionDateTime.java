package object.chap02;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DiscountConditionDateTime implements DiscountCondition{
    private DayOfWeek discountDayOfWeek;
    private int discountStartHour;
    private int discountEndHour;

    public DiscountConditionDateTime(DayOfWeek discountDayOfWeek, int discountStartHour, int discountEndHour) {
        this.discountDayOfWeek = discountDayOfWeek;
        this.discountStartHour = discountStartHour;
        this.discountEndHour = discountEndHour;
    }


    @Override
    public boolean isAvailable(Schedule schedule) {
        LocalDateTime movieStartTime = schedule.getStartTime();
        if(discountDayOfWeek != null && discountDayOfWeek != movieStartTime.getDayOfWeek()){
            return false;
        }

        if(movieStartTime.getHour() >= discountStartHour && movieStartTime.getHour() <= discountEndHour){
            return true;
        }
        return false;
    }
}
