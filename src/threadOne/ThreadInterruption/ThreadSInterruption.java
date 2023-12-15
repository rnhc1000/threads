package threadOne.ThreadInterruption;

public class ThreadSInterruption {

	public static void main(String[] args) {

		Thread thread = new Thread(new BlockingTask());
		thread.setName("T1");
		System.out.println("Starting thread");
		thread.start();
		System.out.println(thread.getName());

	}

	private static class BlockingTask implements Runnable {

		@Override
		public void run() {
			try {

				Thread.sleep(5000);

			} catch (InterruptedException ex) {

				System.out.println("Interrupted: " + ex.getMessage());

			} finally {

				System.out.println("Done!");

			}
		}
	}
}
