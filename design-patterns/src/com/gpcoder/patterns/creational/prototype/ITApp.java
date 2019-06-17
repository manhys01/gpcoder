package com.gpcoder.patterns.creational.prototype;

public class ITApp {
    public static void main(String[] args) {
        Computer standardComputer = new Computer("Windows 10", "Office 2016", "AVG", "Chrome", "Unikey");
        Computer computer1 = standardComputer.clone();
        Computer computer2 = standardComputer.clone();
        computer1.setOthers("IntelliJ");
        computer2.setOthers("Eclipse");
        System.out.println(computer1);
        System.out.println(computer2);
    }
}
