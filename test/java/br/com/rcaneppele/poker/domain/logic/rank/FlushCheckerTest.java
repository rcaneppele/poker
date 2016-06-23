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

public class FlushCheckerTest {
	
	private RankChecker checker;
	
	@Before
	public void before() {
		this.checker = new FlushChecker();
	}
	
	@Test
	public void handShouldBeRankedAsFlush() {
		for (CardSuit suit : CardSuit.values()) {
			Card ten = new Card(suit, CardValue.TEN);
			Card nine = new Card(suit, CardValue.NINE);
			Card three = new Card(suit, CardValue.THREE);
			Card king = new Card(suit, CardValue.KING);
			Card four = new Card(suit, CardValue.FOUR);
			
			Set<Card> set = new HashSet<>(Arrays.asList(nine, three, king, four, ten));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertTrue(matches);
		}
	}
	
	@Test
	public void handShouldNotBeRankedAsFlush() {
		for (CardSuit suit : CardSuit.values()) {
			//The different Suit:
			CardSuit different = Arrays.asList(CardSuit.values()).stream().filter(s -> !s.equals(suit)).findAny().get();
			Card ten = new Card(different, CardValue.TEN);

			Card nine = new Card(suit, CardValue.NINE);
			Card three = new Card(suit, CardValue.THREE);
			Card king = new Card(suit, CardValue.KING);
			Card four = new Card(suit, CardValue.FOUR);
			
			Set<Card> set = new HashSet<>(Arrays.asList(nine, three, king, four, ten));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertFalse(matches);
		}
	}
	
}
