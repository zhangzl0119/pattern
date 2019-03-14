package com.zzl.pattern.test;

import com.zzl.pattern.abstractFactory.JavaCourseFactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        JavaCourseFactory factory = new JavaCourseFactory();

        factory.createNote().edit();

        factory.createVideo().recordCourse();
    }
}
