package munber_baseball;

public class Check_NumberBaseball {

	public boolean match(int[] num, int[] temp) {
		StrikeBallOut sto=new StrikeBallOut();

		int strike = sto.strike(num, temp);
		int ball = sto.ball(num, temp);
		int out = sto.out(num, temp);

		System.out.println(strike + "s, " + ball + "b, " + out + "o");
		if (strike == 4) {
			System.out.println("정답입니다.");
		}

		return (strike == 4) ? false : true;

	}

}
