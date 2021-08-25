package day28.afternoon;

public class WxPayFactory implements FactoryProvider{
    @Override
    public Payable getInstance() {
        return new WxPay();
    }
}
