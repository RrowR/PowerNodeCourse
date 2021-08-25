package day23.afternoon.task;

import java.io.*;
import java.net.URL;

public class GenerateCode {
    public static void generate() throws Exception {
        ClassLoader classLoader = GenerateCode.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("day23/afternoon/task/entity/Character.class");

        BufferedReader br=new BufferedReader(new InputStreamReader(resourceAsStream));
        System.out.println(br.readLine());
    }
}
