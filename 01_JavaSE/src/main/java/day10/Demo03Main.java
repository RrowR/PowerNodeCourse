package day10;

/**
 * args 的作用
 * 在configuration里的 program arguments里设置，用空格来分割
 */
public class Demo03Main {
    public static void main(String[] args) {
        System.out.println(args.length);
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
