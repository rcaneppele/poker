package br.com.rcaneppele.poker.domain.model;

public final class Card implements Comparable<Card> {
	
	private final CardSuit suit;
	private final CardValue value;
	
	public Card(CardSuit suit, CardValue value) {
		this.suit = suit;
		this.value = value;
	}
	
	@Override
	public int compareTo(Card other) {
		return this.value.getValue() - other.value.getValue();
	}
	
	@Override
	public String toString() {
		return value.toString() + suit.toString();
	}

	public CardSuit getSuit() {
		return suit;
	}
	
	public CardValue getValue() {
		return value;
	}

}
