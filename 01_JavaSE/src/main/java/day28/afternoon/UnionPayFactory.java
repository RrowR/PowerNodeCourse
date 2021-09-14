package day28.afternoon;

public class UnionPayFactory implements FactoryProvider{
    @Override
    public Payable getInstance() {
        return new UnionPay();
    }
}
