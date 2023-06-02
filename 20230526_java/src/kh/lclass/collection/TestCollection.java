package kh.lclass.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import kh.lcalss.oo.sample.Car;

public class TestCollection {
	
	public <E extends Number, J> String testGeneric(E a, J b) {
		System.out.println(a.getClass().getName());
		System.out.println(b.getClass().getName());
		return a.toString()+ "결과값"+ b.toString();
	
	}
	
	public void testStack() {
		Stack<String> strStack = new Stack<String>();
		strStack.push("안녕");
		strStack.add("하"); // Stack은 보통 push
		strStack.add("세요");
		System.out.println(strStack.get(1));
		System.out.println(strStack);
		System.out.println(strStack.peek());
		System.out.println(strStack);
		System.out.println(strStack.pop());
		System.out.println(strStack);
	}
 
	public void testHashMap() {
		Map<String, Object> objMap = new HashMap<String, Object>();
		Map<String, Integer> objMap2 = new HashMap<String, Integer>();
		objMap.put("ej", 35.0);
		objMap.put("jh", "지영이네");
		objMap.put("hj", new Car(5000));
		System.out.println(objMap.toString());
		System.out.println("jy" + ":" + objMap.get("jy"));
		Set<String> keySet = objMap.keySet();
		System.out.println(keySet);
		System.out.println("=====Map: ebhanced for =====");
		for (String item : keySet) {
			Object value = objMap.get(item);
			System.out.println(item + " : " + value);
		}
		System.out.println("======Map: Interator for =====");
		Iterator<String> itr = keySet.iterator();
		while (itr.hasNext()) {
			String item = itr.next();
			Object value = objMap.get(item);
			System.out.println(item + " : " + value);
		}

	}

	public void testHashSet() {
		Set<Integer> integerSet = new HashSet<Integer>();
		integerSet.add(11);
		integerSet.add(22);
		integerSet.add(33);
		integerSet.add(11);
		System.out.println(integerSet.toString());
		System.out.println("===Set : enhanced for =====");
		for (Integer item : integerSet) {
			System.out.println(item);
		}
		System.out.println("=== Set :  Interator 사용 =====");
		Iterator<Integer> itr = integerSet.iterator();
		while (itr.hasNext()) {
			Integer item = itr.next();
			System.out.println(item);
		}
		System.out.println(itr);
	}

	public void testArrayList() {
		String[] strArr1 = new String[3];
		strArr1[0] = "바나나";
		strArr1[1] = "딸기";

		/*
		 * 
		 * public class AttayList implements List{ public boolean add(Object e) { //int형
		 * x // } public boolean add(string e) { // } public boolean add(Integer e) { //
		 * } public boolean add(Double e) { // } public boolean add(Car e) { // } }
		 */

		// 아래코드 맨 앞에 List나 ArrayList 똑같(생략됨?)
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Car> list3 = new ArrayList<Car>();
		list3.add(new Car(3000));
		list2.add(25);
		list2.add(26);
		list2.add(null);
		list2.add(27);
		list2.add(55);
		// list2.add(10, 56); //끼워넣기 insert index 현재 크기size() 보다 클 수 없음.
		System.out.println(list2.get(2));
		System.out.println(list2.get(3));

		// List - for
		for (int i = 0; i < list2.size(); i++) {
			Integer item = list2.get(i);
			System.out.println(item);
		}
		// 배열 - for
		for (int i = 0; i < strArr1.length; i++) {
			String item = strArr1[i];
			System.out.println(item);
		}
		System.out.println("========= enhanced for ========");
		// enhanced - for
		for (Integer item : list2) {
			System.out.println(item);
		}
		for (String item : strArr1) {
			System.out.println(item);

		}

		List<String> list1 = new ArrayList<String>(); // List를 import 먼저 시켜줘야함
		if (list1.add("7번")) {
			System.out.println("list1에 추가 성공했습니다.");
		}
		list1.add("2번");
		list1.add("1번");
		list1.add("2번");
		list1.add("3번");
		list1.add(1, "2번대신끼워넣기"); // 말 그대로 2번대신 끼워넣음
//		list.remove("2번"); 				// 값 2번 삭제됨
		Collection<String> collection1 = new ArrayList<String>();
		collection1.add("2번");
//		collection1.add("3번");
		list1.removeAll(collection1);
		((ArrayList<String>) list1).clone();

		if (list1 instanceof ArrayList) { // <> 여기 안에 int같은 자료형 못 넣음
			@SuppressWarnings("unchecked")
			ArrayList<String> copyList = (ArrayList<String>) (((ArrayList<String>) list1).clone());
			System.out.println(copyList);
		}

//		list.remove(0); //1번이 사라진다(컴퓨터는 0부터 시작함)//
//		list.clear();   // 결과값 아무것도 없음//
		System.out.println(list1);
	}


}
