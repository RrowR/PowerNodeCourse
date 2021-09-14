package com.test.day15.Task01;

public class TestMusicianPlayMusic {
    public static void main(String[] args) {
        Instrument erhu = new Erhu("二胡");
        Instrument piano = new Piano("钢琴");
        Instrument violin = new Violin("小提琴");
        Musician musician = new Musician("咚咚", piano);
        musician.playInstrument();

    }
}
