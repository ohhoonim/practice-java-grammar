package grammar.array;

public class Array {
    public static void main(String[] args) {
        // 배열 생성법 1
        String[] names = new String[5];
        names[0] = "카스티엘";
        names[1] = "샘 윈체스터";
        names[2] = "딘 윈체스터";
        IO.println(names[2]);
        IO.println(names.length); // 한번 정해진 배열의 크기는 바꿀수 없다.

        names[1] = "가드리엘";
        IO.println(names[1]);

        IO.println(names[4]); // null

        // IO.println(names[5]); // Error 자바에서는 Exception이라고 한다. out of bounds

        IO.println(names.length); // 배열의 크기

        // 배열 생성법 2
        int[] numbers = { 1, 2, 3, 4, 5 };
        IO.println(numbers[0]); // 1

        // 2차원 배열 생성 1
        int[][] demension_1 = new int[3][5];
        IO.println(demension_1.length); // 3
        IO.println(demension_1[0].length); // 5

        // 2차원 배열 생성 2
        int[][] demension_2 = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 }
        };
        IO.println(demension_2.length); // 3
        IO.println(demension_2[0].length); // 5
        IO.println(demension_2[1][4]); // 10

        
        IO.println(demension_2.length); // 3
        IO.println(demension_2.length); // 3
        IO.println(demension_2.length); // 3
        IO.println(demension_2[0].length); // 5
        IO.println(demension_2[1][4]); // 10
        IO.println(demension_2[0].length); // 5
        IO.println(demension_2[1][4]); // 10
        IO.println(demension_2[0].length); // 5
        IO.println(demension_2[1][4]); // 10

    }
}
