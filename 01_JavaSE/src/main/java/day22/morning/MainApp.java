package day22.morning;

import java.io.IOException;

public class MainApp {
    public static void main(String[] args) throws IOException {
        FileOperate.init("JavaSE/src/a.txt");
        FileOperate.devideFile("JavaSE/src/a.txt",1024*1024);
        FileOperate.combineFile("JavaSE/src/a");
    }
}
