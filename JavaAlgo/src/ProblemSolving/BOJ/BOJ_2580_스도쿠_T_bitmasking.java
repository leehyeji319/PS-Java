package ProblemSolving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2580_스도쿠_T_bitmasking {
    static int N = 9;
    static int map[][];
    static int[] row, col, squ[];
    static ArrayList<int[]> list;
    public static void main(String[] args) throws IOException {
        //행열을 관리하는 1차원 boolean 배열을 -> 비트마스킹을 사용해서 정수하나로 관리

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[N][N];
        row = new int[N];
        col = new int[N];
        squ = new int[3][3];
        list = new ArrayList<int[]>();

        int no = 0;
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().trim().toCharArray();
            for (int j = 0; j <N; j++) {
                no = map[i][j] = line[j] - '0';
                if (no == 0) {
                    list.add(new int[] {i,j});
                    continue;
                }
                //비어있지 않은 칸들은 자신이 속해있는 행렬박스에 비트 합치는 처리해줌
                row[i] |= 1<<no;
                col[j] |= 1<<no;
                squ[i/3][j/3] |= 1<<no;
            }
        }
        go(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            System.out.println(sb);
        }
    }

    private static boolean go(int index) {
        if (index == list.size()) return true; //사이즈가 됐다 -> 그 인덱스가 불가능하다? -> 가능한놈이엇으니까 리턴 트루
        int[] temp = list.get(index);
        int r = temp[0];
        int c = temp[1];

        for (int i = 0; i <= N; i++) {
            if((row[r] & (1 <<i)) != 0 || (col[c]&(1<<i)) != 0 || (squ[r/3][c/3]&(1<<i)) != 0) continue;
            map[r][c] = i;
            row[r] |= 1<<i;
            col[c] |= 1<<i;
            squ[r/3][c/3] |= 1<<i;
            if(go(index + 1)) return true;
            //return되지 않고 내려오는 경우 ->
            map[r][c] = 0;
            row[r] &= ~(1<<i);
            col[c] &= ~(1<<i);
            squ[r/3][c/3] &= ~(1<<i);
        }
        return false;
    }
}
