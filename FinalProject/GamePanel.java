import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class GamePanel extends JLayeredPane
{
	
	private Deck currentDeck;
	private Player currentPlayer;
	
	//temporary
	private Player westPlayer;
	private Player eastPlayer;
	private Player northPlayer;
	
	private int WIDTH = 1600;
	private int HEIGHT = 900;
	
	private final Card a = new SpadeCard(2);
	private int dx =20;
	private int dy = 20;
	
	private ArrayList<Player> allPlayers = new ArrayList<Player>();
	
	public GamePanel()
	{
		super();
	
		setPreferredSize(new Dimension (WIDTH,HEIGHT));

		//set up the players
		for(int i = 0 ; i < 4; i ++)
			allPlayers.add(new Player("Player" + i+1));
			
		currentPlayer = allPlayers.get(0);
		westPlayer = allPlayers.get(1);
		northPlayer = allPlayers.get(2);
		eastPlayer = allPlayers.get(3);
				
	
		//set up the deck
		currentDeck = new Deck();
		for(int i = 0; i < 52; i++)
		{
			Card current = 	currentDeck.getCard(i);
			current.addMouseListener(new MousePressedListener(current));
		}
		
		//DEAL
		deal();
			
		showHand(currentPlayer);
		
		
		
	
	
		
		//testing animation
		int delay = 20;
		Timer time = new Timer(delay, null);
		time.addActionListener( new ActionListener() {	// create button's functionality
		public void actionPerformed (ActionEvent e)
		{
			dx +=2;
			dy +=2;
			repaint();
		}
	});
	
	time.start();
			
	
	
	}
			
	
	
	//for showing other players and combo being played
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 =  (Graphics2D)g;
		
		paintOtherPlayerCards(g2);
		a.drawCard(g2, dx, dy);
		//for(int i = 0; i < 52; i++)
		//{
			//currentDeck.getCard(i).drawCard(g2, i *30, i * 10);
	//	}
		
		
	}
	
	
	
	private void paintOtherPlayerCards(Graphics2D g2)
	{
		int westCard = westPlayer.getTotalCards();
		int eastCard = eastPlayer.getTotalCards();
		int northCard = northPlayer.getTotalCards();
		
		ArrayList<Card> westHand = westPlayer.getHand();
		ArrayList<Card> eastHand = eastPlayer.getHand();
		ArrayList<Card> northHand = northPlayer.getHand();
		
		for(int i =0; i < westCard; i++)
		{
			westHand.get(i).drawCard(g2, 20, HEIGHT/10 + i*40);
		}
		
		for(int i = 0; i < eastCard; i++)
		{
			eastHand.get(i).drawCard(g2, (WIDTH- Card.IMAGE_WIDTH) - 20, HEIGHT/10 + i *40);
		}
		
		for(int i =0; i < northCard; i ++)
		{
			northHand.get(i).drawCard(g2,WIDTH/8 + i *75 , 20);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public void deal()
	{
		currentDeck.shuffle();
		for(int i = 0; i < 52; i++)
		{
			
				allPlayers.get(i%4).addCard(currentDeck.getCard(i));
			
		}
		
		for(int i = 0; i < 4;i++)
			allPlayers.get(i).sortCardValue();
	}
	
	
	//TODO add card to bottom of playable area
	public void showHand(Player p)
	{
		removeAll();
		
		//spread the cards out as less cards in hand
		int totalCard = p.getTotalCards();
		int totalHandWidth = 975 ;
		int shiftWidth = (int)(totalHandWidth/totalCard);
		if(shiftWidth > Card.IMAGE_WIDTH + 3)
			shiftWidth = Card.IMAGE_WIDTH + 3;
		
		ArrayList<Card> playerHand = p.getHand();
		
		for(int i = 0; i < totalCard; i++)
		{
			if(playerHand.get(i).getSelected())
				playerHand.get(i).setBounds(WIDTH/8 + shiftWidth*i,HEIGHT - Card.IMAGE_HEIGHT - 20,Card.IMAGE_WIDTH,Card.IMAGE_HEIGHT);
			else
			  //currentDeck.getCard(i).setBounds(50*i, HEIGHT - Card.IMAGE_HEIGHT,Card.IMAGE_WIDTH,Card.IMAGE_HEIGHT);
			
				playerHand.get(i).setBounds(WIDTH/8 + shiftWidth*i, HEIGHT - Card.IMAGE_HEIGHT,Card.IMAGE_WIDTH,Card.IMAGE_HEIGHT);
			
			//System.out.println(WIDTH/8 +  shiftWidth* i);

				
				
			add(playerHand.get(i),new Integer(i));
		}
		
		
	}
	
	
	private class MousePressedListener extends MouseAdapter
	{
		private Card card;
		public MousePressedListener(Card c)
		{
			card = c;
			
		}
		public void mousePressed(MouseEvent event)
		{
			card.setSelected(!card.getSelected());
			showHand(currentPlayer);
			System.out.println("yes " + card.getWeight());
			
		}
	}
	
	
}
