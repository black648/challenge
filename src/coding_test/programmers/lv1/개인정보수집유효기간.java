package coding_test.programmers.lv1;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 개인정보 파기대상을 출력
 */
public class 개인정보수집유효기간 {
    public static void main(String[] args) {
        개인정보수집유효기간 main = new 개인정보수집유효기간();
        // [1,3]
        Arrays.stream(main.solution("2022.05.19", new String[] {"A 6", "B 12", "C 3"}, new String[] {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})).forEach(System.out::print);
        // [1,4,5]
        Arrays.stream(main.solution("2020.01.01", new String[] {"Z 3", "D 5"}, new String[] {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"})).forEach(System.out::print);

    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        //  terms 별 타입, 기간
        Map<String, Integer> termMap = new HashMap<>();
        for(int i=0; i<terms.length; i++) {
            String[] term = terms[i].split(" ");
            termMap.put(term[0], Integer.parseInt(term[1]));
        }

        // 수집일, 타입
        for(int i=0; i<privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            Date toDay = parseDate(today);
            Date targetDay = parseDateAddMonth(privacy[0], (termMap.get(privacy[1])));
            if(toDay.equals(targetDay) || toDay.after(targetDay)) {
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static Date parseDate(String strDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        Date date = null;
        try {
            date = format.parse(strDate);;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    public static Date parseDateAddMonth(String date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(date));
        calendar.add(Calendar.MONTH, month);

        return calendar.getTime();
    }
}
