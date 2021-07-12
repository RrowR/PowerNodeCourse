package com.test.day14.Task05;

public class Snake extends Monster {
    public Snake() {
    }

    public Snake(String name, int blood, int aggressivity, String moveWay, String attackWays) {
        super(name, blood, aggressivity, moveWay, attackWays);
    }

    public void addBlood() throws InterruptedException {
        int blood = super.getBlood();
        if (blood < 10) {
            super.setBlood(blood + 20);
        }
        System.out.print("实施大蛇补血术...");
        Thread.sleep(1234);
        System.out.println(",当前生命值为:"+super.getBlood());
    }
}
