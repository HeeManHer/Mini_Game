package stop_second;

import java.util.Scanner;

public class Main_StopSecond {

	public static void main(String[] args) {
		
		long time1;
		long time2;
		float result;
		
		Scanner sc = new Scanner(System.in);

		System.out.println("========== 10초에 가깝게 맞추기 ==========");
		
		while(true) {
		System.out.println("준비가 되시면 Enter를 눌러 주세요");
		sc.nextLine();
		time1= System.currentTimeMillis();
		

		System.out.println("10초가 됐다고 생각하시면 Enter를 눌러 주세요");
		sc.nextLine();
		time2= System.currentTimeMillis();
		
		result = (time2-time1)/1000;
		
		System.out.println(result);
		}
		
		
	}

}
