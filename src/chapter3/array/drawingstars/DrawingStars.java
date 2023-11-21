package chapter3.array.drawingstars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawingStars {

    /**
     * [ 문제 설명 ]
     * Ax + By + C = 0으로 표현할 수 있는 n개의 직선이 주어질 때, 이 직선의 교점 중 정수 좌표에 별을 그리려 합니다.
     * 직선A, B, C에 대한 정보가 담긴 배열 line이 매개변수로 주어집니다. 이때 모든 별을 포함하는 최소 사각형을 반환하라.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 모든 직선 쌍에 대해서 반복한다.
     *   A. 교점 좌표 구하기.
     *   B. 정수 좌표만 저장하기.
     * 2. 저장된 정수들에 대해 x, y 좌표의 최댓값, 최솟값 구하기.
     * 3. 구한 최댓, 최솟값을 이용하여 2차원 배열의 크기를 결정한다.
     * 4. 2차원 배열에 별을 표시한다.
     * 5. 문자열 배열로 변환한 후 반환한다.
     */
    private static class Point {
        // 좌표를 표현해야 하므로, 좌표를 나타내는 Pont 클래스를 구현한다.

        // 데이터를 나타내는 클래스이므로, final 키워드를 통해 불변성을 갖게 한다.
        // 또한 좌표 범위가 주어지지 않았으므로 long타입으로 선언하여 오버플로우 발생을 막는다.
        private final long x, y;

        public Point(long x,
                     long y) {
            this.x = x;
            this.y = y;
        }
    }

    // 두 직선의 교점을 구하는 메서드이다. (두 직선의 정보를 매개변수로, 해당 교점이 정수이면 Point 객체를 반환한다.)
    private Point intersection(long a1, long b1, long c1,
                               long a2, long b2, long c2) {
        // a1x + b1y + c1 = 0, a2x + b2y + c2 = 0 다음과 같은 두 직선이 있다고 가정하자.

        // 두 직선의 교점은 아래와 같이 계산된다.
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        // 두 직선의 교점을 구한 뒤, 해당 교점이 정수일 경우에만 반환하도록 한다. 그렇지 않을 경우에는 null을 반환한다.
        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long) x, (long) y);
    }

    // 저장된 정수들에 대해 x, y 좌표의 최솟값을 구하는 메서드이다.
    private Point getMinimumPoint(List<Point> points) {
        // points list 안의 모든 Point 객체를 순회하면서 가장 작은 x, y 값을 찾고, 이를 사용하여 Point 객체를 만들어 반환한다.
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }

        return new Point(x, y);
    }

    private Point getMaximumPoint(List<Point> points) {
        // getMinimumPoint() 메서드와 마찬가지로 구현해준다.
        // 단, x, y의 초기값과 for문 내 비교 연산자의 방향을 반대로 설정해준다.
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }

        return new Point(x, y);
    }

    public String[] solution(int[][] line) {
        // 모든 직선 쌍에 대해서 반복한다.
        // line[i], line[j]를 이용하여 [교점 좌표 구하기], [정수 좌표만 저장] 메서드를 수행한다.
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(
                        line[i][0], line[i][1], line[i][2],
                        line[j][0], line[j][1], line[j][2]
                );

                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        // 구한 최댓값과 최솟값을 이용하여 2차원 배열의 크기를 결정한다.
        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);

        // 배열의 크기를 구해야 하므로 minimum과 maximum을 사용하여 구한 값에 1을 더해야 한다.
        int width = (int) (maximum.x - minimum.x + 1);
        int height = (int) (maximum.y - minimum.y + 1);

        // '.' 문자를 이용하여 각 좌표를 표시하기 때문에 char 자료형의 2차원 배열로 선언해준다.
        // 또한, 2차원 배열은 y축의 성분으로 먼저 접근하기 때문에 높이 성분을 명시해주어야 한다.
        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        // 별을 찍을 위치인 교점 정보는 points 변수에 있으니, 이를 순회하면서 별을 찍어주는 메서드이다.
        // 단, 2차원 배열에서 (0, 0)은 실제 교점의 (0, 0)이 아니다.
        // 교점을 표현할 수 있는 가장 작은 크기로 2차원 배열을 선언했기 때문에, 별을 제대로 표시하려면 좌표를 변경시켜야 한다.
        for (Point p : points) {
            // 2차원 배열의 좌표는 일반 좌표와 비교했을 때, y축 방향이 반대고 minimum과 maximum으로 그 크기가 결정된다.
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y);
            // y 좌표로 먼저 접근한 후, x 좌표로 접근해야 한다.
            arr[y][x] = '*';
        }

        // 마지막으로 문자열 배열로 변환하여 반환해야 한다.
        // 이는 String 배열을 선언한 후 2차원 배열을 구성하는 1차원 배열들을 String으로 변환해준다.
        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        DrawingStars drawingStars = new DrawingStars();
        int[][] lines1 = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        int[][] lines2 = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};

        System.out.println("Result: " + Arrays.toString(drawingStars.solution(lines1)));
        System.out.println("Result: " + Arrays.toString(drawingStars.solution(lines2)));
    }
}
