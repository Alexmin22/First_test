package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String st1 = "Hellllo world!";
        Pattern pat = Pattern.compile("(l){2,3}");
        Matcher matcher = pat.matcher(st1);
        while (matcher.find())
            System.out.println(matcher.start() + " "+matcher.group());
    }
}