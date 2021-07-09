package com.test.day13.nightCourse;

/**
 模拟ArrayList类的实现
 * 分析：ArrayList就是一个集合，其底层维护者一个数组，该数组用于存储集合中的数据，也就是ArrayList对数组做了一层封装。
 * 要求：我们模拟的ArrayList集合，底层维护一个String类型的数组即可，也就是只需存储字符串类型的数据。
 *   成员变量：
 *      String[] elementData; // 用于存储集合中的数据
 *      int size;  // 用于保存实际添加元素的个数
 *   构造方法
 *      public ArrayList() { ... }  // 默认设置elementData的空间长度为10
 *      public ArrayList(int cap) { ... }  // 指定设置elementData的空间长度为cap
 *   成员方法
 *      public void add(String element) { ... }  // 在数组末尾添加元素
 *      public void add(int index, String element) { ... }  // 在index索引位置插入元素
 *      public void get(int index) { ... }  // 获得索引为index对应的元素
 *      public void remove(int index) { ... }  // 根据索引删除元素
 */
public class ArrayByMySelf {
    public String[] elementData;
    public int size = 0;

    /*
        不设置长度时，默认长度为10
     */
    public ArrayByMySelf() {
       int len = 10;
       this.elementData = new String[len];
    }

    /*
        设置指定长度的字符串数组
     */
    public ArrayByMySelf(int cap) {
        this.elementData = new String[cap];
    }

    /*
        根据初始化的size添加元素到最后一个位置，并且让size+1
     */
    public void add(String element){
        elementData[this.size] = element;
        this.size++;
    }

    public void add(int index, String element){
        if (index > size){

        }
    }


}
