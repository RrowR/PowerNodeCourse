package day13.com.p3;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.PI;

public class StaticImport {
    public static void main(String[] args) {
        // 导入静态常量
        System.out.println(PI);
        // 导入静态方法
        System.out.println(sqrt(100));
    }
}
