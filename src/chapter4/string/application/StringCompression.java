package chapter4.string.application;

public class StringCompression {

    /**
     * [ 문제 설명 ]
     * 데이터 처리 전문가가 되고 싶은 "어피치"는 문자열을 압축하는 방법에 대해 공부를 하고 있습니다.
     * 최근에 대량의 데이터 처리를 위한 간단한 비손실 압축 방법에 대해 공부를 하고 있는데,
     * 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현하는 알고리즘을 공부하고 있습니다.
     * 간단한 예로 "aabbaccc"의 경우 "2a2ba3c"(문자가 반복되지 않아 한번만 나타난 경우 1은 생략함)와 같이 표현할 수 있는데,
     * 이러한 방식은 반복되는 문자가 적은 경우 압축률이 낮다는 단점이 있습니다.
     * "어피치"는 이러한 단점을 해결하기 위해 문자열을 1개 이상의 단위로 잘라서 압축하여 더 짧은 문자열로 표현할 수 있는지 방법을 찾아보려고 합니다.
     * 압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 반환하라.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 1부터 입력 문자열 s의 길이만큼 자를 문자열의 길이를 설정하며 반복한다.
     * 2. 설정된 길이만큼 문자열을 잘라 낸 token의 배열을 생성한다.
     * 3. 문자열을 비교하며, token의 배열을 하나의 문자열로 압축한다.
     * 4. 1~3 과정으로 압축된 문자열 중 가장 짧은 길이를 반환한다.
     */


    // 문자열을 압축하고, 압축된 문자열의 길이를 반환하는 compress() 메서드이다.
    private int compress(String source, int length) {
        // 압축한 문자열의 길이를 반환한다.
    }

    public int solution(String s) {
        // 가장 짧은 압축 문자열의 길이를 담을 변수를 선언한다.
        int min = Integer.MAX_VALUE;
        // 자를 문자열의 길이를 반복문을 이용하여 설정한다.
        for (int length = 1; length <= s.length(); length++) {
            // 문자열 압축 후 가장 짧은 길이를 선택한다.
        }
        return min;
    }

    public static void main(String[] args) {
        StringCompression compression = new StringCompression();
        System.out.println("Result: " + compression.solution("aabbaccc"));
        System.out.println("Result: " + compression.solution("ababcdcdababcdcd"));
        System.out.println("Result: " + compression.solution("xababcdcdababcdcd"));
    }
}
