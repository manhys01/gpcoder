package com.gpcoder.patterns.creational.objectpool;

public class TaxiApp {

    private static final  int NUMBER_OF_CLIENT = 8;

    public static void main(String[] args) {
        TaxiPool taxiPool = new TaxiPool();
        for(int i = 0; i <= NUMBER_OF_CLIENT; i++){
            Runnable client = new ClientThread(taxiPool);
            Thread thread = new Thread(client);
            thread.start();
        }
    }

}
