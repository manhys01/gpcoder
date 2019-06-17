package com.gpcoder.patterns.structural.adapter;

public class EnglishAdaptee {
    public void receive(String words){
        System.out.println("Receiving words from Adapter");
        System.out.println(words);
    }
}
