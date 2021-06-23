package Day02;

public class Test04 {
    private static double currentDeposit = 0.0035;
    private static double regularSingleDeposit = 0.015;
    private static double regularDoubleDeposit = 0.021;
    public static void main(String[] args) {
        deposit(10000);
    }

    /**
     * Math.round 取long类型，和整型一样都是4个字节
     * @param i
     */
    private static void deposit(int i) {
        System.out.println("本金"+i);
        System.out.println("活期1年本金总计"+Math.round((i+i*currentDeposit)));
        System.out.println("定期1年本金总计"+Math.round((i+i*regularSingleDeposit)));
        System.out.println("活期2年本金总计"+Math.round(((i+i*currentDeposit)+(i+i*currentDeposit)*currentDeposit)));
        System.out.println("定期2年本金统计"+Math.round((i+i*regularDoubleDeposit)*regularDoubleDeposit+(i+i*regularDoubleDeposit)));
    }
}
