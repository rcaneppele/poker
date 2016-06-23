package br.com.rcaneppele.poker.domain.logic.rank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.rcaneppele.poker.domain.model.Card;
import br.com.rcaneppele.poker.domain.model.CardSuit;
import br.com.rcaneppele.poker.domain.model.CardValue;
import br.com.rcaneppele.poker.domain.model.Cards;

public class FullHouseCheckerTest {
	
	private RankChecker checker;
	
	@Before
	public void before() {
		this.checker = new FullHouseChecker();
	}
	
	@Test
	public void handShouldBeRankedAsFullHouse() {
		for (CardValue value : CardValue.values()) {
			//The different Value:
			CardValue different = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value)).findAny().get();
			Card firstDifferent = new Card(CardSuit.HEARTS, different);
			Card secondDifferent = new Card(CardSuit.CLUBS, different);
			
			Card first = new Card(CardSuit.CLUBS, value);
			Card second = new Card(CardSuit.HEARTS, value);
			Card third = new Card(CardSuit.SPADES, value);
			
			Set<Card> set = new HashSet<>(Arrays.asList(first, second, third, firstDifferent, secondDifferent));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertTrue(matches);
		}
	}
	
}
