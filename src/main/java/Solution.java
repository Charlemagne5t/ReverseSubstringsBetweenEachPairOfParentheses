import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String reverseParentheses(String s) {
        Deque<Character> main = new ArrayDeque<>();
        Deque<Character> side = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                while (main.peek() != '(') {
                    side.offer(main.pop());
                }
                main.pop();
                while (!side.isEmpty()) {
                    main.push(side.poll());
                }

            } else main.push(s.charAt(i));
        }
        while (!main.isEmpty()) {
            sb.append(main.pop());
        }
        return sb.reverse().toString();

    }
}
