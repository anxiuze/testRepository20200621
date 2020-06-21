package test0609.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author anxiuze
 * @date 2020/6/9 16:01
 * @Description: 自定义注解测试
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface FirstAnnotation {
    /**
     * 姓名
     */
    String name();

    /**
     * 年龄
     */
    int age();

    /**
     * 成绩
     */
    int[] score();


}
