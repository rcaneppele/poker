package br.com.rcaneppele.poker.domain.logic.rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.rcaneppele.poker.domain.model.Card;
import br.com.rcaneppele.poker.domain.model.CardValue;
import br.com.rcaneppele.poker.domain.model.Cards;

public class HighCardChecker implements RankChecker {

	@Override
	public boolean matches(Cards cards) {
		Map<CardValue, List<Card>> groupedByValue = cards.getCards().stream().collect(Collectors.groupingBy(Card::getValue));
		
		return !cards.isAllOfTheSameSuit() && !cards.isInAStraight() && groupedByValue.size() == 5;
	}

}
