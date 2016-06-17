package br.com.rcaneppele.poker.domain.model;

import br.com.rcaneppele.poker.domain.logic.rank.RankChecker;
import br.com.rcaneppele.poker.domain.logic.rank.RoyalFlushChecker;

public enum Rank {

	ROYAL_FLUSH("Royal Flush", 10) {
		@Override
		public RankChecker getChecker() {
			return new RoyalFlushChecker();
		}
	},
	STRAIGHT_FLUSH("Straight Flush", 9) {
		@Override
		public RankChecker getChecker() {
			return null;
		}
	},
	FOUR_OF_A_KIND("Four of a Kind", 8) {
		@Override
		public RankChecker getChecker() {
			return null;
		}
	},
	FULL_HOUSE("Full House", 7) {
		@Override
		public RankChecker getChecker() {
			return null;
		}
	},
	FLUSH("Flush", 6) {
		@Override
		public RankChecker getChecker() {
			return null;
		}
	},
	STRAIGHT("Straight", 5) {
		@Override
		public RankChecker getChecker() {
			return null;
		}
	},
	THREE_OF_A_KIND("Three of a Kind", 4) {
		@Override
		public RankChecker getChecker() {
			return null;
		}
	},
	TWO_PAIRS("Tow Pairs", 3) {
		@Override
		public RankChecker getChecker() {
			return null;
		}
	},
	ONE_PAIR("One Pair", 2) {
		@Override
		public RankChecker getChecker() {
			return null;
		}
	},
	HIGH_CARD("High Card", 1) {
		@Override
		public RankChecker getChecker() {
			return null;
		}
	};
	
	private final String name;
	private final int strength;

	private Rank(String name, int strength) {
		this.name = name;
		this.strength = strength;
	}
	
	public abstract RankChecker getChecker();
	
	@Override
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}
	public int getStrength() {
		return strength;
	}
	
}
