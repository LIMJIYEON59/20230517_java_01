package kh.lcalss.oo.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestPolymophism {

	public static void main(String[] args) {
		ArrayList<Car> carList = new ArrayList<Car>();
		List<Car> carArrList = new ArrayList<Car>(); // 가장 흔하게 선언하는 방식
		List<Car> carArrList2 = new ArrayList<Car>();
		Collection<Car> carCollection = new ArrayList<Car>();

		// 오류new TestInterface();
		TestInterface kh = new Kh();
		Kh kh2 = new Kh();

		((Kh) kh).KhSpecial();

		TestInterface bit;
		TestInterface bit2;
		kh2.KhSpecial();
		kh2.method1();

		Driver ej = new DriverSub();

		ej.setMoney(10000);

		ej.buy(new Sonata()); // buy같은 메소드, 가능 이유= 오버로딩
		ej.buy(new Avante());

		Driver jh = new Driver2sub();

		jh.setMoney(10000);
		jh.buy(new Sonata());
		jh.buy(new Avante());
	}

}
