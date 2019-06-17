package com.gpcoder.patterns.structural.adapter;

public class TranslateAdapter implements VietnameseTarget {

    private EnglishAdaptee adaptee;

    public TranslateAdapter(EnglishAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void send(String words) {
        System.out.println("Reading words");
        String englishWords = translate(words);
        System.out.println("Sending words");
        adaptee.receive(englishWords);
    }

    private String translate(String vietnameseWords){
        System.out.println("Translated");
        return "Hello";
    }

}
