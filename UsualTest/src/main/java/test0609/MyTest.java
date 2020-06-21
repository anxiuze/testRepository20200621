package test0609;

import test0609.annotation.FirstAnnotation;
import test0609.pojo.Student;

import java.lang.reflect.Method;

/**
 * @author anxiuze
 * @date 2020/6/9 16:01
 * @Description:
 */
public class MyTest {

    public static void main(String[] args) {
        Class studentClass = Student.class;
        try {
            Method studyMethod = studentClass.getMethod("study", int.class);
            if (studyMethod.isAnnotationPresent(FirstAnnotation.class)) {
                System.out.println("当前方法上有@FirstAnnotation注解！");
                FirstAnnotation firstAnnotation = studyMethod.getAnnotation(FirstAnnotation.class);
                System.out.println("name is " + firstAnnotation.name() + "; age = " + firstAnnotation.age() + "; score is " + firstAnnotation.score()[0]);
            } else {
                System.out.println("当前方法上没有@FirstAnnotation注解");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
