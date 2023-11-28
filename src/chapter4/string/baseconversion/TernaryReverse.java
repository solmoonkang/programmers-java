package chapter4.string.baseconversion;

public class TernaryReverse {

    /**
     * [ 문제 설명 ]
     * 자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 반환하라.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 정수를 3진법으로 변환한다.
     * 2. 변환된 문자열을 뒤집는다.
     * 3. 뒤집은 문자열을 정수로 변환한다.
     */
    public int solution(int n) {
        // 정수를 3진법으로 변환한다.
        String str = Integer.toString(n, 3);
        // 변환된 문자열을 StringBuilder를 이용하여 문자열을 뒤집어 준다.
        String reversed = new StringBuilder(str).reverse().toString();
        // 뒤집은 문자열을 다시 3진법에서 정수로 변환하여 반환한다.
        return Integer.valueOf(reversed, 3);
    }

    public static void main(String[] args) {
        TernaryReverse reverse = new TernaryReverse();
        System.out.println("Result: " + reverse.solution(45));
        System.out.println("Result: " + reverse.solution(125));
    }
}
