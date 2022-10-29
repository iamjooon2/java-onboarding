package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char c : cryptogram.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stackToString(stack);
    }

    public static String stackToString (Stack<Character> stack){
        String answer = "";
        for (char c: stack){
            answer += c;
        }
        return answer;
    }
}
