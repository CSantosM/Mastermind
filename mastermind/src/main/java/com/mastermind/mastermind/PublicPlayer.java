package com.mastermind.mastermind;

import java.util.ArrayList;
import java.util.List;

public class PublicPlayer {
	private final Integer MAX_ATTEMPTS = 10;
	private Integer attempts;
	private List<PublicCombination> combinations = new ArrayList<PublicCombination>();

	public PublicPlayer() {
		this.attempts = 0;
	}

	public void generateCombination() {
		this.combinations.add(new PublicCombination());
		this.getLastCombination().read();
	}

	public PublicCombination getLastCombination() {
		Integer index = this.combinations.size() - 1;

		if (index >= 0) {
			return this.combinations.get(index);
		} else {
			return null;
		}
	}

	public void printAttempts() {
		System.out.println(this.attempts + " attempt(s)");
	}

	public void printCombination() {
		for (int i = 0; i < this.combinations.size(); i++) {
			this.combinations.get(i).print();
		}
	}

	public void addAttempts() {
		this.attempts++;
	}

	public boolean hasAttempts() {
		return this.attempts < this.MAX_ATTEMPTS;
	}

	public boolean isWinner() {
		return this.getLastCombination() != null && this.getLastCombination().isWinner();
	}

	public boolean isLooser() {
		return this.getLastCombination() != null && !this.getLastCombination().isWinner() && !this.hasAttempts();
	}
}
