package ext.AssertExt;

/**
 * @Author Rrow
 * @Date 2021/12/26 23:25
 * <p>
 * 断言表达式
 * <p>
 * 在configuration VM 里添加一个 -ea(enable assert) 默认是关闭的
 * 有2种方式:
 *  assert age >= 0 : "输入的数据错误";
 *  assert age >= 0 ;        // 这种只是没有提示而已
 */
public class AssertDemo {

    public static void main(String[] args) {
        test(-1);
    }

    private static void test(int age) {
        assert age >= 0 : "输入的数据错误";
        System.out.println("继续执行，输入的年龄是:" + age);
    }
}
