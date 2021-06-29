package day07;

/**
 * 可以定义别名来执行外部循环的操作
 */
public class OuterBreakAndContinueDemo01 {
    public static void main(String[] args) {
//        method01();
        method02();

    }

    private static void method02() {
        /**
         *i=0
         * j=0
         * j=1
         * j=2
         * i=1
         * j=0
         * j=1
         * j=2
         * i=2
         * j=0
         * j=1
         * j=2
         * i=3
         * j=0
         * j=1
         * j=2
         * i=4
         * j=0
         * j=1
         * j=2
         *
         */
        outer : for (int i = 0; i < 5; i++) {
            System.out.println("i="+i);
            for (int j = 0; j < 5; j++) {
                System.out.println("j="+j);
                if (j == 2){
                    continue outer;
                }
            }
        }
    }

    private static void method01() {
        /**
         * i=0
         * j=0
         * j=1
         * j=2
         */
        outer : for (int i = 0; i < 5; i++) {
            System.out.println("i="+i);
            for (int j = 0; j < 5; j++) {
                System.out.println("j="+j);
                if (j == 2){
                    break outer;
                }
            }
        }
    }
}
