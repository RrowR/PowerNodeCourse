package com.test.day15.Task01;

public class Musician extends Instrument{
    private String name;

    public Musician(String musicalInstrument, String name) {
        super(musicalInstrument);
        this.name = name;
    }

    @Override
    public String makeSound() {
        String instruments = super.makeSound();
        System.out.println(name+"使用"+instruments+"演奏了音乐");
        return null;
    }
}
