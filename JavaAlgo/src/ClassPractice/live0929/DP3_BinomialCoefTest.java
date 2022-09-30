package ClassPractice.live0929;

import java.util.Scanner;

public class DP3_BinomialCoefTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] B = new int[N + 1][N + 1]; //하나씩 더잡음 왜?
        // B[n][k] = B[n -1][k - 1] + B[n - 1][k];

        for (int i = 0; i <= N; i++) {
            int end = Math.min(i, K); //임시랑 k랑 둘 중에 작은거 까지만 돌래
            for (int j = 0; j <= K; j++) {
                if (j == 0 || j == i) {
                    B[i][j] = 1; //아무것도 안뽑거나, 전부 뽑거나의 경우는 1
                } else {
                    //직전까지 하나 적게 뽑아서 나를 포함해서 j개를 만들거나, 직전까지 j개를 뽑아서 나를 포함시키지 않거나.
                    B[i][j] = B[i - 1][j - 1] + B[i - 1][j];
                }
            }
        }

        System.out.println(B[N][K]);
     }
}
