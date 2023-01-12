package munber_baseball;

public class StrikeBallOut {


	public int strike(int[] num, int[] temp) {

		int strike = 0;

		for (int i = 0; i < num.length; i++) {
			if (num[i] == temp[i]) {
				strike++;
			}
		}

		return strike;
	}

	public int ball(int[] num, int[] temp) {

		int ball = 0;

		for (int i = 0; i < num.length; i++) {
			for (int k = 0; k < temp.length; k++) {
				if (i == k) {
					continue;
				}
				if (num[i] == temp[k]) {
					ball++;
				}
			}
		}
		return ball;

	}

	public int out(int[] num, int[] temp) {

		int out = 0;

		for (int i = 0; i < num.length; i++) {
			int cnt = 0;
			for (int k = 0; k < temp.length; k++) {

				if (num[i] != temp[k]) {
					cnt++;
				}
			}

			if (cnt == temp.length) {
				out++;
			}
		}

		return out;
	}
}
