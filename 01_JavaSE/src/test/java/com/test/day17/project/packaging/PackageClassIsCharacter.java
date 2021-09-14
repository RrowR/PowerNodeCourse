package com.test.day17.project.packaging;

public class PackageClassIsCharacter {
    public static void main(String[] args) {
        // Character包装类的有参构造
        Character character = new Character('s');
        System.out.println(character);
        // 是否是字母
        System.out.println(Character.isLetter('A'));
        // 是否是数字
        System.out.println(Character.isDigit('2'));
        // 是否是大写字母
        System.out.println(Character.isUpperCase('A'));
        // 是否是小写字母
        System.out.println(Character.isLowerCase('a'));
        // 是否是数字或者字母
        System.out.println(Character.isLetterOrDigit('2'));
        System.out.println(Character.isLetterOrDigit('a'));
    }
}
