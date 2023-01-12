package munber_baseball;

import java.util.Scanner;

public class Main_NumberBaseball {

	public static void main(String[] args) {

		Make_NumberBaseball make = new Make_NumberBaseball();
		Check_NumberBaseball check = new Check_NumberBaseball();
		Scanner sc = new Scanner(System.in);

		int[] num = make.numMake();
		int[] temp;	
		
		int cnt=0;

		do {
			System.out.print("네자리 숫자 입력 : ");
			temp = make.tempMake(sc.nextInt());
			cnt++;

		} while (check.match(num, temp));

		System.out.println(cnt+"회 만에 맞추셨습니다.");
	}
}
