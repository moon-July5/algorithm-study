import java.io.*;

/**
 * 문제 : 실버 3 - 달팽이 (1913)
 * 메모리 : 61024 KB
 * 시간 : 644 ms
 * */
public class 달팽이 {
    private static int[] dy = {1, 0, -1, 0}; // 반시계 방향으로 이동할 수 있게끔
    private static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        // 홀수인 자연수
        int n = Integer.parseInt(br.readLine());
        // 위치를 찾고자 하는 자연수
        int search = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        arr[0][0] = n*n;

        // 시작 좌표
        int startX = 0, startY = 0;
        int idx = 0;

        // 2차원 배열에 반시계 방향으로 값 채우기
        while(true){
            int moveX = startX + dx[idx];
            int moveY = startY + dy[idx];

            // 범위 안에 있어야 하고, 값이 채워지지 않았다면
            if(moveX>=0 && moveY>=0 && moveX<n && moveY<n && arr[moveY][moveX]==0){
                // 이전 값에서 -1한 값을 저장
                arr[moveY][moveX] = arr[startY][startX] - 1;

                // 다음에 채울 좌표 값
                startX = moveX;
                startY = moveY;

                // 1이면 종료
                if(arr[moveY][moveX] == 1) break;

            } else {
                idx++;
            }

            if(idx>3)
                idx = 0;
        }

        int searchX = 0;
        int searchY = 0;

        // 출력
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                bw.write(arr[i][j]+" ");

                // 찾고자 하는 값을 찾았다면 위치 저장
                if(arr[i][j]==search){
                    searchX = j+1;
                    searchY = i+1;
                }
            }
            bw.write("\n");
        }

        bw.write(searchY+" "+searchX);

        bw.flush();

        bw.close();
        br.close();
    }
}
