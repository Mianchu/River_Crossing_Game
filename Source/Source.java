/**
 * This class includes the main method which creates a object of Produc class.
 * 
 * Description of Game Controlling:
 * 1. Use direction keys to move the man. For instance, UP is for moving upward, DOWN
 * is for moving downward. This game supports the player to move the man continuely only 
 * if the player press a direction key without releasing.
 * 2. Use mouse to pick up or put down a plank. Especially, The player can click any 
 * part of a plank to pick it up. Also, the player can click any water unit between two 
 * stumps to put down a plank in a appropriate situation.
 * 
 * @author Mianchu Wang
 * 
 */

public class Source {

	public static void main(String[] args) {
		
		try{
			Product game=new Product();
			game.start();
		}
		
		catch(Exception e){}
	}
}
