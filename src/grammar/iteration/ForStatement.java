package grammar.iteration;

public class ForStatement {
    public static void main(String[] args) {
        // 1. 문자를 10번 출력하기

        IO.println("한글");
        IO.println("한글");
        IO.println("한글");
        IO.println("한글");
        IO.println("한글");
        IO.println("한글");
        IO.println("한글");
        IO.println("한글");
        IO.println("한글");
        IO.println("한글");
        
        // 1-2. for문을 이용하면..

        for(int i = 0; i < 10; i++) {
            IO.println("한글");
        }
        
        // 1-3. 순번도 넣어주기
        //  초기값 ; 종료조건 ; 증가방법
        // 위 세가지 조건을 이용하면 몇 번 반복하는지 알 수 있다. 

        for(int i = 0; i < 10; i++) {
            IO.println(i + "한글");
        }

        // 2. 배열과 함께 사용하기
        String[] fruit = {"사과", "딸기", "오이", "귤", "파인애플", "바나나", "참외" };
        // 배열의 길이를 알아야 한다. 
        int size = fruit.length;
        for(int i = 0; i < size; i++) {
            IO.println(fruit[i]);
        }
        
        // 2-1. 반대순서로 출력하려면
        for(int i = size - 1; i > -1; i--) {
            IO.println(fruit[i]);
        }

        // 3. 2차원 배열의 반복 // 반복문 중첩
        int [][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                IO.println(matrix[i][j]);
            }
        }

        // 4. 배열 처리결과를 다른 배열에 저장하기
        int[] source = {1,2,3,4,5};
        int[] result = new int[5];

        for(int i = 0; i < result.length; i++) {
            result[i] = source[i];
        }

        // 출력하기
        for(int i = 0; i < result.length; i++) {
            IO.println(result[i]);
        }

    }
}