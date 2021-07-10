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
    public void add(String element) {
        while (true) {
            if (size < elementData.length) {
                elementData[size++] = element;
                break;
            } else {
                // 扩容
                int capacity = size + 1;
                String[] newArr = new String[capacity];
                System.arraycopy(elementData,0,newArr,0,elementData.length);
                elementData = newArr;
                newArr = null;
            }
        }
    }

    public void add(int index, String element) {
        while (true) {
            if (size < elementData.length && index < elementData.length) {
                if (elementData[index] == null) {
                    elementData[index] = element;
                } else {
                    System.arraycopy(elementData, index, elementData, index + 1, size - index);
                    elementData[index] = element;
                }
                size++;
                break;
            } else {
                if (index >= elementData.length){
                    String[] newArr = new String[index + 1];
                    System.arraycopy(elementData, 0, newArr, 0, elementData.length);
                    elementData = newArr;
                    newArr = null;
                }else if (size >= elementData.length){
                    String[] newArr = new String[size + 1];
                    System.arraycopy(elementData, 0, newArr, 0, elementData.length);
                    elementData = newArr;
                    newArr = null;
                }
            }
        }
    }

    public String get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("不在范围内");
        } else {
            if (elementData[index] == null) {
                return "您查找的数不存在";
            }
            return elementData[index];
        }
    }

    public void remove(int index) {
        if (index >= elementData.length - 1){
            throw new IndexOutOfBoundsException("不在范围内");
        }else {
            String[] newArr = new String[elementData.length - 1];
            System.arraycopy(elementData,index + 1,elementData,index,elementData.length - index - 1);
            elementData[elementData.length - 1] = null;
            System.arraycopy(elementData,0,newArr,0,elementData.length - 1);
            elementData = newArr;
            newArr = null;
            size--;
        }
    }


}
