package day28.afternoon;

public class WxPay implements Payable{
    @Override
    public void pay(int i) {
        System.out.println("微信支付" + i + "元");
    }
}
