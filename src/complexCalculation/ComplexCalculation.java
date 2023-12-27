package complexCalculation;

import java.math.BigInteger;

public class ComplexCalculation {

  public static void main(String[] args) {
    BigInteger result = BigInteger.ZERO;
    BigInteger baseOne = new BigInteger("2");
    BigInteger baseTwo = new BigInteger("3");
    BigInteger powerOne = new BigInteger("10");
    BigInteger powerTwo = new BigInteger("10");

    ComplexCalculation calc = new ComplexCalculation();

   result =  calc.calculateResult(baseOne, powerOne, baseTwo, powerTwo);
    System.out.println("Total sum = " + result);

  }
  public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {

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