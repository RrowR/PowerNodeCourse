package com.test.day26.exam;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

public class ItemService {
    Item[] items = new Item[10];
    LinkedList<Item> linkedList = new LinkedList<>();

    public ItemService() {
        try {
            readTextFile("JavaSE/src/Items.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Item[] readTextFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        int lines = 1;      // 设置一个标志，每次被6整除就多读一行
        LinkedList<Item> list = new LinkedList<>();
        String line;
        String question = null;
        String A = null;
        String B = null;
        String C = null;
        String D = null;
        String answer = null;
        while ((line = br.readLine()) != null) {
            if (line.trim().startsWith("第")) {
                question = line;
            }
            if (line.trim().startsWith("A.")) {
                A = line.substring(2, line.length());
            }
            if (line.trim().startsWith("B.")) {
                B = line.substring(2, line.length());
            }
            if (line.trim().startsWith("C.")) {
                C = line.substring(2, line.length());
            }
            if (line.trim().startsWith("D.")) {
                D = line.substring(2, line.length());
            }
            if (line.trim().length() == 1) {
                answer = line;
            }
            if (lines++ % 6 == 0) {
                br.readLine();
                Item item = new Item();
                HashMap<String, String> map = new HashMap<>();
                map.put("A", A);
                map.put("B", B);
                map.put("C", C);
                map.put("D", D);
                item.setQuestion(question);
                item.setAnswer(answer);
                item.setHashMap(map);
                list.add(item);
                linkedList = list;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            items[i] = list.get(i);
        }
        return items;
    }

    public Item getItems(int input) {
        int no = input - 1;
        Item item = null;
        try {
            item = items[no];
        } catch (Exception e) {
            System.out.println("您输入的题目不存在,请重新输入");
        }
        return item;
    }

    public LinkedList<Item> getItems() {
        return linkedList;
    }

    public void saveAnswer(char[] answers) throws IOException {
        Answers answer = new Answers(answers);
        /*
        // 写对象到内存流中（但是这里不需要使用内存流,内存流用于网络文件传输才会用到，所以不需要讲对象转换为字节）
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        */
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("JavaSE/src/answer.dat"));
        oos.writeObject(answer);
        oos.close();
    }

}
