package coding_test.programmers.lv2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 호텔대실 {
    public static void main(String[] args) {
        호텔대실 main = new 호텔대실();

        System.out.println(main.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
        System.out.println(main.solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}}));
        System.out.println(main.solution(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}}));
    }


    /**
     * ["14:10", "19:20"]   14101920
     * ["14:20", "15:20"]   14201520
     * ["15:00", "17:00"]   15001700
     * ["16:40", "18:20"]   16401820
     * ["18:20", "21:20"]   18202120
     */

    /**
     * ["14:10", "19:20"]
     * ["14:20", "15:20"] ["16:40", "18:20"]
     * ["15:00", "17:00"] ["18:20", "21:20"]
     */

    /**
     * [850, 1170] -> add
     * [860, 930]  -> add
     * [900, 1030] -> add
     * [1000, 1110]
     * [1100, 1290]
     */
    public int solution(String[][] book_time) {
        //String to Integer
        int[][] bookTime = new int[book_time.length][];
        for(int i=0; i<book_time.length; i++) {
            bookTime[i] = new int[] { parseTime(book_time[i][0]), parseTime(book_time[i][1]) + 10};
        }

        //Start Time ASK
        Arrays.sort(bookTime, (a,b) -> a[0] - b[0]);

        //Room 저장
        PriorityQueue<int[]> useRoom = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(int i=0; i<book_time.length; i++) {
            while (!useRoom.isEmpty() && useRoom.peek()[1] <= bookTime[i][0]) {
                useRoom.poll();
            }
            useRoom.offer(bookTime[i]);
        }
        return useRoom.size();
    }

    public static int parseTime(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}
