package com.univ.bakery;

public class Stock {

  // Maximum number of muffins allowed in the stock
  private final int capacity ;
  // The available quantity of muffins in the stock
  private int availableQuantity ;

  // Initializing the stock
  public Stock(int capacity, int availableQuantity) {
    this.capacity = capacity;
    this.availableQuantity = availableQuantity;
  }

  // Add a specified number of muffins to the stock
  public int add(int n) {

    // Checking the possibility of adding new muffins and updating the stock
    int oldQuantity = availableQuantity ;
    availableQuantity = availableQuantity + n >= capacity ?
        capacity : availableQuantity + n ;

    // Returning the added new muffins
    return availableQuantity - oldQuantity;
  }

  // Extract a specified number from the stock
  public int extract(int n) {

    // Checking the availability of the requested number of muffins
    if (availableQuantity - n >= 0){
      availableQuantity -= n ;
      return n ;
    }
    // Updating the stock and returning the actual extracted number of muffins
    else{
      n = availableQuantity;
      availableQuantity = 0 ;
      return n ;
    }
  }
}