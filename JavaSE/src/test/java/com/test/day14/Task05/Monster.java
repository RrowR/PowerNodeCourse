package com.test.day14.Task05;

public class Monster {
    private String name;
    private int blood;
    private int aggressivity;
    private String moveWay;
    public Monster() {
    }

    public Monster(String name, int blood, int aggressivity, String moveWay) {
        this.name = name;
        this.blood = blood;
        this.aggressivity = aggressivity;
        this.moveWay = moveWay;
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
