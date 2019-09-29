package com.mastermind.mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mastermind {

	static final String TITLE = "----- MASTERMIND -----";
	static SecretPlayer secretPlayer;
	static PublicPlayer publicPlayer;

	public static void play() {
		publicPlayer = new PublicPlayer();
		secretPlayer = new SecretPlayer(publicPlayer);
		System.out.println(TITLE);
		secretPlayer.generateCombination();
		secretPlayer.printCombination();

		while (publicPlayer.hasAttempts() && !publicPlayer.isLooser() && !publicPlayer.isWinner()) {
			publicPlayer.generateCombination();
			secretPlayer.answer();
			publicPlayer.printAttempts();
			secretPlayer.printCombination();
			publicPlayer.printCombination();
		}
		if (publicPlayer.isWinner()) {
			System.out.println("You've won!!! ;-)");
		} else {
			System.out.println("You've lost!!! :-(");
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String restart = "y";

		while (restart.equals("y")) {
			play();
			System.out.println("Do you want to continue? (y/n):");
			try {
				restart = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
