/** 
 * Simer Aim
 * Course: ICS 4U
 * Teacher: Mrs. McCaffery
 * Date: 2023/01/29
 * Description: This is the wall class
 */
package finalproject12;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Wall {

	double x = 0;
	double y = 0;
	double width = 30;
	double height = 60;
	Color color = Color.BLACK;
	
	Rectangle wallBody;
	
	/**
	 *  Empty constructor
	 */
	public Wall() {}
	
	public Wall(double x, double y, double width, double height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		wallBody = new Rectangle(x, y, width, height);
		wallBody.setFill(Color.BLACK);
	}
	
	/**
	 * @return the x-coordinate of the wall
	 */
	public double getX()
	{
		return this.x;
	}
	
	/**
	 * @return the y-coordinate of the wall
	 */
	public double getY()
	{
		return this.y;
	}
	
	/**
	 * @return the color of the wall
	 */
	public Color getColor()
	{
		return this.color;
	}
	
	/**
	 * @return the width of the wall
	 */
	public double getWidth()
	{
		return this.width;
	}
	
	/**
	 * @return the width of the wall
	 */
	public double getHeight()
	{
		return this.height;
	}
	
	/**
	 * @return the walls graphical appearance
	 */
	public Rectangle getWall()
	{
		return this.wallBody;
	}
	
	/** 
	 * @param x the walls new x-position
	 */
	public void setX(double x)
	{
		this.x = x;
		updateGraphic();
	}
	
	/** 
	 * @param y the walls new y-position
	 */
	public void setY(double y)
	{
		this.y = y;
		updateGraphic();
	}
	
	/** 
	 * @param color the displayed color of the wall
	 */
	public void setColor(Color color)
	{
		this.color = color;
		updateGraphic();
	}
	
	/** 
	 * @param width the walls width
	 */
	public void setWidth(double width)
	{
		this.width = width;
		updateGraphic();
	}
	
	/** 
	 * @param height the walls height
	 */
	public void setHeight(double height)
	{
		this.height = height;
		updateGraphic();
	}
	
	/**
	 *  Updates the walls graphical appearance on the screen
	 */
	private void updateGraphic()
	{
		wallBody.setX(this.x);
		wallBody.setY(this.y);
		wallBody.setWidth(this.width);
		wallBody.setHeight(this.height);
		wallBody.setFill(this.color);		
	}
	
	
	
}//end class
