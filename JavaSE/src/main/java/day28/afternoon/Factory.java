package day28.afternoon;

public class Factory {
    public static Payable getInstance(String name){
        switch (name){
            case "zfb":
                return new Alipay();
            case "wx":
                return new WxPay();
            case "yl":
                return new UnionPay();
        }
        return null;
    }
}
