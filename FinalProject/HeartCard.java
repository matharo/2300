import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HeartCard extends Card{
	
	
	private String picPath;
	
	/**
	 * set the value of the card to the appropriate card picture
	 * If the value is out of range, the card picture will be a joker
	
	 */
	
	public HeartCard(int value)
	{
		super(value);
		weight = 39;
		
		switch(value)
		{
		case 0:
			picPath = "pictures/cards_PNG/3_of_hearts.png";
			break;		
		case 1:
			picPath = "pictures/cards_PNG/4_of_hearts.png";
			break;
		case 2:
			picPath = "pictures/cards_PNG/5_of_hearts.png";
			break;
		case 3:
			picPath = "pictures/cards_PNG/6_of_hearts.png";
			break;
		case 4:
			picPath = "pictures/cards_PNG/7_of_hearts.png";
			break;
		case 5:
			picPath = "pictures/cards_PNG/8_of_hearts.png";
			break;
		case 6:
			picPath = "pictures/cards_PNG/9_of_hearts.png";
			break;
		case 7:
			picPath = "pictures/cards_PNG/10_of_hearts.png";
			break;
		
			
		case 8:
			picPath = "pictures/cards_PNG/jack_of_hearts.png";
			break;
		case 9:
			picPath = "pictures/cards_PNG/queen_of_hearts.png";
			break;
		case 10:
			picPath = "pictures/cards_PNG/king_of_hearts.png";
			break;
		case 11:
			picPath = "pictures/cards_PNG/ace_of_hearts.png";
			break;
			
		case 12:
			picPath = "pictures/cards_PNG/2_of_hearts.png";
			break;
		default:
			picPath = "pictures/cards_PNG/red_joker.png";
		
			
		}
		try {
			img = ImageIO.read(new File(picPath));
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}

}
