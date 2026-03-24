package gcTest;

import java.lang.reflect.Field;

public class StringPoolDemo {
    public static void main(String[] args) throws Exception {
        // 情况1：常量池中没有"hello"
        System.out.println("=== 情况1: 第一次创建 ===");
        String s1 = "hello";
        printStringInfo(s1, "s1");

        // 情况2：常量池中已有"hello"
        System.out.println("\n=== 情况2: 第二次创建 ===");
        String s2 = "hello";
        printStringInfo(s2, "s2");
        
        System.out.println("s1 == s2: " + (s1 == s2));  // true
        
        // 情况3：使用new创建
        System.out.println("\n=== 情况3: 使用new创建 ===");
        String s3 = new String("hello");
        printStringInfo(s3, "s3");
        
        System.out.println("s1 == s3: " + (s1 == s3));  // false
        
        // 使用intern
        System.out.println("\n=== 情况4: 使用intern ===");
        String s4 = s3.intern();
        printStringInfo(s4, "s4");
        System.out.println("s1 == s4: " + (s1 == s4));  // true

        System.out.println("s3.equals(s4) : " + s3.equals(s4));


    }
    private static void printStringInfo(String str, String name) throws Exception {
        // Java 9+ 中 String 内部使用 byte[] 而不是 char[]
        try {
            Field valueField = String.class.getDeclaredField("value");
            valueField.setAccessible(true);
            Object value = valueField.get(str);

            System.out.println(name + " 对象地址: " + System.identityHashCode(str));
            System.out.println(name + " 内容: " + str);
            System.out.println(name + " 内部数组类型: " + value.getClass().getSimpleName());
        } catch (java.lang.reflect.InaccessibleObjectException e) {
            // 如果反射失败，使用其他方式获取信息
            System.out.println(name + " 对象地址: " + System.identityHashCode(str));
            System.out.println(name + " 内容: " + str);
            System.out.println(name + " (无法通过反射访问内部数组)");
        }
    }

}