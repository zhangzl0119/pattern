package com.zzl.pattern.abstractFactory;

public class GoVideo implements IVideo {
    @Override
    public void recordCourse() {
        System.out.println("录制Go视频");
    }
}
