package HackerVault.entities;

public class Vault {

	private int password;

	public Vault(int password) {
		this.password = password;
	}

	public boolean isCorrectPassword(int guess) {

		try {

			Thread.sleep(5);

		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
		}

		return this.password == guess;

	}

}
