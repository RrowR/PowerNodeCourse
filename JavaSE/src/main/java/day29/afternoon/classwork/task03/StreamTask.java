package day29.afternoon.classwork.task03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamTask {
    @Test
    public void Task01() {
        ArrayList<Clerk> list = new ArrayList<>();
        list.add(new Clerk("张三", "男", 50000.0));
        list.add(new Clerk("李四", "男", 150000.0));
        list.add(new Clerk("王女", "女", 200000.0));
        Stream<Clerk> stream = list.stream();
        // 筛选所有工资在100000-200000之间的员工信息 打印输出
//        stream.filter(a -> a.getSalary() > 100000.0 && a.getSalary() < 200000.0).forEach(System.out::println);
        // 筛选性别为男的员工中工资最高的员工 姓名输出
//        System.out.println(stream.filter(a -> a.gender.equals("男")).max((a, b) -> (int) Math.signum(a.salary - b.getSalary())));
        // 将工资>=100000 的员工的姓名和性别提取到新的流中并输出
        stream.filter(clerk -> clerk.getSalary() >= 100000).map(clerk -> clerk.getName() + ":" + clerk.gender).forEach(System.out::println);

        /*qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq
        stream.filter(a -> a.getSalary() >= 100000).map(a -> {
            Clerk clerk = new Clerk();
            clerk.setName(a.getName());
            clerk.setGender(a.gender);
            return clerk;
        }).forEach(System.out::println);
        */



    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Clerk {
        private String name;
        private String gender;
        private Double salary;
    }
}
