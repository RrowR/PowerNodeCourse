package day19;

import org.junit.Test;

import java.util.Date;
import java.util.TreeSet;

public class TestTreeSet {
    @Test
    public void CompareOuter(){
        Trunk t2 = new Trunk("南", 200.0, new Date(2222), "second");
        Trunk t1 = new Trunk("东", 100.0, new Date(1111), "first");
        Trunk t3 = new Trunk("西", 300.0, new Date(4444), "third");
        Trunk t4 = new Trunk("北", 400.0, new Date(3333), "forth");
        // 在创建TreeSet的时候，传入自己编写的比较器
        TreeSet<Trunk> treeSet = new TreeSet<>(new Mycomparator());
        treeSet.add(t1);
        treeSet.add(t2);
        treeSet.add(t3);
        treeSet.add(t4);
        for (Trunk trunk : treeSet) {
            System.out.println(trunk);
        }
    }

    @Test
    public void CompareInner(){
        Car car2 = new Car("南", 200.0, new Date(), "second");
        Car car1 = new Car("东", 100.0, new Date(), "first");
        Car car4 = new Car("北", 400.0, new Date(), "forth");
        Car car3 = new Car("西", 300.0, new Date(), "third");
        TreeSet<Car> treeSet = new TreeSet<>();
        treeSet.add(car2);
        treeSet.add(car1);
        treeSet.add(car4);
        treeSet.add(car3);
        for (Car car : treeSet) {
            System.out.println(car);
        }
    }
}
