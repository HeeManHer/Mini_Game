package cafe_kiosk;

public class Espresso extends Coffee {
	
	/* Coffee 클래스에서 상속 받아
	 * 객체 생성 시 필드 초기화
	 * */
	
	public Espresso() {		
		setName("에스프레소");
		setPrice(3000);
	}

}
