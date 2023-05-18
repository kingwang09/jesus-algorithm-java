package goorm.level1;


public class Factorial {

    public static void main(String[] args){
        Answer answer = new Answer();
        System.out.println(answer.calc(100));
    }

    //팩토리얼 -> 재귀써야할 것
}

class Answer{
    private long v1 = 0;
    private long v2 = 0;
    private long sum = 0;

    public long calc(int value){
        long index = 2;
        long sum = 1;
        while(index <= value){
            System.out.printf("sum=%d, index=%d\n", sum, index);
            sum = sum * index;
            index++;
        }
        return sum;
    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
}
