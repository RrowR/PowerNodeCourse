package day07;


public class MethodPosting {
    public static void main(String[] args) {
//        System.out.println(toBineryString(5));
        System.out.println(addTwoNum(2, 3));
    }

    private static int addTwoNum(int a,int b) {
        return a + b;
    }

    /**
     * 将一个int类型转换为二进制
     * @param num   输入的num值
     * @return  返回一个int类型的二进制值
     */
    public static int toBineryString(int num){
        // 输入一个正整数，然后把该正整数转化为二进制,使用int来进行输出
        int number = num;
        int bit = 0;
        int count = 0;
        while (true){
            if (number == 0){       // 下面的number会一直 / 2 直到等于0后 break 退出循环
                break;
            }else {
                int i = number % 2;
                System.out.println(i);
                number /= 2;
                int pow = (int) Math.pow(10, count);
                count++;
                bit += i * pow;
            }
        }
        System.out.println("使用int接收转二进制的值为:"+bit);
        return bit;
    }
}
