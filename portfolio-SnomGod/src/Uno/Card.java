package Uno;

public class Card {
	
	//the private variables that represent the color and type of the card
	private String color;
	private String type;
	
	//The Card itself, used for randomly generating a card
	public Card() {
		
		//the color of the card, randomly generated, made so that black cards are rare
		int ColorCard = (int) (Math.random() * 13) + 1;
		
		if (ColorCard >= 1 && ColorCard <= 3) {
			this.color = "red";
		}
		else if (ColorCard >= 4 && ColorCard <= 6) {
			this.color = "blue";
		}
		else if (ColorCard >= 7 && ColorCard <= 9) {
			this.color = "green";
		}
		else if (ColorCard >= 10 && ColorCard <= 12) {
			this.color = "yellow";
		}
		else {
			this.color = "";
		}
		
		//the type of card, being a number between 0-9, or a skip, draw2, or reverse
		int ColorType = 0;
		
		//if the color is a regular card
		if (ColorCard != 13){
			
			//Generates a random number between 1 and 12
			ColorType = (int) (Math.random() * 13); 
	
			if (ColorType >= 0 && ColorType <= 9) {
				this.type = "" + ColorType;
			}
			else if (ColorType == 10) {
				this.type = "skip";
			}
			else if (ColorType == 11) {
				this.type = "draw2";
			}	
			else {
				this.type = "reverse";
			}
			
			
			
		}//end if not black
		
		//If the card is a wild variant card
		if (ColorCard == 13) {
			
			//Generates a random number between 1 and 2
			ColorType = (int) (Math.random() * 2) + 1;

			//Sets the cards type depending on the number rolled
			switch(ColorType) 
			{
				//the type is a wild card
				case 1:
					this.type = "wild";
					break;
				//the type is a wild draw 4 card
				case 2:
					this.type = "wilddraw4";
					break;
					
				//in case something does not work, wild
				default:
					this.type = "wild";
					break;	
			}//end switch 
			
		}//end if wild variant
		
		
	}
	
	//can instantly change the color and type of a card, used for setting a card (Unused)
	public Card(String color, String type) {
		
		this.type = type;
		this.color = color;
		
	}
	
	//retrieves the color of a card
	public String getColor() {
		return this.color;
	}//end color retriever
	
	//retrieves the type of a card
	public String getType() {
		return this.type;
	}//end type retriever
	
	//changes the color of a card
	public void setColor(String newColor) {
		this.color = newColor;
	}//end color changer
	
	//changes the type of a card
	public void setType(String newType) {
		this.type = newType;
	}//end type changer

}//end class
