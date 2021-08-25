package com.test.day14.Task05;

public class Monster {
    private String name;
    private int blood;
    private int aggressivity;
    private String moveWay;
    private String attackWays;
    public Monster() {
    }

    public Monster(String name, int blood, int aggressivity, String moveWay, String attackWays) {
        this.name = name;
        this.blood = blood;
        this.aggressivity = aggressivity;
        this.moveWay = moveWay;
        this.attackWays = attackWays;
    }

    public String getName() {
        return name;
    }

    public String getAttackWays() {
        return attackWays;
    }

    public String getMoveWay() {
        return moveWay;
    }

    public void setMoveWay(String moveWay) {
        this.moveWay = moveWay;
    }

    public void setAttackWays(String attackWays) {
        this.attackWays = attackWays;
    }

    public int getAggressivity() {
        return aggressivity;
    }

    public void setAggressivity(int aggressivity) {
        this.aggressivity = aggressivity;
    }

    public String getMove(){
        return moveWay;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

}
