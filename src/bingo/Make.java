package bingo;

public class Make {
	
	private int[][] bingo;	
	
	public Make(int index) {

		bingo = new int[index][index];

		int temp[] = new int[index * index];

		for (int i = 0; i < temp.length; i++) {
			temp[i] = (int) (Math.random() * index * index) + 1;
		}

		int j = 0;

		for (int i = 0; i < bingo.length; i++) {
			for (int k = 0; k < bingo[i].length; k++) {
				bingo[i][k] = temp[j++];
			}
		}
	}
	
	public int[][] getBingo() {
		return bingo;
	}
}
