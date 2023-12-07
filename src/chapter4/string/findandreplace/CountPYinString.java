package chapter4.string.findandreplace;

public class CountPYinString {

    /**
     * [ 문제 설명 ]
     * 대문자와 소문자가 섞여있는 문자열 s가 주어집니다.
     * s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요.
     * 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
     * 예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 문자열을 모두 소문자로 변환한다.
     * 2. "p"의 개수를 센다.
     *  A. 문자열에 등장하는 모든 "p"를 빈문자열 ""로 치환한다.
     *  B. 원본 문자열과 변환된 문자열의 길이 차이가 p의 개수
     * 3. 2와 같은 방식으로 y의 개수를 센다.
     * 4. 구한 p의 개수와 y의 개수를 비교한다.
     */
    boolean solution(String s) {
        // p와 y의 개수를 세기 위해 대소문자와 상관없이 문자를 비교하기 위해 문자열의 문자를 모두 소문자로 만들어준다.
        s = s.toLowerCase();
    }

    public static void main(String[] args) {

    }
}
