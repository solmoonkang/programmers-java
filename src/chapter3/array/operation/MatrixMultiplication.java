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

        // 반복문을 돌며, 각 원소에 알맞은 값을 찾는다.
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr[i][j] = 0;
                // 행렬의 곱셈 결과는 곱해지는 두 행렬의 행과 열을 순회하면서 곱한 값들을 모두 더해줘야 한다.
                for (int k = 0; k < arr1[i].length; k++) {
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        MatrixMultiplication multiplication = new MatrixMultiplication();
        int[][] firstArr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] firstArr2 = {{3, 3}, {3, 3}};
        System.out.println("Result: " + Arrays.deepToString(multiplication.solution(firstArr1, firstArr2)));

        int[][] secondArr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] secondArr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        System.out.println("Result: " + Arrays.deepToString(multiplication.solution(secondArr1, secondArr2)));
    }
}
