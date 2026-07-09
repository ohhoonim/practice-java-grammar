package std.objects;

import java.util.Objects;

class ObjectsNullSafe {
    // java.util.Objects
    void main() {
        // 3-1. null 대체 및 조건부 반환, 
        String name = null;
        IO.print(
            Objects.requireNonNullElseGet(name, () -> fetchName() )
        );
    }

    String fetchName() {
        // db를 조회하는 로직
        return "dadada";
    }

}