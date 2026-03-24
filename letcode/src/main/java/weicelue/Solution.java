package weicelue;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class Solution {


    // Complete the braces function below.
    static List<String> braces(List<String> values) {
        LinkedList<String> list = new LinkedList<>();
        values.forEach(s -> {
            if (isBraces(s)) {
                list.add("YES");
            } else {
                list.add("NO");
            }
        });
        return list;
    }

    private static boolean isBraces(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> characterMap = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (characterMap.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != characterMap.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int valuesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> values = new ArrayList<>();

        IntStream.range(0, valuesCount).forEach(i -> {
            try {
                values.add(bufferedReader.readLine());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<String> res = braces(values);

        bufferedWriter.write(
                res.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
