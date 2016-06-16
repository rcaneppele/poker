package br.com.rcaneppele.poker.domain.model;

public final class Hand {
	
	private final Cards cards;
	private final Rank rank;

	public Hand(Cards cards, Rank rank) {
		this.cards = cards;
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "Hand - " +rank.toString() +" - [" +cards.toString() +"]";
	}

	public Cards getCards() {
		return cards;
	}
	public Rank getRank() {
		return rank;
	}

}
