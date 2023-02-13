package dao;

import java.util.List;

public interface Dao {
    public void say();
    public int sum(int a, int b);
    public List<String> list(String st);
    public static void hello(String name) {
        System.out.println("Hello "+name);
    }
}
