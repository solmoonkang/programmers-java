package chapter4.string.rethinking;

public class ReverseNumberToArray {

    /**
     * [ 문제 설명 ]
     * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
     * 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 입력받은 숫자를 문자열로 변환한다.
     * 2. 문자열을 뒤집는다.
     * 3. 뒤집힌 문자열을 문자의 배열로 변환한다.
     * 4. 배열의 각 문자를 정수로 변환한다.
     */
    public int[] solution_arrayList(long n) {
        // 입력받은 숫자를 문자열로 변환한다.
        // 이는 정수 long형의 wrapper class인 Long의 static 메서드인 toString()을 사용한다.
        String str = Long.toString(n);
    }

    public static void main(String[] args) {
        ReverseNumberToArray array = new ReverseNumberToArray();
        System.out.println("Result: " + array);
    }
}
