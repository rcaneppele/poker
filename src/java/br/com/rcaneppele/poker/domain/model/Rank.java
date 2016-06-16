package br.com.rcaneppele.poker.domain.model;


public enum Rank {

	ROYAL_FLUSH("Royal Flush", 10),
	STRAIGHT_FLUSH("Straight Flush", 9),
	FOUR_OF_A_KIND("Four of a Kind", 8),
	FULL_HOUSE("Full House", 7),
	FLUSH("Flush", 6),
	STRAIGHT("Straight", 5),
	THREE_OF_A_KIND("Three of a Kind", 4),
	TWO_PAIRS("Tow Pairs", 3),
	ONE_PAIR("One Pair", 2),
	HIGH_CARD("High Card", 1);
	
	private final String name;
	private final int strength;

	private Rank(String name, int strength) {
		this.name = name;
		this.strength = strength;
	}
	
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
