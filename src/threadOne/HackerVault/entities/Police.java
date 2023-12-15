package threadOne.HackerVault.entities;

public class Police extends Thread {

	public Police() {
	}

	Thread policeThread = new Thread();

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
