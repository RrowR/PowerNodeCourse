package com.test.day26;

import com.test.day26.exam.Answers;
import com.test.day26.exam.Item;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestExam {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("JavaSE/src/answer.dat"));
        Object o = ois.readObject();
        Answers answers = (Answers) o;
        char[] chars = answers.getChars();
        for (char c : chars) {
            System.out.println(c);
        }

    }
}
