package com.mastermind.mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PublicCombination extends Combination {

	private Result result;

	public PublicCombination() {
		super();
	}

	public void read() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String proposedCombination = "";

		while (!this.isValidCombination(proposedCombination)) {
			System.out.println("Propose a combination:");
			try {
				proposedCombination = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Integer calculateBlacks(SecretCombination secretCombination) {
		Integer blacks = 0;

		for (int i = 0; i < this.combination.size(); i++) {
			if (this.combination.get(i).equals(secretCombination.combination.get(i))) {
				blacks++;
			}
		}
		return blacks;
	}

	public Integer calculateWhites(SecretCombination secretCombination) {
		Integer whites = 0;

		for (int i = 0; i < this.combination.size(); i++) {
			for (int j = 0; j < secretCombination.combination.size(); j++) {
				if (this.combination.get(i).equals(secretCombination.combination.get(j))) {
					whites++;
					break;
				}
			}
		}
		return whites;
	}

	public boolean isWinner() {
		return this.result != null && this.result.isWinner();
	}

	public void print() {
		System.out.print(this.combination);
		this.result.print();
	}

	private boolean isValidCombination(String proposedCombination) {
		String[] proposedCombinationArr = proposedCombination.split("");
		if (proposedCombinationArr.length != 4) {
			System.out.println("Wrong proposed combination length");
			return false;
		} else {
			for (int i = 0; i < proposedCombinationArr.length; i++) {
				if (this.isValidColor(proposedCombinationArr[i])) {
					if (this.isRepeatedColor(proposedCombinationArr[i])) {
						System.out.println("Repeated colors");
						this.combination.removeAll(this.combination);
						return false;
					} else {
						this.combination.add(Color.valueOf(proposedCombinationArr[i].toUpperCase()));
					}
				} else {
					System.out.println("Wrong colors, they must be: " + printColors());
					this.combination.removeAll(this.combination);
					return false;
				}
			}
			return true;
		}
	}

	private boolean isValidColor(String proposedColor) {
		try {
			Color.valueOf(proposedColor.toUpperCase());
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	private boolean isRepeatedColor(String proposedColor) {
		return this.combination.contains(Color.valueOf(proposedColor.toUpperCase()));
	}

	private String printColors() {
		String colors = "";
		for (Color color : Color.values()) {
			colors += color.toString();
		}
		return colors;
	}
}
