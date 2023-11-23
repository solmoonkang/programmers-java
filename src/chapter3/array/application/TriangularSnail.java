package chapter3.array.application;

import java.util.Arrays;

public class TriangularSnail {

    /**
     * [ 문제 설명 ]
     * 정수 n이 매개변수로 주어집니다.
     * 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
     * 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 반환하라.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. N x N 2차원 배열 선언한다.
     * 2. 숫자를 채울 현재 위치를 (0, 0)으로 설정한다.
     * 3. 방향에 따라 이동할 수 없을 때까지 반복하면서 숫자를 채운다.
     *  A. 아래로 이동하면서 숫자 채우기.
     *  B. 오른쪽으로 이동하면서 숫자 채우기.
     *  C. 왼쪽 위로 이동하면서 숫자 채우기.
     * 4. 채워진 숫자를 차례대로 1차원 배열에 옮겨서 반환한다.
     */

    public int[] existingCode(int n) {
        // 가로 n과 세로 n의 삼각형을 표현하기 위해 n x n 2차원 배열을 선언한다.
        int[][] triangle = new int[n][n];
        // 숫자를 triangle에 기록할 때마다 1씩 증가한다. (채워넣을 변수)
        int v = 1;
        // 2차원 배열에 숫자를 넣을 위치를 변수로 생성하고, (0, 0)으로 초기화한다. 이는 배열의 (0, 0) 위치부터 숫자를 넣어주기 위함이다.
        // x, y는 위치 변수로 숫자를 기록할 때마다 아래, 오른쪽, 왼쪽 위 중 하나의 방향으로 이동한다.
        int x = 0;
        int y = 0;

        // 아래, 오른쪽, 왼쪽 위로 이동하면서 숫자를 triangle에 계속해서 채워 넣어야 하기 때문에, 무한 루프를 사용한다.
        while (true) {
            // 아래로 이동
            while (true) {
                // 숫자를 채워 넣은 후 아래로 이동할 수 있으면 반복해서 아래로 진행해야 한다. 아래로 진행하는 것은 y값이 증가하는 것이다.
                triangle[y][x] = v++;
                // 해당 반복문을 빠져나왔다는 것은 더 이상 아래로 진행할 수 없음을 의미한다.
                // 아래로 진행할 수 없다면 오른쪽으로 진행해야 하지만, 오른쪽으로 진행할 수 없는 경우도 존재한다.
                // 아래로 진행하는 것이 삼각형을 채우는 마지막 진행 방향이라면 여기서 숫자 채우는 것을 멈춰야 한다.
                if (y + 1 == n || triangle[y + 1][x] != 0) break;
                y += 1;
            }
            // 따라서, 오른쪽으로 이동할 수 없는 경우에는 반복문을 탈출하도록 작성해서 오른쪽으로 이동할 수 있을 때만 진행하도록 해야 한다.
            if (x + 1 == n || triangle[y][x + 1] != 0) break;
            x += 1;

            // 오른쪽으로 이동
            while (true) {
                // 마찬가지로 같은 원리로 x, y 값만 바꾸어 주면 된다.
                triangle[y][x] = v++;
                if (x + 1 == n || triangle[y][x + 1] != 0) break;
                x += 1;
            }
            if (triangle[y - 1][x - 1] != 0) break;
            x -= 1;
            y -= 1;

            // 왼쪽 위로 이동
            while (true) {
                // 마찬가지로 같은 원리로 x, y 값만 바꾸어 주면 된다.
                triangle[y][x] = v++;
                if (triangle[y - 1][x - 1] != 0) break;
                x -= 1;
                y -= 1;
            }
            if (y + 1 == n || triangle[y + 1][x] != 0) break;
            y += 1;
        }

        // triangle에 모든 숫자들이 채워지고, 채운 숫자들을 1차원 배열로 구성해서 반환한다.
        // v 변수에는 마지막에 채워 놓은 숫자 +1이 들어 있으므로 v - 1이 채워 넣은 숫자 개수가 된다.
        int[] result = new int[v - 1];

        // 2차원 배열에서는 삼각형이 왼쪽으로 몰려 있는 직각 삼각형으로 들어있다는 것을 이용하여 이중 반복문으로 1차원 배열에 숫자를 넣어줄 수 있다.
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }
        return result;
    }


    // dx와 dy는 각각 'x의 변화량'과 'y의 변화량'을 의미한다. 이는 int[] dx, dy = {아래, 오른쪽, 왼쪽 위}; 가 된다.
    private static final int[] dx = {0, -1, 1};
    private static final int[] dy = {1, -1, 0};

    public int[] improvedCode(int n) {
        int[][] triangle = new int[n][n];
        // 배열 dx, dy의 인덱스는 방향을 가리킨다. 이 방향은 숫자를 채워 나감에 따라 변하므로 위치 변수와 함께 방향 변수(int d)를 추가한다.
        int v = 1;
        int x = 0;
        int y = 0;
        int d = 0;

        // 조건을 만족하는 한 숫자를 계속해서 채워 넣어야 하므로 이전과 마찬가지로 무한루프로 구성한다.
        while (true) {
            // triangle에 숫자를 채워 넣는다.
            triangle[y][x] = v++;

            // 진행 방향은 d변수에 저장되어 있다. (배열의 인덱스가 방향이 된다.)
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 더 이상 진행할 수 없을 경우에 대한 처리를 해줘야 한다.
            // nx == n || ny == n 의 경우, 아래 방향이나 오른쪽으로 진행할 때의 조건이다.
            // nx == -1 || ny == -1 의 경우, 왼쪽 위로 진행할 때의 조건이다.
            // triangle[nx][ny] != 0 의 경우, 이미 숫자가 써있는 칸에 도달했음을 검사한다.
            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                // 위의 조건에 걸리면 현재 진행 방향으로 더 이상 진행할 수 없다는 의미이다. 따라서, 진행 방향을 바꾸어 주어야 한다.
                // 현재 dx, dy를 구성하는 방향은 아래, 오른쪽, 왼쪽 위 순서로 구성되며, 방향 변수 d의 값을 1 증가시키는 것으로 방향을 바꿀 수 있다.
                // 또한, 방향 개수가 3개이므로 나머지 연산을 이용하여 왼쪽 위에서 아래 방향으로 전환될 수 있게 한다.
                d = (d + 1) % 3;

                // 이제 전환된 방향을 이용해서 다음 위치를 계산할 수 있다.
                nx = x + dx[d];
                ny = y + dy[d];

                // 모든 숫자가 다 채워졌을 경우, 전환된 방향으로도 진행을 못한다. 해당 경우에는 break; 를 통해 숫자 채우기를 종료한다.
                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break;
            }
            // if 문이 종료되고 나면 nx, ny에는 진행할 수 있는 방향 위치가 들어있다. 따라서, 다음과 같이 현재 위치를 업데이트한다.
            x = nx;
            y = ny;
        }

        int[] result = new int[v - 1];

        // 2차원 배열에서는 삼각형이 왼쪽으로 몰려 있는 직각 삼각형으로 들어있다는 것을 이용하여 이중 반복문으로 1차원 배열에 숫자를 넣어줄 수 있다.
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TriangularSnail snail = new TriangularSnail();
        System.out.println("Result: " + Arrays.toString(snail.improvedCode(4)));
        System.out.println("Result: " + Arrays.toString(snail.improvedCode(6)));
    }
}
