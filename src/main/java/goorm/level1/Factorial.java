package goorm.level1;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Factorial {

    public static void main(String[] args){
        List<Long> values = new LinkedList<>();
        int max = 100;
        for(long i = 1; i <= max; i++){
            values.add(i);
        }
        System.out.println(values);
        Optional<Long> sum = values.stream().reduce((total, n) -> {
            System.out.printf("total=%d, n=%d \n", total, n);
            return total * n;
        });
        System.out.println(sum.get());
    }

    //팩토리얼 -> 재귀써야할 것
}
