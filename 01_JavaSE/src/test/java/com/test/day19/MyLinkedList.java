package com.test.day19;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>{

    Node<T> first;
    Node<T> last;

    // 记录节点个数
    private int length;

    @Override
    public void add(T e) {
        // 这里不建议放到判断条件里面去，这一步在执行add方法的时候必须先执行
        Node<T> node = new Node<>();
        node.item = e;
        node.prev = null;
        node.next = null;       // 这里这样写还有一个好处末尾节点一定是null

        if (first == null){     // 当链表为空,将第一个节点同时指向首节点和尾节点
            first = node;
            last = node;
        }else {                 // 链表不为空
            node.prev = last;       // 这里的last就是末尾节点，让末尾节点指向新节点的前驱，(注意:这里的prev指向的就是老最后节点)
            node.prev.next = node;
            last = node;
        }
        length++;       // 记录节点个数
    }

    @Override
    public boolean remove(T e) {
        // 因为链表没有索引，查找的时候需要一个一个地顺序去查找
        // 定义一个Node用来遍历整个链表
        Node<T> node = first;
        // 定义一个要删除的Node
        Node<T> deleteNode = null;
        while (node != null){
            if (node.item.equals(e)) {  // 这里尽量用equals，如果传入的是对象我们可以重写equals和hashcode那么比较的是值，如果是基本数据类型，那么里面调用的就是==
                deleteNode = node;      // 如果传入的值和当前节点的值相等，将当前节点的地址给deleteNode
                 break;
            }else {
                node = node.next;       // 否则继续遍历下一个节点
            }
        }

        // 如果没有找到要删除的节点
        if (deleteNode == null){
            return false;
        }else {
            if (deleteNode == first){   // 如果要删除的节点就是第一个节点,那么下一个节点就是第一个first节点
                first = deleteNode.next;
            }else if (deleteNode == last){   // 如果要删除的节点就是最后一个节点
                last = deleteNode.prev;     // 那么被删除节点的上一个节点就是新的last节点
                deleteNode.next = null;     // 并且将新的最后一个节点的后继置为空
            }else {                         // 如果要删除的节点在各节点中间
                deleteNode.prev = deleteNode.next.prev;         // 删除节点的后一个节点的前驱指向删除节点的前一个节点
                deleteNode.prev.next = deleteNode.next;         // 删除节点的后一个节点的内容指向删除节点的前一个节点的后继
            }
            length--;
            return true;
        }
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorImpl();
    }

    public class IteratorImpl implements Iterator<T>{
        Node<T> node = new Node();
        {
            node.next = first;
        }
        @Override
        public boolean hasNext() {
            node = node.next;
            return node != null;        // 由于返回值是boolean类型，当返回值为空的时候就返回null，好做while循环判断下一个是否为空
        }

        @Override
        public T next() {
            return node.item;
        }
    }

    public class Node<T>{
        T item;
        Node<T> prev;
        Node<T> next;
    }
}
