package programmers.level0;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181916
 */
//함정
    //3개가 같고 1개가 다른 경우 & 2개씩 같은 경우
public class DiceGame {

    public static void main(String[] args){
        DiceGameSolution diceGameSolution = new DiceGameSolution();
        //int score = diceGameSolution.solution(2, 2, 2, 2);
        //int score = diceGameSolution.solution(4, 1, 4, 4);
        //int score = diceGameSolution.solution(6, 3, 3, 6);
        int score = diceGameSolution.solution(2, 5, 2, 6);
        System.out.println(
                score
        );
    }
}

class DiceGameSolution{
    Map<Integer, Integer> diceScoreMap = new HashMap<>();
    public int solution(int a, int b, int c, int d) {
        push(a);
        push(b);
        push(c);
        push(d);


        int answer = score();
        return answer;
    }

    private void push(int value){
        if(diceScoreMap.containsKey(value)){
            diceScoreMap.put(value, diceScoreMap.get(value) + 1);
        }else{
            diceScoreMap.put(value, 1);
        }
    }

    private int score(){
        int score = 0;
        System.out.println(diceScoreMap);
        Set<Integer> keys = diceScoreMap.keySet();
        Collection<Integer> counts = diceScoreMap.values();

        int maxCount = counts.stream().max(Comparator.comparing(Integer::intValue)).get();
        int minCount = counts.stream().min(Comparator.comparing(Integer::intValue)).get();
        if(maxCount == 1 && minCount == 1){//모두 맞은 경우
            int key = diceScoreMap.keySet().stream().findFirst().get();
            score = 1111 * key;
        }else if(maxCount == 3 && minCount == 1){//3개가 같고 1개가 다르다.
            int threeEqualsKey = 0;
            int oneEqualsKey = 0;
            for(Integer key: keys){
                Integer count = diceScoreMap.get(key);
                if(count == 1){//1개 다른거
                    oneEqualsKey = key;
                }else{//3개 같은거
                    threeEqualsKey = key;
                }
            }
            score = (int) Math.pow(10 * threeEqualsKey + oneEqualsKey, 2);
        }else if(maxCount == 2 && minCount == 2){//2씩 같은 값.
            int[] twoEqualsValue = new int[2];
            int index = 0;
            for(Integer key: keys){
                twoEqualsValue[index++] = key;
            }
            //(p + q) × |p - q
            score = (twoEqualsValue[0] + twoEqualsValue[1]) * (twoEqualsValue[0] - twoEqualsValue[1]);
            score = score < 0 ? score * -1 : score;//보정처리
        }else if(maxCount == 2 && minCount == 1){//2개 같고, 1개씩 다른 경우
            int[] oneEqualsValue = new int[2];
            int index = 0;
            for(Integer key: keys){
                Integer count = diceScoreMap.get(key);
                if(count == 1) {
                    oneEqualsValue[index++] = key;
                }
            }
            score = oneEqualsValue[0] * oneEqualsValue[1];
        }else{
            score = keys.stream().min(Comparator.comparing(Integer::intValue)).get();
        }
        return score;
    }
}