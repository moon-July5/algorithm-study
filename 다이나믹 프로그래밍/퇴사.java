import java.io.*;
import java.util.*;

/**
 * 문제 : 실버 3 - 퇴사 (14501)
 * 메모리 : 14316 KB
 * 시간 : 132 ms
 * */
public class 퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        // 상담을 완료하는데 걸리는 기간과 받을 수 있는 금액 입력
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];

        for(int i=0; i<n; i++){
            // 퇴사 날짜가 넘어가지 않았으면
            if(i+arr[i][0] <= n){
                dp[i+arr[i][0]] = Math.max(dp[i+arr[i][0]], dp[i]+arr[i][1]);
            }

            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        bw.write(dp[n]+"");
        bw.flush();

        bw.close();
        br.close();
    }
}

