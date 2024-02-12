package Uno;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int UnoRoll;
		
		for (int a = 0; a < 20; a++) {
			UnoRoll = (int) (Math.random() * 9) + 1;
			System.out.println(UnoRoll);
		}
		
	}

}
