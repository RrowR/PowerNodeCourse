package day28.afternoon;

public class UnionPay implements Payable{

    @Override
    public void pay(int i) {
        System.out.println("银联支付" + i + "元");
    }
}
