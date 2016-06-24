package br.com.rcaneppele.poker.domain.logic.rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.rcaneppele.poker.domain.model.Card;
import br.com.rcaneppele.poker.domain.model.CardValue;
import br.com.rcaneppele.poker.domain.model.Cards;

public class TwoPairsChecker implements RankChecker {

	@Override
	public boolean matches(Cards cards) {
		Map<CardValue, List<Card>> groupedByValue = cards.getCards().stream().collect(Collectors.groupingBy(Card::getValue));
		List<CardValue> values = cards.getCards().stream().map(Card::getValue).distinct().collect(Collectors.toList());
		
		return groupedByValue.size() == 3 
				&& 
				(groupedByValue.get(values.get(0)).size() == 2 && groupedByValue.get(values.get(1)).size() == 2 && groupedByValue.get(values.get(2)).size() == 1)
				||
				(groupedByValue.get(values.get(0)).size() == 2 && groupedByValue.get(values.get(1)).size() == 1 && groupedByValue.get(values.get(2)).size() == 2)
				||
				(groupedByValue.get(values.get(0)).size() == 1 && groupedByValue.get(values.get(1)).size() == 2 && groupedByValue.get(values.get(2)).size() == 2);
	}

}
