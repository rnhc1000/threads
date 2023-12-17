package BigNumbers;

import java.math.BigInteger;
import java.util.Scanner;

/*
* <h1>Add two Big Numbers</h1>
* Using BigInteger() class, show how to
* sum up two BigIntegers via add().
 * @(#)BigNumber.java
 * @author  Ricardo Ferreira
 * @version 1.0
 * @since   2023-03-31
 * Copyright (c) 2005-2023 Datagen1x.
 * Santo Agapito, 7, Imperatriz - MA, BR.
 * All rights reserved.
 *
 */
public class BigNumbers {

  public static void main(String[] args) {
  /*
    @param Given two numbers
    @return BigInteger sum.
  */
    BigInteger n1, n2;
    Scanner input = new Scanner(System.in);
    System.out.print("Input the 1st number: ");
    n1 = input.nextBigInteger();
    System.out.println("Input the 2nd number: ");
    n2 = input.nextBigInteger();
    BigInteger sum = n1.add(n2);
    System.out.print("Sum of n1 + n2 is: " + sum);
  }
}
