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

    public int[] solution(String[][] places) {

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
