package day25;

public class MyThread extends Thread{


    public MyThread(String kkk) {
        // 这里必须调用父类的有参构造才能修改线程名字
    }

    @Override
    public void run() {
        System.out.println(MyThread.currentThread().getName()+" sdasd");
    }
}
