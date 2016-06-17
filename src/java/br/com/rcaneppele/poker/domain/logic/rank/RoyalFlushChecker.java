package br.com.rcaneppele.poker.domain.logic.rank;

import br.com.rcaneppele.poker.domain.model.CardValue;
import br.com.rcaneppele.poker.domain.model.Cards;

public class RoyalFlushChecker implements RankChecker {

	@Override
	public boolean matches(Cards cards) {
		return cards.isAllOfTheSameSuit() &&
				cards.contains(CardValue.ACE) &&
				cards.contains(CardValue.KING) &&
				cards.contains(CardValue.QUEEN) &&
				cards.contains(CardValue.JACK) &&
				cards.contains(CardValue.TEN);
	}

}
