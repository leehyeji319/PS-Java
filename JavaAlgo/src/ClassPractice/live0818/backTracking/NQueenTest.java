package ClassPractice.live0818.backTracking;

import java.util.Scanner;

public class NQueenTest {

	static int N, cols[], ans;  //N : 판의 크기, cols[]: 행을 일차원배열로 보고(인덱스가 행번호)
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		cols = new int[N + 1]; //1행부터사용 
		ans = 0;
		
		setQueen(1);
		System.out.println(ans);
	}
	
	public static void setQueen(int rowNo) { //하나의퀸만 가능한 모든 곳에 놓아보기
		
		//유망성체크 
		//if (!isAvailable(rowNo - 1)) return; // 직전까지의 상황이 유망하지 않으면 현재 퀸 놓을 필요없으니 백트랙 가지치기!!
		
		
		if (rowNo > N) { //퀸을 다 놓았으면 (모든 퀸의 배치에 성공한 상황)
			ans++;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			//현재 놓으려고 하는 해당열에 퀸을 놓는다
			cols[rowNo] = i;
			if (isAvailable(rowNo)) //row-1이 아님. 지금 놓아보고 현재 선택이 잘못됏으면 안가고 다른선택을 하는거자
				setQueen(rowNo + 1); //그 다음 다음 퀸을 놓으러간다
		}
	}

	private static boolean isAvailable(int rowNo) {
		
		for (int j = 1; j < rowNo; j++) { // 내 직전위치를 다 비교하는거임
			if (cols[j] == cols[rowNo] || rowNo - j == Math.abs(cols[rowNo] - cols[j])) return false;
		} // 나를 기준으로 앞에 있는 애들하고만 비교하니까 행은 절댓값안씌우고
		
		return true;
	}
	
	
	

}
