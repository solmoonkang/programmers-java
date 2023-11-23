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

        for (char c : s.toCharArray()) {
            // c를 적절히 변환하여 builder에 추가한다.
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        StrangeString strangeString = new StrangeString();
        System.out.println("Result: " + strangeString.solution("try hello world"));
    }
}
