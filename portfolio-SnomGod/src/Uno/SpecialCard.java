package Uno;

public class SpecialCard {
	
	private String color;
	private String type;
	
	public SpecialCard(String CardColor, String CardType) {
		
		this.color = CardColor;
		this.type = CardType;
		
	}
	
	public String getColor() {
		return this.color;
	}
	
	public String getType() {
		return this.type;
	}

}
