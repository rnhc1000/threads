package threadOne.FactorialThread.app;

import threadOne.FactorialThread.Factorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadFactorial {

  public static void main(String[] args) {

    List<Long> numbers = Arrays.asList(100000L, 3435L, 2543L, 1224L, 4656L, 23L, 5556L);
    List<Factorial> threads = new ArrayList<>();

    for (long number : numbers) {
      threads.add(new Factorial(number));
    }

    for (Thread thread : threads) {
      thread.setDaemon(true);
      thread.start();
    }

    for (Thread thread : threads) {
      try {
        thread.join(2000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    for (int i = 0; i < numbers.size(); i++) {
      Factorial factorial = threads.get(i);
      if (factorial.isFinished()) {
        System.out.println("Factorial of " + numbers.get(i) + " is: " + factorial.getResult());
      } else {
        System.out.println("The calculation for " + numbers.get(i) + " is still in progress");
      }
    }
  }
}
