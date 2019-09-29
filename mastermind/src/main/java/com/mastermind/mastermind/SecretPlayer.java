package com.mastermind.mastermind;

public class SecretPlayer {
	private SecretCombination secretCombination;
	private PublicPlayer publicPlayer;

	public SecretPlayer(PublicPlayer publicPlayer) {
		this.publicPlayer = publicPlayer;
	}

	public SecretCombination generateCombination() {
		this.secretCombination = new SecretCombination();
		return this.secretCombination;
	}

	public void answer() {
		this.secretCombination.calculateResult(this.publicPlayer.getLastCombination());
		this.publicPlayer.addAttempts();
	}

	public void printCombination() {
		this.secretCombination.print();
	}
}
