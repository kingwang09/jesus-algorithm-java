package programmers.level0;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 힌트,
 * - for문을 지속해갈 수록 초기에 지정했던 원소의 위치가 달라지게 되면서 생기는 문제
 * - 문제가 인덱가 홀수/짝수 일때를 의미한듯.
 *  - 쿼리 값이 홀수/짝수라 생각함.
 */
public class ArraySubList {

    public static void main(String[] args){
        //System.out.println(0%2 == 0);

        List<Integer> values = Arrays.asList(1, 2, 3, 4 ,5);
        System.out.println(values.subList(3, values.size()));
        //Solution solution = new Solution();
        //System.out.println(Arrays.toString(solution.solution(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, new int[]{4, 1, 2})));
    }
}

class Solution {
    public int[] solution(int[] arr, int[] query) {
        List<Integer> values = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for(int i=0; i<query.length; i++){
            int queryValue = query[i];
            if(values.size() == 0){
                break;
            }
            if(values.size() < queryValue){
                continue;
            }
            System.out.println("[before] query:"+queryValue + ", values: "+values);
            if(isEven(i)){
                values = values.subList(0, queryValue + 1);//짝수면, 뒷부분을 잘라서 버림
            }else{
                values = values.subList(queryValue, values.size());//홀수면, 앞부분을 잘라서 버림
            }
            System.out.println("[after] query:"+queryValue + ", values: "+values);
        }
        System.out.println("result: " + values);

        return values.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean isEven(int value){
        return (value % 2) == 0 ? true : false;
    }
}