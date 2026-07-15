package grammar.collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectionUtil {

    @Test
    @DisplayName("검색")
    public void search() {
        var names = List.of("matthew", "alison", "jun", "josh", "matthew");
        assertEquals(0, names.indexOf("matthew"));
        assertEquals(4, Collections.binarySearch(names, "matthew"));
    }

    @Test
    @DisplayName("정렬")
    public void sort() throws Exception {
        var names = new ArrayList<String>();
        names.addAll(List.of("matthew", "alison", "jun", "josh", "matthew"));
        Collections.reverse(names);
        assertEquals("josh", names.get(1));
    }

    @Test
    @DisplayName("수정 불능한 컬렉션")
    public void unmodified() {
        Exception exception = assertThrows(Exception.class, () -> {
            var names = new ArrayList<String>();
            names.addAll(List.of("matthew", "alison", "jun", "josh", "matthew"));
            var newNames = Collections.unmodifiableCollection(names); // 세상이 바뀌어서 List.of()를 써도 된다.
            newNames.add("yujin"); // <- Exception
        });
        assertEquals("UnsupportedOperationException", exception.getClass().getSimpleName());

    }

    @Test
    @DisplayName("단일원소 컬렉션")
    public void singleton() {
        var names = new ArrayList<String>();
        names.addAll(List.of("matthew", "alison", "jun", "josh", "matthew"));
        var newNames = Collections.singleton(names); // 세상이 바뀌어서 List.of()를 써도 된다.
        assertEquals(1, newNames.size());
        System.out.println(names.toString());
        System.out.println(newNames.toString());
    }

    @Test
    @DisplayName("무원소 컬렉션")
    public void emptyList() {
        var names = Collections.<String>emptyList();
        // names.add("matthew"); // <- 추가할 수 없다.
        assertEquals(0, names.size()); // Optional 이 더 나은듯
    }
}
