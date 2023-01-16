package cafe_kiosk;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu();

		while (true) {						//무한 반복
			/* 메뉴 출력 */
			System.out.println("========== 키오스크 ==========");
			System.out.println("1. 주문 하기");
			System.out.println("2. 주문 취소");
			System.out.println("3. 주문 확인");
			System.out.println("9. 결제");
			System.out.print("선택 : ");

			int no = sc.nextInt(); //메뉴 선택

			switch (no) {
			case 1:
				menu.insert();				//Menu클래스의 insert메소드로 이동
				break;
			case 2:
				menu.delete();				//Menu클래스의 delete메소드로 이동
				break;
			case 3:
				menu.print();				//Menu클래스의 print메소드로 이동
				break;
			case 9:
				if (menu.payment()) {		//Menu클래스의 payment 메소드에서 논리값 반환
					System.out.println("주문해 주셔서 감사합니다.");
					return;
				} else {
					break;
				}
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
				break;

			}

		}

	}

}
