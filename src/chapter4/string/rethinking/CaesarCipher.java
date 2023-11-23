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
        // 알파벳이 아닌 문자는 시저 암호에 영향을 받지 않으므로 isAlphabetic() 메서드를 사용하여 알파벳이 아닌 문자는 그대로 반환될 수 있게 한다.
        if (!Character.isAlphabetic(c)) return c;

        // 대/소문자를 무시하고 생각하면 알파벳은 a부터 z까지 있으며, a가 0, b가 1이라고 했을 때, z는 25가 된다.
        // 그리고 z에서 1을 밀면 26이 되는 것이 아닌 0으로 되돌아와야 한다. 이는 알파벳이 대/소문자에 상관없이 공통적으로 적용된다.
        // 즉, 알파벳을 0~25로 변환할 수 있다면 n만큼 미는 것은 같은 로직을 적용시킬 수 있다.

        // 알파벳을 0~25로 변환하는 것은 숫자를 표현하는 문자를 정수로 변환하는 것과 같다.
        // 대문자는 'A'부터 소문자는 'a'부터 시작하므로 이를 offset 변수에 저장한다.
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        // 이 변수를 사용하여 알파벳의 변환된 값 position을 다음과 같이 계산한다.
        int position = c - offset;
        // 이제 position을 n만큼 밀어주면 된다. 이때, 마지막 위치에 도달하면 0부터 다시 시작해야 한다.
        // 알파벳은 a~z까지 있으므로 가능한 position은 0부터 ('Z'-'A')까지이다. 이 범위를 벗어날 때 0부터 시작되게 하는 것은 다음과 같이 구현한다.
        position = (position + n) % ('Z' - 'A' + 1);
        // offset과 position을 이용해서 n만큼 밀린 문자를 반환한다.
        return (char) (offset + position);
    }

    public String solution(String s, int n) {
        // 입력받은 문자열을 순회하며 문자를 하나씩 이어 붙여야 하므로 StringBuilder를 사용한다.
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            // 완성된 push() 메서드를 사용하여 solution() 메서드의 반복문을 완성시킨다.
            builder.append(push(c, n));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher();
        System.out.println("Result: " + cipher.solution("AB", 1));
        System.out.println("Result: " + cipher.solution("z", 1));
    }
}
