package Day01;

/**
 * 乘法口诀
 */
public class Test3 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        }
    }
}
