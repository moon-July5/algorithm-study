import java.io.*;
import java.util.*;

/**
 * 문제 : 실버 1 - 절댓값 힙 (11286)
 * 메모리 : 26164 KB
 * 시간 : 352 ms
 * */
public class 절댓값 힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        // 우선순위 큐 이용
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 가장 작은 절댓값이 여러 개 있을 수 있기 때문에 가장 작은 수를 출력하기 위해 오름차순으로 정렬
                if(Math.abs(o1)==Math.abs(o2)){
                    return o1-o2;
                }
                // 기본적으로는 절댓값이 가장 적은 순으로 정렬
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        // 연산의 개수
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int value = Integer.parseInt(br.readLine());

            // 값이 0이면
            if(value==0){
                // 우선순위 큐가 비어있지 않으면 값 출력
                if(!pq.isEmpty()) {
                    bw.write(pq.poll()+"\n");
                // 비어있으면 0 출력    
                } else {
                    bw.write(0+"\n");
                }
            } else {
                // 우선순위 큐에 값 추가
                pq.add(value);
            }
        }
        bw.flush();

        bw.close();
        br.close();
    }

}

