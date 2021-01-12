import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        String s[] = {"10 18 23 33 (15) 29 45", "42 (5) 45 32 15 23 12", "19 6 12 16 35 34 (17)", "(15) 23 26 21 20 37 12", "15 20 39 9 (18) 5 12", "18 (20) 11 5 22 21 25", "42 44 23 8 5 22 (20)"};
        System.out.println(solution(s));
    }
    private static String solution(String[] lottos) {
        int[] nums = new int[46];
        int[] bonus = new int[46];
        setLottoCounts(lottos, nums, bonus);

        // 로또 번호
        List<LottoPair> lottoPairs = new ArrayList<>();
        addLottoPairs(lottoPairs, nums);
        sortLottoPairs(lottoPairs);
        List<Integer> resultList = new ArrayList<>();
        getResultLottoNumbers(lottoPairs, resultList); // 로또 번호 추출 완료

        // 보너스 번호
        List<LottoPair> bonusPairs = new ArrayList<>();
        addLottoPairs(bonusPairs, bonus);
        sortLottoPairs(bonusPairs);
        int bonusNumber = 0;
        for (LottoPair bonusPair : bonusPairs) {
            if (!resultList.contains(bonusPair.index)) {
                bonusNumber = bonusPair.index;
                break;
            }
        }
        resultList.add(bonusNumber);
        Collections.sort(resultList);
        String result = setResult(resultList, bonusNumber);
        return result.trim();
    }

    private static String setResult(List<Integer> resultList, int bonusNumber) {
        String result = "";
        for (Integer i : resultList) {
            if (i==bonusNumber) {
                result += "(" + i + ") ";
                continue;
            }
            result += i + " ";
        }
        return result;
    }

    private static void getResultLottoNumbers(List<LottoPair> lottoPairs, List<Integer> list) {
        for (int i = 0; i < 6; i++) {
            list.add(lottoPairs.get(i).index);
        }
    }

    private static void sortLottoPairs(List<LottoPair> lottoPairs) {
        lottoPairs.sort((o1, o2) -> {
            if (o2.num == o1.num) {
                return o1.index - o2.index;
            }
            return o2.num - o1.num;
        });
    }

    private static void addLottoPairs(List<LottoPair> lottoPairs, int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            lottoPairs.add(new LottoPair(i, arr[i]));
        }
    }

    private static void setLottoCounts(String[] lottos, int[] nums, int[] bonus) {
        for (String lotto : lottos) {
            String[] split = lotto.split(" ");
            for (String s : split) {
                try {
                    nums[Integer.parseInt(s)]++;
                } catch (Exception e) {
                    bonus[Integer.parseInt(s.replaceAll("[^0-9]", ""))]++;
                }
            }
        }
    }


    static class LottoPair {
        int index;
        int num;

        public LottoPair(int index, int num) {
            this.index = index;
            this.num = num;
        }

        @Override
        public String toString() {
            return "LottoPair{" + index + " : " + num + '}';
        }
    }
}
