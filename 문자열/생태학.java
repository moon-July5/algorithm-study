import java.io.*;
import java.util.*;

/**
 * 문제 : 실버 2 - 생태학 (4358)
 * 메모리 : 122040 KB
 * 시간 : 840 ms
 * */
public class 생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        HashMap<String, Double> map = new HashMap<>();

        int count = 0;

        while(true){
            // 나무 종 이름 입력
            String tree = br.readLine();

            if(tree==null || tree.equals("")) break;

            // 나무 종 개수 세기
            map.put(tree, map.getOrDefault(tree, 0.0)+1);

            // 전체 개수
            count++;
        }

        // hashmap의 키 값을 list에 저장
        List<String> list = new ArrayList<>(map.keySet());
        // 오름차순으로 정렬
        Collections.sort(list);

        for(String s : list){
            bw.write(s + " "+String.format("%.4f", map.get(s)/count*100)+"\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}

