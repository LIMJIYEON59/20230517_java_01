package kh.lclass;

public class TestGetterSetter {
	private int abc1;
	private long abc2;
	private String abc3;
	private float abc4;
	private double abc5;
	//getter / setter
	public int getAbc1(/*매개인자없어도됨*/) {
		return this.abc1;
	}
	//위에 인트형이니 여기도 인트형이어야함 abc1이든 b1이어도됨
	public void setAbc1(int b1 /*대입할값을 담을 매개변수선언*/) {
		this.abc1 = b1;
	
	}
		
	public long getAbc2() {
		return abc2;
	}

}

