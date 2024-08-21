package com.code;

import java.util.Objects;
import java.util.Scanner;

public class SolutionTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            solution(input);
        }
    }

    private static boolean breakCondition(String str) {
        if (Objects.equals(str, "")) {
            return true;
        } else if (str.length() < 3) {
            return true;
        } else if (str.length() == 3) {
            //三个一样，或者三个有不相同的
            char[] chars = str.toCharArray();
            return chars[0] != chars[1] || chars[0] != chars[2] || chars[1] != chars[2];
        }
        return false;
    }

    public static void solution(String input) {
        //直接遍历
        int length = input.length();
        if (breakCondition(input)) {
            if (input.equals("")) return;
            System.out.println("-> " + input);
            return;
        }

        for (int i = 0; i <= length - 3; i++) {
            if (input.charAt(i) == input.charAt(i + 1) && input.charAt(i + 1) == input.charAt(i + 2)) {
                //只是需要替换这个连续的字符，后面的单个字符不需要被替换
                //超过3个至于有很多个
                int j = i + 3;
                while (j <= input.length() - 1) {
                    if (input.charAt(i) == input.charAt(j)) {
                        j++;
                    } else {
                        break;
                    }
                }
                String consecutiveCh = input.substring(i, j);
                char ch = input.charAt(i);
                String rpl = ch == 'a' ? "" : String.valueOf((char) (ch - 1));
                input = input.substring(0, i) + rpl + input.substring(j);
                if (input.equals("") || input.length() == 1) {
                    break;
                }
                System.out.println("-> " + input + " ," + consecutiveCh + " is replaced by " + rpl);
                break;
            }
        }
        solution(input);
    }
}
