package com.zzl.pattern.simpleFactory;
/**
 * Description: go课程
 * @author zzl
 */
public class GoCourse implements ICourse {
    /**
     * 录制课程
     */
    @Override
    public void recordCourse() {
        System.out.println("录制go课程！");
    }
}
