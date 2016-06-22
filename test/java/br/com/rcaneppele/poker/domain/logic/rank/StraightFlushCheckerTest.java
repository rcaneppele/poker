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

public class StraightFlushCheckerTest {
	
	private RankChecker checker;
	
	@Before
	public void before() {
		this.checker = new StraightFlushChecker();
	}
	
	@Test
	public void handShouldBeRankedAsStraightFlush() {
		for (CardSuit suit : CardSuit.values()) {
			Card ten = new Card(suit, CardValue.TEN);
			Card nine = new Card(suit, CardValue.NINE);
			Card eight = new Card(suit, CardValue.EIGHT);
			Card seven = new Card(suit, CardValue.SEVEN);
			Card six = new Card(suit, CardValue.SIX);
			
			Set<Card> set = new HashSet<>(Arrays.asList(ten, nine, eight, seven, six));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertTrue(matches);
		}
	}
	
	@Test
	public void handShouldNotBeRankedAsStraightFlushWhenCardsAreNotAllOfTheSameSuit() {
		for (CardSuit suit : CardSuit.values()) {
			//The different Suit:
			CardSuit different = Arrays.asList(CardSuit.values()).stream().filter(s -> !s.equals(suit)).findAny().get();
			Card ten = new Card(different, CardValue.TEN);

			Card nine = new Card(suit, CardValue.NINE);
			Card eight = new Card(suit, CardValue.EIGHT);
			Card seven = new Card(suit, CardValue.SEVEN);
			Card six = new Card(suit, CardValue.SIX);
			
			Set<Card> set = new HashSet<>(Arrays.asList(ten, nine, eight, seven, six));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertFalse(matches);
		}
	}
	
	@Test
	public void handShouldNotBeRankedAsStraightFlushWhenCardsAreAllOfTheSameSuitButNotInAStraight() {
		for (CardSuit suit : CardSuit.values()) {
			//The out of Straight card:
			Card three = new Card(suit, CardValue.THREE);

			Card nine = new Card(suit, CardValue.NINE);
			Card eight = new Card(suit, CardValue.EIGHT);
			Card seven = new Card(suit, CardValue.SEVEN);
			Card six = new Card(suit, CardValue.SIX);
			
			Set<Card> set = new HashSet<>(Arrays.asList(three, nine, eight, seven, six));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertFalse(matches);
		}
	}
	
}
