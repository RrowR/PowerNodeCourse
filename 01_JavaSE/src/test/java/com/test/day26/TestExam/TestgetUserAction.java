package com.test.day26.TestExam;

import com.test.day26.exam.ExamView;

import java.util.Scanner;

public class TestgetUserAction {
    public static void main(String[] args) {
        ExamView ev = new ExamView();
        Scanner input = new Scanner(System.in);

        while (true){
            String next = input.next();

            System.out.println(ev.getUserAction(next));
        }
    }
}
