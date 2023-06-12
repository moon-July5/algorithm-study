import java.io.*;
import java.util.*;

/**
 * 문제 : 실버 1 - 미로 탐색 (2178)
 * 메모리 : 102844 KB
 * 시간 : 688 ms
 * */
public class 미로 탐색 {
    private static int n, m; // 세로, 가로 길이
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        // 미로 입력
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(s.split("")[j]);
            }
        }

        // BFS 탐색 메서드 호출
        bfs();

        bw.write(arr[n-1][m-1]+"");
        bw.flush();

        bw.close();
        br.close();
    }

    // BFS 탐색
    public static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0}); // 좌표 저장

        while(!queue.isEmpty()){
            int[] location = queue.poll();

            if(location[0]==m-1 && location[1]==n-1)
                break;

            // 방향 탐색
            for(int i=0; i<4; i++){
                int y = location[0] + dy[i];
                int x = location[1] + dx[i];

                // 주어진 범위 안에서만 이동 가능
                if(x>=0 && y>=0 && x<m && y<n){
                    // 이동할 수 있는 칸이여야 함
                    if(arr[y][x]==1){
                        arr[y][x] = arr[location[0]][location[1]] + 1; // 이동하는 칸에 값 갱신
                        queue.add(new int[] {y, x}); // 좌표 저장
                    }
                }
            }
        }
    }
}

