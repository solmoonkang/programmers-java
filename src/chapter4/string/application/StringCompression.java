package chapter4.string.application;

import java.util.ArrayList;
import java.util.List;

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

    // compress 메서드에서 압축하기 위해서는 length 길이씩 문자열을 잘라야 한다.
    // 문자열을 length 길이씩 잘라 리스트에 추가하는 split() 메서드이다.
    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();

        // source를 length 길이만큼씩 잘라서 tokens 리스트에 추가한다.
        for (int startIndex = 0; startIndex < source.length(); startIndex += length) {
            int endIndex = startIndex + length;
            // 해당 범위가 문자열 범위 밖이라면 문자열의 끝까지 정상적으로 잘릴 수 있도록 다음과 같이 설정한다.
            if (endIndex > source.length()) endIndex = source.length();
            // 문자열을 startIndex로 잘라서 tokens 리스트에 추가한다.
            tokens.add(source.substring(startIndex, endIndex));
        }
        return tokens;
    }

    // 문자열을 압축하고, 압축된 문자열의 길이를 반환하는 compress() 메서드이다.
    private int compress(String source, int length) {
        // 문자열을 구성할 StringBuilder 객체를 생성한다.
        StringBuilder builder = new StringBuilder();
        // 연속으로 중복된 문자열들을 검사해야 하므로 직전에 등장한 문자열을 담는 last 변수를 선언한다.
        String last = "";
        // 또한, 그 등장 횟수를 담는 count 변수를 선언한다.
        int count = 0;

        for (String token : split(source, length)) {
            // 현재 검사하는 문자열 token이 직전에 등장한 문자열과 같다면, 등장횟수를 증가시켜준다.
            if (token.equals(last)) {
                count++;
            // 새로운 토큰 등장을 처리한다.
            } else {
                // 등장 횟수 count는 2 이상일 때만 압축 문자열에 포함되고,
                if (count > 1) builder.append(count);
                // 압축 문자열을 구성한 후에는 현재 검사한 token부터 다시 셀 수 있도록 last와 count를 업데이트한다.
                builder.append(last);
                last = token;
                count = 1;
            }
        }
        // 이렇게 for문을 나오면, 아직 마지막 토근은 last에 담긴 채로 압축 문자열에 포함되지 않은 상태이다.
        // 따라서, 압축 문자열을 구성하는 로직을 for문 이후에 1회 더 추가해야 한다.
        if (count > 1) builder.append(count);
        builder.append(last);

        return builder.length();
    }

    public int solution(String s) {
        // 가장 짧은 압축 문자열의 길이를 담을 변수를 선언한다.
        int min = Integer.MAX_VALUE;
        // 자를 문자열의 길이를 반복문을 이용하여 설정한다.
        for (int length = 1; length <= s.length(); length++) {
            // 문자열 압축 후 가장 짧은 길이를 선택한다.
            int compressed = compress(s, length);
            if (compressed < min) {
                min = compressed;
            }
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
