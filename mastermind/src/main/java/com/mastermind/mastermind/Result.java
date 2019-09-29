package com.mastermind.mastermind;

public class Result {

	private Integer blacks;
	private Integer whites;

	public Result(Integer blacks, Integer whites) {
		super();
		this.blacks = blacks;
		this.whites = whites;
	}

	public void print() {
		System.out.println(" ---> " + blacks + " blacks and " + whites + " whites");
	}

	public boolean isWinner() {
		return this.blacks == 4;
	}

}
