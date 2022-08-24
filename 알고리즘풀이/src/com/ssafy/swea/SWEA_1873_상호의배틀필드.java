package com.ssafy.swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1873_상호의배틀필드 {

	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		// TC 시작
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			// 맵 초기화
			char[][] field = new char[H][W];
			
			int currentRow = 0;
			int currentCol = 0;
			int currentDirectionState = 0;
			
			// field 맵 환경 설정
			for (int h = 0; h < H; h++) {
				String line = br.readLine();

				for (int w = 0; w < W; w++) {
					field[h][w] = line.charAt(w);
					if (field[h][w] == '<' || field[h][w] == '>' || field[h][w] == '^' || field[h][w] == 'v') {
						currentRow = h; // 전차 시작위치 좌표
						currentCol = w;
					}
					currentDirectionState = state(field[currentRow][currentCol]);
				}	
			}
			
			// 사용자가 입력할 명령갯수
			int userCommandCnt = Integer.parseInt(br.readLine());
			char[] userCommand = br.readLine().toCharArray();
			
			//사용자의 명령을 하나씩 수행
			//U, D, L, R 일 때. 현재 방향 상태를 설정해주고, 앞으로 나아갈 수 있는지 확인
			//S일 때, 현재 방향쪽으로 * 일땐 평지로 바꿔주고, # 일땐 break 문으로 나머지 조건은 그냥 idx+-만 해주면 된다.
			for (char command : userCommand) {
				int idx = 0;
				if (command == 'U') {
					currentDirectionState = 1;
					field[currentRow][currentCol] = '^';
					if (currentRow > 0 && field[currentRow - 1][currentCol] == '.') {

						field[currentRow - 1][currentCol] = field[currentRow][currentCol];
						field[currentRow][currentCol] = '.';
						currentRow--;
					}
				} else if (command == 'D') {
					currentDirectionState = 2;
					field[currentRow][currentCol] = 'v';
					if (currentRow < H - 1 && field[currentRow + 1][currentCol] == '.') {

						field[currentRow + 1][currentCol] = field[currentRow][currentCol];
						field[currentRow][currentCol] = '.';
						currentRow++;
					}
				} else if (command == 'L') {
					currentDirectionState = 3;
					field[currentRow][currentCol] = '<';
					if (currentCol > 0 && field[currentRow][currentCol - 1] == '.') {

						field[currentRow][currentCol - 1] = field[currentRow][currentCol];
						field[currentRow][currentCol] = '.';
						currentCol--;
					}
				} else if (command == 'R') {
					currentDirectionState = 4;
					field[currentRow][currentCol] = '>';
					if (currentCol < W - 1 && field[currentRow][currentCol + 1] == '.') {

						field[currentRow][currentCol + 1] = field[currentRow][currentCol];
						field[currentRow][currentCol] = '.';
						currentCol++;
					}
				} else if (command == 'S') {
					switch (currentDirectionState) {
					case 1: //up
						idx = currentRow;
						while (true) {
							if (idx - 1 < 0 || field[idx - 1][currentCol] == '#')
								break;
							if (field[idx - 1][currentCol] == '*') {
								field[idx - 1][currentCol] = '.';
								break;
							}
							idx--;
						}
						break;

					case 2: //down
						idx = currentRow;
						while (true) {
							if (idx + 1 >= H || field[idx + 1][currentCol] == '#')
								break;
							if (field[idx + 1][currentCol] == '*') {
								field[idx + 1][currentCol] = '.';
								break;
							}
							idx++;
						}
						break;
						
					case 3: //left
						idx = currentCol;
						while (true) {
							if (idx - 1 < 0 || field[currentRow][idx - 1] == '#')
								break;
							if (field[currentRow][idx - 1] == '*') {
								field[currentRow][idx - 1] = '.';
								break;
							}
							idx--;
						}
						break;
						
					case 4: //right
						idx = currentCol;
						while (true) {
							if (idx + 1 >= W || field[currentRow][idx + 1] == '#')
								break;
							if (field[currentRow][idx + 1] == '*') {
								field[currentRow][idx + 1] = '.';
								break;
							}
							idx++;
						}
						break;

					}
				}
			}
		
			System.out.printf("#%d ", t);
			for (int z = 0; z < H; z++) {
				for (int c = 0; c < W; c++) {
					System.out.print(field[z][c]);
				}
				System.out.println();
			}
		}
	}

	public static int state(char c) {
		if (c == '^') {
			return 1;
		} else if (c == 'v') {
			return 2;
		} else if (c == '<') {
			return 3;
		} else if (c == '>') {
			return 4;
		}
		return 0;
	}
}
