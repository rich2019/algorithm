package zhaoyin;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 统计字符串中相同字符出现的次数
 * 按照字母表顺序输出
 */
public class CountStr {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String str = in.next();

            System.out.println(count(str));
        }
    }

    private static String count(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        // map保存数据
        HashMap<Character, Integer> map = new HashMap<>();
        // list 保存顺序
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
                list.add(c);
            } else {
                map.put(c,map.get(c) + 1);
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c).append(map.get(c));
        }
        return sb.toString();
    }
}
