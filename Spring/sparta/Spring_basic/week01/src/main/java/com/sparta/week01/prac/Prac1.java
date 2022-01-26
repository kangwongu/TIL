package com.sparta.week01review.prac;


import java.util.ArrayList;
import java.util.List;

public class Prac1 {
    public static void main(String[] args) {
        // 출력
        System.out.println("안녕, 스파르타!");

        // 변수
        String myName = "";
        int num1 = 10;
        int num2 = 3;
        System.out.println(num1+num2);


        List<String> courseList = new ArrayList<>();
        String course1 = "웹개발 종합반";
        String course2 = "앱개발 종합반";

        courseList.add(course1);
        courseList.add(course2);

        System.out.println(courseList);
    }

}
