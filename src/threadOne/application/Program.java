package threadOne.application;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("We are in thread: " + Thread.currentThread().getName());

		Thread threadOne = new Thread(new Runnable() {

			@Override
			public void run() {

				System.out.println("We are in thread ListOne: " + Thread.currentThread().getName());
				System.out.println("ListOne Priority: " + Thread.currentThread().getPriority());

				List<Integer> listOne = Arrays.asList(0, 2, 4, 6, 8, 10);
				for (int i : listOne) {

					System.out.print(i + " ");

				}
			}

		});
		threadOne.setName("Even Thread");

		Thread threadTwo = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("We are in thread ListTwo: " + Thread.currentThread().getName());
				System.out.println("ListTwo Priority: " + Thread.currentThread().getPriority());
				List<Integer> listTwo = Arrays.asList(1, 3, 5, 7, 9);

				for (int i : listTwo) {

					System.out.print(i + " ");
				}

			}
		});
		threadTwo.setName("Odd Thread");

		Random random = new Random();
		int r = random.nextInt(1, 10);
		threadOne.setPriority(r);

		r = random.nextInt(1, 10);
		threadTwo.setPriority(r);

		threadOne.start();
		threadOne.join();
		threadTwo.start();
		threadTwo.join();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
