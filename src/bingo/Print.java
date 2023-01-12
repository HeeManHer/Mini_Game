package bingo;

public class Print {
	
	public static void bingoPrint(Make bingo) {

		for (int i = 0; i < bingo.getBingo().length; i++) {
			for (int k = 0; k < bingo.getBingo()[i].length; k++) {
				System.out.print(bingo.getBingo()[i][k] + "\t");
			}
			System.out.println();
		}

	}
}
