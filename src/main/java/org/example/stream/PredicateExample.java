package org.example.stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

    public static void main(String[] args) {
        List<PredicateModel> list = Arrays.asList(
                    new PredicateModel("1", 14),
                    new PredicateModel("2", 24),
                    new PredicateModel("3", 36),
                    new PredicateModel("4", 40),
                    new PredicateModel("5", 55),
                    new PredicateModel("6", 65),
                    new PredicateModel("7", 70),
                    new PredicateModel("8", 88)
                );

        //stream filter가 predicate를 사용한 함수
        List<PredicateModel> age70OverList = list.stream().filter((v) -> v.getAge() >= 70).collect(Collectors.toList());
        System.out.println("70>=: " + age70OverList);

        //익명함수로 정의
        List<PredicateModel> age70OverListByCustomList = filter(list, (v) -> v.getAge() >= 70);
        System.out.println("70>=(사용자정의):" + age70OverListByCustomList);
    }

    //filter함수 직접 구현해보면 아래와 같다.
    public static List<PredicateModel> filter(List<PredicateModel> allList, Predicate<PredicateModel> predicate){
        List<PredicateModel> filteringList = new LinkedList<>();
        allList.forEach((v)->{
            if(predicate.test(v)){
                filteringList.add(v);
            }
        });
        return filteringList;
    }
}

class PredicateModel{
    public PredicateModel(String id, int age) {
        this.id = id;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String id;

    private int age;

    @Override
    public String toString() {
        return "PredicateModel{" +
                "id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}
