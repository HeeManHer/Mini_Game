package bingo;

import java.util.Scanner;

public class Bingo {

	int[][] bingo;
	int bingoCount = 0;

	Scanner sc = new Scanner(System.in);

	public void BingoGame() {

		System.out.print("빙고 칸 수를 입력하세요 : ");
		int index = sc.nextInt();

		Make(index);
		change();
	}

	public void Make(int index) {

		bingo = new int[index][index];

		int temp[] = new int[index * index];

		for (int i = 0; i < temp.length; i++) {
			temp[i] = (int) (Math.random() * index * index) + 1;

			for (int k = 0; k < i; k++) {
				if (temp[k] == temp[i]) {
					i--;
					break;
				}
			}
		}

		int j = 0;

		for (int i = 0; i < bingo.length; i++) {
			for (int k = 0; k < bingo[i].length; k++) {
				bingo[i][k] = temp[j++];
			}
		}

		Print();
	}

	public void Print() {
		
		System.out.println("bingo count : " + bingoCount);
		
		for (int i = 0; i < bingo.length; i++) {
			for (int k = 0; k < bingo[i].length; k++) {
				System.out.print(bingo[i][k] + "\t");
			}
			System.out.println();
		}

	}

	public void change() {

		int num;

		while (true) {
			System.out.print("숫자를 하나 입력하세요 : ");
			num = sc.nextInt();

			if (num > bingo.length * bingo.length || num < 1) {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
				continue;
			}

			for (int i = 0; i < bingo.length; i++) {
				for (int k = 0; k < bingo[i].length; k++) {
					if (bingo[i][k] == num) {
						bingo[i][k] = 0;
					}
				}
			}
			match();
			
			if(bingoCount > bingo.length/2) {
				Print();
				System.out.println("BINGO!!");
				return;
			}
			Print();
		}
	}

	public void match() {

		int bingoMatch;

		/* 가로줄 빙고 */
		for (int i = 0; i < bingo.length; i++) {
			bingoMatch = 0;
			for (int k = 0; k < bingo[i].length; k++) {
				if (bingo[i][k] == 0) {
					bingoMatch++;
				}
			}
			if (bingoMatch == bingo[i].length) {
				bingoCount++;
			}
		}

		/* 세로줄 빙고 */
		for (int i = 0; i < bingo.length; i++) {
			bingoMatch = 0;
			for (int k = 0; k < bingo[i].length; k++) {
				if (bingo[k][i] == 0) {
					bingoMatch++;
				}
			}
			if (bingoMatch == bingo[i].length) {
				bingoCount++;
			}
		}

		/* 좌상-우하 대각선 빙고 */
		bingoMatch = 0;
		for (int i = 0; i < bingo.length; i++) {
			if (bingo[i][i] == 0) {
				bingoMatch++;
			}
		}
		if (bingoMatch == bingo.length) {
			bingoCount++;
		}

		/* 좌하-우상 대각선 빙고 */
		bingoMatch = 0;
		for (int i = 0; i < bingo.length; i++) {
			if (bingo[i][bingo.length - i - 1] == 0) {
				bingoMatch++;
			}
		}
		if (bingoMatch == bingo.length) {
			bingoCount++;
		}
	}

}
