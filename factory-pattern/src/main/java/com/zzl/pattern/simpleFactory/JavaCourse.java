package com.zzl.pattern.simpleFactory;

public class JavaCourse implements ICourse {
    /**
     * 录制课程
     */
    @Override
    public void recordCourse() {
        System.out.println("录制Java视频");
    }
}
