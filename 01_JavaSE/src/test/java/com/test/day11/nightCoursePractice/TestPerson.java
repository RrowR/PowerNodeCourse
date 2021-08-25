package com.test.day11.nightCoursePractice;
/**
 * 3.	开发一个人类（Person），具有成员变量身高和体重，有如下成员方法：
 * a)	在构造方法中：随机产生身高（140-200cm）和体重(40-300kg)
 * b)	获得身高
 * c)	获得体重
 * d)	获得体型(正常、偏瘦、偏胖)，判断逻辑为：体重与（身高-105）的值进行比较，如果偏差正负10属正常，如果偏少10以上属偏瘦，如果偏多10以上属偏胖。
 * 然后，开发一个测试类，对上述人类进行测试
 */
public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
        int gap = person.weight - (person.high - 105);
        if (gap > 10){
            System.out.println("您的体重偏胖");
        }else if (gap < -10){
            System.out.println("您的体重偏瘦");
        }else {
            System.out.println("您的体重正常");
        }
    }
}
