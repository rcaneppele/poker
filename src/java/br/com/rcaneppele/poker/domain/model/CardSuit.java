package br.com.rcaneppele.poker.domain.model;

public enum CardSuit {

	SPADES("\u2660"),
	CLUBS("\u2663"),
	HEARTS("\u2665"),
	DIAMONDS("\u2666");
	
	private final String symbol;

	private CardSuit(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		return symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
}
