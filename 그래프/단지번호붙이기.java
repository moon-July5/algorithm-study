import java.io.*;
import java.util.*;

/**
 * 문제 : 실버 1 - 단지번호붙이기 (2667)
 * 메모리 : 18388 KB
 * 시간 : 224 ms
 * */
public class 단지번호붙이기 {
    private static int n; // 지도의 크기
    private static int[][] arr;
    private static boolean[][] visited; // 방문 표시
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static int complex = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        // 입력
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(s.split("")[j]);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        // BFS 탐색
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                // 방문하지 않았고 집이 있는 곳이면
                if(!visited[i][j] && arr[i][j]==1){
                    list.add(bfs(i, j));
                    complex++;
                }
            }
        }

        // 총 단지 수 출력
        bw.write(complex+"\n");
        // 각 단지 내의 집의 수를 오름차순
        Collections.sort(list);
        // 각 단지 내의 집의 수 출력
        for(int count : list)
            bw.write(count+"\n");

        bw.flush();

        bw.close();
        br.close();
    }

    // BFS 탐색
    public static int bfs(int a, int b){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {a, b});

        visited[a][b] = true;

        int count = 1;

        while(!queue.isEmpty()){
            int[] location = queue.poll();

            for(int i=0; i<4; i++){
                int x = location[1] + dx[i];
                int y = location[0] + dy[i];

                // 주어진 범위 안에서만 이동 가능
                if(x>=0 && y>=0 && x<n && y<n){
                    // 방문하지 않았고 집이 있는 곳이면
                    if(!visited[y][x] && arr[y][x]==1){
                        count++;
                        visited[y][x] = true;
                        queue.add(new int[] {y, x});
                    }
                }
            }
        }

        return count;
    }


}

