package day13.offer58I_reverseWords;

import org.junit.Test;

import java.util.Stack;

public class MySolution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<String> stack = new Stack<>();

        int i = 0;
        while (i <s.length() - 1 &&  s.charAt(i) == ' ') i++;
        if (i == s.length()) return s;
        s = s + " ";
        while (i < s.length() - 1) {
            if (s.charAt(i) != ' ') {
                int j = i;
                while (s.charAt(i) != ' ') i++;
                stack.push(s.substring(j, i));
            } else {
                i++;
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
            if (!stack.isEmpty()) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    @Test
    public void test() {
        String s = "  hello world!  ";
        System.out.println(reverseWords(s));
    }
}
