package programmers.level0;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Babbling {
    static final List<String> availableWords = Arrays.asList("aya", "ye", "woo", "ma");
    public static void main(String[] args){

    }

    public static int solution(String[] babbling) {
        int answer = 0;
        for(int i=0; i < babbling.length; i++){
            if(isCheck(babbling[i])){
                answer++;
            }
        }
        return answer;
    }

    public static boolean isCheck(String babbling){
        for(String availableWord : availableWords){
            babbling = babbling.replace(availableWord, "-");
        }
        List<String> results = Arrays.stream(babbling.split("")).filter(v -> !v.equals("-")).collect(Collectors.toList());
        return results.size() == 0;
    }


}
