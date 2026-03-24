package zhaoyin;

import java.util.Scanner;

/**
 * 一个字符串只包含*和a-z
 * 把*都放到左边,字母都放到右边
 */
public class SortCode {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String str = in.next();

            char c = '*';
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (c == str.charAt(i)) {
                    System.out.print("*");
                } else {
                    sb.append(str.charAt(i));
                }
            }
            System.out.println(sb);
        }
    }

}
