package br.com.rcaneppele.poker.domain.model;


public enum Rank {

	ROYAL_FLUSH("Royal Flush", 10) {
		@Override
		public boolean matches(Cards cards) {
			return false;
		}
	},
	STRAIGHT_FLUSH("Straight Flush", 9) {
		@Override
		public boolean matches(Cards cards) {
			return false;
		}
	},
	FOUR_OF_A_KIND("Four of a Kind", 8) {
		@Override
		public boolean matches(Cards cards) {
			return false;
		}
	},
	FULL_HOUSE("Full House", 7) {
		@Override
		public boolean matches(Cards cards) {
			return false;
		}
	},
	FLUSH("Flush", 6) {
		@Override
		public boolean matches(Cards cards) {
			return false;
		}
	},
	STRAIGHT("Straight", 5) {
		@Override
		public boolean matches(Cards cards) {
			return false;
		}
	},
	THREE_OF_A_KIND("Three of a Kind", 4) {
		@Override
		public boolean matches(Cards cards) {
			return false;
		}
	},
	TWO_PAIRS("Tow Pairs", 3) {
		@Override
		public boolean matches(Cards cards) {
			return false;
		}
	},
	ONE_PAIR("One Pair", 2) {
		@Override
		public boolean matches(Cards cards) {
			return false;
		}
	},
	HIGH_CARD("High Card", 1) {
		@Override
		public boolean matches(Cards cards) {
			return false;
		}
	};
	
	private final String name;
	private final int strength;

	private Rank(String name, int strength) {
		this.name = name;
		this.strength = strength;
	}
	
	public abstract boolean matches(Cards cards);
	
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
