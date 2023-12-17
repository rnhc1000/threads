package HackerVault.entities;

public class Police extends Thread {

  Thread policeThread = new Thread();

  public Police() {
  }

  @Override
  public void run() {

    for (int i = 10; i > 0; i--) {

      try {
        Thread.sleep(1000);

      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println(i);
    }

    System.out.println("Game over for you guys!!!!");
    System.exit(0);
  }

}
