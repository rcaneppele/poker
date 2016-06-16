package br.com.rcaneppele.poker.domain.logic;

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
import br.com.rcaneppele.poker.domain.model.Hand;
import br.com.rcaneppele.poker.domain.model.Rank;

public class HandFactoryTest {

	private HandFactory factory;
	
	@Before
	public void before() {
		this.factory = new HandFactory();
	}
	
	@Test
	public void handShouldBeRankedAsRoyalFlush() {
		Card ace = new Card(CardSuit.DIAMONDS, CardValue.ACE);
		Card king = new Card(CardSuit.DIAMONDS, CardValue.KING);
		Card queen = new Card(CardSuit.DIAMONDS, CardValue.QUEEN);
		Card jack = new Card(CardSuit.DIAMONDS, CardValue.JACK);
		Card ten = new Card(CardSuit.DIAMONDS, CardValue.TEN);
		
		Set<Card> set = new HashSet<>(Arrays.asList(ace, king, queen, jack, ten));
		Cards cards = new Cards(set);

		Hand royalFlush = factory.createHand(cards);
		
		Assert.assertEquals(Rank.ROYAL_FLUSH, royalFlush.getRank());
	}
	
}
