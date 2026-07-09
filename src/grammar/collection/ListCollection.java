package grammar.collection;

import java.util.ArrayList;

public class ListCollection {
    // 데이터를 효율적으로 접근하고 수정할 수 있는 구조를
    // 자료구조(data structure) 라고 한다. 
    
    // 자바에서는 다양한 자료구조를 컬렉션(Collection)이라는 이름으로
    // 제공하고 있으며, 그 형태에 따라 List, Set, Map 으로 구분된다. 
    // 각각의 구현된 알고리즘에 따라 여러가지가 존재한다..
    
    // List 는 앞서 공부한 배열과 같이 목록형태로 데이터를 
    // 관리할 때 사용되며, 대표적으로 ArrayList, LinkedList 라는 것이 있다. 
    
    // Set 은 List와 유사하나 중복된 값을 허용하지 않는다.
    // 대표적으로 HashSet 등이 있다.
    
    // 자동차 번호를 알면 해당 번호의 차량 정보를 알 수 있듯이
    // 특정 키를 이용하여 값을 얻고자 할 때 사용된다.
    // 대표적으로 HashMap 등이 있다.

    public static void main(String[] args) {
        // 들어가기 전에

        // "new" 연산자 : 
        // 변수가 메모리에 적재된 것을 인스턴스라고 한다. 원시자료형은 
        // 대입연산자 "=" 를 사용하면 알아서 인스턴스가 되지만 
        // 참조자료형은 "new" 라는 키워드를 사용해야한다. 
        String name = new String();  // "new 데이터형()" 
        name = "세종대왕";
        IO.println(name); // 세종대왕

        // String 은 참조데이터형이지만 예외적으로 new 를 사용하지 않아도 된다.
        String adress = "서울시 광진구 화양동"; 
        IO.println(adress); // 세종대왕
        
        // List
        ArrayList<String> names = new ArrayList<String>();
        // 제네릭
        // "<>" 
        // List, Set, Map 과 같은 컬렉션들은 내부에 담아둘 데이터의 형태를
        // 명시적으로 지정해주어야 한다. 어떤 데이터형이 담길지
        // "<>" 기호안에 적어주면 되며, 이를 제네릭이라고 한다. 
        // 원시자료형(int, long, double 등)은 제네릭에 사용할 수 없다.

        // 데이터 추가
        names.add("강은수"); 
        names.add("변상렬");
        names.add("부태섭");
        // 배열로 {"강은수", "변상렬", "부태섭"} 으로 만든 것과 동일하다.
        
        // 데이터 꺼내기
        String name0 = names.get(0); // 강은수 
        String name1 = names.get(1); // 변상렬 
        String name2 = names.get(2); // 부태섭 
        
        // 데이터 삭제하기
        names.remove(0); // 강은수 삭제
        
        IO.println(names);
        IO.println(names.get(0)); // 강은수 삭제 후 "변상렬"이 0번에 들어간다.
        
        // List 크기 알아내기
        int listSize = names.size();
        // for문으로 출력하기 : 
        for(int i = 0; i < listSize; i++) {
            IO.println(names.get(i));
        }

        
    }
}
