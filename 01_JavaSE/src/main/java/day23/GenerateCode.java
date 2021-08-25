package day23;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GenerateCode {
    public static void generate() throws IOException {
        BufferedReader bis = new BufferedReader(new FileReader("JavaSE/src/main/java/day23/Student.java"));
        // 循环条件，当读出来的内容为空时（即读不到数据时，结束循环）
        String line;
        String packageDate = null;
        String className = null;
        String generateName = "generate";
        HashMap<String, String> hashMap = new HashMap<>();
        while ((line = bis.readLine()) != null) {
            if (line.contains("import")) {
                String[] parts = line.trim().split(" ");
                packageDate = parts[1];
            }
            if (line.contains("public class")) {
                String[] parts = line.trim().split(" ");
                className = parts[2];
            }
            if (line.contains("private")) {
                String[] parts = line.trim().split(" ");
                // 使用hashMap存取每个name 和 类型
                hashMap.put(parts[2].substring(0, parts[2].length() - 1), parts[1]);
            }
        }
        if (!new File("JavaSE/src/main/java/day23/generate/").exists()) {
            new File("JavaSE/src/main/java/day23/generate/").mkdir();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("JavaSE/src/main/java/day23/" + generateName + "/" + className + ".java"));
        bw.write("package " + "day23." + generateName + ";");
        bw.newLine();
        bw.newLine();
        bw.write("import " + packageDate);
        bw.newLine();
        bw.write("import lombok.AllArgsConstructor;");
        bw.newLine();
        bw.write("import lombok.Data;");
        bw.newLine();
        bw.write("import lombok.NoArgsConstructor;");
        bw.newLine();
        bw.newLine();
        bw.write("@Data");
        bw.newLine();
        bw.write("@AllArgsConstructor");
        bw.newLine();
        bw.write("@NoArgsConstructor");
        bw.newLine();
        bw.write("public class " + className + " {");
        bw.newLine();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            bw.write("\tprivate " + entry.getValue() + " " + entry.getKey() + ";");
            bw.newLine();
        }
        bw.write("}");


        bis.close();
        bw.close();
    }
}
