package day22.morning;

import org.junit.Test;

import java.io.*;

public class TestMethod {
    public static void main(String[] args) throws IOException {
        File file = new File("JavaSE/src/a.txt");
        System.out.println(file.exists());
        System.out.println(file.getPath());
    }

    @Test
    public void encoding() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/b.txt"));
        // BufferedReader的特有方法 readLine()
        String s = br.readLine();
        System.out.println(s);
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/b.txt"));
        bw.newLine();
    }
}
