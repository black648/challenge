package coding_test.programmers.lv2;


public class 시소짝궁 {
    public static void main(String[] args) {
        시소짝궁 main = new 시소짝궁();
        System.out.println(main.solution(new int[] {100,180,360,100,270}));
    }

    public long solution(int[] weights) {
        long answer = 0;
        for(int i = 0; i < weights.length; i++) {
            for(int j = i + 1; j < weights.length; j++) {
                if(checkEquals(weights[i], weights[j])) {
                    answer++;
                }
            }
        }
        return answer;
    }

    // 값 비교
    public static boolean checkEquals(int weight1, int weight2) {
        int[][] balances = new int[][] { {1,1}, {3,2}, {4,2}, {4,3} };

        for(int[] balance : balances) {
            if( (weight1 * balance[0]) == (weight2 * balance[1]) || (weight2 * balance[0]) == (weight1 * balance[1]) ) {
                return true;
            }
        }

        return false;
    }
}
