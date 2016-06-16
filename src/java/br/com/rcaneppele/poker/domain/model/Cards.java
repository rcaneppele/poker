package br.com.rcaneppele.poker.domain.model;

import java.util.Collections;
import java.util.Set;

public final class Cards {
	
	private final Set<Card> cards;

	public Cards(Set<Card> cards) {
		this.cards = cards;
	}
	
	@Override
	public String toString() {
		return cards.toString();
	}
	
	public Set<Card> getCards() {
		return Collections.unmodifiableSet(cards);
	}

}
