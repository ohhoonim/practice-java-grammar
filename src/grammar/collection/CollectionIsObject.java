package grammar.collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectionIsObject {

    /**
    ## 컬렉션을 객체로 볼까 말까
        - 컬렉션을 단순히 여러 객체를 한번에 가리키는 역할로만 볼 수도 있지만 
          컬렉션 자체를 객체로 볼 수도 있다. 
        - 컬렉션을 객체로 취급하면 매개변수 전달시 참조 호출의 효과를 얻을 수 있다. 
          참조 호출이므로 컬렉션 내의 값을 변경하면 컬렉션이 변경될 수 있다.  
     */
    
    @Test
    @DisplayName("매개변수를 값으로 전달")
    public void primitiveParameterTest() {
        int age = 100;
        int newAge = changeAge(age);
        assertEquals(120, newAge);
        
        age = 200;
        assertNotEquals(220, newAge);
    }

    private int changeAge (int age) {
        int newAge = age + 20;
        return newAge;
    }

    @Test
    @DisplayName("매개변수를 참조로 전달")
    public void referenceObjectTest() {
        var names = new ArrayList<String>(List.of("matthew", "alison", "simon", "mijin"));
        assertEquals("matthew", names.get(0));
        
        var newNames = changeName(names, 0, "youngjin");
        assertNotEquals("matthew", newNames.get(0));
        assertEquals("youngjin", names.get(0));  // names도 바뀌어 버렸다.
    }

    private <T> List<T> changeName(List<T> names, int index, T name) {
        names.set(index, name);
        List<T> newNames = new ArrayList<>(names);
        return newNames;
    }
}
