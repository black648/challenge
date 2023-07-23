package coding_test.programmers.lv2;

import java.util.Arrays;

public class 뒤에있는큰수찾기 {
    public static void main(String[] args) {
        뒤에있는큰수찾기 main = new 뒤에있는큰수찾기();
        Arrays.stream(main.solution(new int[] {2, 3, 3, 5})).forEach(System.out::print);
        System.out.println("");
        Arrays.stream(main.solution(new int[] {9, 1, 5, 3, 6, 2})).forEach(System.out::print);
    }

    /**
     * {2, 3, 3, 5}          {3, 5, 5, -1}
     * {9, 1, 5, 3, 6, 2}    {-1, 5, 6, 6, -1, -1}
     */
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0 || numbers[i] < 1000000) {
                for (int j = i + 1; j <= numbers.length; j++) {
                    if (j == numbers.length) {
                        answer[i] = -1;
                        break;
                    } else if (numbers[i] == numbers[j] || numbers[i] > numbers[j]) {
                        continue;
                    } else {
                        answer[i] = numbers[j];
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
