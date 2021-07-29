package com.test.day26.exam;

public class ExamView {
    public Character getUserAction(String input){
        char[] chars = {'a','b','c','d','n','p'};
        for (char c : chars) {
            if (input.charAt(0) == c){
                return c;
            }
        }
        return null;
    }
}
