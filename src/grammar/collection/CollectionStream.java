package grammar.collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectionStream {
    
    @Test
    @DisplayName("intermediate와 terminal operation")
    public void operationType() {

        List<Widget> widgets = List.of(
            new Widget("who are you", "input", Color.RED, 12),
            new Widget("main grid", "table", Color.GREEN, 32),
            new Widget("some link", "link", Color.RED, 7)
        );
        int sum = widgets.stream()
                      .filter(w -> w.color() == Color.RED) // intermediate
                      .mapToInt(w -> w.weight()) // intermediate
                      .sum(); //terminal

        assertEquals(19, sum);
    }

    record Widget(
        String title, String type, Color color, int weight
    ){}

    enum Color {
        RED,
        WHITE,
        BLACK,
        GREEN,
        BLUE
    }
}
