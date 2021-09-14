package com.test.day99finalTask.task02;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * 交易明细文件内容如下例：
 * ---------------------------------------------------------------------------
 * #客户号 姓名 所述机构号 性别 帐号 发生时间 发生额
 * 000001|刘德华|0000|1|4155990188888888|20060720200005|300.00
 * 000201|晓龙|0002|1|4155990199999999|20060720200005|500.00
 * 000101|黄晓明|0012|1|4155990100000000|20060720200005|1000.50
 * 000101|张东健|0012|1|4155990155555555|20060720200005|1000.50
 * 000301|刘嘉玲|0013|0|4155990111111111|20060722201005|5000.00
 * 000001|刘德华|0000|1|4155990188888888|20060725200005|200.00
 * ---------------------------------------------------------------------------
 * 一行是一条交易明细，每行分6列，列间用|分隔。#为注释符号。
 * 全部换成List实现
 * 提示：排序、查询采用java.util.Collections中的方法
 * 1，使用字节流，套上转换流，再套上字符缓冲流读取出来
 * 2，FileInputStream-->InputStreamReader-->BufferedReader
 * 3，BufferedWirter-->OutputStreamWriter->FileOutputStream
 * 2，解析数据  #为注释符号
 * 3，新建一个类TransRecord
 * |--id  int
 * |--name  String
 * |--code   String
 * |--sex    String 男  女
 * |--account  String
 * |--createtime  Date    ---SimpleDateFormat
 * |--money    Double
 * 4，性别要求是男女  1--男    0---女
 * 5，使用Collections对发生额进行降序排列
 * 6，把新生成的集合数据写入到项目目录file/newTreansRecord.txt里面
 */
public class Task02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("JavaSE/src/tradeFile.txt"));
        ArrayList<TransRecord> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().startsWith("000")) {
                String[] split = line.trim().split("\\|");
                String sex = split[3];
                sex = sex.trim().equals("1") ? "男" : "女";
                list.add(new TransRecord(Integer.parseInt(split[0]), split[1], split[2], sex, split[4], new Date(Long.parseLong(split[5])), Double.parseDouble(split[6])));
            }
        }
        Collections.sort(list, (o1, o2) -> o1.getMoney() > o2.getMoney() ? 1 : -1);
//        list.forEach(System.out::println);
        JSONObject jsonObject = new JSONObject();
        String jsonString = jsonObject.toJSONString(list);
        // 创建一个字符缓冲输出流
        File file = new File("JavaSE/src/file/");
        if (!file.exists()) {
            file.mkdirs();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("JavaSE/src/file/newTreansRecord.txt"));
        String[] split = jsonString.split("},");
        bw.write(split[0].substring(1) + "}");
        bw.newLine();
        for (int i = 1; i < split.length - 1; i++) {
            bw.write(split[i] + "}");
            bw.newLine();
        }
        bw.write(split[split.length - 1].substring(0, split[split.length - 1].length() - 1));
        bw.close();
    }
}
