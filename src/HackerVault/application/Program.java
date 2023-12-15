package HackerVault.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import HackerVault.entities.AscendingHacker;
import HackerVault.entities.DescendingHacker;
import HackerVault.entities.Police;
import HackerVault.entities.Vault;

public class Program {
	public static void main(String[] args) {
		final int MAX_PASSWORD = 9999;

		Random random = new Random();
		Vault vault = new Vault(random.nextInt(MAX_PASSWORD));

		List<Thread> threads = new ArrayList<>();
		threads.add(new AscendingHacker(vault));
		threads.add(new DescendingHacker(vault));
		threads.add(new Police());

		for (Thread thread : threads) {
			thread.start();
		}

	}

}
