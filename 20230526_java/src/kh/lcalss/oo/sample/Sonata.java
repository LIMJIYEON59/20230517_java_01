package kh.lcalss.oo.sample;

public class Sonata extends Car{
	public Sonata() {
		super(4000);		//부모쪽에 필드가 있어 따로 생성x
	}
	public void moveSonata() {
		System.out.println("Sonata moveSonata");
	}

}
