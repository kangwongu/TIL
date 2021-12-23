package com.sparta.week01.prac;

import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

public class Prac2 {
    public static void main(String[] args) {

        int myAge = 20;
        boolean isAdult = myAge>20;
        boolean isKid = myAge <= 20;
        System.out.println(isAdult);
        System.out.println(isKid);
        System.out.println(myAge == 20);
        System.out.println(myAge != 20);
    }
}
