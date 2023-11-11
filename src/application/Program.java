package application;

import java.util.Arrays;
import java.util.List;

public class Program {
  public static void main(String[] args) {
    Thread threadOne = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("We are now in thread ListOne: " + Thread.currentThread().getName());
        List<Integer> listOne = Arrays.asList(0,2,4,6,8,10);
        for (int i : listOne) {
          System.out.print(i + " ");
        }
      }

    });

    Thread threadTwo = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("We are in thread ListTwo: " + Thread.currentThread().getName());
        List<Integer> listTwo = Arrays.asList(1,3,5,7,9);
        for (int i : listTwo) {
          System.out.print(i + " ");
        }

      }
    });
    threadOne.start();
    System.out.println();
    threadTwo.start();
    System.out.println("We are in thread: " + Thread.currentThread().getName());

    // try {
    //   Thread.sleep(10000);
    // } catch (InterruptedException e) {
    //   e.printStackTrace();
    // }

  }
}
