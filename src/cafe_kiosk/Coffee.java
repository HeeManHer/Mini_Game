package cafe_kiosk;

public class Coffee {
	
	private String name;		//커피 이름
	private int price;			//커피 가격
	
	public Coffee() {} 			//기본 생성자

	public Coffee(String name, int price) { //이름과 가격 초기화하는 생성자
		
		this.name = name;
		this.price = price;
	}

	/* getter */
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	/* setter */
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void getInfo() {
		System.out.println("이름 : " + this.name + "\t가격 : " + this.price);
	}
	

}
