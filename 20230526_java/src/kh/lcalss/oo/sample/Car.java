package kh.lcalss.oo.sample;

public class Car {		//부모클래스를 만들어 다 옮겨버림
	private int price; /*소나타랑 아반떼 가격 넣지 않고 
						 car에 전체적으로 넣어줌(선택사항 근데 이게편함 car에서 내려받으니)*/
	public Car() {}
	public Car(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public void defaultFun() {
		System.out.println("Car 기본기능");
	}
	
	public void moveCar() {
		System.out.println("Car move");
	}

}
