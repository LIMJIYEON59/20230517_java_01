package kh.lclass.thread;

public class ThreadAaa implements Runnable {

	@Override
	public void run() {
		for (int dan=2; dan<101; dan++) {
			for (int su=1; su<10; su++) {
				System.out.printf("%3d*%2d=%3d\n", dan, su, dan * su);
			}
			System.out.println("==="); // 여기서 sleep 못씀 Runnable이라서 저긴 상속 받아서 가넝
		}
		System.out.println("**********끝***********");
	}

}
