package org.example.stream;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmptyListTest {

    public static void main(String[] args){
        List<DummyModel> list = Collections.emptyList();
        Map<Integer, DummyModel> map = list.stream().collect(Collectors.toMap(DummyModel::getId, Function.identity()));
        System.out.println(map);
    }
}


class DummyModel{
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String title;
    private int id;

}