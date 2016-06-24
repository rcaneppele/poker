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

public class ThreeOfAKindCheckerTest {
	
	private RankChecker checker;
	
	@Before
	public void before() {
		this.checker = new ThreeOfAKindChecker();
	}
	
	@Test
	public void handShouldBeRankedAsThreeOfAKind() {
		for (CardValue value : CardValue.values()) {
			//The differents Values:
			CardValue firstDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value)).findAny().get();
			CardValue secondDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value) && !v.equals(firstDifferent)).findAny().get();
			Card other = new Card(CardSuit.HEARTS, firstDifferent);
			Card secondOther = new Card(CardSuit.CLUBS, secondDifferent);
			
			Card first = new Card(CardSuit.HEARTS, value);
			Card second = new Card(CardSuit.SPADES, value);
			Card third = new Card(CardSuit.DIAMONDS, value);
			
			Set<Card> set = new HashSet<>(Arrays.asList(first, second, third, other, secondOther));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertTrue(matches);
		}
	}
	
	@Test
	public void handShouldNotBeRankedAsThreeOfAKind() {
		for (CardValue value : CardValue.values()) {
			//The differents Values:
			CardValue firstDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value)).findAny().get();
			CardValue secondDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value) && !v.equals(firstDifferent)).findAny().get();
			CardValue thirdDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value) && !v.equals(firstDifferent) && !v.equals(secondDifferent)).findAny().get();
			Card other = new Card(CardSuit.HEARTS, firstDifferent);
			Card secondOther = new Card(CardSuit.CLUBS, secondDifferent);
			Card thirdOther = new Card(CardSuit.SPADES, thirdDifferent);
			
			Card first = new Card(CardSuit.HEARTS, value);
			Card second = new Card(CardSuit.SPADES, value);
			
			Set<Card> set = new HashSet<>(Arrays.asList(first, second, other, secondOther, thirdOther));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertFalse(matches);
		}
	}
	
}
