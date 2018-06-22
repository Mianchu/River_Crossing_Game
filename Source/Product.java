import java.awt.HeadlessException;
import java.io.*;
import javax.swing.JOptionPane;

/**
 * This class is to show the final game product. 
 * Based on the Logic class and the Interface class, this class adds
 * a timeCounter and a high score recorder on the semi-finished game.
 * 
 * @author Mianchu Wang
 */
public class Product {

	/**
	 * start the game.
	 * @throws IOException From the recordScore method.
	 * @throws HeadlessException
	 * @throws InterruptedException
	 * @throws IllegalArgumentException
	 */
	public void start()
			throws IllegalArgumentException,InterruptedException, 
			HeadlessException, IOException{
		try{
			int score=0;	//Record the score of the player
			Interface level[]=new Interface[Logic.NUMBER_OF_LEVELS];
		
			
			//This for is to control the level of the game.
			for(int lev=0;lev<Logic.NUMBER_OF_LEVELS;lev++){
				level[lev]=new Interface(lev);
				
				//Check if the game is over every 0.1 second.
				//Add 0.1 second to timeCost at a time.
				while(true){
					if(level[lev].isWin()) break;
					Thread.sleep(100);
					level[lev].addTime(0.1);
				}
				score+=level[lev].getScore()/Logic.NUMBER_OF_LEVELS;
			}
			
			
			//All Logic.NUMBER_OF_LEVELS levels have been passed.
			if(recordScore(score))
				JOptionPane.showMessageDialog(null, "Congratulations! "
					+ "You passed all the levels, and set a new record "
					+ "with score "+score+"!");
			else{
				JOptionPane.showMessageDialog(null, "Congratulations! "
						+ "You passed all the levels "
						+ "with score "+score+"!");
			}
		}	
		
		catch(IllegalArgumentException e){}
		catch(InterruptedException e){}
		catch(IOException e){}
		catch(HeadlessException e){}
	}
	
	
	/**
	* Record the highest score into the file Highest_Score
	* @return If this game produces a new record.
	* @throws IOException From the classes BufferedReader and BufferedWriter.
	*/
	private boolean recordScore(int score)
		throws IOException{
		try{
				int highestScore;
				File file = new File("record/Highest_Score");
				BufferedReader br = new BufferedReader(new FileReader(file));
	        
				String str = br.readLine();
				highestScore=Integer.parseInt(str);
				if(score>highestScore){
					 BufferedWriter bw = new BufferedWriter(new FileWriter(file)); 
					 bw.write(String.valueOf(score));
					 bw.close();
					 br.close();
					 return true;
				}
				br.close();
				return false;
		}
		catch(IOException e){}
		return false;
	}
}
