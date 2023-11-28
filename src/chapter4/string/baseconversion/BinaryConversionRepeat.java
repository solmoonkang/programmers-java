package chapter4.string.baseconversion;

import java.util.Arrays;

public class BinaryConversionRepeat {

    /**
     * [ 문제 설명 ]
     * 0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.
     *
     * x의 모든 0을 제거합니다.
     * x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
     * 예를 들어, x = "0111010"이라면, x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.
     *
     * 0과 1로 이루어진 문자열 s가 매개변수로 주어집니다.
     * s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때, 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 반환하라.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 검사하는 문자열이 "1"이 될 때까지 반복한다.
     *  A. 문자열에 포함된 0의 개수를 센다.
     *      i. 0의 개수와 제거 횟수를 누적한다.
     *  B. 나머지 1의 개수를 사용해서 2진법으로 변환하여 1부터 반복한다.
     * 2. 누적된 제거 횟수와 0의 개수를 배열로 반환한다.
     */
    // 0의 개수를 세기 위해 문자열을 전달받아 0의 개수를 세는 메서드이다.
    private int countZeros(String s) {
        int zeros = 0;
        // 문자열에 포함된 0의 개수를 센다.
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }
        return zeros;
    }

    public int[] solution(String s) {
        // 변환 횟수와 제거된 0의 개수를 담는 변수를 선언한다.
        int loop = 0;
        int removed = 0;

        // s가 "1"이 될 때까지 반복한다.
        while (!s.equals("1")) {
            // 변환할 때, 변환 횟수와 제거된 0의 개수를 누적한다.
            int zeros = countZeros(s);
            loop += 1;
            removed += zeros;


        }

        return new int[] {loop, removed};
    }

    public static void main(String[] args) {
        BinaryConversionRepeat repeat = new BinaryConversionRepeat();
        System.out.println("Result: " + Arrays.toString(repeat.solution("110010101001")));
        System.out.println("Result: " + Arrays.toString(repeat.solution("01110")));
        System.out.println("Result: " + Arrays.toString(repeat.solution("1111111")));
    }
}
