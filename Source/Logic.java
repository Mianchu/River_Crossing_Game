/**
 * This class aims to build a 2D array which is suitable to be converted into UI.
 * And this class provides some methods to manipulate the 2D array.
 * 
 * @author Mianchu Wang
 *
 */
public class Logic {
	
	public static final int WIDTH=9;			//The number of units of the width.
	public static final int HEIGHT=13;			//The number of units of the height.
	public static final int NUMBER_OF_LEVELS=4; //The number of the levels.
	
	private int xMan;							//The X coordinate of the man.
	private int yMan;							//The Y coordinate of the man.
	private int xTerminal;						//The X coordinate of the terminal stump.
	private int yTerminal;						//The Y coordinate of the terminal stump.
	private int lengthOfPlank;					//The length of the plank which has been carried.
												//The man carries nothing where lengthOfPlank==0.
	private int step=0;							//The number of the steps the man moved.
	
	String[][] map=new String[HEIGHT][WIDTH];	//Declare the 2D array.
	
	
	/**
	 * Constructor: choose the level of the game.
	 * @param level
	 */
	public Logic(int level){
		if(level==0) level0();
		if(level==1) level1();
		if(level==2) level2();
		if(level==3) level3();
	}
	
	
	/**
	 * Build the map of the 1st level.
	 */
	private void level0(){
		xMan=4;
		yMan=12;
		xTerminal=4;
		yTerminal=0;
		lengthOfPlank=0;
		
		for(int i=0;i<WIDTH;i++)
			map[0][i]="bank2";
		
		for(int i=1;i<HEIGHT-1;i++)
			for(int j=0;j<WIDTH;j++)
				map[i][j]="water1";
		
		for(int i=0;i<WIDTH;i++)
			map[12][i]="bank1";
		
		map[0][4]="stump3";
		map[2][2]="water3";
		map[4][4]="stump1";
		map[4][6]="stump1";
		map[6][6]="water2";
		map[6][1]="water3";
		map[8][4]="stump1";
		map[8][5]="plank1";
		map[8][6]="stump1";
		map[9][4]="plank2";
		map[10][2]="water2";
		map[10][4]="plank2";
		map[11][4]="plank2";
		map[12][4]="stump2_man";
	}
	
	
	
	
	/**
	 * Build the map of the 2nd level.
	 */
	private void level1(){
		xMan=4;
		yMan=12;
		xTerminal=4;
		yTerminal=0;
		lengthOfPlank=0;
		
		for(int i=0;i<WIDTH;i++)
			map[0][i]="bank2";
		
		for(int i=1;i<HEIGHT-1;i++)
			for(int j=0;j<WIDTH;j++)
				map[i][j]="water1";
		
		for(int i=0;i<WIDTH;i++)
			map[12][i]="bank1";
		
		map[0][4]="stump3";
		map[2][0]="stump1";
		map[4][2]="water4";
		map[4][4]="stump1";
		map[4][7]="water2";
		map[6][0]="stump1";
		map[6][2]="stump1";
		map[6][3]="plank1";
		map[6][4]="plank1";
		map[6][5]="plank1";
		map[6][6]="stump1";
		map[8][0]="stump1";
		map[10][2]="water3";
		map[8][4]="stump1";
		map[9][0]="plank2";
		map[9][4]="plank2";
		map[9][7]="water2";
		map[10][0]="stump1";
		map[10][4]="plank2";
		map[11][4]="plank2";
		map[12][4]="stump2_man";
	}
	
	
	/**
	 * Build the map of the 3rd level.
	 */
	private void level2(){
		xMan=2;
		yMan=12;
		xTerminal=6;
		yTerminal=0;
		lengthOfPlank=0;
		
		for(int i=0;i<WIDTH;i++)
			map[0][i]="bank2";
		
		for(int i=1;i<HEIGHT-1;i++)
			for(int j=0;j<WIDTH;j++)
				map[i][j]="water1";
		
		for(int i=0;i<WIDTH;i++)
			map[12][i]="bank1";
		
		map[0][6]="stump3";
		map[2][2]="stump1";
		map[2][8]="stump1";
		map[3][2]="plank2";
		map[4][2]="plank2";
		map[4][4]="stump1";
		map[4][6]="stump1";
		map[5][2]="plank2";
		map[6][0]="stump1";
		map[6][2]="plank2";
		map[6][6]="stump1";
		map[7][2]="plank2";
		map[8][2]="stump1";
		map[8][6]="stump1";
		map[8][8]="stump1";
		map[9][2]="plank2";
		map[9][8]="plank2";
		map[10][0]="stump1";
		map[10][2]="plank2";
		map[10][4]="stump1";
		map[10][8]="stump1";
		map[11][2]="plank2";
		map[12][2]="stump2_man";
	}
	
	
	/**
	 * Build the map of the 4th level.
	 */
	private void level3(){
		xMan=2;
		yMan=12;
		xTerminal=2;
		yTerminal=0;
		lengthOfPlank=0;
		
		for(int i=0;i<WIDTH;i++)
			map[0][i]="bank2";
		
		for(int i=1;i<HEIGHT-1;i++)
			for(int j=0;j<WIDTH;j++)
				map[i][j]="water1";
		
		for(int i=0;i<WIDTH;i++)
			map[12][i]="bank1";
		
		map[0][2]="stump3";
		map[2][0]="stump1";
		map[2][6]="stump1";
		map[2][8]="stump1";
		map[3][6]="plank2";
		map[4][2]="stump1";
		map[4][6]="plank2";
		map[4][8]="stump1";
		map[5][6]="plank2";
		map[6][0]="stump1";
		map[6][4]="stump1";
		map[6][6]="plank2";
		map[6][8]="stump1";
		map[7][0]="plank2";
		map[7][6]="plank2";
		map[7][8]="plank2";
		map[8][0]="plank2";
		map[8][6]="stump1";
		map[8][8]="plank2";
		map[9][0]="plank2";
		map[9][8]="plank2";
		map[10][0]="stump1";
		map[10][2]="stump1";
		map[10][4]="stump1";
		map[10][8]="stump1";
		map[11][2]="plank2";
		map[12][2]="stump2_man";	
	}
	
	
	/**
	 * Move the man upward.
	 * This is the fast version, the man only stops when he meets
	 * a stump. However, the icons which have a man on them are 
	 * useless. This method can be easily changed into the common
	 * version where the man only can move one square at a time.
	 */
	public void upMove(){
		while(isWalkable(xMan,yMan-1)){	
				printMan(xMan,yMan-1);
				wipeMan(xMan,yMan);
				step++;
				if(yMan>0) yMan--;
				if(isStump(xMan,yMan))
					break;
		}
	}
	

	/**
	 * Move the man downward.
	 * This is the fast version, the man only stops when he meets
	 * a stump. However, the icons which have a man on them are 
	 * useless. This method can be easily changed into the common
	 * version where the man only can move one square at a time.
	 */
	public void downMove(){
		while(isWalkable(xMan,yMan+1)){
				printMan(xMan,yMan+1);
				wipeMan(xMan,yMan);
				step++;
				if(yMan<HEIGHT) yMan++;
				if(isStump(xMan,yMan))
					break;
		}
	}
	
	
	/**
	 * Move the man rightward.
	 * This is the fast version, the man only stops when he meets
	 * a stump. However, the icons which have a man on them are 
	 * useless. This method can be easily changed into the common
	 * version where the man only can move one square at a time.
	 */
	public void rightMove(){
		while(isWalkable(xMan+1,yMan)){	
				printMan(xMan+1,yMan);
				wipeMan(xMan,yMan);
				step++;
				if(xMan<WIDTH) xMan++;
				if(isStump(xMan,yMan))
					break;
		}
	}
	
	
	/**
	 * Move the man leftward.
	 * This is the fast version, the man only stops when he meets
	 * a stump. However, the icons which have a man on them are 
	 * useless. This method can be easily changed into the common
	 * version where the man only can move one square at a time.
	 */
	public void leftMove(){
		while(isWalkable(xMan-1,yMan)){
				printMan(xMan-1,yMan);
				wipeMan(xMan,yMan);
				step++;
				if(xMan>0) xMan--;
				if(isStump(xMan,yMan))
					break;
		}
	}
	
	
	/**
	 * Pick up the plank which is selected.
	 * Find out the whole plank from only one unit which is clicked.
	 * @param x the X ordinate of the unit of the plank.
	 * @param y the Y ordinate of the unit of the plank.
	 */
	public void pickUp(int x,int y){
		if(isPlankNearMan(x,y)){
			pickUpUpward(x,y,lengthOfPlank);
			pickUpDownward(x,y+1,lengthOfPlank);
			if(lengthOfPlank==1){
				pickUpRightward(x+1,y,lengthOfPlank);
				pickUpLeftward(x-1,y,lengthOfPlank);
			}
		}
	}
	
	
	/**
	 * Travese the planks upward, and convert them into water.
	 * @param x The X coordinate of the origin of the travesal
	 * @param y The X coordinate of the origin of the travesal
	 * @param length lengthOfPlank in the data field, to record the length of the plank
	 * 				 which has been carried.
	 */
	private void pickUpUpward(int x,int y,int length){
		if(isPlank(x,y)&&isInRange(x,y)){
			length++;
			wipePlank(x,y);
			pickUpUpward(x,y-1,length);
		}
	}
	
	
	/**
	 * Travese the planks downward, and convert them into water.
	 * @param x The X coordinate of the origin of the travesal
	 * @param y The X coordinate of the origin of the travesal
	 * @param length lengthOfPlank in the data field, to record the length of the plank
	 * 				 which has been carried.
	 * @throws StackOverflowError
	 */
	private void pickUpDownward(int x,int y,int length){
		if(isPlank(x,y)&&isInRange(x,y)){
			length++;
			wipePlank(x,y);
			pickUpDownward(x,y+1,length);
		}
	}
	
	
	/**
	 * Travese the planks rightward, and convert them into water.
	 * @param x The X coordinate of the origin of the travesal
	 * @param y The X coordinate of the origin of the travesal
	 * @param length lengthOfPlank in the data field, to record the length of the plank
	 * 				 which has been carried.
	 * @throws StackOverflowError
	 */
	private void pickUpRightward(int x,int y,int length){
		if(isPlank(x,y)&&isInRange(x,y)){
			length++;
			wipePlank(x,y);
			pickUpRightward(x+1,y,length);
		}
	}
	
	
	/**
	 * Travese the planks leftward, and convert them into water.
	 * @param x The X coordinate of the origin of the travesal
	 * @param y The X coordinate of the origin of the travesal
	 * @param length lengthOfPlank in the data field, to record the length of the plank
	 * 				 which has been carried.
	 * @throws StackOverflowError
	 */
	private void pickUpLeftward(int x,int y,int length){
		if(isPlank(x,y)&&isInRange(x,y)){
			length++;
			wipePlank(x,y);
			pickUpLeftward(x-1,y,length);
		}
	}
	
	
	/**
	 * Put down the plank which has been carried.
	 * Find out two stumps to be the bridge piers.
	 * Check if the length of the plank is suitable.
	 * @param x The X coordinate of the unit which was clicked.
	 * @param y The Y coordinate of the unit which was clicked.
	 */
	public void plankDown(int x,int y){
		int leftStep=0;
		int rightStep=0;
		int upStep=0;
		int downStep=0;
		int hori=0;
		int vert=0;
		
		if(isWaterNearMan(x,y)){
		upStep=traverseWaterUpward(x,y);
		downStep=traverseWaterDownward(x,y);
		leftStep=traverseWaterLeftward(x,y);
		rightStep=traverseWaterRightward(x,y);
		
		vert=upStep+downStep;
		hori=rightStep+leftStep;
		
		if(vert==lengthOfPlank) 
			buildBridge(x,y,vert,"vertical");
		if(hori==lengthOfPlank&&vert!=lengthOfPlank)
			buildBridge(x,y,hori,"horizontal");
		}
	}
	
	
	/**
	 * Traverse the water units upon the chosen unit.
	 * @param x The X coordinate of the chosen unit.
	 * @param y The Y coordinate of the chosen unit.
	 * @return The number of the water units upon the chosen unit,
	 * which includes the unit itself.
	 */
	private int traverseWaterUpward(int x,int y){
		int step=0;
		while(isWater(x,y)&&isInRange(x,y)){
			step++;
			y--;
			//To avoid the situation that a bridge is built on a bank unit
			//or a plank unit. 'return -100' is to set the variable 'vert' 
			//in the method 'plankDown' less than 0 to ignore this exceptional
			//situation.
			if(isBank(x,y)||isPlank(x,y)) return -100;
		}
		return step;
	}
	
	
	/**
	 * Traverse the water units below the chosen unit.
	 * @param x The X coordinate of the chosen unit.
	 * @param y The Y coordinate of the chosen unit.
	 * @return The number of the water units below the chosen unit.
	 */
	private int traverseWaterDownward(int x,int y){
		int step=0;
		while(isWater(x,y)&&isInRange(x,y)){
			step++;
			y++;
			//To avoid the situation that a bridge is built on a bank unit
			//or a plank unit. 'return -100' is to set the variable 'vert' 
			//in the method 'plankDown' less than 0 to ignore this exceptional
			//situation.
			if(isBank(x,y)||isPlank(x,y)) return -100;
		}
		return step-1;
	}
	
	
	/**
	 * Traverse the water units on the right of the chosen unit.
	 * @param x The X coordinate of the chosen unit.
	 * @param y The Y coordinate of the chosen unit.
	 * @return The number of the water units on the right of the 
	 * chosen unit, which includes the unit itself.
	 */
	private int traverseWaterRightward(int x,int y){
		int step=0;
		while(isWater(x,y)&&isInRange(x,y)){
			step++;
			x++;
			//To avoid the situation that a bridge is built on a bank unit
			//or a plank unit. 'return -100' is to set the variable 'hori' 
			//in the method 'plankDown' less than 0 to ignore this exceptional
			//situation.
			if(isBank(x,y)||isPlank(x,y)) return -100;
		}
		return step;
	}
	
	
	/**
	 * Traverse the water units on the left of the chosen unit.
	 * @param x The X coordinate of the chosen unit.
	 * @param y The Y coordinate of the chosen unit.
	 * @return The number of the water units on the left of the chosen unit.
	 */
	private int traverseWaterLeftward(int x,int y){
		int step=0;
		while(isWater(x,y)&&isInRange(x,y)){
			step++;
			x--;
			//To avoid the situation that a bridge is built on a bank unit
			//or a plank unit. 'return -100' is to set the variable 'hori' 
			//in the method 'plankDown' less than 0 to ignore this exceptional
			//situation.
			if(isBank(x,y)||isPlank(x,y)) return -100;
		}
		return step-1;
	}
	
	
	/**
	 * Build a bridge on two stumps which are near the unit which was clicked.
	 * @param x The X coordinate of the unit which was clicked.
	 * @param y The Y coordinate of the unit which was clicked.
	 * @param distance The distance between two stumps.
	 * @param str Choose the direction of the bridge, horizantal or vertical.
	 */
	private void buildBridge(int x,int y,int distance,String str){
		if(str.equals("vertical")){
			
			if(yMan-y>0&&xMan==x){
				for(int i=1;i<=distance;i++){
				map[yMan-i][xMan]="plank2";
				}
				lengthOfPlank=0;
				return;
			}
			
			if(yMan-y<0){
				for(int i=1;i<=distance;i++){
					map[yMan+i][xMan]="plank2";
				}
				lengthOfPlank=0;
				return;
			}
		}
	
		if(str.equals("horizontal")){
			
			if(xMan-x>0&&yMan==y){
				for(int i=1;i<=distance;i++){
					map[yMan][xMan-i]="plank1";
				}
				lengthOfPlank=0;
				return;
			}
			
			if(xMan-x<0){
				for(int i=1;i<=distance;i++){
					map[yMan][xMan+i]="plank1";
				}
				lengthOfPlank=0;
				return;
			}	
		}
	}

	
	/**
	 * Judge if the unit is bank.
	 * @param x The X coordinate of the unit.
	 * @param y The Y coordinate of the unit.
	 * @return if the unit is bank.
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public boolean isBank(int x,int y)
		throws ArrayIndexOutOfBoundsException{
			try{
				return map[y][x].indexOf("bank")>-1;
			}
			catch(ArrayIndexOutOfBoundsException e){}
			return true;
	}


	/**
	 * Judge if a unit is in the game area.
	 * @param x The X coordinate of the unit.
	 * @param y The Y coordinate of the unit.
	 * @return if the unit is in the game area.
	 */
	private boolean isInRange(int x,int y){
		return y<HEIGHT && y>-1 &&
				x<WIDTH && x>-1;
	}


	/**
	 * Judge if the Man is on a stump and near the plank unit.
	 * @param x the X coordinate of the unit.
	 * @param y the Y coordinate of the unit.
	 * @return if the Man is on a stump and near the plank unit.
	 */
	private boolean isPlankNearMan(int x,int y){
		int tempX=x;
		int tempY=y;
		
		while(isPlank(tempX,tempY)){
			if(hasMan(tempX+1,tempY)) return true;
			tempX+=1;
			if(isInRange(tempX,tempY)!=true) break;
		}
		tempX=x;
		
		while(isPlank(tempX,tempY)){
			if(hasMan(tempX-1,tempY)) return true;
			tempX-=1;
			if(isInRange(tempX,tempY)!=true) break;
		}
		tempX=x;
		
		while(isPlank(tempX,tempY)){
			if(hasMan(tempX,tempY+1)) return true;
			tempY+=1;
			if(isInRange(tempX,tempY)!=true) break;
		}
		tempY=y;
		
		while(isPlank(tempX,tempY)){
			if(hasMan(tempX,tempY-1)) return true;
			tempY-=1;
			if(isInRange(tempX,tempY)!=true) break;
		}
		tempY=y;
		
		return false;
	}


	/**
	 * Judge if the unit which was clicked is a plank.
	 * @param x The X coordinate of the unit which was clicked.
	 * @param y The Y coordinate of the unit which was clicked.
	 * @return if the unit which was clicked is a plank.
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public boolean isPlank(int x,int y)
			throws ArrayIndexOutOfBoundsException{
		try{
			return map[y][x].indexOf("plank")>-1;
		}
		catch(ArrayIndexOutOfBoundsException e){}
		return true;
	}
	
	
	/**
	 * Judge if the unit is a stump.
	 * @param x The X coordinate of the unit.
	 * @param y The Y coordinate of the unit.
	 * @return if the unit is a stump.
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public boolean isStump(int x,int y){
		return map[y][x].indexOf("stump")>-1;
	}
	
	
	/**
	 * Judge if the player wins.
	 * @return if the player wins
	 */
	public boolean isWin(){
		return xMan==xTerminal&&yMan==yTerminal;
	}


	/**
	 * Judge if the unit is water.
	 * @param x The X coordinate of the unit.
	 * @param y The Y coordinate of the unit.
	 * @return if the unit is water.
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public boolean isWater(int x,int y)
			throws ArrayIndexOutOfBoundsException{
		try{
			return map[y][x].indexOf("water")>-1;
		}
		catch(ArrayIndexOutOfBoundsException e){}
		return true;
	}
	
	
	/**
	 * Judge if the Man is on a stump and near the water unit.
	 * @param x the X coordinate of the unit.
	 * @param y the Y coordinate of the unit.
	 * @return if the Man is on a stump and near the water unit.
	 */
	private boolean isWaterNearMan(int x,int y){
		int tempX=x;
		int tempY=y;
		
		while(isWater(tempX,tempY)){
			if(hasMan(tempX+1,tempY)) return true;
			tempX+=1;
			if(isInRange(tempX,tempY)!=true) break;
		}
		tempX=x;
		
		while(isWater(tempX,tempY)){
			if(hasMan(tempX-1,tempY)) return true;
			tempX-=1;
			if(isInRange(tempX,tempY)!=true) break;
		}
		tempX=x;
		
		while(isWater(tempX,tempY)){
			if(hasMan(tempX,tempY+1)) return true;
			tempY+=1;
			if(isInRange(tempX,tempY)!=true) break;
		}
		tempY=y;
		
		while(isWater(tempX,tempY)){
			if(hasMan(tempX,tempY-1)) return true;
			tempY-=1;
			if(isInRange(tempX,tempY)!=true) break;
		}
		tempY=y;
		
		return false;
	}


	/**
	 * Judge if the unit is walkable.
	 * stump and plank are both walkable.
	 * @param x The X coordinate of the unit.
	 * @param y The Y coordinate of the unit.
	 * @return if the unit is walkable
	 */
	public boolean isWalkable(int x,int y)
			throws ArrayIndexOutOfBoundsException{
		try{	
		return (map[y][x].indexOf("stump")>-1 ||
					map[y][x].indexOf("plank")>-1) &&
						isInRange(x,y);
		}
		catch(ArrayIndexOutOfBoundsException e){}
		return false;
	}


	/**
	 * Judge if the man is on the unit which is a plank.
	 * @param x The X coordinate of the unit.
	 * @param y The Y coordinate of the unit.
	 * @return the man is on a unit and the unit is a plank.
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public boolean hasMan(int x,int y)
			throws ArrayIndexOutOfBoundsException{
		try{
			return map[y][x].indexOf("_man")>-1&&
					map[y][x].indexOf("stump")>-1;
		}
		catch(ArrayIndexOutOfBoundsException e){}
		return false;
	}


	/**
	 * Convert a unit into water.
	 * @param x The X coordinate of the unit.
	 * @param y The Y coordinate of the unit.
	 */
	private void toWater(int x,int y){
		map[y][x]="water1";
	}
	
	
	/**
	 * Convert a unit of a plank into water
	 * @param x The X coordinate of the unit.
	 * @param y The X coordinate of the unit.
	 * @throws ArrayIndexOutOfBoundsException
	 */
	private void wipePlank(int x,int y)
			throws ArrayIndexOutOfBoundsException{
		try{	
			if(isPlank(x,y)){
				toWater(x,y);
				lengthOfPlank++;
			}
		}
		catch(ArrayIndexOutOfBoundsException e){}
	}


	/**
	 * Wipe a man from the unit.
	 * @param x The X coordinate of the unit.
	 * @param y The Y coordinate of the unit.
	 */
	private void wipeMan(int x,int y){
		map[y][x]=map[y][x].substring(0, map[y][x].length()-4);
	}


	/**
	 * Print a man on the unit.
	 * @param x The X coordinate of the unit.
	 * @param y The Y coordinate of the unit.
	 */
	private void printMan(int x,int y){
		map[y][x]=map[y][x]+"_man";
	}
	
	
	/**
	 * Obtain the length of the plank which has been carried.
	 * @return lengthOfPlank.
	 */
	public int getLengthOfPlank(){
		return lengthOfPlank; 
	}
	
	
	/**
	 * Obtain the number of the steps the man moved.
	 * @return the number of the steps the man moved.
	 */
	public int getStep(){
		return step; 
	}
	
	
	/**
	 * This method is only for testing.
	 * Win the game directly.
	 */
	public void win(){
		xMan=xTerminal;
		yMan=yTerminal;
	}
	
	/**
	 * This method is only for testing.
	 * Print the 2D array.
	 */
	public void printArray(){
		for(int i=0;i<HEIGHT;i++){
			for(int j=0;j<WIDTH;j++)
			{
				System.out.printf("%15s",map[i][j]);
			}
			System.out.println();
		}
	}
}
