package Uno;

public class RegularCard {
	
	private String color;
	private int number;
	
	public RegularCard(String CardColor, int CardNumber) {
		
			this.color = CardColor;
		
			this.number = CardNumber;
		
	}
	
	public String getColor() {
		return this.color;
	}
	
	public int getNumber() {
		return this.number;
	}

}
