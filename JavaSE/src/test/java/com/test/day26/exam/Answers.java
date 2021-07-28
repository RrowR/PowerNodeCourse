package com.test.day26.exam;

import java.io.Serializable;

public class Answers implements Serializable {
    private char[] chars;

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    public Answers(char[] chars) {
        this.chars = chars;
    }
}
