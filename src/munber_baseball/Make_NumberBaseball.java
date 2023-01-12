package munber_baseball;

public class Make_NumberBaseball {

	
	public int[] numMake() {
		int[] num = new int[4];

		num[0] = (int) (Math.random() * 9) + 1;
		for (int i = 1; i < num.length; i++) {
			num[i] = (int) (Math.random() * 10);
			for (int k = 0; k < i; k++) {
				if (num[i] == num[k]) {
					i--;
					continue;
				}
			}
		}

		return num;
	}
	
	public int[] tempMake(int select) {
		int[] temp = new int[4];

		temp[0] = select / 1000;
		temp[1] = select % 1000 / 100;
		temp[2] = select % 1000 % 100 / 10;
		temp[3] = select % 1000 % 100 % 10;

		return temp;
	}
}
