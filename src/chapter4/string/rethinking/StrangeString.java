package chapter4.string.rethinking;

public class StrangeString {

    /**
     * [ 문제 설명 ]
     * 문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
     * 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
     *
     * [ 제한 사항 ]
     * 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
     * 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 문자열의 모든 문자에 대해 반복한다.
     *  A. 문자가 공백 문자일 경우
     *      i. 그대로 이어 붙인다.
     *      ii. 다음 등장하는 알파벳은 대문자이다.
     *  B. 공백 문자가 아닌 경우
     *      i. 대소문자를 변환하여 이어 붙인다.
     *      ii. 다음 등장하는 알파벳의 대소문자는 현재 반환하는 문자와 반대이다.
     * 2. 구성한 문자열을 반환한다.
     */
    public String solution(String s) {
        // 문자열 구성을 위한 StringBuilder 클래스와 문자 순회 루프를 구현한다.
        StringBuilder builder = new StringBuilder();
        // 알파벳이 대문자로, 소문자로 변환되어야 할지 나타내는 toUpper 변수를 선언하여 대소문자 상태를 가지고 있는다.
        boolean toUpper = true;

        for (char c : s.toCharArray()) {
            // 검사하는 문자가 공백 문자일 경우에 대해 검사한다. Character 클래스의 문자가 알파벳인지 검사하는 isAlphabetic() 메서드를 사용한다.
            if (!Character.isAlphabetic(c)) {
                // 공백 문자는 별도의 변환 과정 없이 그대로 이어 붙여야 한다. 알파벳 검사에 통과하지 못한 문자들은 builder에 그대로 이어 붙인다.
                builder.append(c);
                // 이제 공백 문자를 만나면 toUpper 변수를 true로 설정하여 다음 만나는 알파벳이 대문자로 변환될 수 있도록 한다.
                toUpper = true;
            } else {
                // 공백 문자가 등장했다면 다음 등장 알파벳은 단어의 시작이므로 무조건 대문자로 변환되어야 한다.
                // 따라서 toUpper를 사용하여 문자의 대소문자를 변환하고, StringBuilder 객체에 이어 붙인다. 그리고 문자의 대소문자 여부를 변경한다.
                if (toUpper) {
                    builder.append(Character.toUpperCase(c));
                } else {
                    builder.append(Character.toLowerCase(c));
                }
                // 현재 문자를 대문자 혹은 소문자로 변환했으므로, 단어의 다음 문자는 그 반대로 변환되어야 한다. 따라서, toUpper 값을 반전시켜 준다.
                toUpper = !toUpper;
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        StrangeString strangeString = new StrangeString();
        System.out.println("Result: " + strangeString.solution("try hello world"));
    }
}
