package com.test.day14.Task05;
// 蜈蚣精
public class Centipede extends Monster{
    private int attack;

    public Centipede() {
    }

    public Centipede(String name, int blood, int aggressivity, String moveWay, int attack) {
        super(name, blood, aggressivity, moveWay);
        this.attack = attack;
    }


}
