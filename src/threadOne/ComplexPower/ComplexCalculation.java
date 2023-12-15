package threadOne.ComplexPower;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplexCalculation {

  public static void main(String[] args) {

    Map<Long, Long> basis = new HashMap<>();

    basis.put(10L, 2L);
    basis.put(12L, 2L);
    basis.put(14L, 2L);
    basis.put(16L, 2L);

    for(Map.Entry<Long,Long> pair: basis.entrySet()) {
      long r = (long)Math.pow(pair.getKey(), pair.getValue());
      System.out.println(r);
    }


    basis.forEach((k,v)-> System.out.println("key: " + k + " value: " + v));

    BigInteger b1,p1,b2,p2;
    b1=BigInteger.TWO;
    p1=BigInteger.ONE;
    b2=BigInteger.TWO;
    p2=BigInteger.TEN;

    BigInteger resultOne = calculateResult(b1, p1, b2,p2);
    System.out.println("Result is: " + resultOne);

  }
  public static BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
    BigInteger result;

    PowerCalculatingThread threadOne = new PowerCalculatingThread(base1, power1);
    PowerCalculatingThread threadTwo = new PowerCalculatingThread(base2, power2);
    threadOne.start();
    threadTwo.start();
    try {
      threadOne.join();
      threadTwo.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    return  threadOne.getResult().add(threadTwo.getResult());

  }

  private static class PowerCalculatingThread extends Thread {
    private BigInteger result = BigInteger.ONE;
    private BigInteger base;
    private BigInteger power;

    public PowerCalculatingThread(BigInteger base, BigInteger power) {
      this.base = base;
      this.power = power;
    }

    @Override
    public void run() {
      result =  pow(base,power);
    }

    private static BigInteger pow(BigInteger base, BigInteger power) {

      BigInteger result = java.math.BigInteger.ONE;

      for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
        if (Thread.currentThread().isInterrupted()) {
          return BigInteger.ZERO;
        }
        result = result.multiply(base);
      }

      return result;
    }

    public BigInteger getResult() { return result; }
  }
}