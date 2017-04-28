import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	
	private ArrayList<Card> deck;
	
	public Deck()
	{
		
		deck = new ArrayList<Card>();
		for(int i = 0; i < 13; i++)
		{			
				deck.add(new SpadeCard(i));
			
				deck.add(new ClubCard(i));
	
				deck.add(new DiamondCard(i));
		
				deck.add(new HeartCard(i));
			
		}
	}
	
	public Card getCard(int index)
	{
		return deck.get(index);
	}

	public void shuffle()
	{
		Random rng = new Random();
		for( int i = 0; i < deck.size(); i++)
		{
			deck.get(i).setRNG(rng.nextLong());
		}
		
		Collections.sort(deck,Card.getComparatorRNG());
		
	}
}
