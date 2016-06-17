package br.com.rcaneppele.poker.domain.model;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public final class Cards {
	
	private final Set<Card> cards;

	public Cards(Set<Card> cards) {
		this.cards = cards;
	}
	
	public boolean isAllOfTheSameSuit() {
		return cards.stream().collect(Collectors.groupingBy(Card::getSuit)).size() == 1;
	}
	
	public boolean contains(CardValue value) {
		return cards.stream().filter(c -> c.getValue() == value).count() != 0;
	}
	
	@Override
	public String toString() {
		return cards.toString();
	}
	
	public Set<Card> getCards() {
		return Collections.unmodifiableSet(cards);
	}

}
