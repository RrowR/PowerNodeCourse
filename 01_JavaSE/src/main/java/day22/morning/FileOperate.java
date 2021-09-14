package day22.morning;

import java.io.*;
import java.util.Properties;

public class FileOperate {
    public static void init(String str) throws IOException {
        File file = new File(str);
        // 只有字节流才有 BufferedWriter.newLine()
        BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream(file));
        // 获取当前系统属性
        Properties properties = System.getProperties();
        // 获取属性中换行操作符（tips：不同系统不一样  win: /r/n linux: /n mac: /r）
        String enter = properties.getProperty("line.separator");
        String data = "这是一个字符串" + enter;
        byte[] bytes = data.getBytes("utf-8");
        for (int i = 0; i < 100002 ; i++) {
            bof.write(bytes);
            // 每次到写一个数组大小内容就开始刷新，不让缓冲区满了再刷新
            bof.flush();
        }
        bof.close();        // 其实这里写了close就不需要自己再flush了
    }

    public static void devideFile(String str,int size){
        File file = new File(str);
        try (BufferedInputStream br = new BufferedInputStream(new FileInputStream(file))){
            StringBuilder builder = new StringBuilder();
            String filePath = file.getPath();
            String[] split = filePath.split("\\.");
            builder.append(split[0]);
            // file.separator 文件分隔符（在 UNIX 系统中是“/”）
            builder.append(System.getProperties().getProperty("file.separator"));
            // 此时的builder内容为 JavaSE/src/a/
            String path = builder.toString();
            // 先判断文件夹是否存在，不存在先创建
            if (!new File(path).exists()){
                File f = new File(path);
                f.mkdir();
            }
            int i = 1;
            int len;
            byte[] bytes = new byte[size];
            while ((len = br.read(bytes)) != -1){
                try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + i++ + ".txt"))){
                    bos.write(bytes,0,len);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void combineFile(String str){
        File file = new File(str);
        // 获得当前路径的相对路径
        String path = file.getPath();
        File[] files = file.listFiles();        // 这个文件夹下的文件一定都是文件而非文件夹，因为是上面程序拆分的结果
        for (File f : files) {
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f)); FileOutputStream fos = new FileOutputStream(path + System.getProperties().getProperty("file.separator") + "combine.txt", true)) {
                int len;
                byte[] bytes = new byte[1024];
                while ((len = bis.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
