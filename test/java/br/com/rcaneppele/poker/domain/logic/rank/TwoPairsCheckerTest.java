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

public class TwoPairsCheckerTest {
	
	private RankChecker checker;
	
	@Before
	public void before() {
		this.checker = new TwoPairsChecker();
	}
	
	@Test
	public void handShouldBeRankedAsTwoPairs() {
		for (CardValue value : CardValue.values()) {
			//The different Values:
			CardValue firstDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value)).findAny().get();
			CardValue secondDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value) && !v.equals(firstDifferent)).findAny().get();
			Card firstOfFirstPair = new Card(CardSuit.HEARTS, firstDifferent);
			Card secondOfFirstPair = new Card(CardSuit.CLUBS, firstDifferent);
			
			Card firstOfSecondPair = new Card(CardSuit.HEARTS, secondDifferent);
			Card secondOfSecondPair = new Card(CardSuit.CLUBS, secondDifferent);
			
			Card other = new Card(CardSuit.DIAMONDS, value);
			
			Set<Card> set = new HashSet<>(Arrays.asList(firstOfFirstPair, secondOfFirstPair, firstOfSecondPair, secondOfSecondPair, other));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertTrue(matches);
		}
	}
	
	@Test
	public void handShouldNotBeRankedAsTwoPairs() {
		for (CardValue value : CardValue.values()) {
			//The different Values:
			CardValue firstDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value)).findAny().get();
			CardValue secondDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value) && !v.equals(firstDifferent)).findAny().get();
			CardValue thirdDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value) && !v.equals(firstDifferent) && !v.equals(secondDifferent)).findAny().get();
			Card firstOfPair = new Card(CardSuit.HEARTS, firstDifferent);
			Card secondOfPair = new Card(CardSuit.CLUBS, firstDifferent);
			
			Card firstOther = new Card(CardSuit.HEARTS, secondDifferent);
			Card secondOther = new Card(CardSuit.DIAMONDS, thirdDifferent);
			Card thirdOther = new Card(CardSuit.DIAMONDS, value);
			
			Set<Card> set = new HashSet<>(Arrays.asList(firstOfPair, secondOfPair, firstOther, secondOther, thirdOther));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertFalse(matches);
		}
	}
	
}
