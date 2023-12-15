package threadOne.HackerVault.entities;

import threadOne.HackerVault.abstractions.HackerThread;

public class AscendingHacker extends HackerThread {

	public static final int MAX_PASSWORD = 9999;

	public AscendingHacker(Vault vault) {
		super(vault);
	}

	@Override
	public void run() {

		for (int guess = 0; guess < MAX_PASSWORD; guess++) {

			if (vault.isCorrectPassword(guess)) {

				System.out.println(this.getName() + " guessed the password: " + guess);
				System.exit(0);

			}

		}
	}

}
