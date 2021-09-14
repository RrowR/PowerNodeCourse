package com.test.day99finalTask.booksalesystem;

/**
 * 二、	项目需求
 * 完成对动力节点书店图书的管理，包括：
 * 1.	图书信息的展示
 * 2.	入库图书（已有情况下增加数量）
 * 3.	出库图书（已有情况下减少数量）
 * 4.	新增图书（新书，库房没有）
 * 5.	展示图书信息
 */
public class MainApp {
    public static void main(String[] args) {
        BookSystem system = new BookSystem();
        system.start();
    }
}
