package kh.lcalss.oo.sample;

import java.io.Serializable;
//import java.util.List;

@SuppressWarnings("serial")
public class Kh implements TestInterface, Serializable {
	// The serializable class Kh does not declare a static final serialVersionUID
	// field of type long
// static final long serialVersionUID = 1L; 

	public void KhSpecial() {
		// TODO Auto-generated method stub

	}

	@Override
	public void method1() {

	}

	@Override
	public String method2() {

		return null;

	}

	@Override
	public int method3(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

//Testlnterface 파일에 밑에 주석처리 했는데 여기다 당연히 못 씀.

}
