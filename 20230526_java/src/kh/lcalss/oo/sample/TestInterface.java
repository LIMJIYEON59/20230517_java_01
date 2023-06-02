package kh.lcalss.oo.sample;

//import java.awt.im.spi.InputMethod;
import java.io.Serializable;


//abstract class => interface(안에 abstract 있다)
//interface > class 바꿔도됨 //.java안에 있는 놈
//interface extends 가능 그리고 뒤에 interface 여러개 쓰기 가능(상속 가능) 
//public interface면 뒤에 class 상속 불가능(반대는 가능)
public interface TestInterface extends/* InputMethod, */Serializable {   	
	public final int MAXCNT = 10;
	public  void method1();				//능력단위별 평가보기
	public  String method2();			//평가안내
	public  int method3(int a, int b);	//평가리뷰
//	public  int method3();
	
	
	//게시글 15개 <리턴, public 생략
//	int insertBoard(Car vo);
//	int deleteBoard(Car vo);
//	int updateBoard(Car vo);
//	Car selectOne(int board);
//	Car[] selectList();
//	Car[] selectList(String searchWord);
//	List<Car> selectListList(String searchWord);
//	Car[] searchSelectBoard(String word);
}
