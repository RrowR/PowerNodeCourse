package day14.com.demoToString;

public class BB extends AA{
    private String hobby;

    @Override
    public String toString() {
        return "BB{" +
                "hobby='" + hobby + '\'' +
                "} " + super.toString();
    }
}
