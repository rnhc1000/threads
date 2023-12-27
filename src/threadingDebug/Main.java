package threadingDebug;

public class Main {

  public static void main(String[] args) {
    Thread threads = new Thread(new BlockingTask());
    threads.setName("tOne");
    threads.start();
    System.out.println("Starting: " + threads.getName() );

  }

  private static class BlockingTask implements Runnable{

    @Override
    public void run() {
      try {
        String [] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        for (String s : importantInfo) {

          Thread.sleep(5000);
          System.out.println(s);
        }
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } finally{
        System.out.println("Done!");
      }
    }
  }
}
