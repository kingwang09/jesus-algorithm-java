package goorm.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NumberBaseBallGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Judge judge = new Judge();
        for(int i=0; i < 5; i++){
            String input = br.readLine();
            List<Integer> values = judge.convert(input);
            List<String> answerList = judge.answer(values);
            System.out.println(answerList);//4개단위로 실행이 되는 듯.
        }
    }
}

class Judge{
    private List<Integer> answerList = Arrays.asList(3, 2, 8, 1);

    public List<Integer> convert(String input){
        List<Integer> values = new LinkedList();
        String[] inputValues = input.split(" ");
        for(int i = 0; i < inputValues.length; i++){
            values.add(Integer.valueOf(inputValues[i]));
        }
        return values;
    }

    public List<String> answer(List<Integer> values){
        List<String> results = new LinkedList();
        for(int i = 0; i < values.size(); i++){
            results.add(judgement(i, values.get(i)));
        }
        return results;
    }

    private String judgement(int index, Integer value){
        if(this.answerList.contains(value)){

            if(this.answerList.get(index) == value){
                return "\'Strike\'";
            }else{
                return "\'Ball\'";
            }
        }
        return "\'Fail\'";
    }
}