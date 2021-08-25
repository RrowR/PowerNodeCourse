package day28.afternoon;

/*
    我这里已经将不同工厂的不同支付对象进行了返回，是一个终极版，这里的接口只是定义了一个规范，规范了返回值是一个Payable接口类型
 */
public class AlipayFactory implements FactoryProvider{
    @Override
    public Payable getInstance() {
        return new Alipay();
    }
}
