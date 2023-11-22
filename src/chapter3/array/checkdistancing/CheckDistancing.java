package chapter3.array.checkdistancing;

public class CheckDistancing {

    /**
     * [ 문제 설명 ]
     * 개발자를 희망하는 죠르디가 카카오에 면접을 보러 왔습니다.
     * 코로나 바이러스 감염 예방을 위해 응시자들은 거리를 둬서 대기를 해야하는데 개발 직군 면접인 만큼
     * 아래와 같은 규칙으로 대기실에 거리를 두고 앉도록 안내하고 있습니다.
     * 대기실은 5개이며, 각 대기실은 5x5 크기입니다. 거리두기를 위하여 응시자들 끼리는 맨해튼 거리1가 2 이하로 앉지 말아 주세요.
     * 단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용합니다.
     *
     * 5개의 대기실을 본 죠르디는 각 대기실에서 응시자들이 거리두기를 잘 기키고 있는지 알고 싶어졌습니다.
     * 자리에 앉아있는 응시자들의 정보와 대기실 구조를 대기실별로 담은 2차원 문자열 배열 places가 매개변수로 주어집니다.
     * 각 대기실별로 거리두기를 지키고 있으면 1을, 한 명이라도 지키지 않고 있으면 0을 배열에 담아 반환하라.
     *
     * places의 원소는 P,O,X로 이루어진 문자열입니다. places 원소의 길이(대기실 가로 길이) = 5
     * P는 응시자가 앉아있는 자리를 의미합니다.
     * O는 빈 테이블을 의미합니다.
     * X는 파티션을 의미합니다.
     */

    /**
     * [ 문제 풀이 흐름 ]
     * 1. 대기실의 모든 응시자 위치에 대해 반복한다.
     *  A. 상하좌우 중 빈 테이블이 있는 방향 대해 1-B로 진행한다.
     *  B. 빈 테이블과 인접한 위치 중 응시자가 있다면, 거리두기를 지키지 않은 것이다.
     * 2. 모든 응시자의 위치를 검사했으나 거리두기를 지키지 않은 경우를 발견하지 못했으면 거리두기를 지킨 것이다.
     */

    // (x, y)위치에 있는 응시자가 거리두기를 지키고 있는지 검사하려면 먼저 상하좌우를 검사해야 한다.
    // 상하좌우 검사를 위해 다음과 같이 dx, dy 를 선언한다.
    private static final int dx[] = {0, 0, -1, 1};
    private static final int dy[] = {-1, 1, 0, 0};

    // 해당 대기실에서 응시자의 위치(x, y)가 거리두기를 지키는지 검사하는 메서드이다.
    private boolean isDistanced(char[][] room, int x, int y) {
        // 위의 dx, dy 를 통해 상하좌우 위치를 가져오고, 해당 위치가 범위를 벗어나지 않는지 검사한다.
        for (int d= 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 2차원 배열의 length 필드를 이용해 범위 검사를 할 때는 y속성을 x속성보다 먼저 검사해야 안전하다.
            // 자바의 OR(||) 연산은 앞선 조건이 true이면, 뒤 조건을 연산하지 않는다.
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;

            // room[ny][nx]를 통해 다른 응시자에게 도달할 수 있는지 검사한다.
            // room[ny][nx]은 세 가지 중 하나의 값을 가지고 있다.
            switch (room[ny][nx]) {
                // 'X': 파티션일 경우, 이 위치를 이용하여 다른 응시자에게 도달할 수 없으므로 별도의 처리가 필요하지 않다.
                // 'P': 응시자일 경우, 맨해튼 거리 1에 다른 응시자가 있는 것이므로 거리두기가 지켜지지 않은 것이다.
                case 'P': return false;
                // 'O': 빈 테이블일 경우, 인접한 곳에 다른 응시자가 있다면 거리두기가 지켜지지 않은 것이다.
                case 'O':
                    // 인접한 곳에 다른 응시자가 있는지 검사한다.
                    break;
            }
        }
    }

    // 하나의 대기실은 char[][] room으로 표현되었다. 해당 대기실이 거리두기를 지키고 있는지 검사하는 메서드이다.
    private boolean isDistanced(char[][] room) {
        // 대기실의 모든 응시자의 위치에 대한 반복을 위해 응시자들이 앉아 있지 않는 자리는 continue; 를 통해 검사를 건너뛰도록 한다.
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] != 'P') continue;
                // 거리두기 검사
            }
        }
    }

    public int[] solution(String[][] places) {
        // 입력이 String[][] 형식으로 들어오고, 대기실 하나는 String[] 형식이 된다.
        // 각 원소에 관심이 있고, 각 대기실이 거리두기를 지키는지 검사할 것이므로 대기실을 char[][] 형식으로 만들어 거리두기 결과를 저장할 배열을 선언한다.
        int[] answer = new int[places.length];

        for (int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }
            // 거리두기 검사 후 answer에 기록한다.
        }
        return answer;
    }

    public static void main(String[] args) {
        CheckDistancing distancing = new CheckDistancing();
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println("Result: " + distancing);
    }
}
