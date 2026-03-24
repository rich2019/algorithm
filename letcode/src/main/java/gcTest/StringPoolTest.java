package gcTest;

public class StringPoolTest {
    public static void main(String[] args) {
        // 示例1：字面量创建 - 共享同一个对象
//        String s1 = "hello";      // 第一次创建，放入常量池
//        String s2 = "hello";      // 从常量池中获取，s1 == s2
//        System.out.println(s1 == s2);  // true，指向同一个对象

// 示例2：new创建 - 创建新对象
        String s3 = new String("hello");  // 在堆中创建新对象
        String s4 = new String("hello");  // 在堆中创建另一个新对象
        System.out.println(s3 == s4);     // false，不同对象
        System.out.println(s3.equals(s4)); // true，内容相同

// 示例3：intern()方法 - 放入或获取常量池引用
        String s5 = new String("world").intern();  // 放入常量池
        String s6 = "world";                       // 从常量池获取
        System.out.println(s5 == s6);              // true

        Integer i1 = Integer.valueOf(1);
        Integer i2 = Integer.valueOf(1);
        System.out.println(i1 == i2);
    }
}
