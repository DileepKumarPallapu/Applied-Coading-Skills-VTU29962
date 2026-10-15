import java.util.*;

public class ServerRequestValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{' || c == '<') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}' || c == '>') {
                if (stack.isEmpty()) {
                    System.out.println("INVALID");
                    return;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[')
                        || (c == '}' && top != '{') || (c == '>' && top != '<')) {
                    System.out.println("INVALID");
                    return;
                }
            }
        }
        System.out.println(stack.isEmpty() ? "VALID" : "INVALID");
    }
}
