package day28.afternoon;

public class Alipay implements Payable {
    @Override
    public void pay(int i) {
        System.out.println("支付宝支付" + i + "元");
    }
}
