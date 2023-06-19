import java.io.*;
import java.util.*;

/**
 * 문제 : 실버 1 - 숨바꼭질 (1697)
 * 메모리 : 16376 KB
 * 시간 : 160 ms
 * */
public class 숨바꼭질 {
    private static int n, k;
    private static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        // 수빈이와 동생의 위치 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new int[100001];

        if(n==k) {
            bw.write(0 + "");
        }
        else {
            bfs();
            bw.write(visited[k]-1 + "");
        }
        bw.flush();

        bw.close();
        br.close();
    }

    public static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);

        visited[n] = 1;

        while (!queue.isEmpty()){
            int location = queue.poll();

            // 동생의 위치로 도착한다면
            if(location==k) return;

            // 1초 후에 x+1로 이동
            if(location+1 <= 100000 && visited[location+1]==0){
                queue.add(location+1);
                visited[location+1] = visited[location]+1;
            }
            // 1초 후에 x-1로 이동
            if(location-1 >= 0 && visited[location-1]==0){
                queue.add(location-1);
                visited[location-1] = visited[location]+1;
            }
            // 1초 후에 x*2로 이동
            if(location*2 <= 100000 && visited[location*2]==0){
                queue.add(location*2);
                visited[location*2] = visited[location]+1;
            }
        }
    }
}

