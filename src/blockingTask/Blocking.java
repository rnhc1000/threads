package blockingTask;

import java.math.BigInteger;

public class Blocking {

  public static void main(String[] args) {

//    Thread thread = new Thread(new BlockingTask());
//    thread.setName("T1");
//    thread.start();
//    while(thread.isAlive()) {
//      System.out.print("Waiting..." + " ");
//    }
    System.out.println("Started!!!");
    Thread thread = new Thread(new LongComputationTask(new BigInteger("200"), new BigInteger("10000")));
    thread.start();
    thread.interrupt();
 }


  private static class BlockingTask implements Runnable{

    @Override
    public void run() {
      try {
        for (int i=0; i<10; i++) {
          Thread.sleep(500);
          System.out.println("[ " + i + " ]");

        }
      } catch (InterruptedException e) {
        System.out.println("Exiting block thread");
        throw new RuntimeException(e);
      }
    }
  }

  private static class LongComputationTask implements Runnable {

    private BigInteger base;
    private BigInteger power;

    public LongComputationTask(BigInteger base, BigInteger power) {
      this.base = base;
      this.power = power;
    }

    @Override
    public void run() {

      System.out.println(base + "EXP"  + power + " = " + pow(base,power));

    }

    public LongComputationTask() {
    }

    private BigInteger pow(BigInteger base, BigInteger power) {

      BigInteger result = BigInteger.ONE;

      for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
        if(Thread.currentThread().isInterrupted()) {
          System.out.println("Prematurely ended!!!");
          return BigInteger.ZERO;
        }
        result = result.multiply(base);
        System.out.println(result);

      }
      return result;
    }
  }
}
