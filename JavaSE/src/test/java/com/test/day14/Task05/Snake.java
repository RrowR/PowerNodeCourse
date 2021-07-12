package com.test.day14.Task05;

public class Snake extends Monster {
    private String attackWays;

    public Snake() {
    }

    public Snake(String attackWays, String name, int blood, int aggressivity, String moveWay) {
        super(name, blood, aggressivity, moveWay);
        this.attackWays = attackWays;
    }

    public String getAttackWays() {
        return attackWays;
    }

    public void setAttackWays(String attackWays) {
        this.attackWays = attackWays;
    }

    public void addBlood() throws InterruptedException {
        int blood = super.getBlood();
        if (blood < 10) {
            super.setBlood(blood + 20);
        }
        System.out.print("实施大蛇补血术..." + ",当前生命值为:");
        Thread.sleep(3000);
        System.out.println(super.getBlood());
    }

    public void show(){
        String move = super.getMove();
        System.out.println(move);
    }
}
