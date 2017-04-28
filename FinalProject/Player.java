import java.util.ArrayList;
import java.util.Collections;

public class Player {

	private String name;
	
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	
	public Player()
	{
		name = "Player01";
	}
	
	
	public Player(String name)
	{
		this.name = name;
	}
	
	
	
	public ArrayList<Card>getHand()
	{
		return hand;
	}
	
	public void addCard(Card c)
	{
		hand.add(c);
	}
	
	
	//TODO remove specific card by weight, each card have a unique weight
	public void removeCard(int weight)
	{
		for( int i = 0; i < hand.size(); i ++)
		{
			if( hand.get(i).getWeight() == weight)
				hand.remove(i);
		}
		
	}
	
	//return number of cards the player is holding currently
	public int getTotalCards()
	{
		return hand.size();
	}
	
	
	public void sortCardValue()
	{
		Collections.sort(hand, Card.getComparatorSuit());
	}
	
}
