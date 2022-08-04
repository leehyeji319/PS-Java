package 스위치켜고끄기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int l = arr.length;
			
			if (gender == 1) {
				int idx = 1;
				while (true) {
					int new_idx = num * idx - 1;
					
					if (new_idx >= l) break;
					
					if (arr[new_idx] == 1) arr[new_idx] = 0;
					else arr[new_idx] = 1;
					
					idx++;
				}				
			} else {
				int idx = 1;
				num--;
				while(true) {
					int left = num - idx;
					int right = num + idx;
					if (num == 0 || num == arr.length - 1) break;
					if (left < 0 || right >= arr.length) break;
					if (arr[left] != arr[right]) break;
					else {
						if (arr[left] == 0) {
							arr[left] = 1;
							arr[right] = 1;
						} else {
							arr[left] = 0;
							arr[right] = 0;
						}
					}
					idx++;
				}
				if (arr[num] == 0) arr[num] = 1;
				else arr[num] = 0;
				
			}
		}
	
		
		for (int ans = 0; ans < arr.length; ans++)
			sb.append(arr[ans]).append((ans + 1) % 20 == 0? "\n": " ");
		System.out.println(sb);
	}
}
