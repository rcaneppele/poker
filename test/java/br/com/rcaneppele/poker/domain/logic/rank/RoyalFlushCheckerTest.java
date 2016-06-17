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

public class RoyalFlushCheckerTest {
	
	private RankChecker checker;
	
	@Before
	public void before() {
		this.checker = new RoyalFlushChecker();
	}
	
	@Test
	public void handShouldBeRankedAsRoyalFlush() {
		for (CardSuit suit : CardSuit.values()) {
			Card ace = new Card(suit, CardValue.ACE);
			Card king = new Card(suit, CardValue.KING);
			Card queen = new Card(suit, CardValue.QUEEN);
			Card jack = new Card(suit, CardValue.JACK);
			Card ten = new Card(suit, CardValue.TEN);
			
			Set<Card> set = new HashSet<>(Arrays.asList(ace, king, queen, jack, ten));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertTrue(matches);
		}
	}

}
