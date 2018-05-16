package com.univ.bakery;

public class Main {

  public static void main(String[] args) throws InterruptedException {

    Bakery bakery = new Bakery();

    // Starting the business process
    try {
        bakery.startBusiness();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}