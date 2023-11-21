package chapter3.array.drawingstars;

import java.util.ArrayList;
import java.util.List;

public class DrawingStars {

    /*
      [ 문제 설명 ]
      Ax + By + C = 0으로 표현할 수 있는 n개의 직선이 주어질 때, 이 직선의 교점 중 정수 좌표에 별을 그리려 합니다.
      직선A, B, C에 대한 정보가 담긴 배열 line이 매개변수로 주어집니다. 이때 모든 별을 포함하는 최소 사각형을 반환하라.
     */

     /*
      [ 제한 사항 ]
      line의 세로(행) 길이는 2 이상 1,000 이하인 자연수입니다.
      line의 가로(열) 길이는 3입니다.
      line의 각 원소는 [A, B, C] 형태입니다.
      A, B, C는 -100,000 이상 100,000 이하인 정수입니다.
      무수히 많은 교점이 생기는 직선 쌍은 주어지지 않습니다.
      A = 0이면서 B = 0인 경우는 주어지지 않습니다.
      정답은 1,000 * 1,000 크기 이내에서 표현됩니다.
      별이 한 개 이상 그려지는 입력만 주어집니다.
     */

    /*
     [ 문제 풀이 흐름 ]
     1. 모든 직선 쌍에 대해서 반복한다.
        A. 교점 좌표 구하기.
        B. 정수 좌표만 저장하기.
      2. 저장된 정수들에 대해 x, y 좌표의 최댓값, 최솟값 구하기.
      3. 구한 최댓, 최솟값을 이용하여 2차원 배열의 크기를 결정한다.
      4. 2차원 배열에 별을 표시한다.
      5. 문자열 배열로 변환한 후 반환한다.
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

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(
                        line[i][0], line[i][1], line[i][2],
                        line[j][0], line[j][1], line[i][2]
                );

                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO:
    }
}
