package grammar.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class MapCollection {
    public static void main(String[] args) {
        IO.println("collection");

        // Map
        // Map은 키와 값을 사용자가 지정하여 데이터를 저장하는 방식이다. 
        HashMap<String, String> students = new HashMap<>();
        
        // 키와 값을 넣어야 하므로 List, Set과는 다르게 put() 메서드를 이용한다.
        students.put("20200001", "phillip");
        students.put("20200002", "antonio");
        students.put("20200003", "smith");

        // 값 가져오기
        String student1 = students.get("2020001"); // phillip
        String student2 = students.get("2020002"); // antonio

        String someone = students.get("99999"); // 찾으려는 키가 없다면 null 이다. 
        IO.println(someone);  
        
        IO.println("--------------------------------------");
        // Map은 반복문을 이용하여 값을 꺼내오는데 잘 사용되지 않는다. 
        // 반복문을 사용해서 값을 꺼내와야 하는 데이터구조라면 List나 Set을 사용
        // 여러가지 방법이 있지만 
        // 방법 1 iterator를 이용한 방법
        Set<String> keys = students.keySet();
        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()) {
            String key = iter.next();
            String name = students.get(key);
            IO.println(name);
        }
        IO.println("--------------------------------------");
        // 방법2 key와 value를 동시에 꺼내오는 방법
        Set<Entry<String, String>> entrySet = students.entrySet();
        Iterator<Entry<String, String>> iter2 = entrySet.iterator();
        while(iter2.hasNext()) {
            Entry<String, String> entry = iter2.next();
            IO.println(entry.getKey() + " : " + entry.getValue());
        }
        IO.println("--------------------------------------");
        // 방법3 forEach를 이용한 방법
        students.forEach((key, value) -> {
            IO.println(key + " : " + value);
        });


        

    }
}