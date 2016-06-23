package br.com.rcaneppele.poker.domain.logic.rank;

import br.com.rcaneppele.poker.domain.model.Cards;

public class StraightChecker implements RankChecker {

	@Override
	public boolean matches(Cards cards) {
		return cards.isInAStraight();
	}

}
