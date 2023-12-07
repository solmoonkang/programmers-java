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
    boolean iterateThroughAll(String s) {
        // p와 y의 개수를 세기 위해 대소문자와 상관없이 문자를 비교하기 위해 문자열의 문자를 모두 소문자로 만들어준다.
        s = s.toLowerCase();

        // 문자열에서 p의 개수를 세기 위해 문자열에서 p를 모두 제거한다.
        // 이때, 제거된 개수, 즉 원본 문자열과 p를 제거한 문자열 길이 차이가 p의 개수가 된다.

        // 문자열에 등장하는 모든 "p"를 ""로 치환한다. 또한 앞서 구한 문자열의 길이를 원본 문자열의 길이에서 빼면 p의 개수를 구할 수 있다.
        int ps = s.length() - s.replace("p", "").length();
        // 마찬가지로 y의 개수도 구할 수 있다.
        int ys = s.length() - s.replace("y", "").length();

        // 두 값을 구했으므로 비교해서 반환한다.
        return ps == ys;
    }

    // 위와 같이 구현된 코드는 직접 루프를 돌며 p와 y의 개수를 세는 것보다 비효율적이다.
    // 직접 반복문을 구현한 코드는 한 번의 순회로 끝내지만, 위와 같이 내장 메서드를 사용하면 toLowerCase()와 replace()에서 전체 순회가 발생한다.
    // 해당 메서드들을 여러 번 호출하는 만큼 전체 순회 횟수가 많아져서 실행 시간이 늘어난다.

    // 하지만 시간 복잡도 측면에서 생각해보면 다른 결과가 나온다.
    // 문자열 길이를 n이라고 했을 때, 직접 순회하면 문자열 전체를 한 번 순회하는 데 소요되는 시간은 O(n)이다.
    // 위와 같이 toLowerCase()와 replace()는 각각 O(n)이 소요되어 소요되는 시간은 O(n) + O(n) + O(n) = O(n)이 된다.
    // 즉, 시간 복잡도는 두 방법 모두 동일하지만, 이는 세 번 순회하는 내장 라이브러리를 이용한 코드가 직접 순회하는 코드보다 느릴 수는 있다.
    boolean iterateOnce(String s) {
        int ps = 0;
        int ys = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case 'p' -> ps++;
                case 'y' -> ys++;
            }
        }
        return ps == ys;
    }

    public static void main(String[] args) {
        CountPYinString countPYinString = new CountPYinString();
        System.out.println("Result: " + countPYinString.iterateThroughAll("pPoooyY"));
        System.out.println("Result: " + countPYinString.iterateThroughAll("Pyy"));

        System.out.println("Result: " + countPYinString.iterateOnce("pPoooyY"));
        System.out.println("Result: " + countPYinString.iterateOnce("Pyy"));
    }
}
