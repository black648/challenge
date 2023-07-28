package coding_test.programmers.lv1;

import java.util.Arrays;
public class 달리기경주{
    public static void main(String[] args) {
        달리기경주 main = new 달리기경주();
        Arrays.stream(main.solution(new String[] {"mumu", "soe", "poe", "kai", "mine"}, new String[] {"kai", "kai", "mine", "mine"})).forEach(System.out::print);
    }

    public String[] solution(String[] players, String[] callings) {

        if (callings.length >= 2 && callings.length <= 1000000 && players.length >=5 && players.length <=50000) {
            String temp = "";
            for (int i = 0; i < callings.length; i++) {
                for (int j = 0; j < players.length; j++) {
                    if (j > 0 && callings[i].equals(players[j])) {
                        temp = players[j - 1];
                        players[j - 1] = players[j];
                        players[j] = temp;
                    }
                }
            }
        }
        return players;
    }
}
