package coding_test.programmers.lv2;

import java.util.HashSet;
import java.util.PriorityQueue;

public class 숫자변환하기 {
    public static void main(String[] args) {
        숫자변환하기 main = new 숫자변환하기();
        System.out.println(main.solution(10,	40,	5));
        System.out.println(main.solution(10,	40,	30));
        System.out.println(main.solution(2,	5,	4));
    }

    public int solution(int x, int y, int n) {
        int[] dis = {n, 2, 3};
        int answer = 0;

        HashSet<Integer> set = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(x);

        while (!queue.isEmpty()) {
            int length = queue.size();

            for(int i=0; i<length; i++) {
                int current = queue.poll();

                if(current == y) {
                    return answer;
                }

                for(int j=0; j<dis.length; j++) {
                    int result = j == 0 ? current + dis[j] : current * dis[j];

                    if(result == y) {
                        return ++answer;
                    } else if(!set.add(result)) {
                      continue;
                    } else if(result >= 1 && result <= 1000000 && result < y) {
                        set.add(result);
                        queue.offer(result);
                    }
                }
            }
            answer++;
        }
        return -1;
    }
}
