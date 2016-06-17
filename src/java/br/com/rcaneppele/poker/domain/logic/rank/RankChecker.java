package br.com.rcaneppele.poker.domain.logic.rank;

import br.com.rcaneppele.poker.domain.model.Cards;

public interface RankChecker {
	
	public boolean matches(Cards cards);

}
