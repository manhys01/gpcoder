package com.gpcoder.patterns.creational.prototype;

public class PrototypeExample {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Board chessBoard = new Board();
        long endTime = System.currentTimeMillis();
        System.out.println("Time take to create a board: " + (endTime - startTime) + " milliseconds.");
        chessBoard.print();
    }
}
