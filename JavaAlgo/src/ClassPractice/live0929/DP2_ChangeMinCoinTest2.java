package ClassPractice.live0929;

import java.util.Arrays;
import java.util.Scanner;

public class DP2_ChangeMinCoinTest2 {

    //4,6원 화폐단위로 고정, 동전 개수 무제한
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt(); //목표금액, <= 100000

        int[] D = new int[money + 1]; // D[i]: i금액을 만드는 최소 동전 수

        int INF = 100000; //가장 작은 화폐단위를 가장 많이 써도 만들수 없는 큰 값, +1 처리시 오버플로우 발생하지 않는 값
                    // 1원단위가 없다면, 가능한 최소 동전수가 가장 많은건,
                    // 가장 작은 화폐단위를 제일 많이 쓸때가 동전개수는 제일 많을 수 있겠지?
        D[0] = 0; //실수할것 같으면 넣어라. 0원에 대한 최적해는 0
        for (int i = 1; i <= money; i++) {
            int min = INF;
            if (i >= 4) min = Math.min(min, D[i - 4] + 1);
            if (i >= 6) min = Math.min(min, D[i - 6] + 1);

            D[i] = min;
        }
        System.out.println(Arrays.toString(D)); //동적테이블에 채워진 값
        System.out.println(D[money] == INF ? -1 : D[money]);
    }
}
