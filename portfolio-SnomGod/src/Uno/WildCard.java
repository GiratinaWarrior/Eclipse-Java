package Uno;

public class WildCard {
	
	private String color = "black";
	private String type;
	
	public WildCard(String CardType) {
		
		this.type = CardType;
		
	}
	
	public String getColor() {
		return this.color;
	}
	
	public String getType() {
		return this.type;
	}

}
