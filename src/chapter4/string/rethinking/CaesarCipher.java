package chapter4.string.rethinking;

public class CaesarCipher {

    /**
     * [ 문제 설명 ]
     * 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
     * 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다.
     * "z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 입력 문자열의 모든 문자에 대해 반복한다.
     *  A. 알파벳이 아닌 경우 문자를 그대로 이어 붙인다.
     *  B. 알파벳인 경우 n만큼 밀어 이어 붙인다.
     */

    // 문자 c를 n만큼 민 새로운 문자를 계산하기 위해 메서드를 분리한다.
    // 입력 문자를 n만큼 민 문자를 반환하는 push() 메서드를 선언한다.
    private char push(char c, int n) {
        // c를 n만큼 밀어 반환한다.
    }

    public String solution(String s, int n) {
        // 입력받은 문자열을 순회하며 문자를 하나씩 이어 붙여야 하므로 StringBuilder를 사용한다.
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            // c를 n만큼 민 문자를 builder에 이어 붙인다.
        }
        return builder.toString();
    }

    public static void main(String[] args) {

    }
}
