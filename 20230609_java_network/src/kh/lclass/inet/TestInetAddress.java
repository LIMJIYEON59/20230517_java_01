package kh.lclass.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class TestInetAddress {
	public void testInerAddressEx() {	//testInerAddressEx 이 메서드는 InetAddress 클래스를 사용하여 네트워크 주소를 테스트한다
		//The constructor InetAddress() is not visible
		// 원인 : 생성자 없음
		// 조치내용 : 1 . singleton 확인
		// 2. singleton 확인 ( 주로 getInstence(), create() 메소드 지원 확인) 근데 없어. 그래서 static 확인
		// 생성자 없이 static method 즉 클래스메소드지원이 됨.{InetAddress.getByName(null);}
		String host1 = "www.naver.com"; // 도메인 이름들(문자열 변수 선언)
		String host2 = "www.gogle.com";
		String host3 = "www.oracle.com"; // getByName: 도메인 명을 통해 IP주소를 얻는다
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MAX_VALUE);
		try { 															// 보통 new를 쓰기마련인데 못 씀.(생성자x) 	
			// 로컬 루프백 주소를 얻어옴
			InetAddress loopbackAddr = InetAddress.getLoopbackAddress();//getLoopbackAddress() 메서드는 로컬 루프백 주소를 반환함 
			System.out.println(loopbackAddr);
			
			// 로컬 호스트의 IP 주소를 얻어옴
			InetAddress localIp = InetAddress.getLocalHost();//getLocalHost 메서드는 현재 컴퓨터의 로컬 호스트의 IP주소를 반환하고 
			System.out.println(localIp);					 //localIP변수에 저장하고 출력한다.
			// 로컬 호스트가 루프백 주소인지 확인
			boolean isLoopback = localIp.isLoopbackAddress();//isLoopbackAddress 주어진 IP주소가 루프백 주소인지 판별한다
			System.out.println(isLoopback);					 //localIp 변수가 루프백 주소인지 확인하고 출력
			
			//"localhost"에 대한 IP 주소를 확인하는 부분이다.
			System.out.println("======localhost=====");
			//"localhost"의 IP 주소를 얻어옴
			InetAddress lb =InetAddress.getByName("localhost");			 //getByName()를 사용하여 localhost의 IP 주소를 얻어온 뒤
			System.out.println(Arrays.toString(lb.getAddress()));			//해당 IP주소의 바이트 배열을 출력하고 루프백 주소인지 여부확인한다.
			// "localhost"가 루프백 주소인지 확인
			boolean lbIsLoopback = lb.isLoopbackAddress();
			System.out.println(lbIsLoopback);
			
			
			//로컬 호스트의 IP 주소를 바이트 배열로 얻어온 뒤, 각 바이트 값을 점으로 구분하여 출력. 음수 값인 경우 256을 더해 양수로 출력
			byte[] localIpArr = localIp.getAddress();
			System.out.print("ip: ");  
			for(int i = 0;i< localIpArr.length;i++) {
				if(localIpArr[i]<0) {
					System.out.print(localIpArr[i]+256);
				}
				else {
					System.out.print(localIpArr[i]);
				}
				if(i != localIpArr.length-1) {
					System.out.print(".");
				}
			}
			System.out.println();
			
			byte[] byteArr = new byte[] {(byte)223,(byte)130,(byte)200,(byte)104};//주어진 바이트배열을 사용해 IP 주소를 생성
			System.out.println(Arrays.toString(byteArr));
			//IP 주소를 바이트 배열로 변환하여 얻어옴
			InetAddress byte2Arr = InetAddress.getByAddress(byteArr);//getByAddress 메서드를 사용하여 바이트 배열로부터 IP주소를 얻어온다
			System.out.println(byte2Arr);							 //  /223.130.195.11 //byte2Arr 출력
			String aa = byte2Arr.getHostName();
			System.out.println(aa);									 //호스트 이름을 얻어와 'aa' 변수에 저장한 뒤 출력
			System.out.println(byte2Arr.getHostAddress());			 //getHostAddress() 메서드를 사용하여 IP 주소를 문자열로 얻은 후 출력
			System.out.println("=====");
			
			// 도메인 이름을 통해 모든 IP 주소를 얻어옴
			InetAddress[] ipAll = InetAddress.getAllByName(host1);
			// 도메인에 대한 모든 IP 주소 출력
			System.out.println(Arrays.toString(ipAll));  // www.naver.com/223.130.195.95
			for(InetAddress ip : ipAll) {
				System.out.println(ip);
				byte[] ipAddr = ip.getAddress();		//각 IP 주소에 대해서는 바이트 배열을 출력하고 점으로 구분하여 IP 주소를 출력한다
				System.out.print("ip:");					//이 과정을 'ipAll' 배열의 모든 IP 주소에 대해 반복한다.
				for (int i = 0; i < ipAddr.length; i++) {
					if (ipAddr[i] < 0) {
						System.out.println(ipAddr[i] + 256); // 자동형변환 일어남
					} else {
						System.out.print(ipAddr[i]);
					}
					if (i != ipAddr.length - 1) {
						System.out.print(".");
					}
				}
				System.out.println();
				
				
				System.out.println("ip:");
				int cnt = 0;
				for (int item : ipAddr) {
					if (item < 0) {
						System.out.println(item + 256); // 자동형변환 일어남
					} else {
						System.out.print(item);
					}
					if (cnt != ipAddr.length - 1) {
						System.out.print(".");
					}
					cnt++;
				}
				System.out.println();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}// 이렇게 코드는 InetAddress 클래스를 사용하여 네트워크 관련 작업을 수행하고 
	 //주어진 도메인 이름의 IP 주소를 얻어오는 등의 테스트를 한다

}
