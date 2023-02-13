package dao;

import java.util.ArrayList;
import java.util.List;

public class SomeClass implements Dao{
    @Override
    public void say() {
        System.out.println("blah-blah");
    }

    @Override
    public int sum(int a, int b) {
        return a+b;
    }

    @Override
    public List<String> list(String st) {
        List<String> list = new ArrayList<>();
        list.add(st);
        return list;
    }
}
