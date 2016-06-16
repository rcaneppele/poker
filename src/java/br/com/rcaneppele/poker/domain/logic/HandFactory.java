package br.com.rcaneppele.poker.domain.logic;

import br.com.rcaneppele.poker.domain.model.Cards;
import br.com.rcaneppele.poker.domain.model.Hand;
import br.com.rcaneppele.poker.domain.model.Rank;

public class HandFactory {
	
	public Hand createHand(Cards cards) {
		if (cards == null) {
			throw new IllegalArgumentException("Cards must not be null");
		}
		
		for (Rank rank : Rank.values()) {
			if (rank.matches(cards)) {
				return new Hand(cards, rank);
			}
		}
		
		throw new RuntimeException("Could not determine the hand of specified cards");
	}

}
