package weicelue;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class OddNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        int r = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = Result.oddNumbers(l, r);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'oddNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER l
     *  2. INTEGER r
     */

    public static List<Integer> oddNumbers(int l, int r) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = l; i <= r; i++) {
            if (i % 2 != 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static String findNumber(List<Integer> arr, int k) {
        // Write your code here
        if (arr.contains(k)) {
            return "YES";
        }
        return "NO";
    }

}