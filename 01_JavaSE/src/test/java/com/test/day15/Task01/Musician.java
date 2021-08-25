package com.test.day15.Task01;

public class Musician{
    private String musicianName;
    private Instrument instrument;

    public Musician(String musicianName, Instrument instrument) {
        this.musicianName = musicianName;
        this.instrument = instrument;
    }

    public void playInstrument(){
        System.out.println("音乐家"+musicianName+"使用"+instrument.getInstrument()+"演奏了");
    }
}
