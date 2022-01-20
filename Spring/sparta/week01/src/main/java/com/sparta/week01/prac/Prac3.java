package com.sparta.week01review.prac;

import java.util.ArrayList;
import java.util.List;

public class Prac3 {
    public static void main(String[] args) {
//        List<String> fruits = new ArrayList<>();
//        fruits.add("감");
//        fruits.add("배");
//        fruits.add("감");
//        fruits.add("딸기");
//        fruits.add("수박");
//        fruits.add("메론");
//        fruits.add("수박");
//        fruits.add("딸기");
//        fruits.add("메론");
//        fruits.add("수박");
//        fruits.add("메론");
//        fruits.add("수박");
//        fruits.add("감");
//        System.out.println(fruits);
//
//        for(int i=0; i<fruits.size(); i++) {
//            System.out.println(fruits.get(i));
//        }

        List<String> celebs = new ArrayList<>();
        celebs.add("아이유");
        celebs.add("린다G");
        celebs.add("은비");
        celebs.add("금비");
        celebs.add("비");
        celebs.add("차은우");
        celebs.add("남주혁");
        celebs.add("수지");
        celebs.add("정우성");
        celebs.add("제니");
        celebs.add("정국");

        // celebs에 저장되어 있는 데이터들을 하나씩 꺼내서 출력하기
        for(int i=0; i<celebs.size(); i++) {
            System.out.println(celebs.get(i));
        }
    }
}
