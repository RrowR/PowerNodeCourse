package day28.afternoon;

public class MainAppFactoryMode {
    public static void main(String[] args) {
        System.out.println("买了一双鞋花了1000");
//        Payable payable = new Alipay();
//        Payable payable = Factory.getInstance("yl");
        Payable payable = new WxPayFactory().getInstance();
        payable.pay(1000);
    }
}
