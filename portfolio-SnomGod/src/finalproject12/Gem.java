/** 
 * Simer Aim
 * Course: ICS 4U
 * Teacher: Mrs. McCaffery
 * Date: 2023/01/19
 * Description: This is the Gem class, the object that the player must collect.
 */
package finalproject12;

import javafx.scene.Group;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * @author Simer
 */
public class Gem
{

	double x = 0;
	double y = 0;
	double xSpeed = 0;
	double ySpeed = 6;
	int point;
	Color color;
	int size = 20;
	Rectangle gemBody = null;

	Group gemGroup = null;

	//The spawn rates of the gems
	int[] gemSpawnRates = {5, 4, 4, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1};

	//Array of colors that coordinate to the number of points a gem is worth
	Color[] gemColors = 
		{
				null, 
				Color.YELLOW, 
				Color.BLUE, 
				Color.LIME,
				Color.ORANGE,
				Color.RED
		};

	/**
	 *  Empty constructor
	 */
	public Gem() {}

	/** Creating the gem object
	 * @param x the starting x-position of the gem
	 * @param y the starting y-position of the gem
	 * @param score how many points the gem is worth. a number between 1 and 10
	 */
	public Gem(int x, int y)
	{
		//Set the values of the gem to the ones in the parameters

		this.point = rndScore();

		setX(x);
		setY(y);
		setSize(size);
		setPoint(this.point);
		setColor(gemColors[this.point]);
		setySpeed(ySpeed);

		gemBody = new Rectangle(x, y, size, size);
		gemBody.setFill(color);
		gemBody.setStroke(Color.BLACK);

		updateGraphic();

	}//end Gem

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @return the xSpeed
	 */
	public double getxSpeed() {
		return xSpeed;
	}

	/**
	 * @param xSpeed the xSpeed to set
	 */
	public void setxSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	/**
	 * @return the ySpeed
	 */
	public double getySpeed() {
		return ySpeed;
	}

	/**
	 * @param ySpeed the ySpeed to set
	 */
	public void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}

	/**
	 * @return the point
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * @param point the point to set
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
		updateGraphic();
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}//end getSize

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
		updateGraphic();
	}//end setSize

	/**
	 * @return the gemBody
	 */
	public Rectangle getGem() {
		return gemBody;
	}//end getGem

	/**
	 * @return the gemGroup
	 */
	public Group getGemGroup() {
		return gemGroup;
	}//end getGemGroup

	/**
	 * @param gemGroup the gemGroup to set
	 */
	public void setGemGroup(Group gemGroup) {
		this.gemGroup = gemGroup;
	}//end setGemGroup

	/**
	 *  Make the gem fall down the screen
	 */
	public void Move()
	{

		
		//Update its coordinates by its speed
		this.x += this.xSpeed;
		this.y += this.ySpeed;

		updateGraphic();

	}//end Move

	/**
	 *  Updates the gems graphical appearance on the screen
	 */
	private void updateGraphic()
	{
		if (gemBody != null)
		{
			//Properly set the gems body
			gemBody.setX(this.x);
			gemBody.setY(this.y);
			gemBody.setWidth(this.size);
			gemBody.setHeight(this.size);
			gemBody.setFill(this.color);		
		}
	}//end updateGraphic

	/**
	 * Generates a random score for the gem from a specified array of options (above)
	 * @return the gems random score
	 */
	public int rndScore()
	{
		return gemSpawnRates[GemGame.randomRange(0, gemSpawnRates.length)];
	}//end rndScore

	/**
	 * This method checks if the gem is in contact with the player
	 * @param player the player to check contact with
	 * @return boolean if the player is touching this gem
	 */
	public boolean hitPlayer(Player player)
	{
		//Check collision between player and gem
		if (
				x + size >= player.getX() &&
				x <= player.getX() + player.getWidth() &&
				y + size >= player.getY() &&
				y <= player.getY() + player.getHeight()
				)
		{
			return true;
		}//end if
		
		//if no collision
		else
		{
			return false;
		}//end else

	}//end hitPlayer

	
}//end class
