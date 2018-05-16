package com.univ.bakery;


import java.util.Random;
import java.util.Scanner;

public class Bakery {

  // Defining the stock of the bakery
  private final Stock stock = new Stock(20, 0) ;

  public void produce(int numMuffins) throws InterruptedException {
      synchronized (this) {

        int bakedMuffins = stock.add(numMuffins);

        // Every muffin takes 0.2 second to be produced + 0.4 second as a delay
        Thread.sleep(200 * (bakedMuffins + 2));

        if (bakedMuffins != 0)
          System.out.println("Baker baked: " + bakedMuffins);
        notify();
      }
  }

  public void consume(int numMuffins) throws InterruptedException {

      synchronized (this) {

        int consumedMuffins = stock.extract(numMuffins);

        // Every muffin takes 0.1 second to be consumed + 0.2 second as a delay
        Thread.sleep(100 * (consumedMuffins + 2));

        if (consumedMuffins == numMuffins)
          System.out.println("Customer bought: " + consumedMuffins);
        else {
          System.out.println("Customer wants to buy "+numMuffins+" muffins, but actually bought "+consumedMuffins);
        }
        notify();
      }

  }

  public void startBusiness() throws InterruptedException{

    // Creating a thread for producing process
    Thread producing = new Thread(() -> {
      try {
        while (true) {
          produce(((Double) (Math.random()*15)).intValue());
        }
      }
      catch (InterruptedException e){
        e.printStackTrace();
      }
    });

    // Creating a thread for consuming process
    Thread consuming = new Thread(() -> {

      try {
        while (true) {
          consume(((Double) (Math.random()*10)).intValue() +1);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });


    producing.start();
    consuming.start();

    producing.join();
    consuming.join();

  }

}
