package chapter9.item58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Card {

  private final Suit suit;
  private final Rank rank;

  enum Suit {CLUB, DIAMOND, HEART, SPADE}

  enum Rank {ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}


  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
  }

  @Override
  public String toString() {
    return "Card{" +
        "suit=" + suit +
        ", rank=" + rank +
        '}';
  }

  static Collection<Suit> suits = Arrays.asList(Suit.values());
  static Collection<Rank> ranks = Arrays.asList(Rank.values());

  public static void main(String[] args) {
    List<Card> deck = new ArrayList<>();
    for (Suit suit : suits) {
      for (Rank value : ranks) {
        deck.add(new Card(suit, value));
      }
    }

    //버그 i.next() 미리 호출 되어 NoSuchElementException 발생
    /*for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
      for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); ) {
        deck.add(new Card(i.next(), j.next()));
      }
    }*/

    System.out.println(deck);
  }
}
