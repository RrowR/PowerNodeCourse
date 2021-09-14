package com.test.day18;

public class TestEqulas {
    public static void main(String[] args) {
        StringBuffer sbf = new StringBuffer("java");
        StringBuffer sbf1 = sbf.append(",C#");
        String sbf2 = sbf + ",C#";
        System.out.print(sbf.equals(sbf1));
        System.out.println();
        System.out.println(sbf2.equals(sbf));
    }

}
