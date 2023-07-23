package coding_test.programmers.lv2;

import java.util.Arrays;

public class 요격시스템 {
    public static void main(String[] args) {
        요격시스템 main = new 요격시스템();
        System.out.println(main.solution(new int[][] {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}));
    }

    /**
     * 0 = {int[2]@694} [1, 4]
     *
     * 1 = {int[2]@695} [3, 7]
     * 2 = {int[2]@696} [4, 5]
     * 3 = {int[2]@697} [4, 8]
     *
     * 4 = {int[2]@698} [5, 12]
     * 5 = {int[2]@699} [10, 14]
     * 6 = {int[2]@700} [11, 13]
     */
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> a[0]-b[0]);
        int answer = 0;
        int boundary = -1;
        for(int[] target : targets) {
            if(boundary <= target[0]) {
                boundary = target[1];
                answer++;
            } else if(boundary > target[1]) {
                boundary = target[1];
            }
        }
        return answer;
    }
}
