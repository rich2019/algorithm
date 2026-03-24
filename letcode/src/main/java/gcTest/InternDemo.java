package gcTest;

public class InternDemo {
    public static void main(String[] args) {
        // 情况1：常量池中没有"world"
        System.out.println("=== 情况1: 常量池中没有'world' ===");
        String s1 = new String("world");
        String s2 = s1.intern();
        System.out.println("s1 == s2: " + (s1 == s2));  // true，因为s1被放入常量池
        
        // 情况2：常量池中已有"world"
        System.out.println("\n=== 情况2: 常量池中已有'world' ===");
        String literal = "world";  // 先在常量池创建"world"
        System.out.println("literal == s2: " + (literal == s2));  // true，因为s1被放入常量池

        String s3 = new String("world");  // 创建新对象
        String s4 = s3.intern();  // 返回常量池中已有的引用
        System.out.println("s3 == s4: " + (s3 == s4));  // false
        System.out.println("literal == s4: " + (literal == s4));  // true
        
        // 情况3：使用字面量创建
        System.out.println("\n=== 情况3: 使用字面量创建 ===");
        String s5 = "hello";
        String s6 = "hello";
        System.out.println("s5 == s6: " + (s5 == s6));  // true，共享常量池
    }
}