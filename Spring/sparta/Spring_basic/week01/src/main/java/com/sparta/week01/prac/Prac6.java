package com.sparta.week01.prac;

import java.util.ArrayList;
import java.util.List;

public class Prac6 {
    public static int countFruit(String fruit) {
        List<String> fruits = new ArrayList<>();
        fruits.add("감");
        fruits.add("배");
        fruits.add("감");
        fruits.add("딸기");
        fruits.add("수박");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("딸기");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("감");

        int count = 0;  // 과일의 수를 담을 변수
        // 리스트를 순회
        for(int i=0; i<fruits.size(); i++) {
           // 과일을 하나씩 꺼내서
            String f = fruits.get(i);
            // 세고자 하는 과일과 일치하면
           if(f.equals(fruit))
               count++;

        }
        return count;
    }

    public static void main(String[] args) {
        int age = 20;
        if(age>19) {
            System.out.println("성인입니다.");
        } else {
            System.out.println("미성년자입니다.");
        }

        int gam = countFruit("감");
        System.out.println(gam);
    }
}
