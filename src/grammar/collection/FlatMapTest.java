package grammar.collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;

public class FlatMapTest {
    
    @Test
    public void flatMap() {
        UUID uniqueId = UUID.randomUUID();
        List<Note> notes_2025 = List.of(
            new Note(UUID.randomUUID(), "어제의 노트", "내용 없음"),
            new Note(uniqueId, "오늘의 노트", "내용 없음"),
            new Note(UUID.randomUUID(), "내일의의 노트", "내용 없음")
        );

        List<Note> notes_2026 = List.of(
            new Note(UUID.randomUUID(), "2026 어제의 노트", "내용 없음"),
            new Note(uniqueId, "2026 오늘의 노트", "내용 없음"),
            new Note(UUID.randomUUID(), "2026 내일의의 노트", "내용 없음")
        );
        var diary2025 = new Area(UUID.randomUUID(), "2025", "2025년도 일기장", notes_2025);
        var diary2026 = new Area(UUID.randomUUID(), "2026", "2026년도 일기장", notes_2026);

        List<Area> areas = List.of(diary2025, diary2026);

        var count = areas.stream().flatMap(area -> area.notes().stream())
            .map(note -> note.noteId()).distinct().toList();
        assertEquals(5, count.size());

        System.out.println(count);
    }


    public record Note(
        UUID noteId, String title, String content
    ) {}
    public record Area(
        UUID areaId, String title, String content, List<Note> notes
    ) {}

}
