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

public class HighCardCheckerTest {
	
	private RankChecker checker;
	
	@Before
	public void before() {
		this.checker = new HighCardChecker();
	}
	
	@Test
	public void handShouldBeRankedAsHighCard() {
		for (CardValue value : CardValue.values()) {
			//The different Values:
			CardValue firstDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value)).findAny().get();
			CardValue secondDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value) && !v.equals(firstDifferent)).findAny().get();
			CardValue thirdDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value) && !v.equals(firstDifferent) && !v.equals(secondDifferent)).findAny().get();
			CardValue fourthDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value) && !v.equals(firstDifferent) && !v.equals(secondDifferent) && !v.equals(thirdDifferent) && Math.abs((v.getValue() - thirdDifferent.getValue())) > 2).findAny().get();
			
			Card first = new Card(CardSuit.HEARTS, firstDifferent);
			Card second = new Card(CardSuit.CLUBS, secondDifferent);
			Card third = new Card(CardSuit.HEARTS, thirdDifferent);
			Card fourth = new Card(CardSuit.DIAMONDS, fourthDifferent);
			Card fifth = new Card(CardSuit.DIAMONDS, value);
			
			Set<Card> set = new HashSet<>(Arrays.asList(first, second, third, fourth, fifth));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertTrue(matches);
		}
	}
	
	@Test
	public void handShouldNotBeRankedAsHighCard() {
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
