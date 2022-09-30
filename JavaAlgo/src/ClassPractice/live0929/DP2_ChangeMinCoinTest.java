package ClassPractice.live0929;

import java.util.Arrays;
import java.util.Scanner;

public class DP2_ChangeMinCoinTest {

    //1,4,6원 화폐단위로 고정, 동전 개수 무제한
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();

        int[] D = new int[money + 1]; // D[i]: i금액을 만드는 최소 동전 수

        int INF = Integer.MAX_VALUE;
        D[0] = 0; //실수할것 같으면 넣어라. 0원에 대한 최적해는 0
        for (int i = 1; i <= money; i++) {
            int min = INF;
            min = Math.min(min, D[i - 1] + 1); //1원을 뺀 나머지 금액의 최적해에 하나를 더했을 때
            if (i >= 4) min = Math.min(min, D[i - 4] + 1);
            if (i >= 6) min = Math.min(min, D[i - 6] + 1);

            D[i] = min;
        }
        System.out.println(Arrays.toString(D)); //동적테이블에 채워진 값
        System.out.println(D[money]);
    }
}
