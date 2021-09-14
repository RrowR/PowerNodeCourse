package day18;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Demo01ArrayList {
    @Test
    public void ArrayListForMethod(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=======================================");
        ListIterator<String> listIterator = arrayList.listIterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        System.out.println("---------------------------------------=");
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
    }

    @Test
    public void IteratorRemove(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        Iterator<String> iterator = arrayList.iterator();
        System.out.println(iterator.next());
        iterator.next();
        iterator.remove();
        System.out.println(iterator.next());
        System.out.println("=======================================");
        ListIterator<String> listIterator = arrayList.listIterator(arrayList.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }


    }
}
