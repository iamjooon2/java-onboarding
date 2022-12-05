package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (cryptogram.length() > 1000 || cryptogram.length() == 0) {
            return "글자 수가 맞지 않습니다";
        }
        Stack<Character> stack = new Stack<>();
        for (char c : cryptogram.toCharArray()) {
            stack = deleteRepetitiveChar(stack, c);
        }
        return stackToString(stack);
    }

    public static String stackToString(Stack<Character> stack) {
        String answer = "";
        for (char c : stack) {
            answer += c;
        }
        return answer;
    }

    public static Stack deleteRepetitiveChar(Stack<Character> stack, char c) {
        if (isCharRepeat(stack, c)) {
            return popStack(stack);
        }
        return pushCharToStack(stack, c);
    }

    private static boolean isCharRepeat(Stack stack, char c) {
        return isStackElementExists(stack) && isTopofStackEqualstoChar(stack, c);
    }

    public static Stack popStack(Stack stack) {
        stack.pop();
        return stack;
    }

    public static Stack pushCharToStack(Stack stack, char c) {
        stack.push(c);
        return stack;
    }

    private static boolean isStackElementExists(Stack stack) {
        return !stack.isEmpty();
    }

    private static boolean isTopofStackEqualstoChar(Stack<Character> stack, char c) {
        return stack.peek() == c;
    }

}
