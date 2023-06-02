package kh.lcalss.oo.sample;

public class Driver {
	private int license;
	private int money;
	
	public int getLicense() {
		return license;
	}
	public void setLicense(int license) {
		this.license = license;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	//자동차 구매 Driver
//	public void buy() {
//		if(money > c.getPrice) {
//			System.out.println("구매확정");
//		}else {
//			System.out.println("잔액 부족");
//		}
//	}
//	public void buy(Avante c) {
//		if(money > c.getPrice) {
//			System.out.println("구매확정");
//		}else {
//			System.out.println("잔액 부족");
//		}
//	}
	//위에 처럼 막 쓰지 않고 그것들의 공통부분을 부모클래스에 올리고 업캐스팅 생성 =>다운캐스팅
	public void buy(Car c) {			
		if(money > c.getPrice()) {
			//(Avante)c).moveAvante();
			
			if( c instanceof Sonata) {			//괄호 한 번 더 =연산자 우선순위 때문에
				((Sonata)c).moveSonata();		//c라는 것의 자료형을 바꾸고(소나타가 자료형) 그다음 move 소나타에 접근함
				c.defaultFun();
				System.out.println("Sonata 이벤트에 응모되셨습니다");
			}
			if( c instanceof Car) {
				System.out.println("Car 이벤트에 응모되셨습니다");
			}
			if( c instanceof Car) {
				System.out.println("Object 이벤트에 응모되셨습니다");
			}
			System.out.println( c.getPrice() +"원에 구매확정");
			money = money -c.getPrice();
		}else {
			System.out.println("잔액 부족! .  현재 잔액은 " +money);
		}
	}
	public void driving() {
		
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	업캐스팅
//	public void buy(Car c) {			
//		if(money > c.getPrice()) {
//			if( c instanceof Sonata) {
//				System.out.println("이벤트에 응모되셨습니다");
//			}
//			if( c instanceof Car) {
//				System.out.println("Car 이벤트에 응모되셨습니다");
//			}
//			System.out.println( c.getPrice() +"원에 구매확정");
//			money = money -c.getPrice();
//		}else {
//			System.out.println("잔액 부족! .  현재 잔액은 " +money);
//		}
//	}
//	public void driving() {
//		
//	}



