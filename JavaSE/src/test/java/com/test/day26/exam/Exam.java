package com.test.day26.exam;

import java.io.IOException;
import java.util.*;

public class Exam {
    public void start() {
        Scanner input = new Scanner(System.in);
        ItemService itemService = new ItemService();

        do {
            System.out.println("-----------------------欢迎来到考试系统------------------------------");
            System.out.println("请输入您的操作");
            System.out.println("1.进入考试");
            System.out.println("2.显示上次考试成绩");
            int i = input.nextInt();
            switch (i) {
                case 1:
                    System.out.println("考试马上开始...");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    LinkedList<Item> list = itemService.getItems();
                    char[] chars = new char[10];
                    for (int j = 0; j < list.size(); j++) {
                        int virtualJ = j + 1;
                        System.out.println(list.get(j).getQuestion());
                        HashMap<String, String> hashMap = list.get(j).getHashMap();
                        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                            System.out.println(entry.getKey() + ":" + entry.getValue());
                        }
                        System.out.print("请输入第" + virtualJ + "道题的结果:     ");
                        String answer = input.next();
                        chars[j] = answer.toUpperCase().trim().charAt(0);
                    }
                    System.out.println();
                    System.out.println("考试结束...正在收试卷");
                    try {
                        Thread.sleep(3000);
                        itemService.saveAnswer(chars);
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    break;
                case 10:
                    System.out.println("请输入你要的题目1~10");
                    int num = input.nextInt();
                    Item items = itemService.getItems(num);

                    if (items != null) {
                        System.out.println(items.getQuestion());
                        HashMap<String, String> hashMap = items.getHashMap();
                        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
                        for (Map.Entry<String, String> entry : entries) {
                            System.out.println(entry.getKey() + ":" + entry.getValue());
                        }
                        System.out.println("答案为：" + items.getAnswer());
                    }
                    break;
            }


        } while (true);
    }
}
