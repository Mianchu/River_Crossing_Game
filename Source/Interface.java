import javax.swing.*;
import java.awt.event.*;

/**
 * This class is a media between the player and the inner logic of this game.
 * The first task of this class is to interpret the 2D array from the logic level 
 * into the UI. The second task is to response operations from the player.
 * 
 * @author Mianchu Wang
 */
public class Interface implements KeyListener,ActionListener{
	
	private Logic log;
	private JFrame frame=new JFrame();
	private JPanel panel=new JPanel();
	private JButton[][] button=new JButton[Logic.HEIGHT][Logic.WIDTH];
	
	//The JLabel plankCarry is to record if the player is carrying a
	//plank, and the length of the carried plank.
	private JLabel plankCarry=new JLabel();
	//The JLabel timeCounter is to record how much time the player has used
	//in a level of the game.
	private JLabel timeCounter=new JLabel();
	//The JLabel numOfSteps is to record the number of the steps the player
	//moved.
	private JLabel numOfSteps=new JLabel();
	//A parameter which will be used in the JLabel timeCounter.
	private double timeCost=0;
	//To record the score of the player. The score is less than 100, and more
	//than 0.
	private int score=0;
	
	
	/**
	 * Constrcutor: to build the basic interface of a game.
	 * @param level the level of the game.
	 */
	public Interface(int level){
		log=new Logic(level);
		panel.setLayout(null);
		
		for(int i=0;i<Logic.HEIGHT;i++)
			for(int j=0;j<Logic.WIDTH;j++){
				ImageIcon img=new ImageIcon(iconSelect(log.map[i][j]));
				button[i][j]=new JButton(img);
				button[i][j].addActionListener(this);
				button[i][j].setBounds(j*32, i*32,32, 32);
				panel.add(button[i][j]);
			}
		
		//Initialize the JLabel timeCounter.
		timeCounter.setBounds(0,405,294,53);
		addTime(timeCost);
		panel.add(timeCounter);
		
		//Initialize the JLabel numOfSteps.
		numOfSteps.setBounds(0, 425, 294, 55);
		addStep();
		panel.add(numOfSteps);
		
		
		
		//Initialize the JLabel plankCarry.
		plankCarry.setBounds(0,445, 294, 55);
		plankCarry.setText("  You haven't picked up any plank yet.");
		panel.add(plankCarry);
		
		//Set the parameters of the frame.
		frame.setContentPane(panel);
		frame.setTitle("River Crossing Game");
		frame.setLocation(500, 200);
		frame.setSize(294,525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.addKeyListener(this);
	}
	
	
	/**
	 * Response operations from the mouse.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			for(int i=0;i<Logic.HEIGHT;i++){
			for(int j=0;j<Logic.WIDTH;j++){
				if(e.getSource()==button[i][j]){
					if(log.getLengthOfPlank()==0) log.pickUp(j,i);
					else log.plankDown(j,i);
					
					//It's for the plankCarry JTextField
					if(log.getLengthOfPlank()!=0)
						plankCarry.setText("  The length of the carried plank "
								+ "is "+log.getLengthOfPlank());
					if(log.getLengthOfPlank()==0)
						plankCarry.setText("  You haven't picked up a plank yet.");
					
					showIcon();
					frame.requestFocus();
					return;
				}
			}
			}
	}


	/**
	 * Set the text on the JLabel numOfSteps.
	 */
	public void addStep(){
			numOfSteps.setText("  Total Steps: "+log.getStep());
	}
	

	/**
	 * Add time to the timeCost, and show it on the JLabel timeCounter
	 * to record the time the player has cost.
	 * @param interval the time added to the timeCost.
	 */
	public void addTime(double interval){
		timeCost+=interval;
		String time = String.format("%.1f", timeCost);
		timeCounter.setText("  Total Time: "+time);
	}


	/**
	 * Compute the score of the level.
	 */
	public void computeScore(){
		score=(int) ((1000-timeCost/2-log.getStep()/2)/10);
		if(score<0) score=0;
	}


	/**
	 * Convert an entire of a 2D array into a name of the 
	 * corresponding icon
	 * @param str the value of the entire of the 2D array
	 * @return the name of the corresponding icon
	 */
	public String iconSelect(String str){
		String res="img/"+str+".jpg";
		return res;
	}


	/**
	 * Judge if the play wins via invoking the logic object.
	 * @return if the play wins.
	 */
	public boolean isWin(){
		return log.isWin();
	}


	/**
	 * Obtain the score of the level.
	 * @return the score of the level.
	 */
	public int getScore(){
		return score;
	}


	/**
	 * Convert the 2D array from the inner logic level into the UI
	 */
	public void showIcon(){
		for(int i=0;i<Logic.HEIGHT;i++)
			for(int j=0;j<Logic.WIDTH;j++){
				ImageIcon img=new ImageIcon(iconSelect(log.map[i][j]));
				button[i][j].setIcon(img);
			}
	}
	
	
	/**
	 * Response operations from the keyboard, and judge if the player wins.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			log.upMove();
			showIcon();
			addStep();
			break;
		case KeyEvent.VK_DOWN:
			log.downMove();
			showIcon();
			addStep();
			break;
		case KeyEvent.VK_LEFT:
			log.leftMove();
			showIcon();
			addStep();
			break;
		case KeyEvent.VK_RIGHT:
			log.rightMove();
			showIcon();
			addStep();
			break;
		}
		
		if(isWin()){
			String time = String.format("%.1f", timeCost);
			computeScore();
			JOptionPane.showMessageDialog(panel, "You win this level\nwith "
						+ time+" seconds and "+log.getStep()+" steps!");
			frame.dispose();
		}
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
