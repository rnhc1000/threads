package threadOne.HackerVault.entities;

import threadOne.HackerVault.abstractions.HackerThread;
import threadOne.HackerVault.entities.Vault;

public class DescendingHacker extends HackerThread {

	public static final int MAX_PASSWORD = 9999;

	public DescendingHacker(Vault vault) {
		super(vault);
		this.vault = vault;
	}

	@Override
	public void run() {

		for (int guess = MAX_PASSWORD; guess >= 0; guess--) {

			if (vault.isCorrectPassword(guess)) {

				System.out.println(this.getName() + " guessed the password: " + guess);
				System.exit(0);

			}
		}
	}
}
