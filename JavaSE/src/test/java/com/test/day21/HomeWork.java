package com.test.day21;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HomeWork {
    @Test
    public void Task01(){
        /*
            1. 在E:PowerNodeCourse/mydoc盘中全盘查找最近7天修改过的word文档
         */
        File file = new File("E:PowerNodeCourse/mydoc");
        ArrayList<File> arrayList = new ArrayList<>();
        ArrayList<File> list = searchFile(file, arrayList);
        for (File f : list) {
            if ((System.currentTimeMillis() - f.lastModified()) < 7 * 24 * 60 * 60 * 1000) {
                System.out.println(f);
            }
        }
    }

    @Test
    public void Task02() throws InterruptedException {
        /*
            2. 使用ArrayList集合保存所有的学生信息完成如下功能
                1. 添加学生
                2. 删除学生
                3. 修改学生电话
                4. 根据姓名查询学生信息
         */
        Student stu = null;
        ArrayList<Student> students = new ArrayList<>();
        studentAdd(students);
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("====================欢迎来到学生信息操作系统====================");
            System.out.println("请输入要执行的操作");
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 修改学生电话");
            System.out.println("4. 根据姓名查询学生信息");
            System.out.println("5. 查询所有学生信息");
            System.out.println("6. 退出系统");
            int num = input.nextInt();
            switch (num){
                case 1:
                    Student student = new Student();
                    System.out.println("请输入学生姓名: ");
                    String name = input.next();
                    student.setName(name);
                    System.out.println("请输入学生年龄: (大于0且小于100)");
                    int age = input.nextInt();
                    if (age > 100 || age < 0){
                        System.out.println("年轻不对，请重新输入");
                        break;
                    }
                    student.setAge(age);
                    System.out.println("请输入学生手机号: ");
                    String phone = input.next();
                    if (phone.length() != 11){
                        System.out.println("您输入的手机号位数不对，请重新输入");
                        break;
                    }
                    student.setPhoneNum(phone);
                    students.add(student);
                    System.out.println("添加学生信息中，请稍后...");
                    Thread.sleep(1000);
                    break;
                case 2:
                    System.out.println("请输入要删除的学生姓名:");
                    String deleteName = input.next();
                    for (Student s : students) {
                        if (s.getName().equals(deleteName)) {
                            stu = s;
                        }
                    }
                    if (stu == null){
                        System.out.println("您要删除的学生不存在!!!");
                    }else {
                        System.out.println("删除中，请稍后...");
                        Thread.sleep(1234);
                        students.remove(stu);
                    }
                    break;
                case 3:
                    System.out.println("请输入要修改电话的学生姓名:");
                    String stuName = input.next();
                    for (Student s : students) {
                        if (s.getName().equals(stuName)) {
                            stu = s;
                        }
                    }
                    System.out.println("请输入要修改的电话:");
                    String phoneNumstu = input.next();
                    if (phoneNumstu.length() != 11){
                        System.out.println("您输入的手机号码不对，请重新输入");
                        break;
                    }
                    stu.setPhoneNum(phoneNumstu);
                    Thread.sleep(3000);
                    System.out.println("手机号修改成功");
                    break;
                case 4:
                    System.out.println("请输入要查询的学生姓名");
                    String stuName2 = input.next();
                    for (Student s : students) {
                        if (s.getName().equals(stuName2)) {
                            stu = s;
                        }
                    }
                    if (stu == null){
                        System.out.println("您要查询的学生不存在!!!");
                    }else {
                        System.out.println("查询中，请稍后...");
                        Thread.sleep(3000);
                        System.out.println(stu);
                    }
                    break;
                case 5:
                    System.out.println("查询中，请稍后...");
                    Thread.sleep(1000);
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;
                case 6:
                    return;
            }
        }while (true);

    }

    @Test
    public void Task03(){
        /*
            3.完成考勤打卡功能
              2.1使用集合保存所有员工信息
              2.2使用结合保存所有考勤信息
               完成如下功能
                1签到
                2 签退
                3 补卡
                4 统计本月考勤
         */
    }

    private void studentAdd(ArrayList<Student> students) {
        students.add(new Student("猫羽雫",16,"17777212100"));
        students.add(new Student("镜华",12,"17777212101"));
        students.add(new Student("美美",10,"17777212102"));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Student{
        private String name;
        private int age;
        private String phoneNum;
    }

    public ArrayList<File> searchFile(File file,ArrayList<File> list){
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()){
                searchFile(f,list);
            }else {
                list.add(f);
            }
        }
        return list;
    }

}
