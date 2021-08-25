package com.test.day18;

// 抽象类不能创建对象，但是可以继承，可以重写父类的方法，抽象类里的方法可以是非抽象的方法
// 虽然自己不能创建对象，但是可以调用抽象类里的静态方法的方式来创建，也可以子类调用父类里的方法来创建，还可以子类重写父类的方法来创建
public abstract class AbstractClass {
    private String name;

    public AbstractClass() {
    }

    // 抽象类里可以拥有构造方法，只是不能自己来构造而已，需要等待别人来调用
    public AbstractClass(String name) {
        this.name = name;
    }
}
