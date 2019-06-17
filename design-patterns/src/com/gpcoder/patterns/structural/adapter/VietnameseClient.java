package com.gpcoder.patterns.structural.adapter;

public class VietnameseClient {
    public static void main(String[] args) {
        VietnameseTarget vietnameseTarget = new TranslateAdapter(new EnglishAdaptee());
        vietnameseTarget.send("Xin chào");
    }
}
