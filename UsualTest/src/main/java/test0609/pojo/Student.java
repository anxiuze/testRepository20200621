package test0609.pojo;

import test0609.annotation.FirstAnnotation;

/**
 * @author anxiuze
 * @date 2020/6/9 16:06
 * @Description:
 */

public class Student {
    @FirstAnnotation(name = "Tom", age = 18, score = {100})
    public void study(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("开始执行学习方法...");
        }
    }
}
