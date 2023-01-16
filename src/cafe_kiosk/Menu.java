package cafe_kiosk;

import java.util.Scanner;

public class Menu {

	/* 필드 */
	
	Scanner sc = new Scanner(System.in);			//Scanner 생성

	private Coffee[] coffee = new Coffee[10];		//Coffee형 객체 배열 생성
	private int index = 0;							//배열 인덱스

	private int result;								//총 금액


	/**
	 * <pre>
	 * 객체 배열에 값 대입 역할을 하는 메소드
	 * 메소드 시작 시 인덱스 범위를 벗어나면 메소드 강제 종료
	 * 커피 메뉴에 따른 객체 생성 후 배열에 값 대입 
	 * </pre>
	 */
	public void insert() {

		if (index >= coffee.length) { 				//배열 범위를 벗어났을 때 메소드 종료
			System.out.println("더 이상 주문하실 수없습니다.");
			System.out.println("이전 화면으로 이동합니다.");
			return;
		}

		/* 메뉴 출력 */
		System.out.println("========== 주문 하기 ==========");
		System.out.println("1. 에스프레소");
		System.out.println("2. 아메리카노");
		System.out.println("3. 라떼");
		System.out.println("9. 뒤로가기");
		System.out.print("선택 : ");

		int no = sc.nextInt(); 						//메뉴 선택

		switch (no) {
		case 1:
			System.out.println("에스프레소를 선택하셨습니다.");
			coffee[index++] = new Espresso();		//배열의 index번에 Coffee클래스에서 상속받은 Espresso클래스로 객체 생성 후 값 대입
			break;
		case 2:
			System.out.println("아메리카노를 선택하셨습니다.");
			coffee[index++] = new Americano();		//배열의 index번에 Coffee클래스에서 상속받은 Americano클래스로 객체 생성 후 값 대입
			break;
		case 3:
			System.out.println("라떼를 선택하셨습니다.");
			coffee[index++] = new Latte();			//배열의 index번에 Coffee클래스에서 상속받은 Latte클래스로 객체 생성 후 값 대입
			break;
		case 9:
			return;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			break;
		}
	}

	/**
	 * <pre>
	 * 배열에서 값 제거 역할을 하는 메소드
	 * 배열의 0번 인덱스가 null이면 강제 종료
	 * 주문내역에서 입력한 메뉴와 이름이 같은 메뉴를 앞에서 부터 검색 후
	 * 일치하는 이름이 있으면 해당 인덱스 부터 뒤에 있는 값을 한칸씩 앞으로 대입 후 마지막 인덱스를 null로 대입 
	 * </pre>
	 * */
	public void delete() {

		if (coffee[0] == null) {
			System.out.println("주문을 하지 않았습니다. 먼저 주문을 해주세요");
			return;
		}

		print();

		System.out.println("========== 주문 취소 ==========");
		System.out.println("1. 에스프레소");
		System.out.println("2. 아메리카노");
		System.out.println("3. 라떼");
		System.out.println("9. 뒤로가기");
		System.out.print("선택 : ");

		int no = sc.nextInt();

		switch (no) {
		case 1:
			match("에스프레소");
			break;
		case 2:
			match("아메리카노");
			break;
		case 3:
			match("라떼");
			break;
		case 9:
			return;
		}
	}

	/**
	 * <pre>
	 * 매개변수와 같은 이름을 배열에서 찾아 삭제하는 메소드
	 * </pre>
	 * 
	 * @param name 삭제하려는 메뉴 이름
	 * */
	public void match(String name) {

		boolean isMatch = false; 						//일치하는 이름이 있으면 true

		for (int i = 0; i < index; i++) { 				//배열의 앞에서부터 검색
			if (coffee[i].getName().equals(name)) { 	//일치하는 이름이 있으면
				isMatch = true;
				for (int k = i; k < index - 1; k++) { 	//해당 인덱스부터 뒤에서 2번째 까지
					coffee[k] = coffee[k + 1]; 			//한 칸씩 앞으로 이동
				}
				coffee[index - 1] = null;				//마지막 인덱스는 null 대입
				index--;								//인덱스 1 감소
				break;
			}
		}

		if (isMatch) { 									//일치하는 이름이 있으면 출력
			System.out.println("주문하신 " + name + "를 취소했습니다.");
		} else {										//없으면 출력
			System.out.println(name + "을 주문하지 않았습니다.");
		}
	}

	/**
	 * <pre>
	 * 현재 주문 내역 출력
	 * </pre>
	 * */
	public void print() {

		result = 0;

		System.out.println();
		System.out.println("========== 현재 주문 상황 ==========");

		for (Coffee c : coffee) {
			if (c != null) {
				c.getInfo();
				result += c.getPrice();
			} else {
				break;
			}
		}

		System.out.println("================================");
		System.out.println("\t      총 금액 : " + result);
		System.out.println();
	}

	/**
	 * <pre>
	 * 최종 결재 메소드
	 * 주문 내역 확인 후 결재 할 것인지 확인 
	 * </pre>
	 * */
	public boolean payment() {

		print();
		System.out.println("주문하신 총 금액은 " + result + "원 입니다.");
		System.out.println("결재하시겠습니까?(1. yes | 2. no) : ");
		int no = sc.nextInt();

		switch (no) {
		case 1:
			System.out.println("결재 완료되셨습니다.");
			return true;
		case 2:
			System.out.println("이전화면으로 이동합니다.");
			return false;
		default:
			System.out.println("잘못 입력하셨습니다. 이전화면으로 이동합니다.");
			return false;
		}

	}

}
