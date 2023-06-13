import java.io.*;
import java.util.*;

/**
 * 문제 : 골드 5 - 토마토 (7576)
 * 메모리 : 103076 KB
 * 시간 : 700 ms
 * */
public class 토마토 {
    private static int n, m; // 상자의 크기
    private static int[][] arr;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static Queue<int[]> queue = new ArrayDeque<>();
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        // 상자의 가로, 세로 크기 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m][n];

        // 토마토들의 정보 입력 (1은 익은 토마토, 0은 익지 않은 토마토, -1은 토마토가 들어있지 않은 칸)
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 익은 토마토의 좌표를 먼저 저장
                if(arr[i][j]==1){
                    queue.add(new int[] {i, j});
                }
            }
        }

        bw.write(bfs()+"");
        bw.flush();

        bw.close();
        br.close();
    }

    public static int bfs() {
        while(!queue.isEmpty()){
            int[] location = queue.poll();

            for(int i=0; i<4; i++){
                int x = location[1] + dx[i];
                int y = location[0] + dy[i];

                // 주어진 범위 안에서만 이동 가능
                if(x>=0 && y>=0 && x<n && y<m){
                    // 익지 않은 토마토일 경우
                    if(arr[y][x]==0){
                        // 좌표 저장
                        queue.add(new int[] {y,x});
                        // 익지 않은 토마토들을 익은 토마토로 변경
                        arr[y][x] = arr[location[0]][location[1]] + 1;
                    }
                }
            }
            // 토마토가 모두 익을 때까지 걸리는 날짜 계산
            answer = Math.max(answer, arr[location[0]][location[1]]);
        }

        // 만약, 익지 않은 토마토가 존재하는 지 확인
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==0)
                    return -1;
            }
        }

        // 처음에 1부터 시작했기 때문에 -1을 해서 반환 
        return answer - 1;
    }
}

