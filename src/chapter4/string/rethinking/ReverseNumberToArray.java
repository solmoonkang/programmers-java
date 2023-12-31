package chapter4.string.rethinking;

import java.util.Arrays;

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
    public int[] solution(long n) {
        // 입력받은 숫자를 문자열로 변환한다.
        // 이는 정수 long형의 wrapper class인 Long의 static 메서드인 toString()을 사용한다.
        String str = Long.toString(n);
        // StringBuilder 클래스를 이용해서 문자열을 뒤집는다.
        String reversed = new StringBuilder(str).reverse().toString();
        // 뒤집힌 문자열은 String 클래스의 toCharArray() 메서드를 사용하여 문자 배열로 변환할 수 있다.
        char[] arr = reversed.toCharArray();

        // 마지막으로 이를 정수로 변환하여 int형 배열을 만들어 줄 수 있다.
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i] - '0';
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseNumberToArray array = new ReverseNumberToArray();
        System.out.println("Result: " + Arrays.toString(array.solution(12345)));
    }
}
