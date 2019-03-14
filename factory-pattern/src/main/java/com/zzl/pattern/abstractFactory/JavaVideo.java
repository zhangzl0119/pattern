package com.zzl.pattern.abstractFactory;

public class JavaVideo implements IVideo {
    @Override
    public void recordCourse() {
        System.out.println("录制Java课程");
    }
}
