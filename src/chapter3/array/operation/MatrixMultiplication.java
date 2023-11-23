package chapter3.array.operation;

import java.util.Arrays;

public class MatrixMultiplication {

    /**
     * [ 문제 설명 ]
     * 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
     *
     * [ 제한 조건 ]
     * 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
     * 행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
     * 곱할 수 있는 배열만 주어집니다.
     */
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 행렬의 곱셈은 왼쪽 행렬의 행과 오른쪽 행렬의 열이 짝을 이루어서 수행한다.
        // 왼쪽 행렬은 행 단위로, 오른쪽 행렬은 열 단위로 계산되며 같은 순서에 있는 숫자끼리 곱해서 더하면 된다.
        int[][] arr = new int[arr1.length][arr2[0].length];
        // 행렬 곱셈
        return arr;
    }

    public static void main(String[] args) {
        MatrixMultiplication multiplication = new MatrixMultiplication();
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        System.out.println("Result: " + Arrays.deepToString(multiplication.solution(arr1, arr2)));
    }
}
