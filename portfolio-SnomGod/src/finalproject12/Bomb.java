/** 
 * Simer Aim
 * Course: ICS 4U
 * Teacher: Mrs. McCaffery
 * Date: 2023/01/21
 * Description: This is the Bomb class, the object that the player must avoid
 */
package finalproject12;

import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class Bomb extends Gem {

	/**
	 *  Empty constructor
	 */
	public Bomb() {}
	
	
	/** Creating the bomb object
	 * @param x the starting x-position
	 * @param y the starting y-position
	 */
	public Bomb(int x, int y)
	{
		setX(x); 
		setY(y);
		setSize(size);
		setPoint(-1);
		setColor(Color.BLACK);
		setySpeed(ySpeed);
		
		gemBody = new Rectangle(x, y, size, size);
		gemBody.setFill(color);
		gemBody.setStroke(Color.BLACK);
		
	}//end Bomb
	
}//end class
