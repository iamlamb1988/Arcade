package arcade.game.game_items;

import java.util.Collections;
import java.util.ArrayList;

public interface Shoe{
	public static ArrayList<Card> genStandardDeck(){
		ArrayList<Card> R = new ArrayList<Card>(52);

		char[] suits = new char[]{'C','D','H','S'};
		char[] faces = new char[]{'2','3','4','5','6','7','8','9','T','J','Q','K','A'};

		for(char x : suits){for(char y : faces){R.add(new Card(y,x));}}

		return R;
	}

	public static ArrayList<Card> genStandardDecks(byte num_of_decks){
		ArrayList<Card> R = new ArrayList<Card>(52*num_of_decks);
		num_of_decks--;

		char[] suits = new char[]{'C','D','H','S'};
		char[] faces = new char[]{'2','3','4','5','6','7','8','9','T','J','Q','K','A'};

		for(char x : suits){for(char y : faces){R.add(new Card(y,x));}}

		Card tmp;
		while(num_of_decks>0){
			num_of_decks--;
			for(byte i=0;i<52;++i){
				tmp=R.get(i);
				R.add(new Card(tmp.face,tmp.suit));
			}
		}

		return R;
	}

	public static void shuffleShoe(ArrayList<Card> unshuffledShoe){
		Collections.shuffle(unshuffledShoe);
	}

	public boolean isEmpty();
	public void shuffleShoe();
	public void reset();
	public Card dealTop();
	public void discard(Card dis);
}