/** 
 * Simer Aim
 * Course: ICS 4U
 * Teacher: Mrs. McCaffery
 * Date: 2023/01/29
 * Description: This the player class for GemGame
 */
package finalproject12;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Simer
 *
 */
public class Player {

	double x = 0;
	double y = 0;
	double gravity = 0.5;
	double xSpeed = 0;
	double ySpeed = 0;
	double width = 30;
	double height = 60;
	Color color = Color.WHITE;
	int score = 0;
	
	boolean jumping = false;
	boolean falling = true;
	
	double walkSpeed = 10;
	double jumpPower = 10;
	
	Rectangle playerBody;
	
	/**
	 * Empty constructor
	 */
	public Player() {}
	
	/** Creates an instance of a player object in GemGame
	 * @param x the starting x-coordinate of the player
	 * @param y the starting y-coordinate of the player
	 */
	public Player(double startX, double startY)
	{
		playerBody = new Rectangle(startX, startY, this.width, this.height);
		playerBody.setFill(color);
		playerBody.setStroke(Color.BLACK);
		
		this.x = startX;
		this.y = startY;
		
	}//end Player(double, double)
	
	/**
	 * @return the x-coordinate of the player
	 */
	public double getX()
	{
		return this.x;
	}
	
	/**
	 * @return the y-coordinate of the player
	 */
	public double getY()
	{
		return this.y;
	}
	
	/**
	 * @return the gravity the player experiences
	 */
	public double getGravity()
	{
		return this.gravity;
	}
	
	/**
	 * @return the horizontal speed of the player
	 */
	public double getXspeed()
	{
		return this.xSpeed;
	}
	
	/**
	 * @return the vertical speed of the player
	 */
	public double getYspeed()
	{
		return this.ySpeed;
	}
	
	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}
	
	/** 
	 * @return boolean for if the player is jumping
	 */
	public boolean getJumping()
	{
		return this.jumping;
	}//end getJumping
	
	/**
	 * @return boolean for if the player is falling
	 */
	public boolean getFalling()
	{
		return this.falling;
	}//end getFalling
	
	/**
	 * Check if the player is in the air
	 * @return if the player is airborne or not
	 */
	public boolean getAirborne()
	{
		//If the player is jumping or falling, they are airborne
		if (!this.falling && !this.jumping)
		{
			return false;
		}
		
		//if not, they are on the ground
		else
		{
			return true;
		}
		
	}//end getAirborne
	
	/**
	 * @return the color of the player
	 */
	public Color getColor()
	{
		return this.color;
	}
	
	/**
	 * @return the player's current score
	 */
	public int getScore()
	{
		return this.score;
	}
	
	/**
	 * @return the player's graphical appearance
	 */
	public Rectangle getPlayer()
	{
		return this.playerBody;
	}
	
	/** 
	 * @param x the players new x-position
	 */
	public void setX(double x)
	{
		this.x = x;
		updateGraphic();
	}
	
	/** 
	 * @param y the players new y-position
	 */
	public void setY(double y)
	{
		this.y = y;
		updateGraphic();
	}
	
	/** 
	 * @param gravity the players force of gravity experienced
	 */
	public void setGravity(double gravity)
	{
		this.gravity = gravity;
	}
	
	/** 
	 * @param xSpeed the players horizontal speed
	 */
	public void setXspeed(double xSpeed)
	{
		this.xSpeed = xSpeed;
	}
	
	/** 
	 * @param ySpeed the players vertical speed
	 */
	public void setYspeed(double ySpeed)
	{
		this.ySpeed = ySpeed;
	}
	
	/** 
	 * @param jump if the player is currently jumping
	 */
	public void setJumping(boolean jump)
	{
		this.jumping = jump;
	}//end setJumping
	
	/**
	 * @param fall if the player is currently falling
	 */
	public void setFalling(boolean fall)
	{
		this.falling = fall;
	}//end setFalling
	
	/** 
	 * @param color the displayed color of the player
	 */
	public void setColor(Color color)
	{
		this.color = color;
		updateGraphic();
	}
	
	/** 
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * increments the players score by a specified amount depending on the gem collected
	 * @param score the score to be added
	 */
	public void addScore(int gemPoints)
	{
		this.score += gemPoints;
	}

	/**
	 *  Updates the players graphical appearance on the screen
	 */
	private void updateGraphic()
	{
		playerBody.setX(this.x);
		playerBody.setY(this.y);
		playerBody.setWidth(this.width);
		playerBody.setHeight(this.height);
		playerBody.setFill(this.color);		
		
		//System.out.println("update graphics");
		
	}
	
	/**
	 * Function causes the player to jump
	 */
	public void Jump()
	{
		setYspeed(-jumpPower);
		updateGraphic();
	}
	
	/**
	 *  function that applies gravity to the player
	 */
	public void applyGravity()
	{
		
		//Apply gravity only if the player is airborne
		if (getAirborne()) 
		{
			setYspeed(getYspeed() + getGravity()); 
		}
		
		updateGraphic();
		
	}//end applyGravity
	
	/**
	 *  The overall movement speed
	 */
	public void Move()
	{
		
		x += xSpeed;
		y += ySpeed;
		
		if (getAirborne())
		{
			if (getYspeed() < 0)
			{
				this.jumping = true;
				this.falling = false;
			}
			else if ((getYspeed() > 0))
			{
				this.falling = true;
				this.jumping = false;
			}
		}
		
		updateGraphic();
		
	}//end Move
	
	/**
	 * This method checks if the player is touching the wall
	 * @param wall the wall to check contact worth
	 * @return if the player is touching the wall
	 */
	public boolean WallTouching(Wall wall)
	{
		
		double xmargin = 0;
		double ymargin = 0;
		
		//Check if the player is making contact with the wall
		if (
				this.x + xmargin + this.width >= wall.getX() && 
				this.x + xmargin <= wall.getX() + wall.getWidth() && 
				this.y + ymargin + this.height >= wall.getY() &&
				this.y + ymargin <= wall.getY() + wall.getHeight()
			)
		{
			return true;
		}//end check contact
		
		else
		{
			return false;
		}
		
	}//end WallTouching

	
}//end class
