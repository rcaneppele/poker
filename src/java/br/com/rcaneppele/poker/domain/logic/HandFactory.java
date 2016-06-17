package br.com.rcaneppele.poker.domain.logic;

import java.util.Arrays;
import java.util.List;

import br.com.rcaneppele.poker.domain.model.Cards;
import br.com.rcaneppele.poker.domain.model.Hand;
import br.com.rcaneppele.poker.domain.model.Rank;

public class HandFactory {
	
	public Hand createHand(Cards cards) {
		if (cards == null) {
			throw new IllegalArgumentException("Cards must not be null");
		}
		
		List<Rank> allRanks = Arrays.asList(Rank.values());
		Rank matched = allRanks.stream().filter(r -> r.getChecker().matches(cards)).findFirst().get();
		return new Hand(cards, matched);
	}

}
