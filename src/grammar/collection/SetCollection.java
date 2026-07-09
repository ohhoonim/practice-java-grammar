package grammar.collection;

import java.util.HashSet;
import java.util.Iterator;

public class SetCollection {
    public static void main(String[] args) {
        IO.println("set collection");

        // Set 
        // Set은 중복값을 허용하지 않는 index가 없는 List이다. 
        HashSet<String> names = new HashSet<>(); // 두번째 <> 는 타입명을 생략할 수 있다.

        names.add("matthew");
        names.add("alison");
        names.add("kail");
        names.add("matthew");       // <- 에러는 나지 않지만 출력해보면
        IO.println(names);  // [matthew, kail, alison] 값은 세개만 들어있다.
        
        int namesSize = names.size();
        IO.println(namesSize); // 3s

        // set에서는 
        // names.get();  // <- set에는 이런게 없다. 
        // 하나씩 꺼내 쓰려면 다른 방법을 사용해야한다. 
        
        IO.println("배열로 변환한 후 출력하는 방법");
        // 방법1.배열로 변환한 후 출력하는 방법
        Object[] namesArray = names.toArray();
        for(int i = 0; i < namesArray.length; i++) {
            IO.println(namesArray[i]);
        }

        IO.println("향상된 for문을 사용하는 방법");
        // 방법2. 향상된 for문을 사용하는 방법
        for(String name: names) {
            IO.println(name);
        }

        IO.println("iterator메서드를 사용하는 방법");
        // 방법3. iterator메서드를 사용하는 방법
        Iterator<String> iter = names.iterator();
        while(iter.hasNext()) {
            String name = iter.next();
            IO.println(name);
        }
        
        IO.println("forEach메서드를 사용하는 방법");
        // 방법4. forEach메서드를 사용하는 방법
        names.forEach( name -> IO.println(name));

    }
}
