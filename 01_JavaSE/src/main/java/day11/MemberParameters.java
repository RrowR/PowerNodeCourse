package day11;

/**
 * 成员变量初始化的顺序：
 *      1.先对成员变量做默认初始化(和引用数据类型一模一样)
 *      2.显示初始化     (给成员变量赋值)
 *      3.指定初始化     (通过 对象名.属性 来赋值)
 */
public class MemberParameters {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "镜华";
        p.eat();
    }
}
