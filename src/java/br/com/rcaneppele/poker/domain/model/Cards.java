package br.com.rcaneppele.poker.domain.model;

import java.util.Collections;
import java.util.List;
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
	
	/*
	 * Example Cards Values: 10 | 9 | 8 | 7 | 6
	 * 10 - 9 = 1
	 * 9 - 8 = 1
	 * 8 - 7 = 1
	 * 7 - 6 = 1
	 * Sum of differences always must be 4
	 */
	public boolean isInAStraight() {
		List<Integer> sortedValues = cards.stream().map(Card::getValue).map(CardValue::getValue).sorted(Collections.reverseOrder()).collect(Collectors.toList());
		
		int sum = 0;
		int currentValue = sortedValues.get(0);
		for (int value : sortedValues) {
			sum += currentValue - value;
			currentValue = value;
		}
		return sum == 4;
		
		//TODO: find how to do the above algorithm with Java 8
		//return cards.stream().map(Card::getValue).map(CardValue::getValue).sorted(Collections.reverseOrder()).reduce(0, (a,b) -> a - b) == 4;
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
