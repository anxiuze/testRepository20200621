package test0810;

import org.junit.Test;

/**
 * @author anxiuze
 * @date 2020/8/10 16:22
 * @Description: Lambda表达式练习
 *
 * 以下是lambda表达式的重要特征:
 *
 * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
 * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
 * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
 */
public class LambdaTest {

    public static void main(String[] args) {

        LambdaTest test = new LambdaTest();

        //声明类型
        MathOperation addition = (int a, int b) -> a + b;

        //不声明类型
        MathOperation subtraction = (a, b) -> a - b;

        //大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        //没有大括号及返回语句
        MathOperation division = (a, b) -> a / b;

        System.out.println("4 + 2 = " + test.operate(4, 2, addition));
        System.out.println("4 - 2 = " + test.operate(4, 2, subtraction));
        System.out.println("4 * 2 = " + test.operate(4, 2, multiplication));
        System.out.println("4 / 2 = " + test.operate(4, 2, division));

        //接受一个String 对象,并在控制台打印,不返回任何值(看起来像是返回void)
        GreetingService greetingService = (String s) -> System.out.println("拍了拍说：" + s);
        greetingService.sayMessage("hello");

        //不需要声明参数类型
        GreetingService greetingService2 = (s) -> System.out.println("拍了拍说：" + s);
        greetingService2.sayMessage("你好");

        //可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
        GreetingService greetingService3 = s -> System.out.println("拍了拍说：" + s);
        greetingService3.sayMessage("拜拜");

    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

}
