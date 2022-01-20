package com.sparta.week01review.prac;

import java.util.ArrayList;
import java.util.List;

public class Prac4 {
    // 매개변수로 들어온 과일을 리스트에서 세고, 그 개수를 반환
    public static int countFruit(String fruit) {
        // 1. 리스트 생성, 매개변수로 들어온 과일의 수를 담을 변수 생성
        int count = 0;
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
        // 2. 리스트를 하나씩 순회하면서 매개변수로 들어온 과일과 일치하는지 확인
        for(int i=0; i<fruits.size(); i++) {
            // 2-1. 일치하면 count++
            if(fruit.equals(fruits.get(i))) {
                count++;
            }
        }
        // 3. count 반환
        return count;
    }

    public static void main(String[] args) {
        int count = countFruit("딸기");
        System.out.println(count);

//        int age = 20;
//        if (age > 19) {
//            System.out.println("성인입니다.");
//        } else {
//            System.out.println("미성년자입니다.");
//        }
    }

}
