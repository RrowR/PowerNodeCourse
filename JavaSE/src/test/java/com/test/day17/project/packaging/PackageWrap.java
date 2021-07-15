package com.test.day17.project.packaging;

import org.junit.Test;

/**
 * 自动装箱和自动拆箱的本质
 */
public class PackageWrap {
    @Test
    public void packaging(){
        int a = new Integer(123);   // 自动拆箱
        System.out.println(a);
        Integer b = 123;
        System.out.println(b);          // 自动装箱
    }

    /*
        拆箱和装箱的本质
     */
    @Test
    public void essence(){
        Integer a = new Integer(213);
//        a.valueof
    }


}
