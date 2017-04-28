
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;

import javax.swing.JComponent;

/**
 * Abstract class of Card to support basic getter operations
 * Extend JComponent to support mousePressed without coordinate
 * 
 *
 */
public abstract class Card extends JComponent{
	
	
	/**
	 * value must be 0-12 to be valid
	 * Value: 	Card Order:
	 * 0		3
	 * 1		4
	 * 2		5
	 * 3		6
	 * 4		7
	 * 5		8
	 * 6		9
	 * 7		10
	 * 8		jack
	 * 9		queen
	 * 10		king
	 * 11		ace
	 * 12		2
	 * 
	 * 
	 * weight is used for comparing card of different suits
	 * Spade's weight  = 0;
	 * Club's weight = 13;
	 * Diamond's weight = 26;
	 * Heart's weight = 39;
	 * 
	 * RNG is assigned by Random class and then sort all cards
	 */
	protected int value; 
	protected int weight; 
	protected long RNG;
	
	protected Image img;
	
	
	private boolean selected = false;
	public static final int IMAGE_WIDTH = 138;
	public static final int IMAGE_HEIGHT = 200;
	
	
	
	public Card(int value)
	{
		this.value = value;
	
	
		
		setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
		setAlignmentX(Component.BOTTOM_ALIGNMENT);
		
	}

	
	public int getValue()
	{
		return value;
		
	}
	
	public int getWeight()
	{
		return weight + value;
	}
	
	
	/**
	 * draw the card image at x and y position
	 
	 */
	//public void drawCard(Graphics2D g2, int x, int y)
	public void paintComponent(Graphics g)//, int x, int y)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img,0,0,null);
		
		
		
	}
	
	public void drawCard(Graphics2D g2, int x , int y)
	{
		g2.drawImage(img, x,y, null);
	}
	
	
	/**
	 * for use with MousePressedListener to see if this card is selected
	 * @return
	 */
	
	
	public boolean getSelected()
	{
		return selected;
	}
	
	public void setSelected(boolean s)
	{
		selected = s;
	}
	
	
	/**
	 * for use with Deck to randomly shuffle all the cards
	 * @return
	 */
	public double getRNG()
	{
		return RNG;
	}
	
	public void setRNG(long x)
	{
		RNG = x;
	}
	
	
	/**
	 * returning the Comparator class for sorting by value, weight, and rng
	 * 
	 */
	
	
	public static Comparator<Card> getComparatorValue()
	 {
		return new Comparator<Card>(){
		 public int compare(Card c1, Card c2)
		 {
			 if(c1.getValue() > c2.getValue()) return 1;
			 else if(c1.getValue() < c2.getValue()) return -1;
			 else return 0;
		 }
		};
	 }
	 
	 
	 public static Comparator<Card> getComparatorWeight()
	 {
		 return new Comparator<Card>(){
		 public int compare(Card c1, Card c2)
		 {
			 if(c1.getWeight() > c2.getWeight()) return 1;
			 else if(c1.getWeight() < c2.getWeight()) return -1;
			 else return 0;
		 }
		 };
	 }
	 
	 
	 public static Comparator<Card> getComparatorRNG()
	 {
		 return new Comparator<Card>(){
			 
		 public int compare(Card c1, Card c2)
		 {
			 if(c1.getRNG() > c2.getRNG()) return 1;
			 else if(c1.getRNG() < c2.getRNG()) return -1;
			 else return 0;
		 }
	    };
	 }
	 
	 /**
	  * compare card by suit(weight) if they have same value
	  */
	 public static Comparator<Card> getComparatorSuit()
	 {
			return new Comparator<Card>(){
			 public int compare(Card c1, Card c2)
			 {
				 int ret = 0;
				 if(c1.getValue() > c2.getValue()) 
					 ret = 1;
				 else if(c1.getValue() < c2.getValue()) 
					 ret =-1;
				 
				 else if(c1.getValue() == c2.getValue())
				 {
					 Comparator<Card> sortByWeight = getComparatorWeight();
					 ret = sortByWeight.compare(c1,c2);
					 
				 }
				 return ret;
			 }
			};
		 }
	
	
	 
	
	
	
}
